package org.example.MainCode.SQLIntepreter;

import org.example.MainCode.SQLIntepreter.Statements.SelectStatement;
import org.example.MainCode.SQLIntepreter.Statements.Statement;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SQLParser {
    private final List<Token> tokens;
    private int pos = 0;

    private List<Statement> query = new ArrayList<>();
    private List<Objects> query2 = new ArrayList<>();

    public SQLParser(List<Token> tokens) {
        this.tokens = tokens;
    }

    public void parse(){
        for (Token t:  tokens){
            System.out.println(t.text + " " + getStringType(t.type));
        }
    }

    public List<Statement> parseTwo(){
        while (pos < tokens.size()){
            addNodes();
        }
        return null;
    }

    private void addNodes() {
        Token t = tokens.get(pos);
        while (true){

        }


    }

    public SelectStatement parseSelect(){

        return null;
    }



    private Token consume(){
        Token t = peek();
        pos++;
        return t;
    }


    private Token expect(List<TokenType> tokenTypes){
        Token t = peek();
        for (TokenType token: tokenTypes){
            if (t.type == token){
                return consume();
            }
        }
        throw new RuntimeException("Unexpected tokentype, found:  " + t);
    }





    private Token expect(TokenType tokenType) {
        Token t = peek();
        if (t.type != tokenType){
            throw new RuntimeException("Expected " + tokenType + " but found " + t);
        }
        return consume();
    }

    private Token peek(){
        if (pos + 1 >= tokens.size()) return tokens.get(tokens.size() - 1);
        return tokens.get(pos + 1);
    }

    public static String getStringType(TokenType type) {
        String returnString = "\t\t";
        switch (type) {
            case SELECT -> {
                return returnString + "Select Token";
            }
            case FROM -> {
                return returnString + "From Token";
            }
            case WHERE -> {
                return returnString + "Where Token";
            }
            case IDENTIFIER -> {
                return returnString + "Identifier Token";
            }
            case COMMA -> {
                return returnString + "Comma Token";
            }
            case ALL -> {
                return returnString + "All Token";
            }
            case NUMBER -> {
                return returnString + "Number Token";
            }
            case STRING -> {
                return returnString + "String Token";
            }
            case OPERATOR -> {
                return returnString + "Operator Token";
            }
            case EOF -> {
                return returnString + "End Of Sentence Token";
            }
            default -> {
                throw new IllegalArgumentException("Unknown TokenType: " + type);
            }
        }
    }
}
