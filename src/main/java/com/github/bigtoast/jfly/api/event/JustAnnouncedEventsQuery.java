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

public interface JustAnnouncedEventsQuery extends JFlyQuery<JustAnnouncedEventsQuery,Event> {
	
    public JustAnnouncedEventsQuery withArtistName(String name);
	
	public JustAnnouncedEventsQuery withOrgId(long orgId);
	
	public JustAnnouncedEventsQuery withVenueId(long venueId);
	
	public JustAnnouncedEventsQuery withMaxResults(int cnt);
	
	public JustAnnouncedEventsQuery withPageNum(int num);
	
	public JustAnnouncedEventsQuery withFieldGroup(FieldGroup group);
	
	public JustAnnouncedEventsQuery withTicketflyTicketed(boolean flag);
	
	public JustAnnouncedEventsQuery withSkin(String skin);
	
	public JustAnnouncedEventsQuery withFeilds(Set<EventField> fields);
	
	public JustAnnouncedEventsQuery withField(EventField field);
	
	public JustAnnouncedEventsQuery withFromDate(DateTime date);

	public JustAnnouncedEventsQuery withThroughDate(DateTime date);
	
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
