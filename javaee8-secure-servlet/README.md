Java EE 8 DatabaseLogin identity store
=====================================

#### Requires

A datasource bound at: java:/MySqlDS
   <datasources>
                <datasource jndi-name="java:/MySqlDS" pool-name="MySqlDS">
                    <connection-url>jdbc:mysql://172.17.0.2:3306/mysqlschema</connection-url>
                    <driver-class>com.mysql.jdbc.Driver</driver-class>
                    <driver>mysql-connector-java-5.1.24-bin.jar_com.mysql.jdbc.Driver_5_1</driver>
                    <security>
                        <user-name>jboss</user-name>
                        <password>jboss</password>
                    </security>
                    <validation>
                        <valid-connection-checker class-name="org.jboss.jca.adapters.jdbc.extensions.mysql.MySQLValidConnectionChecker"/>
                        <background-validation>true</background-validation>
                        <exception-sorter class-name="org.jboss.jca.adapters.jdbc.extensions.mysql.MySQLExceptionSorter"/>
                    </validation>
                </datasource>
                <drivers>
            </datasources>

Hint: I have used the following Docker to start the DB:

$ docker run -d --name mysql -p 3306:3306 -e MYSQL_USER=jboss -e MYSQL_PASSWORD=jboss -e MYSQL_DATABASE=mysqlschema -e MYSQL_ROOT_PASSWORD=secret mysql

###### On the database side 

CREATE TABLE USERS(login VARCHAR(64) PRIMARY KEY, password VARCHAR(64), role VARCHAR(64));
INSERT into USERS values('admin', 'admin',’Admin’);

###### Deploy
```shell
mvn clean install wildfly:deploy
```
###### Test
```shell
http://localhost:8080/javaee8-secure-servlet/test
```
