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
package com.github.bigtoast.jfly.internal.http;

import static org.junit.Assert.*;

import org.junit.Test;

import com.github.bigtoast.jfly.Event;
import com.github.bigtoast.jfly.JFly;
import com.github.bigtoast.jfly.JFlyFactory;
import com.github.bigtoast.jfly.api.EventQueryFactory;
import com.github.bigtoast.jfly.api.PagenatedResponse;

public class JFlyImplTests {

	@Test
	public final void testListEvents() {
		JFly jfly = JFlyFactory.getInstance(null);
	
		PagenatedResponse<Event> resp = jfly.execute(EventQueryFactory.list().withOrgId(7));
		
		assertTrue( resp.totalResults() > 0 );
		assertTrue( resp.maxResults() > 0 );
	}

}
