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
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

import com.github.bigtoast.jfly.internal.util.JFlyUtils;
import org.codehaus.jackson.*;
import org.joda.time.DateTime;

import com.github.bigtoast.jfly.Artist;
import com.github.bigtoast.jfly.Event;
import com.github.bigtoast.jfly.ImageMeta;
import com.github.bigtoast.jfly.Org;
import com.github.bigtoast.jfly.Venue;

public class EventImpl implements Event {

    private static final long serialVersionUID = 8817714558870714367L;

    public static String ID = "id";
    public static String DATE_CREATED = "dateCreated";
    public static String FEATURED = "featured";
    public static String PUBLISHED = "published";
    public static String NAME = "name";
    public static String HEADLINER_NAME = "headlinersName";
    public static String SUPPORTERS_NAME = "supportersName";
    public static String IMAGE = "image";
    public static String PUBLISH_DATE = "publishDate";
    public static String START_DATE = "startDate";
    public static String END_DATE = "endDate";
    public static String DOORS_DATE = "doorsDate";
    public static String ON_SALE_DATE = "onSaleDate";
    public static String OFF_SALE_DATE = "offSaleDate";
    public static String ON_SALE_DATES = "onSaleDates";
    public static String TOP_LINE_INFO = "topLineInfo";
    public static String PROMOTER_NAME = "promoterName";
    public static String SPONSOR_NAME = "sponsorName";
    public static String SPONSOR_IMAGE = "sponsorImage";
    public static String ADDITIONAL_INFO = "additionalInfo";
    public static String ADDITIONAL_TICKET_TEXT = "additionalTicketText";
    public static String AGE_LIMIT_CODE = "ageLimitCode";
    public static String AGE_LIMIT = "ageLimit";
    public static String SHOW_TYPE_CODE = "showTypeCode";
    public static String SHOW_TYPE = "showType";
    public static String EVENT_STATUS_CODE = "eventStatusCode";
    public static String EVENT_STATUS = "eventStatus";
    public static String EVENT_STATUS_MESSAGE = "eventStatusMessage";
    public static String TICKET_PURCHASE_URL = "ticketPurchaseUrl";
    public static String TICKET_PRICE = "ticketPrice";
    public static String LAST_UPDATED = "lastUpdated";
    public static String EXTERNAL_TICKETING_URLS = "externalTicketingUrls";
    public static String ORG = "org";
    public static String FACEBOOK_EVENT_ID = "facebookEventId";
    public static String HEADLINERS = "headliners";
    public static String SUPPORTERS = "supporters";
    public static String VENUE = "venue";
    public static String EVENT_DETAILS_URL = "eventDetailsUrl";

    public static class OnSaleDateImpl implements OnSaleDate {
        private String name;
        private DateTime startDate;
        private DateTime endDate;

        public OnSaleDateImpl(String name, DateTime startDate, DateTime endDate  ) {
            this.name = name;
            this.startDate = startDate;
            this.endDate = endDate;
        }

        public OnSaleDateImpl(JsonParser parser) throws JsonParseException, IOException {
            if (parser.getCurrentToken() != JsonToken.START_OBJECT) {
                if (parser.getCurrentToken() == JsonToken.VALUE_NULL)
                    return;
                throw new IOException("Expected data to start with an Object. Found " + parser.getCurrentToken());
            }

            while (parser.nextToken() != JsonToken.END_OBJECT) {
                String fName = parser.getCurrentName();
                parser.nextToken();

                if ("name".equals(fName))
                    name = parser.getText();
                else if ("startDate".equals(fName))
                    startDate = JFlyUtils.parse(parser.getText());
                else if ("endDate".equals(fName))
                    endDate = JFlyUtils.parse(parser.getText());
            }
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public DateTime getStartDate() {
            return startDate;
        }

        public void setStartDate(DateTime startDate) {
            this.startDate = startDate;
        }

        public DateTime getEndDate() {
            return endDate;
        }

        public void setEndDate(DateTime endDate) {
            this.endDate = endDate;
        }
    }

    private Long id;
    private DateTime dateCreated;
    private boolean featured;
    private boolean published;
    private String name;
    private String headlinerName;
    private String supportersName;
    private ImageMeta image;
    private DateTime publishDate;
    private DateTime startDate;
    private DateTime endDate;
    private DateTime doorsDate;
    private DateTime onSaleDate;
    private DateTime offSaleDate;
    private List<OnSaleDate> onSaleDates = new LinkedList<OnSaleDate>();
    private String topLineInfo;
    private String promoterName;
    private String sponsorName;
    private ImageMeta sponsorImage;
    private String additionalInfo;
    private String additionalTicketText;
    private String ageLimitCode;
    private String ageLimit;
    private String showTypeCode;
    private String showType;
    private String eventStatusCode;
    private String eventStatus;
    private String eventStatusMessage;
    private URL ticketPurchaseUrl;
    private String ticketPrice;
    private DateTime lastUpdated;
    private List<URL> externalTicketingUrls = new LinkedList<URL>();
    private Org org;
    private Long facebookEventId;
    private List<Artist> headliners = new LinkedList<Artist>();
    private List<Artist> supporters = new LinkedList<Artist>();
    private Venue venue;
    private URL eventDetailsUrl;


    public EventImpl(JsonParser parser) throws JsonParseException, IOException {
        if (parser.getCurrentToken() != JsonToken.START_OBJECT) {
            if (parser.getCurrentToken() == JsonToken.VALUE_NULL)
                return;
            throw new IOException("Expected data to start with an Object. Found " + parser.getCurrentToken());
        }

        while (parser.nextToken() != JsonToken.END_OBJECT) {
            String fName = parser.getCurrentName();
            parser.nextToken();

            if (fName.equals(ID)) setId(parser.getLongValue());
            else if (fName.equals(DATE_CREATED)) setDateCreated(parser.getText());
            else if (fName.equals(FEATURED)) setIsFeatured(parser.getBooleanValue());
            else if (fName.equals(PUBLISHED)) setIsPublished(parser.getBooleanValue());
            else if (fName.equals(NAME)) setName(parser.getText());
            else if (fName.equals(HEADLINER_NAME)) setHeadlinerName(parser.getText());
            else if (fName.equals(SUPPORTERS_NAME)) setSupportersName(parser.getText());
            else if (fName.equals(IMAGE)) setImage(new ImageMetaImpl(parser));
            else if (fName.equals(PUBLISH_DATE)) setPublishDate(parser.getText());
            else if (fName.equals(START_DATE)) setStartDate(parser.getText());
            else if (fName.equals(END_DATE)) setEndDate(parser.getText());
            else if (fName.equals(DOORS_DATE)) setDoorsDate(parser.getText());
            else if (fName.equals(ON_SALE_DATE)) setOnSaleDate(parser.getText());
            else if (fName.equals(OFF_SALE_DATE)) setOffSaleDate(parser.getText());
            else if (fName.equals(ON_SALE_DATES)) {
                if (parser.getCurrentToken().equals(JsonToken.START_ARRAY)) {
                    while (parser.nextToken() != JsonToken.END_ARRAY) {
                        addToOnSaleDates( new OnSaleDateImpl(parser) );
                    }
                }
            } else if (fName.equals(TOP_LINE_INFO)) setTopLineInfo(parser.getText());
            else if (fName.equals(PROMOTER_NAME)) setPromoterName(parser.getText());
            else if (fName.equals(SPONSOR_NAME)) setsponsorName(parser.getText());
            else if (fName.equals(SPONSOR_IMAGE)) setsponsorImage(new ImageMetaImpl(parser));
            else if (fName.equals(ADDITIONAL_INFO)) setAdditionalInfo(parser.getText());
            else if (fName.equals(ADDITIONAL_TICKET_TEXT)) setAdditionalTicketText(parser.getText());
            else if (fName.equals(AGE_LIMIT_CODE)) setAgeLimitCode(parser.getText());
            else if (fName.equals(AGE_LIMIT)) setAgeLimit(parser.getText());
            else if (fName.equals(SHOW_TYPE_CODE)) setShowTypeCode(parser.getText());
            else if (fName.equals(SHOW_TYPE)) setShowType(parser.getText());
            else if (fName.equals(EVENT_STATUS_CODE)) setEventStatusCode(parser.getText());
            else if (fName.equals(EVENT_STATUS)) setEventStatus(parser.getText());
            else if (fName.equals(EVENT_STATUS_MESSAGE)) setEventStatusMessage(parser.getText());
            else if (fName.equals(TICKET_PURCHASE_URL)) setTicketPurchaseUrl(parser.getText());
            else if (fName.equals(TICKET_PRICE)) setTicketPrice(parser.getText());
            else if (fName.equals(LAST_UPDATED)) setLastUpdated(parser.getText());
            else if (fName.equals(EXTERNAL_TICKETING_URLS)) {
                if (parser.getCurrentToken().equals(JsonToken.START_ARRAY)) {
                    while (parser.nextToken() != JsonToken.END_ARRAY) {
                        addToExternalTicketingUrls(parser.getText());
                    }
                }
            } else if (fName.equals(ORG)) setOrg(new OrgImpl(parser));
            else if (fName.equals(FACEBOOK_EVENT_ID)) setFacebookEventId( JFlyUtils.parseLong( parser.getText() ) );
            else if (fName.equals(HEADLINERS)) {
                if (parser.getCurrentToken().equals(JsonToken.START_ARRAY)) {
                    while (parser.nextToken() != JsonToken.END_ARRAY) {
                        addToHeadliners(new ArtistImpl(parser));
                    }
                }
            } else if (fName.equals(SUPPORTERS)) {
                if (parser.getCurrentToken().equals(JsonToken.START_ARRAY)) {
                    while (parser.nextToken() != JsonToken.END_ARRAY) {
                        addToSupporters(new ArtistImpl(parser));
                    }
                }
            } else if (fName.equals(VENUE)) setVenue(new VenueImpl(parser));
            else if (fName.equals(EVENT_DETAILS_URL)) setEventDetailsUrl(parser.getText());
            else if ( parser.getCurrentToken() == JsonToken.START_OBJECT || parser.getCurrentToken() == JsonToken.START_ARRAY ) {
                parser.skipChildren();
            }
        }
    }


    @Override
    public Long getId() {
        return id;
    }

    @Override
    public DateTime getDateCreated() {
        return dateCreated;
    }

    @Override
    public boolean isFeatured() {
        return featured;
    }

    @Override
    public boolean isPublished() {
        return published;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getHeadlinerName() {
        return headlinerName;
    }

    @Override
    public String getSupportersName() {
        return supportersName;
    }

    @Override
    public ImageMeta getImage() {
        return image;
    }

    @Override
    public DateTime getPublishDate() {
        return publishDate;
    }

    @Override
    public DateTime getStartDate() {
        return startDate;
    }

    @Override
    public DateTime getEndDate() {
        return endDate;
    }

    @Override
    public DateTime getDoorsDate() {
        return doorsDate;
    }

    @Override
    public DateTime getOnSaleDate() {
        return onSaleDate;
    }

    @Override
    public DateTime getOffSaleDate() {
        return offSaleDate;
    }

    @Override
    public List<OnSaleDate> getOnSaleDates() {
        return onSaleDates;
    }

    @Override
    public String getTopLineInfo() {
        return topLineInfo;
    }

    @Override
    public String getPromoterName() {
        return promoterName;
    }

    @Override
    public String getSponsorName() {
        return sponsorName;
    }

    @Override
    public ImageMeta getSponsorImage() {
        return sponsorImage;
    }

    @Override
    public String getAdditionalInfo() {
        return additionalInfo;
    }

    @Override
    public String getAdditionalTicketText() {
        return additionalTicketText;
    }

    @Override
    public String getAgeLimitCode() {
        return ageLimitCode;
    }

    @Override
    public String getAgeLimit() {
        return ageLimit;
    }

    @Override
    public String getShowTypeCode() {
        return showTypeCode;
    }

    @Override
    public String getShowType() {
        return showType;
    }

    @Override
    public String getEventStatusCode() {
        return eventStatusCode;
    }

    @Override
    public String getEventStatus() {
        return eventStatus;
    }

    @Override
    public String getEventStatusMessage() {
        return eventStatusMessage;
    }

    @Override
    public URL getTicketPurchaseUrl() {
        return ticketPurchaseUrl;
    }

    @Override
    public String getTicketPrice() {
        return ticketPrice;
    }

    @Override
    public DateTime getLastUpdated() {
        return lastUpdated;
    }

    @Override
    public List<URL> getExternalTicketingUrls() {
        return externalTicketingUrls;
    }

    @Override
    public Org getOrg() {
        return org;
    }

    @Override
    public Long getFacebookEventId() {
        return facebookEventId;
    }

    @Override
    public List<Artist> getHeadliners() {
        return headliners;
    }

    @Override
    public List<Artist> getSupporters() {
        return supporters;
    }

    @Override
    public Venue getVenue() {
        return venue;
    }

    @Override
    public URL getEventDetailsUrl() {
        return eventDetailsUrl;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDateCreated(DateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        setDateCreated(JFlyUtils.parse(dateCreated));
    }

    public void setIsFeatured(boolean featured) {
        this.featured = featured;
    }


    public void setIsPublished(boolean published) {
        this.published = published;
    }


    public void setName(String name) {
        this.name = name;
    }


    public void setHeadlinerName(String headlinerName) {
        this.headlinerName = headlinerName;
    }


    public void setSupportersName(String supportersName) {
        this.supportersName = supportersName;
    }


    public void setImage(ImageMeta image) {
        this.image = image;
    }


    public void setPublishDate(DateTime publishDate) {
        this.publishDate = publishDate;
    }

    public void setPublishDate(String publishDate) {
        setPublishDate(JFlyUtils.parse(publishDate));
    }

    public void setStartDate(DateTime startDate) {
        this.startDate = startDate;
    }

    public void setStartDate(String startDate) {
        setStartDate(JFlyUtils.parse(startDate));
    }

    public void setEndDate(DateTime endDate) {
        this.endDate = endDate;
    }

    public void setEndDate(String endDate) {
        setEndDate(JFlyUtils.parse(endDate));
    }

    public void setDoorsDate(DateTime doorsDate) {
        this.doorsDate = doorsDate;
    }

    public void setDoorsDate(String doorsDate) {
        setDoorsDate(JFlyUtils.parse(doorsDate));
    }

    public void setOnSaleDate(DateTime onSaleDate) {
        this.onSaleDate = onSaleDate;
    }

    public void setOnSaleDate(String onSaleDate) {
        setOnSaleDate(JFlyUtils.parse(onSaleDate));
    }

    public void setOffSaleDate(DateTime offSaleDate) {
        this.offSaleDate = offSaleDate;
    }

    public void setOffSaleDate(String offSaleDate) {
        setOffSaleDate(JFlyUtils.parse(offSaleDate));
    }

    public void setOnSaleDates(List<OnSaleDate> onSaleDates) {
        this.onSaleDates = onSaleDates;
    }

    public void addToOnSaleDates(OnSaleDate onSaleDate) {
        this.onSaleDates.add(onSaleDate);
    }

    public void setTopLineInfo(String topLineInfo) {
        this.topLineInfo = topLineInfo;
    }

    public void setPromoterName(String promoterName) {
        this.promoterName = promoterName;
    }

    public void setsponsorName(String sponsorName) {
        this.sponsorName = sponsorName;
    }

    public void setsponsorImage(ImageMeta sponsorImage) {
        this.sponsorImage = sponsorImage;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public void setAdditionalTicketText(String additionalTicketText) {
        this.additionalTicketText = additionalTicketText;
    }

    public void setAgeLimitCode(String ageLimitCode) {
        this.ageLimitCode = ageLimitCode;
    }

    public void setAgeLimit(String ageLimit) {
        this.ageLimit = ageLimit;
    }

    public void setShowTypeCode(String showTypeCode) {
        this.showTypeCode = showTypeCode;
    }

    public void setShowType(String showType) {
        this.showType = showType;
    }

    public void setEventStatusCode(String eventStatusCode) {
        this.eventStatusCode = eventStatusCode;
    }

    public void setEventStatus(String eventStatus) {
        this.eventStatus = eventStatus;
    }

    public void setEventStatusMessage(String eventStatusMessage) {
        this.eventStatusMessage = eventStatusMessage;
    }

    public void setTicketPurchaseUrl(URL ticketPurchaseUrl) {
        this.ticketPurchaseUrl = ticketPurchaseUrl;
    }

    public void setTicketPurchaseUrl(String url) throws MalformedURLException {
        setTicketPurchaseUrl(JFlyUtils.parseURL(url));
    }

    public void setTicketPrice(String ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public void setLastUpdated(DateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        setLastUpdated(JFlyUtils.parse(lastUpdated));
    }

    public void setExternalTicketingUrls(List<URL> externalTicketingUrls) {
        this.externalTicketingUrls = externalTicketingUrls;
    }

    public void addToExternalTicketingUrls(URL externalTicketingUrl) {
        this.externalTicketingUrls.add(externalTicketingUrl);
    }

    public void addToExternalTicketingUrls(String externalTicketingUrl) throws MalformedURLException {
        this.externalTicketingUrls.add(JFlyUtils.parseURL(externalTicketingUrl));
    }

    public void setOrg(Org org) {
        this.org = org;
    }

    public void setFacebookEventId(Long facebookEventId) {
        this.facebookEventId = facebookEventId;
    }

    public void setHeadliners(List<Artist> headliners) {
        this.headliners = headliners;
    }

    public void addToHeadliners(Artist headliner) {
        this.headliners.add(headliner);
    }

    public void setSupporters(List<Artist> supporters) {
        this.supporters = supporters;
    }

    public void addToSupporters(Artist supporter) {
        this.supporters.add(supporter);
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public void setEventDetailsUrl(URL eventDetailsUrl) {
        this.eventDetailsUrl = eventDetailsUrl;
    }

    public void setEventDetailsUrl(String eventDetailsUrl) throws MalformedURLException {
        setEventDetailsUrl(JFlyUtils.parseURL(eventDetailsUrl));
    }

}
