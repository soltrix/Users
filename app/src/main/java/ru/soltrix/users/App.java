package ru.soltrix.users;

import android.app.Application;

import com.readystatesoftware.chuck.ChuckInterceptor;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.soltrix.users.users.github.GitHubService;
import ru.soltrix.users.users.overflow.StackOverflowService;

public class App extends Application {

    GitHubService gitHubService;
    StackOverflowService stackOverflowService;

    @Override
    public void onCreate() {
        super.onCreate();
        createNetworkService();
    }

    public GitHubService getGitHubService() {
        return gitHubService;
    }

    public StackOverflowService getStackOverflowService() {
        return stackOverflowService;
    }

    private void createNetworkService() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        ChuckInterceptor chuckInterceptor = new ChuckInterceptor(this);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addNetworkInterceptor(httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY))
                .addNetworkInterceptor(chuckInterceptor)
                .build();

        Retrofit gitHubRetrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        gitHubService = gitHubRetrofit.create(GitHubService.class);

        Retrofit overflowRetrofit = new Retrofit.Builder()
                .baseUrl("https://api.stackexchange.com/2.2/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        stackOverflowService = overflowRetrofit.create(StackOverflowService.class);
    }
}
