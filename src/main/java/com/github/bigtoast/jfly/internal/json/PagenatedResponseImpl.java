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

import java.lang.reflect.Constructor;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;

import org.codehaus.jackson.*;

import com.github.bigtoast.jfly.api.JFlyException;
import com.github.bigtoast.jfly.api.PagenatedResponse;

public class PagenatedResponseImpl<T, C extends T> extends LinkedList<T> implements PagenatedResponse<T> {
	
	private static final long serialVersionUID = 744029436975246680L;
	
	public static String PAGE_NUM      = "pageNum";
	public static String TOTAL_PAGES   = "totalPages";
	public static String MAX_RESULTS   = "maxResults";
	public static String TOTAL_RESULTS = "totalResults";
	public static String STATUS        = "status";
	public static String LINK          = "link";
	
	private int pageNum;
	private int totalPages;
	private int maxResults;
	private int totalResults;
	private String status;
	private URL link;

	public PagenatedResponseImpl(JsonParser parser, String resultsTag, Class<C> clazz ) throws JFlyException {
      try {
    	if (parser.nextToken() != JsonToken.START_OBJECT) {
          throw new JFlyException("Expected data to start with an Object");
        }
        Constructor<C> cons = clazz.getConstructor(JsonParser.class);
        
        while ( parser.nextToken() != JsonToken.END_OBJECT ){
    	    String fname = parser.getCurrentName();
    	    parser.nextToken();
    	    
    	    if ( fname.equals(PAGE_NUM) ) setPageNum( parser.getIntValue() );
    	    else if ( fname.equals(TOTAL_PAGES)) setTotalPages(parser.getIntValue());
    	    else if ( fname.equals(MAX_RESULTS)) setMaxResults(parser.getIntValue());
    	    else if ( fname.equals(TOTAL_RESULTS)) setTotalResults(parser.getIntValue());
    	    else if ( fname.equals(STATUS)) setStatus(parser.getText());
    	    else if ( fname.equals(LINK)) setLink(parser.getText());
    	    else if ( fname.equals(resultsTag)) {
    	      if ( parser.nextToken().equals(JsonToken.START_ARRAY)) {
          		while ( parser.nextToken() != JsonToken.END_ARRAY ){
          		  add(cons.newInstance(parser));
          	    }
          	  }
    	    }
    	          
    	  }
      } catch (Exception e){
    	throw new JFlyException("could not create class", e);  
      } 
      	  
	}
	
	@Override
	public String getStatus() { return status; }

	@Override
	public int getPageNum() { return pageNum; }

	@Override
	public int totalPages() { return totalPages; }

	@Override
	public int maxResults() { return maxResults; }

	@Override
	public int totalResults() { return totalResults; }

	@Override
	public URL getLink() { return link; }
	
	public void setLink(URL link){
		this.link = link;
	}
	
	public void setLink(String link) throws MalformedURLException{
		this.link = new URL(link);
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public void setMaxResults(int maxResults) {
		this.maxResults = maxResults;
	}

	public void setTotalResults(int totalResults) {
		this.totalResults = totalResults;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
}
