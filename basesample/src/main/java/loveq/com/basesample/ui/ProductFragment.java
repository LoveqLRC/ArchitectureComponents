package loveq.com.basesample.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import loveq.com.basesample.R;

/**
 * Created by Administrator on 2018/3/19.
 */

public class ProductFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        DataBindingUtil.inflate(inflater, R.layout.product_fragment,container,false);
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
