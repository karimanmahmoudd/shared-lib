package org.iti;

def archive() {
    archiveArtifacts artifacts: '**/*.jar', followSymlinks: false
}
