package com.skcc.wallet.framework.api;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.skcc.wallet.core.p057a.C1216a;
import com.skcc.wallet.framework.C1302b;
import com.skcc.wallet.framework.api.http.C1241b;
import com.skcc.wallet.framework.api.http.C1245f;
import com.skcc.wallet.framework.api.http.C1247h;
import com.skcc.wallet.framework.api.http.C1248i;
import com.skcc.wallet.framework.api.http.C1249j;
import com.skcc.wallet.framework.api.http.model.ChangeMWalletPinRq;
import com.skcc.wallet.framework.api.http.model.ChangeTcashFavoriteTransactionRq;
import com.skcc.wallet.framework.api.http.model.ChangeTcashPinRq;
import com.skcc.wallet.framework.api.http.model.CheckBalanceRs;
import com.skcc.wallet.framework.api.http.model.CheckStatusStickerRq;
import com.skcc.wallet.framework.api.http.model.CheckStatusStickerRs;
import com.skcc.wallet.framework.api.http.model.CheckUserStatusRq;
import com.skcc.wallet.framework.api.http.model.CheckWalletUpdateRq;
import com.skcc.wallet.framework.api.http.model.CommonHeader;
import com.skcc.wallet.framework.api.http.model.CountDownloadedCouponRq;
import com.skcc.wallet.framework.api.http.model.CreateCardRs;
import com.skcc.wallet.framework.api.http.model.GetAllCouponListRq;
import com.skcc.wallet.framework.api.http.model.GetAvailLoyaltyCardListRq;
import com.skcc.wallet.framework.api.http.model.GetAvailLoyaltyCardListRs;
import com.skcc.wallet.framework.api.http.model.GetCouponDetailRq;
import com.skcc.wallet.framework.api.http.model.GetGrafariLocationRq;
import com.skcc.wallet.framework.api.http.model.GetMWalletNotificationRq;
import com.skcc.wallet.framework.api.http.model.GetMyDownloadCouponRq;
import com.skcc.wallet.framework.api.http.model.GetMyLoyaltyCardListRq;
import com.skcc.wallet.framework.api.http.model.GetPaymentInfoRq;
import com.skcc.wallet.framework.api.http.model.GetPurchaseInfoRq;
import com.skcc.wallet.framework.api.http.model.GetRetailStoreLocationRq;
import com.skcc.wallet.framework.api.http.model.GetSecurityQuestionRq;
import com.skcc.wallet.framework.api.http.model.GetServiceDetailRq;
import com.skcc.wallet.framework.api.http.model.GetTcashBalanceRq;
import com.skcc.wallet.framework.api.http.model.GetTcashFavoriteTransactionRq;
import com.skcc.wallet.framework.api.http.model.GetTcashPaymentTemplateRq;
import com.skcc.wallet.framework.api.http.model.GetTcashPurchaseTemplateRq;
import com.skcc.wallet.framework.api.http.model.GetTcashTokenRq;
import com.skcc.wallet.framework.api.http.model.GetTcashTransactionHistoryRq;
import com.skcc.wallet.framework.api.http.model.GetTemplateInfoRq;
import com.skcc.wallet.framework.api.http.model.GetTncRq;
import com.skcc.wallet.framework.api.http.model.GetTransferInfoRq;
import com.skcc.wallet.framework.api.http.model.GetUserProfileRq;
import com.skcc.wallet.framework.api.http.model.GetVCardTransactionRs;
import com.skcc.wallet.framework.api.http.model.GetWalletCertificateRq;
import com.skcc.wallet.framework.api.http.model.LoginRq;
import com.skcc.wallet.framework.api.http.model.MobileInfo;
import com.skcc.wallet.framework.api.http.model.NfcActivationRq;
import com.skcc.wallet.framework.api.http.model.NfcActivationRs;
import com.skcc.wallet.framework.api.http.model.NfcDeactivationRq;
import com.skcc.wallet.framework.api.http.model.NfcDeactivationRs;
import com.skcc.wallet.framework.api.http.model.PayWithTcashRq;
import com.skcc.wallet.framework.api.http.model.PurchaseWithTcashRq;
import com.skcc.wallet.framework.api.http.model.RegisterUserMobileRq;
import com.skcc.wallet.framework.api.http.model.RegisterUserRq;
import com.skcc.wallet.framework.api.http.model.RemoveLoyaltyCardRq;
import com.skcc.wallet.framework.api.http.model.RemoveLoyaltyCardRs;
import com.skcc.wallet.framework.api.http.model.RemoveTcashFavoriteTransactionRq;
import com.skcc.wallet.framework.api.http.model.ReportEligibilityFailRq;
import com.skcc.wallet.framework.api.http.model.ReportExceptionTraceRq;
import com.skcc.wallet.framework.api.http.model.RequestAddNewLoyaltyCardRq;
import com.skcc.wallet.framework.api.http.model.RequestAddNewLoyaltyCardRs;
import com.skcc.wallet.framework.api.http.model.RequestCouponDeleteRq;
import com.skcc.wallet.framework.api.http.model.RequestCouponDownloadRq;
import com.skcc.wallet.framework.api.http.model.RequestCouponRedemptionRq;
import com.skcc.wallet.framework.api.http.model.RequestOtpRq;
import com.skcc.wallet.framework.api.http.model.ResetTcashPinRq;
import com.skcc.wallet.framework.api.http.model.ResultRs;
import com.skcc.wallet.framework.api.http.model.SetTcashFavoriteTransactionRq;
import com.skcc.wallet.framework.api.http.model.SetTcashPinAfterResetRq;
import com.skcc.wallet.framework.api.http.model.SetTcashPinForRegisterRq;
import com.skcc.wallet.framework.api.http.model.SetTcashPinRq;
import com.skcc.wallet.framework.api.http.model.SetUserProfileRq;
import com.skcc.wallet.framework.api.http.model.SmsBank;
import com.skcc.wallet.framework.api.http.model.StickerActivationRq;
import com.skcc.wallet.framework.api.http.model.StickerActivationRs;
import com.skcc.wallet.framework.api.http.model.StickerDeactivationRq;
import com.skcc.wallet.framework.api.http.model.StickerDeactivationRs;
import com.skcc.wallet.framework.api.http.model.TcashFavorite;
import com.skcc.wallet.framework.api.http.model.TcashTransactionRequest;
import com.skcc.wallet.framework.api.http.model.TopupPrepaidCardRq;
import com.skcc.wallet.framework.api.http.model.TopupPrepaidCardRs;
import com.skcc.wallet.framework.api.http.model.TopupSmsBankRq;
import com.skcc.wallet.framework.api.http.model.TransferWithTcashRq;
import com.skcc.wallet.framework.api.http.model.UnlinkOtherNfcTagRq;
import com.skcc.wallet.framework.api.http.model.UserInfo;
import com.skcc.wallet.framework.api.http.model.VerifyOtpRq;
import com.skcc.wallet.framework.api.http.model.VerifySecurityAnswerRq;
import com.skcc.wallet.framework.api.http.model.VerifyTcashPinForRegisterRq;
import com.skcc.wallet.framework.api.http.model.VerifyTcashSecurityAnswerRq;
import com.skcc.wallet.framework.api.http.model.VerifyUserRq;
import com.skcc.wallet.framework.api.u.AnonymousClass10;
import com.skcc.wallet.framework.api.u.AnonymousClass11;
import com.skcc.wallet.framework.api.u.AnonymousClass12;
import com.skcc.wallet.framework.api.u.AnonymousClass13;
import com.skcc.wallet.framework.api.u.AnonymousClass14;
import com.skcc.wallet.framework.api.u.AnonymousClass15;
import com.skcc.wallet.framework.p060b.C1301b;
import com.skcc.wallet.framework.p061c.C1303a;
import com.skcc.wallet.framework.p061c.C1306c;

public class C1298u {
    private static String f2773e = "org.simalliance.openmobileapi";
    private C1302b f2774a;
    private String f2775b;
    private C1303a f2776c;
    private boolean f2777d = true;
    private C1241b f2778f;

    public C1298u(C1302b c1302b, String str) {
        this.f2774a = c1302b;
        this.f2775b = str;
        this.f2776c = new C1303a(c1302b);
        this.f2778f = new C1241b(c1302b.m4744d());
    }

    private CommonHeader m4661a() {
        C1272r e = this.f2774a.m4745e();
        CommonHeader commonHeader = new CommonHeader();
        commonHeader.setMsisdn(e.m4651b("msisdn", ""));
        commonHeader.setCustomerId(e.m4651b("customer_id", ""));
        commonHeader.setTid("v" + this.f2776c.m4749c() + "_" + e.m4651b("msisdn", "") + "_" + System.currentTimeMillis());
        String b = e.m4651b("Telkom_language", "");
        C1216a.m4522b("LANGUAGE ", "language " + b + "vs " + "English");
        if ("en".equals(b)) {
            commonHeader.setLocale("en");
        } else if ("in".equals(b) || "id".equals(b)) {
            commonHeader.setLocale("id");
        }
        return commonHeader;
    }

    private void m4663a(VerifyUserRq verifyUserRq, C1245f c1245f) {
        this.f2778f.m4564a("verifyUser", (Object) verifyUserRq, c1245f);
    }

    public static boolean m4664a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String[] systemSharedLibraryNames = context.getPackageManager().getSystemSharedLibraryNames();
        if (systemSharedLibraryNames == null) {
            return false;
        }
        for (Object equals : systemSharedLibraryNames) {
            if (str.equals(equals)) {
                return true;
            }
        }
        return false;
    }

    public void m4668a(double d, double d2, C1245f c1245f) {
        Object getRetailStoreLocationRq = new GetRetailStoreLocationRq();
        getRetailStoreLocationRq.setCommonHeader(m4661a());
        getRetailStoreLocationRq.setLatitude(d);
        getRetailStoreLocationRq.setLongitude(d2);
        this.f2778f.m4564a("getRetailStoreLocation", getRetailStoreLocationRq, c1245f);
    }

    public void m4669a(int i, int i2, C1245f c1245f) {
        Object getMWalletNotificationRq = new GetMWalletNotificationRq();
        getMWalletNotificationRq.setCommonHeader(m4661a());
        getMWalletNotificationRq.setPageNo(i2);
        getMWalletNotificationRq.setRownum(i);
        this.f2778f.m4564a("getMWalletNotification", getMWalletNotificationRq, c1245f);
    }

    public void m4670a(long j, long j2, C1245f c1245f) {
        Object getTcashTransactionHistoryRq = new GetTcashTransactionHistoryRq();
        getTcashTransactionHistoryRq.setCommonHeader(m4661a());
        getTcashTransactionHistoryRq.setRowPerPage(j);
        getTcashTransactionHistoryRq.setPageNum(j2);
        this.f2778f.m4564a("getTcashTransactionHistory", getTcashTransactionHistoryRq, c1245f);
    }

    public void m4671a(final C1231f c1231f) {
        new Thread(new Runnable(this) {
            final /* synthetic */ C1298u f2765b;

            public void run() {
                GetAvailLoyaltyCardListRq getAvailLoyaltyCardListRq = new GetAvailLoyaltyCardListRq();
                getAvailLoyaltyCardListRq.setCommonHeader(this.f2765b.m4661a());
                try {
                    final GetAvailLoyaltyCardListRs a = this.f2765b.f2774a.m4744d().m4624h().m4576a(getAvailLoyaltyCardListRq);
                    C1306c.m4764a(new Runnable(this) {
                        final /* synthetic */ C12958 f2763b;

                        public void run() {
                            if (a == null) {
                                c1231f.mo1491b();
                            } else if (a.getResult() == null) {
                                c1231f.mo1491b();
                            } else if (a.getResult().getCode() != 0) {
                                c1231f.mo1506a(a.getResult().getCode(), a.getResult().getMessage());
                            } else {
                                c1231f.mo1507a(a.getLoyaltyCardList());
                            }
                        }
                    });
                } catch (C1248i e) {
                    c1231f.mo1487a();
                } catch (C1249j e2) {
                    c1231f.mo1491b();
                } catch (C1247h e3) {
                    c1231f.mo1492c();
                } catch (Exception e4) {
                    e4.printStackTrace();
                    c1231f.mo1491b();
                }
            }
        }).start();
    }

    public void m4672a(C1245f c1245f) {
        Object countDownloadedCouponRq = new CountDownloadedCouponRq();
        countDownloadedCouponRq.setCommonHeader(m4661a());
        this.f2778f.m4564a("countDownloadedCoupon", countDownloadedCouponRq, c1245f);
    }

    public void m4673a(SmsBank smsBank, C1245f c1245f) {
        Object topupSmsBankRq = new TopupSmsBankRq();
        topupSmsBankRq.setCommonHeader(m4661a());
        topupSmsBankRq.setSmsBank(smsBank);
        this.f2778f.m4564a("topupSmsBank", topupSmsBankRq, c1245f);
    }

    public void m4674a(TcashFavorite tcashFavorite, C1245f c1245f) {
        Object changeTcashFavoriteTransactionRq = new ChangeTcashFavoriteTransactionRq();
        changeTcashFavoriteTransactionRq.setCommonHeader(m4661a());
        changeTcashFavoriteTransactionRq.setTcashFavorite(tcashFavorite);
        this.f2778f.m4564a("changeTcashFavoriteTransaction", changeTcashFavoriteTransactionRq, c1245f);
    }

    public void m4675a(TcashTransactionRequest tcashTransactionRequest, C1245f c1245f) {
        Object getPurchaseInfoRq = new GetPurchaseInfoRq();
        getPurchaseInfoRq.setCommonHeader(m4661a());
        getPurchaseInfoRq.setTcashTransactionRequest(tcashTransactionRequest);
        this.f2778f.m4564a("getPurchaseInfo", getPurchaseInfoRq, c1245f);
    }

    public void m4676a(UserInfo userInfo, C1245f c1245f) {
        Object setUserProfileRq = new SetUserProfileRq();
        setUserProfileRq.setCommonHeader(m4661a());
        setUserProfileRq.setUserInfo(userInfo);
        this.f2778f.m4564a("setUserProfile", setUserProfileRq, c1245f);
    }

    public void m4677a(UserInfo userInfo, MobileInfo mobileInfo, C1245f c1245f) {
        Object registerUserRq = new RegisterUserRq();
        registerUserRq.setCommonHeader(m4661a());
        registerUserRq.setUserInfo(userInfo);
        registerUserRq.setMobileInfo(mobileInfo);
        this.f2778f.m4564a("registerUser", registerUserRq, c1245f);
    }

    public void m4678a(final C1261k c1261k) {
        if (C1298u.m4664a(this.f2774a, f2773e)) {
            new Thread(new Runnable(this) {
                final /* synthetic */ C1298u f2736b;

                class C12751 implements Runnable {
                    final /* synthetic */ C12831 f2699a;

                    C12751(C12831 c12831) {
                        this.f2699a = c12831;
                    }

                    public void run() {
                        c1261k.mo1471a();
                    }
                }

                class C12762 implements C1261k {
                    final /* synthetic */ C12831 f2700a;

                    C12762(C12831 c12831) {
                        this.f2700a = c12831;
                    }

                    public void mo1471a() {
                        this.f2700a.f2736b.f2777d = true;
                        c1261k.mo1471a();
                    }

                    public void mo1472b() {
                        this.f2700a.f2736b.f2777d = true;
                        c1261k.mo1472b();
                    }
                }

                public void run() {
                    if (this.f2736b.f2774a.m4742b().m4642d()) {
                        this.f2736b.f2777d = true;
                        c1261k.mo1471a();
                        return;
                    }
                    if (TextUtils.isEmpty(this.f2736b.f2774a.m4745e().m4651b("walletPkgName", ""))) {
                        C1306c.m4763a(this.f2736b.f2774a);
                    }
                    if (this.f2736b.f2774a.m4742b().m4642d()) {
                        C1306c.m4764a(new C12751(this));
                        return;
                    }
                    this.f2736b.f2774a.m4742b().m4639a(new C12762(this));
                    this.f2736b.f2774a.m4742b().m4638a();
                    try {
                        Thread.sleep(2000);
                        if (!this.f2736b.f2777d && !this.f2736b.f2774a.m4742b().m4642d()) {
                            C1216a.m4519a("WalletManager", "connent SE() postDelayed failed...");
                            c1261k.mo1472b();
                        }
                    } catch (InterruptedException e) {
                        C1216a.m4519a("WalletManager", "connent SE() thread interupted..");
                        e.printStackTrace();
                    }
                }
            }).start();
            return;
        }
        C1216a.m4519a("WalletManager", "SE connention failed. becuase of open mobile api not supported!");
        c1261k.mo1472b();
    }

    public void m4679a(final C1273s c1273s) {
        new Thread(new Runnable(this) {
            final /* synthetic */ C1298u f2711b;

            public void run() {
                CheckStatusStickerRq checkStatusStickerRq = new CheckStatusStickerRq();
                checkStatusStickerRq.setCommonHeader(this.f2711b.m4661a());
                try {
                    final CheckStatusStickerRs a = this.f2711b.f2774a.m4744d().m4623g().m4590a(checkStatusStickerRq);
                    C1306c.m4764a(new Runnable(this) {
                        final /* synthetic */ AnonymousClass11 f2709b;

                        public void run() {
                            if (a == null) {
                                c1273s.mo1491b();
                            } else if (a.getResult() == null) {
                                c1273s.mo1491b();
                            } else if (a.getResult().getCode() != 0) {
                                c1273s.mo1576a(a.getResult().getCode(), a.getResult().getMessage());
                            } else {
                                c1273s.mo1577a(a.getSerialNumber(), a.getStickerUid());
                            }
                        }
                    });
                } catch (C1248i e) {
                    c1273s.mo1487a();
                } catch (C1249j e2) {
                    c1273s.mo1491b();
                } catch (C1247h e3) {
                    c1273s.mo1492c();
                } catch (Exception e4) {
                    e4.printStackTrace();
                    c1273s.mo1491b();
                }
            }
        }).start();
    }

    public void m4680a(final C1301b c1301b, final C1229d c1229d) {
        new Thread(new Runnable(this) {
            final /* synthetic */ C1298u f2751c;

            public void run() {
                c1301b.m4738a("method", "checkBalance");
                try {
                    final CheckBalanceRs b = this.f2751c.f2774a.m4744d().m4623g().m4598b(c1301b);
                    C1306c.m4764a(new Runnable(this) {
                        final /* synthetic */ C12895 f2748b;

                        public void run() {
                            if (b == null) {
                                c1229d.mo1491b();
                            } else if (b.getStatus() != 1) {
                                c1229d.mo1508a(b.getStatus(), b.getMessage());
                            } else {
                                c1229d.mo1509a(b.getCardId(), b.getBalance());
                            }
                        }
                    });
                } catch (C1248i e) {
                    c1229d.mo1487a();
                } catch (C1249j e2) {
                    c1229d.mo1491b();
                } catch (C1247h e3) {
                    c1229d.mo1492c();
                } catch (Exception e4) {
                    e4.printStackTrace();
                    c1229d.mo1491b();
                }
            }
        }).start();
    }

    public void m4681a(final C1301b c1301b, final C1230e c1230e) {
        new Thread(new Runnable(this) {
            final /* synthetic */ C1298u f2756c;

            public void run() {
                c1301b.m4738a("method", "createCard");
                try {
                    final CreateCardRs c = this.f2756c.f2774a.m4744d().m4623g().m4599c(c1301b);
                    C1306c.m4764a(new Runnable(this) {
                        final /* synthetic */ C12916 f2753b;

                        public void run() {
                            if (c == null) {
                                c1230e.mo1491b();
                            } else if (c.getStatus() != 1) {
                                c1230e.mo1500a(c.getStatus(), c.getMessage());
                            } else {
                                c1230e.mo1501a(c.getVCard());
                            }
                        }
                    });
                } catch (C1248i e) {
                    c1230e.mo1487a();
                } catch (C1249j e2) {
                    c1230e.mo1491b();
                } catch (C1247h e3) {
                    c1230e.mo1492c();
                } catch (Exception e4) {
                    e4.printStackTrace();
                    c1230e.mo1491b();
                }
            }
        }).start();
    }

    public void m4682a(final C1301b c1301b, final C1232g c1232g) {
        new Thread(new Runnable(this) {
            final /* synthetic */ C1298u f2761c;

            public void run() {
                c1301b.m4738a("method", "getTransaction");
                try {
                    final GetVCardTransactionRs d = this.f2761c.f2774a.m4744d().m4623g().m4600d(c1301b);
                    C1306c.m4764a(new Runnable(this) {
                        final /* synthetic */ C12937 f2758b;

                        public void run() {
                            if (d == null) {
                                c1232g.mo1491b();
                            } else if (d.getStatus() != 1) {
                                c1232g.mo1514a(d.getStatus(), d.getMessage());
                            } else {
                                c1232g.mo1515a(d.getTransactions());
                            }
                        }
                    });
                } catch (C1248i e) {
                    c1232g.mo1487a();
                } catch (C1249j e2) {
                    c1232g.mo1491b();
                } catch (C1247h e3) {
                    c1232g.mo1492c();
                } catch (Exception e4) {
                    e4.printStackTrace();
                    c1232g.mo1491b();
                }
            }
        }).start();
    }

    public void m4683a(final String str) {
        new Thread(new Runnable(this) {
            final /* synthetic */ C1298u f2744b;

            public void run() {
                ReportExceptionTraceRq reportExceptionTraceRq = new ReportExceptionTraceRq();
                reportExceptionTraceRq.setStackTrace(str);
                reportExceptionTraceRq.setModelName(Build.MODEL);
                reportExceptionTraceRq.setImei(new C1303a(this.f2744b.f2774a).m4751e());
                reportExceptionTraceRq.setImsi(((TelephonyManager) this.f2744b.f2774a.getSystemService("phone")).getSubscriberId());
                ResultRs resultRs = null;
                try {
                    resultRs = this.f2744b.f2774a.m4744d().m4623g().m4594a(reportExceptionTraceRq);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (resultRs == null) {
                    C1216a.m4523c("WalletManager", "reportExceptionTrace error!");
                }
            }
        }).start();
    }

    public void m4684a(String str, C1245f c1245f) {
        this.f2774a.m4744d().m4618b();
        Object verifyOtpRq = new VerifyOtpRq();
        verifyOtpRq.setCommonHeader(m4661a());
        verifyOtpRq.setOtp(str);
        this.f2778f.m4564a("verifyOtp", verifyOtpRq, c1245f);
    }

    public void m4685a(final String str, final C1273s c1273s) {
        new Thread(new Runnable(this) {
            final /* synthetic */ C1298u f2722c;

            public void run() {
                StickerDeactivationRq stickerDeactivationRq = new StickerDeactivationRq();
                stickerDeactivationRq.setCommonHeader(this.f2722c.m4661a());
                stickerDeactivationRq.setTcashPin(str);
                try {
                    final StickerDeactivationRs a = this.f2722c.f2774a.m4744d().m4623g().m4596a(stickerDeactivationRq);
                    C1306c.m4764a(new Runnable(this) {
                        final /* synthetic */ AnonymousClass13 f2719b;

                        public void run() {
                            if (a == null) {
                                c1273s.mo1491b();
                            } else if (a.getResult() == null) {
                                c1273s.mo1491b();
                            } else if (a.getResult().getCode() != 0) {
                                c1273s.mo1576a(a.getResult().getCode(), a.getResult().getMessage());
                            } else {
                                c1273s.mo1577a(a.getSerialNumber(), a.getStickerUid());
                            }
                        }
                    });
                } catch (C1248i e) {
                    c1273s.mo1487a();
                } catch (C1249j e2) {
                    c1273s.mo1491b();
                } catch (C1247h e3) {
                    c1273s.mo1492c();
                } catch (Exception e4) {
                    e4.printStackTrace();
                    c1273s.mo1491b();
                }
            }
        }).start();
    }

    public void m4686a(String str, String str2, C1245f c1245f) {
        this.f2774a.m4744d().m4618b();
        Object checkWalletUpdateRq = new CheckWalletUpdateRq();
        checkWalletUpdateRq.setCommonHeader(m4661a());
        checkWalletUpdateRq.setWalletId(str);
        checkWalletUpdateRq.setOsType("Android");
        checkWalletUpdateRq.setVersion(str2);
        this.f2778f.m4564a("checkWalletUpdate", checkWalletUpdateRq, c1245f);
    }

    public void m4687a(String str, String str2, MobileInfo mobileInfo, C1245f c1245f) {
        Object registerUserMobileRq = new RegisterUserMobileRq();
        registerUserMobileRq.setCommonHeader(m4661a());
        registerUserMobileRq.setEncTcashPin(str);
        registerUserMobileRq.setToken(str2);
        registerUserMobileRq.setMobileInfo(mobileInfo);
        this.f2778f.m4564a("registerUserMobile", registerUserMobileRq, c1245f);
    }

    public void m4688a(final String str, final String str2, final C1273s c1273s) {
        new Thread(new Runnable(this) {
            final /* synthetic */ C1298u f2717d;

            public void run() {
                StickerActivationRq stickerActivationRq = new StickerActivationRq();
                stickerActivationRq.setCommonHeader(this.f2717d.m4661a());
                stickerActivationRq.setTcashPin(str);
                stickerActivationRq.setSerialNumber(str2);
                try {
                    final StickerActivationRs a = this.f2717d.f2774a.m4744d().m4623g().m4595a(stickerActivationRq);
                    C1306c.m4764a(new Runnable(this) {
                        final /* synthetic */ AnonymousClass12 f2713b;

                        public void run() {
                            if (a == null) {
                                c1273s.mo1491b();
                            } else if (a.getResult() == null) {
                                c1273s.mo1491b();
                            } else if (a.getResult().getCode() != 0) {
                                c1273s.mo1576a(a.getResult().getCode(), a.getResult().getMessage());
                            } else {
                                c1273s.mo1577a(a.getSerialNumber(), a.getStickerUid());
                            }
                        }
                    });
                } catch (C1248i e) {
                    c1273s.mo1487a();
                } catch (C1249j e2) {
                    c1273s.mo1491b();
                } catch (C1247h e3) {
                    c1273s.mo1492c();
                } catch (Exception e4) {
                    e4.printStackTrace();
                    c1273s.mo1491b();
                }
            }
        }).start();
    }

    public void m4689a(final String str, final String str2, final C1274t c1274t) {
        new Thread(new Runnable(this) {
            final /* synthetic */ C1298u f2742d;

            public void run() {
                TopupPrepaidCardRq topupPrepaidCardRq = new TopupPrepaidCardRq();
                topupPrepaidCardRq.setServiceId(str);
                topupPrepaidCardRq.setAmount(str2);
                topupPrepaidCardRq.setCommonHeader(this.f2742d.m4661a());
                try {
                    final TopupPrepaidCardRs a = this.f2742d.f2774a.m4744d().m4623g().m4597a(topupPrepaidCardRq);
                    C1306c.m4764a(new Runnable(this) {
                        final /* synthetic */ C12852 f2738b;

                        public void run() {
                            if (a == null) {
                                c1274t.mo1491b();
                            } else if (a.getResult() == null) {
                                c1274t.mo1491b();
                            } else if (a.getResult().getCode() != 0) {
                                c1274t.mo1512a(a.getResult().getCode(), a.getResult().getMessage());
                            } else {
                                c1274t.mo1513a(a.getBalance());
                            }
                        }
                    });
                } catch (C1248i e) {
                    c1274t.mo1487a();
                } catch (C1249j e2) {
                    c1274t.mo1491b();
                } catch (C1247h e3) {
                    c1274t.mo1492c();
                } catch (Exception e4) {
                    e4.printStackTrace();
                    c1274t.mo1491b();
                }
            }
        }).start();
    }

    public void m4690a(String str, String str2, String str3, C1245f c1245f) {
        Object requestCouponDownloadRq = new RequestCouponDownloadRq();
        requestCouponDownloadRq.setCommonHeader(m4661a());
        requestCouponDownloadRq.setCampaignId(str);
        requestCouponDownloadRq.setMerchantId(str2);
        requestCouponDownloadRq.setCouponProfileNo(str3);
        this.f2778f.m4564a("requestCouponDownload", requestCouponDownloadRq, c1245f);
    }

    public void m4691a(String str, String str2, String str3, C1263m c1263m) {
        final String str4 = str;
        final String str5 = str2;
        final String str6 = str3;
        final C1263m c1263m2 = c1263m;
        new Thread(new Runnable(this) {
            final /* synthetic */ C1298u f2707e;

            public void run() {
                RemoveLoyaltyCardRq removeLoyaltyCardRq = new RemoveLoyaltyCardRq();
                removeLoyaltyCardRq.setCommonHeader(this.f2707e.m4661a());
                removeLoyaltyCardRq.setLoyaltyCardInstanceId(str4);
                removeLoyaltyCardRq.setLoyaltyCardProfileNo(str5);
                removeLoyaltyCardRq.setMerchantId(str6);
                try {
                    final RemoveLoyaltyCardRs a = this.f2707e.f2774a.m4744d().m4624h().m4577a(removeLoyaltyCardRq);
                    C1306c.m4764a(new Runnable(this) {
                        final /* synthetic */ AnonymousClass10 f2702b;

                        public void run() {
                            if (a == null) {
                                c1263m2.mo1491b();
                            } else if (a.getResult() == null) {
                                c1263m2.mo1491b();
                            } else if (a.getResult().getCode() != 0) {
                                c1263m2.mo1510a(a.getResult().getCode(), a.getResult().getMessage());
                            } else {
                                c1263m2.mo1511d();
                            }
                        }
                    });
                } catch (C1248i e) {
                    c1263m2.mo1487a();
                } catch (C1249j e2) {
                    c1263m2.mo1491b();
                } catch (C1247h e3) {
                    c1263m2.mo1492c();
                } catch (Exception e4) {
                    e4.printStackTrace();
                    c1263m2.mo1491b();
                }
            }
        }).start();
    }

    public void m4692a(String str, String str2, String str3, C1264n c1264n) {
        final String str4 = str;
        final String str5 = str2;
        final String str6 = str3;
        final C1264n c1264n2 = c1264n;
        new Thread(new Runnable(this) {
            final /* synthetic */ C1298u f2772e;

            public void run() {
                RequestAddNewLoyaltyCardRq requestAddNewLoyaltyCardRq = new RequestAddNewLoyaltyCardRq();
                requestAddNewLoyaltyCardRq.setCommonHeader(this.f2772e.m4661a());
                requestAddNewLoyaltyCardRq.setMerchantId(str4);
                requestAddNewLoyaltyCardRq.setLoyaltyCardProfileNo(str5);
                requestAddNewLoyaltyCardRq.setLoyaltyCardNumber(str6);
                try {
                    final RequestAddNewLoyaltyCardRs a = this.f2772e.f2774a.m4744d().m4624h().m4578a(requestAddNewLoyaltyCardRq);
                    C1306c.m4764a(new Runnable(this) {
                        final /* synthetic */ C12979 f2767b;

                        public void run() {
                            if (a == null) {
                                c1264n2.mo1491b();
                            } else if (a.getResult() == null) {
                                c1264n2.mo1491b();
                            } else if (a.getResult().getCode() != 0) {
                                c1264n2.mo1502a(a.getResult().getCode(), a.getResult().getMessage());
                            } else {
                                c1264n2.mo1503d();
                            }
                        }
                    });
                } catch (C1248i e) {
                    c1264n2.mo1487a();
                } catch (C1249j e2) {
                    c1264n2.mo1491b();
                } catch (C1247h e3) {
                    c1264n2.mo1492c();
                } catch (Exception e4) {
                    e4.printStackTrace();
                    c1264n2.mo1491b();
                }
            }
        }).start();
    }

    public void m4693a(String str, String str2, String str3, String str4, C1245f c1245f) {
        Object loginRq = new LoginRq();
        loginRq.setCommonHeader(m4661a());
        loginRq.setImsi(str);
        loginRq.setImei(str2);
        loginRq.setToken(str3);
        loginRq.setCMac(str4);
        loginRq.setPushId(this.f2774a.m4745e().m4651b("gcm_registration_id", ""));
        this.f2778f.m4564a("login", loginRq, c1245f);
    }

    public void m4694a(String str, String str2, String str3, String str4, String str5, C1245f c1245f) {
        VerifyUserRq verifyUserRq = new VerifyUserRq();
        CommonHeader a = m4661a();
        a.setPin(str);
        verifyUserRq.setCommonHeader(a);
        verifyUserRq.setFirstName(str2);
        verifyUserRq.setLastName(str3);
        verifyUserRq.setDateOfBirth(str4);
        verifyUserRq.setEmail(str5);
        m4663a(verifyUserRq, c1245f);
    }

    public void m4695a(String str, String str2, String str3, String str4, String str5, String str6, C1245f c1245f) {
        Object verifyTcashSecurityAnswerRq = new VerifyTcashSecurityAnswerRq();
        verifyTcashSecurityAnswerRq.setCommonHeader(m4661a());
        verifyTcashSecurityAnswerRq.setAnswer(str3);
        verifyTcashSecurityAnswerRq.setIdentityNumber(str2);
        verifyTcashSecurityAnswerRq.setBirthDay(str);
        verifyTcashSecurityAnswerRq.setFirstName(str4);
        verifyTcashSecurityAnswerRq.setLastName(str5);
        verifyTcashSecurityAnswerRq.setEmail(str6);
        this.f2778f.m4564a("verifyTCashSecurityAnswer", verifyTcashSecurityAnswerRq, c1245f);
    }

    public void m4696a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, C1245f c1245f) {
        Object requestCouponRedemptionRq = new RequestCouponRedemptionRq();
        requestCouponRedemptionRq.setCommonHeader(m4661a());
        requestCouponRedemptionRq.setCampaignId(str);
        requestCouponRedemptionRq.setMerchantId(str2);
        requestCouponRedemptionRq.setCouponSerialNo(str3);
        requestCouponRedemptionRq.setCouponProfileNo(str4);
        requestCouponRedemptionRq.setRedeemType(str5);
        requestCouponRedemptionRq.setCouponCampaignKey(str7);
        requestCouponRedemptionRq.setBranchId(str8);
        this.f2778f.m4564a("requestCouponRedemption", requestCouponRedemptionRq, c1245f);
    }

    public void m4697b(double d, double d2, C1245f c1245f) {
        Object getGrafariLocationRq = new GetGrafariLocationRq();
        getGrafariLocationRq.setCommonHeader(m4661a());
        getGrafariLocationRq.setLatitude(d);
        getGrafariLocationRq.setLongitude(d2);
        this.f2778f.m4564a("getGrafariLocation", getGrafariLocationRq, c1245f);
    }

    public void m4698b(C1245f c1245f) {
        Object requestOtpRq = new RequestOtpRq();
        requestOtpRq.setCommonHeader(m4661a());
        this.f2778f.m4564a("requestOtp", requestOtpRq, c1245f);
    }

    public void m4699b(TcashFavorite tcashFavorite, C1245f c1245f) {
        Object setTcashFavoriteTransactionRq = new SetTcashFavoriteTransactionRq();
        setTcashFavoriteTransactionRq.setCommonHeader(m4661a());
        setTcashFavoriteTransactionRq.setTcashFavorite(tcashFavorite);
        this.f2778f.m4564a("setTcashFavoriteTransaction", setTcashFavoriteTransactionRq, c1245f);
    }

    public void m4700b(TcashTransactionRequest tcashTransactionRequest, C1245f c1245f) {
        Object purchaseWithTcashRq = new PurchaseWithTcashRq();
        purchaseWithTcashRq.setCommonHeader(m4661a());
        purchaseWithTcashRq.setTcashTransactionRequest(tcashTransactionRequest);
        this.f2778f.m4564a("purchaseWithTcash", purchaseWithTcashRq, c1245f);
    }

    public void m4701b(final String str) {
        new Thread(new Runnable(this) {
            final /* synthetic */ C1298u f2746b;

            public void run() {
                ReportEligibilityFailRq reportEligibilityFailRq = new ReportEligibilityFailRq();
                reportEligibilityFailRq.setStackTrace(str);
                reportEligibilityFailRq.setModelName(Build.MODEL);
                reportEligibilityFailRq.setImei(new C1303a(this.f2746b.f2774a).m4751e());
                reportEligibilityFailRq.setImsi(((TelephonyManager) this.f2746b.f2774a.getSystemService("phone")).getSubscriberId());
                ResultRs resultRs = null;
                try {
                    resultRs = this.f2746b.f2774a.m4744d().m4623g().m4593a(reportEligibilityFailRq);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (resultRs == null) {
                    C1216a.m4523c("WalletManager", "reportEligibilityFail error!");
                }
            }
        }).start();
    }

    public void m4702b(String str, C1245f c1245f) {
        Object getSecurityQuestionRq = new GetSecurityQuestionRq();
        getSecurityQuestionRq.setCommonHeader(m4661a());
        getSecurityQuestionRq.setTemporaryCustomerId(str);
        this.f2778f.m4564a("getSecurityQuestion", getSecurityQuestionRq, c1245f);
    }

    public void m4703b(String str, String str2, C1245f c1245f) {
        Object changeMWalletPinRq = new ChangeMWalletPinRq();
        changeMWalletPinRq.setCommonHeader(m4661a());
        changeMWalletPinRq.setToken(str);
        changeMWalletPinRq.setEncryptedToken(str2);
        this.f2778f.m4564a("changeMWalletPin", changeMWalletPinRq, c1245f);
    }

    public void m4704b(final String str, final String str2, final C1273s c1273s) {
        new Thread(new Runnable(this) {
            final /* synthetic */ C1298u f2728d;

            public void run() {
                NfcActivationRq nfcActivationRq = new NfcActivationRq();
                nfcActivationRq.setCommonHeader(this.f2728d.m4661a());
                nfcActivationRq.setTcashPin(str);
                nfcActivationRq.setSerialNumber(str2);
                try {
                    final NfcActivationRs a = this.f2728d.f2774a.m4744d().m4623g().m4591a(nfcActivationRq);
                    C1306c.m4764a(new Runnable(this) {
                        final /* synthetic */ AnonymousClass14 f2724b;

                        public void run() {
                            if (a == null) {
                                c1273s.mo1491b();
                            } else if (a.getResult() == null) {
                                c1273s.mo1491b();
                            } else if (a.getResult().getCode() != 0) {
                                c1273s.mo1576a(a.getResult().getCode(), a.getResult().getMessage());
                            } else {
                                c1273s.mo1577a(a.getSerialNumber(), null);
                            }
                        }
                    });
                } catch (C1248i e) {
                    c1273s.mo1487a();
                } catch (C1249j e2) {
                    c1273s.mo1491b();
                } catch (C1247h e3) {
                    c1273s.mo1492c();
                } catch (Exception e4) {
                    e4.printStackTrace();
                    c1273s.mo1491b();
                }
            }
        }).start();
    }

    public void m4705b(String str, String str2, String str3, String str4, C1245f c1245f) {
        VerifyUserRq verifyUserRq = new VerifyUserRq();
        verifyUserRq.setCommonHeader(m4661a());
        verifyUserRq.setFirstName(str);
        verifyUserRq.setLastName(str2);
        verifyUserRq.setDateOfBirth(str3);
        verifyUserRq.setEmail(str4);
        m4663a(verifyUserRq, c1245f);
    }

    public void m4706b(String str, String str2, String str3, String str4, String str5, C1245f c1245f) {
        Object getAllCouponListRq = new GetAllCouponListRq();
        getAllCouponListRq.setCommonHeader(m4661a());
        getAllCouponListRq.setOrderType(str);
        getAllCouponListRq.setStartNumber(str2);
        getAllCouponListRq.setReturnCount(str3);
        getAllCouponListRq.setLatitude(str4);
        getAllCouponListRq.setLongitude(str5);
        this.f2778f.m4564a("getAllCouponList", getAllCouponListRq, c1245f);
    }

    public void m4707c(C1245f c1245f) {
        Object getMyLoyaltyCardListRq = new GetMyLoyaltyCardListRq();
        getMyLoyaltyCardListRq.setCommonHeader(m4661a());
        this.f2778f.m4564a("getMyLoyaltyCardList", getMyLoyaltyCardListRq, c1245f);
    }

    public void m4708c(TcashTransactionRequest tcashTransactionRequest, C1245f c1245f) {
        Object getTransferInfoRq = new GetTransferInfoRq();
        getTransferInfoRq.setCommonHeader(m4661a());
        getTransferInfoRq.setTcashTransactionRequest(tcashTransactionRequest);
        this.f2778f.m4564a("getTransferInfo", getTransferInfoRq, c1245f);
    }

    public void m4709c(String str, C1245f c1245f) {
        Object getTncRq = new GetTncRq();
        getTncRq.setCommonHeader(m4661a());
        getTncRq.setFileName(str);
        this.f2778f.m4564a("getTnc", getTncRq, c1245f);
    }

    public void m4710c(String str, String str2, C1245f c1245f) {
        Object changeTcashPinRq = new ChangeTcashPinRq();
        changeTcashPinRq.setCurrentPin(str);
        changeTcashPinRq.setNewPin(str2);
        changeTcashPinRq.setCommonHeader(m4661a());
        this.f2778f.m4564a("changeTCashPin", changeTcashPinRq, c1245f);
    }

    public void m4711c(final String str, final String str2, final C1273s c1273s) {
        new Thread(new Runnable(this) {
            final /* synthetic */ C1298u f2734d;

            public void run() {
                NfcDeactivationRq nfcDeactivationRq = new NfcDeactivationRq();
                nfcDeactivationRq.setCommonHeader(this.f2734d.m4661a());
                nfcDeactivationRq.setTcashPin(str);
                nfcDeactivationRq.setSerialNumber(str2);
                try {
                    final NfcDeactivationRs a = this.f2734d.f2774a.m4744d().m4623g().m4592a(nfcDeactivationRq);
                    C1306c.m4764a(new Runnable(this) {
                        final /* synthetic */ AnonymousClass15 f2730b;

                        public void run() {
                            if (a == null) {
                                c1273s.mo1491b();
                            } else if (a.getResult() == null) {
                                c1273s.mo1491b();
                            } else if (a.getResult().getCode() != 0) {
                                c1273s.mo1576a(a.getResult().getCode(), a.getResult().getMessage());
                            } else {
                                c1273s.mo1577a(a.getSerialNumber(), null);
                            }
                        }
                    });
                } catch (C1248i e) {
                    c1273s.mo1487a();
                } catch (C1249j e2) {
                    c1273s.mo1491b();
                } catch (C1247h e3) {
                    c1273s.mo1492c();
                } catch (Exception e4) {
                    e4.printStackTrace();
                    c1273s.mo1491b();
                }
            }
        }).start();
    }

    public void m4712c(String str, String str2, String str3, String str4, C1245f c1245f) {
        Object verifySecurityAnswerRq = new VerifySecurityAnswerRq();
        verifySecurityAnswerRq.setCommonHeader(m4661a());
        verifySecurityAnswerRq.setAnswer(str);
        verifySecurityAnswerRq.setTemporaryCustomerId(str2);
        MobileInfo mobileInfo = new MobileInfo();
        mobileInfo.setModelNo(this.f2776c.m4747a());
        mobileInfo.setImei(this.f2776c.m4751e());
        mobileInfo.setImsi(this.f2776c.m4750d());
        mobileInfo.setPushId(str3);
        mobileInfo.setWalletVersion(str4);
        mobileInfo.setOsVer(this.f2776c.m4748b());
        verifySecurityAnswerRq.setMobileInfo(mobileInfo);
        this.f2778f.m4564a("verifySecurityAnswer", verifySecurityAnswerRq, c1245f);
    }

    public void m4713c(String str, String str2, String str3, String str4, String str5, C1245f c1245f) {
        Object requestCouponDeleteRq = new RequestCouponDeleteRq();
        requestCouponDeleteRq.setCommonHeader(m4661a());
        requestCouponDeleteRq.setCampaignId(str);
        requestCouponDeleteRq.setMerchantId(str2);
        requestCouponDeleteRq.setCouponProfileNo(str3);
        requestCouponDeleteRq.setCouponInstanceId(str5);
        requestCouponDeleteRq.setCouponSerialNo(str4);
        this.f2778f.m4564a("requestCouponDelete", requestCouponDeleteRq, c1245f);
    }

    public void m4714d(C1245f c1245f) {
        Object getUserProfileRq = new GetUserProfileRq();
        getUserProfileRq.setCommonHeader(m4661a());
        this.f2778f.m4564a("getUserProfile", getUserProfileRq, c1245f);
    }

    public void m4715d(TcashTransactionRequest tcashTransactionRequest, C1245f c1245f) {
        Object transferWithTcashRq = new TransferWithTcashRq();
        transferWithTcashRq.setCommonHeader(m4661a());
        transferWithTcashRq.setTcashTransactionRequest(tcashTransactionRequest);
        this.f2778f.m4564a("transferWithTcash", transferWithTcashRq, c1245f);
    }

    public void m4716d(String str, C1245f c1245f) {
        Object getTcashPurchaseTemplateRq = new GetTcashPurchaseTemplateRq();
        getTcashPurchaseTemplateRq.setCommonHeader(m4661a());
        getTcashPurchaseTemplateRq.setMenuId(str);
        this.f2778f.m4564a("getTcashPurchaseTemplate", getTcashPurchaseTemplateRq, c1245f);
    }

    public void m4717d(String str, String str2, C1245f c1245f) {
        Object getCouponDetailRq = new GetCouponDetailRq();
        getCouponDetailRq.setCommonHeader(m4661a());
        getCouponDetailRq.setCampaignId(str);
        getCouponDetailRq.setMerchantId(str2);
        this.f2778f.m4564a("getCouponDetail", getCouponDetailRq, c1245f);
    }

    public void m4718d(String str, String str2, String str3, String str4, String str5, C1245f c1245f) {
        Object resetTcashPinRq = new ResetTcashPinRq();
        resetTcashPinRq.setCommonHeader(m4661a());
        resetTcashPinRq.setBirthDay(str2);
        resetTcashPinRq.setIdentityNumber(str);
        resetTcashPinRq.setFirstName(str3);
        resetTcashPinRq.setLastName(str4);
        resetTcashPinRq.setOtp(str5);
        this.f2778f.m4564a("resetTcashPin", resetTcashPinRq, c1245f);
    }

    public void m4719e(C1245f c1245f) {
        Object getTcashFavoriteTransactionRq = new GetTcashFavoriteTransactionRq();
        getTcashFavoriteTransactionRq.setCommonHeader(m4661a());
        this.f2778f.m4564a("getTcashFavoriteTransaction", getTcashFavoriteTransactionRq, c1245f);
    }

    public void m4720e(TcashTransactionRequest tcashTransactionRequest, C1245f c1245f) {
        Object getPaymentInfoRq = new GetPaymentInfoRq();
        getPaymentInfoRq.setCommonHeader(m4661a());
        getPaymentInfoRq.setTcashTransactionRequest(tcashTransactionRequest);
        this.f2778f.m4564a("getPaymentInfo", getPaymentInfoRq, c1245f);
    }

    public void m4721e(String str, C1245f c1245f) {
        Object getTcashPaymentTemplateRq = new GetTcashPaymentTemplateRq();
        getTcashPaymentTemplateRq.setCommonHeader(m4661a());
        getTcashPaymentTemplateRq.setMenuId(str);
        this.f2778f.m4564a("getTcashPaymentTemplate", getTcashPaymentTemplateRq, c1245f);
    }

    public void m4722f(C1245f c1245f) {
        Object getMyDownloadCouponRq = new GetMyDownloadCouponRq();
        getMyDownloadCouponRq.setCommonHeader(m4661a());
        this.f2778f.m4564a("getMyDownloadCoupon", getMyDownloadCouponRq, c1245f);
    }

    public void m4723f(TcashTransactionRequest tcashTransactionRequest, C1245f c1245f) {
        Object payWithTcashRq = new PayWithTcashRq();
        payWithTcashRq.setCommonHeader(m4661a());
        payWithTcashRq.setTcashTransactionRequest(tcashTransactionRequest);
        this.f2778f.m4564a("payWithTcash", payWithTcashRq, c1245f);
    }

    public void m4724f(String str, C1245f c1245f) {
        Object getTcashTokenRq = new GetTcashTokenRq();
        getTcashTokenRq.setCommonHeader(m4661a());
        getTcashTokenRq.setTcashPin(str);
        this.f2778f.m4564a("getTcashToken", getTcashTokenRq, c1245f);
    }

    public void m4725g(C1245f c1245f) {
        this.f2774a.m4744d().m4618b();
        this.f2774a.m4745e().m4648a("COOKIE", null);
    }

    public void m4726g(String str, C1245f c1245f) {
        Object getServiceDetailRq = new GetServiceDetailRq();
        getServiceDetailRq.setCommonHeader(m4661a());
        getServiceDetailRq.setMenuId(str);
        this.f2778f.m4564a("getServiceDetail", getServiceDetailRq, c1245f);
    }

    public void m4727h(C1245f c1245f) {
        Object getWalletCertificateRq = new GetWalletCertificateRq();
        getWalletCertificateRq.setCommonHeader(m4661a());
        this.f2778f.m4564a("getWalletCertificate", getWalletCertificateRq, c1245f);
    }

    public void m4728h(String str, C1245f c1245f) {
        Object getTemplateInfoRq = new GetTemplateInfoRq();
        getTemplateInfoRq.setCommonHeader(m4661a());
        getTemplateInfoRq.setApiMenuId(str);
        this.f2778f.m4564a("getTemplateInfo", getTemplateInfoRq, c1245f);
    }

    public void m4729i(C1245f c1245f) {
        Object getTcashBalanceRq = new GetTcashBalanceRq();
        getTcashBalanceRq.setCommonHeader(m4661a());
        this.f2778f.m4564a("getTcashBalance", getTcashBalanceRq, c1245f);
    }

    public void m4730i(String str, C1245f c1245f) {
        Object removeTcashFavoriteTransactionRq = new RemoveTcashFavoriteTransactionRq();
        removeTcashFavoriteTransactionRq.setCommonHeader(m4661a());
        removeTcashFavoriteTransactionRq.setFavoriteMenuId(str);
        this.f2778f.m4564a("removeTcashFavoriteTransaction", removeTcashFavoriteTransactionRq, c1245f);
    }

    public void m4731j(String str, C1245f c1245f) {
        Object setTcashPinRq = new SetTcashPinRq();
        setTcashPinRq.setCommonHeader(m4661a());
        setTcashPinRq.setNewPin(str);
        this.f2778f.m4564a("setTcashPin", setTcashPinRq, c1245f);
    }

    public void m4732k(String str, C1245f c1245f) {
        Object verifyTcashPinForRegisterRq = new VerifyTcashPinForRegisterRq();
        verifyTcashPinForRegisterRq.setCommonHeader(m4661a());
        verifyTcashPinForRegisterRq.setEncTcashPin(str);
        this.f2778f.m4564a("verifyTcashPinForRegister", verifyTcashPinForRegisterRq, c1245f);
    }

    public void m4733l(String str, C1245f c1245f) {
        Object setTcashPinForRegisterRq = new SetTcashPinForRegisterRq();
        setTcashPinForRegisterRq.setCommonHeader(m4661a());
        setTcashPinForRegisterRq.setEncNewPin(str);
        this.f2778f.m4564a("setTcashPinForRegister", setTcashPinForRegisterRq, c1245f);
    }

    public void m4734m(String str, C1245f c1245f) {
        Object checkUserStatusRq = new CheckUserStatusRq();
        checkUserStatusRq.setCommonHeader(m4661a());
        checkUserStatusRq.setCheckMsisdn(str);
        this.f2778f.m4564a("checkUserStatus", checkUserStatusRq, c1245f);
    }

    public void m4735n(String str, C1245f c1245f) {
        Object unlinkOtherNfcTagRq = new UnlinkOtherNfcTagRq();
        unlinkOtherNfcTagRq.setCommonHeader(m4661a());
        unlinkOtherNfcTagRq.setNfcSerialNumber(str);
        this.f2778f.m4564a("unlinkOtherNfcTag", unlinkOtherNfcTagRq, c1245f);
    }

    public void m4736o(String str, C1245f c1245f) {
        Object setTcashPinAfterResetRq = new SetTcashPinAfterResetRq();
        setTcashPinAfterResetRq.setCommonHeader(m4661a());
        setTcashPinAfterResetRq.setNewPin(str);
        this.f2778f.m4564a("setTcashPinAfterReset", setTcashPinAfterResetRq, c1245f);
    }
}
