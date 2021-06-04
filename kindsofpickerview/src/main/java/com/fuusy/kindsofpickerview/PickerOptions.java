package com.fuusy.kindsofpickerview;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.ListView;

import com.fuusy.kindsofpickerview.callback.OnOptionSelectMultipleListener;
import com.fuusy.kindsofpickerview.callback.OnOptionSelectSingleListener;


import java.util.ArrayList;
import java.util.List;

public class PickerOptions {

    public Context context;
    public OnOptionSelectMultipleListener multipleListener;
    public OnOptionSelectSingleListener singleListener;
    public List<String> itemList = new ArrayList<>();
    public List<String> titleList = new ArrayList<>();
    public int gravityValue = Gravity.BOTTOM;//默认底部
    public int choiceMode = ListView.CHOICE_MODE_SINGLE;//默认单选
    public int cancelAllPosition = -1;//多选模式下，取消全选item的位置
    public int style = R.style.DialogStyle;
    public String cancelName = "取消";
    public String confirmName = "确认";
    public int cancelColor = R.color.color_A6A6C0;
    public int confirmColor = R.color.color_405182;
    public int overScrollMode = View.OVER_SCROLL_NEVER;
    public float cancelSize = 16;
    public float confirmSize = 16;
    public boolean cancelable = false;
    public int cancelSureBgColor = R.color.color_F1F3F9;
    public int defaultSelectOnSingle = -1;
    public List<Integer> defaultSelectOnMulti = new ArrayList<>();




}
