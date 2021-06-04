package com.fuusy.example;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.fuusy.kindsofpickerview.builder.KindsOfPickViewBuilder;
import com.fuusy.kindsofpickerview.callback.OnOptionSelectMultipleListener;
import com.fuusy.kindsofpickerview.callback.OnOptionSelectSingleListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String[] mItemArray = {
            "Java", "Kotlin", "Dart", "Js", "HTML", "Python"
    };

    private String[] mItemWithTitleArray = {
            "语言", "Java", "Kotlin", "Dart", "Js", "HTML", "Python"
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
                        .setChoiceMode(ListView.CHOICE_MODE_SINGLE)//单选:ListView.CHOICE_MODE_SINGLE，多选:ListView.CHOICE_MODE_MULTIPLE
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

        //单选
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
                        .setChoiceMode(ListView.CHOICE_MODE_MULTIPLE)//单选:ListView.CHOICE_MODE_SINGLE，多选:ListView.CHOICE_MODE_MULTIPLE
                        .setItemList(itemList)//列表数据
                        .setCancelText("Cancel")//取消按钮文字
                        .setConfirmText("Confirm")//确认按钮文字
                        .setCancelColor(R.color.color_1C97EF)//取消按钮文字颜色
                        .setConfirmColor(R.color.color_1C97EF)//确认按钮文字颜色
                        .setOutSideCancelable(true)//点击屏幕,是否取消显示
                        .setCancelSureBgColor(R.color.color_F1F3F9)//取消、确认整体背景
                        .setCancelSize(16)//取消按钮文字大小
                        .setConfirmSize(16)//确认按钮文字大小
                        .setDefaultSelectOnMulti(defaultSelectList)//多选模式下，设置默认选中项
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
                        .setChoiceMode(ListView.CHOICE_MODE_SINGLE)//单选:ListView.CHOICE_MODE_SINGLE，多选:ListView.CHOICE_MODE_MULTIPLE
                        .setItemList(itemList)//列表数据
                        .setDefaultSelectOnSingle(1)//单选模式下，设置默认选中项
                        .setTitleList(titleList)//设置title的list
                        .build()
                        .show();

            }
        });

    }

    private void showToast(String msg) {
        Toast.makeText(MainActivity.this, "已选择>>>" + msg, Toast.LENGTH_LONG).show();
    }
}
