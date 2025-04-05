def call() {
    echo 'Deleting Docker image locally...'
    sh 'docker rmi my-repo/my-app'
}

