package org.example.MainCode.SQLIntepreter.clauses;

import org.example.MainCode.SQLIntepreter.AstVisitor;
import org.example.MainCode.SQLIntepreter.Expression.JoinExpression;
import org.example.MainCode.SQLIntepreter.Expression.TableExpression;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FromClause extends Clause {

    public List<TableExpression> tables = new ArrayList<TableExpression>();
    public List<JoinExpression> joins = new ArrayList<>();
    @Override
    public <R> R accept(AstVisitor<R> visitor) {
        return visitor.visitFromClause(this);
    }

    public void addTable(TableExpression table){
        tables.add(table);
    }


    public List<TableExpression> getTables() {
        return Collections.unmodifiableList(tables);
    }
    public FromClause(ArrayList<TableExpression> tables){
        this.tables = tables;
    }

    public FromClause(){}



}
