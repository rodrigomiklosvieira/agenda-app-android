package br.com.agenda.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.com.agenda.R;
import br.com.agenda.configuration.RetrofitConfiguration;
import br.com.agenda.model.Pessoa;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Pessoa> people = getPeople();

        ListView listview = findViewById(R.id.listaContatos);

        ArrayAdapter<Pessoa> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, people);

        listview.setAdapter(adapter);

    }


    public List<Pessoa> getPeople(){
        Call<Pessoa> call = new RetrofitConfiguration().getRepositoryService().buscaPessoas();
        final List<Pessoa> people = new ArrayList<>();
        call.enqueue(new Callback<Pessoa>() {

            @Override
            public void onResponse(Call<Pessoa> call, Response<Pessoa> response) {
                Pessoa pessoa = response.body();
                people.add(pessoa);
            }

            @Override
            public void onFailure(Call<Pessoa> call, Throwable t) {
                Log.e("MainActivity", "Error: " + t.getMessage());
            }
        });
        return people;
    }

}
