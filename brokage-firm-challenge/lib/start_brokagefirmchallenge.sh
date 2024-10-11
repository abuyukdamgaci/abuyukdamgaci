#!/bin/sh
########################################################################
# 0. Check if JAVA_HOME is set 

if [ x"$JAVA_HOME" = x ]
then
        echo "JAVA_HOME must be set...!!!"
        exit 1
fi
if [ ! -x $JAVA_HOME/bin/java ]
then
        echo "$JAVA_HOME/bin/java must exist and be executable...!!!"
        exit 1
fi

START_JAVA=$JAVA_HOME/bin/java

BROKAGEFIRMCHALLENGE_MAINCLASS=com.abuyukdamgaci.brokage.BrokageFirmChallengeApplication
export BROKAGEFIRMCHALLENGE_MAINCLASS

###############################################
echo Starting BROKAGEFIRMCHALLENGE
nohup $START_JAVA -DBROKAGEFIRMCHALLENGE -classpath ./brokage-firm-challenge-3.3.4 $BROKAGEFIRMCHALLENGE_MAINCLASS &
