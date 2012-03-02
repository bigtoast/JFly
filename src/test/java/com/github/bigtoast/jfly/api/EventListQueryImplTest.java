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

import static org.junit.Assert.*;

import org.junit.Test;

public class EventListQueryImplTest {

	@Test
	public final void testBuildWithOrg() {
		EventListQuery query = new EventListQueryImpl();
		
		String q = query.withOrgId(7).build();
		
		assertEquals(q, "http://www.ticketfly.com/api/events/list.json?orgId=7");
	}

}
