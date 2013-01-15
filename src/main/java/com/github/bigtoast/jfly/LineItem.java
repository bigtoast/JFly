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
import java.math.BigDecimal;
import java.net.URL;
import java.util.List;

public interface LineItem extends Serializable {

	public long getAccessId();
	
	public URL getUri();
	
	public int getQuantity();
	
	public DeliveryCharge getDeliveryCharge();
	
	public URL getEventUri();
	
	public BigDecimal getLineItemFees();
	
	public BigDecimal getLineItemPrice();
	
	public int getPurchaseLimit();
	
	public String name();
	
	public CurrencyType getCurrencyType();
	
	public List<DeliveryType> getDeliveryOptions();
	
}
