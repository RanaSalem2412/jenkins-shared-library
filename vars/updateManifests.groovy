def call() {
    echo 'Updating Kubernetes manifests...'
    sh 'sed -i "s/old-tag/${env.GIT_COMMIT}/g" k8s-manifests/deployment.yaml'
}

