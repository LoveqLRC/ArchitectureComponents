package loveq.com.basesample.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import loveq.com.basesample.db.entity.ProductEntity;

/**
 * Created by rc on 2018/3/13.
 * Description:
 */

@Dao
public interface ProductDao {

    @Query("SELECT * FROM products")
    LiveData<List<ProductEntity>> loadAllProducts();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<ProductEntity> products);

    @Query("select * from products where id = :productId")
    LiveData<ProductEntity> loadProduct(int productId);

    @Query("select * from products where id = :productId")
    ProductEntity loadProductSync(int productId);
}
