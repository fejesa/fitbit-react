# Reactive way to access Fitbit API 
The example application demonstrates how to access the [Fitbit](https://dev.fitbit.com/build/reference/web-api/) Web API
in reactive way by using [Spring Webflux](https://docs.spring.io/spring/docs/current/spring-framework-reference/web-reactive.html).

The client can call the
* /activities
* /detailed-activities

REST APIs.

The client can fetch user activities measurement results in a given period by sending
a GET request from a console - for example using [httpie](https://httpie.org/) - like
```
http GET localhost:8080/activities from==2020-10-01 to==2020-10-02
```

The client gets the response in JSON like
```html
HTTP/1.1 200 OK
Content-Length: 1136
Content-Type: application/json
Vary: Origin
Vary: Access-Control-Request-Method
Vary: Access-Control-Request-Headers

{
    "activities": [
        {
            "dateTime": "2020-10-02",
            "value": {
                "heartRateZones": [
                    {
                        "caloriesOut": 2236.9039199999997,
                        "max": 99,
                        "min": 30,
                        "minutes": 1363,
                        "name": "Out of Range"
                    },
                    {
                        "caloriesOut": 279.66739999999993,
                        "max": 123,
                        "min": 99,
                        "minutes": 40,
                        "name": "Fat Burn"
                    },
                    {
                        "caloriesOut": 212.199,
                        "max": 153,
                        "min": 123,
                        "minutes": 18,
                        "name": "Cardio"
                    },
                    {
                        "caloriesOut": 245.60673999999995,
                        "max": 220,
                        "min": 153,
                        "minutes": 19,
                        "name": "Peak"
                    }
                ],
                "restingHeartRate": 52
            }
        },
        {
            "dateTime": "2020-10-01",
            "value": {
                "heartRateZones": [
                    {
                        "caloriesOut": 2226.4572000000003,
                        "max": 99,
                        "min": 30,
                        "minutes": 1405,
                        "name": "Out of Range"
                    },
                    {
                        "caloriesOut": 252.4624,
                        "max": 123,
                        "min": 99,
                        "minutes": 35,
                        "name": "Fat Burn"
                    },
                    {
                        "caloriesOut": 0.0,
                        "max": 153,
                        "min": 123,
                        "minutes": 0,
                        "name": "Cardio"
                    },
                    {
                        "caloriesOut": 0.0,
                        "max": 220,
                        "min": 153,
                        "minutes": 0,
                        "name": "Peak"
                    }
                ],
                "restingHeartRate": 52
            }
        }
    ],
    "device": {
        "deviceVersion": "Charge 4",
        "id": "1369721017",
        "lastSyncTime": "2020-12-05T15:20:34.817",
        "type": "TRACKER"
    },
    "user": {
        "age": 31,
        "dateOfBirth": "1989-05-21",
        "displayName": "Anonymous L.",
        "distanceUnit": "METRIC",
        "firstName": "Aladar",
        "gender": "MALE",
        "glucoseUnit": "en_US",
        "height": 175,
        "heightUnit": "METRIC",
        "weight": 71,
        "weightUnit": "METRIC"
    }
}
```

All result types can be used by the downstream applications like UI or reporting.

## Requirements
* Java 11+
* Maven
* Register you Personal App Type at Fitbit [here](https://dev.fitbit.com/login).

## How to build
Execute the following command
```
mvn clean package
```
## Configuration
Customize the _application.yml_ file with your settings
```yaml
myhealth:
    fitbit:
        baseUri: https://api.fitbit.com/1
        tokenFile: file:/<your_fitbit_token_json_path>

fitbit:
    api:
        tokenHost: https://api.fitbit.com
        clientId: <your client id>
        clientSecret: <your client secret>
        redirectUri: https://example.com/auth
```
where the token JSON has the following content
```json
{
  "accessToken": "your_access_token",
  "refreshToken": "your_refresh_token",
  "expirationTime": ""
}
```
The application refreshes the token file automatically.

## How to run
Execute the following command
```
mvn spring-boot:run
```
