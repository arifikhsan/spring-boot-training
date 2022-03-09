# Spring Boot Staff Assignment 

Name: Arif Ikhsanudin

## 1. I want to be able to add new staff ✅

![img.png](img.png)

## 2. I want to be able to add staff’s carrot balance ✅

initial balance is 0

![img_1.png](img_1.png)

add 10 balance

![img_2.png](img_2.png)

balance increased by 10 ✅

![img_3.png](img_3.png)

## 3. I want to be able to do transaction with my carrot ✅

### create staff
![img_4.png](img_4.png)

### create product

price = 949  
stock = 925

![img_5.png](img_5.png)

### add balance to staff (10000)
![img_7.png](img_7.png)

### buy product 

quantity = 2  
returned product entity

![img_6.png](img_6.png)

### staff balance
price = 949  
quantity = 2  
total price = 1898  
staff balance = 10000  
remaining staff balance (10000 - 1898) = 8102 ✅

![img_8.png](img_8.png)

### product sold

initial stock = 925  
bought stock = 2  
remaining stock (925 - 2) = 923 ✅

![img_9.png](img_9.png)

## 4. Record the transaction history in db ✅

same step from number 3

![img_10.png](img_10.png)

returning a response: 

```json
[
    {
        "id": 1,
        "staff": {
            "id": 1,
            "name": "Ellis Barrows PhD",
            "balance": 8616,
            "basket": {
                "id": 1,
                "amount": 0
            }
        },
        "product": {
            "id": 1,
            "productName": "Generic Fresh Car",
            "price": 692,
            "stock": 675
        },
        "quantity": 2,
        "createdAt": "2022-03-09T16:11:57.650905"
    }
]
```