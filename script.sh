#!/bin/sh
echo "---------------------- RUNNING..."
echo "-----------------------------------------------------"

echo "---------- DELETING REPORT FILE EXISTS..."
echo "-----------------------------------------------------"

FILE=report
if test -f "$FILE"; then
    echo "$FILE exists."
    rm -r FILE
fi

echo "-----------------------------------------------------"
echo "----------------- GENERATING REPORT..."
.allure/allure-2.7.0/bin/allure generate target/allure-results -o report

echo "---------- DELETING FOLDER ALLURE-REPORT..."
rm -r target/allure-results

echo "-----------------------------------------------------"
echo "----------------- CUSTOMIZING REPORT..."
cp .allure/report-assets/executors.json report/widgets/executors.json
cp .allure/report-assets/index.html report/index.html
cp .allure/report-assets/app.js report/app.js
cp .allure/report-assets/styles.css report/styles.css
cp .allure/report-assets/favicon.ico report/favicon.ico



echo "------------------- RUNNIG REPORT..."
allure open report

echo "--------------------- FINISHED  ---------------------"

