package com.example.androidsampleapp.APIAdapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.androidsampleapp.APIModel.UserModel;
import com.example.androidsampleapp.R;

import java.util.List;

public class UserAdapter extends ArrayAdapter<UserModel> {

    private final List<UserModel> allUserList;
    private final Context context;


    public UserAdapter(List<UserModel> userModels, Context context){
        super(context, R.layout.item_users, userModels);
        this.allUserList = userModels;
        this.context = context;

    }


    @SuppressLint("ViewHolder")
    @NonNull
    @Override
    public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent){
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        convertView = layoutInflater.inflate(R.layout.item_users, parent,false);

        UserModel userModel = allUserList.get(position);
        TextView textViewUserId = (TextView) convertView.findViewById(R.id.userId);
        textViewUserId.setText(userModel.getUserId());
        TextView textViewId = (TextView) convertView.findViewById(R.id.id);
        textViewId.setText(userModel.getId());
        TextView textViewTitle = (TextView) convertView.findViewById(R.id.title);
        textViewTitle.setText(userModel.getTitle());
        TextView textViewBody = (TextView) convertView.findViewById(R.id.body);
        textViewBody.setText(userModel.getBody());

        return convertView;
    }
}
