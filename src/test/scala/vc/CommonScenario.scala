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
  exec(Actions.getMainPage)
  exec(Actions.login)


  //val loginGroup: ChainBuilder = group("my login"){
  //  exec(Actions.login)
  //    .exec(Actions.check)
  //    .exec(Actions.notifications)
  //}


}
