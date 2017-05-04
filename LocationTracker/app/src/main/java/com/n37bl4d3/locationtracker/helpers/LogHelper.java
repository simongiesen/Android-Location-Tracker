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
                logSave(Log.VERBOSE, Configuration.sApplicationName, msg);
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
                logSave(Log.VERBOSE, tag, msg);
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
                logSave(Log.DEBUG, Configuration.sApplicationName, msg);
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
                logSave(Log.DEBUG, tag, msg);
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
                logSave(Log.INFO, Configuration.sApplicationName, msg);
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
                logSave(Log.INFO, tag, msg);
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

            if (Configuration.LOGGING_WARN_SAVE) {
                logSave(Log.WARN, Configuration.sApplicationName, msg);
            }
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
                logSave(Log.WARN, tag, msg);
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
                logSave(Log.ERROR, Configuration.sApplicationName, msg);
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
                logSave(Log.ERROR, tag, msg);
            }
        }
    }

    private static void verboseLogSave(String tag, String msg) {
        FileWriter fileWriter;

        try {
            fileWriter = new FileWriter(Configuration.sFilesDirPathMemory + File.separator + LogHelper.class.getSimpleName() + File.separator + Configuration.LOGGING_VERBOSE_SAVE_FILE_NAME, true);
            fileWriter.write(System.currentTimeMillis() + "; Tag: " + tag + "; Msg: " + msg + System.lineSeparator());
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void debugLogSave(String tag, String msg) {
        FileWriter fileWriter;

        try {
            fileWriter = new FileWriter(Configuration.sFilesDirPathMemory + File.separator + LogHelper.class.getSimpleName() + File.separator + Configuration.LOGGING_DEBUG_SAVE_FILE_NAME, true);
            fileWriter.write(System.currentTimeMillis() + "; Tag: " + tag + "; Msg: " + msg + System.lineSeparator());
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void infoLogSave(String tag, String msg) {
        FileWriter fileWriter;

        try {
            fileWriter = new FileWriter(Configuration.sFilesDirPathMemory + File.separator + LogHelper.class.getSimpleName() + File.separator + Configuration.LOGGING_INFO_SAVE_FILE_NAME, true);
            fileWriter.write(System.currentTimeMillis() + "; Tag: " + tag + "; Msg: " + msg + System.lineSeparator());
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void warnLogSave(String tag, String msg) {
        FileWriter fileWriter;

        try {
            fileWriter = new FileWriter(Configuration.sFilesDirPathMemory + File.separator + LogHelper.class.getSimpleName() + File.separator + Configuration.LOGGING_WARN_SAVE_FILE_NAME, true);
            fileWriter.write(System.currentTimeMillis() + "; Tag: " + tag + "; Msg: " + msg + System.lineSeparator());
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void errorLogSave(String tag, String msg) {
        FileWriter fileWriter;

        try {
            fileWriter = new FileWriter(Configuration.sFilesDirPathMemory + File.separator + LogHelper.class.getSimpleName() + File.separator + Configuration.LOGGING_ERROR_SAVE_FILE_NAME, true);
            fileWriter.write(System.currentTimeMillis() + "; Tag: " + tag + "; Msg: " + msg + System.lineSeparator());
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void logSave(int verbosity, String tag, String msg) {
        File logSaveDirs = new File(Configuration.sFilesDirPathMemory + File.separator + LogHelper.class.getSimpleName());

        File verboseLogSaveFile = new File(Configuration.sFilesDirPathMemory + File.separator + LogHelper.class.getSimpleName() + File.separator + Configuration.LOGGING_VERBOSE_SAVE_FILE_NAME);
        File debugLogSaveFile = new File(Configuration.sFilesDirPathMemory + File.separator + LogHelper.class.getSimpleName() + File.separator + Configuration.LOGGING_DEBUG_SAVE_FILE_NAME);
        File infoLogSaveFile = new File(Configuration.sFilesDirPathMemory + File.separator + LogHelper.class.getSimpleName() + File.separator + Configuration.LOGGING_INFO_SAVE_FILE_NAME);
        File warnLogSaveFile = new File(Configuration.sFilesDirPathMemory + File.separator + LogHelper.class.getSimpleName() + File.separator + Configuration.LOGGING_WARN_SAVE_FILE_NAME);
        File errorLogSaveFile = new File(Configuration.sFilesDirPathMemory + File.separator + LogHelper.class.getSimpleName() + File.separator + Configuration.LOGGING_ERROR);

        try {
            if (logSaveDirs.exists() && logSaveDirs.isDirectory()) {
                switch (verbosity) {
                    case Log.VERBOSE:
                        if (verboseLogSaveFile.exists() && verboseLogSaveFile.isFile()) {
                            verboseLogSave(tag, msg);
                        } else {
                            if (verboseLogSaveFile.createNewFile()) {
                                verboseLogSave(tag, msg);
                            } else {
                                System.out.println("Will not save log, file \"" + Configuration.sFilesDirPathMemory + File.separator + LogHelper.class.getSimpleName() + File.separator + Configuration.LOGGING_VERBOSE_SAVE_FILE_NAME + "\" not exists");
                            }
                        }

                        break;
                    case Log.DEBUG:
                        if (debugLogSaveFile.exists() && debugLogSaveFile.isFile()) {
                            debugLogSave(tag, msg);
                        } else {
                            if (debugLogSaveFile.createNewFile()) {
                                debugLogSave(tag, msg);
                            } else {
                                System.out.println("Will not save log, file \"" + Configuration.sFilesDirPathMemory + File.separator + LogHelper.class.getSimpleName() + File.separator + Configuration.LOGGING_DEBUG_SAVE_FILE_NAME + "\" not exists");
                            }
                        }

                        break;
                    case Log.INFO:
                        if (infoLogSaveFile.exists() && infoLogSaveFile.isFile()) {
                            infoLogSave(tag, msg);
                        } else {
                            if (infoLogSaveFile.createNewFile()) {
                                infoLogSave(tag, msg);
                            } else {
                                System.out.println("Will not save log, file \"" + Configuration.sFilesDirPathMemory + File.separator + LogHelper.class.getSimpleName() + File.separator + Configuration.LOGGING_INFO_SAVE_FILE_NAME + "\" not exists");
                            }
                        }

                        break;
                    case Log.WARN:
                        if (warnLogSaveFile.exists() && warnLogSaveFile.isFile()) {
                            warnLogSave(tag, msg);
                        } else {
                            if (warnLogSaveFile.createNewFile()) {
                                warnLogSave(tag, msg);
                            } else {
                                System.out.println("Will not save log, file \"" + Configuration.sFilesDirPathMemory + File.separator + LogHelper.class.getSimpleName() + File.separator + Configuration.LOGGING_WARN_SAVE_FILE_NAME + "\" not exists");
                            }
                        }

                        break;
                    case Log.ERROR:
                        if (errorLogSaveFile.exists() && errorLogSaveFile.isFile()) {
                            errorLogSave(tag, msg);
                        } else {
                            if (errorLogSaveFile.createNewFile()) {
                                errorLogSave(tag, msg);
                            } else {
                                System.out.println("Will not save log, file \"" + Configuration.sFilesDirPathMemory + File.separator + LogHelper.class.getSimpleName() + File.separator + Configuration.LOGGING_ERROR_SAVE_FILE_NAME + "\" not exists");
                            }
                        }

                        break;
                }
            } else {
                if (logSaveDirs.mkdirs()) {
                    switch (verbosity) {
                        case Log.VERBOSE:
                            if (verboseLogSaveFile.exists() && verboseLogSaveFile.isFile()) {
                                verboseLogSave(tag, msg);
                            } else {
                                if (verboseLogSaveFile.createNewFile()) {
                                    verboseLogSave(tag, msg);
                                } else {
                                    System.out.println("Will not save log, file \"" + Configuration.sFilesDirPathMemory + File.separator + LogHelper.class.getSimpleName() + File.separator + Configuration.LOGGING_VERBOSE_SAVE_FILE_NAME + "\" not exists");
                                }
                            }

                            break;
                        case Log.DEBUG:
                            if (debugLogSaveFile.exists() && debugLogSaveFile.isFile()) {
                                debugLogSave(tag, msg);
                            } else {
                                if (debugLogSaveFile.createNewFile()) {
                                    debugLogSave(tag, msg);
                                } else {
                                    System.out.println("Will not save log, file \"" + Configuration.sFilesDirPathMemory + File.separator + LogHelper.class.getSimpleName() + File.separator + Configuration.LOGGING_DEBUG_SAVE_FILE_NAME + "\" not exists");
                                }
                            }

                            break;
                        case Log.INFO:
                            if (infoLogSaveFile.exists() && infoLogSaveFile.isFile()) {
                                infoLogSave(tag, msg);
                            } else {
                                if (infoLogSaveFile.createNewFile()) {
                                    infoLogSave(tag, msg);
                                } else {
                                    System.out.println("Will not save log, file \"" + Configuration.sFilesDirPathMemory + File.separator + LogHelper.class.getSimpleName() + File.separator + Configuration.LOGGING_INFO_SAVE_FILE_NAME + "\" not exists");
                                }
                            }

                            break;
                        case Log.WARN:
                            if (warnLogSaveFile.exists() && warnLogSaveFile.isFile()) {
                                warnLogSave(tag, msg);
                            } else {
                                if (warnLogSaveFile.createNewFile()) {
                                    warnLogSave(tag, msg);
                                } else {
                                    System.out.println("Will not save log, file \"" + Configuration.sFilesDirPathMemory + File.separator + LogHelper.class.getSimpleName() + File.separator + Configuration.LOGGING_WARN_SAVE_FILE_NAME + "\" not exists");
                                }
                            }

                            break;
                        case Log.ERROR:
                            if (errorLogSaveFile.exists() && errorLogSaveFile.isFile()) {
                                errorLogSave(tag, msg);
                            } else {
                                if (errorLogSaveFile.createNewFile()) {
                                    errorLogSave(tag, msg);
                                } else {
                                    System.out.println("Will not save log, file \"" + Configuration.sFilesDirPathMemory + File.separator + LogHelper.class.getSimpleName() + File.separator + Configuration.LOGGING_ERROR_SAVE_FILE_NAME + "\" not exists");
                                }
                            }

                            break;
                    }
                } else {
                    System.out.println("Will not save log files, directory \"" + Configuration.sFilesDirPathMemory + File.separator + LogHelper.class.getSimpleName() + "\" not exists");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
