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

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;

import com.github.bigtoast.jfly.Address;
import com.github.bigtoast.jfly.User;

public class UserImpl implements User {
	
	private static final long serialVersionUID = -1157213572067021662L;
	
	private long id;
	private String email;
	private URL uri;
	private String firstName;
	private String lastName;
	private Address billingAddress;
	private Address shippingAddress;
	
	public static String ID         = "id";
	public static String URI        = "uri";
	public static String EMAIL      = "emailAddress";
	public static String FIRST_NAME = "firstName";
	public static String LAST_NAME  = "lastName";
	public static String BILLING    = "billing";
	public static String SHIPPING   = "shipping";
	
	public UserImpl( JsonParser parser ) throws JsonParseException, IOException {
		if (parser.nextToken() != JsonToken.START_OBJECT) {
		    throw new IOException("Expected data to start with an Object");
		}
		
		while ( parser.nextToken() != JsonToken.END_OBJECT ){
			String fname = parser.getCurrentName();
			parser.nextToken();
			
			if ( fname.equals(ID) )
				setId( parser.getLongValue() );
			else if ( fname.equals(URI) )
				setUri( new URL( parser.getText() ));
			else if ( fname.equals(EMAIL))
				setEmail( parser.getText());
			else if ( fname.equals(FIRST_NAME))
				setFirstName(parser.getText());
			else if ( fname.equals(LAST_NAME))
				setLastName(parser.getText());
			else if ( fname.equals(BILLING))
				setBillingAddress( new AddressImpl( parser ) );
			else if ( fname.equals(SHIPPING) )
				setShippingAddress( new AddressImpl( parser) );
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
	public String getEmail() {
		return email;
	}

	@Override
	public String getFirstName() {
		return firstName;
	}

	@Override
	public String getLastName() {
		return lastName;
	}

	@Override
	public Address getBillingAddress() {
		return billingAddress;
	}

	@Override
	public Address getShippingAddress() {
		return shippingAddress;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setUri(URL uri) {
		this.uri = uri;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}

	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

}
