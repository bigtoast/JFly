package com.github.bigtoast.jfly.internal.http.event

import com.github.bigtoast.jfly.JFlySpecBase

class EventListQuerySpecs extends JFlySpecBase {
    def "list events"(){
        def query = jFly.events().withOrgId(7)  //.withMaxResults(2)
        def events = query.execute(jFly);

        expect :
            query.build() == "http://www.ticketfly.com/api/events/list.json?orgId=7"
            events.totalResults() > 0
            events.size() == 25
    }
}
