package com.skcc.wallet.framework.api.http;

import android.os.AsyncTask;
import com.facebook.internal.NativeProtocol;
import com.google.p021a.C0612j;
import com.google.p021a.C0613k;
import com.google.p021a.aa;
import com.skcc.wallet.core.p057a.C1216a;
import com.skcc.wallet.core.se.SExceptionInfo;
import com.skcc.wallet.framework.api.C1260j;
import com.skcc.wallet.framework.api.http.model.ChangeMWalletPinRs;
import com.skcc.wallet.framework.api.http.model.ChangeTcashFavoriteTransactionRs;
import com.skcc.wallet.framework.api.http.model.ChangeTcashPinRs;
import com.skcc.wallet.framework.api.http.model.CheckUserStatusRs;
import com.skcc.wallet.framework.api.http.model.CheckWalletUpdateRs;
import com.skcc.wallet.framework.api.http.model.CountDownloadedCouponRs;
import com.skcc.wallet.framework.api.http.model.CountNewNoticeRs;
import com.skcc.wallet.framework.api.http.model.GetAllCouponListRs;
import com.skcc.wallet.framework.api.http.model.GetCouponDetailRs;
import com.skcc.wallet.framework.api.http.model.GetGrafariLocationRs;
import com.skcc.wallet.framework.api.http.model.GetMWalletNotificationRs;
import com.skcc.wallet.framework.api.http.model.GetMyDownloadCouponRs;
import com.skcc.wallet.framework.api.http.model.GetMyLoyaltyCardListRs;
import com.skcc.wallet.framework.api.http.model.GetPaymentInfoRs;
import com.skcc.wallet.framework.api.http.model.GetPurchaseInfoRs;
import com.skcc.wallet.framework.api.http.model.GetRetailStoreLocationRs;
import com.skcc.wallet.framework.api.http.model.GetSecurityQuestionRs;
import com.skcc.wallet.framework.api.http.model.GetServiceDetailRs;
import com.skcc.wallet.framework.api.http.model.GetTcashBalanceRs;
import com.skcc.wallet.framework.api.http.model.GetTcashFavoriteTransactionRs;
import com.skcc.wallet.framework.api.http.model.GetTcashPaymentTemplateRs;
import com.skcc.wallet.framework.api.http.model.GetTcashPurchaseTemplateRs;
import com.skcc.wallet.framework.api.http.model.GetTcashTokenRs;
import com.skcc.wallet.framework.api.http.model.GetTcashTransactionHistoryRs;
import com.skcc.wallet.framework.api.http.model.GetTemplateInfoRs;
import com.skcc.wallet.framework.api.http.model.GetTncRs;
import com.skcc.wallet.framework.api.http.model.GetTransferInfoRs;
import com.skcc.wallet.framework.api.http.model.GetUserProfileRs;
import com.skcc.wallet.framework.api.http.model.GetWalletCertificateRs;
import com.skcc.wallet.framework.api.http.model.LoginRs;
import com.skcc.wallet.framework.api.http.model.LogoutRs;
import com.skcc.wallet.framework.api.http.model.PayWithTcashRs;
import com.skcc.wallet.framework.api.http.model.PurchaseWithTcashRs;
import com.skcc.wallet.framework.api.http.model.RegisterUserMobileRs;
import com.skcc.wallet.framework.api.http.model.RegisterUserRs;
import com.skcc.wallet.framework.api.http.model.RemoveTcashFavoriteTransactionRs;
import com.skcc.wallet.framework.api.http.model.RequestCouponDeleteRs;
import com.skcc.wallet.framework.api.http.model.RequestCouponDownloadRs;
import com.skcc.wallet.framework.api.http.model.RequestCouponRedemptionRs;
import com.skcc.wallet.framework.api.http.model.RequestOtpRs;
import com.skcc.wallet.framework.api.http.model.ResetTcashPinRs;
import com.skcc.wallet.framework.api.http.model.ResultRs;
import com.skcc.wallet.framework.api.http.model.SetTcashFavoriteTransactionRs;
import com.skcc.wallet.framework.api.http.model.SetTcashPinAfterResetRs;
import com.skcc.wallet.framework.api.http.model.SetTcashPinForRegisterRs;
import com.skcc.wallet.framework.api.http.model.SetTcashPinRs;
import com.skcc.wallet.framework.api.http.model.SetUserProfileRs;
import com.skcc.wallet.framework.api.http.model.TopupSmsBankRs;
import com.skcc.wallet.framework.api.http.model.TransferWithTcashRs;
import com.skcc.wallet.framework.api.http.model.UnlinkOtherNfcTagRs;
import com.skcc.wallet.framework.api.http.model.VerifyOtpAndMakePinRs;
import com.skcc.wallet.framework.api.http.model.VerifyOtpRs;
import com.skcc.wallet.framework.api.http.model.VerifySecurityAnswerRs;
import com.skcc.wallet.framework.api.http.model.VerifyTcashPinForRegisterRs;
import com.skcc.wallet.framework.api.http.model.VerifyTcashSecurityAnswerRs;
import com.skcc.wallet.framework.api.http.model.VerifyUserRs;
import com.skcc.wallet.framework.p060b.C1301b;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import javax.net.ssl.SSLProtocolException;
import twitter4j.HttpResponseCode;

public class C1241b {
    private static boolean f2643e = false;
    private static HashMap<String, C1240b> f2644f = new HashMap();
    protected C0612j f2645a = null;
    protected C1246g f2646b = null;
    private int f2647c = 0;
    private final String f2648d = "BaseGateWay";

    private class C1239a extends AsyncTask<Object, Void, Object> {
        String f2632a;
        String f2633b;
        String f2634c;
        Type f2635d;
        Exception f2636e;
        C1245f f2637f;
        final /* synthetic */ C1241b f2638g;

        public C1239a(C1241b c1241b, String str, C1245f c1245f) {
            this.f2638g = c1241b;
            this.f2632a = str;
            this.f2637f = c1245f;
            this.f2633b = c1241b.f2646b.mo1467f().m4589a();
            this.f2634c = C1241b.m4556a(str);
            this.f2635d = C1241b.m4559c(str);
        }

        protected Object doInBackground(Object... objArr) {
            Object obj = null;
            try {
                obj = this.f2638g.m4555a(this.f2632a, objArr[0]);
            } catch (Exception e) {
                e.printStackTrace();
                this.f2636e = e;
            }
            return obj;
        }

        protected void onCancelled() {
            super.onCancelled();
        }

        protected void onPostExecute(Object obj) {
            C1241b.f2643e = false;
            if (this.f2636e == null) {
                this.f2637f.mo1490a(this.f2632a, obj);
            } else if (this.f2636e instanceof C1251l) {
                this.f2637f.mo1489a(this.f2632a, ((C1251l) this.f2636e).m4586a(), ((C1251l) this.f2636e).m4587b(), this.f2636e.getMessage(), ((C1251l) this.f2636e).m4588c());
            } else if (this.f2636e instanceof C1238a) {
                this.f2637f.mo1489a(this.f2632a, ((C1238a) this.f2636e).m4553a(), "Error", this.f2636e.getMessage(), null);
            } else if (this.f2636e instanceof C1249j) {
                this.f2637f.mo1491b();
            } else if (this.f2636e instanceof C1248i) {
                this.f2637f.mo1487a();
            } else if (this.f2636e instanceof C1247h) {
                this.f2637f.mo1492c();
            } else if (this.f2636e instanceof SSLProtocolException) {
                this.f2637f.mo1489a(this.f2632a, -111, "Error", "We are unable to process your request at this time. We regret the inconvenience and request you to please try again after some time", null);
            } else {
                this.f2637f.mo1489a(this.f2632a, -111, "Error", this.f2636e.toString(), null);
            }
            super.onPostExecute(obj);
        }

        protected void onPreExecute() {
            C1241b.f2643e = true;
            this.f2637f.mo1488a(this.f2632a);
            super.onPreExecute();
        }
    }

    private static class C1240b {
        String f2639a;
        String f2640b;
        String f2641c;
        Type f2642d;

        public C1240b(String str, String str2, String str3, Type type) {
            this.f2639a = str;
            this.f2640b = str2;
            this.f2641c = str3;
            this.f2642d = type;
        }
    }

    static {
        f2644f.put("checkWalletUpdate", new C1240b("checkWalletUpdate", "/user/checkWalletUpdate", "checkWalletUpdateRq", CheckWalletUpdateRs.class));
        f2644f.put("login", new C1240b("login", "/user/login", "loginRq", LoginRs.class));
        f2644f.put("countDownloadedCoupon", new C1240b("countDownloadedCoupon", "/marketing/countDownloadedCoupon", "countDownloadedCouponRq", CountDownloadedCouponRs.class));
        f2644f.put("changeMWalletPin", new C1240b("changeMWalletPin", "/settings/changeMWalletPin", "changeMWalletPinRq", ChangeMWalletPinRs.class));
        f2644f.put("changeTcashFavoriteTransaction", new C1240b("changeTcashFavoriteTransaction", "/settings/changeTcashFavoriteTransaction", "changeTcashFavoriteTransactionRq", ChangeTcashFavoriteTransactionRs.class));
        f2644f.put("requestOtp", new C1240b("requestOtp", "/user/requestOtp", "requestOtpRq", RequestOtpRs.class));
        f2644f.put("verifyOtp", new C1240b("verifyOtp", "/user/verifyOtp", "verifyOtpRq", VerifyOtpRs.class));
        f2644f.put("verifyOtpAndMakePin", new C1240b("verifyOtpAndMakePin", "/settings/verifyOtpAndMakePin", "verifyOtpAndMakePinRq", VerifyOtpAndMakePinRs.class));
        f2644f.put("registerUser", new C1240b("registerUser", "/user/registerUser", "registerUserRq", RegisterUserRs.class));
        f2644f.put("verifyUser", new C1240b("verifyUser", "/settings/verifyUser", "verifyUserRq", VerifyUserRs.class));
        f2644f.put("countNewNotice", new C1240b("countNewNotice", "/user/countNewNotice", "countNewNoticeRq", CountNewNoticeRs.class));
        f2644f.put("getMyLoyaltyCardList", new C1240b("getMyLoyaltyCardList", "/marketing/getMyLoyaltyCardList", "getMyLoyaltyCardListRq", GetMyLoyaltyCardListRs.class));
        f2644f.put("getUserProfile", new C1240b("getUserProfile", "/user/getUserProfile", "getUserProfileRq", GetUserProfileRs.class));
        f2644f.put("getMWalletNotification", new C1240b("getMWalletNotification", "/user/getMWalletNotification", "getMWalletNotificationRq", GetMWalletNotificationRs.class));
        f2644f.put("setUserProfile", new C1240b("setUserProfile", "/user/setUserProfile", "setUserProfileRq", SetUserProfileRs.class));
        f2644f.put("getSecurityQuestion", new C1240b("getSecurityQuestion", "/settings/getSecurityQuestion", "getSecurityQuestionRq", GetSecurityQuestionRs.class));
        f2644f.put("getTnc", new C1240b("getTnc", "/user/getTnc", "getTncRq", GetTncRs.class));
        f2644f.put("getTcashPurchaseTemplate", new C1240b("getTcashPurchaseTemplate", "/tcash/getTcashPurchaseTemplate", "getTcashPurchaseTemplateRq", GetTcashPurchaseTemplateRs.class));
        f2644f.put("getTcashPaymentTemplate", new C1240b("getTcashPaymentTemplate", "/tcash/getTcashPaymentTemplate", "getTcashPaymentTemplateRq", GetTcashPaymentTemplateRs.class));
        f2644f.put("getTcashToken", new C1240b("getTcashToken", "/tcash/getTcashToken", "getTcashTokenRq", GetTcashTokenRs.class));
        f2644f.put("getServiceDetail", new C1240b("getServiceDetail", "/tcash/getServiceDetail", "getServiceDetailRq", GetServiceDetailRs.class));
        f2644f.put("getPurchaseInfo", new C1240b("getPurchaseInfo", "/tcash/getPurchaseInfo", "getPurchaseInfoRq", GetPurchaseInfoRs.class));
        f2644f.put("purchaseWithTcash", new C1240b("purchaseWithTcash", "/tcash/purchaseWithTcash", "purchaseWithTcashRq", PurchaseWithTcashRs.class));
        f2644f.put("getAllCouponList", new C1240b("getAllCouponList", "/marketing/getAllCouponList", "getAllCouponListRq", GetAllCouponListRs.class));
        f2644f.put("changeTCashPin", new C1240b("changeTCashPin", "/settings/changeTcashPin", "changeTcashPinRq", ChangeTcashPinRs.class));
        f2644f.put("getTemplateInfo", new C1240b("getTemplateInfo", "/tcash/getTemplateInfo", "getTemplateInfoRq", GetTemplateInfoRs.class));
        f2644f.put("getTcashFavoriteTransaction", new C1240b("getTcashFavoriteTransaction", "/settings/getTcashFavoriteTransaction", "getTcashFavoriteTransactionRq", GetTcashFavoriteTransactionRs.class));
        f2644f.put("removeTcashFavoriteTransaction", new C1240b("removeTcashFavoriteTransaction", "/settings/removeTcashFavoriteTransaction", "removeTcashFavoriteTransactionRq", RemoveTcashFavoriteTransactionRs.class));
        f2644f.put("verifyTCashSecurityAnswer", new C1240b("verifyTCashSecurityAnswer", "/settings/verifyTcashSecurityAnswer", "verifyTcashSecurityAnswerRq", VerifyTcashSecurityAnswerRs.class));
        f2644f.put("verifySecurityAnswer", new C1240b("verifySecurityAnswer", "/settings/verifySecurityAnswer", "verifySecurityAnswerRq", VerifySecurityAnswerRs.class));
        f2644f.put("requestCouponDownload", new C1240b("requestCouponDownload", "/marketing/requestCouponDownload", "requestCouponDownloadRq", RequestCouponDownloadRs.class));
        f2644f.put("getCouponDetail", new C1240b("getCouponDetail", "/marketing/getCouponDetail", "getCouponDetailRq", GetCouponDetailRs.class));
        f2644f.put("requestCouponDelete", new C1240b("requestCouponDelete", "/marketing/requestCouponDelete", "requestCouponDeleteRq", RequestCouponDeleteRs.class));
        f2644f.put("requestCouponRedemption", new C1240b("requestCouponRedemption", "/marketing/requestCouponRedemption", "requestCouponRedemptionRq", RequestCouponRedemptionRs.class));
        f2644f.put("getMyDownloadCoupon", new C1240b("getMyDownloadCoupon", "/marketing/getMyDownloadCoupon", "getMyDownloadCouponRq", GetMyDownloadCouponRs.class));
        f2644f.put("setTcashFavoriteTransaction", new C1240b("setTcashFavoriteTransaction", "/settings/setTcashFavoriteTransaction", "setTcashFavoriteTransactionRq", SetTcashFavoriteTransactionRs.class));
        f2644f.put("getTransferInfo", new C1240b("getTransferInfo", "/tcash/getTransferInfo", "getTransferInfoRq", GetTransferInfoRs.class));
        f2644f.put("transferWithTcash", new C1240b("transferWithTcash", "/tcash/transferWithTcash", "transferWithTcashRq", TransferWithTcashRs.class));
        f2644f.put("getTcashTransactionHistory", new C1240b("getTcashTransactionHistory", "/tcash/getTcashTransactionHistory", "getTcashTransactionHistoryRq", GetTcashTransactionHistoryRs.class));
        f2644f.put("getRetailStoreLocation", new C1240b("getRetailStoreLocation", "/location/getRetailStoreLocation", "getRetailStoreLocationRq", GetRetailStoreLocationRs.class));
        f2644f.put("getGrafariLocation", new C1240b("getGrafariLocation", "/location/getGrafariLocation", "getGrafariLocationRq", GetGrafariLocationRs.class));
        f2644f.put("getPaymentInfo", new C1240b("getPaymentInfo", "/tcash/getPaymentInfo", "getPaymentInfoRq", GetPaymentInfoRs.class));
        f2644f.put("payWithTcash", new C1240b("payWithTcash", "/tcash/payWithTcash", "payWithTcashRq", PayWithTcashRs.class));
        f2644f.put("topupSmsBank", new C1240b("topupSmsBank", "/tcash/topupSmsBank", "topupSmsBankRq", TopupSmsBankRs.class));
        f2644f.put("logout", new C1240b("logout", "/user/logout", "logoutRq", LogoutRs.class));
        f2644f.put("getWalletCertificate", new C1240b("getWalletCertificate", "/user/getWalletCertificate", "getWalletCertificateRq", GetWalletCertificateRs.class));
        f2644f.put("registerUserMobile", new C1240b("registerUserMobile", "/settings/registerUserMobile", "registerUserMobileRq", RegisterUserMobileRs.class));
        f2644f.put("setTcashPin", new C1240b("setTcashPin", "/tcash/setTcashPin", "setTcashPinRq", SetTcashPinRs.class));
        f2644f.put("getTcashBalance", new C1240b("getTcashBalance", "/user/getTcashBalance", "getTcashBalanceRq", GetTcashBalanceRs.class));
        f2644f.put("resetTcashPin", new C1240b("resetTcashPin", "/settings/resetTcashPin", "resetTcashPinRq", ResetTcashPinRs.class));
        f2644f.put("setTcashPinForRegister", new C1240b("setTcashPinForRegister", "/user/setTcashPinForRegister", "setTcashPinForRegisterRq", SetTcashPinForRegisterRs.class));
        f2644f.put("verifyTcashPinForRegister", new C1240b("verifyTcashPinForRegister", "/user/verifyTcashPinForRegister", "verifyTcashPinForRegisterRq", VerifyTcashPinForRegisterRs.class));
        f2644f.put("checkUserStatus", new C1240b("checkUserStatus", "/user/checkUserStatus", "checkUserStatusRq", CheckUserStatusRs.class));
        f2644f.put("unlinkOtherNfcTag", new C1240b("unlinkOtherNfcTag", "/user/unlinkOtherNfcTag", "unlinkOtherNfcTagRq", UnlinkOtherNfcTagRs.class));
        f2644f.put("setTcashPinAfterReset", new C1240b("setTcashPinAfterReset", "/settings/setTcashPinAfterReset", "setTcashPinAfterResetRq", SetTcashPinAfterResetRs.class));
    }

    public C1241b(C1260j c1260j) {
        this.f2646b = c1260j;
        this.f2645a = new C0613k().m1252a().m1253b();
    }

    private Object m4555a(String str, Object obj) {
        C1243d c1243d = new C1243d(this.f2646b.mo1467f().m4589a() + C1241b.m4558b(str), C1241b.m4556a(str));
        c1243d.m4574a(this.f2645a.m1244a(obj));
        C1242c a = m4561a(c1243d, false);
        if (a.m4565a() != HttpResponseCode.OK) {
            return null;
        }
        this.f2646b.mo1465a(a.m4572d());
        if ("getWalletCertificate".equalsIgnoreCase(str)) {
            return a.m4570c();
        }
        Object a2 = m4562a(a.m4570c(), C1241b.m4559c(str));
        int code = ((ResultRs) a2).getResult().getCode();
        String message = ((ResultRs) a2).getResult().getMessage();
        if (code == 0) {
            return a2;
        }
        throw new C1251l(code, "", message, a2);
    }

    public static String m4556a(String str) {
        return ((C1240b) f2644f.get(str)).f2641c;
    }

    public static String m4558b(String str) {
        return ((C1240b) f2644f.get(str)).f2640b;
    }

    public static Type m4559c(String str) {
        return ((C1240b) f2644f.get(str)).f2642d;
    }

    protected C1242c m4560a(C1243d c1243d) {
        long currentTimeMillis = System.currentTimeMillis();
        C1242c a = m4561a(c1243d, false);
        C1216a.m4522b("BASEGATEWAY", "timestamp[" + (System.currentTimeMillis() - currentTimeMillis) + "] " + c1243d.m4573a().substring(0, 30));
        return a;
    }

    protected C1242c m4561a(C1243d c1243d, boolean z) {
        if (this.f2646b.mo1466d()) {
            C1242c a = new C1257o(this.f2646b).m4612a(c1243d, this.f2646b.mo1464a());
            C1216a.m4519a("BaseGateWay", "HttpCode :: " + a.m4565a());
            switch (a.m4565a()) {
                case SExceptionInfo.INVALID_CLASS /*-8*/:
                case HttpResponseCode.INTERNAL_SERVER_ERROR /*500*/:
                case HttpResponseCode.SERVICE_UNAVAILABLE /*503*/:
                    throw new C1249j();
                case SExceptionInfo.INVALID_INSTRUCTION /*-7*/:
                case -1:
                    if (z) {
                        throw new C1249j();
                    } else if (this.f2647c > 3) {
                        throw new C1249j();
                    } else {
                        this.f2647c++;
                        return m4560a(c1243d);
                    }
                case SExceptionInfo.INCORRECT_P1_P2 /*-6*/:
                case -4:
                    throw new C1248i();
                case HttpResponseCode.UNAUTHORIZED /*401*/:
                    throw new C1247h();
                default:
                    this.f2647c = 0;
                    return a;
            }
        }
        throw new C1248i();
    }

    protected <T> T m4562a(String str, Type type) {
        T t = null;
        if (str != null && str.length() >= 1) {
            try {
                t = this.f2645a.m1242a(str.substring(str.indexOf(":") + 1, str.length() - 1), type);
            } catch (aa e) {
                e.printStackTrace();
            }
        }
        return t;
    }

    protected String m4563a(C1301b c1301b) {
        HttpURLConnection httpURLConnection;
        Exception exception;
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream2;
        String str = null;
        if (this.f2646b.mo1466d()) {
            try {
                URL url = new URL("http://202.78.200.16:8080/vcard/?" + c1301b.toString());
                C1216a.m4519a(NativeProtocol.IMAGE_URL_KEY, url.toString());
                InputStream inputStream;
                try {
                    HttpURLConnection httpURLConnection2 = (HttpURLConnection) url.openConnection();
                    try {
                        ByteArrayOutputStream byteArrayOutputStream3;
                        httpURLConnection2.setConnectTimeout(30000);
                        httpURLConnection2.setReadTimeout(30000);
                        httpURLConnection2.setRequestMethod("POST");
                        httpURLConnection2.setRequestProperty("Content-Type", "application/xml; charset=UTF-8");
                        int responseCode = httpURLConnection2.getResponseCode();
                        C1216a.m4519a("BaseGateWay", "HttpCode :: " + responseCode);
                        if (responseCode == HttpResponseCode.OK) {
                            inputStream = httpURLConnection2.getInputStream();
                            try {
                                byteArrayOutputStream3 = new ByteArrayOutputStream();
                                try {
                                    byte[] bArr = new byte[1024];
                                    while (true) {
                                        int read = inputStream.read(bArr, 0, bArr.length);
                                        if (read == -1) {
                                            break;
                                        }
                                        byteArrayOutputStream3.write(bArr, 0, read);
                                    }
                                    str = new String(byteArrayOutputStream3.toByteArray());
                                    C1216a.m4519a("response", str);
                                    if (str == null || str.equals("")) {
                                        throw new C1249j();
                                    }
                                } catch (Exception e) {
                                    str = inputStream;
                                    ByteArrayOutputStream byteArrayOutputStream4 = byteArrayOutputStream3;
                                    httpURLConnection = httpURLConnection2;
                                    exception = e;
                                    byteArrayOutputStream = byteArrayOutputStream4;
                                    try {
                                        exception.printStackTrace();
                                        throw new C1249j();
                                    } catch (Throwable th2) {
                                        th = th2;
                                        inputStream = str;
                                        byteArrayOutputStream2 = byteArrayOutputStream;
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (Exception e2) {
                                            }
                                        }
                                        if (byteArrayOutputStream2 != null) {
                                            try {
                                                byteArrayOutputStream2.flush();
                                                byteArrayOutputStream2.close();
                                            } catch (Exception e3) {
                                            }
                                        }
                                        if (httpURLConnection != null) {
                                            httpURLConnection.disconnect();
                                        }
                                        throw th;
                                    }
                                } catch (Throwable th3) {
                                    byteArrayOutputStream2 = byteArrayOutputStream3;
                                    httpURLConnection = httpURLConnection2;
                                    th = th3;
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                    if (byteArrayOutputStream2 != null) {
                                        byteArrayOutputStream2.flush();
                                        byteArrayOutputStream2.close();
                                    }
                                    if (httpURLConnection != null) {
                                        httpURLConnection.disconnect();
                                    }
                                    throw th;
                                }
                            } catch (Exception e4) {
                                httpURLConnection = httpURLConnection2;
                                exception = e4;
                                byteArrayOutputStream = null;
                                Object obj = inputStream;
                                exception.printStackTrace();
                                throw new C1249j();
                            } catch (Throwable th32) {
                                httpURLConnection = httpURLConnection2;
                                th = th32;
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                if (byteArrayOutputStream2 != null) {
                                    byteArrayOutputStream2.flush();
                                    byteArrayOutputStream2.close();
                                }
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                throw th;
                            }
                        } else if (responseCode == HttpResponseCode.UNAUTHORIZED) {
                            throw new C1247h();
                        } else if (responseCode == HttpResponseCode.INTERNAL_SERVER_ERROR || responseCode == HttpResponseCode.SERVICE_UNAVAILABLE) {
                            throw new C1249j();
                        } else {
                            byteArrayOutputStream3 = null;
                            inputStream = null;
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e5) {
                            }
                        }
                        if (byteArrayOutputStream3 != null) {
                            try {
                                byteArrayOutputStream3.flush();
                                byteArrayOutputStream3.close();
                            } catch (Exception e6) {
                            }
                        }
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                        return str;
                    } catch (Exception e42) {
                        httpURLConnection = httpURLConnection2;
                        exception = e42;
                        byteArrayOutputStream = null;
                        exception.printStackTrace();
                        throw new C1249j();
                    } catch (Throwable th322) {
                        inputStream = null;
                        httpURLConnection = httpURLConnection2;
                        th = th322;
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (byteArrayOutputStream2 != null) {
                            byteArrayOutputStream2.flush();
                            byteArrayOutputStream2.close();
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        throw th;
                    }
                } catch (Exception e7) {
                    exception = e7;
                    byteArrayOutputStream = null;
                    httpURLConnection = null;
                    exception.printStackTrace();
                    throw new C1249j();
                } catch (Throwable th4) {
                    th = th4;
                    inputStream = null;
                    httpURLConnection = null;
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (byteArrayOutputStream2 != null) {
                        byteArrayOutputStream2.flush();
                        byteArrayOutputStream2.close();
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th;
                }
            } catch (Exception exception2) {
                exception2.printStackTrace();
                throw new C1249j();
            }
        }
        throw new C1248i();
    }

    public void m4564a(String str, Object obj, C1245f c1245f) {
        new C1239a(this, str, c1245f).execute(new Object[]{obj});
    }
}
