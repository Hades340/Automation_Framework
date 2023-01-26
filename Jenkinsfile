pipeline {
    agent any
   tools { 
      maven 'M2_HOME'
      jdk 'JDK13'
    }
    stages {
        stage('run test automation') {
            steps {
                 // Run Maven on a Unix agent.
             	sh "mvn clean test -DtestngFile=testSuite.xml"
                 // To run Maven on a Windows agent, use
               //bat "mvn clean test -DtestngFile=testSuite.xml"
            }
        }
    }
}
