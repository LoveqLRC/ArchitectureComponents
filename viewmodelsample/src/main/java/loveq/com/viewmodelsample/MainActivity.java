package loveq.com.viewmodelsample;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import loveq.com.viewmodelsample.sample1.DailyViewModel;

public class MainActivity extends AppCompatActivity {

    private DailyViewModel mDailyViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDailyViewModel = ViewModelProviders.of(this).get(DailyViewModel.class);
        mDailyViewModel.getDaily();
    }

    public void getTime(View view) {
        ((TextView) findViewById(R.id.tv_time)).setText(mDailyViewModel.getDaily().nextPageUrl);
    }
}
