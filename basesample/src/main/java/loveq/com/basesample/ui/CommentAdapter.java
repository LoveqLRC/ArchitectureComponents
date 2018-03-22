package loveq.com.basesample.ui;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;
import java.util.Objects;

import loveq.com.basesample.R;
import loveq.com.basesample.databinding.CommentItemBinding;
import loveq.com.basesample.model.Comment;

/**
 * Email 664215432@qq.com
 * Created by Rc on 2018/3/22.
 * Version 1.0
 * Description:
 */
public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.
        CommentViewHolder> {
    private List<? extends Comment> mCommentList;

    @NonNull
    private final CommentClickCallback mCommentClickCallback;

    public CommentAdapter(@NonNull CommentClickCallback mCommentClickCallback) {
        this.mCommentClickCallback = mCommentClickCallback;
    }

    public void setCommentList(final List<? extends Comment> comments) {
        if (mCommentList == null) {
            mCommentList = comments;
            notifyItemRangeInserted(0, comments.size());
        } else {
            DiffUtil.DiffResult result = DiffUtil.calculateDiff(new DiffUtil.Callback() {
                @Override
                public int getOldListSize() {
                    return mCommentList.size();
                }

                @Override
                public int getNewListSize() {
                    return comments.size();
                }

                @Override
                public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
                    Comment old = mCommentList.get(oldItemPosition);
                    Comment comment = comments.get(newItemPosition);
                    return old.getId() == comment.getId();
                }

                @Override
                public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
                    Comment old = mCommentList.get(oldItemPosition);
                    Comment comment = comments.get(newItemPosition);
                    return old.getId() == comment.getId()
                            && old.getPostedAt() == comment.getPostedAt()
                            && old.getProductId() == comment.getProductId()
                            && Objects.equals(old.getText(), comment.getText());
                }
            });
            mCommentList = comments;
            result.dispatchUpdatesTo(this);
        }
    }

    @Override
    public CommentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CommentItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.comment_item,
                parent, false);
        binding.setCallback(mCommentClickCallback);
        return new CommentViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(CommentViewHolder holder, int position) {
        holder.binding.setComment(mCommentList.get(position));
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mCommentList==null?0:mCommentList.size();
    }

    public class CommentViewHolder extends RecyclerView.ViewHolder {
        final CommentItemBinding binding;

        public CommentViewHolder(CommentItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
