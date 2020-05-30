import requests


def before_scenario(context, _):
    requests.delete("http://localhost:3000/__admin/mappings")