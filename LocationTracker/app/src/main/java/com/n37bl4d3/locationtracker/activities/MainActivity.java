package com.n37bl4d3.locationtracker.activities;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.n37bl4d3.locationtracker.Configuration;
import com.n37bl4d3.locationtracker.R;
import com.n37bl4d3.locationtracker.adapters.TabLayoutFragmentPagerAdapter;
import com.n37bl4d3.locationtracker.fragments.OptionsTabFragment;
import com.n37bl4d3.locationtracker.fragments.UpdatesTabFragment;
import com.n37bl4d3.locationtracker.helpers.LogHelper;
import com.n37bl4d3.locationtracker.interfaces.ITabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ArrayList<ITabLayout> ITabLayoutArrayList = new ArrayList<>();
        ITabLayoutArrayList.add(new OptionsTabFragment());
        ITabLayoutArrayList.add(new UpdatesTabFragment());

        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        viewPager.setAdapter(new TabLayoutFragmentPagerAdapter(getSupportFragmentManager(), ITabLayoutArrayList));

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    protected void onStart() {
        super.onStart();
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

        if (Configuration.sIsFeatureLocationAvailable) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                final String[] permissions = {
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION
                };

                for (final String permission : permissions) {
                    if (checkSelfPermission(permission) == PackageManager.PERMISSION_DENIED) {
                        requestPermissions(permissions, 1);
                    }
                }
            }
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Location Feature Not Available");
            builder.setMessage("Your device does not have location feature.");
            builder.setNeutralButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    finish();
                }
            });
            builder.setCancelable(false);
            builder.show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        LogHelper.debugLog(TAG,
                "File name: \"" +
                        Thread.currentThread().getStackTrace()[2].getFileName() +
                        "\", Line number: " +
                        Thread.currentThread().getStackTrace()[2].getLineNumber() +
                        ", Class name: \"" +
                        Thread.currentThread().getStackTrace()[2].getClassName() +
                        "\", Method name: \"" +
                        Thread.currentThread().getStackTrace()[2].getMethodName() +
                        "\"");

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        LogHelper.debugLog(TAG,
                "File name: \"" +
                        Thread.currentThread().getStackTrace()[2].getFileName() +
                        "\", Line number: " +
                        Thread.currentThread().getStackTrace()[2].getLineNumber() +
                        ", Class name: \"" +
                        Thread.currentThread().getStackTrace()[2].getClassName() +
                        "\", Method name: \"" +
                        Thread.currentThread().getStackTrace()[2].getMethodName() +
                        "\"");

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
