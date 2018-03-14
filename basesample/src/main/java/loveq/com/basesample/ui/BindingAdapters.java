package loveq.com.basesample.ui;

import android.databinding.BindingAdapter;
import android.view.View;

/**
 * Created by rc on 2018/3/14.
 * Description:
 */

public class BindingAdapters {
    @BindingAdapter("visibleGone")
    public static void showHide(View view, boolean show) {
        view.setVisibility(show ? View.VISIBLE : View.GONE);
    }
}
