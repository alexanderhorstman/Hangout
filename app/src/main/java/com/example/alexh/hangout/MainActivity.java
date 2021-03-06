package com.example.alexh.hangout;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class MainActivity extends Activity {

    ViewHolder holder;
    String usersFileName = "users.txt";

    public void createNewAccount(View view) {
        holder = new ViewHolder();
        Button createNewAccountButton = (Button) findViewById(R.id.create_new_account_button);
        createNewAccountButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                //instantiates an alert for the user to add a new task
                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                //sets the title of the alert
                alert.setTitle("Do you want to clear all saved profiles?");
                //set the click behavior for the positive button click
                alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ArrayList<Profile> emptyList = new ArrayList<Profile>();
                        String usersFileName = "users.txt";
                        ObjectOutputStream usersOutput;
                        try {
                            usersOutput = new ObjectOutputStream(openFileOutput(usersFileName, Context.MODE_PRIVATE));
                            usersOutput.writeObject(emptyList);
                        }
                        catch(Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                //set the click behavior for the negative button click
                alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //do nothing here
                    }
                });
                //show the alert
                alert.show();
                return false;
            }
        });
        Intent createProfile = new Intent(this, CreateProfile.class);
        final int result = 1;
        startActivityForResult(createProfile, result);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void signInAttempt(View view) {
        ArrayList<Profile> users = new ArrayList<>();
        boolean success = false;
        try {
            ObjectInputStream objectInputStream =
                    new ObjectInputStream(openFileInput(usersFileName));
            users = (ArrayList) objectInputStream.readObject();
            objectInputStream.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        int index = 0;
        while(index < users.size() && !success) {
            Profile profile = users.get(index);
            if(profile.getEmailAddress().equals(holder.emailAddressEditText.getText().toString())) {
                if(profile.getPassword().equals(holder.passwordEditText.getText().toString())) {
                    success = true;
                }
                else {
                    success = false;
                }
            }
            else {
                success = false;
            }
            index++;
        }
        if(success) {

        }
        else {
            Toast.makeText(this, "Email or password is incorrect. Try again.", Toast.LENGTH_SHORT).show();
        }
        Toast.makeText(this, "Sign in", Toast.LENGTH_SHORT).show();
    }

    private class ViewHolder {
        EditText emailAddressEditText = (EditText) findViewById(R.id.email_edit_text_sign_in);
        EditText passwordEditText = (EditText) findViewById(R.id.password_edit_text_sign_in);
    }
}
