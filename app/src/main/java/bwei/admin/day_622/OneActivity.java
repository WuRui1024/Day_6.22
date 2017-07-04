package bwei.admin.day_622;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * 类描述：
 * 创建人：WuRui
 * 创建时间：2017/6/22 20:30
 */
public class OneActivity extends AppCompatActivity {

    private ListView mListview;
    private Data mDdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.one);
        TextView text = (TextView) findViewById(R.id.text2);
        mListview = (ListView) findViewById(R.id.listview);
        Intent intent=this.getIntent();
        Bundle bundle=intent.getExtras();
        mDdd = (Data) bundle.getSerializable("name");
        mListview.setAdapter(new Base());
    }
    class Base extends BaseAdapter{

        @Override
        public int getCount() {
            return mDdd.getData().getQuestion().size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = View.inflate(OneActivity.this,R.layout.item,null);

            return convertView;
        }
    }
}
