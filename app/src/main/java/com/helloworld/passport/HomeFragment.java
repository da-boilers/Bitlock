package com.helloworld.passport;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;


public class HomeFragment extends Fragment {
    public ArrayList<HashMap<String, String>> Vids;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_home, container, false);


        RecyclerView rvVids = (RecyclerView) rootView.findViewById(R.id.rvVids);

        rvVids.setLayoutManager(new LinearLayoutManager(getActivity()));

        Vids = Credentials.createCredentialList(15);

        final CredAdapter adapter = new CredAdapter(Vids);
        rvVids.setAdapter(adapter);

        ClickAdapter clickAdapter = new ClickAdapter(Vids);
        clickAdapter.setOnEntryClickListener(new ClickAdapter.OnEntryClickListener() {
            @Override
            public void onEntryClick(View view, int position) {
                HashMap hash = adapter.getCred(position);

                onButtonShowPopupWindowClick(view, hash);
            }
        });
        rvVids.setAdapter(clickAdapter);

        return rootView;
    }

    public void onButtonShowPopupWindowClick(View view, HashMap hashMap) {


        String toDisplay = hashMap.get("IDTYPE").toString() + "\n" + hashMap.get("Name").toString() + "\n" + hashMap.get("CPM").toString() + "\n" + hashMap.get("Membership").toString();
        // inflate the layout of the popup window
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        View popupView = inflater.inflate(R.layout.popup_window, null);

        boolean focusable = true; // lets taps outside the popup also dismiss it
        final PopupWindow popupWindow = new PopupWindow(popupView, 820, 1200, focusable);

        popupView.setBackground(new ColorDrawable(Color.GRAY));

        TextView textout = popupView.findViewById(R.id.textout);

        textout.setText(toDisplay);

        // show the popup window
        // which view you pass in doesn't matter, it is only used for the window tolken
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

        // dismiss the popup window when touched
        popupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                return true;
            }
        });
    }

}
