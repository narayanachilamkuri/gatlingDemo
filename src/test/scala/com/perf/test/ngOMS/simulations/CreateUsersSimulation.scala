package com.perf.test.ngOMS.simulations


import scala.language.postfixOps
import scala.concurrent.duration._
import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.language.postfixOps
import io.gatling.http.request.builder.Http
import com.perf.test.ngOMS.requests.Requests._
import com.perf.test.ngOMS.requests.Requests.baseURL

import scala.concurrent.duration._
import com.perf.test.ngOMS.scenarios.scenarios.{scn, scn1, scn2, scn3}

class CreateUsersSimulation extends Simulation{




  setUp(
    //scn.inject(rampUsers(5).during(10 seconds)).protocols(baseURL),
    scn1.inject(rampUsers(5).during(10 seconds)).protocols(baseURL),
    scn2.inject(rampUsers(5).during(5 seconds)).protocols(baseURL),
    scn3.inject(rampUsers(4).during(5 seconds)).protocols(baseURL)

  )

}
