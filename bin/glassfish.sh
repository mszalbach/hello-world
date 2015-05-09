SCRIPT_DIR=`dirname "$0"`
PROJECT_HOME=$(readlink -f "${SCRIPT_DIR}"/..)
GLASSFISH_VERSION=3.1.2.2
GLASSFISH_HOME=~/glassfishv${GLASSFISH_VERSION}

glassfish_install() {
    cd /tmp
    wget -nc http://download.java.net/glassfish/${GLASSFISH_VERSION}/release/glassfish-${GLASSFISH_VERSION}.zip
    rm -rf $GLASSFISH_HOME
    unzip -q glassfish-${GLASSFISH_VERSION}.zip
    mv glassfish3 $GLASSFISH_HOME

}

glassfish_start() {
    $GLASSFISH_HOME/bin/asadmin start-domain
}


glassfish_stop() {
    $GLASSFISH_HOME/bin/asadmin stop-domain
}

case $1 in
    start)
        glassfish_start
    ;;
    install)
        glassfish_install
        glassfish_start
    ;;
     stop)
        glassfish_stop
        ;;
    *)
    echo "Usage: start|install"
    exit 1
    ;;
esac



