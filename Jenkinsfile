pipeline {
    agent any
    stages {
        stage('Run Tests') {
            steps {
                sh './mvnw clean test'
            }
            post{
                always{
                    junit '**/surefire-reports/*.xml'
                    cucumber buildStatus: 'UNCHANGED', customCssFiles: '', customJsFiles: '', failedFeaturesNumber: -1, failedScenariosNumber: -1, failedStepsNumber: -1, fileIncludePattern: '**/*.json', pendingStepsNumber: -1, skippedStepsNumber: -1, sortingMethod: 'ALPHABETICAL', undefinedStepsNumber: -1
                }
            }
        }
    }
}