def call() {
    echo 'Building Docker image...'
    sh 'docker build -t ${DOCKER_IMAGE}:${DOCKER_TAG} .'  // قمنا بإضافة مسار العمل في الـ Jenkinsfile مباشرة
}
