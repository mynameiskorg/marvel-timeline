package com.nicholaspiazza.marveltimeline;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.RatingBar;
import android.widget.TextView;

import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailView;

import org.json.JSONArray;
import org.json.JSONException;
import org.parceler.Parcels;

import okhttp3.Headers;

public class MarvelMovieDetail extends YouTubeBaseActivity {

    public static final String YOUTUBE_API_KEY = "AIzaSyAcj9jFn-Qw35rf2D3_d8SgX5gSFD4DAdI";
    public static final String TAG = "MarvelMovieDetail";
    public static final String TRAILERS_URL = "https://api.themoviedb.org/3/movie/%d/videos?api_key=a07e22bc18f5cb106bfe4cc1f83ad8ed&language=en-US";

    TextView tvMarvelTitle;
    TextView tvMarvelOverview;
    TextView tvReleaseDate;
    RatingBar ratingBar;
    YouTubePlayerView player;
    Movie marvelMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marvel_movie_detail);
        tvMarvelTitle = findViewById(R.id.tvMarvelTitle);
        tvMarvelOverview = findViewById(R.id.tvMarvelOverview);
        tvReleaseDate = findViewById(R.id.tvReleaseDate);
        ratingBar = findViewById(R.id.ratingBar);
        player = findViewById(R.id.player);

        marvelMovie = Parcels.unwrap(getIntent().getParcelableExtra("marvelMovie"));
        tvMarvelTitle.setText(marvelMovie.getTitle());
        tvMarvelOverview.setText(marvelMovie.getOverView());
        tvReleaseDate.setText(marvelMovie.getReleaseDate());
        ratingBar.setRating((float) marvelMovie.getMovieRating());

        AsyncHttpClient marvelClient = new AsyncHttpClient();
        marvelClient.get(String.format(TRAILERS_URL, marvelMovie.getMovieId()), new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Headers headers, JSON json) {
                try {
                    JSONArray results = json.jsonObject.getJSONArray("results");
                    if(results.length() == 0) {
                        return;
                    }

                    String youtubeLink = results.getJSONObject(0).getString("key");
                    Log.d(TAG, youtubeLink);
                    
                    startYouTube(youtubeLink);
                } catch (JSONException jsonException) {
                    Log.e(TAG, "did not parse json", jsonException);
                    jsonException.printStackTrace();
                }

            }

            @Override
            public void onFailure(int statusCode, Headers headers, String response, Throwable throwable) {

            }
        });
    }

    private void startYouTube(String youtubeLink) {
        player.initialize(YOUTUBE_API_KEY, new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                Log.d(TAG, "onInitializationSuccess");
                youTubePlayer.cueVideo(youtubeLink);
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Log.d(TAG, "onInitializationFailure");
            }
        });
    }
}