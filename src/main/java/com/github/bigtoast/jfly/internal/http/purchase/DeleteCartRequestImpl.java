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

import com.github.bigtoast.jfly.api.JFlyValidationException;
import com.github.bigtoast.jfly.api.purchase.DeleteCartRequest;

public class DeleteCartRequestImpl extends CartRequestBase<DeleteCartRequestImpl> implements DeleteCartRequest {
	
	private static final long serialVersionUID = -4585030024833557654L;

	public DeleteCartRequestImpl( String cartId ){
		withCartId(cartId);
	}
	
	@Override
	public void validate() throws JFlyValidationException {
		if ( getCartId() != null )
			throw new JFlyValidationException("Cart id must be set.");		
	}

}
