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

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;

import com.github.bigtoast.jfly.DeliveryCharge;

public class DeliveryChargeImpl implements DeliveryCharge {

	private static final long serialVersionUID = -5105203966657317934L;
	
	private String id;
	private String message;
	private String name;
	private BigDecimal amount;
	
	public static String ID      = "id";
	public static String MESSAGE = "message";
	public static String NAME    = "name";
	public static String AMOUNT  = "charge";

	public DeliveryChargeImpl(JsonParser parser) throws JsonParseException, IOException {
		if (parser.nextToken() != JsonToken.START_OBJECT) {
		    throw new IOException("Expected data to start with an Object");
		}
		      
		while ( parser.nextToken() != JsonToken.END_OBJECT){
		    String fname = parser.getCurrentName();
		    parser.nextToken();
		    
		    if ( fname.equals( ID ) )
		    	id = parser.getText();
		    else if ( fname.equals( MESSAGE ) )
		    	message = parser.getText();
		    else if ( fname.equals( NAME ) )
		    	name = parser.getText();
		    else if ( fname.equals(AMOUNT) )
	      		amount = parser.getDecimalValue();
		    
		}
		
	}
	
	@Override
	public String getId() {
		return id;
	}

	@Override
	public String getMessage() {
		return message;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public BigDecimal getAmount() {
		return amount;
	}

}
