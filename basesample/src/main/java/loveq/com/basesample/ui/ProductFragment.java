package loveq.com.basesample.ui;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import loveq.com.basesample.R;
import loveq.com.basesample.databinding.ProductFragmentBinding;
import loveq.com.basesample.db.entity.CommentEntity;
import loveq.com.basesample.db.entity.ProductEntity;
import loveq.com.basesample.model.Comment;
import loveq.com.basesample.viewmodel.ProductViewModel;

/**
 * Created by Administrator on 2018/3/19.
 */

public class ProductFragment extends Fragment {
    private static final String KEY_PRODUCT_ID = "product_id";
    private ProductFragmentBinding mBinding;

    private CommentAdapter mCommentAdapter;

    private final CommentClickCallback mCommentClickCallback = new CommentClickCallback() {
        @Override
        public void onClick(Comment comment) {

        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mBinding = DataBindingUtil.inflate(inflater, R.layout.product_fragment,
                container, false);
        mCommentAdapter = new CommentAdapter(mCommentClickCallback);
        mBinding.commentList.setAdapter(mCommentAdapter);
        return mBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ProductViewModel.Factory factory = new ProductViewModel.Factory(getActivity().getApplication(),
                getArguments().getInt(KEY_PRODUCT_ID));

        ProductViewModel viewModel = ViewModelProviders.of(this, factory)
                .get(ProductViewModel.class);

        mBinding.setProductViewModel(viewModel);

        subscribeToModel(viewModel);

    }


    private void subscribeToModel(final ProductViewModel viewModel) {
        viewModel.getObservableProduct().observe(this, new Observer<ProductEntity>() {
            @Override
            public void onChanged(@Nullable ProductEntity productEntity) {
                viewModel.setProduct(productEntity);
            }
        });

        viewModel.getComments().observe(this, new Observer<List<CommentEntity>>() {
            @Override
            public void onChanged(@Nullable List<CommentEntity> commentEntities) {
                if (commentEntities == null) {
                    mBinding.setIsLoading(true);
                } else {
                    mBinding.setIsLoading(false);
                    mCommentAdapter.setCommentList(commentEntities);
                }
            }
        });

    }

    public static ProductFragment forProduct(int productId) {
        ProductFragment productFragment = new ProductFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_PRODUCT_ID, productId);
        productFragment.setArguments(bundle);
        return productFragment;
    }


}
