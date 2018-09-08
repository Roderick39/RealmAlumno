package com.example.rodrigobaez.realmalumno.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.ListView;

import com.example.rodrigobaez.realmalumno.R;
import com.example.rodrigobaez.realmalumno.adapters.MyAdapter;
import com.example.rodrigobaez.realmalumno.models.Alumno;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity implements RealmChangeListener<RealmResults<Alumno>> {


    private GridView gridView;
    private MyAdapter adapter;

    private Realm realm;
    private RealmResults<Alumno> people;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Realm.init(getApplicationContext());
        realm = Realm.getDefaultInstance();
        gridView = (GridView) findViewById(R.id.GridView);

        people = getAllPeople();
        people.addChangeListener(this);

        adapter = new MyAdapter(people, R.layout.grid_item_view, this);

        gridView.setAdapter(adapter);
    }

    @Override
    public void onChange(RealmResults<Alumno> element) {
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onDestroy() {
        realm.removeAllChangeListeners();
        realm.close();
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.item_add:
                addPeople();
                return true;
            case R.id.item_delete:
                removeAll();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    private RealmResults<Alumno> getAllPeople() {
        return realm.where(Alumno.class).findAll();
    }

    private void removeAll() {
        realm.beginTransaction();
        realm.deleteAll();
        realm.commitTransaction();
    }


    private void addPeople() {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {



                Alumno ingreso1 = new Alumno("22.453.811-3","Martin","Galvez","22","ICIN","2016","quinto");
                Alumno ingreso2 = new Alumno("21.533.190-6","Graciela","Meneses","24","ICIN","2015","séptimo");
                Alumno ingreso3 = new Alumno("19.200.183-0","Claudio","Troncoso","27","ICIN","2011","séptimo");
                Alumno ingreso4 = new Alumno("23.564.010-4","Fabiola","Mirosevic","21","ICIN","2016","quinto");
                Alumno ingreso5 = new Alumno("22.911.071-2","Miguel","Herrera","22","ICIN","2014","séptimo");
                Alumno ingreso6 = new Alumno("20.101.110-1","Carolina","Daza","26","ICIN","2018","primero");
                Alumno ingreso7 = new Alumno("25.467.006-9","Alejandro","Reyes","18","ICIN","2018","primero");
                Alumno ingreso8 = new Alumno("21.992.997-5","Noelia","Rebolledo","23","ICIN","2013","tercero");
                Alumno ingreso9 = new Alumno("18.330.221-7","Maite","Pizarro","28","ICIN","2010","quinto");
                Alumno ingreso10 = new Alumno("20.551.829-8","Arnaldo","Bugueño","26","ICIN","2016","quinto");
                realm.copyToRealmOrUpdate(ingreso1);
                realm.copyToRealmOrUpdate(ingreso2);
                realm.copyToRealmOrUpdate(ingreso3);
                realm.copyToRealmOrUpdate(ingreso4);
                realm.copyToRealmOrUpdate(ingreso5);
                realm.copyToRealmOrUpdate(ingreso6);
                realm.copyToRealmOrUpdate(ingreso7);
                realm.copyToRealmOrUpdate(ingreso8);
                realm.copyToRealmOrUpdate(ingreso9);
                realm.copyToRealmOrUpdate(ingreso10);

                people = getAllPeople();
            }
        });
    }
}

