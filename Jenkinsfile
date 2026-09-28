pipeline {
    agent any

    tools {
        maven 'Maven'
    }

    stages {

        stage('Checkout') {
            steps {
                git 'https://github.com/SwastikP121/cicd'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    sh '''
                        mvn sonar:sonar \
                        -Dsonar.projectKey=cicd \
                        -Dsonar.projectName="CI/CD Demo"
                    '''
                }
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying Java Web Application...'
            }
        }
    }
}
