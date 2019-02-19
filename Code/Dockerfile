FROM ubuntu:14.04

MAINTAINER Manisha Gupta <mg48626n@pace.edu>

ENV TOMCAT_VERSION 8.0.47

# Set locales
RUN locale-gen en_GB.UTF-8
ENV LANG en_GB.UTF-8
ENV LC_CTYPE en_GB.UTF-8

# Fix sh
RUN rm /bin/sh && ln -s /bin/bash /bin/sh

# Install dependencies
RUN apt-get update && \
apt-get install -y git build-essential curl wget software-properties-common

# Install JDK 8
RUN \
echo oracle-java8-installer shared/accepted-oracle-license-v1-1 select true | debconf-set-selections && \
add-apt-repository -y ppa:webupd8team/java && \
apt-get update && \
apt-get install -y oracle-java8-installer wget unzip tar && \
rm -rf /var/lib/apt/lists/* && \
rm -rf /var/cache/oracle-jdk8-installer

# Define commonly used JAVA_HOME variable
ENV JAVA_HOME /usr/lib/jvm/java-8-oracle

# Get Tomcat
RUN wget --quiet --no-cookies http://apache.rediris.es/tomcat/tomcat-8/v8.0.47/bin/apache-tomcat-8.0.47.tar.gz -O /tmp/tomcat.tgz && tar xzvf /tmp/tomcat.tgz -C /opt && mv /opt/apache-tomcat-8.0.47 /opt/tomcat && rm /tmp/tomcat.tgz

RUN rm -rf /opt/tomcat/webapps/examples
RUN rm -rf /opt/tomcat/webapps/docs
RUN rm -rf /opt/tomcat/webapps/ROOT


# Add admin/admin user

COPY tomcat-users.xml /opt/tomcat/conf/tomcat-users.xml

ENV CATALINA_HOME /opt/tomcat
ENV PATH $PATH:/opt/tomcat/bin

EXPOSE 8080
EXPOSE 8009
VOLUME "/opt/tomcat/webapps"
WORKDIR /opt/tomcat

# Launch Tomcat
CMD ["/opt/tomcat/bin/catalina.sh", "run"]
