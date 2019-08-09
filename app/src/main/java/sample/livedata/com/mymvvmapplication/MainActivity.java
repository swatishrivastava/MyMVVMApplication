package sample.livedata.com.mymvvmapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView = findViewById(R.id.greet_text);
        final EditText editText = findViewById(R.id.editText);
        final Button button = findViewById(R.id.button);


        final MyViewModel myViewModel = ViewModelProvider.AndroidViewModelFactory
                .getInstance(getApplication()).create(MyViewModel.class);

        myViewModel.getMutableLiveData().observe(this, new Observer<PersonDto>() {
            @Override
            public void onChanged(PersonDto personDto) {
                textView.setText("Hello " + personDto.getName() + " (" + personDto.getEmail() + ")");
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = editText.getText().toString();
                PersonDto personDto = new PersonDto(s, s + "@gmail.com");
                myViewModel.setMutableLiveData(personDto);
                editText.clearComposingText();

            }
        });

    }
}
