package loveq.com.viewmodelsample.sample2;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import loveq.com.viewmodelsample.R;
import loveq.com.viewmodelsample.sample1.entity.Daily;

public class Sample2Activity extends AppCompatActivity {
    private DailyViewModel mDailyViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample2);

        //get ViewModel using ViewModelProviders and then tech data
        mDailyViewModel = ViewModelProviders.of(this).get(DailyViewModel.class);

        //livedata
        mDailyViewModel.getDaily().observe(this, new Observer<Daily>() {
            @Override
            public void onChanged(@Nullable Daily daily) {
                ((TextView) findViewById(R.id.tv_time)).setText(daily.nextPageUrl);
            }
        });
    }
}
