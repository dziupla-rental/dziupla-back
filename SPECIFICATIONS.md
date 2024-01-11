# Data Interface Specifications
==All the requests will be sent with POST==
## Endpoints (Servlets)
### Login
The login will be implemented according to the instructions:
- [Backend](https://www.bezkoder.com/spring-boot-login-example-mysql/)
- [Frontend](https://www.bezkoder.com/angular-17-jwt-auth/)
- [Fullstack](https://www.bezkoder.com/angular-17-spring-boot-jwt-auth/)
### Employees
###### Package into JSON
`get api/employee`
- A list of all Employees and their respective IDs
- Office list
- Positions list
```json
{
	"employees": [ 
		{
			"name": "Jan Nowak",
			"id": 23
		},
		{
			"name": "Michał Kowalski",
			"id": 27
		}
	],
	"offices": [ // Lista dostępnych biur
	"Gliwice",
	"Zabrze"
	],
	"positions": [ // Lista dostępncyh stanowisk
	"Mechanik",
	"Menedżer"
	]
}
```

### Employee
###### Package into JSON
`get api/employee/id`

For a provided Employee ID:
```json
{
	"first_name": "Steve",
	"last_name": "Gomez",
	"position": "Mechanik",
	"id": 12,
	"salary": 12.3,
	"shift_start": "08:00:00",
	"shift_end": 200000,
	"office": "Gliwice"
}
```
### DeleteEmployee
`delete api/employee/id`

### AddEmployee
`post api/employee`

all employee parameters must be sent in json (only id should be empty)

json with added employee (also with id) is returned in response

### ModifyEmployee
`put api/employee`

employee sent in json must have id param, other params can be empty

modified employee is sent in response

Example request parameters:
```json
{
  "position": "Menedżer",
  "id": 12,
  "shift_start": 90000
}
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

