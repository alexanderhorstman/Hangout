package com.example.alexh.hangout;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Set;

public class CreateProfile extends Activity{

    private ArrayList<Profile> users = new ArrayList<>();
    private ObjectInputStream usersInput = null;
    private ObjectOutputStream usersOutput = null;
    private String usersFileName = "users.txt";
    private ViewHolder holder;

    @Override
    public void onBackPressed() {
        //set result code to canceled
        setResult(RESULT_CANCELED);
        //leave this activity
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_profile);
        holder = new ViewHolder();
    }

    private boolean checkEmailAvailability(String email) {
        //load the users from file
        //create new file if none exists
        try {
            usersInput = new ObjectInputStream(openFileInput(usersFileName));
            users = (ArrayList) usersInput.readObject();
            usersInput.close();
        }
        catch(FileNotFoundException e) {
            //create new file
            File usersFile = new File(this.getFilesDir().getAbsolutePath(), usersFileName);
            //try to create a new file, quit if system cannot create new file
            try {
                usersFile.createNewFile();
            }
            catch(Exception f) {
                Toast.makeText(this, "The list file could not be created. Shutting down.",
                        Toast.LENGTH_LONG).show();
                try {
                    wait(2000);
                }
                catch(Exception g) {
                    g.printStackTrace();
                }
                finish();
            }
            return true;
        }
        catch(Exception f) {
        }
        //check each user in the list
        if(users.size() > 0) {
            for (int i = 0; i < users.size(); i++) {
                //if emails match, then email is not available
                if (users.get(i).getEmailAddress().equals(email)) {
                    return false;
                }
            }
        }
        return true;
    }

    //return to sign in activity
    public void returnToMainActivityWithCancel(View view) {
        //set result code to canceled
        setResult(RESULT_CANCELED);
        //leave this activity
        finish();
    }

    //save profile info
    //move to create schedule activity
    public void moveToCreateSchedule(View view) {
        //check to make sure the email is not taken
        if(holder.firstNameEditText.getText().toString().equals("")) {
            Toast.makeText(this, "First name cannot be blank", Toast.LENGTH_LONG).show();
        }
        else if(holder.lastNameEditText.getText().toString().equals("")) {
            Toast.makeText(this, "Last name cannot be blank", Toast.LENGTH_LONG).show();
        }
        else if(holder.emailEditText.getText().toString().equals("")) {
            Toast.makeText(this, "Email address cannot be blank", Toast.LENGTH_LONG).show();
        }
        else if(!checkEmailAvailability(holder.emailEditText.getText().toString())) {
            Toast.makeText(this, "Email address has already been used. Please use a different "
                    + "email.", Toast.LENGTH_LONG).show();
        }
        else if(holder.passwordEditText.getText().toString().equals("")) {
            Toast.makeText(this, "Password cannot be blank", Toast.LENGTH_LONG).show();
        }
        else if(!(holder.passwordEditText.getText().toString().
                equals(holder.confirmPasswordEditText.getText().toString()))) {
            Toast.makeText(this, "Passwords do not match", Toast.LENGTH_LONG).show();
        }
        else {
            String email = holder.emailEditText.getText().toString();
            String firstName = holder.firstNameEditText.getText().toString();
            String lastName = holder.lastNameEditText.getText().toString();
            String password = holder.passwordEditText.getText().toString();
            Profile newProfile = new Profile(email, firstName, lastName, password);
            Intent createSchedule = new Intent(this, CreateSchedule.class);
            createSchedule.putExtra("profileInProgress", newProfile);
            startActivity(createSchedule);
        }
    }

    public class ViewHolder {
        private EditText firstNameEditText = (EditText) findViewById(R.id.first_name_edit_text_create_profile);
        private EditText lastNameEditText = (EditText) findViewById(R.id.last_name_edit_text_create_profile);
        private EditText emailEditText = (EditText) findViewById(R.id.email_edit_text_create_profile);
        private EditText passwordEditText = (EditText) findViewById(R.id.password_edit_text_create_profile);
        private EditText confirmPasswordEditText = (EditText) findViewById(R.id.confirm_password_edit_text_create_profile);
    }
}

