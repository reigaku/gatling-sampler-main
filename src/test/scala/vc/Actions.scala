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
    .formParam("returnDate", "05/02/2024")
    .formParam("numPassengers", "1")
    .formParam("page", "welcome")
    .formParam("seatPref", "None")
    .formParam("seatType", "Coach")
    .formParam("findFlights.x", "50")
    .formParam("findFlights.y", "11")
    .formParam(".cgifields", "roundtrip")
    .formParam(".cgifields", "seatType")
    .formParam("..cgifields", "seatPref")
    .check(
      regex("(?<=outboundFlight\" value=\")\\d+;\\d+;\\d{2}/\\d{2}/\\d{4}").findRandom.saveAs("flight_out_current")
    )
  val reserve_flight1: HttpRequestBuilder = http("reserve_flight1")
    .post("/cgi-bin/reservations.pl")
    .formParam("outboundFlight", "#{flight_out_current}")
    .formParam("numPassengers", "1")
    .formParam("advanceDiscount", "0")
    .formParam("seatType", "Coach")
    .formParam("seatPref", "None")
    .formParam("reserveFlights.x", "53")
    .formParam("reserveFlights.y", "9")

  val reserve_flight_payment: HttpRequestBuilder = http("reserve_flight_payment")
    .post("/cgi-bin/reservations.pl")
    .formParam("outboundFlight", "#{flight_out_current}")
    .formParam("firstName", "Anton")
    .formParam("lastName", "Vlasov")
    .formParam("address1", "Test 1")
    .formParam("address2", "123456")
    .formParam("pass1", "Anton Vlasov")
    .formParam("creditCard", "123")
    .formParam("expDate", "123")
    .formParam("oldCCOption", "")
    .formParam("numPassengers", "1")
    .formParam("seatType", "Coach")
    .formParam("seatPref", "None")
    .formParam("advanceDiscount", "0")
    .formParam("returnFlight", "")
    .formParam("JSFormSubmit", "off")
    .formParam("buyFlights.x", "66")
    .formParam("buyFlights.y", "12")
    .formParam(".cgifields", "saveCC")





}
