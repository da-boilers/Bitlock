package com.helloworld.passport;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.HashMap;

import static com.helloworld.passport.R.id;
import static com.helloworld.passport.R.layout;

public class MainActivity extends AppCompatActivity {


    public ArrayList<HashMap<String, String>> Vids;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(layout.activity_main);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

//        RecyclerView rvVids = findViewById(id.rvVids);
//
//        rvVids.setLayoutManager(new LinearLayoutManager(this));
//
//        Vids = Credentials.createCredentialList(15);
//
//        final CredAdapter adapter = new CredAdapter(Vids);
//        rvVids.setAdapter(adapter);
//
//        ClickAdapter clickAdapter = new ClickAdapter(Vids);
//        clickAdapter.setOnEntryClickListener(new ClickAdapter.OnEntryClickListener() {
//            @Override
//            public void onEntryClick(View view, int position) {
//                HashMap hash = adapter.getCred(position);
//
//                onButtonShowPopupWindowClick(view, hash);
//            }
//        });
//        rvVids.setAdapter(clickAdapter);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new HomeFragment()).commit();
    }


    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;
                    switch (menuItem.getItemId()) {
                        case R.id.nav_home:
                            selectedFragment = new HomeFragment();
                            break;
                        case id.nav_verify:
                            selectedFragment = new VerifyFragment();
                            break;
                        case id.nav_add:
                            selectedFragment = new AddFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();

                    return true;
                }
            };

//    public void onButtonShowPopupWindowClick(View view, HashMap hashMap) {
//
//
////        String toDisplay = hashMap.get("IDTYPE").toString() + "\n" + hashMap.get("Name").toString() + "\n" + hashMap.get("CPM").toString() + "\n" + hashMap.get("Membership").toString();
////        // inflate the layout of the popup window
////        LayoutInflater inflater = (LayoutInflater)
////                getSystemService(LAYOUT_INFLATER_SERVICE);
////        View popupView = inflater.inflate(layout.popup_window, null);
////
////        boolean focusable = true; // lets taps outside the popup also dismiss it
////        final PopupWindow popupWindow = new PopupWindow(popupView, 820, 1200, focusable);
////
////        popupView.setBackground(new ColorDrawable(Color.GRAY));
////
////        TextView textout = popupView.findViewById(R.id.textout);
////
////        textout.setText(toDisplay);
////
////        // show the popup window
////        // which view you pass in doesn't matter, it is only used for the window tolken
////        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);
////
////        // dismiss the popup window when touched
////        popupView.setOnTouchListener(new View.OnTouchListener() {
////            @Override
////            public boolean onTouch(View v, MotionEvent event) {
////                popupWindow.dismiss();
////                return true;
////            }
////        });
//    }


}