package com.telkom.mwallet.setting.twitter;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.AsyncTask;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.skcc.wallet.core.p057a.C1216a;
import com.skcc.wallet.framework.api.C1265o;
import com.telkom.mwallet.C1359a;
import com.telkom.mwallet.R;
import java.util.ArrayList;
import twitter4j.IDs;
import twitter4j.ResponseList;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.ConfigurationBuilder;

public class C1703d {
    static String f4294a = "twitter_oauth";
    protected static Twitter f4295b;
    protected static C1703d f4296c = null;
    static long f4297e;
    static long[] f4298f;
    static String f4299g;
    static ArrayList<C1702a> f4300i = new ArrayList();
    private static RequestToken f4301k = null;
    private static String f4302l = null;
    private static C1359a f4303m;
    private static SharedPreferences f4304n;
    C1692a f4305d = new C1692a();
    User f4306h;
    C1265o f4307j = new C17014(this);

    class C16981 extends AsyncTask<Void, Void, Long> {
        final /* synthetic */ C1703d f4280a;

        C16981(C1703d c1703d) {
            this.f4280a = c1703d;
        }

        protected Long m6386a(Void... voidArr) {
            String string = C1703d.f4304n.getString("oauth_token", "");
            String string2 = C1703d.f4304n.getString("oauth_token_secret", "");
            C1216a.m4519a("access_token", "> " + string);
            C1216a.m4519a("access_token_secret", "> " + string2);
            C1703d.f4297e = new AccessToken(string, string2).getUserId();
            return Long.valueOf(C1703d.f4297e);
        }

        protected void m6387a(Long l) {
            if (C1703d.f4297e < 0) {
                C1703d.f4303m.m4979b(C1703d.f4303m.getString(R.string.no_network));
            }
        }

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m6386a((Void[]) objArr);
        }

        protected /* synthetic */ void onPostExecute(Object obj) {
            m6387a((Long) obj);
        }

        protected void onPreExecute() {
        }
    }

    class C17014 implements C1265o {
        final /* synthetic */ C1703d f4287a;

        C17014(C1703d c1703d) {
            this.f4287a = c1703d;
        }

        public void mo1487a() {
            C1216a.m4522b("Login", "login onNoNetwork");
        }

        public void mo1539a(Object obj) {
            String str = (String) obj;
            C1216a.m4522b("Login", "verified url " + str);
            this.f4287a.m6409a(Uri.parse(str));
        }

        public void mo1491b() {
            C1216a.m4522b("Login", "login onNoResponse");
        }

        public void mo1492c() {
            C1216a.m4522b("Login", "login onSessionTimeOut");
        }

        public void mo1540d() {
            C1216a.m4522b("Login", "login Failed");
        }
    }

    protected class C1702a {
        long f4288a;
        String f4289b;
        String f4290c;
        String f4291d;
        String f4292e;
        final /* synthetic */ C1703d f4293f;

        protected C1702a(C1703d c1703d) {
            this.f4293f = c1703d;
        }
    }

    public C1703d(C1359a c1359a) {
        f4303m = c1359a;
        m6405j();
        f4296c = this;
    }

    protected static boolean m6400b() {
        if (f4304n == null) {
            f4304n = f4303m.getSharedPreferences("twitterpref", 0);
        }
        return f4304n.getBoolean("isTwitterLogedIn", false);
    }

    private void m6405j() {
        if ("teaXgi4D0NPJnOzlkY6Hr26fT".trim().length() == 0 || "nFiJ7RI8aw7WagNM1hake7Y4iXUjTKtQfo6oopTI2perrf67lK".trim().length() == 0) {
            this.f4305d.m6376a(f4303m, "Twitter oAuth tokens", "Please set your twitter oauth tokens first!", Boolean.valueOf(false));
        } else if (new C1693b(f4303m).m6377a()) {
            f4304n = f4303m.getSharedPreferences("twitterpref", 0);
            m6408a();
        } else {
            this.f4305d.m6376a(f4303m, "Internet Connection Error", "Please connect to working Internet connection", Boolean.valueOf(false));
        }
    }

    private void m6406k() {
        Editor edit = f4304n.edit();
        edit.remove("oauth_token");
        edit.remove("oauth_token_secret");
        edit.remove("isTwitterLogedIn");
        edit.commit();
    }

    private void m6407l() {
        f4303m.startActivity(new Intent(f4303m, TwitterStatus.class));
    }

    void m6408a() {
        ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();
        configurationBuilder.setOAuthConsumerKey("teaXgi4D0NPJnOzlkY6Hr26fT");
        configurationBuilder.setOAuthConsumerSecret("nFiJ7RI8aw7WagNM1hake7Y4iXUjTKtQfo6oopTI2perrf67lK");
        f4295b = new TwitterFactory(configurationBuilder.build()).getInstance();
        if (C1703d.m6400b()) {
            C1216a.m4522b("twitter", "if( isTwitterLoggedInAlready()){");
            new C16981(this).execute(new Void[0]);
        }
    }

    void m6409a(Uri uri) {
        if (uri != null && uri.toString().startsWith("http://m.telkomsel.com/")) {
            final String queryParameter = uri.getQueryParameter("oauth_verifier");
            C1216a.m4522b("twitter", "if (uri != null && uri.toString().startsWith(TWITTER_CALLBACK_URL)) {");
            new AsyncTask<Void, Void, AccessToken>(this) {
                final /* synthetic */ C1703d f4284b;
                private int f4285c;
                private String f4286d;

                protected AccessToken m6390a(Void... voidArr) {
                    try {
                        AccessToken oAuthAccessToken = C1703d.f4295b.getOAuthAccessToken(C1703d.f4301k, queryParameter);
                        this.f4284b.m6410a(oAuthAccessToken);
                        this.f4284b.m6412d();
                        return oAuthAccessToken;
                    } catch (TwitterException e) {
                        e.printStackTrace();
                        this.f4285c = e.getErrorCode();
                        this.f4286d = e.getErrorMessage();
                        return null;
                    }
                }

                protected void m6391a(AccessToken accessToken) {
                    C1703d.f4303m.m4990k();
                    if (accessToken != null) {
                        this.f4284b.m6407l();
                    } else if (this.f4285c == 88) {
                        C1703d.f4303m.m4979b(this.f4286d);
                    } else {
                        C1703d.f4303m.m4979b(C1703d.f4303m.getString(R.string.no_network));
                    }
                }

                protected /* synthetic */ Object doInBackground(Object[] objArr) {
                    return m6390a((Void[]) objArr);
                }

                protected /* synthetic */ void onPostExecute(Object obj) {
                    m6391a((AccessToken) obj);
                }

                protected void onPreExecute() {
                    C1703d.f4303m.m4973a(C1703d.f4303m, C1703d.f4303m.getString(R.string.twitter_connect));
                }
            }.execute(new Void[0]);
        }
    }

    protected void m6410a(AccessToken accessToken) {
        try {
            Editor edit = f4304n.edit();
            edit.putString("oauth_token", accessToken.getToken());
            edit.putString("oauth_token_secret", accessToken.getTokenSecret());
            edit.putBoolean("isTwitterLogedIn", true);
            edit.commit();
            C1216a.m4522b("Twitter OAuth Token", "> " + accessToken.getToken());
        } catch (Exception e) {
            e.printStackTrace();
            C1216a.m4522b("Twitter Login Error", "> " + e.getMessage());
        }
    }

    public boolean m6411c() {
        final C1265o c1265o = this.f4307j;
        if (C1703d.m6400b()) {
            C1216a.m4522b("twitter", " if (!isTwitterLoggedInAlready()) { --->> else ");
            m6407l();
        } else {
            C1216a.m4522b("twitter", " if (!isTwitterLoggedInAlready()) {");
            new AsyncTask<Void, Void, String>(this) {
                final /* synthetic */ C1703d f4282b;

                protected String m6388a(Void... voidArr) {
                    try {
                        if (C1703d.f4301k == null) {
                            C1703d.f4301k = C1703d.f4295b.getOAuthRequestToken();
                            C1703d.f4302l = C1703d.f4301k.getAuthenticationURL();
                        } else if (C1703d.f4302l == null) {
                            C1703d.f4302l = C1703d.f4301k.getAuthenticationURL();
                        }
                        C1216a.m4522b("authUrl", "requestToken : " + C1703d.f4301k);
                        C1216a.m4522b("authUrl", "authUrl : " + C1703d.f4302l);
                        return C1703d.f4302l;
                    } catch (TwitterException e) {
                        e.printStackTrace();
                        C1216a.m4522b("dgpark", "error!!!! " + e.getMessage());
                        this.f4282b.m6413e();
                        return null;
                    }
                }

                protected void m6389a(String str) {
                    if (str != null) {
                        new C1707f(C1703d.f4303m, str, c1265o).show();
                    } else {
                        C1703d.f4303m.m4979b(C1703d.f4303m.getString(R.string.no_network));
                    }
                }

                protected /* synthetic */ Object doInBackground(Object[] objArr) {
                    return m6388a((Void[]) objArr);
                }

                protected /* synthetic */ void onPostExecute(Object obj) {
                    m6389a((String) obj);
                }

                protected void onPreExecute() {
                    C1703d.f4303m.m4973a(C1703d.f4303m, C1703d.f4303m.getString(R.string.twitter_connect));
                }
            }.execute(new Void[0]);
        }
        return true;
    }

    long m6412d() {
        int i;
        C1216a.m4522b("twitter", "long setUserNFriendsData() throws TwitterException{");
        String string = f4304n.getString("oauth_token", "");
        String string2 = f4304n.getString("oauth_token_secret", "");
        C1216a.m4519a("access_token", "> " + string);
        C1216a.m4519a("access_token_secret", "> " + string2);
        AccessToken accessToken = new AccessToken(string, string2);
        C1216a.m4522b("twitter", "AccessToken accessToken = new AccessToken(access_token, access_token_secret);");
        f4297e = accessToken.getUserId();
        C1216a.m4519a("access_token", "> " + f4297e);
        f4295b.setOAuthAccessToken(accessToken);
        this.f4306h = f4295b.showUser(f4297e);
        f4299g = f4295b.showUser(f4297e).getScreenName();
        C1216a.m4519a("screen Name?", f4299g);
        System.out.println("Listing following ids." + f4297e);
        IDs friendsIDs = f4295b.getFriendsIDs(f4297e, -1);
        C1216a.m4522b("twitter", "IDs friendIDs = twitter.getFriendsIDs(userID, cursor);");
        System.out.println("Listing following ids." + friendsIDs.toString());
        f4298f = friendsIDs.getIDs();
        System.out.println("Listing following ids." + f4298f.length);
        if (f4300i.size() == f4298f.length) {
            return f4297e;
        }
        f4300i = new ArrayList();
        int length = f4298f.length;
        int i2 = 100;
        int i3 = 0;
        while (i3 < f4298f.length) {
            long[] jArr;
            if (i2 < length) {
                int i4 = i2;
                jArr = new long[(i2 - i3)];
                i = i4;
            } else {
                jArr = new long[(length - i3)];
                i = length;
            }
            int i5 = i3;
            i3 = 0;
            while (i5 < i) {
                jArr[i3] = f4298f[i5];
                i5++;
                i3++;
            }
            i3 = i + 100;
            try {
                ResponseList<User> lookupUsers = f4295b.lookupUsers(jArr);
                for (User user : lookupUsers) {
                    C1702a c1702a = new C1702a(this);
                    c1702a.f4290c = user.getName();
                    c1702a.f4288a = user.getId();
                    c1702a.f4289b = user.getScreenName();
                    c1702a.f4291d = user.getProfileImageURL().toString();
                    c1702a.f4292e = user.getDescription();
                    f4300i.add(c1702a);
                }
                C1216a.m4522b("friends List", "user cnt : " + lookupUsers.size());
                i2 = i3;
                i3 = i;
            } catch (Exception e) {
                string = "Not all friends are displayed";
                i2 = i3;
                i3 = i;
            }
        }
        return f4297e;
    }

    public void m6413e() {
        m6406k();
        f4301k = null;
        f4302l = null;
        f4298f = null;
        this.f4306h = null;
        CookieSyncManager.createInstance(f4303m);
        CookieManager instance = CookieManager.getInstance();
        instance.setCookie("https://www.twitter.com", null);
        instance.removeAllCookie();
        f4295b = null;
        ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();
        configurationBuilder.setOAuthConsumerKey("teaXgi4D0NPJnOzlkY6Hr26fT");
        configurationBuilder.setOAuthConsumerSecret("nFiJ7RI8aw7WagNM1hake7Y4iXUjTKtQfo6oopTI2perrf67lK");
        f4295b = new TwitterFactory(configurationBuilder.build()).getInstance();
        if (f4300i != null) {
            f4300i = new ArrayList();
        }
    }
}
