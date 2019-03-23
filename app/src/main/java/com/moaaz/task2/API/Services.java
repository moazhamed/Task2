package com.moaaz.task2.API;

import com.moaaz.task2.API.Model.CitiesResponse;
import com.moaaz.task2.API.Model.CountriesResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Services {

    @GET("GetCountries ")
    Call<List<CountriesResponse>> getCountries();

    @GET("GetCities")
    Call<List<CitiesResponse>> getCities(@Query("countryId") int countryId);

}
