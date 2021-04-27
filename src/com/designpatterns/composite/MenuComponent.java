package com.designpatterns.composite;

import java.util.ArrayList;
import java.util.List;

public abstract class MenuComponent {

    String name;
    String url;
    List<MenuComponent> menuComponentList = new ArrayList<MenuComponent>();

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String print(MenuComponent menuComponent) {
        StringBuilder sb = new StringBuilder();
        sb.append(menuComponent.getName());
        sb.append(":");
        sb.append(menuComponent.getUrl());
        sb.append("\n");
        return sb.toString();
    };

    public abstract String toString();
}
