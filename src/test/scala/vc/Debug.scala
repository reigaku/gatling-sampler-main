package vc

import io.gatling.core.Predef._
import scala.concurrent.duration.DurationInt
//import io.gatling.http.Predef._

class Debug extends Simulation{
  setUp(
    CommonScenario().inject(
      // вариантант для поиска максимума
      /**
       constantUsersPerSec(1).during(300),
       constantUsersPerSec(2).during(300),
       constantUsersPerSec(3).during(300),
       constantUsersPerSec(4).during(300),
       */

      constantUsersPerSec(2).during(1.hour)
      // вариант для 80%
      /**
       * constantUsersPerSec(2).during(1.hour) */
    )

  )
    .protocols(httpProtocol)
}