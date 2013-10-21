package com.github.bigtoast.jfly

import spock.lang.Specification


abstract class JFlySpecBase extends Specification {

    JFly jFly = JFlyFactory.getInstance(null)

}
