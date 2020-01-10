#! /bin/sh
PORT=8080
JAR_NAME=$1
pid=$(netstat -apn | grep $PORT | awk '{print $7}' | cut -d/ -f 1)
if [ -n "$pid" ];then
 echo "$pid号进程尝试终止"
 kill -9 $pid
 echo "$PID端口进程终止成功"
 echo "开始启动$PORT端口"
 nohup java -jar $JAR_NAME &
fi
if [ ! -n "$pid" ];then
 echo "开始启动$PORT端口"
 nohup java -jar $JAR_NAME &
fi