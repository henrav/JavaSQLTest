package org.example.MainCode.SQLIntepreter;

import java.util.ArrayList;
import java.util.List;

public  interface AcceptASTVisitor{
    public <R> R accept(AstVisitor<R> visitor);


}
