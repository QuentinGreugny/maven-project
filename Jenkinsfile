pipeline {
  
  agent any
  
  parameters {
  string(name:'tomcat_dev',
  defaultValue:'C:/Prog/Apache_Tomcat_8_5_73_Formation_Jenkins/webapps',
  description:'Staging Server : 8181')
  string(name:'tomcat_prod',
  defaultValue:'C:/Prog/Apache_Tomcat_8_5_73_Formation_Production/webapps',
  description:'Prodution Server : 9090')
  }
  
  triggers {
  pollSCM('* * * * *') // Polling Source Control
  }
  
  stages {
    stage('Build') {
		steps{
        bat 'mvn clean package'
		}
		post {
			success {
			echo "Now Archiving ....."
			archiveArtifacts artifacts: '**/target/*.war'
			}
		}
    }
    
    stage('Deployments') {
		parallel {
			stage ('Deploy to Staging') {
				steps {
				bat "cd **/target/*.war %tomcat_dev%"
				}
			}
        
			stage ('Deploy to Prodution') {
				steps {
				bat "cd **/target/*.war %tomcat_prod%"
				}
			}
		}
    }
  }	
}
