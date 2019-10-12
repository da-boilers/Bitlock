package com.helloworld.passport;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.helloworld.passport.UserMGT.*;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class LoginActivity extends AppCompatActivity {
    private EditText userName;
    private EditText userPassword;
    private Button loginBtn;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ActivityCompat.requestPermissions(LoginActivity.this,
                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE},
                0);


        userName = (EditText) findViewById(R.id.usernameTxt);
        userPassword = (EditText) findViewById(R.id.passwordTxt);
        loginBtn = (Button) findViewById(R.id.loginBtn);
        //user = new User();
        //user.writeInfo();

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 if(true){//user.checkInfo(userName.getText().toString(), userPassword.getText().toString(), LoginActivity.this)) {
                   Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                 } else {
                    Log.e("LoginActivity","Failed to sign in");
                 }

            }
        });
    }
}
