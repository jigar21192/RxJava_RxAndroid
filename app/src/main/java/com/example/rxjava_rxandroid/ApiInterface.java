package com.example.rxjava_rxandroid;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {

/*

    @FormUrlEncoded
    @POST("json.php")
    Call<List<Coutry>> getCountry(@Field("action") String action, @Field("umID") String umID, @Field("OauthToken") String OauthToken);
*/


    @GET("contacts")
    Call<Contects> getData();

    @GET("contacts")
    Observable<Contects> getDaata();

/*

    @GET("movies.json")
    Call<List<ImageUrl>> getImageData();

*/

}
