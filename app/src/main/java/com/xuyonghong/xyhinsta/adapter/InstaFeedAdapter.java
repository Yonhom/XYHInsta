package com.xuyonghong.xyhinsta.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.xuyonghong.xyhinsta.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by xuyonghong on 2017/5/30.
 */

public class InstaFeedAdapter extends RecyclerView.Adapter<InstaFeedAdapter.InstaFeedViewHolder> {
    private Context context;

    public InstaFeedAdapter(Context context) {
        this.context = context;
    }

    @Override
    public InstaFeedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // parent have to be provided, cause the layout parameter set in the item xml can not implied to parent view!!!
        View view = LayoutInflater.from(context).inflate(R.layout.main_feed_item, parent, false);
        InstaFeedViewHolder holder = new InstaFeedViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(InstaFeedViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }


    static class InstaFeedViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.image_user)
        ImageButton imageUser;
        @BindView(R.id.text_user)
        TextView textUser;
        @BindView(R.id.main_image_view)
        ImageView mainImageView;
        @BindView(R.id.text_comment)
        TextView textComment;
        @BindView(R.id.btn_like)
        ImageButton btnLike;
        @BindView(R.id.btn_look_up_comment)
        ImageButton btnLookupComment;
        @BindView(R.id.btn_more)
        ImageButton btnMore;
        @BindView(R.id.like_count_text)
        TextView likeCountText;

        public InstaFeedViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
