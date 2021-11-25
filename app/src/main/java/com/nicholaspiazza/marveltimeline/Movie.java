package com.nicholaspiazza.marveltimeline;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

@Parcel
public class Movie {
    int movieId;
    String posterPath;
    String releaseDate;
    String title;
    String overView;
    String mediaType;
    double movieRating;

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

    public  String getReleaseDate(){return releaseDate;}

    public String getTitle(){return title;}

    public String getOverView(){return overView;}

    public String getMediaType() {
        return mediaType;
    }

    public double getMovieRating() {
        return movieRating;
    }
}

