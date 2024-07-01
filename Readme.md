
# Unisinos-Software_Engineering-Analysis

To start the application and bank, please follow the following steps:

## Starting Project

*If this is your first time running the project, I recommend that you opt for one of the first one method.*

### Using "init.sh" script

```sh
    $ ./init.sh
```
Just run the script with the provided command and it will automatically carry out the entire process, from downloading the dependencies to starting the project.

### "Manual" Commands

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



