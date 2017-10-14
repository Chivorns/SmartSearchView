package com.chivorn.hum.rxbinding;

import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;

import com.chivorn.hum.smartsearchview.SmartSearchView;
import com.jakewharton.rxbinding2.InitialValueObservable;

public final class RxFloatingSearchView {

    @CheckResult
    @NonNull
    public static InitialValueObservable<CharSequence> queryChanges(
            @NonNull SmartSearchView view) {
        return queryChanges(view, 1);
    }

    @CheckResult
    @NonNull
    public static InitialValueObservable<CharSequence> queryChanges(
            @NonNull SmartSearchView view, int characterLimit) {
        checkNotNull(view, "view == null");
        return new QueryObservable(view, characterLimit);
    }

    public static void checkNotNull(Object value, String message) {
        if (value == null) {
            throw new NullPointerException(message);
        }
    }
}
