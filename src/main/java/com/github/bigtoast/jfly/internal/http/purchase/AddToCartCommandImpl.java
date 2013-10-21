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
import java.util.LinkedList;
import java.util.List;

import com.github.bigtoast.jfly.api.purchase.DoAllocate;
import com.github.bigtoast.jfly.api.purchase.SetPaymentCommand;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;

import com.github.bigtoast.jfly.DeliveryType;
import com.github.bigtoast.jfly.LineItem;
import com.github.bigtoast.jfly.api.JFlyValidationException;
import com.github.bigtoast.jfly.api.purchase.AddToCartCommand;

public class AddToCartCommandImpl extends CartRequestBase<AddToCartCommandImpl> implements AddToCartCommand {
	
	private static final long serialVersionUID = 2512502177554576187L;
	
	private List<LineItem> lineItems = new LinkedList<LineItem>();
	
	private JsonFactory factory;
	
	public static String ACCESS_ID     = "accessId";
	public static String QUANTITY      = "quantity";
	public static String DELIVERY_TYPE = "delivery";
	public static String PROMO_CODE    = "promoCode";
	
	public AddToCartCommandImpl(JsonFactory factory){
		this.factory = factory;
	}
	
	@Override
	public String build() throws JFlyValidationException {
		validate();
		CharArrayWriter writer = new CharArrayWriter();
		try {
			JsonGenerator generator = factory.createJsonGenerator(writer);
			generator.writeStartArray();
			for( LineItem lineItem : lineItems ){
				generator.writeFieldName(ACCESS_ID);
				generator.writeNumber(lineItem.getAccessId());
				generator.writeFieldName(QUANTITY);
				generator.writeNumber(lineItem.getQuantity());
				generator.writeStringField(DELIVERY_TYPE, lineItem.getDeliveryOptions().get(0).getName());
			}
			generator.writeEndArray();
			
			generator.writeStartObject();
			/*if ( deliveryType != null )
				generator.writeStringField(DELIVERY_TYPE, deliveryType.toString() );
			
			if ( checkHas( accessId ) )
				generator.writeFieldName( ACCESS_ID ); 
				generator.writeNumber( accessId );
			
			if ( checkHas( quantity ) ) {
				generator.writeFieldName(QUANTITY);
				generator.writeNumber(quantity);
			}
			
			if ( promoCode != null ) {
				generator.writeStringField(PROMO_CODE, promoCode);
			} */
			
			generator.writeEndObject();
		
		} catch ( IOException e ) {
			throw new JFlyValidationException(e);
		}
		return writer.toString();
	}

	@Override
	public void validate() throws JFlyValidationException {
		//if ( ! ( accessId > 0  && quantity > 0 ) )
		//	throw new JFlyValidationException("inventory id must be set and a quantity larger than 0 must be set.");
	}


    @Override
    public AddToCartCommand withDoAllocate(DoAllocate doIt) {
        throw new UnsupportedOperationException();
    }

    @Override
    public AddToCartCommand withSetPayment(SetPaymentCommand payment) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String buildBody() throws JFlyValidationException {
        throw new UnsupportedOperationException();
    }
}
