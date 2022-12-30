package com.archdesignpatterns.circuitbreaker;

public class PromoServiceRequestBuilder {

    private String promoCode;
    private Double amount;
    private PromoService client;
    private String orderId;

    public PromoServiceRequestBuilder withPromoCode(String promoCode) {
        this.promoCode = promoCode;
        return this;
    }

    public PromoServiceRequestBuilder withOrderId(String orderId) {
        this.orderId = orderId;
        return this;
    }

    public PromoServiceRequestBuilder withAmount(Double amount) {
        this.amount =amount;
        return this;
    }

    public PromoServiceRequestBuilder withPromoService(PromoService client) {
        this.client = client;
        return this;
    }

    public PromoServiceRequest build() {
        return new PromoServiceRequest(this);
    }

    public PromoService getPromoService() {
        return this.client;
    }

    public String getPromoCode() {
        return this.promoCode;
    }

    public Double getAmount() {
        return this.amount;
    }

    public String getOrderId() {
        return this.orderId;
    }
}
