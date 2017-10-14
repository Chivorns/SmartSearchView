package com.chivorn.hum.sample.fragment;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.chivorn.hum.smartsearchview.SmartSearchView;

public abstract class BaseExampleFragment extends Fragment {


    private BaseExampleFragmentCallbacks mCallbacks;

    public interface BaseExampleFragmentCallbacks {

        void onAttachSearchViewToDrawer(SmartSearchView searchView);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BaseExampleFragmentCallbacks) {
            mCallbacks = (BaseExampleFragmentCallbacks) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement BaseExampleFragmentCallbacks");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallbacks = null;
    }

    protected void attachSearchViewActivityDrawer(SmartSearchView searchView) {
        if (mCallbacks != null) {
            mCallbacks.onAttachSearchViewToDrawer(searchView);
        }
    }

    public abstract boolean onActivityBackPress();
}
