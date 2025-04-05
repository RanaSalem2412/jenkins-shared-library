def call() {
    echo 'Deleting Docker image locally...'

    
    def imageExists = sh(script: 'docker images -q ranasalem2412/my-app', returnStdout: true).trim()

    if (imageExists) {
        sh 'docker rmi ranasalem2412/my-app'
    } else {
        echo 'Docker image not found, skipping deletion.'
    }
}
