package com.parserc.study;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateText1 {

    public static void main(String[] args) {

        String s1 = "abcdefghijklmn";

        System.out.println();


        System.out.println(test_length(s2 -> s2.length() > 8, s1));
    }

    public static boolean test_length(Predicate<String> predicate, String str) {
        return predicate.test(str);
    }


}
