/*
 * Copyright 2020 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.test.ui.cucumber.stepdefs

import uk.gov.hmrc.test.ui.pages.CommonPage
import org.openqa.selenium.By

class CommonStepDef extends BaseStepDef {

  And ("""^clicks continue$"""){ () =>
    driver.findElement(By.cssSelector("#main-content > div > div > form > button.govuk-button.govuk-\!-margin-right-1")).click()
  }

  When("""^the user clicks the provide updates button$""") { () =>
    driver.findElement(By.cssSelector("#main-content > div > div > main > div > a")).click()
  }

  Then("""^the user will redirect to the Income Tax Submission start page$""") { () =>
    driver.getCurrentUrl should be (CommonPage.url + "/start")
  }

  Then("""^the user should be on the overview page$""") { () =>
    driver.getCurrentUrl should be (CommonPage.url + "/view")
  }

  Given ("""^the user clicks on the dividends link$^""") { () =>
    driver.findElement(By.cssSelector(
      "#main-content > div > div > main > div > ol > li:nth-child(1) > ol > li:nth-child(4) > span.app-task-list__task-name > a"
    )).click()
  }

  Then("""^the user should be on the received UK dividends page$""") { () =>
    driver.getCurrentUrl should be(CommonPage.url + "/dividends/dividend-uk-status")
  }

  Then("""^the user should be on the UK dividends amount page$""") { () =>
    driver.getCurrentUrl should be(CommonPage.url + "/dividends/dividend-uk-amount")
  }

  When ("""^the user clicks the no radio button$""") { () =>
    driver.findElement(By.id("dividend-uk-status-2")).click()
  }

  When ("""^the user clicks the yes radio button$""") { () =>
    driver.findElement(By.id("dividend-uk-status")).click()
  }

  Then ("""^the user should be on the authorised unit trusts, investment companies/trusts page$""") { () =>
    driver.getCurrentUrl should be (CommonPage.url + "/dividends/other-dividend-status")
  }

  Then ("""^the user should be on the authorised unit trusts, investment companies/trusts amount page$""") { () =>
    driver.getCurrentUrl should be (CommonPage.url + "/dividends/other-dividend-amount")
  }

  Then ("""^the user should be on the dividends check your answers page$""") { () =>
    driver.getCurrentUrl should be (CommonPage.url + "/dividends/summary")
  }

  When ("""^the user clicks the save and continue button$""") { () =>
    driver.findElement(By.cssSelector("#main-content > div > div > form > button.govuk-button.govuk-\!-margin-right-1")).click()
  }

  When ("""^the user enters a value of £1000$""") { () =>
    driver.findElement(By.id("dividend-uk-amount")).sendKeys("1000")
  }

  When ("""^the user enters a value of £500$""") { () =>
    driver.findElement(By.id("other-dividend-amount")).sendKeys("500")
  }

}
