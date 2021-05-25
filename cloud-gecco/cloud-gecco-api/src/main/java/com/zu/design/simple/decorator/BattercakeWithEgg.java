package com.zu.design.simple.decorator;

/**
 * @Author zuyunbo
 * @Date 2021/5/8  5:05 下午
 **/
public class BattercakeWithEgg extends Battercake{

      @Override
      protected String  getMsg(){
          return super.getMsg()+"1个鸡蛋";
      }

      @Override
      public int getPrice(){
          return super.getPrice()+1;
      }


    public static void main(String[] args) {
          String s = "Retest_GWM_EC12_20210422_0943_A-0506.stpx";
        String str1=s.substring(s.indexOf("GWM_"));
        String substring = str1.substring(4, 8);

        System.out.println(substring);


    }

}
