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

import com.github.bigtoast.jfly.api.JFlyValidationException;

public class JustAnnouncedEventsQueryImpl extends EventQueryBase<JustAnnouncedEventsQueryImpl> implements
		JustAnnouncedEventsQuery {

	private static final long serialVersionUID = 8765363729662343471L;

	public String getBaseUrl(){ 
		return baseRestUrl + "/events/justAnnounced.json?";
	}
		
	@Override
	public void validate() throws JFlyValidationException {
		if ( getOrgId() == -1 || getVenueId() == -1 )
			throw new JFlyValidationException("OrgId and VenueId must both be set.");		
	}

}
