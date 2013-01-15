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

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashSet;
import java.util.Set;

import org.joda.time.DateTime;

import com.github.bigtoast.jfly.api.FieldGroup;
import com.github.bigtoast.jfly.api.JFlyQuery;
import com.github.bigtoast.jfly.api.JFlyValidationException;
import com.github.bigtoast.jfly.internal.http.JFlyQueryBase;
import com.github.bigtoast.jfly.internal.util.DateUtils;

abstract public class EventQueryBase<T extends JFlyQuery<T>> extends JFlyQueryBase<T> {

	private static final long serialVersionUID = 6100944944751273569L;

	abstract public String getBaseUrl();
	
	private long orgId = -1;
	private long venueId = -1;
	
	private String q;
	private String artistName;
	private String tflyTicketed;
	private String skin;
	private FieldGroup fieldGroup;
	private Set<EventField> fields;
	private DateTime fromDate;
	private DateTime throughDate;
	
	private boolean hasOrgId() { return orgId != -1; }
	private boolean hasVenueId() { return venueId != -1; }
	private boolean hasFields(){ return fields != null && !fields.isEmpty(); }
	private boolean hasFieldGroup(){ return fieldGroup != null; }
	private boolean hasSkin(){ return skin != null; }
	private boolean hasTflyTicketed() { return tflyTicketed != null; }
	private boolean hasArtistName(){ return artistName != null; }
	private boolean hasQuery(){ return q != null; }
    private boolean hasFromDate(){ return fromDate != null; }
    private boolean hasThroughDate(){ return throughDate != null; }
	
    @SuppressWarnings("unchecked")
	public T withArtistName(String name) {
		this.artistName = name;
		return (T) this;
	}
	
    @SuppressWarnings("unchecked")
	public T withOrgId(long orgId){
		this.orgId = orgId;
		return (T) this;
	}
	
    @SuppressWarnings("unchecked")
	public T withVenueId(long venueId){
		this.venueId = venueId;
		return (T) this;
	}
	
    @SuppressWarnings("unchecked")
	public T withFieldGroup(FieldGroup group){
		this.fieldGroup = group;
		return (T) this;
	}
	
    @SuppressWarnings("unchecked")
	public T withTicketflyTicketed(boolean flag){
		if( flag == true)
		  this.tflyTicketed = "true";
		else 
	      this.tflyTicketed = "false";
		
		return (T) this;
	}
	
    @SuppressWarnings("unchecked")
	public T withSkin(String skin){
		this.skin = skin;
		return (T) this;
	}
	
    @SuppressWarnings("unchecked")
	public T withFeilds(Set<EventField> fields){
		this.fields = fields;
		return (T) this;
	}
	
    @SuppressWarnings("unchecked")
	public T withField(EventField field){
		if ( this.fields == null )
			this.fields = new HashSet<EventField>();
		
		this.fields.add(field);
		return (T) this;
	}
	
    @SuppressWarnings("unchecked")
	public T withFromDate(DateTime date){
		this.fromDate = date;
		return (T) this;
	}
	
    @SuppressWarnings("unchecked")
	public T withThroughDate(DateTime date){
		this.throughDate = date;
		return (T) this;
	}
	
	public String build() {
		validate();
		StringBuilder str = new StringBuilder(getBaseUrl());
		try {	
			if ( hasOrgId() ) {
				str.append("orgId=");
				str.append(orgId);
			}
			if ( hasVenueId() ){
				str.append("&venueId=");
				str.append(venueId);
			}
			if ( hasQuery() ) {
				str.append("&q=");
			    str.append(URLEncoder.encode(q, encoding));
			}
			if ( hasArtistName() ) {
				str.append("&artistName=");
				str.append(URLEncoder.encode(artistName, encoding));
			}
			if ( hasPageNum() ){
				str.append("&pageNum=");
				str.append(getPageNum());
			}
			if ( hasMaxResults() ){
				str.append("&maxResults=");
				str.append(getMaxResults());
			}
			if ( hasSkin() ){
				str.append("&skin=");
				str.append(URLEncoder.encode(skin, encoding));
			}
			if ( hasTflyTicketed() ){
				str.append("&tflyTicketed=");
				str.append(tflyTicketed);
			}
			if ( hasFromDate() ){
				str.append("&fromDate=");
				str.append(URLEncoder.encode(DateUtils.toDateString(fromDate), encoding));
			}
			if ( hasThroughDate() ){
				str.append("&throughDate=");
				str.append(URLEncoder.encode(DateUtils.toDateString(fromDate), encoding));
			}
			if ( hasFieldGroup() ){
				str.append("&fieldGroup=");
				str.append(fieldGroup);
			}
			if ( hasFields() ){
				str.append("&fields=");
				for( EventField f :fields){
				  str.append(f);
				  str.append(",");
				}
				str.deleteCharAt(str.length());
			}
		} catch ( UnsupportedEncodingException e ){
			throw new JFlyValidationException("build failed", e);
		}
		return str.toString();
	}
	
	public long getOrgId() {
		return orgId;
	}
	public long getVenueId() {
		return venueId;
	}
	public String getQuery() {
		return q;
	}
	public String getArtistName() {
		return artistName;
	}

	public String getTflyTicketed() {
		return tflyTicketed;
	}
	public String getSkin() {
		return skin;
	}
	public FieldGroup getFieldGroup() {
		return fieldGroup;
	}
	public Set<EventField> getFields() {
		return fields;
	}
	public DateTime getFromDate() {
		return fromDate;
	}
	public DateTime getThroughDate() {
		return throughDate;
	}
	
	


}
