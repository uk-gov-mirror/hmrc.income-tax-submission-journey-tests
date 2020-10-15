package uk.gov.hmrc.test.ui.pages

import org.openqa.selenium.By
import org.scalatest.matchers.should.Matchers

trait CommonElements extends BasePage with Matchers{

  def load(key: String): By =
    elements(key)

  val elements: Map[String, By] = Map(
    //Common Elements
    "yes"       -> By.id("value"),
    "no"        -> By.id("value-no"),

    //Dividends Elements
    "dividends" -> By.cssSelector("#main-content > div > div > main > div > ol > li:nth-child(1) > ol > li:nth-child(4) > span.app-task-list__task-name > a"),

    //Interest Elements
    "interest"  -> By.id("a-made-up-id")
  )
}
