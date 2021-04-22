package com.designpatterns.abstractfactory;

public class AbstractFactoryDemo {

    public static void main(String[] args) {

        /*
        * abstract factory pattern
        *
        * - a higher level of abstraction on top of factory class
        * - factory method returns a concrete class
        * - abstract factory returns an implementation which later returns a concrete class.
        *
        * observations
        *
        * - the implementation below hides all the details of what factory is used to get which card
        * - you can get gold / platinum card either from amex or visa
        * - the business logic is common of all types of card
        * - when you have multiple layers of card you can use abstract factory method
        *
        * abstract factory is nice way to expose an existing factory when
        * examples
        * - you want the object to decide which factory is best for you to use
        *       - e.g. say file reading based on underlying OS you want the correct reader factory presented
        * - when there is conditional business logic
        *   in this case - if credit card > 750 then use AMEX card for any transaction.
        *   else give him a conventional visa factory
        * - tenanted database ?
        *   there are customers who want DB entries in their dedicated instances
        *   - give me a db factory for this client
        *
        *
        * pitfalls
        * - complex - really a lot of classes are needed to get things done
        * - pattern within a pattern - factory returning another factory.
        * - usually starts with a factory and then is moved into an abstract factory
        *   don't start off with an abstract factory!! let it evolve.
        * */
        CreditCardFactory cf = CreditCardFactory.getCreditCardFactory(740);
        CreditCard goldCreditCard = cf.getCreditCard(CardType.GOLD);
        System.out.println(goldCreditCard.getClass()); // returns a VisaGoldCreditCard

        CreditCardFactory cf2 = CreditCardFactory.getCreditCardFactory(500);
        CreditCard platinumCreditCard = cf2.getCreditCard(CardType.PLATINUM);
        System.out.println(platinumCreditCard.getClass()); // returns PlatinumCreditCard
    }

}
