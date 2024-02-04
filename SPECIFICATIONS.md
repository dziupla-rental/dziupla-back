# Data Interface Specifications
==All the requests will be sent with POST==
## Endpoints (Servlets)
### Login
The login will be implemented according to the instructions:
- [Backend](https://www.bezkoder.com/spring-boot-login-example-mysql/)
- [Frontend](https://www.bezkoder.com/angular-17-jwt-auth/)
- [Fullstack](https://www.bezkoder.com/angular-17-spring-boot-jwt-auth/)

### Roles
public enum ERole {

    ROLE_USER, (user)
    
    ROLE_MODERATOR,
    
    ROLE_ADMIN, (admin)
    
    ROLE_EMPLOYEE, (emp)
    
    ROLE_EMPLOYEE_HR, (empHR)
    
    ROLE_EMPLOYEE_MECHANIC (empMech)
    
}

if you want to create new user provide names in brackets (in JSON)

### Employees
###### Package into JSON
`get api/employee`
- A list of all Employees and their respective IDs
```json
{
[
   {
    "id": 4,
    "office": {
        "id": 10,
        "location": "Warszawa"
    },
    "officeId": null,
    "salary": 0.0,
    "shiftStart": "08:00:00",
    "shiftEnd": "16:00:00",
    "email": "dom47@gmail.com",
    "name": "Domi",
    "lastName": "wasil",
    "role": "ROLE_EMPLOYEE_HR"
}
]
}
```

### Employee
###### Package into JSON
`get api/employee/id`

For a provided Employee ID:
```json
{
    {
    "id": 4,
    "office": {
        "id": 10,
        "location": "Warszawa"
    },
    "officeId": null,
    "salary": 0.0,
    "shiftStart": "08:00:00",
    "shiftEnd": "16:00:00",
    "email": "dom47@gmail.com",
    "name": "Domi",
    "lastName": "wasil",
    "role": "ROLE_EMPLOYEE_HR"
}
}
```
### DeleteEmployee
`delete api/employee/id`

returns http status ok if employee was succesfully deleted

### AddEmployee
`post api/auth/signup/employee`

```json
{
  "username": "Domi10",
  "email": "domi10@gmail.com",
  "password": "Domii11i1",
  "name": "Domi", //optional
  "lastName": "Domi",	//optional
  "role": "emp"	//optional default is emp
}
```

returns employee with id if it was sucessfulyy added
example result:

```json
{
    "id": 3,
    "office": null,
    "officeId": null,
    "salary": 0.0,
    "shiftStart": null,
    "shiftEnd": null,
    "email": "domi10@gmail.com",
    "name": "Domi",
    "lastName": "Domi",
    "role": "ROLE_EMPLOYEE"
}
```

### ModifyEmployee
`put api/employee`

employee sent in json must have id param, other params can be empty

modified employee is sent in response

Example request parameters:
```json
{
    "id": 6,
    "officeId": 2,
    "salary": 1000.0,
    "shiftStart": "08:00:00",
    "shiftEnd": "16:00:00"
}
```
###### Package into JSON
Response would be:
```json

{
    "id": 6,
    "office": {
        "id": 2,
        "location": "Nowy Sacz"
    },
    "officeId": null,
    "salary": 1000.0,
    "shiftStart": "08:00:00",
    "shiftEnd": "16:00:00",
    "email": "dom49@gmail.com",
    "name": "Domi",
    "lastName": null,
    "role": "ROLE_EMPLOYEE"

}
```
### Offices
### Get all offices
###### Package into JSON
`get api/office`
- A list of all offices and their respective IDs
```json
{
[
    {
        "id": 2,
        "location": "Nowy Sacz"
    },
    {
        "id": 3,
        "location": "Gliwice"
    },
    {
        "id": 4,
        "location": "Warszawa"
    }
]
}
```
### Get one office by id
###### Package into JSON
`get api/office/id`
- An office of given id or 404 not found message if office doesn't exist
```json
{
    "id": 2,
    "location": "Nowy Sacz"
}
```
### Create office
###### Package into JSON
`post api/office`
- location must not be blank, it isn't possible to create 2 offices of the same location
```json
{
    "location": "Katowice"
}
```
- response would be
```json
{
    "id": 11,
    "location": "Katowice"
}
```

### delete office
###### Package into JSON
`delete api/office/id`
- returns status OK if office was successfully deleted
  
### update office
###### Package into JSON
`put api/office`
- office sent in json must have id param, you can't change location to a location that already exists
 ```json
  {
    "id": 5,
    "location": "Gliwice"
}
```
- in reponse you get udpated office
 ```json
  {
    "id": 5,
    "location": "Gliwice"
}
```  

### Cars List
request formatted thusly:
```json
{
	"office": "Warszawa",
	"available_start": "12-05-2024",
	"available_end": "18-05-2024"
}
```
##### Package into JSON
For a certain date and office locatio (Supplied in the request):

- Car types list
- Fuel types list
- Cars list

An example response object:
```json
{
	"car_types": [
	"hatchback",
	"sedan"
	],
	"fuel_types": [
	"electric",
	"petrol"
	],
	"cars": [
	{},
	{}
	]
}
```

An example of a "Car" object:
```json
{
	"model": "Toyota Corolla",
	"id": 123,
	"type": "hatchback",
	"cost": 50.4,
	"deposit": 200.1,
	"availability": true, // Has to be the availability for the date frame in the request
	"seat_number": 4,
	"fuel_type": 1,
	"image_url": "https://i.imgur.com/P74meQD.png",
	"office": "Gliwice"
}
```

### Car
##### Package into JSON
For a certain car id (Supplied in the request):
An example of a "Car" object:
```json
{
	"model": "Toyota Corolla",
	"id": 123,
	"type": "hatchback",
	"cost": 50.4,
	"deposit": 200.1,
	"availability": true, // Has to be the availability for the date in the request
	"seat_number": 4,
	"fuel_type": 1,
	"image_url": "https://i.imgur.com/P74meQD.png",
	"office": "Gliwice"
}
```

### ModifyCar
##### Accepts Request Parameters to Add, Modify or Remove Car Data.
Example request parameters:
```json
"model": "Toyota Corolla"
"id": 123,
"type": "sedan" # Zmienione dane
"cost": 50.4
"deposit": 200.1
"seat_number": 4
"fuel_type": "petrol"
"image_url": "https://i.imgur.com/P74meQD.png"
"office": "Gliwice"
"action": "add" # Can be either add, remove or modify. If remove, no other parameters than the ID are necessary.
```
###### Package into JSON
Response would be:
```json
{
	"status": "OK",
	"error": ""
}
```
Or:
```json
{
	"status": "Error!",
	"error": "java.lang.NullPointerException" // Either the exception name or the error message
}
```
### ModifyRent
##### Accepts Request Parameters to Add or Remove Rented Car Data.
Example request parameters:
```json
"car_id": 12
"rent_from": "25-08-2001"
"rent_to": "11-09-2001"
"action": "add" # Can be either add, remove or modify.
```
###### Package into JSON
Response would be:
```json
{
	"status": "OK",
	"error": ""
}
```
Or:
```json
{
	"status": "Error!",
	"error": "java.lang.NullPointerException" // Either the exception name or the error message
}
```
### Statistics
###### Package into JSON
Variables:
- Total cars
- Cars that are rented
- Cars that are in service
- Employees amount
- Offices amount
- Clients amount
- Earnings statistics array (24 float numbers, most recent last, null if not present)
```json
{
	"cars_total": 68,
	"cars_rented": 41,
	"cars_service": 3,
	"employees_total": 8,
	"offices_total": 3,
	"clients_total": 200,
	"earnings_stats": [
		121.3,
		223.1,
		421.1
	]
}
```
## Client
### Get client details
Get information about currently signed in Client
get /client/details
```json
{
    "id": 2,
    "username": "goodman",
    "email": "goodman@gmail.com",
    "name": "Jimmy",
    "lastName": "McGill",
    "companyInfo": null,
    "licenses": []
}
```
### Get all clients
get /client
```json
[
    {
        "id": 1,
        "username": "kielich420",
        "email": "kielich@gmail.com",
        "name": "Mateusz",
        "lastName": "Kieliszkowski",
        "companyInfo": {
            "name": "Budex Sp. z.o.o.",
            "nip": 123456789
        },
        "licenses": [
            {
                "id": 1,
                "licenseCategory": "B",
                "licenseNumber": 123458,
                "expirationDate": "2024-12-12"
            },
            {
                "id": 3,
                "licenseCategory": "A",
                "licenseNumber": 1312420,
                "expirationDate": "2030-01-01"
            }
        ]
    },
    {
        "id": 2,
        "username": "goodman",
        "email": "goodman@gmail.com",
        "name": "Jimmy",
        "lastName": "McGill",
        "companyInfo": null,
        "licenses": []
    }
]
```
### Get client by id
get /client/{id}

Response like above

### Delete client by id
delete /client/{id}

### Modify client
put /client

#### Request:
Client's id is required, chooses which client to modify.
To add new license do not specify its id, to modify existing license it is requierd to specify its id.
```json
{
    "id": 1,	// requierd - chooses client to modify
    "companyInfo": {
        "name": "Budex Sp. z.o.o.",
        "nip": 123456789
    },
    "licenses": [
        {
            "id": 1,
            "clientId": 1,
            "licenseCategory": "B",
            "licenseNumber": 123458,
            "expirationDate": "2024-12-12"
        },
        {
            "clientId": 1,
            "licenseCategory": "A",
            "licenseNumber": "1312420",
            "expirationDate": "2030-01-01"
        }
    ]
}
```

In response returns modified client (all fields).
