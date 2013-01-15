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

public interface CreditCard extends Buildable<CreditCard, CreditCard.CreditCardBuilder>, Serializable {

	public String getNumber();
	public CreditCardType getCreditCardType();
	public int getExpirationMonth();
	public int getExpirationYear();
	
	public enum CreditCardType {
		VISA("Visa"), 
		MASTER_CARD("MasterCard"), 
		DISCOVER("Discover"),
		DINERS_CLUB("Diners Club"),
		AMERICAN_EXPRESS("American Express");
		
		private String name;
		
		CreditCardType(String name){
			this.name = name;
		}
		
		public String getName() {
			return name;
		}

	}
	
	public interface CreditCardBuilder extends EntityBuilder<CreditCard> {
		public CreditCardBuilder withNumber(String number);
		public CreditCardBuilder withType(CreditCardType type);
		public CreditCardBuilder withExpirationMonth(int month);
		public CreditCardBuilder withExpirationYear(int year);
	}

}
