package loveq.com.livedatasample.sample2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import loveq.com.livedatasample.R;

public class Sample2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample2);
        RetrofitRepository.getData().observe(this, daily -> {
            ((TextView) findViewById(R.id.tv_time)).setText("" + daily.nextPageUrl);
        });
    }

    public void getTime(View view) {
        RetrofitRepository.getDailyInfo();
    }
}
