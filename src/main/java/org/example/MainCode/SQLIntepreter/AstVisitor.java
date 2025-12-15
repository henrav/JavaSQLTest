package org.example.MainCode.SQLIntepreter;

import org.example.MainCode.SQLIntepreter.DataTypes.DataTypeNode;
import org.example.MainCode.SQLIntepreter.Expression.*;
import org.example.MainCode.SQLIntepreter.Expression.Arithmetic.AdditionExpressionNode;
import org.example.MainCode.SQLIntepreter.Expression.Arithmetic.SubtractionExpressionNode;
import org.example.MainCode.SQLIntepreter.Statements.SelectStatement;
import org.example.MainCode.SQLIntepreter.clauses.FromClause;
import org.example.MainCode.SQLIntepreter.clauses.SelectClause;
import org.example.MainCode.SQLIntepreter.clauses.WhereClause;

public interface AstVisitor<R> {
    R visitSelectClause(SelectClause node);

    R visitFromClause(FromClause fromClause);

    R visitWhereClause(WhereClause whereClause);

    R visitDataTypeNode(DataTypeNode dataTypeNode);

    R visitBinaryExpressionNode(BinaryExpressionNode binaryExpressionNode);


    R visitNumberLiteralNode(NumberLiteralNode numberLiteralNode);

    R visitIdentifierExpressionNode(IdentifierExpressionNode identifierExpressionNode);

    R visitSelectStatement(SelectStatement selectStatement);

    R visitStringLiteralNode(StringLiteralNode stringLiteralNode);

    R visitColumnNode(ColumnNode columnNode);


    R visitAdditionExpressionNode(AdditionExpressionNode additionExpressionNode);

    R visitSubtractionExpressionNode(SubtractionExpressionNode subtractionExpressionNode);
}
