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
import java.util.List;

import com.github.bigtoast.jfly.LineItem;
import com.github.bigtoast.jfly.api.JFlyRequestBase;
import com.github.bigtoast.jfly.api.purchase.SetPaymentCommand;

@SuppressWarnings("serial")
public abstract class CartRequestBase<R extends CartRequestBase<R>> extends JFlyRequestBase {
	
	private String cartId;
	
	private List<LineItem> lineItemRequests = new LinkedList<LineItem>();
	
	private SetPaymentCommand setPaymentRequest;
	
	public String getCartId(){
		return cartId;
	}
	
	
	public SetPaymentCommand getSetPaymentRequest(){
		return setPaymentRequest;
	}
	
	@SuppressWarnings("unchecked")
	public R withCartId( String cartId ){
		this.cartId = cartId;
		return (R) this;
	}
	
	@SuppressWarnings("unchecked")
	public R withLineItem( LineItem lineItem ){
		lineItemRequests.add( lineItem );
		return (R) this;
	}
	
	@SuppressWarnings("unchecked")
	public R withSetPaymentRequest( SetPaymentCommand request ){
		setPaymentRequest = request;
		return (R) this;
	}

}
