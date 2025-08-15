package org.iti;

def dockerBuild(String imageName, String buildNumber) {
        sh """
          docker build -t ${IMAGE_REPO}:${IMAGE_TAG} .
          echo "${DOCKER_PASS}" | docker login -u "${DOCKER_USER}" --password-stdin
          docker push ${IMAGE_REPO}:${IMAGE_TAG}
          docker logout || true
        """
}
