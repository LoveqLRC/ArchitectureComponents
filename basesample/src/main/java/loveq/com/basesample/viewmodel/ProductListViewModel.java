package loveq.com.basesample.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MediatorLiveData;
import android.support.annotation.NonNull;

import java.util.List;

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

    }

}
