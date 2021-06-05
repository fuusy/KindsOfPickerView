package com.fuusy.kindsofpickerview;

import android.app.Dialog;
import android.content.Context;
import android.util.SparseBooleanArray;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.fuusy.kindsofpickerview.adapter.PickAdapter;

import java.util.ArrayList;
import java.util.List;

import static com.fuusy.kindsofpickerview.config.Constant.CHOICE_MODE_SINGLE;

/**
 * @author fuusy
 * @date：2021/6/4
 * @instruction：自定义单选和多选的选择器。
 */
public class KindsOfPickerView extends Dialog {
    private static final String TAG = "KindsOfPickerView";

    private PickerOptions mPickerOptions;
    private PickAdapter mPickAdapter;

    public KindsOfPickerView(@NonNull Context context, PickerOptions options) {
        super(context);
        this.mPickerOptions = options;
    }

    public KindsOfPickerView(@NonNull Context context, int themeResId, PickerOptions options) {
        super(context, themeResId);
        this.mPickerOptions = options;
        initView(context);
    }


    private void initView(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_kind_pick_view, null);
        addContentView(view,
                new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
        //设置
        Window window = getWindow();
        assert window != null;
        window.setGravity(mPickerOptions.gravityValue);
        //设置为全屏dialog
        WindowManager.LayoutParams params = window.getAttributes();
        Display display = context.getDisplay();
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        params.height = (int) (display.getHeight() * mPickerOptions.heightRatio);
        window.setAttributes(params);
        setCanceledOnTouchOutside(mPickerOptions.cancelable);

        final ListView listView = view.findViewById(R.id.lv_kind_of_pick_view);
        listView.setChoiceMode(mPickerOptions.choiceMode);
        mPickAdapter = new PickAdapter();
        mPickAdapter.setList(mPickerOptions.itemList, mPickerOptions.titleList);
        mPickAdapter.setOptions(mPickerOptions);
        listView.setAdapter(mPickAdapter);

        //设置ListView的分割线
        if (mPickerOptions.isShowLine) {
            listView.setDividerHeight(mPickerOptions.lineHeight);
        } else {
            listView.setDividerHeight(0);
        }

        //设置默认选择
        if (mPickerOptions.choiceMode == CHOICE_MODE_SINGLE) {
            //单选
            listView.setItemChecked(mPickerOptions.defaultSelectOnSingle, true);
        } else {
            for (int position :
                    mPickerOptions.defaultSelectOnMulti) {
                listView.setItemChecked(position, true);
            }
        }
        initItemClick(listView);

        //取消、确认按钮
        TextView cancel = view.findViewById(R.id.tv_pick_view_cancel);
        TextView sure = view.findViewById(R.id.tv_pick_view_sure);
        cancel.setText(mPickerOptions.cancelName);
        sure.setText(mPickerOptions.confirmName);
        cancel.setTextColor(context.getResources().getColor(mPickerOptions.cancelColor));
        sure.setTextColor(context.getResources().getColor(mPickerOptions.confirmColor));
        cancel.setTextSize(mPickerOptions.cancelSize);
        sure.setTextSize(mPickerOptions.confirmSize);

        //点击取消
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        //点击确认
        sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnData(listView);
                dismiss();
            }
        });

        //取消、确认整体背景
        ConstraintLayout clCancelSure = view.findViewById(R.id.cl_cancel_sure);
        clCancelSure.setBackgroundColor(context.getResources().getColor(mPickerOptions.cancelSureBgColor));
    }

    /**
     * 点击确认后，携带数据通知调用者。
     *
     * @param listView ListView
     */
    private void returnData(ListView listView) {
        if (mPickerOptions.choiceMode == ListView.CHOICE_MODE_MULTIPLE) {
            //多选
            SparseBooleanArray checkedItemPositionArray = listView.getCheckedItemPositions();

            if (mPickerOptions.multipleListener != null) {
                List<Integer> selectList = new ArrayList<>();
                for (int i = 0; i < mPickerOptions.itemList.size(); i++) {
                    if (checkedItemPositionArray.get(i)) {
                        selectList.add(i);
                    }
                }
                if (selectList.size() != 0) {
                    mPickerOptions.multipleListener.onOptionsSelectMultiple(selectList);
                }
            }
        } else {
            //单选
            if (mPickerOptions.singleListener != null) {
                int selectPosition = listView.getCheckedItemPosition();
                if (selectPosition >= 0) {
                    mPickerOptions.singleListener.onOptionsSelectSingle(selectPosition);
                }
            }
        }
    }

    /**
     * ListView Item
     * 的点击事件。
     *
     * @param listView ListView
     */
    private void initItemClick(final ListView listView) {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (mPickerOptions.itemClickListener != null) {
                    mPickerOptions.itemClickListener.onItemClick(position);
                }
                if (position == mPickerOptions.cancelAllPosition) {
                    //如果点击的是取消全选item
                    for (int i = 0; i < mPickerOptions.itemList.size(); i++) {
                        listView.setItemChecked(i, false);
                    }
                    listView.setItemChecked(mPickerOptions.cancelAllPosition, true);
                } else {
                    //如果取消全选已经点击了，这个时候点击其他选项，则取消取消全选的选中状态
                    if (listView.isItemChecked(mPickerOptions.cancelAllPosition)) {
                        listView.setItemChecked(mPickerOptions.cancelAllPosition, false);
                    }
                }
                mPickAdapter.notifyDataSetChanged();
            }
        });
    }
}
