package ru.ifmo.md.lesson8.Weather;

import java.util.ArrayList;

/**
 * Created by daria on 29.11.14.
 */
public class WeatherForecast {
    private ArrayList<Weather> weekWeather = new ArrayList<>();
    String name;

    public ArrayList<Weather> getWeekWeather() {
        return weekWeather;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
        if (this.name.contains(" ")) {
            this.name = this.name.replace(" ", "-");
        }
    }

    public void addDay(Weather w) {
        weekWeather.add(w);
    }
}
