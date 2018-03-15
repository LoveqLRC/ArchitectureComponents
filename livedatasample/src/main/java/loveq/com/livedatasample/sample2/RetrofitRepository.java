package loveq.com.livedatasample.sample2;

import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import java.util.concurrent.Executors;

import loveq.com.livedatasample.sample2.entity.Daily;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by rc on 2018/3/15.
 * Description:
 */

public class RetrofitRepository {
    private static MutableLiveData<Daily> data = new MutableLiveData<Daily>();
    private static Retrofit retrofit = null;

    public static Retrofit getRetrofitClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(EyeApi.EYE_END_POINT)
                    .addConverterFactory(GsonConverterFactory.create())
                    //指定回调的线程
                    .callbackExecutor(Executors.newSingleThreadExecutor())
                    .build();
        }
        return retrofit;
    }

    public static MutableLiveData<Daily> getData() {
        return data;
    }

    public static void getDailyInfo() {
        Log.d("TAG", "PROCESSING IN THREAD BEFORE RETROFIT CALL " + Thread.currentThread().getName());
        Call<Daily> call = getRetrofitClient().create(EyeApi.class).getDaily();
        call.enqueue(new Callback<Daily>() {
            @Override
            public void onResponse(Call<Daily> call, Response<Daily> response) {
                Daily daily = response.body();
                data.postValue(daily);
                Log.d("TAG", "PROCESSING IN THREAD IN RETROFIT RESPONSE HANDLER " + Thread.currentThread().getName());
            }

            @Override
            public void onFailure(Call<Daily> call, Throwable t) {
                Log.e("", "Error RETROFIT");
            }
        });

    }
}
