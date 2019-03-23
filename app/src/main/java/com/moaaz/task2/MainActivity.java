package com.moaaz.task2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.moaaz.task2.API.ApiManager;
import com.moaaz.task2.API.Model.CitiesResponse;
import com.moaaz.task2.API.Model.CountriesResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends BaseActivity {
    protected Spinner codeSpinner;
    protected Spinner countrySpinner;
    protected Spinner citySpinner;
    protected TextView terms;
    //CustomSpinnerAdapter spinnerAdapter;
    protected Button changeLanguage;
    //String[] arrayForSpinner = {"One", "Two", "Three"};
    int countryId;
    List<CountriesResponse> countriesList = new ArrayList<>();
    ArrayList<String> countriesNames = new ArrayList<>();

    List<CitiesResponse> citiesList = new ArrayList<>();
    ArrayList<String> citiesNames = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_main);
        initView();
        //  spinnerAdapter = new CustomSpinnerAdapter(MainActivity.this,R.id.city_spinner ,arrayForSpinner , "City");
        getCountriesResponse();
        terms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WebActivity.class);
                startActivity(intent);
           }
        });

        changeLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (LANG_CURRENT.equals("en")) {
                    changeLang(MainActivity.this, "ar");

                } else {
                    changeLang(MainActivity.this, "en");
                }
                finish();
                startActivity(new Intent(MainActivity.this, MainActivity.class));
            }
        });


    }

    public void changeLang(Context context, String lang) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("Language", lang);
        editor.apply();
    }


    public void getCountriesResponse() {

        ApiManager
                .getAPIs()
                .getCountries()
                .enqueue(new Callback<List<CountriesResponse>>() {
                    @Override
                    public void onResponse(Call<List<CountriesResponse>> call,
                                           Response<List<CountriesResponse>> response) {

                        countriesList = response.body();
                        for (int i = 0; i < countriesList.size(); i++) {
                            if(LANG_CURRENT.equals("en"))
                                countriesNames.add(countriesList.get(i).getTitleEN());
                            else
                                countriesNames.add(countriesList.get(i).getTitleAR());
                        }
                        Spinner spinner = findViewById(R.id.country_spinner);
                        ArrayAdapter<String> adapter =
                                new ArrayAdapter<>(MainActivity.this,
                                        android.R.layout.simple_spinner_item, countriesNames);
                        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        //spinner.setPrompt("country");
                        spinner.setAdapter(adapter);
                        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                countryId = countriesList.get(position).getId();
                                Log.e("country id ", "this is id " + countryId);
                                getCitiesResponse(countryId);

                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {

                            }
                        });
                    }

                    @Override
                    public void onFailure(Call<List<CountriesResponse>> call, Throwable t) {

                    }
                });

    }




    public void getCitiesResponse(int Id) {
        ApiManager
                .getAPIs()
                .getCities(Id)
                .enqueue(new Callback<List<CitiesResponse>>() {
                    @Override
                    public void onResponse(Call<List<CitiesResponse>> call,
                                           Response<List<CitiesResponse>> response) {
                        citiesNames.clear();
                        citiesList = response.body();
                        for (int j = 0; j < citiesList.size(); j++) {
                            if(LANG_CURRENT.equals("en"))
                                citiesNames.add(citiesList.get(j).getTitleEN());
                            else
                                citiesNames.add(citiesList.get(j).getTitleAR());

                        }
                        Spinner citySpinner = findViewById(R.id.city_spinner);
                        ArrayAdapter<String> adapter2 =
                                new ArrayAdapter<>(MainActivity.this,
                                        android.R.layout.simple_spinner_item, citiesNames);
                        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        citySpinner.setAdapter(adapter2);
                        // Log.e("cities response" , response.toString());

                    }

                    @Override
                    public void onFailure(Call<List<CitiesResponse>> call, Throwable t) {

                    }
                });

    }


    private void initView() {
        codeSpinner = findViewById(R.id.code_pinner);
        countrySpinner = findViewById(R.id.country_spinner);
        citySpinner = findViewById(R.id.city_spinner);
        terms = findViewById(R.id.terms);
        changeLanguage = findViewById(R.id.change_language);
    }




}
