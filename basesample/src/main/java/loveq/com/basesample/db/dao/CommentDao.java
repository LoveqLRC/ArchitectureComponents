package loveq.com.basesample.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import loveq.com.basesample.db.entity.CommentEntity;

/**
 * Created by rc on 2018/3/13.
 * Description:
 */

@Dao
public interface CommentDao {
    @Query("SELECT * FROM comments where productId = :productId")
    LiveData<List<CommentEntity>> loadComments(int productId);

    @Query("SELECT * FROM comments where productId = :productId")
    List<CommentEntity> loadCommentsSync(int productId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<CommentEntity> comments);
}
