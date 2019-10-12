package com.helloworld.passport;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    public ArrayList<HashMap<String, String>> Vids;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rvVids = findViewById(R.id.rvVids);

        rvVids.setLayoutManager(new LinearLayoutManager(this));

        Vids = Credentials.createCredentialList(15);

        CredAdapter adapter = new CredAdapter(Vids);
        rvVids.setAdapter(adapter);


    }

}