pipeline {
    agent any
    environment {
        //be sure to replace "felipelujan" with your own Docker Hub username
        //changesss
        DOCKER_IMAGE_NAME = "dyronrh/cocacola-backend"
    }
    stages {
         stage('Build') {	
             steps {	
                echo 'Running build automation'	
                sh 'chmod +x ./gradlew'	
                sh './gradlew build -x test'	
            }	
        }
       
        stage('Build Docker Image') {
            when {
                branch 'master'
            }
            steps {
                script {
                   sh 'docker build -t cocacola-backend:1.1.1 .'
                }
            }
        }
        stage('Push Docker Image') {
            when {
                branch 'master'
            }
            steps {
                script {
                    docker.withRegistry('https://registry.hub.docker.com', 'docker_hub_login') {
                        app.push("${env.BUILD_NUMBER}")
                        app.push("latest")
                    }
                }
            }
        }
        stage('DeployToProduction') {
            when {
                branch 'master'
            }
            steps {
                milestone(1)
                kubernetesDeploy(
                    kubeconfigId: 'kubeconfig',
                    configs: 'k8s_svc_deploy.yaml',
                    enableConfigSubstitution: true
                )
            }
        }
    }
}
