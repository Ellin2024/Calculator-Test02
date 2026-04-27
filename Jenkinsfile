pipeline {
	agent any

	 tools {
        maven 'maven3.9'
        
    }

	environment {
        IMAGE_NAME = "yym-calcu-image"
		CONTAINER_NAME = "yym-calcu-container"
		BUILD_TAG_VERSION = "${BUILD_NUMBER}"
        APP_JAR = "target\\Calculator-v1.jar"
        DOCKER_CREDENTIALS_ID = "dockerhub-credentials"
        DOCKER_HOST_PORT = "7070"
    }
	
	
	
	stages {
		
		stage("Compile") {
            steps {
                sh "mvn compile"
            }
        }
		
		stage('Checkout'){
			steps {
				git branch: 'main', url: 'https://github.com/Ellin2024/Calculator-Test02.git'
			}
		}
		
		stage('Build Jar'){
			steps{
				 sh 'mvn clean package -DskipTests'
			}
		}
		
		//Using Env
		stage('Build Docker Image') {
            steps {
                script {
                    // Build Docker image and tag it with build number
                  sh "docker build -t ellinhugo/calculator:3.0 ."
                }
            }
        }
	    
      	stage('Push to Docker Hub') {
        steps {
            withCredentials([usernamePassword(
                credentialsId: 'dockerhub',
                usernameVariable: 'USER',
                passwordVariable: 'PASS'
            )]) {
                sh 'docker login -u $USER -p $PASS'
                sh 'docker push ellinhugo/calculator:3.0'
            }
        }
    }
        
        stage('Deploy to Kubernetes') {
            steps {
                sh '''
                kubectl apply -f deployment.yaml
                kubectl apply -f service.yaml
                '''
            }
        }
	}
	 post {
          always {
              echo "✅ Pipeline finished."
          }
          success {
             echo "Pipeline succeeded! App running at http://150.95.84.29:${env.DOCKER_HOST_PORT}/"
			  emailext(
            to: 'yyint3914@gmail.com',
			subject: '✅ Build SUCCESS',
			body: 'Build completed successfully.'
             )
          }
          failure {
              echo "Pipeline failed."
			  emailext(
                to: 'yyint3914@gmail.com',
                subject: '❌ Build FAILED',
                body: 'Build failed. Check logs.'
            )
          }
      }
}