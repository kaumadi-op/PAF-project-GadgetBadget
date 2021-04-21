package com.gadgetBadgetG14.payment;

public class Payment {
		
	public String cardHolderName;
	public int cardNumber;
	public int expDate;
	public int cvv;
	public String getCardHolderName() {
		return cardHolderName;
	}
	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}
	public int getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}
	public int getExpDate() {
		return expDate;
	}
	@Override
	public String toString() {
		return "Payment [cardHolderName=" + cardHolderName + ", cardNumber=" + cardNumber + ", expDate=" + expDate
				+ ", cvv=" + cvv + "]";
	}
	public void setExpDate(int expDate) {
		this.expDate = expDate;
	}
	public int getCvv() {
		return cvv;
	}
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	
}
