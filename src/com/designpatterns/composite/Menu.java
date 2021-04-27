package com.designpatterns.composite;

import java.util.Iterator;
import java.util.List;

public class Menu extends MenuComponent {

    public Menu(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public List<MenuComponent> addComponent(MenuComponent menuComponent) {
        this.menuComponentList.add(menuComponent);
        return this.menuComponentList;
    }

    public List<MenuComponent> removeComponent(MenuComponent menuComponent) {
        this.menuComponentList.remove(menuComponent);
        return this.menuComponentList;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(print(this));
        Iterator<MenuComponent> menuComponentIterator = this.menuComponentList.iterator();
        while(menuComponentIterator.hasNext()) {
            MenuComponent component = menuComponentIterator.next();
            sb.append("\t\t");
            sb.append(component.toString());
        }
        return sb.toString();
    }
}
