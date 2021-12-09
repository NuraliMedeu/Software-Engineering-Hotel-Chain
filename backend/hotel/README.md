# Start server

	./mvnw spring-boot:run
	
## API

### /api/hotel

#### GET
Return an array of hotels.

#### GET (api/hotel/search) Work in progress
Return an array of hotels.

#### GET (api/hotel/{id})
Return specific hotel entity.

#### POST
Create new hotel entity:
```json
{
  "name": "Rixos",
  "destination": {
    "city": "Almaty"
  }
}
```

Returns created entity with its ID.

#### PUT (api/hotel/{id})
Updates existing hotel entity:
```json
{
	"name": "Another name",
	"destination": {
		"city": "Nur-Sultan"
	}
}
```

Returns updated entity.

#### DELETE (api/hotel/{id})
Deletes hotel entity.

Returns "Deleted with id: {id}" in case of success, otherwise, "Not Found".

----

### /api/user_types

#### GET
Return an array of user types.

----

### /api/user

#### GET
Return an array of users.

#### POST
Create new user entity:
```json
{
	"email": "test001@gmail.com",
	"password": "12345",
	"name": "John",
	"surname": "Doe",
	"id_typeNum": 1,
	"id_number": "111222"
	"user_type": {
		"type": "guest"
	}
}
```

Returns created entity.

#### GET (api/user/{email})
Return entity by its email.

#### PUT Work in progress

#### DELETE  Work in progress

----

### /api/id_types

#### GET
Return an array of identification types.

----

### /api/room_types

#### GET
Returns array of room types in every hotel (id is an id of a hotel)

----

### /api/rooms

#### GET
Returns array of rooms in every hotel (id is an id of a hotel)

----

### /api/booking

#### GET
Returns an array of all bookings

#### POST

```json
{
	"email": "test001@gmail.com",
	"check_in": "2021-12-08",
	"check_out": "2021-12-10",
	"room": {
		"hotel_id": 1,
		"room_number": 101,
		"floor": 1
	}
}
```
