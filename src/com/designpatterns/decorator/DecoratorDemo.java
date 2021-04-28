package com.designpatterns.decorator;

public class DecoratorDemo {

    public static void main(String[] args) {

        /*
        *
        * Decorator is structural pattern
        *
        * - add behavior without changing other parts
        * - also termed as wrapper
        * - more than just inheritance where we are overriding or doing some contract matching
        * - follows single responsibility principle
        * - e.g java io input stream classes
        * - constructor needs the component from hierarchy
        *
        * how to identify a decorator
        * - Decorator can be recognized by creation methods or constructor
        *    that accept objects of the same class or interface as a current class.
        * - Decorator looks similar to Builder but Builders don't take in same objects / interface
        * - You have a new decorator for every feature. e.g. say ISandwichDecorator
        *    RanchDressingDecorator, VignettesDressingDecorator, ItalianBreadDecorator
        *
        * how to build a decorator
        * Create an interface
        * Create concrete classes implementing the same interface.
        * Create an abstract decorator class implementing the above same interface.
        * Create a concrete decorator class extending the above abstract decorator class.
        * Now use the concrete decorator class created above to decorate interface objects.
        *
        * */
        Shape rectangle = new Rectangle();

        ShapeDecorator fillColorDecorator = new FillColorDecorator(rectangle, Color.BLUE);
        System.out.println(fillColorDecorator.description());

        Shape circle = new Circle();
        BorderColorDecorator bcd = new BorderColorDecorator(circle, LineStyle.BOLD_SOLID);

        System.out.println(bcd.description());

        // see how we passed a built decorator inside another decorator.
        // caveat here is each decorator takes care of just one business problem
        // here fillColorDecorator just fills the shape with a color
        // border color decorator just gives a border to shape it can either be a shape object or another decorator
        // this avoids a problem of building combination of classes that we would need if we did an interface method.
        // FillColor - just fills color
        // BorderShape - applies border to shape.
        // BorderFillColorClass - applies border and fills color <- we avoided this class because we can pass
        // a fillColor decorator to border shape and reuse it.
        bcd = new BorderColorDecorator(fillColorDecorator, LineStyle.BOLD_SOLID);

        System.out.println(bcd.description());

    }
}
