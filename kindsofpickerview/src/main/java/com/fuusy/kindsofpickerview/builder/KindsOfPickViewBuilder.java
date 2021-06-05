package com.fuusy.kindsofpickerview.builder;

import android.content.Context;

import com.fuusy.kindsofpickerview.KindsOfPickerView;
import com.fuusy.kindsofpickerview.PickerOptions;
import com.fuusy.kindsofpickerview.callback.OnItemClickListener;
import com.fuusy.kindsofpickerview.callback.OnOptionSelectMultipleListener;
import com.fuusy.kindsofpickerview.callback.OnOptionSelectSingleListener;

import java.util.List;

/**
 * @author fuusy
 * @date：2021/6/4
 * @instruction：自定义单选、多选View的Builder类
 */
public class KindsOfPickViewBuilder {

    private PickerOptions mPickerOptions;

    /**
     * 默认构造函数
     *
     * @param context 上下文
     */
    public KindsOfPickViewBuilder(Context context) {
        mPickerOptions = new PickerOptions();
        mPickerOptions.context = context;
    }


    /***
     * 单选时的构造函数
     * @param context 上下文
     * @param singleListener 单选时，点击确认时的回调
     */
    public KindsOfPickViewBuilder(Context context, OnOptionSelectSingleListener singleListener) {
        mPickerOptions = new PickerOptions();
        mPickerOptions.context = context;
        mPickerOptions.singleListener = singleListener;
    }

    /**
     * 多选时的构造函数
     *
     * @param context          上下文
     * @param multipleListener 多选时，点击确认时的回调
     */
    public KindsOfPickViewBuilder(Context context, OnOptionSelectMultipleListener multipleListener) {
        mPickerOptions = new PickerOptions();
        mPickerOptions.context = context;
        mPickerOptions.multipleListener = multipleListener;
    }

    /**
     * 设置ListView的item点击事件
     *
     * @param listener 点击事件
     * @return KindsOfPickViewBuilder
     */
    public KindsOfPickViewBuilder setItemClickListener(OnItemClickListener listener) {
        mPickerOptions.itemClickListener = listener;
        return this;
    }

    /**
     * 设置pickView的位置.
     *
     * @param value Gravity.BOTTOM ,Gravity.TOP ...
     * @return KindsOfPickViewBuilder
     */
    public KindsOfPickViewBuilder setGravity(int value) {
        mPickerOptions.gravityValue = value;
        return this;
    }


    /**
     * 设置取消全选的位置，点击该position的item，取消全选
     *
     * @param position 位置
     * @return KindsOfPickViewBuilder
     */
    public KindsOfPickViewBuilder setCancelAllPosition(int position) {
        mPickerOptions.cancelAllPosition = position;
        return this;
    }


    /**
     * 设置选中模式，单选还是多选，默认单选
     *
     * @param mode 单选：ListView.CHOICE_MODE_SINGLE，多选：ListView.CHOICE_MODE_MULTIPLE
     * @return KindsOfPickViewBuilder
     */
    public KindsOfPickViewBuilder setChoiceMode(int mode) {
        mPickerOptions.choiceMode = mode;
        return this;
    }

    /**
     * 设置CheckBox的样式
     *
     * @param drawableId drawableId
     * @return KindsOfPickViewBuilder
     */
    public KindsOfPickViewBuilder setCheckBoxStyle(int drawableId) {
        mPickerOptions.checkBoxButtonStyle = drawableId;
        return this;
    }

    /**
     * 设置ListView占用屏幕的比例
     *
     * @param ratio 比例
     * @return KindsOfPickViewBuilder
     */
    public KindsOfPickViewBuilder setHeightRatio(float ratio) {
        mPickerOptions.heightRatio = ratio;
        return this;
    }


    /**
     * 设置ListView的ITem值
     *
     * @param list String list
     * @return KindsOfPickViewBuilder
     */
    public KindsOfPickViewBuilder setItemList(List<String> list) {
        mPickerOptions.itemList = list;
        return this;
    }


    /**
     * 设置标题List
     *
     * @param list String list
     * @return KindsOfPickViewBuilder
     */
    public KindsOfPickViewBuilder setTitleList(List<String> list) {
        mPickerOptions.titleList = list;
        return this;
    }

    /**
     * 设置PickView的风格
     *
     * @param style style ITEM_STYLE_DEFAULT、ITEM_STYLE_CHECK_BOX、ITEM_STYLE_SWITCH
     * @return KindsOfPickViewBuilder
     */
    public KindsOfPickViewBuilder setStyle(int style) {
        mPickerOptions.style = style;
        return this;
    }

    /**
     * 设置’取消‘的名称
     *
     * @param cancelValue 名称
     * @return KindsOfPickViewBuilder
     */
    public KindsOfPickViewBuilder setCancelText(String cancelValue) {
        mPickerOptions.cancelName = cancelValue;
        return this;
    }

    /**
     * 设置‘确认’的名称
     *
     * @param confirmValue 名称
     * @return KindsOfPickViewBuilder
     */
    public KindsOfPickViewBuilder setConfirmText(String confirmValue) {
        mPickerOptions.confirmName = confirmValue;
        return this;
    }

    /**
     * 设置取消字体颜色
     *
     * @param colorId 颜色
     * @return KindsOfPickViewBuilder
     */
    public KindsOfPickViewBuilder setCancelColor(int colorId) {
        mPickerOptions.cancelColor = colorId;
        return this;
    }

    /**
     * 设置确认字体颜色
     *
     * @param colorId 颜色
     * @return KindsOfPickViewBuilder
     */
    public KindsOfPickViewBuilder setConfirmColor(int colorId) {
        mPickerOptions.confirmColor = colorId;
        return this;
    }

    /**
     * 设置取消文字大小
     *
     * @param size 文字大小
     * @return KindsOfPickViewBuilder
     */
    public KindsOfPickViewBuilder setCancelSize(float size) {
        mPickerOptions.cancelSize = size;
        return this;
    }

    /**
     * 设置取消、确认的背景颜色
     *
     * @param color color
     * @return KindsOfPickViewBuilder
     */
    public KindsOfPickViewBuilder setCancelSureBgColor(int color) {
        mPickerOptions.cancelSureBgColor = color;
        return this;
    }

    /**
     * 设置确认文字大小
     *
     * @param size 文字大小
     * @return KindsOfPickViewBuilder
     */
    public KindsOfPickViewBuilder setConfirmSize(float size) {
        mPickerOptions.confirmSize = size;
        return this;
    }


    /**
     * 点击屏幕，点在控件外部范围时，是否取消显示
     *
     * @param cancelable boolean
     * @return KindsOfPickViewBuilder
     */
    public KindsOfPickViewBuilder setOutSideCancelable(boolean cancelable) {
        mPickerOptions.cancelable = cancelable;
        return this;
    }

    /**
     * 单选模式下，设置默认选中
     *
     * @param position 选中的position
     * @return KindsOfPickViewBuilder
     */
    public KindsOfPickViewBuilder setDefaultSelectOnSingle(int position) {
        mPickerOptions.defaultSelectOnSingle = position;
        return this;
    }

    /**
     * 多线模式下，设置默认选中
     *
     * @param positionList 默认选中的List
     * @return KindsOfPickViewBuilder
     */
    public KindsOfPickViewBuilder setDefaultSelectOnMulti(List<Integer> positionList) {
        mPickerOptions.defaultSelectOnMulti = positionList;
        return this;
    }

    /**
     * 设置item高度
     *
     * @param height 高度
     * @return KindsOfPickViewBuilder
     */
    public KindsOfPickViewBuilder setItemHeight(int height) {
        mPickerOptions.itemHeight = height;
        return this;
    }

    /**
     * 是否显示分割线
     *
     * @param isShow boolean
     * @return KindsOfPickViewBuilder
     */
    public KindsOfPickViewBuilder isShowLine(boolean isShow) {
        mPickerOptions.isShowLine = isShow;
        return this;
    }

    /**
     * 设置分割线的高度。
     *
     * @param height 高度 默认1
     * @return KindsOfPickViewBuilder
     */
    public KindsOfPickViewBuilder setLineHeight(int height) {
        mPickerOptions.lineHeight = height;
        return this;
    }

    /**
     * 设置Item的样式，checkBox switch
     *
     * @param style checkBox switch
     * @return KindsOfPickViewBuilder
     */
    public KindsOfPickViewBuilder setItemStyle(int style) {
        mPickerOptions.itemStyle = style;
        return this;
    }


    public KindsOfPickerView build() {
        return new KindsOfPickerView(mPickerOptions.context, mPickerOptions.style, mPickerOptions);
    }
}
