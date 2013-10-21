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

import com.github.bigtoast.jfly.Event;
import com.github.bigtoast.jfly.api.PaginatedResponse;

public interface EventMethods {

    public EventListQuery events();
	
	public PaginatedResponse<Event> execute(EventListQuery query);

    public PastEventsQuery pastEvents();

	public PaginatedResponse<Event> execute(PastEventsQuery query);

    public UpcomingEventsQuery upcomingEvents();

	public PaginatedResponse<Event> execute(UpcomingEventsQuery query);

    public JustAnnouncedEventsQuery justAnnouncedEvents();

	public PaginatedResponse<Event> execute(JustAnnouncedEventsQuery query);

    public FeaturedEventsQuery featuredEvents();

	public PaginatedResponse<Event> execute(FeaturedEventsQuery query);
	
}
