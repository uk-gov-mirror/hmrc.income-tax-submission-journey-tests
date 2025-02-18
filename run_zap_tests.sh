#!/usr/bin/env bash

ENV=${1:-local}
BROWSER=${2:-chrome}

echo "Starting ZAP Daemon..."
./run_zap_daemon.sh
sleep 10

if [ "$BROWSER" = "chrome" ]; then
    DRIVER="-Dwebdriver.chrome.driver=/usr/local/bin/chromedriver"
elif [ "$BROWSER" = "firefox" ]; then
    DRIVER="-Dwebdriver.gecko.driver=/usr/local/bin/geckodriver"
fi

# NOTE: It is not required to proxy every journey test via ZAP. The intention of proxying a test through ZAP is to expose all the
# relevant pages of an application to ZAP. So tagging a subset of the journey tests or creating a
# single ZAP focused journey test is sufficient.

sh insert_interest_data.sh
sh insert_dividends_data.sh
sbt -Dbrowser=$BROWSER -Denvironment=$ENV $DRIVER -Dzap.proxy=true "testOnly uk.gov.hmrc.test.ui.cucumber.runner.ZapRunner"
sbt "testOnly uk.gov.hmrc.test.ui.ZapSpec"
curl -X DELETE http://localhost:9303/setup/all-data
