package com.archdesignpatterns.circuitbreaker;

public class PromoServiceRequest {

    private final PromoService service;
    private final String promoCode;
    private final Double amount;

    public PromoServiceRequest(PromoServiceRequestBuilder requestBuilder) {

        this.service = requestBuilder.getPromoService();
        this.promoCode = requestBuilder.getPromoCode();
        this.amount = requestBuilder.getAmount();
    }

    public PromoServiceRequest(Order order, PromoService service) {
        this.service = service;
        this.promoCode = order.promoCode;
        this.amount = order.amount;
    }
    public double execute() throws Exception {
        double afterDiscount = this.service.apply(this.promoCode, this.amount);
        return afterDiscount;
    }
}
