def call() {
    echo 'Updating Kubernetes manifests with the new Docker image...'

    // قراءة محتوى deployment.yaml و استبدال الـ image بالـ Docker image الجديد
    sh """
        sed -i 's|image: .*|image: ${DOCKER_IMAGE}:${DOCKER_TAG}|' k8s-manifests/deployment.yaml
    """
}
