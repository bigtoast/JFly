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
package com.github.bigtoast.jfly.api;

public enum EventField {
	ID("id"),
	DATE_CREATED("dateCreated"),
	FEATURED("featured"),
	PUBLISHED("published"),
	PUBLISH_DATE("publishDate"),
	NAME("name"),
	HEADLINERS_NAME("headlinersName"),
	SUPPORTS_NAME("supportsName"),
	IMAGE("image"),
	START_DATAE("startDate"),
	END_DATE("endDate"),
	DOORS_DATE("doorsDate"),
	ON_SALE_DATE("onSaleDate"),
	OFF_SALE_DATE("offSaleDate"),
	TOP_LINE_INFO("topLineInfo"),
	PROMOTER_NAME("promoterName"),
	SPONSER_NAME("sponsorName"),
	SPONSER_IMAGE("sponsorImage"),
	ADDITIONAL_INFO("additionalInfo"),
	AGE_LIMIT_CODE("ageLimitCode"),
	AGE_LIMIT("ageLimit"),
	AGE_TYPE_CODE("showTypeCode"),
	SHOW_TYPE("showType"),
	EVENT_STATUS_CODE("eventStatusCode"),
	EVENT_STATUS("eventStatus"),
	EVENT_STATUS_MESSAGE("eventStatusMessage"),
	TICKET_PURCHASE_URL("ticketPurchaseUrl"),
	TICKET_PRICE("ticketPrice"),
	EXTERNAL_TICKETING_URLS("externalTicketingUrls"),
	FACEBOOK_EVENT_ID("facebookEventId"),
	IS_MOBILE_FRIENDLY("isMobileFriendly"),
	HEADLINERS_ID("headliners.id"),
	HEADLINER_NAME("headliners.name"),
	HEADLINER_START_TIME("headliners.startTime"),
	HEADLINER_DESCRIPTION("headliners.eventDescription"),
	HEADLINER_WEBSITE_URL("headliners.urlOfficialWebsite"),
	HEADLINER_MYSPACE_URL("headliners.urlMySpace"),
	HEADLINER_FACEBOOK_URL("headliners.urlFacebook"),
	HEADLINER_TWITTER_URL("headliners.urlTwitter"),
	HEADLINER_AUDIO_URL("headliners.urlAudio"),
	HEADLINER_MUSIC_PUCHASE_URL("headliners.urlPurchaseMusic"),
	HEADLINER_EMBED_AUDIO("headliners.embedAudio"),
	HEADLINER_EMBED_VIDEO("headliners.embedVideo"),
	HEADLINER_IMAGE_ORIGINAL("headliners.image.original"),
	HEADLINER_IMAGE_XLARGE("headliners.image.xlarge"),
	HEADLINER_IMAGE_LARGE("headliners.image.large"),
	HEADLINER_IMAGE_MEDIUM("headliners.image.medium"),
	HEADLINER_IMAGE_SMALL("headliners.image.small"),
	HEADLINER_IMAGE_XLARGE1("headliners.image.xlarge1"),
	HEADLINER_IMAGE_LARGE1("headliners.image.large1"),
	HEADLINER_IMAGE_MEDIUM1("headliners.image.medium1"),
	HEADLINER_IMAGE_SMALL1("headliners.image.small1"),
	HEADLINER_IMAGE_SQUARE("headliners.image.square"),
	HEADLINER_IMAGE_SQUARE_SMALL("headliners.image.squareSmall"),
	SUPPORTS_ID("supports.id"),
	SUPPORT_NAME("supports.name"),
	SUPPORT_START_TIME("supports.startTime"),
	SUPPORT_DESCRIPTION("supports.eventDescription"),
	SUPPORT_WEBSITE_URL("supports.urlOfficialWebsite"),
	SUPPORT_MYSPACE_URL("supports.urlMySpace"),
	SUPPORT_FACEBOOK_URL("supports.urlFacebook"),
	SUPPORT_TWITTER_URL("supports.urlTwitter"),
	SUPPORT_AUDIO_URL("supports.urlAudio"),
	SUPPORT_MUSIC_PUCHASE_URL("supports.urlPurchaseMusic"),
	SUPPORT_EMBED_AUDIO("supports.embedAudio"),
	SUPPORT_EMBED_VIDEO("supports.embedVideo"),
	SUPPORT_IMAGE_ORIGINAL("supports.image.original"),
	SUPPORT_IMAGE_XLARGE("supports.image.xlarge"),
	SUPPORT_IMAGE_LARGE("supports.image.large"),
	SUPPORT_IMAGE_MEDIUM("supports.image.medium"),
	SUPPORT_IMAGE_SMALL("supports.image.small"),
	SUPPORT_IMAGE_XLARGE1("supports.image.xlarge1"),
	SUPPORT_IMAGE_LARGE1("supports.image.large1"),
	SUPPORT_IMAGE_MEDIUM1("supports.image.medium1"),
	SUPPORT_IMAGE_SMALL1("supports.image.small1"),
	SUPPORT_IMAGE_SQUARE("supports.image.square"),
	SUPPORT_IMAGE_SQUARE_SMALL("supports.image.squareSmall"),
	ORG_ID("org.id"),
	VENUE_ID("venue.id"),
	VENUE_NAME("venue.name"),
	VENUE_TIME_ZONE("venue.timeZone"),
	VENUE_ADDRESS1("venue.address1"),
	VENUE_ADDRESS2("venue.address2"),
	VENUE_CITY("venue.city"),
	VENUE_STATE_PROVINCE("venue.stateProvince"),
	VENUE_POSTAL_CODE("venue.postalCode"),
	VENUE_COUNTRY("venue.country"),
	VENUE_WEBSITE_URL("venue.url"),
	VENUE_DESCRIPTION("venue.blurb"),
	VENUE_FACEBOOK_URL("venue.urlFacebook"),
	VENUE_TWITTER_URL("venue.urlTwitter"),
	VENUE_LATITUDE("venue.lat"),
	VENUE_LONGITUDE("venue.lng"),
	VENUE_IMAGE("venue.image"),
	EVENT_DETAILS_URL("urlEventDetailsUrl");

	
	private final String str;
	
    EventField(String str){
    	this.str = str;
    }
    
    @Override
    public String toString(){
    	return this.str;
    }
    
}
