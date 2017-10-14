# SmartSearchView
# Usage
### Add the dependencies to your gradle file:

```gradle
dependencies {
    compile 'com.github.chivorns:smartsearchview:1.0.1'
}
```

### Add SmartSearchView to your layout:

```xml
<com.chivorn.hum.smartsearchview.SmartSearchView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:smsv_searchBarMarginLeft="0dp"
        app:smsv_searchBarMarginTop="0dp"
        app:smsv_searchBarMarginRight="0dp"
        app:smsv_searchHint="Search..."
        app:smsv_suggestionsListAnimDuration="250"
        app:smsv_showSearchKey="false"
        app:smsv_leftActionMode="showSearch"
        app:smsv_menu="@menu/search_menu"
        app:smsv_close_search_on_keyboard_dismiss="true"
        app:smsv_showVoiceInput="true">
</com.chivorn.hum.smartsearchview.SmartSearchView>
```
