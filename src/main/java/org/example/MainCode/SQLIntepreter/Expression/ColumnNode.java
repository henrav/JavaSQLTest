package org.example.MainCode.SQLIntepreter.Expression;

import org.example.MainCode.SQLIntepreter.AcceptASTVisitor;
import org.example.MainCode.SQLIntepreter.AstVisitor;
import org.example.MainCode.SQLIntepreter.DataTypes.DataType;
import org.example.MainCode.SQLIntepreter.DataTypes.DataTypeNode;

import java.util.ArrayList;
import java.util.List;

public class ColumnNode implements AcceptASTVisitor {
    private List<DataTypeNode> children = new ArrayList<>();

    @Override
    public <R> R accept(AstVisitor<R> visitor) {
        return visitor.visitColumnNode(this);
    }
}
