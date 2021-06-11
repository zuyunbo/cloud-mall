package net.zu.rource;

import java.util.List;
import java.util.function.Function;

/**
 * @Author zuyunbo
 * @Date 2021/6/11  2:24 下午
 **/
public class IsstartWith {

    char[] value;


    public IsstartWith(char[] value) {
        this.value = value;
    }

    public static void main(String[] args) {

        IsstartWith l = new IsstartWith("abcsdi".toCharArray());

        boolean b = l.startsWiths(new IsstartWith("abc".toCharArray()), 0);
        System.out.println(b);
    }



    public boolean startsWiths(IsstartWith prefix , int toffset){
        char[] ta = value;

        int to = toffset;

        char[] pa = prefix.value;

        int po = 0;

        int pc = prefix.value.length;

        if((toffset < 0) || (toffset>value.length-pc)){
           return false;
        }
        while (--pc >= 0) {
            if (ta[to++] != pa[po++]) {
                return false;
            }
        }
        return true;
    }
}
