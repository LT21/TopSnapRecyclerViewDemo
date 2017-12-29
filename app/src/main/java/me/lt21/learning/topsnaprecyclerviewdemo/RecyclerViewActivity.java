package me.lt21.learning.topsnaprecyclerviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class RecyclerViewActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    TestAdapter testAdapter;
    EditText editText;
    public static final int size = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        recyclerView = findViewById(R.id.recycler_view);
        editText = findViewById(R.id.edit_text);

        testAdapter = new TestAdapter(recyclerView);
        recyclerView.setLayoutManager(new TopSnapLayoutManager(this));
        recyclerView.setAdapter(testAdapter);

    }

    private int getTargetPosition() {
        String positionString = editText.getText().toString();
        int position = 0;
        if (!TextUtils.isEmpty(positionString)) {
            int p = Integer.parseInt(positionString);
            if (p > size) {
                position = size - 1;
                editText.setText(Integer.toString(size - 1));
            } else if (p > 0) {
                position = p;
            } else {
                editText.setText(Integer.toString(0));
            }
        }
        return position;
    }

    public void scroll(View view) {
        // recyclerView.scrollToPosition(getTargetPosition());
        recyclerView.stopScroll();
        ((LinearLayoutManager) recyclerView.getLayoutManager()).scrollToPositionWithOffset(getTargetPosition(), 0);
    }

    public void smoothScroll(View view) {
        recyclerView.smoothScrollToPosition(getTargetPosition());
    }
}
