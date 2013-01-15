package com.github.bigtoast.jfly.internal.json;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;

import com.github.bigtoast.jfly.Address;
import com.github.bigtoast.jfly.Cart;
import com.github.bigtoast.jfly.Charge;
import com.github.bigtoast.jfly.Event;
import com.github.bigtoast.jfly.LineItem;
import com.github.bigtoast.jfly.Payment;
import com.github.bigtoast.jfly.CreditCard.CreditCardType;

public class CartImpl implements Cart {

	private static final long serialVersionUID = 6540501378341296188L;
	
	private String id;
	private List<Event> events = new LinkedList<Event>();
	private Charge handlingCharge;
	private List<CreditCardType> creditCardTypes = new LinkedList<CreditCardType>();
	private List<LineItem> lineItems = new LinkedList<LineItem>();
	private Payment payment;
	private Address shippingAddress;
	private Charge shippingCharge;
	private URL uri;
	private long whenExpires;
	private boolean isExpired;
	private Charge total;
	
	
	public static String ID                = "id";
	public static String EVENTS            = "events";
	public static String HANDLING_CHARGE   = "handlingCharge";
	public static String CREDIT_CARD_TYPES = "availableCardTypes";
	public static String LINE_ITEMS        = "lineItems";
	public static String PAYMENT           = "payment";
	public static String SHIPPING_ADDRESS  = "shippingAddress";
	public static String SHIPPING_CHARGE   = "shippingCharge";
	public static String URI               = "uri";
	public static String WHEN_EXPIRES      = "expires";
	public static String IS_EXPIRED        = "expired";
	public static String TOTAL             = "total";
	
	public static String CC_NAME           = "name";
		
	public CartImpl(JsonParser parser) throws JsonParseException, IOException {
		if (parser.nextToken() != JsonToken.START_OBJECT) {
		    throw new IOException("Expected data to start with an Object");
		}
		      
		while ( parser.nextToken() != JsonToken.END_OBJECT){
		    String fname = parser.getCurrentName();
		    parser.nextToken();
		
		    if ( fname.equals(ID) )
		    	id = parser.getText();
		    else if ( fname.equals(EVENTS) )
		    	readEvents( parser );
		    else if ( fname.equals(HANDLING_CHARGE) )
		    	handlingCharge = new ChargeImpl( parser.getDecimalValue() );
		    else if ( fname.equals( SHIPPING_CHARGE ) )
		    	shippingCharge = new ChargeImpl( parser.getDecimalValue() );
		    else if ( fname.equals( SHIPPING_ADDRESS ) )
		    	shippingAddress = new AddressImpl( parser );
		    else if ( fname.equals( PAYMENT ) )
		    	payment = new PaymentImpl( parser );
		    else if ( fname.equals( CREDIT_CARD_TYPES ) ) {
		    	if ( parser.nextToken().equals(JsonToken.START_ARRAY) ){
		    	  while ( parser.nextToken() != JsonToken.END_ARRAY ) {
		    		 readCreditCardType( parser );
		    	  }
		    	}
		    } else if ( fname.equals( LINE_ITEMS ) ) {
		    	if ( parser.nextToken().equals(JsonToken.START_ARRAY) ){
		    		while ( parser.nextToken() != JsonToken.END_ARRAY ) {
		    			lineItems.add( new LineItemImpl( parser ) );
		    		}
		    	}
		    } else if ( fname.equals( URI ) )
		    	uri = new URL( parser.getText() );
		    else if ( fname.equals( WHEN_EXPIRES ) )
		    	whenExpires = parser.getLongValue();
		    else if ( fname.equals(IS_EXPIRED) )
		    	isExpired = parser.getBooleanValue();
		    else if ( fname.equals(TOTAL))
		    	total = new ChargeImpl( parser.getDecimalValue() );
		}
	}
	
	private void readEvents( JsonParser parser ) throws JsonParseException, IOException {
		while ( parser.nextToken() != JsonToken.END_OBJECT ) {
			// ignore the current key which should be the event uri
			parser.nextToken();
			events.add( new EventImpl( parser ) );
		}
	}
	
	private void readCreditCardType( JsonParser parser ) throws JsonParseException, IOException {
		while ( parser.nextToken() != JsonToken.END_OBJECT ) {
			String fname = parser.getCurrentName();
			parser.nextToken();
			
			if ( fname.equals(CC_NAME) ) {
				creditCardTypes.add( CreditCardType.valueOf( parser.getText() ) );
			}
		}
	}
		    	  
	@Override
	public String getId() {
		return id;
	}

	@Override
	public URL getUri() {
		return uri;
	}

	@Override
	public boolean isExpired() {
		return isExpired;
	}

	@Override
	public long getWhenExpires() {
		return whenExpires;
	}

	@Override
	public List<LineItem> getLineItems() {
		return lineItems;
	}

	@Override
	public Charge getShippingCharge() {
		return shippingCharge;
	}

	@Override
	public Charge getHandlingCharge() {
		return handlingCharge;
	}
	
	public Charge getTotalCharge() {
		return total;
	}

	@Override
	public List<CreditCardType> getCreditCardTypes() {
		return creditCardTypes;
	}

	@Override
	public Address getShippingAddress() {
		return shippingAddress;
	}

	@Override
	public Payment getPayment() {
		return payment;
	}

	@Override
	public List<Event> getEvents() {
		return events;
	}

}
