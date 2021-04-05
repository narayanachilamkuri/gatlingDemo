package com.perf.test



import scala.concurrent.duration._
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.language.postfixOps
import io.gatling.http.request.builder.Http

class BasicSimulation extends Simulation { // 3


  //val csvFeeder = csv("samplecsvdata.csv")

  val httpProtocol1=http
    .baseUrl("https://reqres.in")
    .acceptHeader("application/json")



  def createUsers() = {
    exec(http("create a user")
     .post("/api/users")
     .body(StringBody(s"""{"name":"Bob","job":"Painter"} """.stripMargin)).asJson)
      }

  val scn = scenario("Create list of users")
    .exec(createUsers())
  setUp(scn.inject(rampUsers(5).during(10 seconds)).protocols(httpProtocol1))
 // setUp(scn.inject(atOnceUsers(5)).protocols(httpProtocol))
  //setUp(scn.inject(nothingFor(10 seconds), rampUsers(5) during(10 seconds),constantUsersPerSec(5) during(10)).protocols(httpProtocol))
  //setUp(scn.inject(rampUsers(10) during(300 seconds)).protocols(httpProtocol))

}

