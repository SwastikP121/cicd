pipeline {
    agent any

    options {
        timestamps()
        disableConcurrentBuilds()
    }

    parameters {
        string(
            name: 'DEPLOY_DIR',
            defaultValue: '',
            description: 'Optional writable Tomcat webapps directory. Leave empty to skip deployment.'
        )
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Test') {
            steps {
                sh 'mvn -B clean test'
            }
        }

        stage('Package') {
            steps {
                sh 'mvn -B package -DskipTests'
            }
        }

        stage('Deploy') {
            when {
                expression {
                    params.DEPLOY_DIR?.trim()
                }
            }
            steps {
                sh 'cp target/simple-web-app.war "$DEPLOY_DIR/simple-web-app.war"'
            }
        }
    }

    post {
        always {
            junit testResults: 'target/surefire-reports/*.xml', allowEmptyResults: true
            archiveArtifacts artifacts: 'target/simple-web-app.war', fingerprint: true, allowEmptyArchive: true
        }
    }
}
