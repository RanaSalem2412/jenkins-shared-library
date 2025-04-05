@Library('jenkins-shared-library@main') _

pipeline {
                                                                                       
    environment {
        GITHUB_REPO_URL    = 'https://github.com/IbrahimAdell/App3.git'
         GITHUB_REPO_BRANCH = 'main'
        DOCKER_IMAGE = "ranasalem2412/my-app"
        DOCKER_TAG = "latest"
    }
    
    stages {
        stage('Checkout') {
            steps {
                echo 'Cloning repository containing Dockerfile and source code...'
                git 'https://github.com/IbrahimAdell/FinalProjectCode.git'
            }
        }

        stage('Run Unit Tests') {
            steps {
                echo 'Running unit tests...'
                runUnitTest()
            }
        }

        stage('Build JAR') {
            steps {
                echo 'Building JAR file...'
                buildJar()
            }
        }

        stage('Build Docker Image') {
            steps {
                echo 'Building Docker image...'
                sh 'docker build -t ${DOCKER_IMAGE}:${DOCKER_TAG} .'
            }
        }

        stage('Push Docker Image') {
            steps {
                echo 'Pushing Docker image to Docker Hub...'
                pushImage()
            }
        }

        stage('Delete Local Docker Image') {
            steps {
                echo 'Deleting local Docker image...'
                deleteImage()
            }
        }

        stage('Update Kubernetes Manifests') {
            steps {
                echo 'Updating Kubernetes manifests with new image...'
                updateManifests()
            }
        }

        stage('Push Kubernetes Manifests') {
            steps {
                echo 'Pushing Kubernetes manifests to Git...'
                pushManifests()
            }
        }
    }
}
