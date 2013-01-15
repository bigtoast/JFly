package com.github.bigtoast.jfly.api.purchase;

import com.github.bigtoast.jfly.DeliveryType;
import com.github.bigtoast.jfly.api.JFlyRequest;

public interface DoAllocate extends JFlyRequest {
	
	public DoAllocate withPromoCode( String promoCode );
	
	public DoAllocate withDeliveryType( DeliveryType type );
	
	public DoAllocate withQuantity( int quantity );
	
	public DoAllocate withAccessId( long accessId );

}
