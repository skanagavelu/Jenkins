//evaluate(new File("common.groovy"))
def script = new GroovyScriptEngine( '.' ).with {
  loadScriptByName( 'common.groovy' )
} 
//metaClass.mixin script

pipeline {
    agent any
    stages {
         stage('Validate Fail fast') {
             failFast true
             parallel {
                  stage('stage A') {
                    steps {
                        echo 'stage A started'
                        sleep 5
//                        greet()
//                        script {
  //                         greet()
                           // error 'Test error'
    //                    }
                        echo "RESULT: ${currentBuild.result}"
                        echo 'stage A Ended' //will not execute because of above sh return
                    }
                }
                stage('stage B') {
                    steps {
                        echo 'stage B started'
                        sleep 10
                        echo 'stage B wakeup'
                        echo "RESULT: ${currentBuild.result}"
                        echo 'stage B Ended' //will not execute because of above stage fail
                    }
                }
                 stage('stage C') {
                    steps {
                        echo 'stage C started'
                        echo 'stage C Ended' //will not execute because of above stage fail
                    }
                }
             }
         }
         stage('final stage sequential') {
             steps {
//                 script {
  //                   echo "The complete run!"
    //             }
             }
         }
     }
}
