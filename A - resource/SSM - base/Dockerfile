FROM anapsix/alpine-java:8_server-jre_unlimited
# jar包名称 需要指定 
ENV APP_NAME fitmgr-quota-biz.jar

MAINTAINER ranmufei@gmail.com

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

RUN mkdir -p /app

WORKDIR /app

EXPOSE 4000 

ADD ./fitmgr-quota-biz/target/*.jar ./

CMD sleep 5;java -Xms128m -Xmx256m -Djava.security.egd=file:/dev/./urandom -jar "${APP_NAME}"
