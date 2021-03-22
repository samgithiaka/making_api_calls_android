package com.tuk.apps.repository;

import com.tuk.apps.models.VehicleMakesResponseModel;
import com.tuk.apps.webservice.IExecute;
import com.tuk.apps.webservice.IVehicleWebservice;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class VehicleRepository {
    private IVehicleWebservice webservice;
    private String BASE_URL = "https://test.hillcroftinsurance.com";

    public VehicleRepository() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        this.webservice = retrofit.create(IVehicleWebservice.class);
    }

    public void getVehicleMakes(IExecute<VehicleMakesResponseModel> callback) {
        this.webservice.getVehicleMakes().enqueue(new Callback<VehicleMakesResponseModel>() {
            @Override
            public void onResponse(Call<VehicleMakesResponseModel> call, Response<VehicleMakesResponseModel> response) {
                callback.run(response ,null);
            }

            @Override
            public void onFailure(Call<VehicleMakesResponseModel> call, Throwable t) {
                callback.run(null,t);
            }
        });
    }
}
