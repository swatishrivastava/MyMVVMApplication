package sample.livedata.com.mymvvmapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

public class SecondFragment extends Fragment {

    private TextView textView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.second_frag_layout, container, false);
        textView = view.findViewById(R.id.textView);
        MyViewModel myViewModel = ViewModelProviders.of(getActivity()).get(MyViewModel.class);
        textView.setText("Welcome  " + myViewModel.getMutableLiveData().getValue().getName() + "    !");
        return view;
    }
}
