package com.nicholaspiazza.marveltimeline;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    int movieId;
    String posterPath;
    String releaseDate;
    String title;
    String overView;

    public Movie(){}

    public Movie(JSONObject jsonObject) throws JSONException{
        movieId = jsonObject.getInt("id");
        posterPath = jsonObject.getString("poster_path");
        releaseDate = jsonObject.getString("release_date");
        title = jsonObject.getString("title");
        overView = jsonObject.getString("overview");
    }

    public static List<Movie> fromJsonArray(JSONArray movieJsonArray) throws JSONException {
        List<Movie> movies = new ArrayList<>();
        for(int i =0; i < movieJsonArray.length(); i++){
            movies.add(new Movie(movieJsonArray.getJSONObject(i)));
        }
        return movies;
    }

    public int getMovieId(){return movieId;}

    public String getPosterPath(){
        return String.format("https://image.tmdb.org/t/p/w342/%s", posterPath);
    }

    public  String getReleaseDate(){return releaseDate;}

    public String getTitle(){return title;}

    public String getOverView(){return overView;}

}

