pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Build World'
                build 'mavenjob1'
            }
        }
        stage('Test') {
            steps {
                echo 'Test World'
                build 'mavenjob2'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploy World'
                build 'mavenjob3'
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
