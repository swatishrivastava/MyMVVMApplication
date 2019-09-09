package sample.livedata.com.mymvvmapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment {


    private onSubmitButtonClick onSubmitButtonClick;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onSubmitButtonClick= (FirstFragment.onSubmitButtonClick) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view=inflater.inflate(R.layout.first_frag_layout, container, false);
        final TextView textView = view.findViewById(R.id.greet_text);
        final EditText editText = view.findViewById(R.id.editText);
        final Button button = view.findViewById(R.id.button);

        final MyViewModel myViewModel = ViewModelProviders.of(getActivity()).get(MyViewModel.class);

        myViewModel.getMutableLiveData().observe(getActivity(), new Observer<PersonDto>() {
            @Override
            public void onChanged(PersonDto personDto) {
                textView.setText("Hello " + personDto.getName() + " (" + personDto.getEmail() + ")");
            }
        });


        List<String> list = new ArrayList<>();
        list.add("Swati");

        Log.e("Playing with collection",  ""+list.size());

        for (String s: list){
            if(s.equalsIgnoreCase("Swati")){
                list.remove("Swati");
            }
        }


        Log.e("Collection after for ",  ""+list.size());


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = editText.getText().toString();
                PersonDto personDto = new PersonDto(s, s + "@gmail.com");
                myViewModel.setMutableLiveData(personDto);
                editText.setText("");
                onSubmitButtonClick.submitButtonClick();

            }
        });
        return view;

    }

    interface onSubmitButtonClick{
        void submitButtonClick();
    }




}
