package com.beyonic.model.enums;

/**
 * @author Harshvardhan Dadhich
 * <p> All supported payment types should be listed down here </p>
 */
public enum PaymentTypeEnum {
	
	money("money"),
	airtime("airtime");
	
	
	private String paymentType;  
	
	private PaymentTypeEnum(String paymentType){  
		this.paymentType = paymentType;  
	}  
	
	public String getPaymentType(){
		return paymentType;
	}
	
	
}
