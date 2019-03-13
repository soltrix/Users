package ru.soltrix.users;

import java.util.List;

import ru.soltrix.users.users.User;

public interface Model {

    public void getUsers(Model.ModelResponse<List<User>> modelResponse);

    public interface ModelResponse<T> {
        public void onSuccess(T response);
        public void onError(Throwable error);
    }
}
