package com.rozadin.motivationalquote;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        ListView listView = (ListView)findViewById(R.id.list_item);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, new DatabaseListWork().doInBackground());
        listView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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


    class DatabaseListWork extends AsyncTask<Void, Integer, String[]>
    {
        @Override
        protected String[] doInBackground(Void... voids) {
            DAO_List dao_list = App.getInstance().getDatabase().getPersonDao();
            List<Room_List> list = dao_list.getAll();
            String[] str = new String[list.size()];
            if(list.size() == 0)
            {
                dao_list.insertAll(new Room_List(list.size(),(byte)8,(byte)18,(byte)0));
                list = dao_list.getAll();
            }
            for(int i=0;i<list.size();i++)
            {
                StringBuilder stringBuilder = new StringBuilder("1 раз в ");
                switch (list.get(i).period)
                {
                    case 0: stringBuilder.append("день");break;
                    case 1: stringBuilder.append("неделю");break;
                    case 2: stringBuilder.append("месяц");break;
                }
                stringBuilder.append("с ");
                if(list.get(i).start == 1 || list.get(i).start == 21) stringBuilder.append(list.get(i).start + " часа");
                else stringBuilder.append(list.get(i).start + " часов");
                stringBuilder.append(" до ");
                if(list.get(i).end == 1 || list.get(i).end == 21) stringBuilder.append(list.get(i).end + " часа");
                else stringBuilder.append(list.get(i).end + " часов");
                str[i] = stringBuilder.toString();
            }
            return str;
        }
    }
}
