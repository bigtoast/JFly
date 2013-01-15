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

import org.joda.time.DateTime;

import com.github.bigtoast.jfly.api.FieldGroup;
import com.github.bigtoast.jfly.api.JFlyRequest;

public interface UpcomingEventsQuery extends JFlyRequest {
	
    public UpcomingEventsQuery withArtistName(String name);
	
	public UpcomingEventsQuery withOrgId(long orgId);
	
	public UpcomingEventsQuery withVenueId(long venueId);
	
	public UpcomingEventsQuery withMaxResults(int cnt);
	
	public UpcomingEventsQuery withPageNum(int num);
	
	public UpcomingEventsQuery withFieldGroup(FieldGroup group);
	
	public UpcomingEventsQuery withTicketflyTicketed(boolean flag);
	
	public UpcomingEventsQuery withSkin(String skin);
	
	public UpcomingEventsQuery withFeilds(Set<EventField> fields);
	
	public UpcomingEventsQuery withField(EventField field);
	
	public UpcomingEventsQuery withFromDate(DateTime date);

	public UpcomingEventsQuery withThroughDate(DateTime date);
	
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
