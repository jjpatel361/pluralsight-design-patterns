package com.designpatterns.behavioral.interpreter;

public class AndExpression implements Expression {

    private Expression exprA;
    private Expression exprB;

    public AndExpression(Expression terminalA, Expression terminalB) {
        exprA = terminalA;
        exprB = terminalB;
    }

    @Override
    public boolean interpret(String context) {
        return exprA.interpret(context) && exprB.interpret(context);
    }
}
