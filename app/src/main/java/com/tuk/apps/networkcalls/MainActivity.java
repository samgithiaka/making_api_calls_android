package com.tuk.apps.networkcalls;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;
import com.tuk.apps.adapters.VehicleMakesAdapter;
import com.tuk.apps.models.Payload;
import com.tuk.apps.models.VehicleMakesResponseModel;
import com.tuk.apps.repository.VehicleRepository;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView make;
    RecyclerView recyclerView;
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        make = findViewById(R.id.make);
        recyclerView = findViewById(R.id.recycler);
        getVehicleMakes();
    }

    private void getVehicleMakes() {
        VehicleRepository vehicleRepository = new VehicleRepository();
        vehicleRepository.getVehicleMakes((result, t) -> {
            Log.e(TAG, "getVehicleMakes: makes :" + new Gson().toJson(result.body()) );
            VehicleMakesResponseModel vehicleMakesResponseModel = result.body();
            if (vehicleMakesResponseModel != null) {
                List<Payload> payloadList = vehicleMakesResponseModel.getPayload();
                //make.setText(payloadList.get(4).getMake());
                setUpRecycler(payloadList);
            }
        });
    }

    private void setUpRecycler(List<Payload> payloadList) {
        VehicleMakesAdapter vehicleMakesAdapter = new VehicleMakesAdapter(payloadList);
        recyclerView.setAdapter(vehicleMakesAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(
                this,LinearLayoutManager.VERTICAL ,false);
        recyclerView.setLayoutManager(linearLayoutManager);
    }
}