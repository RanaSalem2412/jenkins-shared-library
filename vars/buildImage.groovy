def call() {
    echo 'Building Docker image...'
    sh 'docker build -t my-repo/my-app .'
}

