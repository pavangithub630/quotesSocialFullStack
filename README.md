# quotesSocialFullStack

## api Documentation



## User Controller

#### API 1

##### Path: `user/add`
##### Method: `POST`
##### Description:
##### Creates a new user instance and saves it to the databse

## request 

```json


{
    "firstName":"Wallace",
    "lastName":"Riley",
    "userId": 0,
    "userName": "wallace.riley3@example.com",
    "email": "wallace.riley@example.com ",
    "dob": "1945-05-06",
    "password": "hectorhector",
    "country": "Australia"
}

```
## Response

```json
{
    "successMessage": "User Added Succesfully"
}
```

#### API 2

##### Path: `user/user-signin`
##### Method: `POST`
##### Description:
##### validate the user with email and password


## Request
```json
{
    "email": "wallace.riley@example.com",
    "password": "hectorhector"
}
```

## Response
```json
{
    "userId": 1,
    "firstName": "Wallace",
    "lastName": "Riley",
    "userName": "wallace.riley3@example.com",
    "email": "wallace.riley@example.com",
    "dob": "1945-05-06",
    "password": "hectorhector",
    "avatar": "https://robohash.org/wallace.riley3@example.com",
    "isActive": true,
    "posts": [],
    "likes": [],
    "active": true,
    "country": "Australia"
}
```


#### API 3

##### Path: `user/add-freind/{userId}/{friendUserId}`
##### Method: `PUT`
##### Description:
##### Add the friend with given user id into friends list


## Response
```json
{
        "successMessage": "Friend added to your network"
}
```

#### API 4

##### Path: `user/{userId}`
##### Method: `GET`
##### Description:
##### Finds the user with given userId


## Response
```json
{
    "userId": 25,
    "firstName": "Wallace",
    "lastName": "Riley",
    "userName": "wallace.riley2@example.com",
    "email": "wallace.riley@example.com ",
    "dob": "1945-05-06",
    "password": "hectorhector",
    "avatar": "https://robohash.org/wallace.riley2@example.com",
    "isActive": true,
    "posts": [],
    "likes": [],
    "active": true,
    "country": "Australia"
}
```
#### API 5

##### Path: `user/all`
##### Method: `GET`
##### Description:
##### Returns all the users in the database


## Response
```json
[{
    "userId": 1,
    "firstName": "Wallace",
    "lastName": "Riley",
    "userName": "wallace.riley2@example.com",
    "email": "wallace.riley@example.com ",
    "dob": "1945-05-06",
    "password": "hectorhector",
    "avatar": "https://robohash.org/wallace.riley2@example.com",
    "isActive": true,
    "posts": [],
    "likes": [],
    "active": true,
    "country": "Australia"
}

]
```


#### API 6

##### Path: `user/user/get-friends-suggestions/{userId}`
##### Method: `GET`
##### Description:
##### Returns all the users that are not in our friends network in list format
