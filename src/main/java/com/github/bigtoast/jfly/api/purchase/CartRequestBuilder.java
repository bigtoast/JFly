/*
 * Copyright 2012 Andrew Headrick
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.bigtoast.jfly.api.purchase;

import com.github.bigtoast.jfly.Address;
import com.github.bigtoast.jfly.Payment;

public interface CartRequestBuilder {
	
	/**
	 * Create a delete cart request builder.
	 * @return
	 */
	public DeleteCartRequest delete();
	
	public AddToCartCommand withDoAllocate( DoAllocate request );

	/**
	 * create a get cart request
	 * 
	 * @return
	 */
	public GetCartRequest get();
	
	public PurchaseCartCommand purchase();
	
	/**
	 * create a line item command builder for this given cart and line item.
	 * 
	 * @param lineItem
	 * @return
	 */
	public LineItemCommandBuilder lineItem( long lineItem );
	
	
	/**
	 * Create a SetPaymentCommand for this cart.
	 * @param payment
	 * @return
	 */
	public SetPaymentCommand withPayment( Payment payment );
	
	/**
	 * Generate an empty set payment command for this cart. Note that this 
	 * will not validate until cc info and billing address is added.
	 * @return
	 */
	public SetPaymentCommand payment();
	
	/**
	 * Build a set shipping address command from an address object
	 * 
	 * @param address
	 * @return
	 */
	public SetShippingAddressCommand withShippingAddress( Address address );
	
	/**
	 * Build a set shipping address command. It will need an address added to it before it can 
	 * be built successfully. 
	 * 
	 * @return
	 */
	public SetShippingAddressCommand shipping();
	
	
	//public LineItemUpdateRequest lineItem( long lineItemId );
}
