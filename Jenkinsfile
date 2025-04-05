@Library('jenkins-shared-library@main') _

pipeline {
    agent { label 'docker-agent' }                                                                                   
    environment {
        GITHUB_REPO_URL    = 'https://github.com/IbrahimAdell/FinalProjectCode.git'
        GITHUB_REPO_BRANCH = 'main'
        DOCKER_IMAGE = "ranasalem2412/my-app"
        DOCKER_TAG = "latest"
        LIBRARY_REPO = "https://github.com/RanaSalem2412/jenkins-shared-library.git"
    }
    
    stages {
        stage('Checkout') {
            steps {
                echo 'Cloning repository containing Dockerfile and source code...'
                git url: "${GITHUB_REPO_URL}", branch: "${GITHUB_REPO_BRANCH}"
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

        stage('Checkout Shared Library to Get Dockerfile') {
            steps {
                dir('jenkins-shared-library') {
                    git url: "${LIBRARY_REPO}", branch: 'main'
                }
            }
        }

        stage('Copy Dockerfile to App') {
            steps {
                sh 'cp jenkins-shared-library/Dockerfile ./'
                sh 'ls -l ./Dockerfile'
            }
        }

        stage('Build Docker Image') {
            steps {
                echo 'Building Docker image...'
                sh 'docker build -t ${DOCKER_IMAGE}:${DOCKER_TAG} .'

            }
        }
        echo 'Listing Docker images...'
        sh 'docker images'

        stage('Docker Login') {
    steps {
        script {
            // تسجيل الدخول إلى Docker Hub باستخدام بيانات الاعتماد المحددة
            docker.withRegistry('https://index.docker.io/v1/', 'dockerhub-creds') {
                echo 'Logged into Docker Hub'
            }
        }
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

