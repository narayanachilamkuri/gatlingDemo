package com.perf.test.ngOMS.requests

import scala.concurrent.duration._
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.language.postfixOps
import io.gatling.http.request.builder.Http
import io.gatling.http.Predef.status

object Requests {


  //val csvFeeder = csv("samplecsvdata.csv")

  val baseURL=http
    .baseUrl("https://reqres.in")
    .acceptHeader("application/json")



  val createUsers1 = http(requestName = "createUser1").get("/api/users")
    .check(bodyString.saveAs("AuthResponse"))
    .check(status.is(200))

  def createUsers2() = {
    exec(http("createUser2")
      .post("/api/users")
      .body(StringBody(s"""{"name":"Bob","job":"Painter"} """.stripMargin)).asJson)

  }


  val createUser3 = http("createUser3")
    .post("/api/users")
    .body(StringBody(s"""{"name":"Bob","job":"Painter"}""")).asJson
    .check(status.is(200))
}
