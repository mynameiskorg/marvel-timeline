package com.nicholaspiazza.marveltimeline;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Parcel
public class Movie {
    int movieId;
    String posterPath;
    String releaseDate;
    String title;
    String overView;
    String mediaType;
    double movieRating;
    HashMap<String, String> monthMap = new HashMap<>();

    public Movie(){}

    public Movie(JSONObject jsonObject) throws JSONException{
        movieId = jsonObject.getInt("id");
        posterPath = jsonObject.getString("poster_path");
        try {
            releaseDate = jsonObject.getString("release_date");
            title = jsonObject.getString("title");
        } catch(JSONException jsonException) {
            releaseDate = "";
            title = "";
        }
        overView = jsonObject.getString("overview");
        mediaType = jsonObject.getString("media_type");
        movieRating = 5*(jsonObject.getDouble("vote_average")/10);
        monthMap.put("01","Jan");
        monthMap.put("02","Feb");
        monthMap.put("03","Mar");
        monthMap.put("04","Apr");
        monthMap.put("05","May");
        monthMap.put("06","June");
        monthMap.put("07","July");
        monthMap.put("08","Aug");
        monthMap.put("09","Sept");
        monthMap.put("10","Oct");
        monthMap.put("11","Nov");
        monthMap.put("12","Dec");
    }

    public static List<Movie> fromJsonArray(JSONArray movieJsonArray) throws JSONException {
        List<Movie> movies = new ArrayList<>();
        for(int i =0; i < movieJsonArray.length(); i++){
            Movie marvelMedia = new Movie(movieJsonArray.getJSONObject(i));
            if(marvelMedia.getMediaType().equals("movie")) {
                movies.add(marvelMedia);
            }
        }
        return movies;
    }

    public int getMovieId(){return movieId;}

    public String getPosterPath(){
        return String.format("https://image.tmdb.org/t/p/w342/%s", posterPath);
    }

    public  String getReleaseDate() {
        return formatDate(releaseDate);
    }

    public String getTitle(){return title;}

    public String getOverView(){return overView;}

    public String getMediaType() {
        return mediaType;
    }

    public double getMovieRating() {
        return movieRating;
    }

    private String formatDate(String releaseDate) {
        String[] splitDate = releaseDate.split("-");
        String formattedDate = monthMap.get(splitDate[1]) + " " + splitDate[2] + ", " + splitDate[0];
        return formattedDate;
    }
}

