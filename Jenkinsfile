pipeline {
    agent any

    tools {
        maven 'Maven'
        jdk 'JDK17'
    }

    stages {

        stage('Clone Code') {
            steps {
                git 'https://github.com/Gnaneswar15/springboot-jenkins-demo.git'
            }
        }

        stage('Build') {
            steps {
                dir('SpringSB') {
                    bat 'mvn clean install'
                }
            }
        }

       stage('Stop Old App') {
    steps {
        bat '''
        for /f "tokens=5" %%a in ('netstat -aon ^| findstr :9091') do taskkill /F /PID %%a
        exit /b 0
        '''
    }
}

        stage('Run App') {
            steps {
                dir('SpringSB') {
                    bat 'start java -jar target/SpringSB-0.0.1-SNAPSHOT.jar'
                }
            }
        }
    }
}
