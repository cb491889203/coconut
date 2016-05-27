package com.coconut.mywaterflow;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private ListView lv1;
    private ListView lv2;
    private ListView lv3;
    private MyAdapter adapter;
    private int[] ids = new int[]{R.drawable.a, R.drawable.b, R.drawable.c, R
            .drawable.d, R.drawable.e, R.drawable.f};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        lv1 = (ListView) findViewById(R.id.lv1);
        lv2 = (ListView) findViewById(R.id.lv2);
        lv3 = (ListView) findViewById(R.id.lv3);
        adapter = new MyAdapter();
        lv1.setAdapter(adapter);
        lv2.setAdapter(adapter);
        lv3.setAdapter(adapter);
    }


    private class MyAdapter extends BaseAdapter {

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView = null;
            if (convertView == null) {
                imageView = (ImageView) View.inflate(MainActivity.this, R
                        .layout.listview, null);
            } else {
                imageView = (ImageView) convertView;
            }
            int id = ids[(int) (Math.random() * 6)];
            imageView.setBackgroundResource(id);
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), id);
            float width = bitmap.getWidth();
            float height = bitmap.getHeight();
            float f = width / height;
            Log.i(TAG, "getView: width =" + bitmap.getWidth() + "-----  " +
                    "height =" + bitmap.getHeight());
            Log.i(TAG, "getView: f=" + f);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams
                    .WRAP_CONTENT, (int) (getWindowManager().getDefaultDisplay().getWidth() / 3 /
                    f)));
            return imageView;
        }

        @Override
        public int getCount() {
            return 5;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }
    }
}
