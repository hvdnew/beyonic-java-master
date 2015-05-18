package com.beyonic.client.collections;

import java.math.BigDecimal;
import java.util.List;

import com.beyonic.model.collections.CollectionResponse;

/**
 * 
 * @author Harshvardhan Dadhich
 *
 */
public interface CollectionsMethods {
	
	public static final String COLLECTIONS_API_ENDPOINT = "https://staging.beyonic.com/api/collections";
	
	
	public CollectionResponse read(String id);
	public List<CollectionResponse> list();
	public List<CollectionResponse> search(String phonenumber, String remote_transaction_id);
	public List<CollectionResponse> claim(String phonenumber, String remote_transaction_id, boolean claim, BigDecimal amount);
	

}
