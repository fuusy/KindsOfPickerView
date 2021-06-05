package com.fuusy.kindsofpickerview.callback;

import java.util.List;

/**
 * @author fuusy
 * @date：2021/6/5
 * @instruction： 点击确认时，多选模式的选中回调
 */
public interface OnOptionSelectMultipleListener {

    void onOptionsSelectMultiple(List<Integer> selectedList);

}
