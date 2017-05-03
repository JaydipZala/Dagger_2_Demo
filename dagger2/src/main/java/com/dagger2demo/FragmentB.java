package com.dagger2demo;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.dagger2demo.extras.Keys;
import com.dagger2demo.module.Student;

import javax.inject.Inject;

/**
 * A placeholder fragment containing a simple view.
 */
public class FragmentB extends Fragment implements View.OnClickListener {

    @Inject
    SharedPreferences mPreferences;
    @Inject
    Student student;
    private TextView mTextStored;
    private Button mBtnRefresh;

    public FragmentB() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((MyApplication) getActivity().getApplication()).getComponent().inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_b, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    private void initViews(View view) {
        mTextStored = (TextView) view.findViewById(R.id.text_stored);
        mBtnRefresh = (Button) view.findViewById(R.id.btn_refresh);
        mBtnRefresh.setOnClickListener(this);
        loadStoredDataIntoTextView();
    }

    @Override
    public void onClick(View v) {
        loadStoredDataIntoTextView();
    }

    private void loadStoredDataIntoTextView() {
        String storedText = mPreferences.getString(Keys.PREF_INPUT, "Nothing found yet");
        String name = student.name;
        mTextStored.setText(name);
    }
}
