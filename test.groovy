node{
checkout scm
def c=load “${pwd()}/common.groovy”
c.mycommoncode()
println "Hello World!"
}
