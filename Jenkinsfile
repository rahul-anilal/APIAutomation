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
                }
            }
        }
    }
}