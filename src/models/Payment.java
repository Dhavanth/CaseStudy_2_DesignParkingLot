package models;

import java.util.Date;

public class Payment extends BaseModel{
    private PaymentMode paymentMode;
    private PaymentStatus paymentStatus;
    private int amount;

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    private String referenceNumber;
    private Date timeOfPayment;

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


    public Date getTimeOfPayment() {
        return timeOfPayment;
    }

    public void setTimeOfPayment(Date timeOfPayment) {
        this.timeOfPayment = timeOfPayment;
    }
}
