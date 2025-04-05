def call() {
    echo 'Pushing updated Kubernetes manifests to Git repository...'

    // دفع التغييرات إلى الـ Git repository
    sh """
        git add k8s/deployment.yaml k8s/service.yaml
        git commit -m "Update Kubernetes manifests with new Docker image"
        git push origin master
    """
}
