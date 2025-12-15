package org.example.MainCode.SQLIntepreter.Statements;

import org.example.MainCode.SQLIntepreter.AstVisitor;
import org.example.MainCode.SQLIntepreter.Expression.SelectItem;
import org.example.MainCode.SQLIntepreter.Expression.Expression;
import org.example.MainCode.SQLIntepreter.Expression.TableExpression;
import org.example.MainCode.SQLIntepreter.clauses.FromClause;

import java.util.ArrayList;
import java.util.List;

public class SelectStatement extends Statement {
    public List<SelectItem> columns = new ArrayList<>();
    public FromClause from;

    public void addColumn(SelectItem columnExpression){
        columns.add(columnExpression);
    }



    public Expression getWhere() {
        return where;
    }

    public void setWhere(Expression where) {
        this.where = where;
    }

    public  Expression where;

    public SelectStatement(){}

    @Override
    public <R> R accept(AstVisitor<R> visitor) {
        return visitor.visitSelectStatement(this);
    }
}
