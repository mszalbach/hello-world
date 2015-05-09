SCRIPT_DIR=`dirname "$0"`
PROJECT_HOME=$(readlink -f "${SCRIPT_DIR}"/..)
HUDSON_WAR=hudson-2.2.1.war
HUDSON_PORT=8085
HUDSON_HOME=$HOME/.hudson

hudson_install() {
    cd $HOME
    wget -nc http://java.net/projects/hudson/downloads/download/war/$HUDSON_WAR
    rm -rf $HUDSON_HOME
    mkdir $HUDSON_HOME
    mkdir -p ~/hudsonNode
    cp -r $PROJECT_HOME/hudson/* $HOME/.hudson
}

hudson_start() {
    java -jar ~/$HUDSON_WAR --httpPort=$HUDSON_PORT
}


case $1 in
    start)
        hudson_start
    ;;
    install)
        hudson_install
        hudson_start
    ;;
    *)
    echo "Usage: start|install"
    exit 1
    ;;
esac



