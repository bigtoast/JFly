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


public class EventListQueryImpl extends EventQueryBase<EventListQueryImpl> implements EventListQuery {
	
	private static final long serialVersionUID = 1152107551472899221L;

	public String getBaseUrl(){ 
		return baseRestUrl + "/events/list.json?";
	}
		
	@Override
	public void validate() throws JFlyValidationException {
		if ( getOrgId() == -1 && getVenueId() == -1 )
			throw new JFlyValidationException("OrgId or VenueId must be set.");		
	}

}
