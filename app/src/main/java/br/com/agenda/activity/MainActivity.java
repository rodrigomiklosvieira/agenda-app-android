package br.com.agenda.activity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import br.com.agenda.R;
import br.com.agenda.configuration.RetrofitConfiguration;
import br.com.agenda.model.Pessoa;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ArrayAdapter<Pessoa> adapter;
    private List<Pessoa> people = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getPeople();

        ListView listview = findViewById(R.id.listaContatos);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, people);

        listview.setAdapter(adapter);

    }

    public void getPeople() {

        Call<List<Pessoa>> call = new RetrofitConfiguration().getRepositoryService().buscaPessoas();

        call.enqueue(new Callback<List<Pessoa>>() {

            @Override
            public void onResponse(Call<List<Pessoa>> call, Response<List<Pessoa>> response) {
                people.addAll(response.body());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Pessoa>> call, Throwable t) {

            }

        });

    }

}