**Docker Commands**
* Command to run postrges db
  ```shell
  docker run --name <container-name> -e POSTGRES_DB=<db-name> -e POSTGRES_USER=<db-username> -e POSTGRES_PASSWORD=<db-password> postgres
  e.g. : docker run --name postgres -e POSTGRES_DB=pgdb -e POSTGRES_USER=pgoel -e POSTGRES_PASSWORD=89910331 postgres
  ```

* Command to open postgres server and its terminal
    ```shell
      docker exec -it <container-id> bash
      psql -U <db-username> -d <db-name>
    ```

* Command to run redis
  ```shell
    docker run redis
  ```

* Command to open redis server and its terminal
  ```shell
      docker exec -it <container-id> bash
      redis-cli
  ```
  
  
* https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html
