package agents

import scala.concurrent.duration._
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._
import requests.RegistrationRequests

class UserSignInSimulation extends Simulation {

  val httpProtocol = http
    .baseUrl("http://localhost:9005/agents-frontend")
    .inferHtmlResources()

  val uri1 = "localhost"

  val scn = scenario("UserSignInSimulation")
    .exec(RegistrationRequests.getStartPage)
    .exec(http("Get Login page")
      .get("/agent-login")
    )
    .exec(http("Submit login details")
      .post("/agent-login")
      .formParam("arn", "ARNB2A9D0FB")
      .formParam("password", "password123")
      .check(status.is(303))
    )


  val userSignInScn =
    setUp(scn.inject(atOnceUsers(1)).protocols(httpProtocol))
}