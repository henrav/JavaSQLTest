package org.example.MainCode.SQLIntepreter.clauses;

import org.example.MainCode.SQLIntepreter.AstVisitor;
import org.example.MainCode.SQLIntepreter.Expression.ColumnNode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SelectClause extends Clause {
    private List<ColumnNode> columns = new ArrayList<>();

    public SelectClause(){}

    public SelectClause(List<ColumnNode> columns){
        this.columns = columns;
    }

    public void addColumn(ColumnNode column) {
        columns.add(column);
    }

    public List<ColumnNode> getColumns() {
      return   Collections.unmodifiableList(columns);
    }

    @Override
    public <R> R accept(AstVisitor<R> visitor) {
        return visitor.visitSelectClause(this);
    }
}