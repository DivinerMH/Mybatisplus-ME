FROM harbor.ls.com/operation-gold/nginx:latest

MAINTAINER JinX

ENV web_name m02
#�޸�web_name
WORKDIR /usr/html

COPY ./dist ./${web_name}/

RUN ./${web_name}/index.html ./${web_name}/index.txt