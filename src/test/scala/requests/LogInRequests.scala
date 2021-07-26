package requests

import io.gatling.core.Predef._
import io.gatling.core.structure.ChainBuilder
import io.gatling.http.Predef._

object LogInRequests {

  def getStartPage: ChainBuilder = {
    exec(http("Get start page")
      .get("http://localhost:9005/agents-frontend/start-page")
      .check(status.is(200))
    )
  }

  def getLoginPage: ChainBuilder = {
    exec(http("Get Login page")
      .get("/agent-login")
    )
  }

  def submitLoginDetails: ChainBuilder = {
    exec(http("Submit login details")
      .post("/agent-login")
      .formParam("arn", "ARN0EB04960")
      .formParam("password", "password123")
      .disableFollowRedirect
      .check(status.is(303))
      .check(header("Location").is("/agents-frontend/dashboard"))
    )
  }

  def getAddClientPage: ChainBuilder = {
    exec(http("Get add client page")
      .get("/client-code")

    )
  }

  def submitAddClient: ChainBuilder = {
    exec(http("Add client")
      .post("/client-code")
      .formParam("crn", "CRN18BAA7DF")
      .check(status.is(200))
    )
  }

  def getDashBoard: ChainBuilder = {
    exec(http("Get dashboard")
      .get("/dashboard")
      .check(status.is(200)))
  }

  def getRemoveClientPage: ChainBuilder = {
    exec(http("Get remove client page")
      .get("/remove-clients/CRN18BAA7DF")
      .check(status.is(200)))
  }

  def submitConfirmRemoveClient: ChainBuilder = {
    exec(http("Submit confirm remove client")
      .get("/remove-confirmed/CRN18BAA7DF")
      .check(status.is(200)))

  }
}
