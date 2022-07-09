# Objective

The project use the ```Google calendar API``` to get the user event and read the location of the event and give to waze service or google map to get the destination and time to arrive from the location of the user and the location of the event . 

-----
## Challenge
* Design the Controller and Model classes required for the atomic and composite services .


* Implementing your composite and atomic service code. At this stage you need to start actually implementing the code inside
your ```GET``` and ```POST``` methods. Here you can write Java code that invokes model classes and
other controllers locally inside the project code. But you should also show how you invoke
third party APIs through the ```Apache HTTP``` client or the ```REST Client``` provided by your third
party provider.

## Solution
You need to create a simple cloud application first ( developers.google to create account and create project in google cloud), After that you'll need to download your credentials.json file


![Pasted File at December 18, 2018 1_08 AM](https://user-images.githubusercontent.com/7686353/178112216-55487342-4fad-4468-a9b7-87f021fe0e9e.png)

then you need to enable the ```Google Calender API``` and ```Distance Matrix API```

![Pasted File at December 18, 2018 3_17 PM](https://user-images.githubusercontent.com/7686353/178112262-3c17be01-f879-415f-a36a-b72a379fc5a2.png)

----------- 

http://localhost:8282/getDistanceOfGivenEventById?eventId=cctoe6olq0hc3jl35rmq2ds95o&origins=Budapest,Hungary&mode=ride

```json
{
  "summary": "Test 897987564",
  "location": "Belgrade, Serbia",
  "description": "Test 14 Rome",
  "id": "cctoe6olq0hc3jl35rmq2ds95o_20181218T200000Z",
  "distanceResponse": {
    "status": "OK",
    "rows": [
      {
        "elements": [
          {
            "duration": {
              "text": "3 hours 46 mins",
              "value": "13550"
            },
            "distance": {
              "text": "379 km",
              "value": "378532"
            },
            "status": "OK"
          }
        ]
      }
    ],
    "origin_addresses": [
      "Budapest, Hungary"
    ],
    "destination_addresses": [
      "Belgrade, Serbia"
    ]
  }
}
```
