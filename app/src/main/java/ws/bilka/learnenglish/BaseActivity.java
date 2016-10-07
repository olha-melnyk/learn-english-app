package ws.bilka.learnenglish;

import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class BaseActivity extends Activity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.menu:
                Toast.makeText(this, "Clicked: Menu No. 1", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.submenu1:
                Toast.makeText(this, "Clicked: Menu No. 2 - SubMenu No .1", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.submenu2:
                Toast.makeText(this, "Clicked: Menu No. 2 - SubMenu No .2", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.list_item_pager:
                Intent nextActivity = new Intent(this, CardActivity.class);
                startActivity(nextActivity);

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
