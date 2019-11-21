pipeline {
    agent any
    stages {
        stage('final stage sequential') {
            steps {
              script {
                  checkout scm
                  def rootDir = pwd()
                  println("Current Directory: " + rootDir)
                  def c = load "${rootDir}/common.groovy"
                  c.mycommoncode()
                  println "Hello World!"
              }
            }
        }
     }
}
