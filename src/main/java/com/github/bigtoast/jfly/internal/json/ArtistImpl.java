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

import java.util.LinkedList;
import java.util.List;
import java.io.IOException;
import java.net.URL;

import com.github.bigtoast.jfly.Artist;
import com.github.bigtoast.jfly.ImageMeta;
import com.github.bigtoast.jfly.YouTubeMeta;

import org.codehaus.jackson.*;

public class ArtistImpl implements Artist {

	private static final long serialVersionUID = -5828314561317895401L;
	private long id;
	private String name;
	private String description = "";
	private URL siteUrl;
	private URL myspaceUrl;
	private URL facebookUrl;
	private URL twitterUrl;
	private String twitterScreenName;
	private URL audioUrl;
	private URL purchaseUrl;
	private String audioHtml;
	private String videoHtml;
	private boolean mobileFriendly;
	private List<ImageMeta> images = new LinkedList<ImageMeta>();
	private List<YouTubeMeta> youTubeVideos = new LinkedList<YouTubeMeta>();;
	
	public ArtistImpl(JsonParser parser) throws JsonParseException, IOException{
      if (parser.nextToken() != JsonToken.START_OBJECT) {
        throw new IOException("Expected data to start with an Object");
      }
      
      while ( parser.nextToken() != JsonToken.END_OBJECT){
    	  String fname = parser.getCurrentName();
    	  parser.nextToken();
    	  
    	  if ( fname.equals("id") )
    	    id = parser.getLongValue();
    	  else if ( fname.equals("name"))
    		name = parser.getText();
    	  else if ( fname.equals("eventDescription"))
    		description = parser.getText();
    	  else if ( fname.equals("urlOfficialWebsite"))
    		siteUrl = new URL( parser.getText());
    	  else if ( fname.equals("urlMySpace"))
    		myspaceUrl = new URL( parser.getText());
    	  else if ( fname.equals("urlFacebook"))
    	    facebookUrl = new URL( parser.getText());
    	  else if ( fname.equals("twitterScreenName"))
    		twitterScreenName = parser.getText();
    	  else if ( fname.equals("urlAudio"))
    		audioUrl = new URL( parser.getText() );
    	  else if ( fname.equals("urlPurchaseMusic"))
    		purchaseUrl = new URL( parser.getText());
    	  else if ( fname.equals("embedAudio"))
    		audioHtml = parser.getText();
    	  else if ( fname.equals("embedVideo"))
    		videoHtml = parser.getText();
    	  else if ( fname.equals("idMobileFriendly") )
    		mobileFriendly = parser.getBooleanValue();
    	  else if ( fname.equals("images") ) {
    		  if ( parser.nextToken().equals(JsonToken.START_ARRAY)) {
    		    while ( parser.nextToken() != JsonToken.END_ARRAY ){
    		    	images.add( new ImageMetaImpl( parser ) );
    		    }
    		  }
    	  } else if ( fname.equals("youtubeVideos")) {
    		  if ( parser.nextToken().equals(JsonToken.START_ARRAY)) {
      		    while ( parser.nextToken() != JsonToken.END_ARRAY ){
      		    	youTubeVideos.add( new YouTubeMetaImpl( parser ) );
      		    }
      		  }
    	  }  
      } // end while
	}
	
	
	@Override
	public long getId() { return id; }

	@Override
	public String getName() { return name; }

	@Override
	public String getDescription() { return description; }

	@Override
	public URL getOfficalWebsiteUrl() { return siteUrl; }

	@Override
	public URL getMySpaceUrl() { return myspaceUrl; }

	@Override
	public URL getFacebookUrl() { return facebookUrl; }

	@Override
	public URL getTwitterUrl() { return twitterUrl; }

	@Override
	public String getTwitterScreenName() { return twitterScreenName; }

	@Override
	public URL getAudioUrl() { return audioUrl; }

	@Override
	public URL getMusicPurchaseUrl() { return purchaseUrl; }

	@Override
	public String getEmbededAudioHtml() { return audioHtml; }

	@Override
	public String getEmbededVideoHtml() { return videoHtml; }

	@Override
	public boolean isMobileFriendly() { return mobileFriendly; }

	@Override
	public List<ImageMeta> getImages() { return images; }

	@Override
	public List<YouTubeMeta> getYouTubeVideos() { return youTubeVideos; }

}
