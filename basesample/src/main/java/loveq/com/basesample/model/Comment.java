package loveq.com.basesample.model;

import java.util.Date;

/**
 * Created by rc on 2018/3/13.
 * Description:
 */

public interface Comment {
    int getId();

    int getProductId();

    String getText();

    Date getPostedAt();
}
