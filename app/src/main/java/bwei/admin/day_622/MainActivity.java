package bwei.admin.day_622;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {
    private Data mData;
    Handler handler = new Handler() {



        @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                String urlpath = (String) msg.obj;
                Gson gson = new Gson();
                mData = gson.fromJson(urlpath, Data.class);
            }
        };

    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = (Button) findViewById(R.id.butt);
        new Thread(){
            @Override
            public void run() {
                HttpUtils url = new HttpUtils();
                String path = url.getData("http://v3.wufazhuce.com:8000/api/reading/index/?version=3.5.0&platform=android");
                Message msg = new Message();
                msg.obj = path;

            }
        }.start();
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,OneActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("name",mData);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}
