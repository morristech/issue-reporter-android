package com.cookpad.android.issuereporter;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.cookpad.android.issuereporter.fragment.IssueReporterFragment;

public class IssueReporter {
    public static IssueReporterFragment apply(FragmentActivity activity, ReportMail reportMail) {
        FragmentManager fragmentManager = activity.getSupportFragmentManager();
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
