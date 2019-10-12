package com.helloworld.passport;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;
import java.io.OutputStreamWriter;

public class LoginActivity extends AppCompatActivity {
    private EditText userName;
    private EditText userPassword;
    private Button loginBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userName = (EditText) findViewById(R.id.usernameTxt);
        userPassword = (EditText) findViewById(R.id.passwordTxt);
        loginBtn = (Button) findViewById(R.id.loginBtn);

        //writeCredentials(userName, userPassword);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                 if(checkCredentials(userName, userPassword)) {
                   Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                 } else {
                    //Report error
                 }
                */
            }
        });
    }
}
