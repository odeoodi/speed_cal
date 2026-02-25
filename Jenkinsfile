pipeline {
    agent any

    tools {
        maven 'Maven3'
    }

    environment {
          PATH = "usr/local/"
          DOCKERHUB_CREDENTIALS_ID = 'docker_hub'
          DOCKERHUB_REPO = 'odeoodi/speed_cal'
          DOCKER_IMAGE_TAG = 'latest'
      }



    stages {

        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/odeoodi/speed_cal.git'
            }
        }

        stage('Build') {
            steps {
                'mvn clean install'
            }
        }

        stage('Generate Report') {
            steps {
                'mvn jacoco:report'
            }
        }

        stage('Publish Test Results') {
            steps {
                junit '**/target/surefire-reports/*.xml'
            }
        }

        stage('Publish Coverage Report') {
            steps {
                jacoco()
            }
        }

         stage('Build Docker Image') {
              steps {
                 script {
                     docker.build("${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}")
                 }
              }
         }

         stage('Push Docker Image to Docker Hub') {
                  steps {
                      script {
                          docker.withRegistry('https://index.docker.io/v1/', DOCKERHUB_CREDENTIALS_ID) {
                              docker.image("${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}").push()
                          }
                      }
                  }
              }



    }
}