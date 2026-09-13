package de.blinkt.openvpn;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

// Diagnostic-only: shows the stack trace of whatever crashed the app instead
// of just letting Android kill the process silently, so it can be read
// (and copied) straight off the device with no computer/ADB needed. Wired
// up from VPNLaunchHelper.startOpenVpn's default-uncaught-exception-handler
// install. Remove once the official-source replacement is confirmed stable.
public class CrashReportActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String trace = getIntent().getStringExtra("trace");
        TextView tv = new TextView(this);
        tv.setText(trace != null ? trace : "(no trace)");
        tv.setTextIsSelectable(true);
        tv.setPadding(32, 32, 32, 32);
        tv.setMovementMethod(new ScrollingMovementMethod());
        ScrollView sv = new ScrollView(this);
        sv.addView(tv, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        setContentView(sv);
    }
}
