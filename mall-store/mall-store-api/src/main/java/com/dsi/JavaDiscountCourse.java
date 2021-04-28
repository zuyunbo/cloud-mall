package com.dsi;


// 继承父类的属性值
public class JavaDiscountCourse extends JavaCourse{
    public JavaDiscountCourse(Integer id, String name, Double price) {
        super(id, name, price);
    }

    public Double getOriginPrice(){
        return super.getPrice();
    }

    public Double getPrice(){
        return super.getPrice() * 0.61;
    }


}
