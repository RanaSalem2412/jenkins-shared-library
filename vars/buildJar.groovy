def call() {
    dir('web-app') {
        sh './gradlew build'
    }
}
