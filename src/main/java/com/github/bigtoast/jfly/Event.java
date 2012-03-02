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
import java.net.URL;
import java.util.List;

import org.joda.time.DateTime;


public interface Event extends Serializable {
	
	public long getId();
	public DateTime getDateCreated();
	public boolean isFeatured();
	public boolean isPublished();
	public String getName();
	public String getHeadlinerName();
	public String getSupportersName();
	public ImageMeta getImage();
	public DateTime getPublishDate();
	public DateTime getStartDate();
	public DateTime getEndDate();
	public DateTime getDoorsDate();
	public DateTime getOnSaleDate();
	public DateTime getOffSaleDate();
	public List<DateTime> getOnSaleDates();
	public String getTopLineInfo();
	public String getPromoterName();
	public String getSponserName();
	public ImageMeta getSponserImage();
	public String getAdditionalInfo();
	public String getAdditionalTicketText();
	public String getAgeLimitCode();
	public String getAgeLimit();
	public String getShowTypeCode();
	public String getShowType();
	public String getEventStatusCode();
	public String getEventStatus();
	public String getEventStatusMessage();
	public URL getTicketPurchaseUrl();
	public String getTicketPrice();
	public DateTime getLastUpdated();
	public List<URL> getExternalTicketingUrls();
	public Org getOrg();
	public long getFacebookEventId();
	public List<Artist> getHeadliners();
	public List<Artist> getSupporters();
	public Venue getVenue();
	public URL getEventDetailsUrl();

}
