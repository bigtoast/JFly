package com.github.bigtoast.jfly.internal.http.venue

import com.github.bigtoast.jfly.JFlySpecBase

class VenueListQueryImplSpecs extends JFlySpecBase {
    def "constructing a request"(){
        def query = jFly.venues().withId(123).withOrgId(456).withMaxResults(10).withPageNum(2)

        expect :
            query.hasId() == true
            query.hasOrgId() == true
            query.hasMaxResults() == true
            query.hasPageNum() == true
            query.getId() == 123
            query.getOrgId() == 456
            query.getMaxResults() == 10
            println(query.build())

    }

    def "executing a request"(){
        def query = jFly.venues()
        def results = query.execute(jFly)

        expect:
            query.build() == "http://www.ticketfly.com/api/venues/list.json?"
            results.pageNum == 1
            results.size() == 25
    }
}
