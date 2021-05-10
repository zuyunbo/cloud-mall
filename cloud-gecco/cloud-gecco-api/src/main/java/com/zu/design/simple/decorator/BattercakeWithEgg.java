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

}
