package com.helloworld.passport;

import android.os.Bundle;
import android.view.View;

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

        ClickAdapter clickAdapter = new ClickAdapter(Vids);
        clickAdapter.setOnEntryClickListener(new ClickAdapter.OnEntryClickListener() {
            @Override
            public void onEntryClick(View view, int position) {

            }
        });
        rvVids.setAdapter(clickAdapter);
    }

}