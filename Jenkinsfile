pipeline {
    agent any
    tools {
    	maven 'mvn'
    	jdk 'java' 
    }
    stages {
        stage('Build') {
            steps {
                bat 'mvn clean'
            }
        }
        stage('Test') {
            steps {
            	bat 'mvn verify'
            }
        }
    }
    post('Publish Reports') {
    	always {
    		publishHTML (target: [
		      allowMissing: false,
		      alwaysLinkToLastBuild: false,
		      keepAll: true,
		      reportDir: 'target/failsafe-reports',
		      reportFiles: 'index.html',
		      reportName: "Test Report"
		    ])
    	}
    }
}