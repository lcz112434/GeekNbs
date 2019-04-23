package com.lcz.geek.CallBackss;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

/**
 * Created by 李承泽 on 2019/4/19.
 */
public class SimepleTouchCallBack extends ItemTouchHelper.Callback {
    private final TouchCallBack mcallback;
    boolean swienable = true;

    public void setSwienable(boolean swienable) {
        this.swienable = swienable;
    }

    public SimepleTouchCallBack(TouchCallBack callBack) {
        mcallback = callBack;
    }

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        //允许上下滑动
        int drag = ItemTouchHelper.DOWN | ItemTouchHelper.UP;
        //允许向左滑动
        int swipe = ItemTouchHelper.LEFT;

        return makeMovementFlags(drag, swipe);
    }

    /**
     * 拖动item时回调，可以调用Adapter的notifyItemMoved方法来交换两个ViewHolder的位置，
     * 最后返回true，表示被拖动的ViewHolder已经移动到了目的位置
     *
     * @param recyclerView
     * @param viewHolder
     * @param target
     * @return
     */
    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder,
                          RecyclerView.ViewHolder target) {
        mcallback.onItemMove(viewHolder.getAdapterPosition(), target.getAdapterPosition());
        return true;
    }

    /**
     * 当用户左右滑动item时达到删除条件就会调用,一般为一半,条目继续滑动删除,否则弹回
     *
     * @param viewHolder
     * @param direction
     */
    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        mcallback.onItemDelete(viewHolder.getAdapterPosition());
    }

    /**
     * 支持长按拖动,默认是true
     *
     * @return
     */
    @Override
    public boolean isLongPressDragEnabled() {
        return super.isLongPressDragEnabled();
    }

    //支持滑动 既调到onSwiped方法 默认true
    @Override
    public boolean isItemViewSwipeEnabled() {
        return super.isItemViewSwipeEnabled();
    }
}
