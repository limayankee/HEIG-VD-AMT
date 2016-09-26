FROM jboss/wildfly:10.1.0.Final

MAINTAINER Julien Leroy <julien.leroy@heig-vd.ch>

RUN /opt/jboss/wildfly/bin/add-user.sh admin admin --silent

COPY app.war /opt/jboss/wildfly/standalone/deployments/app.war

CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]
