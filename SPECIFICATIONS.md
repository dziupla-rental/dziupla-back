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
        "id": 1,
        "office": null,
        "salary": 1000.0,
        "shiftStart": "08:00:00",
        "shiftEnd": "16:00:00",
        "email": "domi10@gmail.com"
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
    "id": 1,
    "office": null, //tu trzeba poprawić
    "salary": 1000.0,
    "shiftStart": "08:00:00",
    "shiftEnd": "16:00:00",
    "email": "domi10@gmail.com"
}
```
### DeleteEmployee
`delete api/employee/id`

returns http status ok if employee was succesfully deleted

### AddEmployee
`post api/employee`

json with added employee (with id) is returned in response

### ModifyEmployee
`put api/employee`

employee sent in json must have id param, other params can be empty

modified employee is sent in response

Example request parameters:
```json
{
    "id": 1,
    "office_id": 2,
    "salary": 1000.0,
    "shiftStart": "08:00:00",
    "shiftEnd": "16:00:00"
}
```
###### Package into JSON
Response would be:
```json
{
    "id": 1,
    "office": null, //tu trzeba poprawić
    "salary": 1000.0,
    "shiftStart": "08:00:00",
    "shiftEnd": "16:00:00",
    "email": "domi10@gmail.com"
}
```

### Role
###### Package into JSON
For a User ID:
```json
{ "role": "" }
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
### Client Details
For the currently signed in client (owner of the token)
```json
{
	"first_name": "Jan",
	"last_name": "Kowalski",
	"is_company": false,
	"licenses":[
		{
		"number":123453252,
		"expiration_date": "11-11-2026",
		"category": "B"
		}
	]
}

```

