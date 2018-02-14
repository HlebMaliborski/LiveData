package hmaliborski.com.livedata.ui;


import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hmaliborski.com.livedata.R;
import hmaliborski.com.livedata.lifecycle.TestObserver;
import hmaliborski.com.livedata.viewmodel.NetworkViewModel;
import hmaliborski.com.livedata.viewmodel.livedata.NetworkLiveData;

/**
 * A simple {@link Fragment} subclass.
 */
public class NoteFragment extends Fragment {
    private static final String TAG = NoteFragment.class.getSimpleName();
    private TestObserver mTestObserver;
    private NetworkViewModel mNetworkViewModel;

    @BindView(R.id.noteText)
    TextView mTextView;
    @BindView(R.id.noteButton)
    Button mButton;
    @BindView(R.id.noteTextWifi)
    TextView mTextViewNetwork;

    public static NoteFragment newInstance() {

        Bundle args = new Bundle();

        NoteFragment fragment = new NoteFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public NoteFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTestObserver = new TestObserver(getLifecycle());
        mNetworkViewModel = ViewModelProviders.of(this).get(NetworkViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_note, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        final Observer<String> stringObserver = new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                mTextView.setText(s);
            }
        };

        mNetworkViewModel.getNetworkName().observe(this, stringObserver);

        final LiveData<String> stringLiveData = new NetworkLiveData(getContext());
        final Observer<String> stringObserver1 = new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                mTextViewNetwork.setText(s);
            }
        };

        stringLiveData.observe(this, stringObserver1);
    }

    @OnClick(R.id.noteButton)
    public void onClick(View view) {
        mNetworkViewModel.getNetworkName().setValue("Ura");
    }
}
