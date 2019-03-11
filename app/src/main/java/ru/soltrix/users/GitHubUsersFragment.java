package ru.soltrix.users;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class GitHubUsersFragment extends Fragment {

    @BindView(R.id.recycler)
    RecyclerView recyclerView;

    private Unbinder unbinder;
    private UserRecycleAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_git_hub_users, container, false);
        unbinder = ButterKnife.bind(this, view);

        adapter = new UserRecycleAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);

        ArrayList<User> userArrayList = new ArrayList<>();

        userArrayList.add(new User("Vasya", "https://avatars0.githubusercontent.com/u/1?v=4"));
        userArrayList.add(new User("Vasya1", "https://avatars0.githubusercontent.com/u/1?v=4"));
        userArrayList.add(new User("Vasya2", "https://avatars0.githubusercontent.com/u/1?v=4"));
        userArrayList.add(new User("Vasya3", "https://avatars0.githubusercontent.com/u/1?v=4"));
        userArrayList.add(new User("Vasya4", "https://avatars0.githubusercontent.com/u/1?v=4"));
        userArrayList.add(new User("Vasya5", "https://avatars0.githubusercontent.com/u/1?v=4"));
        userArrayList.add(new User("Vasya6", "https://avatars0.githubusercontent.com/u/1?v=4"));
        userArrayList.add(new User("Vasya7", "https://avatars0.githubusercontent.com/u/1?v=4"));

        adapter.addUsers(userArrayList);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
