def call() {
    echo "Checking if Docker image exists..."
    sh "docker images | grep ${DOCKER_IMAGE}:${DOCKER_TAG} || exit 1"
    echo "Pushing Docker image ${DOCKER_IMAGE}:${DOCKER_TAG} to Docker Hub..."
    sh 'docker push ${DOCKER_IMAGE}:${DOCKER_TAG}'
}
