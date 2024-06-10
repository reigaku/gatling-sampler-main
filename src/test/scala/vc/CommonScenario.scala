package vc

import io.gatling.core.Predef._
import io.gatling.core.structure.{ChainBuilder, ScenarioBuilder}
//import io.gatling.http.Predef._
//import vc.Feeders._

object CommonScenario{
  def apply(): ScenarioBuilder = new CommonScenario().scn
}

class CommonScenario {
  val scn: ScenarioBuilder = scenario("Common scenario")
    .exec(Actions.getMainPage)
  .exec(Actions.getMainPage1)
  .exec(Actions.login)
    .exec(Actions.login)
    .exec(Actions.login1)
    .exec(Actions.login2)
    .exec(Actions.flights_page)
    .exec(Actions.flights_page1)
    .exec(Actions.flights_page2)
    .exec(Actions.reserve_flight)
    .exec(Actions.reserve_flight1)
    .exec(Actions.reserve_flight_payment)
    .exec(Actions.flights_page2)
    .exec(Actions.flights_page2)


  //val loginGroup: ChainBuilder = group("my login"){
  //  exec(Actions.login)
  //    .exec(Actions.check)
  //    .exec(Actions.notifications)
  //}


}
