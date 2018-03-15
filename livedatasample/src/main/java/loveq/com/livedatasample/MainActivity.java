package loveq.com.livedatasample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import loveq.com.livedatasample.sample1.DataRepository;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DataRepository.getData().observe(this, time -> {
            ((TextView) findViewById(R.id.tv_time)).setText("" + time);
        });
    }

    public void getTime(View view) {
        DataRepository.getData();
    }
}
