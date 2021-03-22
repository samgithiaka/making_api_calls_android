package com.tuk.apps.webservice;

import com.tuk.apps.models.VehicleMakesResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IVehicleWebservice {
    @GET("/motor/vehicle/makes")
    Call<VehicleMakesResponseModel> getVehicleMakes();
}
