# Health-Appointments-Management-API

## How to run the API

To tun the API, it's necessary to access the Swagger UI through `localhost:8080/swagger-ui/index.html`.

The Swagger UI allows its user to use the API online. By using the Swagger UI, there's no need to install softwares like Postman.

## Versions

|Version|Description|
|:-:|:-:|
|1|First version|
|2|Error handling was added|
|3|Serializable and regular expression (regex) were added|

## Examples

Register Patient
```
{
  "fullAddress": "St. Exupery Blv, LA, CA, 6333",
   "systemUserDTO": {
      "fullName": "G Madina",
      "ssn": "123456789",
      "birthDay": "12/12/2000",
      "email": "madina@madina.net",
      "phoneNumber": "12345678900"
  }
}
```

Register Physician
```
{
  "mln": "1234567",
  "systemUserDTO": {
    "fullName": "G Braga",
    "ssn": "987654321",
    "birthDay": "12/12/2000",
    "email": "braga@braga.net",
    "phoneNumber": "12345678900"
  }
}
```
DateTime

```
{
  "dateTime": "12/12/2024 12:30:00"
}
```
