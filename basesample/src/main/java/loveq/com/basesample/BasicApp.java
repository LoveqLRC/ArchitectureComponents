package loveq.com.basesample;

import android.app.Application;

/**
 * Created by rc on 2018/3/13.
 * Description:
 */

public class BasicApp extends Application {

    private AppExecutors mAppExecutors;
    @Override
    public void onCreate() {
        super.onCreate();

        mAppExecutors = new AppExecutors();
    }
}
