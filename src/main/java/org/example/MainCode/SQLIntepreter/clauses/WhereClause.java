package org.example.MainCode.SQLIntepreter.clauses;

import org.example.MainCode.SQLIntepreter.AstVisitor;
import org.example.MainCode.SQLIntepreter.Expression.ExpressionNode;
import org.example.MainCode.SQLIntepreter.SQLParser;
import org.example.MainCode.SQLIntepreter.Token;

import java.util.ArrayList;
import java.util.List;

public class WhereClause extends Clause {

    private List<ExpressionNode> expressionNodes = new ArrayList<>();

    @Override
    public <R> R accept(AstVisitor<R> visitor) {
        return visitor.visitWhereClause(this);
    }

    public void addChild(ExpressionNode node){
        this.expressionNodes.add(node);
    }
}
