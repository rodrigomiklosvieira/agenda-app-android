package br.com.agenda.repository;

import br.com.agenda.model.Pessoa;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface RepositoryService {

    @GET("pessoas")
    Call<List<Pessoa>> buscaPessoas();

}