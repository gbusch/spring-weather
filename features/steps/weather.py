from behave import given
import requests
from model import model_weather


@given('the following weather')
def mock_weather(context):
    weather = model_weather(context.table)
    mock = {"coord": {"lon": weather.lon, "lat": weather.lat},
            "weather": [{"description": weather.description}],
            "main": {"temp": weather.temperature},
            "name": weather.location}
    mapping = {
                "request": {
                  "method": "GET",
                  "urlPattern": r"^/weather(.*)"
                },
                "response": {
                  "jsonBody": mock,
                  "headers": {
                    "Content-Type": "application/json"
                  },
                  "status": 200
                }
              }
    r = requests.post("http://localhost:3000/__admin/mappings", json=mapping)
    context.lat = weather.lat
    context.lon = weather.lon


@given('there is an error with the weather API')
def break_weather_api(context):
    requests.delete("http://localhost:3000/__admin/mappings")


@when('I query the weather')
def query_weather(context):
    r = requests.get(f"http://localhost:8080/weather/{context.contract['id']}",
                        params={"lat": context.lat, "lon": context.lon})
    if r.status_code == 200:
        context.response = r.text
    else:
        context.response = r.json()


@then('I get "{response}"')
def assert_response(context, response):
    assert response == context.response


@then('I get an error with message "{message}"')
def assert_error_message(context, message):
    assert message == context.response["message"]
