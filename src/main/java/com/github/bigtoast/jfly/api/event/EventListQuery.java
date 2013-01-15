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
import com.github.bigtoast.jfly.api.JFlyQuery;

public interface EventListQuery extends JFlyQuery<EventListQuery> {
	
	public EventListQuery withArtistName(String name);
	
	public EventListQuery withOrgId(long orgId);
	
	public EventListQuery withVenueId(long venueId);
	
	public EventListQuery withFieldGroup(FieldGroup group);
	
	public EventListQuery withTicketflyTicketed(boolean flag);
	
	public EventListQuery withSkin(String skin);
	
	public EventListQuery withFeilds(Set<EventField> fields);
	
	public EventListQuery withField(EventField field);
	
	public EventListQuery withFromDate(DateTime date);

	public EventListQuery withThroughDate(DateTime date);
	
	public long getOrgId();
	
	public long getVenueId();
	
	public String getQuery();
	
	public String getArtistName();
	
	public String getTflyTicketed();
	
	public String getSkin();
	
	public FieldGroup getFieldGroup();
	
	public Set<EventField> getFields();
	
	public DateTime getFromDate();
	
	public DateTime getThroughDate();
}
