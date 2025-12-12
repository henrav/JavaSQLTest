package org.example.MainCode.SQLIntepreter.clauses;

import org.example.MainCode.SQLIntepreter.AstVisitor;
import org.example.MainCode.SQLIntepreter.Expression.TableNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FromClause extends Clause {

    List<TableNode> tables = new ArrayList<TableNode>();
    @Override
    public <R> R accept(AstVisitor<R> visitor) {
        return visitor.visitFromClause(this);
    }

    public void addTable(TableNode table){
        tables.add(table);
    }


    public List<TableNode> getTables() {
        return Collections.unmodifiableList(tables);
    }
    public FromClause(ArrayList<TableNode> tables){
        this.tables = tables;
    }

    public FromClause(){}



}
