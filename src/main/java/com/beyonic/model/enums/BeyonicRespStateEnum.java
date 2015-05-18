package com.beyonic.model.enums;

/**
 * 
 * @author Harshvardhan Dadhich
 *
 */
public enum BeyonicRespStateEnum {

	new_("new"),
	processed("processed"),
	processed_with_errors("processed_with_errors"), // The last_error field will have more information.
	rejected("rejected"), // The following fields will have more information: rejected_reason, rejected_by and rejected_time
	cancelled("cancelled"); // The following fields will have more information: cancelled_reason, cancelled_by and cancelled_time
	
	
	private String respState;  
	
	private BeyonicRespStateEnum(String respState){  
		this.respState = respState;  
	}  
	
	public String getBeyonicRespState(){
		return respState;
	}
	
	
	
}
