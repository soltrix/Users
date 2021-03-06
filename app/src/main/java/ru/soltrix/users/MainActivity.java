package ru.soltrix.users;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import ru.soltrix.users.users.UsersFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, UsersFragment.newInstance(true))
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_settings) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, UsersFragment.newInstance(false))
                    .addToBackStack("BackStack")
                    .commit();
            return true;
        }
        return  super.onOptionsItemSelected(item);
    }
}
