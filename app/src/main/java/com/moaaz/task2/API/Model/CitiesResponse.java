package com.moaaz.task2.API.Model;

import com.google.gson.annotations.SerializedName;

public class CitiesResponse {

    @SerializedName("CountryId")
    private int countryId;

    @SerializedName("TitleAR")
    private String titleAR;

    @SerializedName("Id")
    private int id;

    @SerializedName("TitleEN")
    private String titleEN;

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setTitleAR(String titleAR) {
        this.titleAR = titleAR;
    }

    public String getTitleAR() {
        return titleAR;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setTitleEN(String titleEN) {
        this.titleEN = titleEN;
    }

    public String getTitleEN() {
        return titleEN;
    }

    @Override
    public String toString() {
        return
                "CitiesResponse{" +
                        "countryId = '" + countryId + '\'' +
                        ",titleAR = '" + titleAR + '\'' +
                        ",id = '" + id + '\'' +
                        ",titleEN = '" + titleEN + '\'' +
                        "}";
    }
}