package com.mediclink.hassan.popularmoviestage1.Sync;

import android.net.Uri;
import android.provider.BaseColumns;


public class MoviesContract {

    public static final String AUTHORITY = "com.mediclink.hassan.popularmoviestage1";
    public static final Uri BASE_URL = Uri.parse("content://" + AUTHORITY);
    public static final String PATH = "movies";

    public static class MoviesEntry implements BaseColumns{
        public static final Uri CONTENT_URI = BASE_URL.buildUpon().appendPath(PATH).build();

        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_RATING = "rating";
        public static final String COLUMN_POSTER = "poster";
        public static final String TABLE_NAME = "movies";
        public static final String COLUMN_ID = "id";
    }
}
