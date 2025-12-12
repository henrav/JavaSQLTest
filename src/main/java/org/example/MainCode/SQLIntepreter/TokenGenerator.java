package org.example.MainCode.SQLIntepreter;

import java.util.ArrayList;
import java.util.List;

public class TokenGenerator {
    private final String input;
    private int pos = 0;

    public TokenGenerator(String input){
        this.input = input;
    }

    public List<Token> tokenize(){
        List<Token> tokens = new ArrayList<>();
        Token t;
        do {
            t = nextToken();
            tokens.add(t);
        }while (t.type != TokenType.EOF);
        return tokens;
    }

    private Token nextToken() {
        skipWhiteSpace();
        if (pos >= input.length()) return new Token(TokenType.EOF, "");
        char c = input.charAt(pos);

        if (c == ',') { pos++; return new Token(TokenType.COMMA, ","); }
        if (c == '*') { pos++; return new Token(TokenType.ALL, "*"); }

        if (Character.isDigit(c)) return numberToken();
        if (c == '\'')   return stringToken();
        if (Character.isLetter(c) || c == '_') return identifierOrKeyword();
        if ("=<>!".indexOf(c) >= 0) {
            pos++;
            return new Token(TokenType.OPERATOR, String.valueOf(c));
        }
        pos++;
        return new Token(TokenType.IDENTIFIER, String.valueOf(c));
    }

    private Token identifierOrKeyword() {
        int start = pos;
        while (pos < input.length() && (Character.isLetterOrDigit(input.charAt(pos)) || input.charAt(pos) == '_')) pos++;
        String text = input.substring(start, pos);
        String upper = text.toUpperCase();
        return switch (upper) {
            case "SELECT" -> new Token(TokenType.SELECT, text);
            case "FROM" -> new Token(TokenType.FROM, text);
            case "WHERE" -> new Token(TokenType.WHERE, text);
            default -> new Token(TokenType.IDENTIFIER, text);
        };
    }

    private Token stringToken() {
        int start = pos;
        while (pos < input.length() && input.charAt(pos) != '\'') pos++;
        String text = input.substring(start, pos);
        return new Token(TokenType.STRING, text);
    }

    private Token numberToken() {
        int start = pos;
        while (pos < input.length() && (Character.isDigit(input.charAt(pos)) || input.charAt(pos) == '.')) pos++;
        String text = input.substring(start, pos);
        return new Token(TokenType.NUMBER, text);
    }

    private void skipWhiteSpace(){
        while (pos < input.length() && Character.isWhitespace(input.charAt(pos))) {
            pos++;
        }
    }
}
