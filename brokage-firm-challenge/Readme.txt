There is a basic auhentication for all APIs, username and password as follows :
username : admin
password : admin

Create Order: Create a new order for a given customer, asset, side, size and price
Side can be BUY or SELL. Customer is a unique id for a customer. Asset is the name of the stock customer wants to buy. Size represents how many shares customer wants to buy. Price represents how much customer wants to pay for per share.
:
http://localhost:9090/order
[{
    "id": "66",
    "customer": "666",
    "asset": "asset6",
    "side": "BUY",
    "size": "1",
    "price": "66",
    "status": "CANCELED",
    "createDate": "2024-10-08T21:00:00.000+00:00"
},
{
    "id": "77",
    "customer": "777",
    "asset": "asset7",
    "side": "BUY",
    "size": "1",
    "price": "77",
    "status": "PENDING",
    "createDate": "2024-10-08T21:00:00.000+00:00"
}
]
List Orders: List orders for a given customer and date range. (you can add more filter if you want)
:http://localhost:9090/order?parameterList=444,12-10-2023
-
Delete Order: Cancel a pending order. Other status orders cannot be deleted
:http://localhost:9090/order/6

Deposit Money: Deposit TRY for a given customer and amount
:http://localhost:9090/asset?parameterList=111,100

Withdraw Money: Withdraw TRY for a given customer amount and IBAN
:http://localhost:9090/asset/withdrawMoney?parameterList=111,100

List Assets: List all assets for a given customer (you can add filters if you want)
:http://localhost:9090/asset