package com.github.bigtoast.jfly.api.purchase;

import com.github.bigtoast.jfly.DeliveryType;

public interface UpdateLineItemCommand extends CartRequest<UpdateLineItemCommand> {

	public UpdateLineItemCommand withLineItemId( long lineItemId );
	
	public UpdateLineItemCommand withQuantity( int quantity );
	
	public UpdateLineItemCommand withDeliveryType( DeliveryType deliveryType );
	
	public UpdateLineItemCommand withPromoCode( String promoCode );
	
}
