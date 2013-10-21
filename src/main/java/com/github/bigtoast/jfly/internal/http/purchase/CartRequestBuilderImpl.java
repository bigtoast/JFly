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

package com.github.bigtoast.jfly.internal.http.purchase;

import java.util.LinkedList;

import com.github.bigtoast.jfly.Address;
import com.github.bigtoast.jfly.Payment;
import com.github.bigtoast.jfly.api.JFlyValidationException;
import com.github.bigtoast.jfly.api.purchase.*;

public class CartRequestBuilderImpl implements CartRequestBuilder {
	
	private String cartId;
	
	public CartRequestBuilderImpl( String cartId ) {
		this.cartId = cartId;
	}
	
	public CartRequestBuilderImpl(){}

	@Override
	public DeleteCartRequest delete() {
		if ( cartId == null )
			throw new JFlyValidationException("The cart id must be set in order to create a deletion request");
		
		return new DeleteCartRequestImpl( cartId );
	}

	@Override
	public AddToCartCommand withDoAllocate(DoAllocate request) {
		// TODO Auto-generated method stub
		return null;
	}

    @Override
    public GetCartRequest get() {
        throw new UnsupportedOperationException();
    }

    @Override
    public PurchaseCartCommand purchase() {
        throw new UnsupportedOperationException();
    }

    @Override
    public LineItemCommandBuilder lineItem(long lineItem) {
        throw new UnsupportedOperationException();
    }

    @Override
    public SetPaymentCommand withPayment(Payment payment) {
        throw new UnsupportedOperationException();
    }

    @Override
    public SetPaymentCommand payment() {
        throw new UnsupportedOperationException();
    }

    @Override
    public SetShippingAddressCommand withShippingAddress(Address address) {
        throw new UnsupportedOperationException();
    }

    @Override
    public SetShippingAddressCommand shipping() {
        throw new UnsupportedOperationException();
    }

}
