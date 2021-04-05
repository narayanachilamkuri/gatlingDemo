package com.perf.test.ngOMS.scenarios

import scala.concurrent.duration._
import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.language.postfixOps
import io.gatling.http.request.builder.Http
import com.perf.test.ngOMS.requests.Requests
import com.perf.test.ngOMS.requests.Requests._


object scenarios {
  val statusCheck = status.is(200)


  val scn = scenario("CreateUser1")
    .exec(createUsers1)
  val scn1 = scenario("CreateUser2")
    .exec(createUsers2())
  val scn2=scenario("CreateUser3")
    .exec(createUser3)
  val scn3 = scenario("CreateUser4")
    .exec(http("CreateUser4_1")
      .get("/api/users").check(statusCheck))
    .pause(2)
    .exec((http("CreateUser4_2")
      .get("/api/users").check(statusCheck)))
    .pause(1)
    .exec(createUsers1)



}
