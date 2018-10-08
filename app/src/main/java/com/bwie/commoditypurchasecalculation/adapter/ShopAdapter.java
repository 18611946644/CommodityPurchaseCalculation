package com.bwie.commoditypurchasecalculation.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.commoditypurchasecalculation.R;
import com.bwie.commoditypurchasecalculation.bean.Shop;

import java.util.List;

/**
 * Created by DELL on 2018/10/7.
 */

public class ShopAdapter extends BaseAdapter {

    private Context context;
    private List<Shop> list;
    private TextView zprice;//代表总的价格

    public ShopAdapter(Context context, List<Shop> list, TextView zprice) {
        this.context = context;
        this.list = list;
        this.zprice = zprice;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if(convertView==null){

            convertView = View.inflate(context, R.layout.item_shop, null);
            holder = new ViewHolder();
            holder.shangtu = (ImageView) convertView.findViewById(R.id.shangtu);
            holder.shangname = (TextView) convertView.findViewById(R.id.shangname);
            holder.jiage = (TextView) convertView.findViewById(R.id.jiage);
            holder.shangprice = (TextView) convertView.findViewById(R.id.shangprice);
            holder.check = (CheckBox) convertView.findViewById(R.id.check);

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }


        holder.shangtu.setImageResource(list.get(position).getImg());
        holder.shangname.setText(list.get(position).getName());
        holder.jiage.setText(list.get(position).getTjiage());
        holder.shangprice.setText(""+list.get(position).getPrice());
        holder.check.setChecked(list.get(position).isCheck());//多选框

        //为所有多选框设置点击事件
        holder.check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击后   设置一个变量  用来记录选框是  选中状态的时候
                Boolean ischeck = holder.check.isChecked();
                //将选框设置为默认选中状态
                list.get(position).setCheck(ischeck);
                //当选框是选中状态是  执行一个加法
                jia();
                //刷新
                notifyDataSetChanged();
            }

            //选框设置为选中时  执行的加法
            //定义一个变量用来表示总的价格
            int money=0;
            private void jia() {
                //循环遍历所有复选框
                for (int i = 0; i <list.size() ; i++) {
                    //判断选中的复选框
                    if(list.get(i).isCheck()){//如果选中了
                       //就进行加
                        money+=list.get(position).getPrice();
                    }
                }
                //将得到的总价  重新赋值
                //注意  如果赋值直接为money则会报错  所以必须加上文本格式赋值即加上+“”
                zprice.setText(money+"");
            }

        });

        return convertView;
    }


    class ViewHolder{
        TextView shangname;
        TextView jiage;
        ImageView shangtu;
        CheckBox check;
        TextView shangprice;
    }

}
