package com.n37bl4d3.locationtracker;

import android.app.Application;
import android.content.pm.PackageManager;

import com.n37bl4d3.locationtracker.helpers.LogHelper;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class BaseApplication extends Application {

    private static final String TAG = BaseApplication.class.getName();

    @Override
    public void onCreate() {
        Configuration.sFilesDirMemory = getFilesDir();
        Configuration.sFilesDirPathMemory = getFilesDir().getPath();

        Configuration.sCacheDirMemory = getCacheDir();
        Configuration.sCacheDirPathMemory = getCacheDir().getPath();

        super.onCreate();
        LogHelper.verboseLog(TAG,
                "File name: \"" +
                        Thread.currentThread().getStackTrace()[2].getFileName() +
                        "\", Line number: " +
                        Thread.currentThread().getStackTrace()[2].getLineNumber() +
                        ", Class name: \"" +
                        Thread.currentThread().getStackTrace()[2].getClassName() +
                        "\", Method name: \"" +
                        Thread.currentThread().getStackTrace()[2].getMethodName() +
                        "\"");

        Configuration.sApplicationName = getString(R.string.app_name);

        Configuration.sOptionsTabFragmentPageTitle = getString(R.string.options);
        Configuration.sUpdatesTabFragmentPageTitle = getString(R.string.updates);

        Realm.init(this);

        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder().build();

        try {
            Realm.setDefaultConfiguration(realmConfiguration);
        } catch (Exception e) {
            LogHelper.errorLog(TAG, e.getMessage());
            e.printStackTrace();
        }

        PackageManager packageManager = getPackageManager();

        if (packageManager.hasSystemFeature(PackageManager.FEATURE_LOCATION)) {
            LogHelper.infoLog(TAG, "Feature \"" + PackageManager.FEATURE_LOCATION + "\" is available");

            Configuration.sIsFeatureLocationAvailable = true;
        } else {
            LogHelper.warnLog(TAG, "Feature \"" + PackageManager.FEATURE_LOCATION + "\" is not available");

            Configuration.sIsFeatureLocationAvailable = false;
        }
        if (packageManager.hasSystemFeature(PackageManager.FEATURE_LOCATION_NETWORK)) {
            LogHelper.infoLog(TAG, "Feature \"" + PackageManager.FEATURE_LOCATION_NETWORK + "\" is available");

            Configuration.sIsFeatureLocationNetworkAvailable = true;
        } else {
            LogHelper.warnLog(TAG, "Feature \"" + PackageManager.FEATURE_LOCATION_NETWORK + "\" is not available");

            Configuration.sIsFeatureLocationNetworkAvailable = false;
        }
        if (packageManager.hasSystemFeature(PackageManager.FEATURE_LOCATION_GPS)) {
            LogHelper.infoLog(TAG, "Feature \"" + PackageManager.FEATURE_LOCATION_GPS + "\" is available");

            Configuration.sIsFeatureLocationGpsAvailable = true;
        } else {
            LogHelper.warnLog(TAG, "Feature \"" + PackageManager.FEATURE_LOCATION_GPS + "\" is not available");

            Configuration.sIsFeatureLocationGpsAvailable = false;
        }
    }
}
