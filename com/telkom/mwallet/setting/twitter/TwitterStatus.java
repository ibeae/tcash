package com.telkom.mwallet.setting.twitter;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.skcc.wallet.core.p057a.C1216a;
import com.skcc.wallet.framework.p062d.C1323c;
import com.telkom.mwallet.R;
import com.telkom.mwallet.slidingframe.SlidingFrameActivity;
import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.auth.AccessToken;

public class TwitterStatus extends SlidingFrameActivity {
    private static SharedPreferences f4260A;
    static String f4261n = "twitter_oauth";
    EditText f4262k;
    Button f4263l;
    Button f4264m;
    protected C1323c f4265o;
    private String f4266z = null;

    class C16851 implements OnClickListener {
        final /* synthetic */ TwitterStatus f4253a;

        C16851(TwitterStatus twitterStatus) {
            this.f4253a = twitterStatus;
        }

        public void onClick(View view) {
            if (C1703d.f4296c != null) {
                C1703d.f4296c.m6413e();
            }
            this.f4253a.finish();
        }
    }

    class C16862 implements OnClickListener {
        final /* synthetic */ TwitterStatus f4254a;

        C16862(TwitterStatus twitterStatus) {
            this.f4254a = twitterStatus;
        }

        public void onClick(View view) {
            String obj = this.f4254a.f4262k.getText().toString();
            C1216a.m4519a("gg", "status:" + obj.toString());
            if (obj == null || obj.length() <= 140) {
                new C1690a(this.f4254a).execute(new String[]{obj});
                return;
            }
            C1216a.m4522b("TwitterStatus", "Status length (" + obj.length() + ") is over 140");
            Toast.makeText(this.f4254a.getApplicationContext(), R.string.tweeter_err_status_over_maximum, 0).show();
        }
    }

    class C1690a extends AsyncTask<String, String, String> {
        final /* synthetic */ TwitterStatus f4259a;

        class C16882 implements Runnable {
            final /* synthetic */ C1690a f4257a;

            C16882(C1690a c1690a) {
                this.f4257a = c1690a;
            }

            public void run() {
                Toast.makeText(this.f4257a.f4259a.getApplicationContext(), this.f4257a.f4259a.getString(R.string.tweeter_tweet_succ), 0).show();
                this.f4257a.f4259a.finish();
            }
        }

        class C16893 implements Runnable {
            final /* synthetic */ C1690a f4258a;

            C16893(C1690a c1690a) {
                this.f4258a = c1690a;
            }

            public void run() {
                Toast.makeText(this.f4258a.f4259a.getApplicationContext(), this.f4258a.f4259a.getString(R.string.tweeter_tweet_fail), 0).show();
            }
        }

        C1690a(TwitterStatus twitterStatus) {
            this.f4259a = twitterStatus;
        }

        protected String m6372a(String... strArr) {
            C1216a.m4519a("Tweet Text", "> " + strArr[0]);
            String str = strArr[0];
            String str2 = "";
            try {
                Twitter twitter = C1703d.f4295b;
                String string = TwitterStatus.f4260A.getString("oauth_token", "");
                String string2 = TwitterStatus.f4260A.getString("oauth_token_secret", "");
                C1216a.m4522b("TwitterStatus", "AT> " + string);
                C1216a.m4522b("TwitterStatus", "AT secret> " + string2);
                twitter.setOAuthAccessToken(new AccessToken(string, string2));
                StatusUpdate statusUpdate = new StatusUpdate(str);
                if (this.f4259a.f4266z != null) {
                    statusUpdate.setMedia(this.f4259a.f4265o.m4825a(this.f4259a.f4266z));
                }
                C1216a.m4519a("Status", "> " + twitter.updateStatus(statusUpdate).getText());
                return str2;
            } catch (final TwitterException e) {
                C1216a.m4522b("TwitterStatus", e.getMessage());
                C1216a.m4522b("TwitterStatus", e.getErrorMessage());
                this.f4259a.runOnUiThread(new Runnable(this) {
                    final /* synthetic */ C1690a f4256b;

                    public void run() {
                        Toast.makeText(this.f4256b.f4259a.getApplicationContext(), e.getErrorMessage(), 0).show();
                    }
                });
                return null;
            }
        }

        protected void m6373a(String str) {
            C1216a.m4519a("TwitterStatus", "onPostExecute>> " + str);
            if (str != null) {
                this.f4259a.runOnUiThread(new C16882(this));
            } else {
                this.f4259a.runOnUiThread(new C16893(this));
            }
        }

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m6372a((String[]) objArr);
        }

        protected /* synthetic */ void onPostExecute(Object obj) {
            m6373a((String) obj);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m5021b((int) R.layout.twitter_post);
        C1216a.m4522b("TwitterStatus", "Created");
        this.f4262k = (EditText) findViewById(R.id.contentEdit);
        this.f4263l = (Button) findViewById(R.id.postBtn);
        this.f4264m = (Button) findViewById(R.id.logoutBtn);
        this.f4264m.setOnClickListener(new C16851(this));
        f4260A = getApplicationContext().getSharedPreferences("twitterpref", 0);
        this.f4263l.setOnClickListener(new C16862(this));
        this.f4265o = new C1323c(this);
        this.f4265o.m4826a();
    }
}
