FROM jboss/wildfly:10.1.0.Final

MAINTAINER Julien Leroy <julien.leroy@heig-vd.ch>
COPY data/standalone.xml /opt/jboss/wildfly/standalone/configuration/standalone.xml


RUN /opt/jboss/wildfly/bin/add-user.sh admin admin --silent

COPY deploy/ /opt/jboss/wildfly/standalone/deployments/

CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]
