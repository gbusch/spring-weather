import requests
from behave import when, then


@given('I purchased a contract')
@when('I purchase a {model} contract with price {price}')
def purchase_contract(context, model="default", price=0.1):
    payload = {"name": "muster", "model": model, "price": price}
    context.response = requests.post("http://localhost:8080/contract", json=payload)
    context.contract = context.response.json()


@given('I did not purchase a contract')
def not_purchase_contract(context):
    context.contract = {"id": "no-contract-purchased"}


@then('I get the response {status} ({error})')
def assert_response(context, status, error):
    assert str(context.response.status_code) == status
    if context.response.status_code != 200:
        actual = context.response.json()['message']
        print('response: ', actual)
        print('expected: ', error)
        assert actual == error