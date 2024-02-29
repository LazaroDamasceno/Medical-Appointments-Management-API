# Health-Appointments-Management-API

## Versions

|Version|Description|
|:-:|:-:|
|1|First version|
|2|Error handling was added|
|3|Serialable, Regular expression and some new methods were add|
|4|?UI?|


## Examples

Register Patient
```
{
  "fullAddress": "St. Exupery Blv, LA, CA, 6333",
   "systemUserDTO": {
      "fullName": "G Madina",
      "ssn": "123456789",
      "birthDay": "12/12/2000",
      "email": "madina@mdina.net",
      "phoneNumber": "12345678900"
  }
}
```

RegisterPhysician
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