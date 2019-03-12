package ru.soltrix.users.overflow;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface StackOverflowService {

    @GET("users")
    Call<UsersResponse> getUsers(@Query("page") int page, @Query("site") String site);
}
