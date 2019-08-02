package com.example.rxjava_rxandroid;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import org.reactivestreams.Subscriber;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv=findViewById(R.id.rv);

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);



        Observable<Contects> observable= apiService.getDaata().subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());


        observable.subscribe(new Observer<Contects>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Contects value) {

                Log.e("Res",">>>>>."+value);
                List<Contact> list=value.getContacts();

                Adapter adapter=new Adapter(list);
                RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getApplicationContext());
                rv.setLayoutManager(layoutManager);
                rv.setItemAnimator(new DefaultItemAnimator());
                rv.setAdapter(adapter);

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                Toast.makeText(MainActivity.this, "CC", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
