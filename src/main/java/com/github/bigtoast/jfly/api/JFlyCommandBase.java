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

import java.io.Serializable;

abstract public class JFlyCommandBase implements Serializable {
	
	private static final long serialVersionUID = -5635894907213703327L;
	public static String encoding = "ISO-8859-1";

	public static String baseRestUrl = "http://www.ticketfly.com/api";
	
	/**
	 * Check if the command is valid without having to catch exceptions. 
	 * @return boolean
	 */
	public boolean isValid(){
		try {
			validate();
			return true;
		} catch( JFlyValidationException e ) {
			return false;
		}
	}
	
	/**
	 * A JFlyCommand must be validated before it can be executed.
	 * 
	 * @throws JFlyValidationException
	 */
	abstract public void validate() throws JFlyValidationException;

	//abstract public T execute() throws JFlyException;
}
