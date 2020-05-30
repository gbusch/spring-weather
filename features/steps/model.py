from collections import namedtuple


def model_weather(table):
    assert table.headings == ["location", "lat", "lon", "description", "temperature"]
    assert len(table.rows) == 1
    Weather = namedtuple("Weather", "location lat lon description temperature")
    return Weather(location=table.rows[0][0],
                   lat=table.rows[0][1],
                   lon=table.rows[0][2],
                   description=table.rows[0][3],
                   temperature=table.rows[0][4])