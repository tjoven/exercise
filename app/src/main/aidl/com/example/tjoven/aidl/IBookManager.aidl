// IBookManager.aidl
package com.example.tjoven.aidl;
import com.example.tjoven.aidl.Book;
import com.example.tjoven.aidl.IOnAddNewBookListener;
// Declare any non-default types here with import statements

interface IBookManager {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);

    List<Book> getBookList();
    void addBook(in Book book);
    void registerLisener(IOnAddNewBookListener listener);
    void unregisterLisener(IOnAddNewBookListener listener);
}
