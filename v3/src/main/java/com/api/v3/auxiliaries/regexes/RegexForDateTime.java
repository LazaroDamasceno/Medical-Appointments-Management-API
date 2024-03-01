package com.api.v3.auxiliaries.regexes;

public interface RegexForDateTime {
   
    static String get() {
        return "[1-3][0-9]/[0-9][0-2]/[2][0][0-9][0-9] [0-2][0-4]:[0-5][0-9]:[0-5][0-9]";
    }

}
