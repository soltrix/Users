package ru.soltrix.users.users.github;

import com.google.gson.annotations.SerializedName;

import ru.soltrix.users.users.User;

public class GitHubUser {

    @SerializedName("login") String name;
    @SerializedName("avatar_url") String avatar;
    @SerializedName("id") long userId;

    public User mapToUser() {
        return new User (name, avatar, userId);
    }
}
