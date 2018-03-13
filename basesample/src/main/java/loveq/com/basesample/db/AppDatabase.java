package loveq.com.basesample.db;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;
import android.support.annotation.NonNull;

import java.util.List;

import loveq.com.basesample.AppExecutors;
import loveq.com.basesample.db.converter.DateConverter;
import loveq.com.basesample.db.dao.CommentDao;
import loveq.com.basesample.db.dao.ProductDao;
import loveq.com.basesample.db.entity.CommentEntity;
import loveq.com.basesample.db.entity.ProductEntity;

/**
 * Created by rc on 2018/3/13.
 * Description:
 */

@Database(entities = {ProductEntity.class, CommentEntity.class}, version = 1)
@TypeConverters(DateConverter.class)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase sInstance;
    public static final String DATABASE_NAME = "basic-sample-db";

    public abstract ProductDao productDao();

    public abstract CommentDao commentDao();

    private final MutableLiveData<Boolean> mIsDatabaseCreated = new MutableLiveData<>();

    public static AppDatabase getInstance(final Context context, final AppExecutors executors) {
        if (sInstance == null) {
            synchronized (AppDatabase.class) {
                if (sInstance == null) {
                    sInstance = buildDatabase(context.getApplicationContext(), executors);
                    sInstance.updateDatabaseCreated(context.getApplicationContext());
                }
            }
        }
        return sInstance;
    }

    private void updateDatabaseCreated(Context context) {
        if (context.getDatabasePath(DATABASE_NAME).exists()) {
            setDatabaseCreated();
        }
    }

    private static AppDatabase buildDatabase(final Context context, final AppExecutors executors) {

        return Room.databaseBuilder(context, AppDatabase.class, DATABASE_NAME)
                .addCallback(new Callback() {
                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                        super.onCreate(db);
                        executors.diskIO().execute(new Runnable() {
                            @Override
                            public void run() {
                                AppDatabase database = AppDatabase.getInstance(context, executors);
                                List<ProductEntity> products = DataGenerator.generateProducts();
                                List<CommentEntity> comments =
                                        DataGenerator.generateCommentsForProducts(products);
                                insertData(database, products, comments);
                                database.setDatabaseCreated();
                            }
                        });
                    }
                }).build();
    }

    private void setDatabaseCreated() {
        mIsDatabaseCreated.postValue(true);
    }

    private static void insertData(final AppDatabase database, final List<ProductEntity> products, final List<CommentEntity> comments) {
        database.runInTransaction(new Runnable() {
            @Override
            public void run() {
                database.productDao().insertAll(products);
                database.commentDao().insertAll(comments);
            }
        });
    }

    public LiveData<Boolean> getDatabaseCreated() {
        return mIsDatabaseCreated;
    }
}
