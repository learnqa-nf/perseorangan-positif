pipeline{
agent{
node{
label 'master'
}
}
options{
timestamps()
}

stages{
stage("Test"){
steps{
checkout scm
script{
bat (/mvn clean test/)

}
step ([$ : '', reportFilenamePattern : '**/testng-results.xml'])
}
}
}

}
