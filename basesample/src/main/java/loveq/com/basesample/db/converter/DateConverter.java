package loveq.com.basesample.db.converter;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

/**
 * Created by rc on 2018/3/13.
 * Description:
 */

public class DateConverter {
    @TypeConverter
    public static Date toDate(Long timestamp) {
        return timestamp == null ? null : new Date(timestamp);
    }

    @TypeConverter
    public static Long toTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }
}
