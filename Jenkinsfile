pipeline {
  agent any
  tools {
    maven 'MAVEN'
  }
  stages {
    stage ('Maven Build'){
      steps {
        checkout scmGit(
          branches: [[name: '*/main']], 
          extensions: [], 
          userRemoteConfigs: [[
          credentialsId: 'github-ID', url: 'https://github.com/NavreetK/jenkins-docker']]
        )
        sh "mvn clean package"
      }
    }

    stage ('Build Docker Image'){
      steps{
      script{
        withDockerRegistry(credentialsId: 'docker_id') {
         sh "docker build -t navreetk/firstcommit:tag1"
          sh "docker push"
        }
      }
      }
    }
  }
}
