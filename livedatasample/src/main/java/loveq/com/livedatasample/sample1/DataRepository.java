package loveq.com.livedatasample.sample1;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import java.util.Date;

/**
 * Created by rc on 2018/3/15.
 * Description:
 */

public class DataRepository {
    private static MutableLiveData<Long> data = new MutableLiveData<Long>();

    //sets latest time to LiveData
    public static LiveData<Long> getData() {
        data.setValue(new Date().getTime());
        return data;
    }
}
