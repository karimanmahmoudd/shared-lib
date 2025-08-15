package org.iti;

def javaBuild(COMMAND_OPT){
    sh "mvn ${COMMAND_OPT}"
}
