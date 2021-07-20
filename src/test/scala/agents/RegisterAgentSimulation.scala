package agents

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import requests.{LogInRequests, RegistrationRequests}

class RegisterAgentSimulation extends Simulation {

  val httpProtocol = http
    .baseUrl("http://localhost:9000")
    .inferHtmlResources()

  val scn = scenario("RegisterAgentSimulation")
    .exec(LogInRequests.getStartPage)
    .exec(RegistrationRequests.getBusinessNamePage)
    .exec(RegistrationRequests.submitBusinessName)
    .exec(RegistrationRequests.submitEmail)
    .exec(RegistrationRequests.submitContactNumber)
    .exec(RegistrationRequests.submitAddress)
    .exec(RegistrationRequests.submitCorrespondence)
    .exec(RegistrationRequests.submitPassword)
    .exec(RegistrationRequests.getSuccessfulRegistration)
    .exec(RegistrationRequests.getSignIn)


  val registerAgentSimulation = setUp(scn.inject(atOnceUsers(1)).protocols(httpProtocol))
}