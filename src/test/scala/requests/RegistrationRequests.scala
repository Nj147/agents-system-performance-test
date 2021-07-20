package requests

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object RegistrationRequests {
  val uri1 = "localhost"

  def getBusinessNamePage = {
    exec(http("Get business name page")
      .get("/registration/business-name/false")
      .check(status.is(200))
    )
  }

  def submitBusinessName = {
    exec(http("Submit business name")
      .post("/registration/business-name/false")
      .formParam("businessName", "TestBusiness5")
      .disableFollowRedirect
      .check(status.is(303))
      .check(header("Location").is("/registration/email/false"))
    )
  }

  def submitEmail = {
    exec(http("Submit email")
      .post("/registration/email/false")
      .formParam("email", "test@test.com")
      .disableFollowRedirect
      .check(status.is(303))
      .check(header("Location").is("/registration/contact-number/false"))
    )
  }

  def submitContactNumber = {
    exec(http("Submit contact number")
      .post("/registration/contact-number/false")
      .formParam("number", "07294850384")
      .disableFollowRedirect
      .check(status.is(303))
      .check(header("Location").is("/registration/address/false"))
    )
  }

  def submitAddress = {
    exec(http("Submit address")
      .post("/registration/address/false")
      .formParam("propertyNumber", "Test street")
      .formParam("postcode", "LE50 1PQ")
      .disableFollowRedirect
      .check(status.is(303))
      .check(header("Location").is("/registration/correspondence/false"))
    )
  }

  def submitCorrespondence = {
    exec(http("Submit correspondence")
      .post("/registration/correspondence/false")
      .formParam("modes[0]", "Phone call")
      .disableFollowRedirect
      .check(status.is(303))
      .check(header("Location").is("/registration/password"))
    )
  }

  def submitPassword = {
    exec(http("Submit password")
      .post("/registration/password")
      .formParam("password", "123456789A!")
      .formParam("passwordCheck", "123456789A!")
      .disableFollowRedirect
      .check(status.is(303))
      .check(header("Location").is("/registration/summary"))
    )
  }

  def getSuccessfulRegistration = {
    exec(http("Successful registration")
      .get("/registration/arn?")
      .check(status.is(200))
    )
  }

  def getSignIn = {
    exec(http("Sign in")
      .get("http://" + uri1 + ":9005/agents-frontend/agent-login")
      .check(status.is(200))
    )
  }


}

