package com.leijiaxq.tablayoutsample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by  leijiaxq
 * Date        2017/10/12 16:50
 * Describe
 */

public class SampleFragment extends Fragment {

    private TextView mTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle state) {
        View view = inflater.inflate(R.layout.fragment_sample, container, false);
        mTextView = view.findViewById(R.id.text_view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initData();
    }

    private void initData() {
        Bundle bundle = getArguments();
        String params = bundle.getString("params");
        if (!TextUtils.isEmpty(params)) {
            mTextView.setText(params);
        }
    }
}
