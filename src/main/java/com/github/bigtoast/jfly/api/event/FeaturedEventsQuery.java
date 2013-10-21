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
package com.github.bigtoast.jfly.api.event;

import java.util.Set;

import com.github.bigtoast.jfly.Event;
import com.github.bigtoast.jfly.api.JFlyQuery;
import org.joda.time.DateTime;

import com.github.bigtoast.jfly.api.FieldGroup;
import com.github.bigtoast.jfly.api.JFlyRequest;

public interface FeaturedEventsQuery extends JFlyQuery<FeaturedEventsQuery,Event> {
	
    public FeaturedEventsQuery withArtistName(String name);
	
	public FeaturedEventsQuery withOrgId(long orgId);
	
	public FeaturedEventsQuery withVenueId(long venueId);
	
	public FeaturedEventsQuery withMaxResults(int cnt);
	
	public FeaturedEventsQuery withPageNum(int num);
	
	public FeaturedEventsQuery withFieldGroup(FieldGroup group);
	
	public FeaturedEventsQuery withTicketflyTicketed(boolean flag);
	
	public FeaturedEventsQuery withSkin(String skin);
	
	public FeaturedEventsQuery withFeilds(Set<EventField> fields);
	
	public FeaturedEventsQuery withField(EventField field);
	
	public FeaturedEventsQuery withFromDate(DateTime date);

	public FeaturedEventsQuery withThroughDate(DateTime date);
	
	public long getOrgId();
	
	public long getVenueId();
	
	public String getQuery();
	
	public String getArtistName();
	
	public int getPageNum();
	
	public int getMaxResults();
	
	public String getTflyTicketed();
	
	public String getSkin();
	
	public FieldGroup getFieldGroup();
	
	public Set<EventField> getFields();
	
	public DateTime getFromDate();
	
	public DateTime getThroughDate();
}
