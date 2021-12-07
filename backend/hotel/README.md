# Start server

	./mvnw spring-boot:run
	
## API

### /api/hotel

#### GET
Return an array of hotels.

#### GET (api/hotel/{id})
Return specific hotel entity.

#### POST
Create new hotel entity:
```json
{
	"name": "Some name"
}
```

Returns created entity with its ID.

#### PUT (api/hotel/{id})
Updates existing hotel entity:
```json
{
	"name": "Another name",
	"destination": {
		"city": "Almaty"
	}
}
```

Returns updated entity.

#### DELETE (api/hotel/{id})
Deletes hotel entity.

Returns "Deleted with id: {id}" in case of success, otherwise, "Not Found".

----

### /api/user

#### GET
Return an array of user.

#### GET (api/user/{email})
Return specific user entity.

#### POST
Create new user entity:
```json
{
	"email": "test@gmail.com",
	"password": "12345"
}
```

Returns created entity with.

#### PUT (api/user/{email})
Updates existing user entity:
```json
{
	"password": "54321"
}
```

Returns updated entity.

#### DELETE (api/user/{email})
Deletes user entity.

Returns "Deleted with email: {email}" in case of success, otherwise, "Not Found".

----

### /api/guest

#### GET
Return an array of guests.


#### POST
Create new guest entity:
```json
{
	"name": "John",
	"surname": "Doe",
	"email": "test@gmail.com",
	"id_typeNum": 1,
	"id_number": "111222"
}
```

Returns created entity with its ID.

#### GET (api/guest/{id}) Work in progress

#### PUT (api/guest/{id}) Work in progress

#### DELETE (api/user/{email}) Work in progress

----

### /api/id_types

#### GET
Return an array of identification types.
