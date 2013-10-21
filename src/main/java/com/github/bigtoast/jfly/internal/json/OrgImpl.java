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
package com.github.bigtoast.jfly.internal.json;

import java.io.IOException;

import org.codehaus.jackson.*;

import com.github.bigtoast.jfly.Org;

public class OrgImpl implements Org {

    private static final long serialVersionUID = 2330273513558370162L;

    public static String ID = "id";
    public static String NAME = "name";
    public static String TIME_ZONE = "timeZone";

    private long id;
    private String name;
    private String timeZone;

    public OrgImpl(JsonParser parser) throws JsonParseException, IOException {
        if (parser.getCurrentToken() != JsonToken.START_OBJECT) {
            if (parser.getCurrentToken() == JsonToken.VALUE_NULL)
                return;
            throw new IOException("Expected data to start with an Object. Found " + parser.getCurrentToken());
        }

        while (parser.nextToken() != JsonToken.END_OBJECT) {
            String fName = parser.getCurrentName();
            parser.nextToken();

            if (fName.equals(ID))
                id = parser.getLongValue();
            else if (fName.equals(NAME))
                name = parser.getText();
            else if (fName.equals(TIME_ZONE))
                timeZone = parser.getText();
        }
    }


    @Override
    public long getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getTimeZone() {
        return timeZone;
    }

}
