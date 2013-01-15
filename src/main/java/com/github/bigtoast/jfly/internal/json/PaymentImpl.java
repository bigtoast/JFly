package com.github.bigtoast.jfly.internal.json;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;

import com.github.bigtoast.jfly.Address;
import com.github.bigtoast.jfly.CreditCard;
import com.github.bigtoast.jfly.Payment;
import com.github.bigtoast.jfly.api.JFlyValidationException;

public class PaymentImpl implements Payment, Payment.PaymentBuilder {

	private static final long serialVersionUID = -2606495314511870703L;
	
	private CreditCard creditCard;
	private Address address;
	
	public static String CREDIT_CARD = "card";
	public static String ADDRESS     = "address";

	public PaymentImpl( JsonParser parser ) throws JsonParseException, IOException{
        if (parser.nextToken() != JsonToken.START_OBJECT) {
          throw new IOException("Expected data to start with an Object");
        }
        
        while ( parser.nextToken() != JsonToken.END_OBJECT){
      	  String fname = parser.getCurrentName();
      	  parser.nextToken();
      	  
      	  if ( fname.equals(CREDIT_CARD) )
      	    creditCard = new CreditCardImpl(parser);
      	  else if ( fname.equals(ADDRESS) )
      		address = new AddressImpl(parser);
        }
	}
	
	@Override
	public CreditCard getCard() {
		return creditCard;
	}

	@Override
	public Address getBillingAddress() {
		return address;
	}

	public PaymentImpl(CreditCard creditCard, Address address) {
		super();
		this.creditCard = creditCard;
		this.address = address;
	}
	
	public PaymentImpl(){}

	@Override
	public Payment build() {
		if ( ! isValid() )
			throw new JFlyValidationException("Payment is not ready to be built");
		
		return (Payment) getBuilder();
	}

	@Override
	public boolean isValid() {
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PaymentBuilder getBuilder() {
		return new PaymentImpl( creditCard, address );
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PaymentBuilder newBuilder() {
		return new PaymentImpl(new CreditCardImpl(), new AddressImpl());
	}

	@Override
	public PaymentBuilder withCreditCard(CreditCard card) {
		this.creditCard = card;
		return this;
	}

	@Override
	public PaymentBuilder withBillingAddress(Address address) {
		this.address = address;
		return this;
	}
	
	

}
