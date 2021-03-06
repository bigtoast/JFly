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

import com.github.bigtoast.jfly.JFly;

/**
 * All queries have no side effects and return a paginated response.
 * @param <Q> query type
 * @param <R> result type contained in paginated response
 */
public interface JFlyQuery<Q extends JFlyQuery<Q,R>,R> extends JFlyRequest {
	
	public Q withMaxResults(int cnt);
	
	public Q withPageNum(int num);
	
    public int getPageNum();
	
	public int getMaxResults();
	
	public boolean hasMaxResults();
	
	public boolean hasPageNum();

    public PaginatedResponse<R> execute(JFly jFly);
}
