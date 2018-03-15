package loveq.com.viewmodelsample.sample1;

import android.arch.lifecycle.ViewModel;

import loveq.com.viewmodelsample.sample1.entity.Daily;

/**
 * Created by rc on 2018/3/15.
 * Description:
 */

public class DailyViewModel extends ViewModel {
    private Daily mDaily;
    private DataRepository mDataRepository = new DataRepository();

    public Daily getDaily() {
        if (mDaily == null) {
            mDaily = mDataRepository.getDaily();
        }
        return mDaily;
    }

}
