package loveq.com.basesample.ui;

import android.arch.lifecycle.Lifecycle;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import loveq.com.basesample.R;
import loveq.com.basesample.databinding.ListFragmentBinding;
import loveq.com.basesample.model.Product;

/**
 * Created by rc on 2018/3/13.
 * Description:
 */

public class ProductListFragment extends Fragment {
    public static final String TAG = "ProductListViewModel";
    private ListFragmentBinding mBinding;
    private ProductAdapter mProductAdapter;

    private final ProductClickCallback mProductClickCallback = new ProductClickCallback() {
        @Override
        public void onClick(Product product) {
            if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
//                ((MainActivity) getActivity()).show(product);
            }
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.list_fragment, container, false);
        mProductAdapter = new ProductAdapter(mProductClickCallback);
        mBinding.productsList.setAdapter(mProductAdapter);
        return mBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        ViewModelProviders.of(this).
    }
}
