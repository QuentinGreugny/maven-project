pipeline {
  
  agent any
  
  parameters {
    string (name: 'tomcat_dev',
            defaultValue:'C:\Program Files\apache-tomcat-8.5.73-formation-jenkins\webapps',
            description:'Staging Server : 8080')
    string (name: 'tomcat_prod',
            defaultValue:'C:\Prog\apache-tomcat-8.5.73-formation-production\webapps',
            description:'Staging Server : 9090')
  }
  
  triggers {
    pollSCM('* * * * *') //Polling Source Control
  }
  
  stages {
    stage ('Build') {
      steps {
        bat 'mvn clean package'
      }
      post {
        success {
          echo "Now Archiving ....."
          archiveArtifacts artifacts: '**/target/*.war'
        }
      }
    }
    
    stage ('Deployments') {
      parallel {
        stage ('Deploy to Staging') {
          steps {
            bat "cp **/target/*.war %tomcat_dev%"
          }
        }
        
        stage ('Deploy to Prodution') {
          steps {
            bat "cp **/target/*.war %tomcat_prod%"
          }
        }
      }
    }
  }
}
