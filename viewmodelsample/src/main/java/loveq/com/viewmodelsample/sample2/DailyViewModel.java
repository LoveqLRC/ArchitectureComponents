package loveq.com.viewmodelsample.sample2;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;


import loveq.com.viewmodelsample.sample1.entity.Daily;

/**
 * Created by rc on 2018/3/15.
 * Description:
 */

public class DailyViewModel extends ViewModel {
    private LiveData<Daily> mDaily;
    private DataRepository mDataRepository = new DataRepository();

    public LiveData<Daily> getDaily() {
        if (mDaily == null) {
            mDaily = mDataRepository.getDaily();
        }
        return mDaily;
    }

}
