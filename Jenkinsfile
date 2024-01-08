pipeline {
    agent {
        node {
            label 'docker-agent-alpine'
        }
    }
    stages {
        stage('Temp-Test') {
            steps {
                sh 'echo "Hello World"'
            }
        }
        stage('Build and Test') {
            steps {
                echo "Building and Testing"
                sh """
                    chmod +x mvnw
                    ./mvnw clean install
                """
            }
        }
    }
}