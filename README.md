# KindsOfPickerView

这是一个开源库，你可以使用、可以借鉴修改，希望对你们有所帮助。

## 功能介绍
这是一款可单选、多选、可自定义样式的选择器，功能如下：

- 支持多选
- 支持单选
- 支持设置item选中样式
- 支持多选一键清除
- 实时回调
- 支持自定义文字、背景、颜色、大小
- 支持自定义Item样式和大小
- 支持设置选择器的大小、位置
- 支持设置标题
......

## 效果图

【带标题】：

![691b11f536ebd7d20029ca6154993821.gif](https://p1-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/0e107a42f68a4322b2bbb4135ac80306~tplv-k3u1fbpfcp-watermark.image)

【多选一键清除】：

![2665ac3193916936efb3ef5c831637ab.gif](https://p6-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/577ce808c73b49139aca3a69d756482e~tplv-k3u1fbpfcp-watermark.image)

【多选】：

![7abc75168e1a0863529c9508d9aa8d6b.gif](https://p6-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/8b14360fa745444e88c2e9914341cab9~tplv-k3u1fbpfcp-watermark.image)

【单选】：

![4a8991321cd804b423ce9d9e04fcdea1.gif](https://p1-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/b67b79de03a240f496cc128cf3aede9d~tplv-k3u1fbpfcp-watermark.image)

如果你不满足上面默认效果，可依照下方功能介绍，自定义样式。
## 使用步骤
1. 添加依赖

```js
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

```js
dependencies {
	implementation 'com.github.fuusy:KindsOfPickerView:1.1.0'
}
```
或Maven

```js
<repositories>
	<repository>
		<id>jitpack.io</id>
		<url>https://jitpack.io</url>
	</repository>
</repositories>
```


```js
<dependency>
	    <groupId>com.github.fuusy</groupId>
	    <artifactId>KindsOfPickerView</artifactId>
	    <version>1.0.0</version>
</dependency>
```
2.具体代码


```js
//1.单选，setChoiceMode(CHOICE_MODE_SINGLE)
new KindsOfPickViewBuilder(context, new OnOptionSelectSingleListener() {
                    @Override
                    public void onOptionsSelectSingle(int position) {
                        //单选模式下，点击确认的回调
                        
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
                        .setItemStyle(Constant.ITEM_STYLE_CHECK_BOX)//设置Item的选中的样式
                        .setCheckBoxStyle(R.drawable.selector_check_box_test)//设置CheckBox的样式
                        .setHeightRatio(0.4f)//设置整体占用屏幕的比例
                        .build()
                        .show();
                        
                        
 //2.多选，setChoiceMode(CHOICE_MODE_MULTI)
 new KindsOfPickViewBuilder(MainActivity.this, new OnOptionSelectMultipleListener() {
                    @Override
                    public void onOptionsSelectMultiple(List<Integer> selectedList) {
                       
                    }
                })
                .setChoiceMode(CHOICE_MODE_MULTI)//单选:CHOICE_MODE_SINGLE，多选:CHOICE_MODE_MULTI
                .setItemList(itemList)//列表数据
                .setTitleList(titleList)//设置title的list
                .build()
                .show();
                
                
//3.多选模式下，点击某个item取消已经选中的，并选择该item，主要添加setCancelAllPosition 
 new KindsOfPickViewBuilder(MainActivity.this, new OnOptionSelectMultipleListener() {
                    @Override
                    public void onOptionsSelectMultiple(List<Integer> selectedList) {
                       
                    }
                })
                .setChoiceMode(CHOICE_MODE_MULTI)//单选:CHOICE_MODE_SINGLE，多选:CHOICE_MODE_MULTI
                .setItemList(itemList)//列表数据
                .setTitleList(titleList)//设置title的list
                .setCancelAllPosition(itemList.size() - 1)
                .build()
                .show();
```
## 详细方法名
|   名称  |   参数  |   描述  |
| --- | --- | --- |
|  KindsOfPickViewBuilder   |  Context   |  KindsOfPickViewBuilder构造函数   |
|   KindsOfPickViewBuilder  |   Context，OnOptionSelectSingleListener  |   KindsOfPickViewBuilder构造函数，带有单选回调  |
|  KindsOfPickViewBuilder   |  Context，OnOptionSelectMultipleListener   |   KindsOfPickViewBuilder构造函数，带有多选回调   |
|  setItemClickListener   |   OnItemClickListener  |   Item的点击事件  |
|   setGravity  |   int value  |   设置pickerView的位置  |
|   setCancelAllPosition  |  int position   |   设置取消全选的位置，点击该position的item，取消全选  |
|  setChoiceMode   |  int mode   |  设置选中模式，单选还是多选，默认单选   |
|  setCheckBoxStyle   |  int drawableId   |  设置CheckBox的样式   |
|  setHeightRatio   |  float ratio   | 设置pickerView的高度，占屏幕的比例    |
|  setItemList   |  List  | 设置pickerView的Item数据源   |
|  setTitleList   |  List  | 设置pickerView的标题数据源    |
|  setCancelText   |  String cancelValue  | 设置’取消‘的名称    |
|  setConfirmText   |  String confirmValue  | 设置‘确认’的名称   |
|  setCancelColor   |  int colorId  | 设置取消字体颜色    |
|  setConfirmColor   |  int colorId  | 设置确认字体颜色    |
|  setCancelSize   |  float size  | 设置取消文字大小  |
|  setConfirmSize   |  float size  | 设置确认文字大小   |
|  setCancelSureBgColor   |  int colorId  | 设置取消、确认的背景颜色   |
|  setOutSideCancelable   |  boolean cancelable  | 点击屏幕，点在控件外部范围时，是否取消显示   |
|  setDefaultSelectOnSingle   |  int position | 单选模式下，设置默认的选中项   |
|  setDefaultSelectOnMulti   |  int position| 多选模式下，设置默认的选中项   |
|  setItemHeight   |  int height  | 设置item高度   |
|  isShowLine   |  boolean isShow  | 是否显示分割线   |
|  setLineHeight   |  int height  | 设置Item分割线的高度   |
|  setItemStyle   |  int style  | 设置PickView的风格，ITEM_STYLE_DEFAULT、ITEM_STYLE_CHECK_BOX、ITEM_STYLE_SWITCH    |

## 版本更新
**v1.1.0:**

1.新增Item的选中样式,checkBox,switch,可自定义

2.对外新增ListView的item点击事件

**v1.0.0**

1.新增基础功能

## Thanks
[Bigkoo/Android-PickerView](https://github.com/Bigkoo/Android-PickerView)

## License

> License Copyright 2021 fuusy
> 
> Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at
> 
> http://www.apache.org/licenses/LICENSE-2.0
> 
> Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
