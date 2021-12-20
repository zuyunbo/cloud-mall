package com.parserc.study;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateText {

    public static void main(String[] args) {
        List<String> name = Arrays.asList("Adam","Alexander","John","Tom");

        Predicate<String> predicate = s -> s.startsWith("J");

        Predicate<String> predicate1 = s1 -> s1.length() < 5;



        List<String> a = name.stream().filter(predicate.and(predicate1)).collect(Collectors.toList());

        for (String s : a) {
            System.out.println(a);
        }
    }


}
