package loveq.com.viewmodelsample.sample2;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import loveq.com.viewmodelsample.sample1.EyeApi;
import loveq.com.viewmodelsample.sample1.entity.Daily;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by rc on 2018/3/15.
 * Description:
 */

public class DataRepository {
    private static Retrofit retrofit = null;

    public static Retrofit getRetrofitClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(EyeApi.EYE_END_POINT)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public LiveData<Daily> getDaily() {
        final MutableLiveData<Daily> liveData = new MutableLiveData<Daily>();
        Call<Daily> call = getRetrofitClient().create(EyeApi.class).getDaily();
        call.enqueue(new Callback<Daily>() {
            @Override
            public void onResponse(Call<Daily> call, Response<Daily> response) {
                Daily dai = response.body();
                liveData.setValue(dai);
            }

            @Override
            public void onFailure(Call<Daily> call, Throwable t) {

            }
        });
        return liveData;
    }
}
