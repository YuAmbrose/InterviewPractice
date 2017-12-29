package com.example.interviewpractice.adapter.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.interviewpractice.R;
import com.example.interviewpractice.enity.CategoryTab;
import com.example.interviewpractice.utils.ScreenUtil;

import java.util.List;


public class EntranceAdapter extends RecyclerView.Adapter<EntranceAdapter.EntranceViewHolder> {


    private List<CategoryTab> mDatas;
    /**
     * 页数下标,从0开始(通俗讲第几页)
     */
    private int mIndex;
    /**
     * 每页显示最大条目个数
     */
    private int mPageSize;
    private Context mContext;
    private final LayoutInflater mLayoutInflater;
    private List<CategoryTab> homeEntrances;

    public EntranceAdapter(Context context, List<CategoryTab> datas, int index, int pageSize) {
        this.mContext = context;
        this.homeEntrances = datas;
        mPageSize = pageSize;
        mDatas = datas;
        mIndex = index;
        mLayoutInflater = LayoutInflater.from(context);

    }

    @Override
    public EntranceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new EntranceViewHolder(mLayoutInflater.inflate(R.layout.item_home_entrance, null));
    }

    @Override
    public void onBindViewHolder(EntranceViewHolder holder, final int position) {
        /**
         * 在给View绑定显示的数据时，计算正确的position = position + mIndex * mPageSize，
         */
        final int pos = position + mIndex * mPageSize;
        Log.e("888", "onBindViewHolder: "+homeEntrances.size() );
        holder.entranceNameTextView.setText(homeEntrances.get(pos).getType());
        if (homeEntrances.get(pos).getTypeIcon().getUrl()!=null){
            Glide.with(mContext)
                    .load(homeEntrances.get(pos).getTypeIcon().getUrl())
                    .into(holder.entranceIconImageView);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, homeEntrances.get(pos).getId(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDatas.size() > (mIndex + 1) * mPageSize ? mPageSize : (mDatas.size() - mIndex * mPageSize);
    }

    @Override
    public long getItemId(int position) {
        return position + mIndex * mPageSize;
    }

    class EntranceViewHolder extends RecyclerView.ViewHolder {

        private TextView entranceNameTextView;
        private ImageView entranceIconImageView;

        public EntranceViewHolder(View itemView) {
            super(itemView);
            entranceIconImageView = (ImageView) itemView.findViewById(R.id.entrance_image);
            entranceNameTextView = (TextView) itemView.findViewById(R.id.entrance_name);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, (int) ((float) ScreenUtil.getScreenWidth() / 4.0f));
            itemView.setLayoutParams(layoutParams);
        }
    }
}
