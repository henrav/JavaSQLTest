package org.example.MainCode.SQLIntepreter.DataTypes;


import org.example.MainCode.SQLIntepreter.AcceptASTVisitor;
import org.example.MainCode.SQLIntepreter.AstVisitor;

import java.util.List;

public class DataTypeNode implements AcceptASTVisitor {


    @Override
    public <R> R accept(AstVisitor<R> visitor) {
        return visitor.visitDataTypeNode(this);
    }

    public enum Kind { STRING, INT, FLOAT, BOOL }
    private final Kind kind;
    public DataTypeNode(Kind kind) { this.kind = kind; }
    public Kind getKind() { return kind; }
}
