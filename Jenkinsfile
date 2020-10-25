node {
    tools {
        maven 'Maven 3.6.1'
    }

    stage("GETTING CODE") {
        git branch: "master",
        credentialsId: "32cfa69f-f5e5-42cd-9f9c-4b2d4cb92e20",
        url: "https://github.com/yan-8/RES_001.git"
    }

    stage("BUILDING") {
        sh 'mvn compile'
    }

    stage("API TESTING") {
        sh 'mvn test'
    }
}