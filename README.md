<!-- ABOUT THE PROJECT -->
## About The Project

Developed a log ingestor system that can efficiently handle vast volumes of log data, and offer a simple interface for querying this data using full-text search or specific field filters.




### Built With

* [Spring Boot](Spring-url)




<!-- GETTING STARTED -->
## Getting Started

How to run the code Locally:
* Clone this repository and open it in your preferred IDE (e.g.,VS Code, IntelliJ)(logger)



### Installation

1. Clone the repo
   ```sh
   git clone https://github.com/dyte-submissions/november-2023-hiring-the0ss.git
   ```
2. Open /logger folder in your desired Code Editor(Preferred VS Code with Extensions and IntelliJ)

3. Create a database connection using the correct names respectively in application properties file. Located in src/main/resource.(Only change the DB name(jdbc:mysql://localhost:3306/{DB_NAME}) and username password).

4. Start or Run the application.




## Working Of Project

The project is divided into two parts - Logger and Query search.

### Ingest

```
localhost:3000/ingest
```
(POST Mapping)
This endpoint takes JSON data as input and stores it in the database. It also logs all incoming requests.

#### Request Body

```
{
	"level": "error",
	"message": "Failed to connect to DB",
    "resourceId": "server-1234",
	"timestamp": "2023-09-15T08:00:00Z",
	"traceId": "abc-xyz-123",
    "spanId": "span-456",
    "commit": "5e5342f",
    "metadata": {
        "parentResourceId": "server-0987"
    }
}
```

### Search

(GET Mapping)
A Web UI is developed to search on specific filters. Can be queried on the application.

## Requirements

### Log Ingestor:

- Develop a mechanism to ingest logs in the provided format.
- Ensure scalability to handle high volumes of logs efficiently.
- Mitigate potential bottlenecks such as I/O operations, database write speeds, etc.
- Make sure that the logs are ingested via an HTTP server, which runs on port `3000` by default.

### Query Interface:

- Offer a user interface (Web UI or CLI) for full-text search across logs.
- Include filters based on:
    - level
    - message
    - resourceId
    - timestamp
    - traceId
    - spanId
    - commit
    - metadata.parentResourceId
- Aim for efficient and quick search results.

<!-- CONTACT -->
## Contact

Your Name - Yuvraj Sooraj Chauhan

Github Link: [https://github.com/the0ss](https://github.com/the0ss)


[Spring-url]: https://spring.io/projects/spring-boot
