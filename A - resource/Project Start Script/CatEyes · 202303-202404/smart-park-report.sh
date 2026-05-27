#!/bin/bash

APP_NAME=``

command=$1

function init()
{
	APP_NAME=`find . -name "smart-park-report-*.jar"`
	APP_NAME=${APP_NAME:2}
}

function start()
{
	init
	
	rm -f app_pid

	nohup java -Xms1g -Xmx1g -Xss256k -XX:PermSize=64m -XX:MaxPermSize=512m -XX:NewRatio=4 -XX:SurvivorRatio=8 -verbose:gc -XX:+PrintGCDateStamps -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -XX:-HeapDumpOnOutOfMemoryError -Xloggc:gc.log -jar ${APP_NAME} > /dev/null 2>&1 &

	echo $! > app_pid
  
	echo "APP_NAME="$APP_NAME

	check
}

function stop()
{
	init
	
	app_pid=`ps -ef|grep $APP_NAME|grep -v grep|grep -v kill|awk '{print $2}'`
	if [ ${app_pid} ]; then
		echo 'Stop Process...'
		kill -15 $app_pid
	fi

	sleep 5
	app_pid=`ps -ef|grep $APP_NAME|grep -v grep|grep -v kill|awk '{print $2}'`

	if [ ${app_pid} ]; then
		echo 'Kill Process!'
		kill -9 $app_pid
		rm -f app_pid
	else
		rm -f app_pid
		echo 'Stop Success!'
    fi
}

function check()
{
	init
	
	app_pid=`ps -ef|grep $APP_NAME|grep -v grep|grep -v kill|awk '{print $2}'`
	if [ ${app_pid} ]; then
		echo 'App is running.'
		echo "Process="`cat app_pid`
	else
		echo 'App is NOT running.'
	fi
}

function forcekill()
{
	init
	
	app_pid=`ps -ef|grep $APP_NAME|grep -v grep|grep -v kill|awk '{print $2}'`

	if [ ${app_pid} ]; then
		echo 'Kill Process!'
		kill -9 $app_pid
		rm -f app_pid
	fi
}

if [ "${command}" ==  "start" ]; then
	start
elif [ "${command}" ==  "stop" ]; then
	stop
elif [ "${command}" ==  "check" ]; then
	check
elif [ "${command}" ==  "kill" ]; then
	forcekill
elif [ "${command}" ==  "restart" ]; then
	stop
  start
else
  echo "Restart..."
 	stop
  start
fi