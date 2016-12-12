package com.qttx.mydemotest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    /*五角星评价系统*/
    private double number = 9.0; //后台返回的评价的分数
    private double totalNumber = 10.0;//总的分数
    private LinearLayout ll_proportion;//需要设置的长度
    private LinearLayout ll_with_blank;//底部透明的长度
    private double ll_proportion_size; //需要设置的长度
    private int ll_with_blank_size;//底部透明的长度




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ll_proportion = (LinearLayout) findViewById(R.id.ll_proportion);
        ll_with_blank = (LinearLayout) findViewById(R.id.ll_with_blank);
        setPropertion(number);

    }

    private void setPropertion(double number) {
        /*根据比例来设置ll_proportion的长度
        * number/totalNumber(总的分数) = ll_proportion(需要设置的顶部的长度)/ll_with_blank（底部透明的长度）//注意的是 布局长度上顶部和底部的布局要一模一样
        *
        * */
        ViewGroup.LayoutParams ll_with_blankParams = ll_with_blank.getLayoutParams();//得到底部空白的长度
        ll_with_blank_size=ll_with_blankParams.width;
        ll_proportion_size = (double) ((number / totalNumber) * ll_with_blank_size);
        ViewGroup.LayoutParams layoutParams  = ll_proportion.getLayoutParams();
        layoutParams.width = (int) ll_proportion_size;
        ll_proportion.setLayoutParams(layoutParams);
    }
}
