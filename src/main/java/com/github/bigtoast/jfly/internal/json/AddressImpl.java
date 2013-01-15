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

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;

import com.github.bigtoast.jfly.Address;
import com.github.bigtoast.jfly.api.JFlyValidationException;

public class AddressImpl implements Address, Address.AddressBuilder {

	private static final long serialVersionUID = 5834192125041644860L;
	
	private String email;
	private String firstName;
	private String lastName;
	private String address1;
	private String address2;
	private String city;
	private String stateProvince;
	private String postalCode;
	private String country;
	private String phoneNumber;
	
	public static String EMAIL          = "emailAddress";
	public static String FIRST_NAME     = "firstName";
	public static String LAST_NAME      = "lastName";
	public static String ADDRESS1       = "address1";
	public static String ADDRESS2       = "address2";
	public static String CITY           = "city";
	public static String STATE_PROVINCE = "stateProvince";
	public static String POSTAL_CODE    = "postalCode";
	public static String COUNTRY        = "country";
	public static String PHONE_NUMBER   = "phoneNumber";
	
	public AddressImpl( JsonParser parser ) throws JsonParseException, IOException{
	   if (parser.nextToken() != JsonToken.START_OBJECT) {
	     throw new IOException("Expected data to start with an Object");
	   }
	        
	    while ( parser.nextToken() != JsonToken.END_OBJECT){
	  	  String fname = parser.getCurrentName();
	  	  parser.nextToken();
	  	  
	  	  if ( fname.equals(EMAIL) )
	  		  email = parser.getText();
	  	  else if ( fname.equals(FIRST_NAME) )
	  		  firstName = parser.getText();
	  	  else if ( fname.equals(LAST_NAME) )
	  		  lastName = parser.getText();
	  	  else if ( fname.equals(ADDRESS1) )
	  		  address1 = parser.getText();
	  	  else if ( fname.equals(ADDRESS2) )
	  		  address2 = parser.getText();
	  	  else if ( fname.equals(CITY))
	  		  city = parser.getText();
	  	  else if ( fname.equals(STATE_PROVINCE) )
	  		  stateProvince = parser.getText();
	  	  else if ( fname.equals(POSTAL_CODE) )
	  		  postalCode = parser.getText();
	  	  else if ( fname.equals( COUNTRY ) )
	  		  country = parser.getText();
	  	  else if ( fname.equals(PHONE_NUMBER) )
	  		  phoneNumber = parser.getText();
	    }
	}
	
	

	public AddressImpl(String email, String firstName, String lastName,
			String address1, String address2, String city,
			String stateProvince, String postalCode, String country,
			String phoneNumber) {
		super();
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.stateProvince = stateProvince;
		this.postalCode = postalCode;
		this.country = country;
		this.phoneNumber = phoneNumber;
	}
	
	public AddressImpl(){}

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
	public String getAddress1() {
		return address1;
	}

	@Override
	public String getAddress2() {
		return address2;
	}

	@Override
	public String getCity() {
		return city;
	}

	@Override
	public String getStateProvince() {
		return stateProvince;
	}

	@Override
	public String getPostalCode() {
		return postalCode;
	}

	@Override
	public String getCountry() {
		return country;
	}

	@Override
	public String getPhoneNumber() {
		return phoneNumber;
	}

	@Override
	public Address build() {
		if ( ! isValid() )
			throw new JFlyValidationException(String.format("Address %s is not valid for building", this));
		
		return (Address) getBuilder();
	}

	@Override
	public boolean isValid() {
		return true;
	}

	@Override
	public AddressBuilder withEmail(String email) {
		this.email = email;
		return this;
	}

	@Override
	public AddressBuilder withFirstName(String fName) {
		this.firstName = fName;
		return this;
	}

	@Override
	public AddressBuilder withLastName(String lName) {
		this.lastName = lName;
		return this;
	}

	@Override
	public AddressBuilder withAddress1(String address1) {
		this.address1 = address1;
		return this;
	}

	@Override
	public AddressBuilder withAddress2(String address2) {
		this.address2 = address2;
		return this;
	}

	@Override
	public AddressBuilder withCity(String city) {
		this.city = city;
		return this;
	}

	@Override
	public AddressBuilder withStateProvince(String stateProvince) {
		this.stateProvince = stateProvince;
		return this;
	}

	@Override
	public AddressBuilder withPostalCode(String postalCode) {
		this.postalCode = postalCode;
		return this;
	}

	@Override
	public AddressBuilder withCountry(String country) {
		this.country = country;
		return this;
	}

	@Override
	public AddressBuilder withPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public AddressBuilder getBuilder() {
		return new AddressImpl(email, firstName, lastName,
			address1, address2, city,
			stateProvince, postalCode, country,
			phoneNumber);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public AddressBuilder newBuilder() { return new AddressImpl(); }
	
	

}
