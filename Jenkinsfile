pipeline {
    agent any
    stages {
        stage('Compile') {
            steps {
                dir('projDeliveries/backend') {
                    sh 'mvn compile'
                }
                echo 'Compilation successful';
            }
        }
        stage('Build') {
            steps {
                dir('projDeliveries/backend') {
                    sh 'mvn clean'
                    sh 'mvn package -Dmaven.test.skip=true'
                }
                echo 'Build successful';
            }
        }
        stage('Test') {
            steps {
                dir('projDeliveries/backend') {
                    sh ' mvn test'
                }
                echo 'Test successful';
            }
        }
        stage('Deploy') {
            steps {
                dir('projDeliveries') {
                    sh 'docker-compose up -d --build'
                }
                echo 'Deploy successful';
            }
        }
        stage('Monitor') {
            steps {
                echo 'Now you can monitor!'
            }
        }
    }
}
