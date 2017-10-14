package com.arlib.floatingsearchview.rxbinding

import com.chivorn.hum.rxbinding.RxFloatingSearchView
import com.chivorn.hum.smartsearchview.SmartSearchView;
import com.jakewharton.rxbinding2.InitialValueObservable

inline fun SmartSearchView.queryChanges(minQueryLimit: Int = 1): InitialValueObservable<CharSequence> = RxFloatingSearchView.queryChanges(this, minQueryLimit)