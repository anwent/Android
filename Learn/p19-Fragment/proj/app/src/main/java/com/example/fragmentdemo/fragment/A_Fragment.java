package com.example.fragmentdemo.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.fragmentdemo.R;

public class A_Fragment extends Fragment {

    TextView tv1;
    private Button modButton, resetButton;
    private B_Fragment bF;

    public static A_Fragment newInstance(String str) {
        A_Fragment aF = new A_Fragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", str);
        aF.setArguments(bundle);
        return aF;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_a_fragment, container, false);
        Log.d("A_Fragment", "----- onCreateView -----");
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tv1 = (TextView) view.findViewById(R.id.a_tv_1);

        modButton = (Button) view.findViewById(R.id.mod_btn);
        resetButton = (Button) view.findViewById(R.id.mod_reset);

        modButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bF == null) {
                    bF = new B_Fragment();
                }
                Fragment aF = getFragmentManager().findFragmentByTag("aF");
                if (aF != null) {
                    getFragmentManager()
                            .beginTransaction()
                            .hide(aF)
                            .add(R.id.fg_1, bF)
                            .addToBackStack(null)
                            .commitAllowingStateLoss();
                } else {
                    // pop时，会调用onCreate 重绘页面
                    getFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fg_1, bF)
                            .addToBackStack(null) // 添加到back栈中
                            .commitAllowingStateLoss();
                }
            }
        });


        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv1.setText("reset button click!");
            }
        });

        if (getArguments() != null) {
            tv1.setText(getArguments().getString("title"));
        }

    }
}
