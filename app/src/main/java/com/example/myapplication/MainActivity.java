package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            int id = item.getItemId();

            if (id == R.id.action_settings) {
                startActivity(new Intent(this, SettingsActivity.class));
                return true;
            }

            if (id == R.id.action_map) {
                openPreferredLocationInMap();
                return true;
            }
            return super.onOptionsItemSelected(item);
        }

        private void openPreferredLocationInMap() {
            SharedPreferences sharedPreferences =
                    PreferenceManager.getDefaultSharedPreferences(this);

            String location = sharedPreferences.getString(
                    getString(R.string.pref_location_key),
                    getString(R.string.pref_location_default));

            Uri geoLocation = Uri.parse("geo:0,0?").buildUpon()
                    .appendQueryParameter("q", location)
                    .build();

            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(geoLocation);

            if(intent.resolveActivity(getPackageManager()) != null){
                startActivity(intent);
            }else {
                Log.d(LOG_TAG, "Couldn't call" + location + ", no receiving apps installed!");
            }
        }
    }
}
