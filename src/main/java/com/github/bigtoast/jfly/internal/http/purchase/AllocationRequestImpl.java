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

package com.github.bigtoast.jfly.internal.http.purchase;

import java.io.CharArrayWriter;
import java.io.IOException;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;

import com.github.bigtoast.jfly.DeliveryType;
import com.github.bigtoast.jfly.api.JFlyRequestBase;
import com.github.bigtoast.jfly.api.JFlyValidationException;
import com.github.bigtoast.jfly.api.purchase.DoAllocate;
import com.github.bigtoast.jfly.internal.json.DeliveryChargeImpl;

public class AllocationRequestImpl extends JFlyRequestBase implements DoAllocate {
	
	private static final long serialVersionUID = -5611247629102050527L;
	
	private String promoCode;
    private DeliveryType deliveryType;
    private int quantity;
    private long accessId;

	@Override
	public DoAllocate withPromoCode(String promoCode) {
		this.promoCode = promoCode;
		return this;
	}

	@Override
	public DoAllocate withDeliveryType(DeliveryType type) {
		this.deliveryType = type;
		return this;
	}

	@Override
	public DoAllocate withQuantity(int quantity) {
		this.quantity = quantity;
		return this;
	}

	@Override
	public DoAllocate withAccessId(long accessId) {
		this.accessId = accessId;
		return this;
	}

	@Override
	public void validate() throws JFlyValidationException {
		if ( ! ( accessId > 0  && quantity > 0 ) )
			throw new JFlyValidationException("inventory id must be set and a quantity larger than 0 must be set.");

	}

    @Override
    public String build() throws JFlyValidationException {
        throw new UnsupportedOperationException();
    }

}
