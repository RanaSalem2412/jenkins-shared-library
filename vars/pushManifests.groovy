def call() {
    echo 'Pushing updated Kubernetes manifests to Git repository...'

    // الانتقال إلى مجلد الكود الذي يحتوي على الملفات
    dir('jenkins-shared-library/k8s-manifests') {
        // دفع التغييرات إلى الـ Git repository باستخدام بيانات الاعتماد
        withCredentials([usernamePassword(credentialsId: 'git_credential', usernameVariable: 'GIT_USERNAME', passwordVariable: 'GIT_PASSWORD')]) {
            sh """
                git config --global user.email "your-email@example.com"
                git config --global user.name "Your Name"
                git add deployment.yaml service.yaml
                git commit -m "Update Kubernetes manifests with new Docker image"
                git push https://${GIT_USERNAME}:${GIT_PASSWORD}@github.com/RanaSalem2412/jenkins-shared-library.git HEAD:main
            """
        }
    }
}
