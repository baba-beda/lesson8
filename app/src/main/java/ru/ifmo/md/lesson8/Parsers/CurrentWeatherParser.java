package ru.ifmo.md.lesson8.Parsers;

import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Time;

import ru.ifmo.md.lesson8.Queries.ImageQuery;
import ru.ifmo.md.lesson8.Weather.CurrentWeather;

/**
 * Created by daria on 29.11.14.
 */
public class CurrentWeatherParser {
    public static CurrentWeather getWeather(String data) throws JSONException {
        CurrentWeather weather = new CurrentWeather();

        JSONObject jObj = new JSONObject(data);

        JSONObject sysObj = jObj.getJSONObject("sys");
        weather.setSunrise(new Time(Long.parseLong(sysObj.getString("sunrise")) * 1000));
        weather.setSunset(new Time(Long.parseLong(sysObj.getString("sunset")) * 1000));
        weather.setName(jObj.getString("name"));

        JSONObject jWeather = jObj.getJSONObject("weather");
        weather.setWeatherId(jWeather.getString("description"));
        weather.setIconId(jWeather.getString("icon"));
        weather.setIcon(new ImageQuery().getImage(weather.getIconId()));


        weather.setMaxTemperature((int) (jWeather.getDouble("temp_max") - 273.15));
        weather.setMinTemperature((int) (jWeather.getDouble("temp_min") - 273.15));
        weather.setTemperature((int) (jWeather.getDouble("temp") - 273.15));

        JSONObject wObj = jObj.getJSONObject("wind");
        weather.setWindSpeed((int) wObj.getDouble("speed"));
        weather.setWindDeg((int) wObj.getDouble("deg"));

        return weather;
    }
}
