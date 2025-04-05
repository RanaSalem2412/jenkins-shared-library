def call() {
    echo 'Building JAR...'
    sh './gradlew build -x test'
}

