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

import com.github.bigtoast.jfly.YouTubeMeta;

import org.codehaus.jackson.*;

public class YouTubeMetaImpl implements YouTubeMeta {

	private String title;
	private String iframe;
	private String videoId;
	
	
	public YouTubeMetaImpl(JsonParser parser) throws JsonParseException, IOException {
        if (parser.getCurrentToken() != JsonToken.START_OBJECT) {
            if ( parser.getCurrentToken() == JsonToken.VALUE_NULL )
                return;
            throw new IOException("Expected data to start with an Object. Found " + parser.getCurrentToken() );
        }
      
      while ( parser.nextToken() != JsonToken.END_OBJECT ){
    	  String fName = parser.getCurrentName();
          parser.nextToken();
          
          if ( fName.equals("videoId") )
            videoId = parser.getText();
          else if ( fName.equals("title") )
        	title = parser.getText();
          else if ( fName.equals("embedCodeIframe"))
        	iframe = parser.getText();
          else if ( parser.getCurrentToken() == JsonToken.START_OBJECT || parser.getCurrentToken() == JsonToken.START_ARRAY )
              parser.skipChildren();
      }
	}
	
	
	@Override
	public String getTitle() { return title; }

	@Override
	public String getVideoId() { return videoId; }

	@Override
	public String getIFrameHtml() { return iframe; }

}
