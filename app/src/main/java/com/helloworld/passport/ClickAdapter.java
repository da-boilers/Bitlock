package com.helloworld.passport;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;

public class ClickAdapter extends RecyclerView.Adapter<ClickAdapter.ClickViewHolder> {

    public class ClickViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView text1, text2;

        ClickViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            text1 = (TextView) itemView.findViewById(android.R.id.text1);
            text2 = (TextView) itemView.findViewById(android.R.id.text2);
        }

        @Override
        public void onClick(View v) {
            if (mOnEntryClickListener != null) {
                mOnEntryClickListener.onEntryClick(v, getLayoutPosition());
            }
        }

    }

    private ArrayList<HashMap<String, String>> mVids = new ArrayList<>();

    public ClickAdapter(ArrayList<HashMap<String, String>> vids) {
        this.mVids.addAll(vids);
    }

    @Override
    public int getItemCount() {
        return mVids.size();
    }

    @Override
    public ClickViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_2, parent, false);
        return new ClickViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ClickViewHolder holder, int position) {
        HashMap hm = mVids.get(position);

        String firsttext = new String(hm.get("IDTYPE").toString());
        String secondtext = new String(hm.get("Name").toString());

        holder.text1.setText(firsttext);
        holder.text2.setText(secondtext);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }


    private OnEntryClickListener mOnEntryClickListener;

    public interface OnEntryClickListener {
        void onEntryClick(View view, int position);
    }

    public void setOnEntryClickListener(OnEntryClickListener onEntryClickListener) {
        mOnEntryClickListener = onEntryClickListener;
    }

}
