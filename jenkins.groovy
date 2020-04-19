#!/usr/bin/env groovy
node() {

    try {
        stage('Prepare code') {
            git url: 'https://github.com/jdmesalosada/selenium-framework-poc.git', branch: '${branch}'
        }

        stage('Start Testing'){
            withMaven(maven: 'maven3.6.1') {
                sh "mvn clean test -Denvironment=${environment} -Dgrid.url=${gridUrl} -Dcucumber.options=\"--tags '@${tags}'\" -Ddriver.type=${browser}"
            }
        }

        currentBuild.result = "SUCCESS"
    } catch (e) {
        // If there was an exception thrown, the build failed
        currentBuild.result = "FAILED"
        throw e

    } finally {

        publishReport();
        //sendSlackNotification(currentBuild.result);

    }

}

def publishReport(){
    publishHTML(target: [
            reportName : 'Cucumber Report',
            reportDir:   'target/cucumber/cucumber-html-reports/',
            reportFiles: 'overview-features.html',
            keepAll:     true,
            alwaysLinkToLastBuild: true,
            allowMissing: false
    ])
}