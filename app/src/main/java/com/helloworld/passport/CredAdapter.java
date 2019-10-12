package com.helloworld.passport;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;


public class CredAdapter extends
        RecyclerView.Adapter<CredAdapter.ViewHolder> {


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView text1, text2;

        public ViewHolder(View itemView) {
            super(itemView);

            text1 = (TextView) itemView.findViewById(android.R.id.text1);
            text2 = (TextView) itemView.findViewById(android.R.id.text2);
        }
    }

    public ArrayList<HashMap<String, String>> mVids = new ArrayList<>();

    public CredAdapter(ArrayList<HashMap<String, String>> vids)
    {
        this.mVids.addAll(vids);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(android.R.layout.simple_list_item_2, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override

    public void onBindViewHolder(ViewHolder holder, int position) {

//        Log.d("view",holder.text1.toString());
//        Log.d("view",holder.text2.toString());

        HashMap hm = mVids.get(position);

        String firsttext = new String(hm.get("IDTYPE").toString());
        String secondtext = new String(hm.get("Name").toString());

        holder.text1.setText(firsttext);
        holder.text2.setText(secondtext);
    }

    @Override
    public int getItemCount() {
        return mVids.size();
    }
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}