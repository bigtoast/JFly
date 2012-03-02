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

import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonFactory;

import com.github.bigtoast.jfly.Event;
import com.github.bigtoast.jfly.JFly;
import com.github.bigtoast.jfly.api.EventListQuery;
import com.github.bigtoast.jfly.api.FeaturedEventsQuery;
import com.github.bigtoast.jfly.api.JFlyException;
import com.github.bigtoast.jfly.api.JustAnnouncedEventsQuery;
import com.github.bigtoast.jfly.api.PagenatedResponse;
import com.github.bigtoast.jfly.api.PastEventsQuery;
import com.github.bigtoast.jfly.api.UpcomingEventsQuery;
import com.github.bigtoast.jfly.internal.json.EventImpl;
import com.github.bigtoast.jfly.internal.json.PagenatedResponseImpl;

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

}
