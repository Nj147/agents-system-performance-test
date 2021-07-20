package agents

import scala.concurrent.duration._
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._
import requests.RegistrationRequests

class RegisterAgentSimulation extends Simulation {

  val httpProtocol = http
    .baseUrl("http://localhost:9000")
    .inferHtmlResources()


  val scn = scenario("RegisterAgentSimulation")
    .exec(RegistrationRequests.getStartPage)
    .exec(RegistrationRequests.getBusinessNamePage)
    .exec(RegistrationRequests.submitBusinessName)
    .exec(RegistrationRequests.submitEmail)
    .exec(RegistrationRequests.submitContactNumber)
    .exec(RegistrationRequests.submitAddress)
    .exec(RegistrationRequests.submitCorrespondence)
    .exec(RegistrationRequests.submitPassword)
    .exec(RegistrationRequests.getSuccessfulRegistration)
    .exec(RegistrationRequests.getSignIn)

  val userSignInScn =

    setUp(scn.inject(
      nothingFor(4.seconds), // 1
      atOnceUsers(10), // 2
      rampUsers(10).during(5.seconds))
      .protocols(httpProtocol))
}