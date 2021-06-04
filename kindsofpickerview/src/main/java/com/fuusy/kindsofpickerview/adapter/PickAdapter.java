package com.fuusy.kindsofpickerview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.fuusy.kindsofpickerview.R;
import java.util.ArrayList;
import java.util.List;

/**
 * @author fuusy
 * @date：2021/6/4
 * @instruction：ListView Adapter
 */
public class PickAdapter extends BaseAdapter {

    private List<String> mItemList = new ArrayList<>();
    private List<String> mTagList = new ArrayList<>();

    /**
     * 添加数据
     *
     * @param itemList item
     * @param tagList  标题
     */
    public void setList(List<String> itemList, List<String> tagList) {
        this.mItemList = itemList;
        this.mTagList = tagList;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mItemList.size();
    }

    @Override
    public Object getItem(int position) {
        return mItemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        if (mTagList.contains(getItem(position))) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pick_view_tag, parent, false);
            TextView tagView = view.findViewById(R.id.tv_pick_view_tag);
            tagView.setText((CharSequence) getItem(position));
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pick_view, parent, false);
            TextView itemName = view.findViewById(R.id.tv_pick_item_name);
            itemName.setText((CharSequence) getItem(position));
            ListView listView = (ListView) parent;
            ImageView ivSelected = view.findViewById(R.id.iv_pick_select);
            if (listView.isItemChecked(position)) {
                //选中
                ivSelected.setBackgroundResource(R.drawable.pick_selected);
            } else {
                ivSelected.setBackgroundResource(0);
            }
        }

        return view;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public boolean isEnabled(int position) {
        //如果是标题则不可点击
        if (mTagList.contains(getItem(position))) {
            return false;
        }
        return super.isEnabled(position);
    }
}
