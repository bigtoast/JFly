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

import java.io.Serializable;
import java.util.List;
import java.net.URL;

		
public interface Artist extends Serializable {
	public long getId();
	public String getName();
	public String getDescription();
	public URL getOfficalWebsiteUrl();
	public URL getMySpaceUrl();
	public URL getFacebookUrl();
	public URL getTwitterUrl();
	public String getTwitterScreenName();
	public URL getAudioUrl();
	public URL getMusicPurchaseUrl();
	public String getEmbededAudioHtml();
	public String getEmbededVideoHtml();
	public boolean isMobileFriendly();
	public List<ImageMeta> getImages();
	public List<YouTubeMeta> getYouTubeVideos();
	
}
