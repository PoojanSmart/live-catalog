FROM liquibase/liquibase:4.33-alpine

WORKDIR /liquibase/

COPY liquibase.properties /liquibase/
COPY db /liquibase/db/

ENTRYPOINT [ "sh", "-c", "liquibase --defaultsFile=liquibase.properties update" ]