package com.yldz;

public class Tom {

   public void study(ICourse1 course1){
       course1.study();
   }

    public static void main(String[] args) {

        Tom tom = new Tom();
        tom.study(new PythonCourse());
        tom.study(new JavaCourse());


    }

}
