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
package com.github.bigtoast.jfly.internal.util;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.net.MalformedURLException;
import java.net.URL;

public class JFlyUtils {

	private static DateTimeFormatter dtFormatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
	private static DateTimeFormatter dFormatter = DateTimeFormat.forPattern("yyyy-MM-dd");
	
	public static DateTime parse(String str){
        if ( str == "null" )
            return null;
		return dtFormatter.parseDateTime(str);
	}
	
	public static String toDateTimeString(DateTime date){
		return dtFormatter.print(date);
	}
	
	public static String toDateString(DateTime date){
		return dFormatter.print(date);
	}

    public static Long parseLong(String str){
        try {
           return Long.valueOf(str);
        } catch ( NumberFormatException e ) {
            // swallow
            return null;
        }
    }

    public static Integer parseInt(String str){
        try {
            return Integer.valueOf(str);
        } catch ( NumberFormatException e ) {
            // swallow
            return null;
        }
    }

    public static URL parseURL(String str){
        try {
            return new URL(str);
        } catch ( MalformedURLException e ) {
            // ignore
            return null;
        }
    }


}
