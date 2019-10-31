package br.com.agenda.repository;

import br.com.agenda.model.Pessoa;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RepositoryService {

    @GET("pessoas")
    Call<Pessoa> buscaPessoas();

}
