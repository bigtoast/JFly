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

import com.github.bigtoast.jfly.ImageMeta;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;

public class ImageMetaImpl implements ImageMeta {
	private ImageDetailMeta original;
	private ImageDetailMeta square;
	private ImageDetailMeta squareSmall;
	private ImageDetailMeta small;
	private ImageDetailMeta small1;
	private ImageDetailMeta medium;
	private ImageDetailMeta medium1;
	private ImageDetailMeta large;
	private ImageDetailMeta large1;
	private ImageDetailMeta xLarge;
	private ImageDetailMeta xLarge1;
	
	public static class ImageDetailMetaImpl implements ImageMeta.ImageDetailMeta{
		private int width;
		private int height;
		private URL url;
		
		public ImageDetailMetaImpl(JsonParser parser) throws JsonParseException, IOException{
		if (parser.nextToken() != JsonToken.START_OBJECT) {
	        throw new IOException("Expected data to start with an Object");
	      }
	      
	      while ( parser.nextToken() != JsonToken.END_OBJECT){
	        String fname = parser.getCurrentName();
	    	parser.nextToken();
	    	
	    	if (fname.equals("width")) 
			    width = parser.getIntValue();
		   
		   else if (fname.equals("height")) 
		    height = parser.getIntValue();
		    
		   else if (fname.equals("path")) 
		    url = new URL(parser.getText());
	    	  
	      }
		}
		
		
		@Override
		public int getWidth() { return width; }

		@Override
		public int getHeight() { return height; }

		@Override
		public URL getUrl() { return url; }		
	}
	
	public ImageMetaImpl(JsonParser parser) throws JsonParseException, IOException {
		  if (parser.nextToken() != JsonToken.START_OBJECT) {
		    throw new IOException("Expected data to start with an Object");
		  }

		  while (parser.nextToken() != JsonToken.END_OBJECT) {
		   String fname = parser.getCurrentName();
		   parser.nextToken();
		   
		   if ( fname.equals("original") ) 
			   original = new ImageDetailMetaImpl( parser );
		   else if ( fname.equals("square") ) 
			   square = new ImageDetailMetaImpl( parser );
		   else if ( fname.equals("squareSmall") ) 
			   squareSmall = new ImageDetailMetaImpl( parser );
		   else if ( fname.equals("small") ) 
			   small = new ImageDetailMetaImpl( parser );
		   else if ( fname.equals("small1") ) 
			   small1 = new ImageDetailMetaImpl( parser );
		   else if ( fname.equals("medium") ) 
			   medium = new ImageDetailMetaImpl( parser );
		   else if ( fname.equals("medium1") ) 
			   medium1 = new ImageDetailMetaImpl( parser );
		   else if ( fname.equals("large") ) 
			   large = new ImageDetailMetaImpl( parser );
		   else if ( fname.equals("large1") ) 
			   large1 = new ImageDetailMetaImpl( parser );
		   else if ( fname.equals("xlarge") ) 
			   xLarge = new ImageDetailMetaImpl( parser );
		   else if ( fname.equals("xLarge1") ) 
			   xLarge1 = new ImageDetailMetaImpl( parser );
		   
		  }
		   
	}
	
	public ImageDetailMeta getOriginal() {
		return original;
	}

	public ImageDetailMeta getSquare() {
		return square;
	}

	public ImageDetailMeta getSquareSmall() {
		return squareSmall;
	}

	public ImageDetailMeta getSmall() {
		return small;
	}

	public ImageDetailMeta getSmall1() {
		return small1;
	}

	public ImageDetailMeta getMedium() {
		return medium;
	}

	public ImageDetailMeta getMedium1() {
		return medium1;
	}

	public ImageDetailMeta getLarge() {
		return large;
	}

	public ImageDetailMeta getLarge1() {
		return large1;
	}

	public ImageDetailMeta getXLarge() {
		return xLarge;
	}

	public ImageDetailMeta getXLarge1() {
		return xLarge1;
	}


}
