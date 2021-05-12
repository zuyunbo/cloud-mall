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

          String s = "005056B089C11EEBA48DD085FE73D9C9_210329CDX95";
        String substring = s.substring(0, 32);
        System.out.println(substring);


    }

}
