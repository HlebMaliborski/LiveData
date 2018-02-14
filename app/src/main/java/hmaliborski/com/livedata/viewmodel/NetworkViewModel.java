package hmaliborski.com.livedata.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class NetworkViewModel extends ViewModel {
    private MutableLiveData<String> mMutableLiveData;

    public MutableLiveData<String> getNetworkName() {
        if (mMutableLiveData == null) {
            mMutableLiveData = new MutableLiveData<>();
        }

        return mMutableLiveData;
    }
}
