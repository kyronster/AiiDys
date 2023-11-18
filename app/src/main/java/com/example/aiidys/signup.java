package com.example.aiidys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class signup extends AppCompatActivity {

    EditText nameEditText, emailEditText, numberEditText, passEditText, cpassEditText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        nameEditText =(EditText)  findViewById(R.id.name);
        emailEditText =(EditText) findViewById(R.id.email);
        numberEditText =(EditText) findViewById(R.id.number);
        passEditText =(EditText) findViewById(R.id.pass);
        cpassEditText =(EditText) findViewById(R.id.cpass);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerNewUser();
            }
        });
    }
    private void registerNewUser() {
        final String name = nameEditText.getText().toString().trim();
        final String phone = numberEditText.getText().toString().trim();
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
        if (phone.isEmpty()) {
            numberEditText.setError("Please enter your phone number.");
            numberEditText.requestFocus();
            return;
        }
        if (phone.length() != 10) {
            numberEditText.setError("Please enter a valid phone number.");
            numberEditText.requestFocus();
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