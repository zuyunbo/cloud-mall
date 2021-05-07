package com.pattern.template;

public class PowerAdapter implements DC5{

    private AC220 ac220;

    public PowerAdapter(AC220 ac220) {
        this.ac220 = ac220;
    }

    @Override
    public int outputDC5V() {
        int adapterInput = ac220.output220v();
        int adapterOut = adapterInput/44;
        System.out.println("使用PowerAdapter输入AC"+adapterInput + "V" + "输出DC" + adapterOut+ "V");
        return adapterOut;
    }
}
