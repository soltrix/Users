package ru.soltrix.users.users.github;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.soltrix.users.Model;
import ru.soltrix.users.users.User;

public class GitHubUsersModel implements Model{

    private GitHubService gitHubService;

    public GitHubUsersModel(GitHubService gitHubService) {
        this.gitHubService = gitHubService;
    }

    @Override
    public void getUsers(Model.ModelResponse<List<User>> modelResponse) {
        gitHubService.getUsers(0)
                .enqueue(new Callback<List<GitHubUser>>() {
                    @Override
                    public void onResponse(Call<List<GitHubUser>> call, Response<List<GitHubUser>> response) {
                        ArrayList<User> users = new ArrayList<>();
                        for (GitHubUser gitHubUser : response.body()) {
                            users.add(gitHubUser.mapToUser());
                        }
                        modelResponse.onSuccess(users);
                    }

                    @Override
                    public void onFailure(Call<List<GitHubUser>> call, Throwable t) {
                        modelResponse.onError(t);
                    }
                });
    }
}
