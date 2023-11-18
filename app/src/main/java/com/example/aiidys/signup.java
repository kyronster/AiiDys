package com.example.aiidys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class signup extends AppCompatActivity {

    EditText nameEditText, emailEditText, usernameEditText, passEditText, cpassEditText;
    Button button;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        nameEditText =(EditText)  findViewById(R.id.name);
        emailEditText =(EditText) findViewById(R.id.email);
        usernameEditText =(EditText) findViewById(R.id.username);
        passEditText =(EditText) findViewById(R.id.pass);
        cpassEditText =(EditText) findViewById(R.id.cpass);
        button = (Button) findViewById(R.id.button);
        DB = new DBHelper(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerNewUser();
            }

        });
    }
    private void registerNewUser() {
        final String name = nameEditText.getText().toString().trim();
        final String username = usernameEditText.getText().toString().trim();
        final String email = emailEditText.getText().toString().trim();
        final String pass = passEditText.getText().toString().trim();
        final String confirmPass = cpassEditText.getText().toString().trim();


        // Validate name
        if (name.isEmpty()) {
            nameEditText.setError("Please enter your name.");
            nameEditText.requestFocus();
            return;
        }

        // Validate phone number
        if (username.isEmpty()) {
            usernameEditText.setError("Please enter your username.");
            usernameEditText.requestFocus();
            return;
        }

        // Validate email
        if (email.isEmpty()) {
            emailEditText.setError("Please enter your email.");
            emailEditText.requestFocus();
            return;
        }
        if (!isValidEmail(email)) {
            emailEditText.setError("Please enter a valid email.");
            emailEditText.requestFocus();
            return;
        }

        // Validate password
        if (pass.isEmpty()) {
            passEditText.setError("Please enter a password.");
            passEditText.requestFocus();
            return;
        }



        if (!isValidPassword(pass)) {
            passEditText.setError("Password must contain at least one capital letter, one small letter, one number, and one symbol.");
            passEditText.requestFocus();
            return;
        }

        // Validate password confirmation
        if (confirmPass.isEmpty()) {
            cpassEditText.setError("Please retype your password.");
            cpassEditText.requestFocus();
            return;
        }
        if (!confirmPass.equals(pass)) {
            cpassEditText.setError("Passwords do not match.");
            cpassEditText.requestFocus();
            return;
        }

        Boolean checkuser = DB.checkusername(username);
        if (checkuser == false){
            Boolean insert = DB.insertData(username, pass);
            if(insert == true){
                Toast.makeText(signup.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(signup.this, "Registration Failed", Toast.LENGTH_SHORT).show();
            }




    }



    }
    private boolean isValidEmail(String email) {
        Pattern pattern = Pattern.compile("^\\w+[\\w-\\.]*\\@\\w+((-\\w+)|(\\w*))\\.[a-z]{2,3}$");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    // Method to validate password
    private boolean isValidPassword(String pass) {
        String pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$";
        return pass.matches(pattern);
    }
}