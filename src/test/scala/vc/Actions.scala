package vc

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder

object Actions {

  val getMainPage: HttpRequestBuilder = http("getMainPage")
    .get("/cgi-bin/nav.pl")
    .queryParam("query", "in=home")
    .check(status is 200)
    .check(
      regex("(?<=name=\"userSession\" value=\")[A-Za-z0-9.]+").saveAs("userSession")
    )

  val login: HttpRequestBuilder = http("login")
    .post("*/cgi-bin/login.pl")
    .formParam("userSession", "#{userSession}")
    .formParam("username", "chudo")
    .formParam("password", "negr")



  val subs: HttpRequestBuilder = http("getSubs")
    .get("/subs")
    .queryParam("mode", "ajax")
    .check(regex("""Ещё (\d+)&nbsp;подпис\W+<""").is("884"))
    .check(regex("""Ещё (\d+)&nbsp;подпис\W+<""").saveAs("counter"))

  val search: HttpRequestBuilder = http("search #{counter}")
    .get("/search/v2/content/relevant")
    .queryParam("mode", "ajax")
    .queryParam("query", "#{word}")
    .check(status not 500)
    .check(regex("""l-page l-page--header-content-sidebar l-mb-12""").exists)



  val check: HttpRequestBuilder = http("check")
    .get("/auth/check")
    .queryParam("mode", "raw")
    .check(jsonPath("$.rc").is("200"))

  val notifications: HttpRequestBuilder = http("notifications")
    .get("/notifications/unread-count")
    .queryParam("mode", "raw")
    .check(jsonPath("$.rc").is("200"))

}
