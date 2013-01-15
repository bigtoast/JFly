package com.github.bigtoast.jfly.internal.http.org;

import com.github.bigtoast.jfly.api.JFlyValidationException;
import com.github.bigtoast.jfly.api.org.OrgListQuery;
import com.github.bigtoast.jfly.internal.http.JFlyQueryBase;

public class OrgListQueryImpl extends JFlyQueryBase<OrgListQuery> implements OrgListQuery {

	private long orgId = -1;
	
	private static final long serialVersionUID = 8903050803801713926L;
	
	private String baseOrgsUrl = baseRestUrl + "/orgs/list.json";

	@Override
	public boolean isValid() {
		return true; // nothing to validate
	}
	
	public String getBaseOrgsUrl() {
		return baseOrgsUrl;
	}

	@Override
	public void validate() throws JFlyValidationException {
		// do nothing
	}

	@Override
	public String build() throws JFlyValidationException {
		validate();
		StringBuilder str = new StringBuilder(getBaseOrgsUrl());
		if ( hasOrgId() ) {
			str.append("orgId=");
			str.append(orgId);
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

	@Override
	public boolean hasOrgId() {
		return checkHas(orgId);
	}

	@Override
	public OrgListQuery withOrgId(long orgId) {
		this.orgId = orgId;
		return this;
	}

	@Override
	public long getOrgId() {
		return orgId;
	}

}
