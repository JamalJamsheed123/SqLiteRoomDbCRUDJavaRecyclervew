package com.example.androidsampleapp.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidsampleapp.EntityClass.PurchaseModel;
import com.example.androidsampleapp.Features.UpdateDataActivity;
import com.example.androidsampleapp.R;

import java.util.ArrayList;
import java.util.List;

public class PurchaseAdapter extends RecyclerView.Adapter<PurchaseAdapter.ViewHolder> {
    Context context;
    List< PurchaseModel > list;
    DeleteItemClicklistner deleteItemClicklistner;

    public PurchaseAdapter(Context context, List<PurchaseModel> list, DeleteItemClicklistner deleteItemClicklistner) {
        this.context = context;
        this.list = list;
        this.deleteItemClicklistner = deleteItemClicklistner;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setFilteredList(List<PurchaseModel> filteredList){
        this.list = filteredList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") final int position) {

        holder.customerName.setText(list.get(position).getCustomerName());
        holder.productName.setText(list.get(position).getProductName());
        holder.Quantity.setText(list.get(position).getQuantity());
        holder.purchaseDate.setText(list.get(position).getPurchaseDate());
        holder.contactNumber.setText(list.get(position).getContactNumber());
        holder.outletLocation.setText(list.get(position).getOutletLocation());

        holder.update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, UpdateDataActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("id", String.valueOf(list.get(position).getId()));
                intent.putExtra("customerName", String.valueOf(list.get(position).getCustomerName()));
                intent.putExtra("productName", String.valueOf(list.get(position).getProductName()));
                intent.putExtra("quantity", String.valueOf(list.get(position).getQuantity()));
                intent.putExtra("purchaseDate", String.valueOf(list.get(position).getPurchaseDate()));
                intent.putExtra("contactNumber", String.valueOf(list.get(position).getContactNumber()));
                intent.putExtra("outletLocation", String.valueOf(list.get(position).getOutletLocation()));
                context.startActivity(intent);

            }
        });
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteItemClicklistner.onItemDelete(position, list.get(position).getId());

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView customerName, productName, Quantity, purchaseDate, contactNumber, outletLocation;
        Button update, delete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            customerName = itemView.findViewById(R.id.customerName);
            productName = itemView.findViewById(R.id.productName);
            Quantity = itemView.findViewById(R.id.Quantity);
            purchaseDate = itemView.findViewById(R.id.purchaseDate);
            contactNumber = itemView.findViewById(R.id.contactNumber);
            outletLocation = itemView.findViewById(R.id.outletLocation);
            update = itemView.findViewById(R.id.updateId);
            delete = itemView.findViewById(R.id.deleteId);
        }
    }

    public interface DeleteItemClicklistner {
        void onItemDelete(int position, int id);
    }
}
