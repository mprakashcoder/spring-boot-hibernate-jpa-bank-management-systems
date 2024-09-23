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
# customer GET Screen 

<image src="https://github.com/user-attachments/assets/1ea8773f-2a29-4c9b-9665-07e554584dbe" width="750" height="350">


### Only create Schemas bankmanagementsystemsjpa
```shell
 create ankmanagementsystemsjpa;
SELECT * FROM bankmanagementsystemsjpa.customer;

```
## customer MySql Database Screen Shot

<image src="https://github.com/user-attachments/assets/d11be352-a8a9-4feb-996b-843a938915c1" width="750" height="350">

<hr>

# Card form
## Card POST Data
```shell
curl --location 'http://localhost:8084/cardManagement/card' \
--header 'Accept: application/json' \
--header 'Content-Type: application/json' \
--data '{
    
        "cardId" : 1,
         "cardNo":123,
        "accountNo":1001,
          "accountHolderName":"Purvamali",
         "cvv":452,
         "cardType":"Debit"
}'
```

# card Post  Screen Shot

<image src="https://github.com/user-attachments/assets/d442563b-5be2-4b4a-b69d-f8a28d57eee0" width="750" height="350">

<hr>

## Card GET Data
```shell


curl --location --request GET 'http://localhost:8084/cardManagement/cards' \
--header 'Accept: application/json' \
--header 'Content-Type: application/json' \
--data '{
    
        "cardId" : 1,
         "cardNo":123,
        "accountNo":1001,
          "accountHolderName":"Purvamali",
         "cvv":452,
         "cardType":"Debit"
}'
```

# card GET  Screen Shot

<image src="https://github.com/user-attachments/assets/0b4d3853-be78-47a5-bfe1-75a2115955a9" width="750" height="350">

## card MySql Database Screen Shot

<image src="https://github.com/user-attachments/assets/d6a30a25-eee4-4fbf-859f-872d1672cadb" width="750" height="350">

<hr>

# Account form
## Account POST Data
```shell
curl --location 'http://localhost:8084/accountManagement/account' \
--header 'Content-Type: application/json' \
--data '{

    "accountNumber":1001,
      "accountHolderName":"purvamali",
        "balance": 50000,
        "customerId":1
}'
```

# Account Post  Screen Shot

<image src="https://github.com/user-attachments/assets/8a07b539-fe0e-49a1-9ef1-804c2fd59594" width="750" height="350">

##  Account GET Data
```shell
curl --location --request GET 'http://localhost:8084/accountManagement/accounts' \
--header 'Content-Type: application/json' \
--data '{

    "accountNumber":1001,
      "accountHolderName":"purvamali",
        "balance": 50000,
        "customerId":1
}'

```

# Account GET  Screen Shot

<image src="https://github.com/user-attachments/assets/d44955bd-952d-4d6d-8733-511b141707de" width="750" height="350">



