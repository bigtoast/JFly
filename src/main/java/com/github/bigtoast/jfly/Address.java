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
package com.github.bigtoast.jfly;

import java.io.Serializable;

public interface Address extends Buildable<Address, Address.AddressBuilder>,  Serializable {
	
	public String getEmail();
	public String getFirstName();
	public String getLastName();
	public String getAddress1();
	public String getAddress2();
	public String getCity();
	public String getStateProvince();
	public String getPostalCode();
	public String getCountry();
	public String getPhoneNumber();
	
	public interface AddressBuilder extends EntityBuilder<Address> {
	  public AddressBuilder withEmail( String email );
	  public AddressBuilder withFirstName( String fName );
	  public AddressBuilder withLastName( String lName );
	  public AddressBuilder withAddress1( String address1 );
	  public AddressBuilder withAddress2( String address2 );
	  public AddressBuilder withCity( String city );
	  public AddressBuilder withStateProvince( String stateProvince );
	  public AddressBuilder withPostalCode( String postalCode );
	  public AddressBuilder withCountry( String country );
	  public AddressBuilder withPhoneNumber( String phoneNumber );
	}
}
