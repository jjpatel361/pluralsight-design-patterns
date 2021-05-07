package com.designpatterns.behavioral.interpreter;

import java.util.StringTokenizer;

public class TerminalExpression implements Expression {

    private String data;

    public TerminalExpression(String data) {
        this.data = data;
    }

    @Override
    public boolean interpret(String str) {
        StringTokenizer strTokenizer = new StringTokenizer(str);

        while(strTokenizer.hasMoreTokens()) {
            String test = strTokenizer.nextToken();
            if(test.equals(data)) {
                return true;
            }
        }

        return false;
    }
}
