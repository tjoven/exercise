// OnAddNewBookListener.aidl
package com.example.tjoven.aidl;
import com.example.tjoven.aidl.Book;

// Declare any non-default types here with import statements

interface IOnAddNewBookListener {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);

    void onAddNewBookListener(in Book book);
}
