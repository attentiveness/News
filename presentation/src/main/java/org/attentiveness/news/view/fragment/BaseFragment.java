package org.attentiveness.news.view.fragment;


import android.support.v4.app.Fragment;
import android.widget.Toast;

import org.attentiveness.news.internal.di.HasComponent;

/**
 * Base {@link android.support.v4.app.Fragment} class for every fragment in this application.
 */
public abstract class BaseFragment extends Fragment {

    protected void showToastMessage(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    @SuppressWarnings("unchecked")
    protected <C> C getComponent(Class<C> componentType) {
        return componentType.cast(((HasComponent<C>) getActivity()).getComponent());
    }

}
