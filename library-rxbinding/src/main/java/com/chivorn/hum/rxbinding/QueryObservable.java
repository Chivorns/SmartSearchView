package com.chivorn.hum.rxbinding;

import com.chivorn.hum.smartsearchview.SmartSearchView;
import com.jakewharton.rxbinding2.InitialValueObservable;

import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;

final public class QueryObservable extends InitialValueObservable<CharSequence> {

    private final SmartSearchView view;

    private final int minQueryLength;

    public QueryObservable(SmartSearchView view) {
        this(view, 1);
    }

    public QueryObservable(SmartSearchView view, int minQueryLength) {
        this.view = view;
        this.minQueryLength = minQueryLength;
    }

    @Override
    protected void subscribeListener(Observer<? super CharSequence> observer) {
        Listener listener = new Listener(view, observer, minQueryLength);
        observer.onSubscribe(listener);
        view.setOnQueryChangeListener(listener);
    }

    @Override
    protected CharSequence getInitialValue() {
        return view.getQuery();
    }

    final static class Listener extends MainThreadDisposable implements SmartSearchView.OnQueryChangeListener {

        private final SmartSearchView view;
        private final Observer<? super CharSequence> observer;
        private final int minQueryLength;

        public Listener(SmartSearchView view, Observer<? super CharSequence> observer, int minQueryLength) {
            this.view = view;
            this.observer = observer;
            this.minQueryLength = minQueryLength;
        }

        @Override
        public void onSearchTextChanged(String oldQuery, String newQuery) {
            if (!isDisposed() && newQuery != null && newQuery.length() >= minQueryLength) {
                observer.onNext(newQuery);
            }
        }

        @Override
        protected void onDispose() {
            view.setOnQueryChangeListener(null);
        }
    }
}
