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
    stage ('Create Image'){
        steps{
             sh "docker build -t navreetk/firstcommit:${BUILD_NUMBER} ."
        }
    }
    stage('Docker Login'){
        steps{
            withCredentials([
                usernamePassword(credentialsId: 'docker_id', 
                passwordVariable: 'DOCKER_PASSWORD', usernameVariable: 'DOCKER_USERNAME')]) {
        sh "docker login -u ${DOCKER_USERNAME} -p ${DOCKER_PASSWORD}"
        }
        
        }
    }
    
    stage ('Push Docker Image'){
      steps{
      script{
          sh "docker push navreetk/firstcommit:${BUILD_NUMBER}"
        }
      }
    }
    stage('Deploy to Docker'){
        steps{
            script{
                def dockerRun = 'docker run -itd -p 8081:8080 -d navreetk/firstcommit:${BUILD_NUMBER}        
               sshagent(['ubuntu']) { 
            sh "ssh -o StrictHostKeyChecking=no ubuntu@35.183.188.90 ${dockerRun}"          
        }
            }
        }
        
    }
    
    }
  }
