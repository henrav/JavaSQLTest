package org.example.MainCode.SQLIntepreter.Expression;

import org.example.MainCode.SQLIntepreter.AcceptASTVisitor;
import org.example.MainCode.SQLIntepreter.AstVisitor;
import org.example.MainCode.SQLIntepreter.DataTypes.DataTypeNode;

import java.util.ArrayList;
import java.util.List;

public class SelectItem extends Expression implements AcceptASTVisitor {

    public Expression expression;
    public String Alias;

    public SelectItem(Expression expression, String alias) {
        this.expression = expression;
        this.Alias = alias;
    }

    public SelectItem() {
    }
    public SelectItem(Expression expression) {
        this.expression = expression;

    }


    @Override
    public <R> R accept(AstVisitor<R> visitor) {
        return visitor.visitColumnNode(this);
    }
}
