package com.designpatterns.behavioral.interpreter;

public class OrExpression implements Expression {

    private Expression exprA;
    private Expression exprB;

    public OrExpression(Expression expressionA, Expression expressionB) {
        this.exprA = expressionA;
        this.exprB = expressionB;
    }

    @Override
    public boolean interpret(String str) {
        return this.exprA.interpret(str) || this.exprB.interpret(str);
    }
}
