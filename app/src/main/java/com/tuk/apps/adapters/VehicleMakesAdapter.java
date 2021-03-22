package com.tuk.apps.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tuk.apps.models.Payload;
import com.tuk.apps.networkcalls.R;

import java.util.List;

public class VehicleMakesAdapter extends RecyclerView.Adapter<VehicleMakesAdapter.VehicleMakesViewHolder> {
    public List<Payload> vehicleMakesList;
    public VehicleMakesAdapter (List<Payload> vehicleMakes) {
        this.vehicleMakesList = vehicleMakes;
    }

    @NonNull
    @Override
    public VehicleMakesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.vehicle_makes_list, parent, false);
        return new VehicleMakesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VehicleMakesViewHolder holder, int position) {
        Payload current = vehicleMakesList.get(position);
        holder.make.setText(current.getMake());
             
    }

    @Override
    public int getItemCount() {
        return vehicleMakesList.size();
    }

    class VehicleMakesViewHolder extends RecyclerView.ViewHolder {
        TextView make;
        public VehicleMakesViewHolder(@NonNull View itemView) {
            super(itemView);
            make = itemView.findViewById(R.id.make);
        }
    }
}
