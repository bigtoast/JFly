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

package com.github.bigtoast.jfly;

import java.io.Serializable;
import java.net.URL;
import java.util.List;

import org.joda.time.DateTime;

public interface Sale extends Serializable {

	public long getId();
	public URL getUri();
	public DateTime createdAt();
	public List<LineItem> getLineItems();
	public Charge getShippingCharge();
	public Charge getHandlingCharge();
	public Charge getTotalCharge();
	public Address getShippingAddress();
	public Payment getPayment();
	// what is custom text and why is it used?
	//public List<CustomEventText> getCustomText();
	public List<Event> getEvents();
}
