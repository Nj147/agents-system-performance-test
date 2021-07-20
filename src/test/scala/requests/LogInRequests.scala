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
}
