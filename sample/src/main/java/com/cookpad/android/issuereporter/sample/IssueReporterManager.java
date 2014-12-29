package com.cookpad.android.issuereporter.sample;

import android.app.Activity;
import android.app.Application;
import android.support.v4.app.FragmentActivity;

import com.cookpad.android.issuereporter.IssueReporter;
import com.cookpad.android.issuereporter.ReportMail;

public class IssueReporterManager {
    private static IssueReporterManager INSTANCE;

    private ReportMail reportMail;

    private ActivityLifecycleCallbacksAdapter activityLifecycleCallbacksAdapter;
    private ActivityLifecycleCallbacksAdapter.Callback callback = new ActivityLifecycleCallbacksAdapter.Callback() {
        @Override
        public void onCreated(Activity activity) {
            if (activity instanceof FragmentActivity) {
                IssueReporter.apply((FragmentActivity) activity, reportMail);
            }
        }
    };

    public IssueReporterManager(Application application, ReportMail reportMail) {
        this.reportMail = reportMail;
        this.activityLifecycleCallbacksAdapter = new ActivityLifecycleCallbacksAdapter(application, callback);
    }

    public static synchronized void start(Application application, ReportMail reportMail) {
        if (INSTANCE == null) {
            INSTANCE = new IssueReporterManager(application, reportMail);
        }
    }

    public static synchronized void stop(Application application) {
        if (INSTANCE != null) {
            INSTANCE.activityLifecycleCallbacksAdapter.unregister(application);
            INSTANCE = null;
        }
    }
}
