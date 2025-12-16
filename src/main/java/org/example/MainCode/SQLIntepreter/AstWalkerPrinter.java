package org.example.MainCode.SQLIntepreter;

import org.example.MainCode.SQLIntepreter.DataTypes.DataTypeNode;
import org.example.MainCode.SQLIntepreter.Expression.*;
import org.example.MainCode.SQLIntepreter.Expression.Arithmetic.AdditionExpression;
import org.example.MainCode.SQLIntepreter.Expression.Arithmetic.SubtractionExpression;
import org.example.MainCode.SQLIntepreter.Expression.Logical.*;
import org.example.MainCode.SQLIntepreter.Statements.SelectStatement;
import org.example.MainCode.SQLIntepreter.clauses.FromClause;

public class AstWalkerPrinter implements AstVisitor{




    @Override
    public Object visitFromClause(FromClause fromClause) {
        return null;
    }

    @Override
    public Object visitWhereClause(WhereExpression whereClause) {
        return null;
    }

    @Override
    public Object visitDataTypeNode(DataTypeNode dataTypeNode) {
        return null;
    }

    @Override
    public Object visitBinaryExpressionNode(BinaryExpression binaryExpressionNode) {
        return null;
    }

    @Override
    public Object visitNumberLiteralNode(NumberLiteralExpression numberLiteralNode) {
        return null;
    }

    @Override
    public Object visitIdentifierExpressionNode(IdentifierExpression identifierExpressionNode) {
        return null;
    }

    @Override
    public Object visitSelectStatement(SelectStatement selectStatement) {
        return null;
    }

    @Override
    public Object visitStringLiteralNode(StringLiteralExpression stringLiteralNode) {
        return null;
    }

    @Override
    public Object visitColumnNode(SelectItem columnNode) {
        return null;
    }


    @Override
    public Object visitAdditionExpressionNode(AdditionExpression additionExpressionNode) {
        return null;
    }

    @Override
    public Object visitSubtractionExpressionNode(SubtractionExpression subtractionExpressionNode) {
        return null;
    }

    @Override
    public Object visitAndExpression(AndExpression andExpression) {
        return null;
    }

    @Override
    public Object visitOrExpression(OrExpression orExpression) {
        return null;
    }

    @Override
    public Object visitGreaterThanExpression(GreaterThanExpression greaterThanExpression) {
        return null;
    }

    @Override
    public Object visitLessThanExpression(LessThanExpression lessThanExpression) {
        return null;
    }

    @Override
    public Object visitComparisonExpression(ComparisonExpression comparisonExpression) {
        return null;
    }
}
