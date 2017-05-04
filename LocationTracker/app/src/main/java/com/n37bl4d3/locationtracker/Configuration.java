package com.n37bl4d3.locationtracker;

import java.io.File;

public class Configuration {

    public static File sFilesDirMemory;
    public static String sFilesDirPathMemory;

    public static File sCacheDirMemory;
    public static String sCacheDirPathMemory;

    public static String sApplicationName;

    public static String sOptionsTabFragmentPageTitle;
    public static String sUpdatesTabFragmentPageTitle;

    public static final boolean LOGGING_VERBOSE = true;
    public static final boolean LOGGING_VERBOSE_SAVE = true;
    public static final String LOGGING_VERBOSE_SAVE_FILE_NAME = "verboseLog.log";

    public static final boolean LOGGING_DEBUG = true;
    public static final boolean LOGGING_DEBUG_SAVE = true;
    public static final String LOGGING_DEBUG_SAVE_FILE_NAME = "debugLog.log";

    public static final boolean LOGGING_INFO = true;
    public static final boolean LOGGING_INFO_SAVE = true;
    public static final String LOGGING_INFO_SAVE_FILE_NAME = "infoLog.log";

    public static final boolean LOGGING_WARN = true;
    public static final boolean LOGGING_WARN_SAVE = true;
    public static final String LOGGING_WARN_SAVE_FILE_NAME = "warnLog.log";

    public static final boolean LOGGING_ERROR = true;
    public static final boolean LOGGING_ERROR_SAVE = true;
    public static final String LOGGING_ERROR_SAVE_FILE_NAME = "errorLog.log";

    public static boolean sIsFeatureLocationAvailable;
    public static boolean sIsFeatureLocationNetworkAvailable;
    public static boolean sIsFeatureLocationGpsAvailable;
}
