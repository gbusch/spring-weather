# Simple Weather-Service with Spring

* Clone the repo
* Execute ./start.sh.
* The images necessary to build and run the application, as well as the databases are download

* Ideally you should have IntelliJ installed
* Lombok Plugin is also useful
* If not done automatically, "reimport all Maven projects" (click on Maven tab on the right side and in the opening menu, click on the two arrows).

* Place your openweathermap.org API key into src/main/resources/application.properties

## Status Quo
Available interfaces (examples):
* curl "localhost:8080/weather?lat=50.92&lon=6.92"
* curl -X POST "localhost:8080/contract?name=gerold&price=0.2"
* curl localhost:8080/contracts
* curl localhost:8080/contract/{existing contract ID}