package com.api.v3.auxiliaries.regexes;

public interface RegexForSsn {
    
    static String get() {
        return "[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]";
    }

}