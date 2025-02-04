pipeline {
    agent any

    tools {
        maven 'Maven_3.8.6'
    }
    stages {
        stage('Run Tests') {
            steps {
                sh 'mvn test'
            }
        }
    }
}