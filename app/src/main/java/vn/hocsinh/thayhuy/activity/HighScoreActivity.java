package vn.hocsinh.thayhuy.activity;

import android.app.ListActivity;
import android.os.Bundle;

import vn.hocsinh.thayhuy.App;
import vn.hocsinh.thayhuy.R;
import vn.hocsinh.thayhuy.adapter.HighScoreAdapter;
import vn.hocsinh.thayhuy.manager.DatabaseManager;

@SuppressWarnings("ALL")
public class HighScoreActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);

        DatabaseManager databaseManager = new DatabaseManager(App.getContext());
        getListView().setAdapter(new HighScoreAdapter(databaseManager.getHighScore()));
    }

    @Override
    protected void onPause() {
        super.onPause();
        App.getMusicPlayer().pauseBgMusic();
    }

    @Override
    protected void onResume() {
        super.onResume();
        App.getMusicPlayer().resumeBgMusic();

    }
}
