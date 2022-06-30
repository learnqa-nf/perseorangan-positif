pipeline {
   agent any

   stages {
      stage('Test') {
			steps {
				git 'https://github.com/learnqa-nf/perseorangan-positif.git'
				bat "mvn clean test"
			}
			post{
				succces{
					junit '**/target/surefire-reports/TEST-*.xml'
					archiveArtifacts 'target/*.jar'
				}

			}
		}
	}
}