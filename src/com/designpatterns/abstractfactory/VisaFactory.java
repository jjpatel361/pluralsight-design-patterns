package com.designpatterns.abstractfactory;

public class VisaFactory extends CreditCardFactory {

    @Override
    public CreditCard getCreditCard(CardType cardType) {
        return switch (cardType) {
            case GOLD -> new VisaGoldCreditCard();
            case PLATINUM -> new VisaPlatinumCreditCard();
            default -> null;
        };
    }
}
