def call() {
    dir('web-app') {
        sh 'chmod +x gradlew'
        sh './gradlew test'
    }
}
