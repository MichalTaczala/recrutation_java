# recrutation_java

# Requirements:
- Tests are not be working - find out what’s wrong and fix the source code accordingly

Files Receipt.java, ReceiptGenerator.java, TenPercentDiscount.java has been changed, so now the tests doesn't fail.

- Our product owner needs a new type of promotion - a 15% discount on the total price,
which should be applied only if at least 3-grain products are in the basket. It applies before
the 10% discount that is implemented

New file is created: FifteenPercentDiscount.java which works similarily to TenPercentDiscount.java.

- Using framework of your choice (e.g. Spring Boot) implement a Rest endpoint, that will
accept the Basket object and return the Receipt with the calculated price

Spring boot controller and service are created for Receipt.
<img width="615" alt="Zrzut ekranu 2022-03-10 o 14 00 04" src="https://user-images.githubusercontent.com/77026945/157716045-b4bd3851-42eb-43ca-9836-5e5a58e4fc47.png">
<img width="1112" alt="Zrzut ekranu 2022-03-10 o 14 00 31" src="https://user-images.githubusercontent.com/77026945/157716034-6453766b-6da4-4bb4-a49a-df447c0e7e5e.png">



- Remember about tests for the implemented use cases

For every written classes and functions, there are unit tests written.
