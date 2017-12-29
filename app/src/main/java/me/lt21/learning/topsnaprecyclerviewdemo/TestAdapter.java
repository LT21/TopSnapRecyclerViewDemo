package me.lt21.learning.topsnaprecyclerviewdemo;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import static me.lt21.learning.topsnaprecyclerviewdemo.RecyclerViewActivity.size;

/**
 * Created by LT21 on 2017/12/28.
 */

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.TestViewHolder> {

    RecyclerView recyclerView;

    public TestAdapter(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }

    @Override
    public TestViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TextView tv = new TextView(parent.getContext());
        tv.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        TestViewHolder holder = new TestViewHolder(tv);
        return holder;
    }

    @Override
    public void onBindViewHolder(TestViewHolder holder, int position) {
        holder.bindTestView(position);
    }

    @Override
    public int getItemCount() {
        return size;
    }

    public class TestViewHolder extends RecyclerView.ViewHolder {

        TextView tv;

        public TestViewHolder(View itemView) {
            super(itemView);
        }

        public void bindTestView(int position) {
            tv = (TextView) itemView.getRootView();
            tv.setText(Integer.toString(position));
        }
    }
}
