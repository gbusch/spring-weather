from behave import given
import json
import requests

@given('the following prices are configured')
def set_prices(context):
    headings = context.table.headings
    prices = []
    for row in context.table:
        prices.append({k: v for k,v in zip(headings, row)})
    print(prices)
    with open("test-tmp/backend/config/prices.json", "w") as fp:
        json.dump(prices, fp)


@when('I query the prices for model {model}')
def query_prices(context, model):
    r = requests.get("http://localhost:8080/prices")
    assert r.status_code == 200
    for row in r.json():
        if row['name'] == model:
            context.response = row['price']


@then('I get the price {price}')
def assert_prices(context, price):
    assert float(context.response) == float(price), f'expected {price}, but got {context.response}'