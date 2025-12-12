package org.example.MainCode.SQLIntepreter;

import org.example.MainCode.SQLIntepreter.DataTypes.DataTypeNode;
import org.example.MainCode.SQLIntepreter.Expression.*;
import org.example.MainCode.SQLIntepreter.Statements.SelectStatement;
import org.example.MainCode.SQLIntepreter.clauses.FromClause;
import org.example.MainCode.SQLIntepreter.clauses.SelectClause;
import org.example.MainCode.SQLIntepreter.clauses.WhereClause;

public class AstWalkerPrinter implements AstVisitor{
    @Override
    public Object visitSelectClause(SelectClause node) {
        return null;
    }

    @Override
    public Object visitFromClause(FromClause fromClause) {
        return null;
    }

    @Override
    public Object visitWhereClause(WhereClause whereClause) {
        return null;
    }

    @Override
    public Object visitDataTypeNode(DataTypeNode dataTypeNode) {
        return null;
    }

    @Override
    public Object visitBinaryExpressionNode(BinaryExpressionNode binaryExpressionNode) {
        return null;
    }

    @Override
    public Object visitNumberLiteralNode(NumberLiteralNode numberLiteralNode) {
        return null;
    }

    @Override
    public Object visitIdentifierExpressionNode(IdentifierExpressionNode identifierExpressionNode) {
        return null;
    }

    @Override
    public Object visitSelectStatement(SelectStatement selectStatement) {
        return null;
    }

    @Override
    public Object visitStringLiteralNode(StringLiteralNode stringLiteralNode) {
        return null;
    }

    @Override
    public Object visitColumnNode(ColumnNode columnNode) {
        return null;
    }

    @Override
    public void visitExpressionNode(ExpressionNode expressionNode) {

    }
}
