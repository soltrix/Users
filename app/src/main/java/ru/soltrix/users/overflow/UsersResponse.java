package ru.soltrix.users.overflow;

import java.util.ArrayList;

public final class UsersResponse {

    private ArrayList<UserOverflow> items;

    public UsersResponse(ArrayList<UserOverflow> items) {
        this.items = items;
    }

    public ArrayList<UserOverflow> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "UsersResponse{" +
                "items=" + items +
                '}';
    }
}
