package agents

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import requests.LogInRequests

class LogInSimulation extends Simulation {

  val httpProtocol = http
    .baseUrl("http://localhost:9005/agents-frontend")
    .inferHtmlResources()

  val scn = scenario("LogInSimulation")
    .exec(LogInRequests.getStartPage)
    .exec(LogInRequests.getLoginPage)
    .exec(LogInRequests.submitLoginDetails)
    .exec(LogInRequests.getAddClientPage)
    .exec(LogInRequests.submitAddClient)
    .exec(LogInRequests.getDashBoard)
    .exec(LogInRequests.getRemoveClientPage)
    .exec(LogInRequests.submitConfirmRemoveClient)

  val LogInSimulation =
    setUp(scn.inject(atOnceUsers(1)).protocols(httpProtocol))
}