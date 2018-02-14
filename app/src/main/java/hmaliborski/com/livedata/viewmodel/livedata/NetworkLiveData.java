package hmaliborski.com.livedata.viewmodel.livedata;

import android.arch.lifecycle.LiveData;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;

public class NetworkLiveData extends LiveData<String> {
    private BroadcastReceiver mBroadcastReceiver;
    private Context mContext;

    public NetworkLiveData(Context context) {
        mContext = context;
    }

    @Override
    protected void onActive() {
        IntentFilter filter = new IntentFilter();
        filter.addAction(WifiManager.SUPPLICANT_CONNECTION_CHANGE_ACTION);
        filter.addAction(WifiManager.NETWORK_STATE_CHANGED_ACTION);

        mBroadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                WifiManager wifiManager = (WifiManager) mContext.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                WifiInfo wifiInfo = wifiManager.getConnectionInfo();
                String name = wifiInfo.getSSID();
                if (name.isEmpty()) {
                    setValue(null);
                } else {
                    setValue(name);
                }
            }
        };

        mContext.registerReceiver(mBroadcastReceiver, filter);
    }

    @Override
    protected void onInactive() {
        mContext.unregisterReceiver(mBroadcastReceiver);
        mBroadcastReceiver = null;
    }
}
