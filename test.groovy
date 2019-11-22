def common

pipeline {
    agent any
    stages {
        stage('final stage sequential') {
            steps {
              script {
                  checkout scm
                  def rootDir = pwd()
                  println("Current Directory: " + rootDir)
                  common = load "${rootDir}/common.groovy"
                  common.mycommoncode()
                  println "Hello World!"
              }
            }
        }

        stage('second stage sequential') {
            steps {
              script {
                  common.mycommoncode()
                  println "Second Hello World!"
              }
            }
        }
     }
}
