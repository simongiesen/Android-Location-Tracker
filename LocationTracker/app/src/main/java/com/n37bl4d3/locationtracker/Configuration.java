package com.n37bl4d3.locationtracker;

import java.io.File;

public class Configuration {

    public static File sFilesDir;
    public static String sFilesDirPath;

    public static File sCacheDir;
    public static String sCacheDirPath;

    public static String sApplicationName;

    public static String sOptionsTabFragmentPageTitle;
    public static String sUpdatesTabFragmentPageTitle;

    public static final boolean LOGGING_VERBOSE = true;
    public static final boolean LOGGING_VERBOSE_SAVE = true;

    public static final boolean LOGGING_DEBUG = true;
    public static final boolean LOGGING_DEBUG_SAVE = true;

    public static final boolean LOGGING_INFO = true;
    public static final boolean LOGGING_INFO_SAVE = true;

    public static final boolean LOGGING_WARN = true;
    public static final boolean LOGGING_WARN_SAVE = true;

    public static final boolean LOGGING_ERROR = true;
    public static final boolean LOGGING_ERROR_SAVE = true;

    public static boolean sIsFeatureLocationAvailable;
    public static boolean sIsFeatureLocationNetworkAvailable;
    public static boolean sIsFeatureLocationGpsAvailable;
}
