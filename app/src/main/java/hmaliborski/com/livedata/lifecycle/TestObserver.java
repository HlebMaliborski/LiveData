package hmaliborski.com.livedata.lifecycle;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.util.Log;

public class TestObserver implements LifecycleObserver {
    public TestObserver(Lifecycle lifecycle) {
        lifecycle.addObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void testOnResume() {
        Log.d("OnResume", "OnResume");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void testOnPause() {
        Log.d("OnPause", "OnPause");
    }
}
