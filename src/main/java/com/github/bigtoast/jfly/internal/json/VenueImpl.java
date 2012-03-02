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

import java.io.IOException;
import java.net.URL;
import org.codehaus.jackson.*;

import com.github.bigtoast.jfly.ImageMeta;
import com.github.bigtoast.jfly.Venue;

public class VenueImpl implements Venue {

	private static final long serialVersionUID = 8447681850655594805L;
	private long id;
	private String name;
	private String timeZone;
	private String address1;
	private String address2;
	private String city;
	private String stateProvince;
	private String postalCode;
	private String country;
	private URL siteUrl;
	private String description;
	private URL facebookUrl;
	private URL twitterUrl;
	private double latitude;
	private double longitude;
	private ImageMeta image;
	
	
	public VenueImpl(JsonParser parser) throws JsonParseException, IOException{
		if (parser.nextToken() != JsonToken.START_OBJECT) {
		    throw new IOException("Expected data to start with an Object");
		  }
	      
	      while ( parser.nextToken() != JsonToken.END_OBJECT ){
	    	  String fname = parser.getCurrentName();
	          parser.nextToken();
	          
	          if ( fname.equals("id") )
	        	  id = parser.getLongValue();
	          else if ( fname.equals("name") )
	        	  name = parser.getText();
	          else if ( fname.equals("timeZone") )
	        	  timeZone = parser.getText();
	          else if ( fname.equals("address1") )
	        	  address1 = parser.getText();
	          else if ( fname.equals("address2") )
	        	  address2 = parser.getText();
	          else if ( fname.equals("city") )
	        	  city = parser.getText();
	          else if ( fname.equals("stateProvice") )
	        	  stateProvince = parser.getText();
	          else if ( fname.equals("postalCode") )
	        	  postalCode = parser.getText();
	          else if ( fname.equals("country"))
	        	  country = parser.getText();
	          else if ( fname.equals("url") )
	        	  siteUrl = new URL( parser.getText() );
	          else if ( fname.equals("blurb") )
	        	  description = parser.getText();
	          else if ( fname.equals("urlFacebook"))
	        	  facebookUrl = new URL( parser.getText() );
	          else if ( fname.equals("urlTwitter"))
	        	  twitterUrl = new URL( parser.getText() );
	          else if ( fname.equals("lat") )
	        	  latitude = parser.getDoubleValue();
	          else if ( fname.equals("lng") )
	        	  longitude = parser.getDoubleValue();
	          else if ( fname.equals("image") )
	        	  image = new ImageMetaImpl( parser );
	      }
	}

	@Override
	public long getId() { return id; }

	@Override
	public String getName() { return name; }

	@Override
	public String getTimeZone() { return timeZone; }
	
	@Override
	public String getAddress1() { return address1; }

	@Override
	public String getAddress2() { return address2; }

	@Override
	public String getCity() { return city; }

	@Override
	public String getStateProvice() { return stateProvince; }
	@Override
	public String getPostalCode() { return postalCode; }

	@Override
	public String getCountry() { return country; }

	@Override
	public URL getWebsiteUrl() { return siteUrl; }

	@Override
	public String getDescription() { return description; }

	@Override
	public URL getFacebookUrl() { return facebookUrl; }

	@Override
	public URL getTwitterUrl() { return twitterUrl; }

	@Override
	public double getLatitude() { return latitude; }

	@Override
	public double getLongitude() { return longitude; }

	@Override
	public ImageMeta getImage() { return image; }

}
