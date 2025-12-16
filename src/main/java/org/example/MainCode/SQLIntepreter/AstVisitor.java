package org.example.MainCode.SQLIntepreter;

import org.example.MainCode.SQLIntepreter.DataTypes.DataTypeNode;
import org.example.MainCode.SQLIntepreter.Expression.*;
import org.example.MainCode.SQLIntepreter.Expression.Arithmetic.AdditionExpression;
import org.example.MainCode.SQLIntepreter.Expression.Arithmetic.SubtractionExpression;
import org.example.MainCode.SQLIntepreter.Expression.Logical.*;
import org.example.MainCode.SQLIntepreter.Statements.SelectStatement;
import org.example.MainCode.SQLIntepreter.clauses.FromClause;

public interface AstVisitor<R> {


    R visitFromClause(FromClause fromClause);

    R visitWhereClause(WhereExpression whereClause);

    R visitDataTypeNode(DataTypeNode dataTypeNode);

    R visitBinaryExpressionNode(BinaryExpression binaryExpressionNode);


    R visitNumberLiteralNode(NumberLiteralExpression numberLiteralNode);

    R visitIdentifierExpressionNode(IdentifierExpression identifierExpressionNode);

    R visitSelectStatement(SelectStatement selectStatement);

    R visitStringLiteralNode(StringLiteralExpression stringLiteral);

    R visitColumnNode(SelectItem columnNode);


    R visitAdditionExpressionNode(AdditionExpression additionExpressionNode);

    R visitSubtractionExpressionNode(SubtractionExpression subtractionExpressionNode);

    R visitAndExpression(AndExpression andExpression);

    R visitOrExpression(OrExpression orExpression);

    R visitGreaterThanExpression(GreaterThanExpression greaterThanExpression);

    R visitLessThanExpression(LessThanExpression lessThanExpression);

    R visitComparisonExpression(ComparisonExpression comparisonExpression);
}
