// IRemoteService.aidl
package com.example.messageservicedemo;

// Declare any non-default types here with import statements

interface IRemoteService {
    String message(String aString);
    int getPid();
}
