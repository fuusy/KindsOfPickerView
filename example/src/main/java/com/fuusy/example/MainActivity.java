package com.fuusy.example;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.fuusy.kindsofpickerview.builder.KindsOfPickViewBuilder;
import com.fuusy.kindsofpickerview.callback.OnItemClickListener;
import com.fuusy.kindsofpickerview.callback.OnOptionSelectMultipleListener;
import com.fuusy.kindsofpickerview.callback.OnOptionSelectSingleListener;
import com.fuusy.kindsofpickerview.config.Constant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.fuusy.kindsofpickerview.config.Constant.CHOICE_MODE_MULTI;
import static com.fuusy.kindsofpickerview.config.Constant.CHOICE_MODE_SINGLE;

public class MainActivity extends AppCompatActivity {

    private String[] mItemArray = {
            "Java", "Kotlin", "Dart", "Js", "HTML", "Python"
    };

    private String[] mItemWithTitleArray = {
            "语言", "Java", "Kotlin", "Dart", "Js", "HTML", "Python"
    };


    private String[] mItemWithNoArray = {
            "语言", "Java", "Kotlin", "Dart", "Js", "HTML", "Python", "都不想学"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //单选
        findViewById(R.id.bt_single).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final List<String> itemList = new ArrayList<>(Arrays.asList(mItemArray));

                new KindsOfPickViewBuilder(MainActivity.this, new OnOptionSelectSingleListener() {
                    @Override
                    public void onOptionsSelectSingle(int position) {
                        //单选模式下，点击确认的回调
                        showToast(itemList.get(position));
                    }
                })
                        .setGravity(Gravity.TOP)//位置
                        .setChoiceMode(CHOICE_MODE_SINGLE)//单选:CHOICE_MODE_SINGLE，多选:CHOICE_MODE_MULTI
                        .setItemList(itemList)//列表数据
                        .setCancelText("Cancel")//取消按钮文字
                        .setConfirmText("Confirm")//确认按钮文字
                        .setCancelColor(R.color.color_1C97EF)//取消按钮文字颜色
                        .setConfirmColor(R.color.color_1C97EF)//确认按钮文字颜色
                        .setOutSideCancelable(true)//点击屏幕,是否取消显示
                        .setCancelSureBgColor(R.color.color_F1F3F9)//取消、确认整体背景
                        .setCancelSize(20)//取消按钮文字大小
                        .setConfirmSize(20)//确认按钮文字大小
                        .setDefaultSelectOnSingle(1)//单选模式下，设置默认选中项
                        .build()
                        .show();

            }
        });

        //多选
        findViewById(R.id.bt_multi).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final List<String> itemList = new ArrayList<>(Arrays.asList(mItemArray));
                List<Integer> defaultSelectList = new ArrayList<>();
                defaultSelectList.add(2);
                defaultSelectList.add(3);
                new KindsOfPickViewBuilder(MainActivity.this, new OnOptionSelectMultipleListener() {
                    @Override
                    public void onOptionsSelectMultiple(List<Integer> selectedList) {
                        StringBuilder value = new StringBuilder();
                        for (int selectPosition :
                                selectedList) {
                            value.append(itemList.get(selectPosition)).append("-");
                        }
                        showToast(value.toString());
                    }
                })
                        .setGravity(Gravity.CENTER)//位置
                        .setChoiceMode(CHOICE_MODE_MULTI)//单选:CHOICE_MODE_SINGLE，多选:CHOICE_MODE_MULTI
                        .setItemList(itemList)//列表数据
                        .setCancelText("Cancel")//取消按钮文字
                        .setConfirmText("Confirm")//确认按钮文字
                        .setCancelColor(R.color.color_1C97EF)//取消按钮文字颜色
                        .setConfirmColor(R.color.color_1C97EF)//确认按钮文字颜色
                        .setOutSideCancelable(true)//点击屏幕,是否取消显示
                        .setCancelSureBgColor(R.color.color_F1F3F9)//取消、确认整体背景
                        .setItemHeight(60)//设置item的高度
                        .setLineHeight(1)//设置分割线的高度
                        .setCancelSize(16)//取消按钮文字大小
                        .setConfirmSize(16)//确认按钮文字大小
                        .setDefaultSelectOnMulti(defaultSelectList)//多选模式下，设置默认选中项
                        .setItemStyle(Constant.ITEM_STYLE_CHECK_BOX)//设置Item的选中的样式
                        .setCheckBoxStyle(R.drawable.selector_check_box_test)//设置CheckBox的样式
                        .setHeightRatio(0.4f)//设置整体占用屏幕的比例
                        .setItemClickListener(new OnItemClickListener() {
                            @Override
                            public void onItemClick(int position) {
                                showToast("点击了 " + position);
                            }
                        })
                        .build()
                        .show();

            }
        });


        findViewById(R.id.bt_with_title).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final List<String> itemList = new ArrayList<>(Arrays.asList(mItemWithTitleArray));
                List<String> titleList = new ArrayList<>();
                titleList.add(mItemWithTitleArray[0]);

                new KindsOfPickViewBuilder(MainActivity.this, new OnOptionSelectSingleListener() {
                    @Override
                    public void onOptionsSelectSingle(int position) {
                        //单选模式下，点击确认的回调
                        showToast(itemList.get(position));
                    }
                })
                        .setGravity(Gravity.BOTTOM)//位置
                        .setChoiceMode(CHOICE_MODE_SINGLE)//单选:CHOICE_MODE_SINGLE，多选:CHOICE_MODE_MULTI
                        .setItemList(itemList)//列表数据
                        .setDefaultSelectOnSingle(1)//单选模式下，设置默认选中项
                        .setTitleList(titleList)//设置title的list
                        .setItemStyle(Constant.ITEM_STYLE_SWITCH)
                        .build()
                        .show();

            }
        });

        findViewById(R.id.bt_with_no).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final List<String> itemList = new ArrayList<>(Arrays.asList(mItemWithNoArray));
                List<String> titleList = new ArrayList<>();
                titleList.add(mItemWithNoArray[0]);

                new KindsOfPickViewBuilder(MainActivity.this, new OnOptionSelectMultipleListener() {
                    @Override
                    public void onOptionsSelectMultiple(List<Integer> selectedList) {
                        StringBuilder value = new StringBuilder();
                        for (int selectPosition :
                                selectedList) {
                            value.append(itemList.get(selectPosition)).append("-");
                        }
                        showToast(value.toString());
                    }
                })
                        .setGravity(Gravity.BOTTOM)//位置
                        .setChoiceMode(CHOICE_MODE_MULTI)//单选:CHOICE_MODE_SINGLE，多选:CHOICE_MODE_MULTI
                        .setItemList(itemList)//列表数据
                        .setTitleList(titleList)//设置title的list
                        .setItemStyle(Constant.ITEM_STYLE_SWITCH)
                        .setCancelAllPosition(itemList.size() - 1)
                        .build()
                        .show();
            }
        });
    }

    private void showToast(String msg) {
        Toast.makeText(MainActivity.this, "已选择>>>" + msg, Toast.LENGTH_LONG).show();
    }
}
