package sample.livedata.com.mymvvmapplication;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {

    private MutableLiveData<PersonDto> mutableLiveData;

    public MyViewModel() {
        this.mutableLiveData = new MutableLiveData<>();
    }

    public MutableLiveData<PersonDto> getMutableLiveData() {
        return mutableLiveData;
    }

    public void setMutableLiveData(PersonDto personDto) {
        mutableLiveData.setValue(personDto);
    }

}
