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
import org.codehaus.jackson.*;
import com.github.bigtoast.jfly.CreditCard;
import com.github.bigtoast.jfly.api.JFlyValidationException;

public class CreditCardImpl implements CreditCard, CreditCard.CreditCardBuilder {

	private static final long serialVersionUID = 6789787395581686121L;
	
	private String number;
	private CreditCardType type;
	private int expirationMonth;
	private int expirationYear;
	
	public static String NUMBER = "number";
	public static String TYPE = "type";
	public static String EXPIRATION_MONTH = "expirationMonth";
	public static String EXPIRATION_YEAR = "expirationYear";
	
	@Override
	public String getNumber() {
		return number;
	}

	@Override
	public CreditCardType getCreditCardType() {
		return type;
	}

	@Override
	public int getExpirationMonth() {
		return expirationMonth;
	}

	@Override
	public int getExpirationYear() {
		return expirationYear;
	}
	
	public CreditCardImpl(JsonParser parser) throws JsonParseException, IOException {
		if (parser.nextToken() != JsonToken.START_OBJECT) {
		    throw new IOException("Expected data to start with an Object");
		}
		      
		while ( parser.nextToken() != JsonToken.END_OBJECT){
		    String fname = parser.getCurrentName();
		    parser.nextToken();
		    	  
		    if ( fname.equals(NUMBER) )
		      number = parser.getText();
		    else if ( fname.equals(TYPE))
		      type = CreditCardType.valueOf( parser.getText() );
		    else if ( fname.equals(EXPIRATION_MONTH) )
		      expirationMonth = parser.getIntValue();
		    else if ( fname.equals(EXPIRATION_YEAR) )
		      expirationYear = parser.getIntValue();
	    }
	}
		
	public CreditCardImpl(String number, CreditCardType type,
			int expirationMonth, int expirationYear) {
		super();
		this.number = number;
		this.type = type;
		this.expirationMonth = expirationMonth;
		this.expirationYear = expirationYear;
	}

	public CreditCardImpl(){}
	
	public CreditCardBuilder getBuilder(){
        return new CreditCardImpl( number, type, expirationMonth, expirationYear );
	}
	
	public CreditCardBuilder newBuilder(){ return new CreditCardImpl(); }

	@Override
	public CreditCard build() {
		if ( ! isValid() )
			throw new JFlyValidationException("CreditCard is not ready to be built");
		
		return (CreditCard) getBuilder();
	}

	@Override
	public boolean isValid() {
		return true;
	}

	@Override
	public CreditCardBuilder withNumber(String number) {
		this.number = number;
		return this;
	}

	@Override
	public CreditCardBuilder withType(CreditCardType type) {
		this.type = type;
		return this;
	}

	@Override
	public CreditCardBuilder withExpirationMonth(int month) {
		this.expirationMonth = month;
		return this;
	}

	@Override
	public CreditCardBuilder withExpirationYear(int year) {
		this.expirationYear = year;
		return this;
	}
	
	
}
