cmd /C "A:\glassfish-4.1.1\glassfish4\glassfish\bin\asadmin.bat --user admin --port 4848 undeploy cargo-tracker"
cmd /C "mvn clean package"
cmd /C "A:\glassfish-4.1.1\glassfish4\glassfish\bin\asadmin.bat --user admin --port 4848 deploy target/cargo-tracker.war"
@REM cmd /C "A:\glassfish-4.1.1\glassfish4\glassfish\bin\asadmin.bat --user admin --port 4848 redeploy --name cargo-tracker  target/cargo-tracker.war"