
# Unisinos-Software_Engineering-Analysis

To start the application and bank, please follow the following steps:

## Getting Started

### Starting with docker

NOTE: this is for development only.

- Clone this repository and open a terminal inside the root of the repository.
- Use `docker compose up -d` to start the server for the first time.
- Update the program by restarting the project with `docker compose restart`. This will rebuild the application but wont delete data from the database
- To delete the project use `docker compose down` followed by `docker volume rm unisinos-software_engineering-analysis_postgres-data` to remove the database's persistant volume.

### Starting Project

*If this is your first time running the project, I recommend that you opt for one of the first one method.*

#### Using "init.sh" script

```sh
    $ ./init.sh
```
Just run the script with the provided command and it will automatically carry out the entire process, from downloading the dependencies to starting the project.

#### "Manual" Commands

*For this start method you need to have java 17 and docker-compose installed on your machine.*

Generating the .jar of the application.

```sh
    $ mvn clean package
```
Uploading the postgres and api container.
```sh
    $ docker-compose up --build
```

## After the Start

Now that everything is runnig, the app should be reachable from port 8080 and you can use the Postman collections provided in the `postman` folder.



