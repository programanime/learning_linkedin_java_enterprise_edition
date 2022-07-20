cmd /C "mvn package"
cmd /C "A:\glassfish-4.1.1\glassfish4\glassfish\bin\asadmin.bat --user admin --port 4848 redeploy --name learning-cargo-tracker  target/learning-cargo-tracker.war"
REM A:\glassfish-4.1.1\glassfish4\glassfish\bin\asadmin.bat --user admin --port 4848 deploy target/learning-cargo-tracker.war