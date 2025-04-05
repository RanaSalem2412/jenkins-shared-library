def call() {
    echo 'Pushing updated Kubernetes manifests...'
    sh 'git add k8s-manifests/'
    sh 'git commit -m "Updated image tag in deployment.yaml"'
    sh 'git push'
}

