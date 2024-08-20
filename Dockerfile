FROM openjdk:11-jre-slim
MAINTAINER "ynd_common_provider"
LABEL maintainer = "Yang Daiong <826422592@qq.com>"
COPY --from=builder /home/itezu/work/itezu/api/agile-parent/agile-common-provider/build/libs/agile-common-provider-1.0.1.jar /app.jar
RUN ls -al
ENV JAVA_OPTS=""
ENV PARAMS=""
ENTRYPOINT [ "sh", "-c","java $JAVA_OPTS -jar /app.jar $PARAMS", "-Xms128m", "-Xmx128m", "-XX:MetaspaceSize=64m", "-XX:MaxMetaspaceSize=128m" ]