package ru.ifmo.md.lesson8;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import ru.ifmo.md.lesson8.Weather.CurrentWeather;

/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a {@link CitiesListActivity}
 * in two-pane mode (on tablets) or a {@link CurrentWeatherActivity}
 * on handsets.
 */
public class CurrentWeatherFragment extends Fragment {

    public static final String ARG_ITEM_ID = "item_id";


    private CurrentWeather currentWeather;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.

            //TODO: currentWeather = ... smth with Loader
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.current_weather_fragment, container, false);

        if (currentWeather != null) {
            ((TextView) rootView.findViewById(R.id.city_name)).setText(currentWeather.getName());
            //TODO: get Date from system and set it to date field
            ((TextView) rootView.findViewById(R.id.sunrise)).setText("Sunrise: " + currentWeather.getSunrise().toString());
            ((TextView) rootView.findViewById(R.id.sunset)).setText("Sunset: " + currentWeather.getSunset().toString());
            ((TextView) rootView.findViewById(R.id.cur_temp)).setText(Integer.toString(currentWeather.getTemperature()) + "ºC");
            ((TextView) rootView.findViewById(R.id.min_temp)).setText(Integer.toString(currentWeather.getMinTemperature()) + "ºC");
            ((TextView) rootView.findViewById(R.id.max_temp)).setText(Integer.toString(currentWeather.getMaxTemperature()) + "ºC");

            ImageView image = (ImageView) rootView.findViewById(R.id.icon);
            image.setImageBitmap(Bitmap.createBitmap(currentWeather.getIcon(), image.getWidth(), image.getHeight(), Bitmap.Config.RGB_565));

            //TODO: get Time, compare it with sunrise and sunset and set image to background

            ((TextView) rootView.findViewById(R.id.weatherId)).setText(currentWeather.getWeatherId());
            ((TextView) rootView.findViewById(R.id.humidity)).setText("Humidity: " + Integer.toString(currentWeather.getHumidity()) + "%");
            ((TextView) rootView.findViewById(R.id.pressure)).setText("Pressure: " + Integer.toString(currentWeather.getPressure()) + " hPa");
            ((TextView) rootView.findViewById(R.id.speed)).setText("Speed: " + Integer.toString(currentWeather.getWindSpeed()) + " mps");

            int deg = currentWeather.getWindDeg();
            TextView windDeg = (TextView) rootView.findViewById(R.id.direction);
            String windDegText = "Direction: ";

            if (deg >= 338 || deg <= 22) {
                windDegText += "N";
            }
            else if (deg >= 23 && deg <= 67) {
                windDegText += "NE";
            }
            else if (deg >= 68 && deg <= 112) {
                windDegText += "E";
            }
            else if (deg >= 113 && deg <= 157) {
                windDegText += "SE";
            }
            else if (deg >= 158 && deg <= 202) {
                windDegText += "S";
            }
            else if (deg >= 203 && deg <= 247) {
                windDegText += "SW";
            }
            else if (deg >= 248 && deg <= 292) {
                windDegText += "W";
            }
            else {
                windDegText += "NW";
            }
            windDeg.setText(windDegText);
        }

        return rootView;
    }
}
