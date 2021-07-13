package com.pattern.parsing.lexer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Lexer {

    private static final List<Character> OPERATORS = Arrays.asList('+', '-', '*', '/');

    private static final List<Character> PARENS = Arrays.asList('(', ')');

    private static final HashMap<Character, TokenType> TOKEN_TYPES = new HashMap<Character, TokenType>() {
        {
            put('+', TokenType.PLUS);
            put('-', TokenType.MINUS);
            put('*', TokenType.TIMES);
            put('/', TokenType.DIVIDE);
            put('(', TokenType.LEFT_PAREN);
            put(')', TokenType.RIGHT_PAREN);
            put(',', TokenType.COMMA);
        }
    };

    public static final List<Character> SEPARATORS = Arrays.asList(',');

    private final String source;
    private int index = 0;

    public Lexer(String source) {
        this.source = source;
    }

    public List<Token> run(){
        List<Token> tokens = new ArrayList<>();
       return null;
    }

    private boolean EOF() {
        return index >= source.length();
    }






}
