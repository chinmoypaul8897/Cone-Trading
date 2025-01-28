package com.cone.trading.response;

public class PaymentResponse {

    private String payment_url ;


    // getters and setters


    public String getPayment_url() {
        return payment_url;
    }

    public void setPayment_url(String payment_url) {
        this.payment_url = payment_url;
    }

    @Override
    public String toString() {
        return "PaymentResponse{" +
                "payment_url='" + payment_url + '\'' +
                '}';
    }
}
