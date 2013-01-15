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

public interface Buildable<E, B extends EntityBuilder<E>> {
	
	/**
	 * return a new builder initialized with the values from
	 * the object this is invoked upon. Changing values of the 
	 * builder does not change the values of 'this'.
	 * 
	 * @return EntityBuilder
	 */
	public B getBuilder();
	
	/**
	 * return an empty builder for this type.
	 * 
	 * @return EntityBuilder
	 */
	public B newBuilder();
	
}
