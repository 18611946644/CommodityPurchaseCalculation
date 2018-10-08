package com.bwie.commoditypurchasecalculation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.commoditypurchasecalculation.adapter.ShopAdapter;
import com.bwie.commoditypurchasecalculation.bean.Shop;

import java.util.ArrayList;

public class ShopActivity extends AppCompatActivity {

    private ArrayList<Shop> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        //1
        ListView listview = (ListView) findViewById(R.id.listview);
        final TextView zprice = (TextView) findViewById(R.id.zprice);
        Button Bgoumai = (Button) findViewById(R.id.goumai);

        //2 定义一个集合 参数为封装商品的类
        list = new ArrayList<>();
        //3 自动添加
        for (int i = 0; i < 5; i++) {
            list.add(new Shop(R.drawable.aa,"商品名称"+i,"价格",100,false));
        }
        //4 创建适配器
        ShopAdapter adapter = new ShopAdapter(this,list,zprice);
        //5 添加适配器
        listview.setAdapter(adapter);

        //6 为多选框设置一个选中事件
        Bgoumai.setOnClickListener(new View.OnClickListener() {
            int num=0;//数量购买
            @Override
            public void onClick(View v) {
//点击跳转   并传值
                for (int i = 0; i < list.size(); i++) {
                    //单个判断是否选中
                    if(list.get(i).isCheck()){//如果选中 就实现累加
                        num++;//数量加1
                    }
                }
                if(num==0){
                    //说明没有选中的   提示
                    Toast.makeText(ShopActivity.this, "请选中后再进行购买！", Toast.LENGTH_LONG).show();
                }else{
                    //进行跳转
                    Intent intent = new Intent(ShopActivity.this,XiangQingActivity.class);

                    //跳转   并传输数据
                    intent.putExtra("zprice", zprice.getText().toString());
                    intent.putExtra("num", num);
                    startActivity(intent);
                }
            }
        });

    }
}
