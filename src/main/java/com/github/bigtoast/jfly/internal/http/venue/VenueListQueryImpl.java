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
package com.github.bigtoast.jfly.internal.http.venue;

import com.github.bigtoast.jfly.api.JFlyValidationException;
import com.github.bigtoast.jfly.api.venue.VenueListQuery;
import com.github.bigtoast.jfly.internal.http.JFlyQueryBase;

public class VenueListQueryImpl extends JFlyQueryBase<VenueListQuery> implements VenueListQuery {
	
	private static final long serialVersionUID = 5234265609495326092L;

	VenueListQueryImpl(){}
	
	private long orgId = -1;
	private long venueId = -1; 
	
	private String venuesUrl = baseRestUrl + "/venues/list.json?";
	
	public String getVenuesUrl() { return venuesUrl; }

	@Override
	public VenueListQuery withOrgId(long orgId) {
		this.orgId = orgId;
		return this;
	}

	@Override
	public VenueListQuery withVenueId(long venueId) {
		this.venueId = venueId;
		return this;
	}

	@Override
	public long getOrgId(){
		return orgId;
	}

	@Override
	public long getVenueId() {
		return venueId;
	}

	@Override
	public boolean hasOrgId() { return checkHas( orgId ); }
	@Override
	public boolean hasVenueId() { return checkHas( venueId ); }
	

	@Override
	public boolean isValid() {
		return true; // nothing to validate in this one.
	}

	@Override
	public void validate() throws JFlyValidationException {
		// do nothing
	}

	@Override
	public String build() throws JFlyValidationException {
		validate();
		StringBuilder str = new StringBuilder(getVenuesUrl());
		if ( hasOrgId() ) {
			str.append("orgId=");
			str.append(orgId);
		}
		if ( hasVenueId() ){
			str.append("&venueId=");
		}
		if ( hasPageNum() ){
			str.append("&pageNum=");
			str.append(getPageNum());
		}
		if ( hasMaxResults() ){
			str.append("&maxResults=");
			str.append(getMaxResults());
		}
		return str.toString();
	}



}
