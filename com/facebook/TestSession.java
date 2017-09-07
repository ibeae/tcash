package com.facebook;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.Session.AuthorizationRequest;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.model.GraphObject;
import com.facebook.model.GraphObjectList;
import com.facebook.model.GraphUser;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestSession extends Session {
    static final /* synthetic */ boolean $assertionsDisabled = (!TestSession.class.desiredAssertionStatus());
    private static final String LOG_TAG = "FacebookSDK.TestSession";
    private static Map<String, TestAccount> appTestAccounts = null;
    private static final long serialVersionUID = 1;
    private static String testApplicationId;
    private static String testApplicationSecret;
    private final Mode mode;
    private final List<String> requestedPermissions;
    private final String sessionUniqueUserTag;
    private String testAccountId;
    private String testAccountUserName;
    private boolean wasAskedToExtendAccessToken;

    private enum Mode {
        PRIVATE,
        SHARED
    }

    private interface TestAccount extends GraphObject {
        String getAccessToken();

        String getId();

        String getName();

        void setName(String str);
    }

    private interface TestAccountsResponse extends GraphObject {
        GraphObjectList<TestAccount> getData();
    }

    private static final class TestTokenCachingStrategy extends TokenCachingStrategy {
        private Bundle bundle;

        private TestTokenCachingStrategy() {
        }

        public void clear() {
            this.bundle = null;
        }

        public Bundle load() {
            return this.bundle;
        }

        public void save(Bundle bundle) {
            this.bundle = bundle;
        }
    }

    TestSession(Activity activity, List<String> list, TokenCachingStrategy tokenCachingStrategy, String str, Mode mode) {
        super(activity, testApplicationId, tokenCachingStrategy);
        Validate.notNull(list, "permissions");
        Validate.notNullOrEmpty(testApplicationId, "testApplicationId");
        Validate.notNullOrEmpty(testApplicationSecret, "testApplicationSecret");
        this.sessionUniqueUserTag = str;
        this.mode = mode;
        this.requestedPermissions = list;
    }

    public static TestSession createSessionWithPrivateUser(Activity activity, List<String> list) {
        return createTestSession(activity, list, Mode.PRIVATE, null);
    }

    public static TestSession createSessionWithSharedUser(Activity activity, List<String> list) {
        return createSessionWithSharedUser(activity, list, null);
    }

    public static TestSession createSessionWithSharedUser(Activity activity, List<String> list, String str) {
        return createTestSession(activity, list, Mode.SHARED, str);
    }

    private TestAccount createTestAccountAndFinishAuth() {
        Bundle bundle = new Bundle();
        bundle.putString("installed", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        bundle.putString("permissions", getPermissionsString());
        bundle.putString("access_token", getAppAccessToken());
        if (this.mode == Mode.SHARED) {
            bundle.putString("name", String.format("Shared %s Testuser", new Object[]{getSharedTestAccountIdentifier()}));
        }
        Response executeAndWait = new Request(null, String.format("%s/accounts/test-users", new Object[]{testApplicationId}), bundle, HttpMethod.POST).executeAndWait();
        FacebookRequestError error = executeAndWait.getError();
        TestAccount testAccount = (TestAccount) executeAndWait.getGraphObjectAs(TestAccount.class);
        if (error != null) {
            finishAuthOrReauth(null, error.getException());
            return null;
        } else if ($assertionsDisabled || testAccount != null) {
            if (this.mode == Mode.SHARED) {
                testAccount.setName(bundle.getString("name"));
                storeTestAccount(testAccount);
            }
            finishAuthWithTestAccount(testAccount);
            return testAccount;
        } else {
            throw new AssertionError();
        }
    }

    private static synchronized TestSession createTestSession(Activity activity, List<String> list, Mode mode, String str) {
        TestSession testSession;
        synchronized (TestSession.class) {
            if (Utility.isNullOrEmpty(testApplicationId) || Utility.isNullOrEmpty(testApplicationSecret)) {
                throw new FacebookException("Must provide app ID and secret");
            }
            List asList;
            if (Utility.isNullOrEmpty((Collection) list)) {
                asList = Arrays.asList(new String[]{"email", "publish_actions"});
            } else {
                List<String> list2 = list;
            }
            testSession = new TestSession(activity, asList, new TestTokenCachingStrategy(), str, mode);
        }
        return testSession;
    }

    private void deleteTestAccount(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("access_token", str2);
        Response executeAndWait = new Request(null, str, bundle, HttpMethod.DELETE).executeAndWait();
        FacebookRequestError error = executeAndWait.getError();
        GraphObject graphObject = executeAndWait.getGraphObject();
        if (error != null) {
            Log.w(LOG_TAG, String.format("Could not delete test account %s: %s", new Object[]{str, error.getException().toString()}));
        } else if (graphObject.getProperty(Response.NON_JSON_RESPONSE_PROPERTY) == Boolean.valueOf(false) || graphObject.getProperty(Response.SUCCESS_KEY) == Boolean.valueOf(false)) {
            Log.w(LOG_TAG, String.format("Could not delete test account %s: unknown reason", new Object[]{str}));
        }
    }

    private void findOrCreateSharedTestAccount() {
        TestAccount findTestAccountMatchingIdentifier = findTestAccountMatchingIdentifier(getSharedTestAccountIdentifier());
        if (findTestAccountMatchingIdentifier != null) {
            finishAuthWithTestAccount(findTestAccountMatchingIdentifier);
        } else {
            createTestAccountAndFinishAuth();
        }
    }

    private static synchronized TestAccount findTestAccountMatchingIdentifier(String str) {
        TestAccount testAccount;
        synchronized (TestSession.class) {
            retrieveTestAccountsForAppIfNeeded();
            for (TestAccount testAccount2 : appTestAccounts.values()) {
                if (testAccount2.getName().contains(str)) {
                    break;
                }
            }
            testAccount2 = null;
        }
        return testAccount2;
    }

    private void finishAuthWithTestAccount(TestAccount testAccount) {
        this.testAccountId = testAccount.getId();
        this.testAccountUserName = testAccount.getName();
        finishAuthOrReauth(AccessToken.createFromString(testAccount.getAccessToken(), this.requestedPermissions, AccessTokenSource.TEST_USER), null);
    }

    static final String getAppAccessToken() {
        return testApplicationId + "|" + testApplicationSecret;
    }

    private String getPermissionsString() {
        return TextUtils.join(",", this.requestedPermissions);
    }

    private String getSharedTestAccountIdentifier() {
        return validNameStringFromInteger((this.sessionUniqueUserTag != null ? ((long) this.sessionUniqueUserTag.hashCode()) & 4294967295L : 0) ^ (((long) getPermissionsString().hashCode()) & 4294967295L));
    }

    public static synchronized String getTestApplicationId() {
        String str;
        synchronized (TestSession.class) {
            str = testApplicationId;
        }
        return str;
    }

    public static synchronized String getTestApplicationSecret() {
        String str;
        synchronized (TestSession.class) {
            str = testApplicationSecret;
        }
        return str;
    }

    private static synchronized void populateTestAccounts(Collection<TestAccount> collection, GraphObject graphObject) {
        synchronized (TestSession.class) {
            for (TestAccount testAccount : collection) {
                testAccount.setName(((GraphUser) graphObject.getPropertyAs(testAccount.getId(), GraphUser.class)).getName());
                storeTestAccount(testAccount);
            }
        }
    }

    private static synchronized void retrieveTestAccountsForAppIfNeeded() {
        synchronized (TestSession.class) {
            if (appTestAccounts == null) {
                appTestAccounts = new HashMap();
                Request.setDefaultBatchApplicationId(testApplicationId);
                Bundle bundle = new Bundle();
                bundle.putString("access_token", getAppAccessToken());
                Request request = new Request(null, "app/accounts/test-users", bundle, null);
                request.setBatchEntryName("testUsers");
                request.setBatchEntryOmitResultOnSuccess(false);
                bundle = new Bundle();
                bundle.putString("access_token", getAppAccessToken());
                bundle.putString("ids", "{result=testUsers:$.data.*.id}");
                bundle.putString("fields", "name");
                new Request(null, "", bundle, null).setBatchEntryDependsOn("testUsers");
                List executeBatchAndWait = Request.executeBatchAndWait(request, r3);
                if (executeBatchAndWait == null || executeBatchAndWait.size() != 2) {
                    throw new FacebookException("Unexpected number of results from TestUsers batch query");
                }
                populateTestAccounts(((TestAccountsResponse) ((Response) executeBatchAndWait.get(0)).getGraphObjectAs(TestAccountsResponse.class)).getData(), ((Response) executeBatchAndWait.get(1)).getGraphObject());
            }
        }
    }

    public static synchronized void setTestApplicationId(String str) {
        synchronized (TestSession.class) {
            if (testApplicationId == null || testApplicationId.equals(str)) {
                testApplicationId = str;
            } else {
                throw new FacebookException("Can't have more than one test application ID");
            }
        }
    }

    public static synchronized void setTestApplicationSecret(String str) {
        synchronized (TestSession.class) {
            if (testApplicationSecret == null || testApplicationSecret.equals(str)) {
                testApplicationSecret = str;
            } else {
                throw new FacebookException("Can't have more than one test application secret");
            }
        }
    }

    private static synchronized void storeTestAccount(TestAccount testAccount) {
        synchronized (TestSession.class) {
            appTestAccounts.put(testAccount.getId(), testAccount);
        }
    }

    private String validNameStringFromInteger(long j) {
        String l = Long.toString(j);
        StringBuilder stringBuilder = new StringBuilder("Perm");
        char[] toCharArray = l.toCharArray();
        int length = toCharArray.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = toCharArray[i];
            if (i3 == i2) {
                i3 = (char) (i3 + 10);
            }
            stringBuilder.append((char) ((i3 + 97) - 48));
            i++;
            i2 = i3;
        }
        return stringBuilder.toString();
    }

    void authorize(AuthorizationRequest authorizationRequest) {
        if (this.mode == Mode.PRIVATE) {
            createTestAccountAndFinishAuth();
        } else {
            findOrCreateSharedTestAccount();
        }
    }

    void extendAccessToken() {
        this.wasAskedToExtendAccessToken = true;
        super.extendAccessToken();
    }

    void fakeTokenRefreshAttempt() {
        setCurrentTokenRefreshRequest(new TokenRefreshRequest());
    }

    void forceExtendAccessToken(boolean z) {
        AccessToken tokenInfo = getTokenInfo();
        setTokenInfo(new AccessToken(tokenInfo.getToken(), new Date(), tokenInfo.getPermissions(), tokenInfo.getDeclinedPermissions(), AccessTokenSource.TEST_USER, new Date(0)));
        setLastAttemptedTokenExtendDate(new Date(0));
    }

    public final String getTestUserId() {
        return this.testAccountId;
    }

    public final String getTestUserName() {
        return this.testAccountUserName;
    }

    boolean getWasAskedToExtendAccessToken() {
        return this.wasAskedToExtendAccessToken;
    }

    void postStateChange(SessionState sessionState, SessionState sessionState2, Exception exception) {
        String str = this.testAccountId;
        super.postStateChange(sessionState, sessionState2, exception);
        if (sessionState2.isClosed() && str != null && this.mode == Mode.PRIVATE) {
            deleteTestAccount(str, getAppAccessToken());
        }
    }

    boolean shouldExtendAccessToken() {
        boolean shouldExtendAccessToken = super.shouldExtendAccessToken();
        this.wasAskedToExtendAccessToken = false;
        return shouldExtendAccessToken;
    }

    public final String toString() {
        return "{TestSession" + " testUserId:" + this.testAccountId + " " + super.toString() + "}";
    }
}
