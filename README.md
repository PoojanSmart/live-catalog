# Live Catalog
Demonstrates cataloging and indexing of products using microservices architecture


## Liquibase migration
1. Build image: `sudo docker build -t catalogdb:1.0 .`
2. Create and run container: 
    `sudo docker run --rm --network=infra_default -e LIQUIBASE_COMMAND_URL=jdbc:postgresql://postgres:5432/catalogdb -e LIQUIBASE_COMMAND_USERNAME=livecatalog -e LIQUIBASE_COMMAND_PASSWORD=livecatalog catalogdb:1.0`