package com.moaaz.task2.API.Model;

import com.google.gson.annotations.SerializedName;

public class CountriesResponse{

	@SerializedName("CurrencyAR")
	private String currencyAR;

	@SerializedName("CodeAR")
	private String codeAR;

	@SerializedName("TitleAR")
	private String titleAR;

	@SerializedName("CurrencyEN")
	private String currencyEN;

	@SerializedName("CodeEN")
	private String codeEN;

	@SerializedName("Id")
	private int id;

	@SerializedName("TitleEN")
	private String titleEN;

	@SerializedName("Code")
	private String code;

	@SerializedName("CurrencyId")
	private int currencyId;

	public void setCurrencyAR(String currencyAR){
		this.currencyAR = currencyAR;
	}

	public String getCurrencyAR(){
		return currencyAR;
	}

	public void setCodeAR(String codeAR){
		this.codeAR = codeAR;
	}

	public String getCodeAR(){
		return codeAR;
	}

	public void setTitleAR(String titleAR){
		this.titleAR = titleAR;
	}

	public String getTitleAR(){
		return titleAR;
	}

	public void setCurrencyEN(String currencyEN){
		this.currencyEN = currencyEN;
	}

	public String getCurrencyEN(){
		return currencyEN;
	}

	public void setCodeEN(String codeEN){
		this.codeEN = codeEN;
	}

	public String getCodeEN(){
		return codeEN;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setTitleEN(String titleEN){
		this.titleEN = titleEN;
	}

	public String getTitleEN(){
		return titleEN;
	}

	public void setCode(String code){
		this.code = code;
	}

	public String getCode(){
		return code;
	}

	public void setCurrencyId(int currencyId){
		this.currencyId = currencyId;
	}

	public int getCurrencyId(){
		return currencyId;
	}

	@Override
 	public String toString(){
		return 
			"CountriesResponse{" + 
			"currencyAR = '" + currencyAR + '\'' + 
			",codeAR = '" + codeAR + '\'' + 
			",titleAR = '" + titleAR + '\'' + 
			",currencyEN = '" + currencyEN + '\'' + 
			",codeEN = '" + codeEN + '\'' + 
			",id = '" + id + '\'' + 
			",titleEN = '" + titleEN + '\'' + 
			",code = '" + code + '\'' + 
			",currencyId = '" + currencyId + '\'' + 
			"}";
		}
}