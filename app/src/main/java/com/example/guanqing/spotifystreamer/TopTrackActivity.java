package com.example.guanqing.spotifystreamer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;


public class TopTrackActivity extends ActionBarActivity {
    private final String LOG_TAG = SearchFragment.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        setTitle(getString(R.string.title_activity_detail));
        String[] artistInfo = null;
        if (getIntent()!=null){
            artistInfo = getIntent().getStringArrayExtra(Intent.EXTRA_TEXT);
            getSupportActionBar().setSubtitle(artistInfo[0]);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        Bundle args = new Bundle();
        args.putStringArray(TopTrackFragment.ARTIST_INFO, artistInfo);

        TopTrackFragment topTrackFragment = new TopTrackFragment();
        topTrackFragment.setArguments(args);

        if (savedInstanceState==null){
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.top_track_container, topTrackFragment)
                    .commit();
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}