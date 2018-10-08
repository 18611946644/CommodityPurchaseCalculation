package com.bwie.commoditypurchasecalculation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class XiangQingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiang_qing);

        //购买完成界面
        //总金额界面
        TextView zprice = (TextView) findViewById(R.id.textView3);
        TextView znum = (TextView) findViewById(R.id.textView6);

        //响应 intent
        Intent intent = getIntent();

        //给总金额   和总数量   赋值
        zprice.setText(intent.getStringExtra("zprice"));
        // znum.setText(intent.getIntExtra("num", -1));

    }
}
