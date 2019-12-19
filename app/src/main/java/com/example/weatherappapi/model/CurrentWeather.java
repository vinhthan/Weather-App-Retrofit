package com.example.weatherappapi.model;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CurrentWeather {
    @SerializedName("request")
    private final Request request;

    @SerializedName("location")
    private final Location location;

    @SerializedName("current")
    private final Current current;

    public CurrentWeather(Request request, Location location, Current current) {
        this.request = request;
        this.location = location;
        this.current = current;
    }

    public Request getRequest() {
        return request;
    }

    public Location getLocation() {
        return location;
    }

    public Current getCurrent() {
        return current;
    }

    public static class Request {
        @SerializedName("type")
        private final String type;

        @SerializedName("query")
        private final String query;

        @SerializedName("language")
        private final String language;

        @SerializedName("unit")
        private final String unit;

        public Request(String type, String query, String language, String unit) {
            this.type = type;
            this.query = query;
            this.language = language;
            this.unit = unit;
        }

        public String getType() {
            return type;
        }

        public String getQuery() {
            return query;
        }

        public String getLanguage() {
            return language;
        }

        public String getUnit() {
            return unit;
        }
    }

    public static class Location {
        @SerializedName("name")
        private final String name;

        @SerializedName("country")
        private final String country;

        @SerializedName("region")
        private final String region;

        @SerializedName("lat")
        private final String lat;

        @SerializedName("lon")
        private final String lon;

        @SerializedName("timezone_id")
        private final String timezoneId;

        @SerializedName("localtime")
        private final String localtime;

        @SerializedName("localtime_epoch")
        private final int localtimeEpoch;

        @SerializedName("utc_offset")
        private final String utcOffset;

        public Location(String name, String country, String region, String lat, String lon,
                        String timezoneId, String localtime, int localtimeEpoch, String utcOffset) {
            this.name = name;
            this.country = country;
            this.region = region;
            this.lat = lat;
            this.lon = lon;
            this.timezoneId = timezoneId;
            this.localtime = localtime;
            this.localtimeEpoch = localtimeEpoch;
            this.utcOffset = utcOffset;
        }

        public String getName() {
            return name;
        }

        public String getCountry() {
            return country;
        }

        public String getRegion() {
            return region;
        }

        public String getLat() {
            return lat;
        }

        public String getLon() {
            return lon;
        }

        public String getTimezoneId() {
            return timezoneId;
        }

        public String getLocaltime() {
            return localtime;
        }

        public int getLocaltimeEpoch() {
            return localtimeEpoch;
        }

        public String getUtcOffset() {
            return utcOffset;
        }
    }

    public static class Current {
        @SerializedName("observation_time")
        private final String observationTime;

        @SerializedName("temperature")
        private final int temperature;

        @SerializedName("weather_code")
        private final int weatherCode;

        @SerializedName("weather_icons")
        private final List<String> weatherIcons;

        @SerializedName("weather_descriptions")
        private final List<String> weatherDescriptions;

        @SerializedName("wind_speed")
        private final int windSpeed;

        @SerializedName("wind_degree")
        private final int windDegree;

        @SerializedName("wind_dir")
        private final String windDir;

        @SerializedName("pressure")
        private final int pressure;

        @SerializedName("precip")
        private final double precip;

        @SerializedName("humidity")
        private final int humidity;

        @SerializedName("cloudcover")
        private final int cloudcover;

        @SerializedName("feelslike")
        private final int feelslike;

        @SerializedName("uv_index")
        private final int uvIndex;

        @SerializedName("visibility")
        private final int visibility;

        @SerializedName("is_day")
        private final String isDay;

        public Current(String observationTime, int temperature, int weatherCode,
                       List<String> weatherIcons, List<String> weatherDescriptions, int windSpeed,
                       int windDegree, String windDir, int pressure, double precip, int humidity,
                       int cloudcover, int feelslike, int uvIndex, int visibility, String isDay) {
            this.observationTime = observationTime;
            this.temperature = temperature;
            this.weatherCode = weatherCode;
            this.weatherIcons = weatherIcons;
            this.weatherDescriptions = weatherDescriptions;
            this.windSpeed = windSpeed;
            this.windDegree = windDegree;
            this.windDir = windDir;
            this.pressure = pressure;
            this.precip = precip;
            this.humidity = humidity;
            this.cloudcover = cloudcover;
            this.feelslike = feelslike;
            this.uvIndex = uvIndex;
            this.visibility = visibility;
            this.isDay = isDay;
        }

        public String getObservationTime() {
            return observationTime;
        }

        public int getTemperature() {
            return temperature;
        }

        public int getWeatherCode() {
            return weatherCode;
        }

        public List<String> getWeatherIcons() {
            return weatherIcons;
        }

        public List<String> getWeatherDescriptions() {
            return weatherDescriptions;
        }

        public int getWindSpeed() {
            return windSpeed;
        }

        public int getWindDegree() {
            return windDegree;
        }

        public String getWindDir() {
            return windDir;
        }

        public int getPressure() {
            return pressure;
        }

        public double getPrecip() {
            return precip;
        }

        public int getHumidity() {
            return humidity;
        }

        public int getCloudcover() {
            return cloudcover;
        }

        public int getFeelslike() {
            return feelslike;
        }

        public int getUvIndex() {
            return uvIndex;
        }

        public int getVisibility() {
            return visibility;
        }

        public String getIsDay() {
            return isDay;
        }
    }
}
