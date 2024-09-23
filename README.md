# in progress 
<hr>
# spring-boot-hibernate-jpa-bank-management-systems

### Technical Details
In this project, we are going to use below set of versions for demonstrations.

    Spring Boot - 3.3.3
    Spring - 6.1.12
    Lombok - 1.18.34

### Building

The example can be built with
```shell
mvn clean install
```

### Running the example in your local
```shell
mvn clean spring-boot:run
```
# Customer form
## Customer POST Data
```shell
curl --location 'http://localhost:8084/customerManagement/customer' \
--header 'Content-Type: application/json' \
--data-raw '{
     "customerId":1,
     "name":"Nirav",
    "mobileNo":"89345644",
    "address":"Pune",
     "emailId":"Nirav@gmail.com",
    "aadhaarNo":"123456789"
}'
```
## Customer GET Data
```shell

curl --location --request GET 'http://localhost:8084/customerManagement/customers' \
--header 'Content-Type: application/json' \
--data-raw '{
     "customerId":1,
     "name":"Nirav",
    "mobileNo":"89345644",
    "address":"Pune",
     "emailId":"Nirav@gmail.com",
    "aadhaarNo":"123456789"
}'
```

