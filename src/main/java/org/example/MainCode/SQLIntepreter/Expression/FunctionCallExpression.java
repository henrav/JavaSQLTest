package org.example.MainCode.SQLIntepreter.Expression;

import org.example.MainCode.SQLIntepreter.AstVisitor;

import java.util.List;

public class FunctionCallExpression extends Expression{

    public String funcName;
    public List<Expression> args;

    public FunctionCallExpression(String text, List<Expression> args) {
        this.funcName = text;
        this.args = args;
    }

    @Override
    public <R> R accept(AstVisitor<R> visitor) {
        return null;
    }
}
