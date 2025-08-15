package org.iti;

def updateArgoCD(String IMAGE_REPO, String IMAGE_TAG) {
        git branch: 'main',
            credentialsId: 'github-credentials',
            url: 'git@github.com:karimanmahmoudd/argocd-java-project.git'

        // Now run shell commands
        sh """
            git config user.name "karimanmahmoudd"
            git config user.email "kariman122@gmail.com"
            
            pwd
            ls
            sed -i "s|image: .*|image: ${IMAGE_REPO}:${IMAGE_TAG}|" deployment.yaml
            git add .
            git commit -m "update image" || true
            git push origin main
        """
}
