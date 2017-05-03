package com.dagger2demo;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.dagger2demo.extras.Keys;
import com.dagger2demo.module.Student;

import javax.inject.Inject;

/**
 * A placeholder fragment containing a simple view.
 */
public class FragmentA extends Fragment implements View.OnClickListener {

    @Inject
    SharedPreferences mPreferences;
    @Inject
    Student student;
    private EditText mInputText;
    private Button mBtnStore;

    public FragmentA() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((MyApplication) getActivity().getApplication()).getComponent().inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_a, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    private void initViews(View view) {
        mInputText = (EditText) view.findViewById(R.id.input_text);
        mBtnStore = (Button) view.findViewById(R.id.btn_store);
        mBtnStore.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        storeTextToPreferences();
    }

    private void storeTextToPreferences() {
        String text = mInputText.getText().toString().trim();
        if (!TextUtils.isEmpty(text)) {
            student.id = 1;
            student.name = text;
            mPreferences.edit().putString(Keys.PREF_INPUT, text).apply();
        }
    }
}
