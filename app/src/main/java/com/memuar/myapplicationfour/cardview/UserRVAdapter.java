package com.memuar.myapplicationfour.cardview;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.memuar.myapplicationfour.R;

import java.util.ArrayList;

public class UserRVAdapter extends RecyclerView.Adapter<UserRVAdapter.ViewHolder> {

    // variable for our array list and context.
    private ArrayList<UserModal> userModalArrayList;
    private Context context;

    // creating a constructor.
    public UserRVAdapter(ArrayList<UserModal> userModalArrayList, Context context) {
        this.userModalArrayList = userModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // inflating our layout file on below line.
        View view = LayoutInflater.from(context).inflate(R.layout.user_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        // getting data from our array list in our modal class.
        UserModal userModal = userModalArrayList.get(position);

        // on the below line we are setting data to our text view.
        holder.subNameTV.setText(userModal.getSub_name());
        holder.profNameTV.setText(userModal.getProf_name());
        holder.cabinetTV.setText(userModal.getCabinet());
        holder.timeTv.setText(userModal.getTime());


    }

    @Override
    public int getItemCount() {
        // returning the size of array list.
        return userModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // creating a variable for our text view and image view.
        private TextView subNameTV, profNameTV, cabinetTV, timeTv;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // initializing our variables.
            subNameTV = itemView.findViewById(R.id.text_view_result);
            profNameTV = itemView.findViewById(R.id.text_view_result2);
            cabinetTV = itemView.findViewById(R.id.text_view_result3);
            timeTv = itemView.findViewById(R.id.text_view_result4);
        }
    }
}
