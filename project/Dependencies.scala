import sbt._

object Dependencies {

  val test = Seq(
    "uk.gov.hmrc"                %% "webdriver-factory"       % "0.16.0" % Test,
    "org.scalatest"              %% "scalatest"               % "3.2.0" % Test,
    "io.cucumber"                %% "cucumber-scala"          % "6.1.1" % Test,
    "io.cucumber"                %  "cucumber-junit"          % "6.1.1" % Test,
    "junit"                      %  "junit"                   % "4.12"  % Test,
    "com.novocode"               %  "junit-interface"         % "0.11"  % Test,
    "uk.gov.hmrc"                %% "zap-automation"          % "2.8.0" % Test,
    "com.typesafe"               %  "config"                  % "1.4.1" % Test
  )

}
