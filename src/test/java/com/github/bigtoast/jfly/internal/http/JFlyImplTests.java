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
package com.github.bigtoast.jfly.internal.http;

import static org.junit.Assert.*;

import org.junit.Test;

import com.github.bigtoast.jfly.DeliveryCharge.DeliveryType;
import com.github.bigtoast.jfly.Event;
import com.github.bigtoast.jfly.JFly;
import com.github.bigtoast.jfly.JFlyFactory;
import com.github.bigtoast.jfly.api.PagenatedResponse;
import com.github.bigtoast.jfly.api.event.EventQueryFactory;

public class JFlyImplTests {

	@Test
	public final void testListEvents() {
		JFly jfly = JFlyFactory.getInstance(null);
	
		PagenatedResponse<Event> resp = jfly.execute(EventQueryFactory.list().withOrgId(7));
		
		assertTrue( resp.totalResults() > 0 );
		assertTrue( resp.maxResults() > 0 );
	}
	
	public final void testInventoryRequest(){
		JFly jfly = JFlyFactory.getInstance(null);
		
		String cartId = "tester";
		
		// get a cart
		jfly.cart( cartId ).get();
		
		// allocate tix
		jfly.allocate(123, 2).execute();
		// or
		jfly.cart().withDoAllocate( jfly.allocate(123, 5).withPromoCode("123") ).execute();
		
		// delete a cart
		jfly.cart( cartId ).delete();
		
		// purchase a cart
		jfly.cart( cartId ).purchase();
		
		// delete a line item
		jfly.cart( cartId ).lineItem(123).delete();
		
		// update a line item
		jfly.cart( cartId ).lineItem( 123 ).update().withQuantity(5).withPromoCode("asdf").execute();
		jfly.cart( cartId ).lineItem( 123 ).update().withDeliveryType(DeliveryType.USPS).execute();
		
		// set cart payment
		jfly.cart( cartId ).withPayment( jfly.payment().withBillingAddress( jfly.address.withStreet() ) );
		jfly.cart(cartId).payment().withAddress(
		
		
		jfly.cart().withDoAllocate( jfly.allocate(123, 2) ).execute();
		
	}

}
