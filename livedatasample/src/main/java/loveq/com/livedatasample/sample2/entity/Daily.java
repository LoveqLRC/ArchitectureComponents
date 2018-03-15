package loveq.com.livedatasample.sample2.entity;

import java.util.List;

/**
 * Created by rc on 2018/3/15.
 * Description:
 */

public class Daily {
    public String nextPageUrl;
    public List<IssueList> issueList;

    public static class IssueList {
        public long releaseTime;
        public String type;
        public long date;
        public long publishTime;
        public int count;
    }
}
