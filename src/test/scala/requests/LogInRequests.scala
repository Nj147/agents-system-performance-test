package requests

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object LogInRequests {

  def getStartPage = {
    exec(http("Get start page")
      .get("http://localhost:9005/agents-frontend/start-page")
      .check(status.is(200))
    )
  }

  def getLoginPage = {
    exec(http("Get Login page")
      .get("/agent-login")
    )
  }

  def submitLoginDetails = {
    exec(http("Submit login details")
      .post("/agent-login")
      .formParam("arn", "ARN478A6784")
      .formParam("password", "password123")
      .disableFollowRedirect
      .check(status.is(303))
      .check(header("Location").is("/agents-frontend/dashboard"))
    )
  }

  def getAddClientPage = {
    exec(http("Get add client page")
      .get("/client-code")

    )
  }

  def submitAddClient = {
    exec(http("Add client")
      .post("/client-code")
      .formParam("crn", "CRNC493F3DA")
      .disableFollowRedirect
      .check(status.is(303))
      .check(header("Location").is("/agents-frontend/success-client-code"))
    )
  }

  def getDashBoard = {
    exec(http("Get dashboard")
      .get("/dashboard")
      .check(status.is(200)))
  }

  def getRemoveClientPage = {
    exec(http("Get remove client page")
      .get("/remove-clients/CRNC493F3DA")
      .check(status.is(200)))
  }

  def submitConfirmRemoveClient = {
    exec(http("Submit confirm remove client")
      .get("/remove-confirmed/CRNC493F3DA")
      .check(status.is(200)))

  }
}
