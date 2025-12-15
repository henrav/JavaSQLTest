package org.example.MainCode.SQLIntepreter.Expression.DataTypes;

import org.example.MainCode.SQLIntepreter.AstVisitor;
import org.example.MainCode.SQLIntepreter.Expression.Expression;
import org.example.MainCode.SQLIntepreter.Expression.SelectItem;

public class AllExpression extends SelectItem {
    public AllExpression(Expression expression, String alias) {
        super(expression, alias);
    }

    public AllExpression() {

    }

    @Override
    public <R> R accept(AstVisitor<R> visitor) {
        return null;
    }
}
