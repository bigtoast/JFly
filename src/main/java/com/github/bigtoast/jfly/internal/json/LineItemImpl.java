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
import java.math.BigDecimal;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;

import com.github.bigtoast.jfly.CurrencyType;
import com.github.bigtoast.jfly.DeliveryCharge;
import com.github.bigtoast.jfly.DeliveryType;
import com.github.bigtoast.jfly.LineItem;

public class LineItemImpl implements LineItem {

	private long accessId;
	private URL uri;
	private int quantity;
	private DeliveryCharge deliveryCharge;
	private URL eventUri;
	private BigDecimal lineItemFees;
	private BigDecimal lineItemPrice;
	private int purchaseLimit;
	private String name;
	private CurrencyType currencyType;
	private List<DeliveryType> deliveryOptions = new LinkedList<DeliveryType>();
	
	private static final long serialVersionUID = 9075403935093267179L;
	
	private static String ACCESS_ID        = "accessId";
	private static String URI              = "uri";
	private static String NAME             = "name";
	private static String QUANTITY         = "quantity";
	private static String DELIVERY         = "delivery";
	private static String EVENT_URI        = "eventUri";
	private static String LINE_ITEM_FEES   = "lineItemFees";
	private static String LINE_ITEM_PRICE  = "lineItemPrice";
	private static String PURCHASE_LIMIT   = "purchaseLimit";
	private static String CURRENCY_TYPE    = "currency";
	private static String DELIVERY_OPTIONS = "deliveryOptions";
	
	public LineItemImpl(JsonParser parser) throws JsonParseException, IOException {
		if (parser.nextToken() != JsonToken.START_OBJECT) {
		    throw new IOException("Expected data to start with an Object");
		}
		      
		while ( parser.nextToken() != JsonToken.END_OBJECT){
		    String fname = parser.getCurrentName();
		    parser.nextToken();
		 
		    if ( fname.equals(ACCESS_ID) )
		    	accessId = parser.getLongValue();
		    else if ( fname.equals(URI) )
		    	uri = new URL( parser.getText() );
		    else if ( fname.equals( NAME )) 
		    	name = parser.getText();
		    else if ( fname.equals( QUANTITY ) )
		    	quantity = parser.getIntValue();
		    else if ( fname.equals( DELIVERY ) )
		    	deliveryCharge = new DeliveryChargeImpl( parser );
		    else if ( fname.equals( EVENT_URI ) )
		    	eventUri = new URL( parser.getText() );
		    else if ( fname.equals( LINE_ITEM_FEES ) )
		    	lineItemFees = parser.getDecimalValue();
		    else if ( fname.equals( LINE_ITEM_PRICE ) )
		    	lineItemPrice = parser.getDecimalValue();
		    else if ( fname.equals( PURCHASE_LIMIT ) )
		    	purchaseLimit = parser.getIntValue();
		    else if ( fname.equals( CURRENCY_TYPE ) )
		    	currencyType = CurrencyType.valueOf(parser.getText());
		    else if ( fname.equals( DELIVERY_OPTIONS ) ) {
		    	if ( parser.nextToken().equals(JsonToken.START_ARRAY) ){
		    	  while ( parser.nextToken() != JsonToken.END_ARRAY ) {
		    		 deliveryOptions.add( new DeliveryChargeImpl( parser ) );
		    	  }
			    }
		    }
		    
		}
	}

	@Override
	public long getAccessId() {
		return accessId;
	}

	@Override
	public URL getUri() {
		return uri;
	}

	@Override
	public int getQuantity() {
		return quantity;
	}

	@Override
	public DeliveryCharge getDeliveryCharge() {
		return deliveryCharge;
	}

	@Override
	public URL getEventUri() {
		return eventUri;
	}

	@Override
	public BigDecimal getLineItemFees() {
		return lineItemFees;
	}

	@Override
	public BigDecimal getLineItemPrice() {
		return lineItemPrice;
	}

	@Override
	public int getPurchaseLimit() {
		return purchaseLimit;
	}

	@Override
	public String name() {
		return name;
	}

	@Override
	public CurrencyType getCurrencyType() {
		return currencyType;
	}

	@Override
	public List<DeliveryType> getDeliveryOptions() {
		return deliveryOptions;
	}
	
	

}
