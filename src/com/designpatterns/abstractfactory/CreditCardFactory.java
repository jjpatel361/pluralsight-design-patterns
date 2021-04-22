package com.designpatterns.abstractfactory;

public abstract class CreditCardFactory {

    public static CreditCardFactory getCreditCardFactory(int creditScore) {

        if(creditScore > 650) {
            return new AmexCardFactory();
        }

        return new VisaFactory();
    }

    public abstract CreditCard getCreditCard(CardType cardType);

}
