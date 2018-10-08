package com.bwie.commoditypurchasecalculation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn_goumai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //1 找控件  进行点击事件监听
        final Button  btn_goumai = findViewById(R.id.btn_goumai);

        btn_goumai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ShopActivity.class);
                startActivity(intent);
            }
        });

    }
}
