package me.lt21.learning.topsnaprecyclerviewdemo;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;

/**
 * Created by LT21 on 2017/12/28.
 */

public class TopSnapLayoutManager extends LinearLayoutManager {

    public TopSnapLayoutManager(Context context) {
        super(context);
    }

    public TopSnapLayoutManager(Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
    }

    @Override
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {
        TopSnapSmoothScroller testSmoothScroller =
                new TopSnapSmoothScroller(recyclerView.getContext());
        testSmoothScroller.setTargetPosition(position);
        startSmoothScroll(testSmoothScroller);
    }

    public class TopSnapSmoothScroller extends LinearSmoothScroller {

        public TopSnapSmoothScroller(Context context) {
            super(context);
        }

        /**
         * When scrolling towards a child view, this method defines we should align
         * child view's left with the parent RecyclerView's left.
         *
         * @return SNAP_TO_START
         * @see #SNAP_TO_START
         * @see #SNAP_TO_END
         * @see #SNAP_TO_ANY
         */
        @Override
        protected int getHorizontalSnapPreference() {
            return SNAP_TO_START;
        }

        /**
         * When scrolling towards a child view, this method defines we should align
         * child view's top with the parent RecyclerView's top.
         *
         * @return SNAP_TO_START
         * @see #SNAP_TO_START
         * @see #SNAP_TO_END
         * @see #SNAP_TO_ANY
         */
        @Override
        protected int getVerticalSnapPreference() {
            return SNAP_TO_START;
        }
    }

}
