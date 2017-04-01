package com.n37bl4d3.locationtracker.helpers;

import android.util.Log;

import com.n37bl4d3.locationtracker.Configuration;

import java.io.File;
import java.io.FileWriter;

public class LogHelper {

    public static void verboseLog(String msg) {
        if (Configuration.LOGGING_VERBOSE) {
            try {
                Log.v(Configuration.sApplicationName, msg);
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (Configuration.LOGGING_VERBOSE_SAVE) {
                saveLog(Log.VERBOSE, Configuration.sApplicationName, msg);
            }
        }
    }

    public static void verboseLog(String tag, String msg) {
        if (Configuration.LOGGING_VERBOSE) {
            try {
                Log.v(tag, msg);
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (Configuration.LOGGING_VERBOSE_SAVE) {
                saveLog(Log.VERBOSE, tag, msg);
            }
        }
    }

    public static void debugLog(String msg) {
        if (Configuration.LOGGING_DEBUG) {
            try {
                Log.d(Configuration.sApplicationName, msg);
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (Configuration.LOGGING_DEBUG_SAVE) {
                saveLog(Log.DEBUG, Configuration.sApplicationName, msg);
            }
        }
    }

    public static void debugLog(String tag, String msg) {
        if (Configuration.LOGGING_DEBUG) {
            try {
                Log.d(tag, msg);
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (Configuration.LOGGING_DEBUG_SAVE) {
                saveLog(Log.DEBUG, tag, msg);
            }
        }
    }

    public static void infoLog(String msg) {
        if (Configuration.LOGGING_INFO) {
            try {
                Log.i(Configuration.sApplicationName, msg);
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (Configuration.LOGGING_INFO_SAVE) {
                saveLog(Log.INFO, Configuration.sApplicationName, msg);
            }
        }
    }

    public static void infoLog(String tag, String msg) {
        if (Configuration.LOGGING_INFO) {
            try {
                Log.i(tag, msg);
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (Configuration.LOGGING_INFO_SAVE) {
                saveLog(Log.INFO, tag, msg);
            }
        }
    }

    public static void warnLog(String msg) {
        if (Configuration.LOGGING_WARN) {
            try {
                Log.w(Configuration.sApplicationName, msg);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (Configuration.LOGGING_WARN_SAVE) {
            saveLog(Log.WARN, Configuration.sApplicationName, msg);
        }
    }

    public static void warnLog(String tag, String msg) {
        if (Configuration.LOGGING_WARN) {
            try {
                Log.w(tag, msg);
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (Configuration.LOGGING_WARN_SAVE) {
                saveLog(Log.WARN, tag, msg);
            }
        }
    }

    public static void errorLog(String msg) {
        if (Configuration.LOGGING_ERROR) {
            try {
                Log.e(Configuration.sApplicationName, msg);
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (Configuration.LOGGING_ERROR_SAVE) {
                saveLog(Log.ERROR, Configuration.sApplicationName, msg);
            }
        }
    }

    public static void errorLog(String tag, String msg) {
        if (Configuration.LOGGING_ERROR) {
            try {
                Log.e(tag, msg);
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (Configuration.LOGGING_ERROR_SAVE) {
                saveLog(Log.ERROR, tag, msg);
            }
        }
    }

    private static void saveLog(int verbosity, String tag, String msg) {
        try {
            File saveLogDirectoryFile = new File(Configuration.sFilesDirPath + File.separator + LogHelper.class.getSimpleName());
            if (saveLogDirectoryFile.exists()) {
                FileWriter fileWriter;

                switch (verbosity) {
                    case Log.VERBOSE:
                        fileWriter = new FileWriter(Configuration.sFilesDirPath + File.separator + LogHelper.class.getSimpleName() + File.separator + "verboseLog.log", true);
                        fileWriter.write(System.currentTimeMillis() + "; Tag: " + tag + "; Msg: " + msg + System.lineSeparator());
                        fileWriter.close();

                        break;
                    case Log.DEBUG:
                        fileWriter = new FileWriter(Configuration.sFilesDirPath + File.separator + LogHelper.class.getSimpleName() + File.separator + "debugLog.log", true);
                        fileWriter.write(System.currentTimeMillis() + "; Tag: " + tag + "; Msg: " + msg + System.lineSeparator());
                        fileWriter.close();

                        break;
                    case Log.INFO:
                        fileWriter = new FileWriter(Configuration.sFilesDirPath + File.separator + LogHelper.class.getSimpleName() + File.separator + "infoLog.log", true);
                        fileWriter.write(System.currentTimeMillis() + "; Tag: " + tag + "; Msg: " + msg + System.lineSeparator());
                        fileWriter.close();

                        break;
                    case Log.WARN:
                        fileWriter = new FileWriter(Configuration.sFilesDirPath + File.separator + LogHelper.class.getSimpleName() + File.separator + "warnLog.log", true);
                        fileWriter.write(System.currentTimeMillis() + "; Tag: " + tag + "; Msg: " + msg + System.lineSeparator());
                        fileWriter.close();

                        break;
                    case Log.ERROR:
                        fileWriter = new FileWriter(Configuration.sFilesDirPath + File.separator + LogHelper.class.getSimpleName() + File.separator + "errorLog.log", true);
                        fileWriter.write(System.currentTimeMillis() + "; Tag: " + tag + "; Msg: " + msg + System.lineSeparator());
                        fileWriter.close();

                        break;
                }
            } else {
                if (saveLogDirectoryFile.mkdirs()) {
                    if (saveLogDirectoryFile.exists()) {
                        FileWriter fileWriter;

                        switch (verbosity) {
                            case Log.VERBOSE:
                                fileWriter = new FileWriter(Configuration.sFilesDirPath + File.separator + LogHelper.class.getSimpleName() + File.separator + "verbose.log", true);
                                fileWriter.write(System.currentTimeMillis() + "; Tag: " + tag + "; Msg: " + msg + System.lineSeparator());
                                fileWriter.close();

                                break;
                            case Log.DEBUG:
                                fileWriter = new FileWriter(Configuration.sFilesDirPath + File.separator + LogHelper.class.getSimpleName() + File.separator + "debug.log", true);
                                fileWriter.write(System.currentTimeMillis() + "; Tag: " + tag + "; Msg: " + msg + System.lineSeparator());
                                fileWriter.close();

                                break;
                            case Log.INFO:
                                fileWriter = new FileWriter(Configuration.sFilesDirPath + File.separator + LogHelper.class.getSimpleName() + File.separator + "info.log", true);
                                fileWriter.write(System.currentTimeMillis() + "; Tag: " + tag + "; Msg: " + msg + System.lineSeparator());
                                fileWriter.close();

                                break;
                            case Log.WARN:
                                fileWriter = new FileWriter(Configuration.sFilesDirPath + File.separator + LogHelper.class.getSimpleName() + File.separator + "warn.log", true);
                                fileWriter.write(System.currentTimeMillis() + "; Tag: " + tag + "; Msg: " + msg + System.lineSeparator());
                                fileWriter.close();

                                break;
                            case Log.ERROR:
                                fileWriter = new FileWriter(Configuration.sFilesDirPath + File.separator + LogHelper.class.getSimpleName() + File.separator + "error.log", true);
                                fileWriter.write(System.currentTimeMillis() + "; Tag: " + tag + "; Msg: " + msg + System.lineSeparator());
                                fileWriter.close();

                                break;
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
