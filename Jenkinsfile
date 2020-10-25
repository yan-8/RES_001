pipeline {
    agent any

    tools {
        maven "Maven 3.6.1"
        jdk "Java JDK 11.0.8"
    }

    stages {
        stage("MAVEN INITIALIZE") {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                '''
            }
        }

        stage("GETTING CODE") {
            steps {
                git branch: "master",
                credentialsId: "32cfa69f-f5e5-42cd-9f9c-4b2d4cb92e20",
                url: "https://github.com/yan-8/RES_001.git"
            }
        }

        stage("MAVEN BUILDING") {
            steps {
                sh "mvn compile"
            }
        }

        stage("API TESTING") {
            steps {
                sh "mvn test -DisRequestAndResponseLoggingEnable=${LOGGING} -Denvironment=${ENVIRONMENT} -Dlocale={JAVA_FAKER_LOCALE}"
            }
        }
    }
}