void setBuildStatus(String message, String state) {
    step([
        $class: 'GitHubCommitStatusSetter',
        reposSource: [$class: 'ManuallyEnteredRepositorySource', url: 'https://github.com/danyjf/tqs-project'],
        contextSource: [$class: 'ManuallyEnteredCommitContextSource', context: 'CI-CD/jenkins/build-status'],
        errorHandlers: [[$class: 'ChangingBuildStatusErrorHandler', result: 'UNSTABLE']],
        statusResultSource: [$class: 'ConditionalStatusResultSource', results: [[$class: 'AnyBuildResult', message: message, state: state]]]
    ]);
}

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
    
    post {
        success {
            setBuildStatus('Build complete', 'success');
        }
        failure {
            setBuildStatus('Failed', 'failure');
        }
    }
}
