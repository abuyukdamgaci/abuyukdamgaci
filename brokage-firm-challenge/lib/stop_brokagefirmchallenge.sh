#!/bin/sh
USER=`whoami`
PID=`ps -fu $USER|  grep java | grep BROKAGEFIRMCHALLENGE | grep -v grep | awk '{ print $2 }'`

if [ -n "$PID" ]
then
	kill   $PID
else
	echo BROKAGEFIRMCHALLENGE is not running.
fi

