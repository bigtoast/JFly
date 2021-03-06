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

import com.github.bigtoast.jfly.Org;

/**
 * This is a paginated response where all results belong to a
 * single org.
 * 
 * @author Andrew Headrick
 *
 * @param <T> contained type in response
 */
public interface OrgPagenatedResponse<T> extends PaginatedResponse<T> {
	public Org getOrg();
}
