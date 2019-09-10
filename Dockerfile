FROM ycr.yonyoucloud.com/base/maven-ynpm-debian:latest
MAINTAINER licza licza@yonyou.com
ADD ./ /app/
WORKDIR /app/
RUN cd eyetouch-seentao-fe/ \
    && ynpm install \
    && npm run build \
    && cd ../eyetouch-seentao-be \
    && /usr/local/maven/bin/mvn clean install -U -Dmaven.test.skip=true


FROM ycr.yonyoucloud.com/base/tomcat:8-jdk8-alpine
WORKDIR /app
RUN  mkdir -p /usr/local/tomcat/webapps/eyetouch-seentao-be

COPY --from=0 /app/eyetouch-seentao-fe/ucf-publish/eyetouch-seentao-fe /usr/local/tomcat/webapps/eyetouch-seentao-fe
COPY --from=0 /app/eyetouch-seentao-be/iuap-bootstrap/target/eyetouch-seentao-be.war /usr/local/tomcat/webapps/eyetouch-seentao-be.war
RUN unzip /usr/local/tomcat/webapps/eyetouch-seentao-be.war -d /usr/local/tomcat/webapps/eyetouch-seentao-be
RUN rm -f /usr/local/tomcat/webapps/eyetouch-seentao-be.war
WORKDIR /usr/local/tomcat
EXPOSE 8080
CMD ["catalina.sh", "run"]
