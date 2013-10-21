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

public interface PastEventsQuery extends JFlyQuery<PastEventsQuery,Event> {
	
    public PastEventsQuery withArtistName(String name);
	
	public PastEventsQuery withOrgId(long orgId);
	
	public PastEventsQuery withVenueId(long venueId);
	
	public PastEventsQuery withMaxResults(int cnt);
	
	public PastEventsQuery withPageNum(int num);
	
	public PastEventsQuery withFieldGroup(FieldGroup group);
	
	public PastEventsQuery withTicketflyTicketed(boolean flag);
	
	public PastEventsQuery withSkin(String skin);
	
	public PastEventsQuery withFeilds(Set<EventField> fields);
	
	public PastEventsQuery withField(EventField field);
	
	public PastEventsQuery withFromDate(DateTime date);

	public PastEventsQuery withThroughDate(DateTime date);
	
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
