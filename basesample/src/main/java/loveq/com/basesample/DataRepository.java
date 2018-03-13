package loveq.com.basesample;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;

import java.util.List;

import loveq.com.basesample.db.AppDatabase;
import loveq.com.basesample.db.entity.CommentEntity;
import loveq.com.basesample.db.entity.ProductEntity;

/**
 * Created by rc on 2018/3/13.
 * Description:
 */

public class DataRepository {
    private static DataRepository sInstance;
    private final AppDatabase mDatabase;
    private MediatorLiveData<List<ProductEntity>> mObservableProducts;

    private DataRepository(final AppDatabase database) {
        mDatabase = database;
        mObservableProducts = new MediatorLiveData<>();

        mObservableProducts.addSource(mDatabase.productDao().loadAllProducts(), new Observer<List<ProductEntity>>() {
            @Override
            public void onChanged(@Nullable List<ProductEntity> entities) {
                if (mDatabase.getDatabaseCreated().getValue() != null) {
                    mObservableProducts.postValue(entities);
                }
            }
        });
    }


    public static DataRepository getInstance(final AppDatabase database) {
        if (sInstance == null) {
            synchronized (DataRepository.class) {
                if (sInstance == null) {
                    sInstance = new DataRepository(database);
                }
            }
        }
        return sInstance;
    }

    /**
     * Get the list of products from the database and get notified when the data changes.
     */
    public LiveData<List<ProductEntity>> getProducts() {
        return mObservableProducts;
    }

    public LiveData<ProductEntity> loadProduct(final int productId) {
        return mDatabase.productDao().loadProduct(productId);
    }

    public LiveData<List<CommentEntity>> loadComments(final int productId) {
        return mDatabase.commentDao().loadComments(productId);
    }

}
