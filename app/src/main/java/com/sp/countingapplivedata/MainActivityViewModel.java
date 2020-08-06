package com.sp.countingapplivedata;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {

    private int mClickCount = 0;
    private MutableLiveData<Integer> mCountLiveData = new MutableLiveData<>();

    protected MutableLiveData<Integer> getInitialCount() {
        mCountLiveData.setValue(mClickCount);
        return mCountLiveData;
    }

    protected void getCurrentCount() {
        mClickCount += 1;
        mCountLiveData.setValue(mClickCount);
    }
}
