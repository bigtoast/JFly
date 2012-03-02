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
package com.github.bigtoast.jfly;

import java.net.URL;

public interface ImageMeta {
	
	public interface ImageDetailMeta {
	  public int getWidth();
	  public int getHeight();
	  public URL getUrl();
	}
	
	public ImageDetailMeta getOriginal();
	public ImageDetailMeta getSquare();
	public ImageDetailMeta getSquareSmall();
	public ImageDetailMeta getSmall();
	public ImageDetailMeta getSmall1();
	public ImageDetailMeta getMedium();
	public ImageDetailMeta getMedium1();
	public ImageDetailMeta getLarge();
	public ImageDetailMeta getLarge1();
	public ImageDetailMeta getXLarge();
	public ImageDetailMeta getXLarge1();
	
	public enum ImageType {
		ORIGINAL,
	    SQUARE,
	    SQUARE_SMALL,
	    LARGE, LARGE1,
	    MEDIUM, MEDIUM1,
	    SMALL, SMALL1,
	    XLARGE, XLARGE1
	}
}
