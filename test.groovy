node{
checkout scm
  // To know files are checked out or not
    sh '''
        ls -lhrt
    '''

def rootDir = pwd()
    println("Current Directory: " + rootDir)


def c = load "${rootDir}/common.groovy"
c.mycommoncode()
println "Hello World!"
}
