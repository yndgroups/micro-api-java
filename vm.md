```
-vmargs
-Xms512m              （ Java能够分配的内存）
-Xmx512m              （ Java能够分配的最大内存）
-XX:PermSize=512M      （非堆内存初始值）
-XX:MaxPermSize=512M   （非堆内存最大值）
-XX:ReservedCodeCacheSize=64m  （eclipse缓存）


这个是我试过可行的参数

-vmargs
-Xmx900m
-XX:MaxPermSize=500m
-XX:ReservedCodeCacheSize=64m
```
# shell 启动多个jar
### 命令
``` 
启动：./boot.sh start
停止：./boot.sh stop
重启：./boot.sh restart
```

### -bash: ./java.sh: 权限不够
``` 
chmod +7 java.sh
```

### 脚本
```
#!/bin/sh
export GATEWAY=agile-gateway.jar
export COMMON=agile-common-provider.jar
export FILE=agile-file-provider.jar

export GATEWAY_port=8100
export COMMON_port=8200
export FILE_port=8300

 
case "$1" in
 
start)
        ## 启动gateway
        echo ">>>>>>>>>>>>>>> 开始启动 $GATEWAY >>>>>>>>>>>>>>>"
        nohup java -jar $GATEWAY > ./$GATEWAY.log 2>&1 &
        ## tail -f ./$GATEWAY.log
        GATEWAY_pid=`lsof -i:$GATEWAY_port|grep "LISTEN"|awk '{print $2}'`
        until [ -n "$GATEWAY_pid" ]
            do
              GATEWAY_pid=`lsof -i:$GATEWAY_port|grep "LISTEN"|awk '{print $2}'`
            done
        echo ">>>>>>>>>>>>>>> $GATEWAY pid is $GATEWAY_pid"
        echo ">>>>>>>>>>>>>>> $GATEWAY 启动成功 >>>>>>>>>>>>>>>"
        echo ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"

        ## 启动公共服务
        echo ">>>>>>>>>>>>>>> $COMMON 开始启动 >>>>>>>>>>>>>>>"
        nohup java -jar $COMMON >/dev/null 2>&1 &
        COMMON_pid=`lsof -i:$COMMON_port|grep "LISTEN"|awk '{print $2}'`
        until [ -n "$COMMON_pid" ]
            do
              COMMON_pid=`lsof -i:$COMMON_port|grep "LISTEN"|awk '{print $2}'`
            done
        echo ">>>>>>>>>>>>>>> $COMMON pid is $COMMON_pid"
        echo ">>>>>>>>>>>>>>> $COMMON 启动成功 >>>>>>>>>>>>>>>"
        echo ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"
 
        ## 启动config
        echo ">>>>>>>>>>>>>>> 开始启动 $FILE >>>>>>>>>>>>>>>"
        nohup java -jar $FILE >/dev/null 2>&1 &
        FILE_pid=`lsof -i:$FILE_port|grep "LISTEN"|awk '{print $2}'`
        until [ -n "$FILE_pid" ]
            do
              FILE_pid=`lsof -i:$FILE_port|grep "LISTEN"|awk '{print $2}'`
            done
        echo ">>>>>>>>>>>>>>> $FILE pid is $FILE_pid"
        echo ">>>>>>>>>>>>>>> $FILE 启动成功 >>>>>>>>>>>>>>>"
        echo ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"
        
        echo ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"
        echo ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"
        echo ">>>>>>>>>>>>>>> start all success >>>>>>>>>>>>>>>"
        echo ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"
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
        echo ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"
        echo ">>>>>>>>>>>>>>> stop all success >>>>>>>>>>>>>>>"
        echo ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"
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
```