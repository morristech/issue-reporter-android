package com.cookpad.android.issuereporter;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Build;
import android.support.v4.app.FragmentActivity;

import com.cookpad.android.issuereporter.fragment.IssueReporterFragment;

public class IssueReporter {
    public static com.cookpad.android.issuereporter.support.fragment.IssueReporterFragment apply(FragmentActivity activity, ReportMail reportMail) {
        android.support.v4.app.FragmentManager fragmentManager = activity.getSupportFragmentManager();
        com.cookpad.android.issuereporter.support.fragment.IssueReporterFragment fragment =
                (com.cookpad.android.issuereporter.support.fragment.IssueReporterFragment) fragmentManager.findFragmentByTag(
                        com.cookpad.android.issuereporter.support.fragment.IssueReporterFragment.FRAGMENT_TAG);
        if (fragment != null) {
            return fragment;
        }

        fragment = com.cookpad.android.issuereporter.support.fragment.IssueReporterFragment.newInstance(reportMail);
        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(fragment, com.cookpad.android.issuereporter.support.fragment.IssueReporterFragment.class.getName());
        fragmentTransaction.commit();

        return fragment;
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static IssueReporterFragment apply(Activity activity, ReportMail reportMail) {
        FragmentManager fragmentManager = activity.getFragmentManager();
        IssueReporterFragment fragment =
                (IssueReporterFragment) fragmentManager.findFragmentByTag(IssueReporterFragment.FRAGMENT_TAG);
        if (fragment != null) {
            return fragment;
        }

        fragment = IssueReporterFragment.newInstance(reportMail);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(fragment, IssueReporterFragment.class.getName());
        fragmentTransaction.commit();

        return fragment;
    }
}
