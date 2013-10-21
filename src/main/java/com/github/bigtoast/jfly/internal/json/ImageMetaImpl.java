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

import com.github.bigtoast.jfly.internal.util.JFlyUtils;
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
	
	public static class ImageDetailMetaImpl implements ImageMeta.ImageDetailMeta {
		private int width;
		private int height;
		private URL url;
		
		public ImageDetailMetaImpl(JsonParser parser) throws JsonParseException, IOException{
            if (parser.getCurrentToken() != JsonToken.START_OBJECT) {
                if ( parser.getCurrentToken() == JsonToken.VALUE_NULL )
                    return;
                throw new IOException("Expected data to start with an Object. Found " + parser.getCurrentToken() );
            }

            while ( parser.nextToken() != JsonToken.END_OBJECT ){
                String fName = parser.getCurrentName();
                parser.nextToken();

                if (fName.equals("width"))
                    width = parser.getIntValue();

                else if (fName.equals("height"))
                    height = parser.getIntValue();

                else if (fName.equals("path"))
                    url = JFlyUtils.parseURL(parser.getText());

                else if ( parser.getCurrentToken() == JsonToken.START_OBJECT || parser.getCurrentToken() == JsonToken.START_ARRAY )
                    parser.skipChildren();

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
        if (parser.getCurrentToken() != JsonToken.START_OBJECT) {
            if ( parser.getCurrentToken() == JsonToken.VALUE_NULL )
                return;
            throw new IOException("Expected data to start with an Object. Found " + parser.getCurrentToken() );
        }

        while (parser.nextToken() != JsonToken.END_OBJECT) {
            String fName = parser.getCurrentName();
            parser.nextToken();

            if ( fName.equals("original") )
               original = new ImageDetailMetaImpl( parser );
            else if ( fName.equals("square") )
               square = new ImageDetailMetaImpl( parser );
            else if ( fName.equals("squareSmall") )
               squareSmall = new ImageDetailMetaImpl( parser );
            else if ( fName.equals("small") )
               small = new ImageDetailMetaImpl( parser );
            else if ( fName.equals("small1") )
               small1 = new ImageDetailMetaImpl( parser );
            else if ( fName.equals("medium") )
               medium = new ImageDetailMetaImpl( parser );
            else if ( fName.equals("medium1") )
               medium1 = new ImageDetailMetaImpl( parser );
            else if ( fName.equals("large") )
               large = new ImageDetailMetaImpl( parser );
            else if ( fName.equals("large1") )
               large1 = new ImageDetailMetaImpl( parser );
            else if ( fName.equals("xlarge") )
               xLarge = new ImageDetailMetaImpl( parser );
            else if ( fName.equals("xLarge1") )
               xLarge1 = new ImageDetailMetaImpl( parser );
            else if ( parser.getCurrentToken() == JsonToken.START_OBJECT || parser.getCurrentToken() == JsonToken.START_ARRAY )
                parser.skipChildren();

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
