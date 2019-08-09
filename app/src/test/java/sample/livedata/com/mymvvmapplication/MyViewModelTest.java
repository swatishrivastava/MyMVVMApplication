package sample.livedata.com.mymvvmapplication;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

public class MyViewModelTest {
    private MyViewModel myViewModel;
    @Rule
    public TestRule rule = new InstantTaskExecutorRule();

    @Before
    public void setup() {
        myViewModel = new MyViewModel();
    }

    @Test
    public void testBasic() {
        final PersonDto personDto = new PersonDto("swati", "swati@gmail.com");
        myViewModel.setMutableLiveData(personDto);
        final MutableLiveData<PersonDto> mutableLiveData = myViewModel.getMutableLiveData();
        Assert.assertEquals(mutableLiveData.getValue().getName(), "swati");
        Assert.assertEquals(mutableLiveData.getValue().getEmail(), "swati@gmail.com");
    }

}