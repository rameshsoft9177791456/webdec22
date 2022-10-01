pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Build World'
                build 'testjob'
            }
        }
    }
    post
    {
        always
        {
            emailext body: 'Hello', subject: 'Build', to: 'rameshsoft.selenium@gmail.com'
        }
    }
}
