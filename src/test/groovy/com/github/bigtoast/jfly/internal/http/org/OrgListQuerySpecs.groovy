package com.github.bigtoast.jfly.internal.http.org

import com.github.bigtoast.jfly.JFlySpecBase


class OrgListQuerySpecs extends JFlySpecBase {
    def "construct an org list query"(){
        def query = jFly.orgs()
        def orgs = query.execute(jFly)

        expect :
            query.build() == "http://www.ticketfly.com/api/orgs/list.json?"
            orgs.size() == 25
    }

    def "get a specific org"(){
        def query = jFly.orgs().withId(7)
        def org = query.execute(jFly)

        expect :
            query.build() == "http://www.ticketfly.com/api/orgs/list.json?orgId=7"
            org.size() == 1
            org.totalPages() == 1
            org.totalResults() == 1
            org.getPageNum() == 1
            org.first().id == 7
            org.first().name == "Demo1"
            org.first().timeZone == "America/Los_Angeles"
    }
}
