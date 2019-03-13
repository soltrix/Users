package ru.soltrix.users.users.overflow;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.soltrix.users.Model;
import ru.soltrix.users.users.User;

public class OverflowUsersModel implements Model {

    private StackOverflowService stackOverflowService;

    public OverflowUsersModel(StackOverflowService stackOverflowService) {
        this.stackOverflowService = stackOverflowService;
    }

    @Override
    public void getUsers(ModelResponse<List<User>> modelResponse) {
        stackOverflowService.getUsers(1, "stackoverflow")
                .enqueue(new Callback<UsersResponse>() {
                    @Override
                    public void onResponse(Call<UsersResponse> call, Response<UsersResponse> response) {
                        ArrayList<User> users = new ArrayList<>();
                        for (StackOverflowUser userOverflow : response.body().getItems()) {
                            users.add(userOverflow.mapToUser());
                        }
                        modelResponse.onSuccess(users);
                    }

                    @Override
                    public void onFailure(Call<UsersResponse> call, Throwable t) {
                        modelResponse.onError(t);
                    }
                });
    }

    public final class UsersResponse {

        private ArrayList<StackOverflowUser> items;

        public UsersResponse(ArrayList<StackOverflowUser> items) {
            this.items = items;
        }

        public ArrayList<StackOverflowUser> getItems() {
            return items;
        }
    }
}
