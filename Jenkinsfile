pipeline {
  //Donde se va a ejecutar el Pipeline
  agent {
    label 'master'
  }

  environment{
    dirSonar = "${tool name: 'SonarScanner', type:'hudson.plugins.sonar.SonarRunnerInstallation'}"
  }

  //Opciones específicas de Pipeline dentro del Pipeline
  options {
    	buildDiscarder(logRotator(numToKeepStr: '3'))
 	disableConcurrentBuilds()
  }

  //Una sección que define las herramientas preinstaladas en Jenkins
  tools {
    jdk 'jdkJava11' //Preinstalada en la Configuración del Master
    gradle 'Gradle6.2.2' //Preinstalada en la Configuración del Master
  }

  //Aquí comienzan los items del Pipeline
  stages{
    stage('Checkout') {
      steps{
        echo "------------>Checkout<------------"
        checkout([
			$class: 'GitSCM', 
			branches: [[name: '*/master']], 
			doGenerateSubmoduleConfigurations: false, 
			extensions: [], 
			gitTool: 'GitJenkins', 
			submoduleCfg: [], 
			userRemoteConfigs: [[
				credentialsId: 'personal-github', 
				url:'https://github.com/valenciadaniel0/buyGroup.git'
			]]
		])
        
      }
    }
    
	stage('Clean & Compile') {
      steps{
      	bat 'gradle --b ./back/group/build.gradle clean compileJava'
      }
    }
	
	 stage('Build') {
      steps {
        echo "------------>Build<------------"
        //Construir sin tarea test que se ejecutó previamente
		bat 'gradle --b ./back/group/build.gradle build -x test'
                
      }
    } 
	
    stage('Unit Tests') {
      steps{
      //	sh 'gradle --b ./back/build.gradle clean'
        echo "------------>Unit Tests<------------"
		bat 'gradle --b ./back/group/build.gradle test'
      }
    }

    stage('Static Code Analysis') {
      steps{
        echo '------------>Análisis de código estático<------------'
        //def dirSonar = "${tool name: 'SonarScanner', type:'hudson.plugins.sonar.SonarRunnerInstallation'}" 
          echo "${dirSonar}"
        
        withSonarQubeEnv('Sonar') {
          
			    bat '"${dirSonar}\\bin\\sonar-scanner"'
        }
      }
    }

    
  }

  post {
    always {
      echo 'This will always run'
    }
    success {
		echo 'This will run only if successful'
		junit 'back/group/build/test-results/test/*.xml' 
	}

    failure {
		echo 'This will run only if failed'
		//mail (to: 'daniel.valencia@ceiba.com.co',subject: "Failed Pipeline:${currentBuild.fullDisplayName}",body: "Something is wrong with ${env.BUILD_URL}")

	}
    unstable {
      echo 'This will run only if the run was marked as unstable'
    }
    changed {
      echo 'This will run only if the state of the Pipeline has changed'
      echo 'For example, if the Pipeline was previously failing but is now successful'
    }
  }
}