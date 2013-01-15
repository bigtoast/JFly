package com.github.bigtoast.jfly.api.purchase;

import java.io.Serializable;

public interface LineItemCommand extends Serializable {

	public LineItemCommand withAccessId( long accessId );
	
	public LineItemCommand withQuantity( int quantity );
	
	public LineItemCommand withDeliveryType( String deliveryType );
	
	public LineItemCommand withPromoCode( String promoCode );
	
}
