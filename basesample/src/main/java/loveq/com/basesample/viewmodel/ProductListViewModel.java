package loveq.com.basesample.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.test.mock.MockApplication;

import java.util.List;

import loveq.com.basesample.BasicApp;
import loveq.com.basesample.db.entity.ProductEntity;

/**
 * Created by rc on 2018/3/14.
 * Description:
 */

public class ProductListViewModel extends AndroidViewModel {
    private final MediatorLiveData<List<ProductEntity>> mObservableProducts;


    public ProductListViewModel(@NonNull Application application) {
        super(application);
        mObservableProducts = new MediatorLiveData<>();
        mObservableProducts.setValue(null);

        LiveData<List<ProductEntity>> products = ((BasicApp) application)
                .getRepository().getProducts();

        mObservableProducts.addSource(products, new Observer<List<ProductEntity>>() {
            @Override
            public void onChanged(@Nullable List<ProductEntity> productEntities) {
                mObservableProducts.setValue(productEntities);
            }
        });
    }

    public LiveData<List<ProductEntity>> getProducts() {
        return mObservableProducts;
    }

}
