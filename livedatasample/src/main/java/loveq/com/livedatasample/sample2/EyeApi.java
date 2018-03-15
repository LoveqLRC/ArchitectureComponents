package loveq.com.livedatasample.sample2;

import loveq.com.livedatasample.sample2.entity.Daily;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by rc on 2018/3/15.
 * Description:
 */

public interface EyeApi {
    String EYE_END_POINT = " http://baobab.kaiyanapp.com/api/";

    //such as http://baobab.kaiyanapp.com/api/v2/feed?num=2
    @GET("v2/feed?num=2")
    Call<Daily> getDaily();
}
