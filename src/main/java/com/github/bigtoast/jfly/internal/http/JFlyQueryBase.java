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

import com.github.bigtoast.jfly.JFly;
import com.github.bigtoast.jfly.api.JFlyQuery;
import com.github.bigtoast.jfly.api.JFlyRequestBase;
import com.github.bigtoast.jfly.api.PaginatedResponse;

public abstract class JFlyQueryBase<Q extends JFlyQuery<Q,R>,R> extends JFlyRequestBase implements JFlyQuery<Q,R> {

	private int maxResults = -1;
	private int pageNum = -1;

	@Override
	@SuppressWarnings("unchecked")
	public Q withMaxResults(int cnt) {
		this.maxResults = cnt;
		return (Q) this;
	}

	@Override
	@SuppressWarnings("unchecked")
	public Q withPageNum(int num) {
		this.pageNum = num;
		return (Q) this;
	}

	@Override
	public int getPageNum() {
		return pageNum;
	}

	@Override
	public int getMaxResults() {
		return maxResults;
	}

	@Override
	public boolean hasMaxResults() { return checkHas(maxResults); }

	@Override
	public boolean hasPageNum() { return checkHas(pageNum); }

}
