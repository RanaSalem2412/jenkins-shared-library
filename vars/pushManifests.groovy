def call() {
    echo 'Pushing updated Kubernetes manifests to Git repository...'

    // دفع التغييرات إلى الـ Git repository
    sh """
        git add k8s-manifests/deployment.yaml k8s-manifests/service.yaml
        git commit -m "Update Kubernetes manifests with new Docker image"
        git push origin main
    """
}
