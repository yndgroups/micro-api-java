#!/bin/sh
export GATEWAY=agile-gateway-1.0.1.jar
export COMMON=agile-common-provider-1.0.1.jar
export FILE=agile-file-provider-1.0.1.jar

export GATEWAY_PORT=8100
export COMMON_PORT=8200
export FILE_PORT=8300

 
case "$1" in
 
start)
        ## 启动gateway
        echo ">>>>>>>>>>>>>>> 开始启动 $GATEWAY >>>>>>>>>>>>>>>"
        nohup java -jar -Xmx512M -Xms256M $GATEWAY --spring.profiles.active=dev > ./$GATEWAY.log 2>&1 &
        ## tail -f ./$GATEWAY.log
        GATEWAY_pid=`lsof -i:$GATEWAY_PORT|grep "LISTEN"|awk '{print $2}'`
        until [ -n "$GATEWAY_pid" ]
            do
              GATEWAY_pid=`lsof -i:$GATEWAY_PORT|grep "LISTEN"|awk '{print $2}'`
            done
        echo ">>>>>>>>>>>>>>> $GATEWAY pid is $GATEWAY_pid"
        echo ">>>>>>>>>>>>>>> $GATEWAY 启动成功 >>>>>>>>>>>>>>>"
         echo "***********************************************"

        ## 启动公共服务
        echo ">>>>>>>>>>>>>>> $COMMON 开始启动 >>>>>>>>>>>>>>>"
        nohup java -jar -Xmx512M -Xms256M  $COMMON --spring.profiles.active=dev > ./$COMMON.log 2>&1 &
        COMMON_pid=`lsof -i:$COMMON_PORT|grep "LISTEN"|awk '{print $2}'`
        until [ -n "$COMMON_pid" ]
            do
              COMMON_pid=`lsof -i:$COMMON_PORT|grep "LISTEN"|awk '{print $2}'`
            done
        echo ">>>>>>>>>>>>>>> $COMMON pid is $COMMON_pid"
        echo ">>>>>>>>>>>>>>> $COMMON 启动成功 >>>>>>>>>>>>>>>"
        echo "***********************************************"
 
        ## 启动config
        echo ">>>>>>>>>>>>>>> 开始启动 $FILE >>>>>>>>>>>>>>>"
        nohup java -jar -Xmx512M -Xms256M  $FILE --spring.profiles.active=dev > ./$FILE.log 2>&1 &
        FILE_pid=`lsof -i:$FILE_PORT|grep "LISTEN"|awk '{print $2}'`
        until [ -n "$FILE_pid" ]
            do
              FILE_pid=`lsof -i:$FILE_PORT|grep "LISTEN"|awk '{print $2}'`
            done
        echo ">>>>>>>>>>>>>>> $FILE pid is $FILE_pid"
        echo ">>>>>>>>>>>>>>> $FILE 启动成功 >>>>>>>>>>>>>>>"
         echo "***********************************************"

        echo ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"
        echo ">>>>>>>>>>>>>>> start all success >>>>>>>>>>>>>>>"
        echo ">>>>>>>>>>>>>>> start all success >>>>>>>>>>>>>>>"
        echo ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"
        ;;
 
 stop)
        P_ID=`ps -ef | grep -w $COMMON | grep -v "grep" | awk '{print $2}'`
        if [ "$P_ID" == "" ]; then
            echo ">>>>>>>>>>>>>>> $COMMON process not exists or stop success"
        else
            kill -9 $P_ID
            echo "COMMON killed success"
        fi
		P_ID=`ps -ef | grep -w $FILE | grep -v "grep" | awk '{print $2}'`
        if [ "$P_ID" == "" ]; then
            echo ">>>>>>>>>>>>>>> $FILE process not exists or stop success"
        else
            kill -9 $P_ID
            echo "FILE killed success"
        fi
		 P_ID=`ps -ef | grep -w $GATEWAY | grep -v "grep" | awk '{print $2}'`
        if [ "$P_ID" == "" ]; then
            echo ">>>>>>>>>>>>>>> $GATEWAY process not exists or stop success"
        else
            kill -9 $P_ID
            echo "GATEWAY killed success"
        fi
 
        echo ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"
        echo ">>>>>>>>>>>>>>> stop all success >>>>>>>>>>>>>>>"
        echo ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"
        ;;
 
restart)
        $0 stop
        sleep 2
        $0 start
        echo ">>>>>>>>>>>>>>> restart success  >>>>>>>>>>>>>>>"
        ;;   
esac	
exit 0

# 内存限制 -Xmx 表示JVM最大的内存 -Xms 表示JVM初始内存