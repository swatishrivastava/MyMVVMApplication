package sample.livedata.com.mymvvmapplication;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {

    private static final String TAG = "MyViewModel";
    private final MutableLiveData<PersonDto> mutableLiveData;

    public MyViewModel() {
        this.mutableLiveData = new MutableLiveData<>();
    }

    public MutableLiveData<PersonDto> getMutableLiveData() {
        return mutableLiveData;
    }

    public void setMutableLiveData(final PersonDto personDto) {
        Log.d(TAG, "setMutableLiveData: ");
        mutableLiveData.setValue(personDto);
    }

}
