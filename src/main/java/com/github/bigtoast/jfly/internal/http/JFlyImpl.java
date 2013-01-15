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
package com.github.bigtoast.jfly.internal.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonFactory;

import com.github.bigtoast.jfly.Address.AddressBuilder;
import com.github.bigtoast.jfly.Cart;
import com.github.bigtoast.jfly.CreditCard.CreditCardBuilder;
import com.github.bigtoast.jfly.Event;
import com.github.bigtoast.jfly.JFly;
import com.github.bigtoast.jfly.Org;
import com.github.bigtoast.jfly.Payment.PaymentBuilder;
import com.github.bigtoast.jfly.Venue;
import com.github.bigtoast.jfly.api.Empty;
import com.github.bigtoast.jfly.api.JFlyException;
import com.github.bigtoast.jfly.api.JFlyResponse;
import com.github.bigtoast.jfly.api.PagenatedResponse;
import com.github.bigtoast.jfly.api.event.EventListQuery;
import com.github.bigtoast.jfly.api.event.FeaturedEventsQuery;
import com.github.bigtoast.jfly.api.event.JustAnnouncedEventsQuery;
import com.github.bigtoast.jfly.api.event.PastEventsQuery;
import com.github.bigtoast.jfly.api.event.UpcomingEventsQuery;
import com.github.bigtoast.jfly.api.org.OrgListQuery;
import com.github.bigtoast.jfly.api.purchase.AddToCartCommand;
import com.github.bigtoast.jfly.api.purchase.CartRequestBuilder;
import com.github.bigtoast.jfly.api.purchase.DoAllocate;
import com.github.bigtoast.jfly.api.purchase.GetCartRequest;
import com.github.bigtoast.jfly.api.venue.VenueListQuery;
import com.github.bigtoast.jfly.internal.http.purchase.CartRequestBuilderImpl;
import com.github.bigtoast.jfly.internal.json.AddressImpl;
import com.github.bigtoast.jfly.internal.json.CartImpl;
import com.github.bigtoast.jfly.internal.json.CreditCardImpl;
import com.github.bigtoast.jfly.internal.json.EventImpl;
import com.github.bigtoast.jfly.internal.json.JFlyResponseImpl;
import com.github.bigtoast.jfly.internal.json.OrgImpl;
import com.github.bigtoast.jfly.internal.json.PagenatedResponseImpl;
import com.github.bigtoast.jfly.internal.json.PaymentImpl;
import com.github.bigtoast.jfly.internal.json.VenueImpl;

public class JFlyImpl implements JFly {

	private JsonFactory factory = new JsonFactory();
	
	@Override
	public PagenatedResponse<Event> execute(EventListQuery query) {
		JsonParser parser = executeGet(query.build());
		return new PagenatedResponseImpl<Event,EventImpl>(parser, "events", EventImpl.class);
	}

	@Override
	public PagenatedResponse<Event> execute(PastEventsQuery query) {
		JsonParser parser = executeGet(query.build());
		return new PagenatedResponseImpl<Event,EventImpl>(parser, "events", EventImpl.class);
	}

	@Override
	public PagenatedResponse<Event> execute(UpcomingEventsQuery query) {
		JsonParser parser = executeGet(query.build());
		return new PagenatedResponseImpl<Event,EventImpl>(parser, "events", EventImpl.class);
	}

	@Override
	public PagenatedResponse<Event> execute(JustAnnouncedEventsQuery query) {
		JsonParser parser = executeGet(query.build());
		return new PagenatedResponseImpl<Event,EventImpl>(parser, "events", EventImpl.class);
	}

	@Override
	public PagenatedResponse<Event> execute(FeaturedEventsQuery query) {
		JsonParser parser = executeGet(query.build());
		return new PagenatedResponseImpl<Event,EventImpl>(parser, "events", EventImpl.class);
	}
	
	
	
	@Override
	public PagenatedResponse<Org> execute(OrgListQuery query) {
		JsonParser parser = executeGet(query.build());
		return new PagenatedResponseImpl<Org,OrgImpl>(parser, "orgs", OrgImpl.class);
	}

	@Override
	public PagenatedResponse<Venue> execute(VenueListQuery query) {
		JsonParser parser = executeGet(query.build());
		return new PagenatedResponseImpl<Venue,VenueImpl>(parser, "venues", VenueImpl.class);
	}
	
	@Override
	public CartRequestBuilder cart(){
		return new CartRequestBuilderImpl();
	}
	
	@Override
	public CartRequestBuilder cart( String cartId ){
		return new CartRequestBuilderImpl( cartId );
	}
	
	@Override 
	public JFlyResponse<Cart> execute( AddToCartCommand request ){
		JsonParser parser = executePost( request.build(), request.buildBody() );
		return new JFlyResponseImpl<Cart,CartImpl>( parser, "cart", CartImpl.class);
	}
	
	@Override 
	public JFlyResponse<Cart> execute( GetCartRequest request ){
		JsonParser parser = executeGet( request.build() );
		return new JFlyResponseImpl<Cart,CartImpl>( parser, "cart", CartImpl.class);
	}
	

	@Override
	public AddressBuilder address() {
		return new AddressImpl();
	}

	@Override
	public PaymentBuilder payment() {
		return new PaymentImpl();
	}

	@Override
	public CreditCardBuilder creditCard() {
		return new CreditCardImpl();
	}

	@Override
	public DoAllocate allocate(long inventoryId, int quantity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cart getCart(String cartId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cart getCart(String cartId, boolean includeEventDetail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JFlyResponse<Empty> deleteCart(String cartId) {
		// TODO Auto-generated method stub
		return null;
	}

	protected JsonParser executeGet(String uri){
		DefaultHttpClient client = new DefaultHttpClient();
		HttpGet get = new HttpGet(uri);
		
		try {
			HttpResponse response = client.execute(get);
			StatusLine status = response.getStatusLine();
			int code = status.getStatusCode();
			if ( code == 200 ) {
				HttpEntity entity = response.getEntity();
				InputStream content = entity.getContent();
				return factory.createJsonParser(content);
			} else {
				throw new JFlyException();
			}
			
		} catch ( Exception e ) {
			throw new JFlyException(e);
		}
	}
	
	protected JsonParser executePost(String uri, String body){
		try {
			DefaultHttpClient client = new DefaultHttpClient();
			HttpPost post = new HttpPost(uri);
			StringEntity entity = new StringEntity( body );
			post.setEntity( entity );
			HttpResponse response = client.execute(post);
			if ( 200 == response.getStatusLine().getStatusCode() ) {
				HttpEntity responseEntity = response.getEntity();
				InputStream responseContent = responseEntity.getContent();
				return factory.createJsonParser( responseContent );
			} else {
				throw new JFlyException();
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new JFlyException(e);
		} catch ( IOException e ) {
			throw new JFlyException(e);
		} 	
	}
	
	protected JsonParser executePut(String uri, String body){
		try{
			DefaultHttpClient client = new DefaultHttpClient();
			HttpPut put = new HttpPut(uri);
			StringEntity entity = new StringEntity( body );
			put.setEntity(entity);
			HttpResponse response = client.execute(put);
			if ( 200 == response.getStatusLine().getStatusCode() ) {
				HttpEntity responseEntity = response.getEntity();
				InputStream responseContent = responseEntity.getContent();
				return factory.createJsonParser( responseContent );
			} else {
				throw new JFlyException();
			}
		} catch ( Exception e ) {
			throw new JFlyException(e);
		}
	}
}
