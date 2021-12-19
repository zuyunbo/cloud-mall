package com.cloud.service.controller;

public class day01 {


    public static void main(String[] args) {


        int[] nums = new int[]{1,3};

        int[] nums1 = new int[]{2};

        int  i =  (nums.length + nums1.length)/2;
        double s = (nums[i-1] + nums[i-2]) / 2;



        System.out.println(s);



    }

}
