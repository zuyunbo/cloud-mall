package com.example.parzering.lex;

import com.example.parzering.parser.Token;
import org.yaml.snakeyaml.util.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author zuyunbo
 * @Date 2021/8/21  4:53 下午
 **/
public class scanner {

    private static List<String> OPERATOR = Arrays.asList("+", "-", "*", "/");

    int index = 0;

    String source;


    public scanner(String source) {
        this.source = source;
    }

    public List<Token> run() {
        List<Token> tokens = new ArrayList<>();
        while (EOF()) {
            tokens.add(nextToken());
        }
        return tokens;
    }

    public Token nextToken() {

        if (EOF() && Character.isDigit(currently())){

        }

        return null;
    }


    public char currently() {
        if (EOF()) {
            return source.charAt(index);
        }
        return ' ';
    }

    public boolean EOF() {
        return index < source.length();
    }


}
