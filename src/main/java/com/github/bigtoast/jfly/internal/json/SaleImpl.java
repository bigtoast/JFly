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

package com.github.bigtoast.jfly.internal.json;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.joda.time.DateTime;

import com.github.bigtoast.jfly.Address;
import com.github.bigtoast.jfly.Charge;
import com.github.bigtoast.jfly.Event;
import com.github.bigtoast.jfly.LineItem;
import com.github.bigtoast.jfly.Payment;
import com.github.bigtoast.jfly.Sale;

public class SaleImpl implements Sale {

	private static final long serialVersionUID = -7834910340021139804L;
	
	private long id;
	private URL uri;
	private DateTime createdAt;
	private List<LineItem> lineItems = new LinkedList<LineItem>();
	private Charge shippingCharge;
	private Charge handlingCharge;
	private Charge totalCharge;
	private Address shippingAddress;
	private Payment payment;
	private List<Event> events = new LinkedList<Event>();
	
	public static String ID               = "id";
	public static String URI              = "uri";
	public static String CREATED_AT       = "dateCreated";
	public static String LINE_ITEMS       = "lineItems";
	public static String SHIPPING_CHARGE  = "shipping";
	public static String HANDLING_CHARGE  = "handling";
	public static String TOTAL_CHARGE     = "total";
	public static String SHIPPING_ADDRESS = "shippingAddress";
	public static String PAYMENT          = "payment";
	public static String EVENTS           = "events";

	public SaleImpl( JsonParser parser ) throws JsonParseException, IOException {
		if (parser.nextToken() != JsonToken.START_OBJECT) {
		    throw new IOException("Expected data to start with an Object");
		}
		      
		while ( parser.nextToken() != JsonToken.END_OBJECT){
		    String fname = parser.getCurrentName();
		    parser.nextToken();
		    
		    if ( fname.equals(ID))
		    	id = parser.getLongValue();
		    else if ( fname.equals(URI))
		    	uri = new URL( parser.getText() );
		    else if ( fname.equals(CREATED_AT))
		    	createdAt = new DateTime( parser.getText() );
		    else if ( fname.equals(SHIPPING_CHARGE) )
		    	shippingCharge = new ChargeImpl( parser.getDecimalValue() );
		    else if ( fname.equals(HANDLING_CHARGE) )
		    	handlingCharge = new ChargeImpl( parser.getDecimalValue() );
		    else if ( fname.equals(TOTAL_CHARGE) )
		    	totalCharge = new ChargeImpl( parser.getDecimalValue() );
		    else if ( fname.equals(SHIPPING_ADDRESS) )
		    	shippingAddress = new AddressImpl( parser );
		    else if ( fname.equals(PAYMENT) )
		    	payment = new PaymentImpl( parser );
		    else if ( fname.equals(EVENTS) )
		    	readEvents( parser );
		    else if ( fname.equals( LINE_ITEMS ) ) {
		    	if ( parser.nextToken().equals(JsonToken.START_ARRAY) ){
		    		while ( parser.nextToken() != JsonToken.END_ARRAY ) {
		    			lineItems.add( new LineItemImpl( parser ) );
			    	}
			    }
		    }
		}
	}
	
	private void readEvents( JsonParser parser ) throws JsonParseException, IOException {
		while ( parser.nextToken() != JsonToken.END_OBJECT ) {
			// ignore the current key which should be the event uri
			parser.nextToken();
			events.add( new EventImpl( parser ) );
		}
	}
	
	@Override
	public long getId() {
		return id;
	}

	@Override
	public URL getUri() {
		return uri;
	}

	@Override
	public DateTime createdAt() {
		return createdAt;
	}

	@Override
	public List<LineItem> getLineItems() {
		return lineItems;
	}

	@Override
	public Charge getShippingCharge() {
		return shippingCharge;
	}

	@Override
	public Charge getHandlingCharge() {
		return handlingCharge;
	}

	@Override
	public Charge getTotalCharge() {
		return totalCharge;
	}

	@Override
	public Address getShippingAddress() {
		return shippingAddress;
	}

	@Override
	public Payment getPayment() {
		return payment;
	}

	@Override
	public List<Event> getEvents() {
		return events;
	}

}
