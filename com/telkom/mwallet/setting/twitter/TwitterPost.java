package com.telkom.mwallet.setting.twitter;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.internal.NativeProtocol;
import com.skcc.wallet.core.p057a.C1216a;
import com.skcc.wallet.framework.p062d.C1323c;
import com.telkom.mwallet.R;
import com.telkom.mwallet.slidingframe.SlidingFrameActivity;
import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.auth.AccessToken;

public class TwitterPost extends SlidingFrameActivity {
    private static SharedPreferences f4246A;
    static String f4247n = "twitter_oauth";
    EditText f4248k;
    TextView f4249l;
    Button f4250m;
    protected C1323c f4251o;
    private String f4252z = null;

    class C1684a extends AsyncTask<String, String, String> {
        final /* synthetic */ TwitterPost f4245a;

        class C16822 implements Runnable {
            final /* synthetic */ C1684a f4243a;

            C16822(C1684a c1684a) {
                this.f4243a = c1684a;
            }

            public void run() {
                Toast.makeText(this.f4243a.f4245a.getApplicationContext(), this.f4243a.f4245a.getString(R.string.tweeter_tweet_succ), 0).show();
                this.f4243a.f4245a.finish();
            }
        }

        class C16833 implements Runnable {
            final /* synthetic */ C1684a f4244a;

            C16833(C1684a c1684a) {
                this.f4244a = c1684a;
            }

            public void run() {
                Toast.makeText(this.f4244a.f4245a.getApplicationContext(), this.f4244a.f4245a.getString(R.string.tweeter_tweet_fail), 0).show();
            }
        }

        C1684a(TwitterPost twitterPost) {
            this.f4245a = twitterPost;
        }

        protected String m6368a(String... strArr) {
            C1216a.m4519a("Tweet Text", "> " + strArr[0]);
            String str = strArr[0];
            String str2 = "";
            try {
                Twitter twitter = C1703d.f4295b;
                String string = TwitterPost.f4246A.getString("oauth_token", "");
                String string2 = TwitterPost.f4246A.getString("oauth_token_secret", "");
                C1216a.m4522b("TwitterPost", "AT> " + string);
                C1216a.m4522b("TwitterPost", "AT secret> " + string2);
                twitter.setOAuthAccessToken(new AccessToken(string, string2));
                StatusUpdate statusUpdate = new StatusUpdate(str);
                if (this.f4245a.f4252z != null) {
                    statusUpdate.setMedia(this.f4245a.f4251o.m4825a(this.f4245a.f4252z));
                }
                C1216a.m4519a("Status", "> " + twitter.updateStatus(statusUpdate).getText());
                return str2;
            } catch (final TwitterException e) {
                C1216a.m4522b("TwitterPost", e.getMessage());
                C1216a.m4522b("TwitterPost", e.getErrorMessage());
                this.f4245a.runOnUiThread(new Runnable(this) {
                    final /* synthetic */ C1684a f4242b;

                    public void run() {
                        Toast.makeText(this.f4242b.f4245a.getApplicationContext(), e.getErrorMessage(), 0).show();
                    }
                });
                return null;
            }
        }

        protected void m6369a(String str) {
            C1216a.m4519a("TwitterPost", "onPostExecute>> " + str);
            if (str != null) {
                this.f4245a.runOnUiThread(new C16822(this));
            } else {
                this.f4245a.runOnUiThread(new C16833(this));
            }
        }

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m6368a((String[]) objArr);
        }

        protected /* synthetic */ void onPostExecute(Object obj) {
            m6369a((String) obj);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m5021b((int) R.layout.twitter_post);
        C1216a.m4522b("TwitterPost", "Created");
        this.f4249l = (TextView) findViewById(R.id.toEdit);
        this.f4248k = (EditText) findViewById(R.id.contentEdit);
        this.f4250m = (Button) findViewById(R.id.postBtn);
        f4246A = getApplicationContext().getSharedPreferences("twitterpref", 0);
        Intent intent = getIntent();
        intent.getStringExtra("to");
        CharSequence stringExtra = intent.getStringExtra("name");
        final String stringExtra2 = intent.getStringExtra("screenName");
        CharSequence stringExtra3 = intent.getStringExtra("BODY");
        if (!TextUtils.isEmpty(stringExtra3)) {
            this.f4248k.setText(stringExtra3);
        }
        this.f4252z = intent.getStringExtra(NativeProtocol.METHOD_ARGS_IMAGE);
        this.f4249l.setText(stringExtra);
        this.f4250m.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ TwitterPost f4240b;

            public void onClick(View view) {
                String str = "@" + stringExtra2 + " " + this.f4240b.f4248k.getText().toString();
                C1216a.m4519a("gg", "status:" + str.toString());
                if (str == null || str.length() <= 140) {
                    new C1684a(this.f4240b).execute(new String[]{str});
                    return;
                }
                C1216a.m4522b("TwitterPost", "Status length (" + str.length() + ") is over 140");
                Toast.makeText(this.f4240b.getApplicationContext(), R.string.tweeter_err_status_over_maximum, 0).show();
            }
        });
        this.f4251o = new C1323c(this);
        this.f4251o.m4826a();
    }
}
