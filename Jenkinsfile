@Library('shared-lib')_

pipeline {
    agent any

    tools { 
    maven 'maven-tools'
    git 'git-v1.0'
    }

    environment {
    DOCKER_USER = credentials('kariman-docker')
    DOCKER_PASS = credentials('password-docker')
    IMAGE_REPO  = 'karimanmahmoud/app-java'
    IMAGE_TAG   = "v${env.BUILD_NUMBER}"

    GITOPS_URL    = 'https://github.com/karimanmahmoudd/argocd-java-project.git'
    GITOPS_BRANCH = 'main'
    GITOPS_FILE   = 'deployment.yaml'
    }
    stages {
        stage('Build') {
            steps {
                script {
                    def mavenBuild = new org.iti.mvn()
                    mavenBuild.javaBuild("package install")
                }
            }
        }

        stage('Archive') {
            steps {
                script {
                    def archiveApp = new org.iti.archiveApp()
                    archiveApp.archive()
                }
            }
        }

        stage('Docker build & push') {
            steps {
                script {
                    def dockerBuildAndPush = new org.iti.dockerBuildAndPush()
                    dockerBuildAndPush.dockerBuildAndPush()
                }
            }
        }
        stage('Update ArgoCD') {
            steps {
                script {
                    def updateArgoCD = new org.iti.updateArgoCD()
                    updateArgoCD.updateArgoCD()
                }
            }
        }
    }
}