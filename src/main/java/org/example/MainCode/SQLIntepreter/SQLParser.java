package org.example.MainCode.SQLIntepreter;

import org.example.MainCode.SQLIntepreter.Expression.*;
import org.example.MainCode.SQLIntepreter.Expression.Arithmetic.AdditionExpression;
import org.example.MainCode.SQLIntepreter.Expression.Arithmetic.SubtractionExpression;
import org.example.MainCode.SQLIntepreter.Expression.DataTypes.AllExpression;
import org.example.MainCode.SQLIntepreter.Expression.Logical.*;
import org.example.MainCode.SQLIntepreter.Statements.SelectStatement;
import org.example.MainCode.SQLIntepreter.Statements.Statement;
import org.example.MainCode.SQLIntepreter.clauses.FromClause;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SQLParser {
    private final List<Token> tokens;
    private int pos = 0;

    private List<Statement> query = new ArrayList<>();
    private List<Object> query2 = new ArrayList<>();

    public SQLParser(List<Token> tokens) {

        this.tokens = tokens;
    }

    public SQLParser(String string){
        this.tokens = new TokenGenerator(string).tokenize();
    }

    public void parse(){
        for (Token t:  tokens){
            System.out.println(t.text + " " + getStringType(t.type));
        }
    }

    public List<Statement> parseTwo(){
        while (pos < tokens.size()){
            query2.add(addNodes());
        }
        return null;
    }

    private Object addNodes() {
        Token t = peek();

        return switch (t.text.toUpperCase()) {
            case "SELECT" -> parseSelect();
            case "INSERT" -> parseInsert();
            case "UPDATE" -> parseUpdate();
            case "DELETE" -> parseDelete();
            default -> throw new RuntimeException("Unsupported statement keyword: " + t.text);
        };
    }

    private Object parseInsert() {
        return null;
    }

    private Object parseUpdate() {
        return null;
    }

    private Object parseDelete() {
        return null;
    }


    public SelectStatement parseSelect(){
        SelectStatement statement = new SelectStatement();
        statement.columns = parseSelectList();
        statement.from =  parseFromList();
        if (match(TokenType.WHERE)){
            statement.where = parseOr();
        }
        return statement;
    }


    Expression parseOr() {
        Expression left = parseAnd();
        while (check(TokenType.OPERATOR) && peek().text.equalsIgnoreCase("OR")) {
            consume();
            left = new OrExpression(left, parseAnd());
        }
        return left;
    }

    Expression parseAnd() {
        Expression left = getExpressionFromToken();
        while (check(TokenType.OPERATOR) && peek().text.equalsIgnoreCase("AND")) {
            consume();
            left = new AndExpression(left, getExpressionFromToken());
        }
        return left;
    }


    private Expression getExpressionFromToken() {
        Expression left = parseValue();

        Token t = expect(TokenType.OPERATOR);

        Expression right = parseValue();


        return switch (t.text) {
            case "=" -> new ComparisonExpression(left, right);
            case "+" -> new AdditionExpression(left, right);
            case "-" -> new SubtractionExpression(left, right);
            case "<" -> new LessThanExpression(left, right);
            case ">" -> new GreaterThanExpression(left, right);
            default -> throw new IllegalArgumentException("Unsupported operator: " + t.text);
        };
    }

    private Expression parseValue() {
        if (match(TokenType.NUMBER)) {
            return new NumberLiteralExpression(previous().text);
        }

        Token t = expect(TokenType.IDENTIFIER);

        if (match(TokenType.DOT)) {
            Token col = expect(TokenType.IDENTIFIER);
            return new ColumnExpression(t.text, col.text);
        }

        return new ColumnExpression(null, t.text);

    }

    public FromClause parseFromList(){
        expect(TokenType.FROM);
        FromClause fromClause = new FromClause();
        fromClause.tables = parseFromTables();
        if (match(TokenType.JOIN)){
            fromClause.joins = parseJoinTables();
        }
       return fromClause;
    }

    private List<JoinExpression> parseJoinTables() {


        return null;
    }

    private List<TableExpression> parseFromTables() {
        List<TableExpression> tables = new ArrayList<>();
        tables.add(parseTable());
        while (match(TokenType.COMMA)){
            tables.add(parseTable());
        }
        return tables;
    }


    private TableExpression parseTable() {
        Token name = expect(TokenType.IDENTIFIER);

        String alias = null;
        if (match(TokenType.ALIAS)) {
            alias = expect(TokenType.IDENTIFIER).text;
        }
        return new TableExpression(name.text, alias);
    }

    private List<SelectItem> parseSelectList() {
        expect(TokenType.SELECT);
        List<SelectItem> items = new ArrayList<>();
        items.add(parseSelectItem());
        while (match(TokenType.COMMA)){
            items.add(parseSelectItem());
        }
        return items;
    }
    private SelectItem parseSelectItem() {
        Expression expr = parseSelectExpr();
        String alias = parseOptionalAlias();
        return new SelectItem(expr, alias);
    }

    private String parseOptionalAlias() {
        if (match(TokenType.ALIAS)) {
            return expect(TokenType.IDENTIFIER).text;
        }
        return null;
    }


    private Expression parseSelectExpr() {
        if (match(TokenType.ALL)) {
            return new AllExpression();
        }

        Token t = expect(TokenType.IDENTIFIER);

        if (match(TokenType.LPAREN)) {
            List<Expression> args = new ArrayList<>();
            if (!match(TokenType.RPAREN)) {
                args.add(parseSelectExpr());
                while (match(TokenType.COMMA)) {
                    args.add(parseSelectExpr());
                }
                expect(TokenType.RPAREN);
            }
            return new FunctionCallExpression(t.text, args);
        }

        if (match(TokenType.DOT)) {
            Token col = expect(TokenType.IDENTIFIER);
            return new ColumnExpression(t.text, col.text);
        }
        return new ColumnExpression(null, t.text);
    }





    private boolean isAtEnd() {
        return pos >= tokens.size() || peek().type == TokenType.EOF;
    }


    /**
     *
     * @return token at current pos
     */
    private Token peek() {
        return (pos >= tokens.size()) ? null : tokens.get(pos);
    }
    private Token peekNext() { return (pos + 1 < tokens.size()) ? tokens.get(pos + 1) : tokens.get(tokens.size()-1); }
    private Token previous() { return tokens.get(pos - 1); }

    /**
     *
     * @return returns current tokens increases counter
     */
    private Token consume() {
        Token t = peek();
        if (t == null) throw new RuntimeException("Tried to consume past end of tokens");
        pos++;
        return t;
    }


    /**
     * check if current token == param token. if true, consumes current token returns true; if false, returns false;
     * @param type
     * @return true or false
     */
    private boolean match(TokenType type) {
        Token t = peek();
        if (t != null && t.type == type) {
            consume();
            return true;
        }
        return false;
    }

    /**
     * checks if current token == param token
     * @param type
     * @return true if param == current, false if param != current
     */
    private boolean check(TokenType type){
        Token t = peek();
        return t != null && t.type == type;
    }

    private boolean isClauseStart(Token t) {
        if (t == null) return false;
        return t.type == TokenType.FROM || t.type == TokenType.WHERE || t.type == TokenType.JOIN;
    }


    /**
     * checks if current token == param token. if true, then consume current token and pos ++;
     * @param types
     * @return next token
     */
    private Token expect(TokenType... types) {
        Token t = peek();
        if (t == null) throw new RuntimeException("Unexpected end of input");

        for (TokenType tt : types) {
            if (t.type == tt) return consume();
        }
        throw new RuntimeException("Unexpected token " + t + ", expected one of " + Arrays.toString(types));
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
            case LPAREN -> {
                return returnString + "Left parenthesis Token";
            }
            case RPAREN -> {
                return returnString + "Right parenthesis Token";
            }
            case ALIAS -> {
                return returnString + "Alias Token";
            }
            case DOT -> {
                return returnString + "Dot token";
            }
            case JOIN -> {
                return returnString + "Join Token";
            }
            default -> {
                throw new IllegalArgumentException("Unknown TokenType: " + type);
            }
        }
    }
}
