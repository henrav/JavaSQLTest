package org.example.MainCode.SQLIntepreter.Statements;

import org.example.MainCode.SQLIntepreter.AstVisitor;
import org.example.MainCode.SQLIntepreter.Expression.ExpressionNode;
import org.example.MainCode.SQLIntepreter.Statements.Statement;

public class SelectStatement extends Statement {

    @Override
    public <R> R accept(AstVisitor<R> visitor) {
        return visitor.visitSelectStatement(this);
    }
}
