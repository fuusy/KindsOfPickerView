package com.fuusy.kindsofpickerview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.widget.SwitchCompat;

import com.fuusy.kindsofpickerview.PickerOptions;
import com.fuusy.kindsofpickerview.R;
import com.fuusy.kindsofpickerview.config.Constant;
import com.fuusy.kindsofpickerview.config.PixelTool;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fuusy
 * @date：2021/6/4
 * @instruction：ListView的Adapter
 */
public class PickAdapter extends BaseAdapter {
    private static final String TAG = "PickAdapter";
    private List<String> mItemList = new ArrayList<>();
    private List<String> mTagList = new ArrayList<>();
    private PickerOptions mOptions;

    /**
     * 添加数据
     *
     * @param itemList item
     * @param tagList  标题
     */
    public void setList(List<String> itemList, List<String> tagList) {
        this.mItemList = itemList;
        this.mTagList = tagList;

    }

    public void setOptions(PickerOptions options) {
        mOptions = options;
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
            AbsListView.LayoutParams param = new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, PixelTool.dpToPx(parent.getContext(), mOptions.itemHeight));
            view.setLayoutParams(param);

            TextView itemName = view.findViewById(R.id.tv_pick_item_name);
            itemName.setText((CharSequence) getItem(position));
            ListView listView = (ListView) parent;
            ImageView ivSelected = view.findViewById(R.id.iv_pick_select);
            CheckBox checkBox = view.findViewById(R.id.cb_pick_select);
            checkBox.setClickable(false);
            SwitchCompat switchCompat = view.findViewById(R.id.sw_pick_select);
            switchCompat.setClickable(false);
            if (mOptions.itemStyle == Constant.ITEM_STYLE_CHECK_BOX) {
                checkBox.setVisibility(View.VISIBLE);
                switchCompat.setVisibility(View.GONE);
                ivSelected.setVisibility(View.GONE);
                if (mOptions.checkBoxButtonStyle != -1) {
                    checkBox.setButtonDrawable(mOptions.checkBoxButtonStyle);
                }
                if (listView.isItemChecked(position)) {
                    checkBox.setChecked(true);
                } else {
                    checkBox.setChecked(false);
                }
            } else if (mOptions.itemStyle == Constant.ITEM_STYLE_SWITCH) {
                checkBox.setVisibility(View.GONE);
                switchCompat.setVisibility(View.VISIBLE);
                ivSelected.setVisibility(View.GONE);
                if (listView.isItemChecked(position)) {
                    switchCompat.setChecked(true);
                } else {
                    switchCompat.setChecked(false);
                }
            } else {
                checkBox.setVisibility(View.GONE);
                switchCompat.setVisibility(View.GONE);
                ivSelected.setVisibility(View.VISIBLE);
                if (listView.isItemChecked(position)) {
                    //选中
                    ivSelected.setBackgroundResource(R.drawable.pick_selected);
                } else {
                    ivSelected.setBackgroundResource(0);
                }
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
