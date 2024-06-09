package vc

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder

object Actions {
  val getMainPage: HttpRequestBuilder = http("getMainPage")
    .get("/cgi-bin/welcome.pl")
    .queryParam("signOff", "true")
    .check(status is 200)

  val getMainPage1: HttpRequestBuilder = http("getMainPage1")
    .get("/cgi-bin/nav.pl")
    .queryParam("query", "in=home")
    .check(status is 200)
    .check(
      regex("(?<=name=\"userSession\" value=\")[A-Za-z0-9.]+").saveAs("userSession")
    )

  val login: HttpRequestBuilder = http("login")
    .post("/cgi-bin/login.pl")
    .formParam("userSession", "#{userSession}")
    .formParam("username", "chudo")
    .formParam("password", "negr")

  val login1: HttpRequestBuilder = http("login1")
    .post("/cgi-bin/nav.pl")
    .formParam("page", "menu")
    .formParam("in", "home")


  val login2: HttpRequestBuilder = http("login2")
    .post("/cgi-bin/login.pl")
    .formParam("intro", "true")

  val flights_page: HttpRequestBuilder = http("flights_page")
    .post("/cgi-bin/welcome.pl")
    .formParam("page", "search")
  val flights_page1: HttpRequestBuilder = http("flights_page1")
    .post("/cgi-bin/nav.pl")
    .formParam("page", "menu")
    .formParam("in", "flights")
  val flights_page2: HttpRequestBuilder = http("flights_page2")
    .post("/cgi-bin/reservations.pl")
    .formParam("page", "welcome")
    .check(
      regex("(?<=<option value=\")[^\"]+").findRandom.saveAs("cityOut")
    )
    .check(
      regex("(?<=<option value=\")[^\"]+").findRandom.saveAs("cityTo")
    )

  val reserve_flight: HttpRequestBuilder = http("reserve_flight")
    .post("/cgi-bin/reservations.pl")
    .formParam("advanceDiscount", "0")
    .formParam("depart", "#{cityOut}")
    .formParam("departDate", "05/01/2024")
    .formParam("arrive", "#{cityTo}")
    .formParam("page", "welcome")
    .formParam("page", "welcome")
    .formParam("page", "welcome")
    .formParam("page", "welcome")
    .formParam("page", "welcome")
    .formParam("page", "welcome")
    .formParam("page", "welcome")
    .formParam("page", "welcome")
    .formParam("page", "welcome")




}
