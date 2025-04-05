def call() {
    echo 'Updating Kubernetes manifests with the new Docker image...'

    // الانتقال إلى مجلد الكود الذي يحتوي على الملفات
    dir('jenkins-shared-library/k8s-manifests') {
        // قراءة محتوى deployment.yaml و استبدال الـ image بالـ Docker image الجديد
        sh """
            sed -i 's|image: .*|image: ${DOCKER_IMAGE}:${DOCKER_TAG}|' deployment.yaml
        """
    }
}
