package sample.livedata.com.mymvvmapplication;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class MyViewModel extends AndroidViewModel {

    private MutableLiveData<PersonDto> mutableLiveData;
    public MyViewModel(@NonNull Application application) {
        super(application);

        PersonDto personDto=new PersonDto("Paramvir", "swati@gmail.com");
        mutableLiveData=new MutableLiveData<>();
        mutableLiveData.setValue(personDto);
    }

    public MutableLiveData<PersonDto> getMutableLiveData(){
        return mutableLiveData;
    }

    public void setMutableLiveData(PersonDto personDto){
        mutableLiveData.setValue(personDto);
    }

}
