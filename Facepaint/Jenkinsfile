pipeline {
    agent any

    environment{
        PORT_HOST: 8081
        PORT_CONTAINER: 8080
        IMAGE_TAG: "Facepaint"
        CONTAINER_NAME: "Facepaint"
        URL=credentials('URL')
        Username=credentials('Username')
        Password=credentials('Password')
    }

    stages {
        stage('package'){
            steps{
                sh 'mvn package -Dmaven.test.skip=true -Pprod'
            }
        }
        stage('remove previous image if exists'){
            steps{
                sh 'docker rmi -f ${IMAGE_TAG} || true'
            }
        }
        stage('create image'){
            steps{
                sh 'docker build -t ${IMAGE_TAG} -f Dockerfile .'
            }
        }
        stage('remove previous container if exists'){
            steps{
                sh 'docker stop ${CONTAINER_NAME} || true'
            }
        }
        stage('create container'){
            steps{
                sh 'docker run -e URL=${URL} -e Username=${Username} -e Password=${Password} -d --rm -p ${PORT_HOST}:${PORT_CONTAINER} --NAME ${CONTAINER_NAME} ${IMAGE_TAG}'
            }
        }
    }
}
