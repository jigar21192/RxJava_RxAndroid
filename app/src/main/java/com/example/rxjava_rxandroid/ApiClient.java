package com.example.rxjava_rxandroid;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static final String BASE_URL = "http://23.227.133.210/consultapro/";
    public static final String BASE_URL_Contects = "https://api.androidhive.info/";
    public static final String BASE_URL_Image = "https://api.androidhive.info/json/";
    private static Retrofit retrofit = null;


    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL_Contects)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return retrofit;
        //  9428100471
    }
}
/*

    Get Country List :
        API : http://23.227.133.210/consultapro/json.php?action=GetCountry
        json=[{"umID":"727","OauthToken":"cl1oEntQ32PxZsS3VJnC+H+CY5oLfFLRU5j1H4bg+1g="}]

        Get State List :
        API : http://23.227.133.210/consultapro/json.php?action=GetStates
        json=[{"umID":"727","Country_Id":"10","OauthToken":"eyviE/IAKm8gJ/kpDUztODmyuMcbHsaBiXBVNx9r1rc="}]

        Get City List :
        API : http://23.227.133.210/consultapro/json.php?action=GetCity
        json=[{"umID":"727","State_Id":"10","OauthToken":"NfdICexlA6feO6sNkqzHZA=="}]
*/
