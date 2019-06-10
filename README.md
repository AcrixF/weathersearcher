# weathersearcher
Weather Searcher

This project was developed with Maven, Java 8 and Spring Boot 2.1.5, so to build the executable JAR for the project is needed to have 
installed maven 3.3 or higher, or install the Spring Boot CLI. Even though in the folder project, a copy for the JAR project has been located.

To build the project:
  1 - Download the projecr weathersearcher.
  2 - Navigate inside the project throught a Linux Terminal
  3 - If maven or Spring boot CLI  has been installed execute "mvn clean install".
  4 - After this a folder named target is created, inside this the weathersearcher-0.0.1-SNAPSHOT.jar has been located.
  5 - Copy this file to any other location and navigate to the path where the JAR was moved.
  6 - If Java 8 has been installed execute "java -jar weathersearcher-0.0.1-SNAPSHOT.jar"
  7 - This start up the projec, this will run in the port 8080.
  8 - Download the project  from https://github.com/AcrixF/weather_client.git to consume the services provides for the Weather Searcher
  9 - Open the index.html  with the some navegator, this file is inside the weather_client project. 
  10 - To stop the project, inside the terminal press "Ctrl + C".
  
If you cannot generate the JAR, you can copy the actual executable for this project, this is inside the project folder in the root of the project directory. 
  
Even though if you cannot run the weather client you can consume the services developed for the weather services througth 
the next URIs with a tool like CURL or POSTMAN:
  1 - For Searching the weather by the City´s name:
    http://localhost:8080/api/weather/cities/name/{city_name}
    Example: http://localhost:8080/api/weather/cities/name/London
  2 - For Searching the weather by the City´s  ID:
    http://localhost:8080/api/weather/cities/{city_name}
    Example: http://localhost:8080/api/weather/cities/264374
  3 - For Searching the weather by the City´s Zipcode:
    http://localhost:8080/api/weather/cities/zipcode/{zip_code}/countrycode/{country_code}
    Example: http://localhost:8080/api/weather/cities/zipcode/50780/countrycode/mx
  4 - For Searching the weather by the City´s coordinates 
    http://localhost:8080/api/weather/cities/coord/{lat}/{lon}
    Example: http://localhost:8080/api/weather/cities/coord/6.4254/79.994797
  
 
