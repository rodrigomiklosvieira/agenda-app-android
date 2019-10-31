package br.com.agenda.configuration;

import br.com.agenda.repository.RepositoryService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfiguration {

    private final Retrofit retrofit;

    public RetrofitConfiguration() {

        this.retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.104:8080/agenda-maven/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public RepositoryService getRepositoryService(){
        return this.retrofit.create(RepositoryService.class);
    }

}