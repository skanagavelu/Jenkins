node{
//checkout scm
def rootDir = pwd()
def c=load “${rootDir}@script/common.groovy”
c.mycommoncode()
println "Hello World!"
}
