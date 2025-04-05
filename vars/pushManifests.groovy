def call() {
    echo 'Pushing updated Kubernetes manifests to Git repository...'

    // الانتقال إلى مجلد الكود الذي يحتوي على الملفات
    dir('jenkins-shared-library/k8s-manifests') {
        // دفع التغييرات إلى الـ Git repository
        sh """
            git add deployment.yaml service.yaml
            git commit -m "Update Kubernetes manifests with new Docker image"
            git push origin main
        """
    }
}
