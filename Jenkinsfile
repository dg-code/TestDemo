pipeline {
    agent any
    tools {
    	maven 'mvn'
    	jdk 'java' 
    }
    stages {
        stage('Build') {
            steps {
                echo 'Hello, Maven'
                bat 'mvn -version'
            }
        }
        stage('Example Test') {
            steps {
                echo 'Hello, JDK'
                bat 'java -version'
            }
        }
    }
}