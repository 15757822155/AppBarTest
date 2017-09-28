package com.yang.appbartest;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView rvMain;
    AppBarLayout appBar;
    RvAdapter mAdapter;
    List<RvAdapter.Student> mList;
    ImageView ivMain;
    private ViewGroup.LayoutParams mParams;
    private int mWidth = 1080;
    private int mHeight = 720;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        appBar = (AppBarLayout) findViewById(R.id.appBar);
        ivMain = (ImageView) findViewById(R.id.ivMain);
        rvMain = (RecyclerView) findViewById(R.id.rvMain);
        ivMain.post(new Runnable() {
            @Override
            public void run() {
//                mWidth = ivMain.getWidth();
//                mHeight = ivMain.getHeight();
                Log.i(TAG, "run: width" + mWidth);
                Log.i(TAG, "run: height----------" + mHeight);
            }
        });
        mList = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            RvAdapter.Student student = new RvAdapter.Student();
            student.setName("杨再光" + i + 1 + "号");
            student.setNum(i + 1 + "号");
            mList.add(student);
        }
        mAdapter = new RvAdapter(this);
        mAdapter.setList(mList);
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        rvMain.setLayoutManager(manager);
        rvMain.setAdapter(mAdapter);
        mParams = ivMain.getLayoutParams();

        appBar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                Log.i(TAG, "onOffsetChanged: " + verticalOffset);
                mParams.height = mHeight + verticalOffset;
                mParams.width = (mHeight +verticalOffset) * mWidth / mHeight;
                ivMain.setLayoutParams(mParams);
            }
        });
    }
}
