package com.designpatterns.behavioral.interpreter;

public class InterpreterDemo {

    public static void main(String[] args) {

        /*
        * interpreter is a behavioral pattern
        * used to represent a grammar
        * map a domain or define some sort of tree
        * have some sort of recursive composition
        *
        * e.g. java.util.Format is an example where we are mapping %s to string
        * %d to double etc.
        *
        * Components are
        * - Expressions
        * - TerminalExpression / Non TerminalExpression
        * - Context
        * - Interpreter
        * */

        String context = "Lions";
        Expression define = buildExpressionTree();
        System.out.println(context  + " is " + define.interpret(context));

    }

    private static Expression buildExpressionTree() {

        Expression terminal1 = new TerminalExpression("Lions");
        Expression terminal2 = new TerminalExpression("Tigers");
        Expression terminal3 = new TerminalExpression("Bears");

        // (Tigers and Bears)
        Expression alternation1 = new AndExpression(terminal2, terminal3);

        // Lions or (Tigers and Bears)
        Expression alternation2 = new OrExpression(alternation1, terminal1);


        return alternation2;
    }
}
