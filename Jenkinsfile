Pipeline {
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
  }
}
