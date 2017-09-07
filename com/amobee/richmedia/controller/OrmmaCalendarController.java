package com.amobee.richmedia.controller;

import android.annotation.SuppressLint;
import android.app.AlertDialog.Builder;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.provider.CalendarContract.Calendars;
import android.provider.CalendarContract.Events;
import android.provider.CalendarContract.Reminders;
import android.widget.SimpleAdapter;
import com.amobee.adsdk.Log;
import com.amobee.richmedia.controller.OrmmaController.RecurrenceProperties;
import com.amobee.richmedia.view.AmobeeView;
import com.amobee.richmedia.view.AmobeeView.ViewState;
import com.skcc.wallet.framework.api.http.model.Condition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;

public class OrmmaCalendarController {
    private static final int DAYS_IN_MONTH = 31;
    private static final int DAYS_IN_YEAR = 365;
    private static final int FIRST_MONTH = 1;
    private static final int FIRST_WEEK = 1;
    private static final String FIRST_WEEK_DAYS = "1,2,3,4,5,6,7";
    private static final int FOURTH_WEEK = 4;
    private static final String FOURTH_WEEK_DAYS = "22,23,24,25,26,27,28,29,30,31";
    private static final int LAST_MONTH = 12;
    private static final int SECOND_WEEK = 2;
    private static final String SECOND_WEEK_DAYS = "8,9,10,11,12,13,14";
    private static final int THIRD_WEEK = 3;
    private static final String THIRD_WEEK_DAYS = "15,16,17,18,19,20,21";
    private static final int WEEKS_IN_MONTH = 4;
    private String LOG_TAG = "";
    private Cursor cursor = null;
    private final String[] daysInWeek = new String[]{"SU", "MO", "TU", "WE", "TH", "FR", "SA"};
    private String description = "";
    private String end = "";
    private int eventsCount = 0;
    private final String[] frequency = new String[]{"daily", "weekly", "monthly", "yearly"};
    private boolean isCalanderJustArrived = false;
    private String location = "";
    private Context mContext = null;
    private AmobeeView mOrmmaView = null;
    RecurrenceProperties mRecurrenceProperties;
    private String recurrence = "";
    private String reminder = "";
    private String start = "";
    private String status = "";
    private String summary = "";
    private String transparency = "";

    class C03301 implements OnClickListener {
        C03301() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            OrmmaCalendarController.this.showCalendarWithCursor();
        }
    }

    class C03312 implements OnClickListener {
        C03312() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            OrmmaCalendarController.this.mOrmmaView.raiseError("Create calendar event canceled by the user.", "createCalendarEvent");
        }
    }

    OrmmaCalendarController(String str, Context context, AmobeeView amobeeView) {
        this.LOG_TAG = str;
        this.mContext = context;
        this.mOrmmaView = amobeeView;
    }

    @SuppressLint({"NewApi"})
    private void addCalendarEvent(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        try {
            Uri insert;
            ContentResolver contentResolver = this.mContext.getContentResolver();
            ContentValues contentValues = new ContentValues();
            contentValues.put("calendar_id", Integer.valueOf(i));
            contentValues.put("title", str);
            contentValues.put("description", str3);
            contentValues.put("dtstart", Long.valueOf(getTimeFromStringDateFormat(str4)));
            contentValues.put("hasAlarm", Integer.valueOf(1));
            if (str5.length() == 0) {
                contentValues.put("dtend", String.valueOf(getTimeFromStringDateFormat(str4) + 3600000));
            } else {
                contentValues.put("dtend", Long.valueOf(getTimeFromStringDateFormat(str5)));
            }
            contentValues.put("eventLocation", str2);
            if (this.mRecurrenceProperties != null) {
                contentValues.put("rrule", recurrencePropertiesString());
            }
            if (Integer.parseInt(VERSION.SDK) >= 14) {
                contentValues.put("eventTimezone", TimeZone.getDefault().getID());
                insert = contentResolver.insert(Events.CONTENT_URI, contentValues);
            } else if (Integer.parseInt(VERSION.SDK) >= 8) {
                contentValues.put("transparency", str7);
                insert = contentResolver.insert(Uri.parse("content://com.android.calendar/events"), contentValues);
            } else {
                contentValues.put("transparency", str7);
                insert = contentResolver.insert(Uri.parse("content://calendar/events"), contentValues);
            }
            if (insert != null) {
                long parseLong = Long.parseLong(insert.getLastPathSegment());
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("event_id", Long.valueOf(parseLong));
                contentValues2.put("method", Integer.valueOf(1));
                parseLong = 15;
                if (str9.length() > 0) {
                    try {
                        parseLong = ((long) (Integer.parseInt(str9) * -1)) / 60000;
                    } catch (Exception e) {
                        try {
                            parseLong = ((getTimeFromStringDateFormat(str4) - getTimeFromStringDateFormat(str9)) * -1) / 60000;
                        } catch (Exception e2) {
                        }
                    }
                }
                contentValues2.put("minutes", Long.valueOf(parseLong));
                if (Integer.parseInt(VERSION.SDK) >= 14) {
                    contentResolver.insert(Reminders.CONTENT_URI, contentValues2);
                } else if (Integer.parseInt(VERSION.SDK) >= 8) {
                    contentResolver.insert(Uri.parse("content://com.android.calendar/reminders"), contentValues2);
                } else {
                    contentResolver.insert(Uri.parse("content://calendar/reminders"), contentValues2);
                }
            }
            Log.m811d(this.LOG_TAG, "Event added to calendar");
        } catch (Exception e3) {
            Log.m811d(this.LOG_TAG, "Can't access calendar, exception message");
            this.mOrmmaView.raiseError("Create calendar event failed.", "createCalendarEvent");
        }
    }

    private void addExceptioDates(int i) {
        long j = (long) i;
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Long.valueOf(j));
        contentValues.put("calendar_id", this.cursor.getString(0));
        try {
            if (!(this.mRecurrenceProperties == null || this.mRecurrenceProperties.exceptionDates == null)) {
                String str = "";
                for (int i2 = 0; i2 < this.mRecurrenceProperties.exceptionDates.length; i2++) {
                    Date dateFromStringDateFormat = getDateFromStringDateFormat(this.mRecurrenceProperties.exceptionDates[i2]);
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd HHmmss");
                    simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                    str = new StringBuilder(String.valueOf(str)).append(simpleDateFormat.format(dateFromStringDateFormat).replace(" ", "T")).append("Z").toString();
                    if (i2 < this.mRecurrenceProperties.exceptionDates.length - 1) {
                        str = new StringBuilder(String.valueOf(str)).append(",").toString();
                    }
                }
                contentValues.put("exdate", str);
            }
            this.mContext.getContentResolver().update(Events.CONTENT_URI, contentValues, "_id =" + i, null);
        } catch (Exception e) {
        }
    }

    private Date getDateFromStringDateFormat(String str) {
        String replace = str.replace("T", " ");
        String[] strArr = new String[]{"yyyy-MM-dd", "yyyy-MM-dd HH:mm", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm:ss.SSS", "yyyy-MM-dd HH:mmZ", "yyyy-MM-dd HH:mm:ssZ", "yyyy-MM-dd HH:mm:ss.SSSZ", "yyyy-MM-dd HH:mmZZZZZ", "yyyy-MM-dd HH:mm:ssZZZZZ", "yyyy-MM-dd HH:mm:ss.SSSZZZZZ"};
        String str2 = "";
        int length = strArr.length - 1;
        while (length >= 0) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(strArr[length]);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            try {
                return simpleDateFormat.parse(replace);
            } catch (Exception e) {
                str2 = "parse exception: bad date format";
                length--;
            }
        }
        Log.m811d(this.LOG_TAG, "Can't Parse date, ParseException message: " + str2);
        this.mOrmmaView.raiseError("Valid date required.", "createCalendarEvent");
        return null;
    }

    private long getTimeFromStringDateFormat(String str) {
        Date dateFromStringDateFormat = getDateFromStringDateFormat(str);
        return dateFromStringDateFormat != null ? dateFromStringDateFormat.getTime() : -1;
    }

    private String recurrencePropertiesString() {
        int i = 0;
        String str = "";
        if (this.mRecurrenceProperties == null) {
            return null;
        }
        Date dateFromStringDateFormat;
        String str2;
        int i2;
        if (this.mRecurrenceProperties.frequency != null && validFrequency(this.mRecurrenceProperties.frequency)) {
            str = new StringBuilder(String.valueOf(str)).append("FREQ=").append(this.mRecurrenceProperties.frequency.toUpperCase()).append(";").toString();
        }
        if (this.mRecurrenceProperties.expires != null) {
            dateFromStringDateFormat = getDateFromStringDateFormat(this.mRecurrenceProperties.expires);
            if (dateFromStringDateFormat != null) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd HHmmss");
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                str = new StringBuilder(String.valueOf(str)).append("UNTIL=").append((simpleDateFormat.format(dateFromStringDateFormat) + "Z").replace(" ", "T")).append(";").toString();
            }
        }
        if (this.mRecurrenceProperties.daysInWeek != null && str.contains("WEEKLY")) {
            str2 = "";
            for (i2 = 0; i2 < this.mRecurrenceProperties.daysInWeek.length; i2++) {
                try {
                    str2 = new StringBuilder(String.valueOf(str2)).append(this.daysInWeek[this.mRecurrenceProperties.daysInWeek[i2]]).toString();
                    if (i2 != this.mRecurrenceProperties.daysInWeek.length - 1) {
                        str2 = new StringBuilder(String.valueOf(str2)).append(",").toString();
                    }
                } catch (Exception e) {
                }
            }
            if (!str2.equals("")) {
                str = new StringBuilder(String.valueOf(str)).append("BYDAY=").append(str2).append(";").toString();
            }
        }
        if (str.contains("WEEKLY") && !str.contains("BYDAY")) {
            dateFromStringDateFormat = getDateFromStringDateFormat(this.start);
            Calendar instance = Calendar.getInstance();
            instance.setTime(dateFromStringDateFormat);
            str = new StringBuilder(String.valueOf(str)).append("BYDAY=").append(this.daysInWeek[instance.get(7) - 1]).append(";").toString();
        }
        if (this.mRecurrenceProperties.daysInYear != null && str.contains("YEARLY")) {
            str2 = "";
            i2 = 0;
            while (i2 < this.mRecurrenceProperties.daysInYear.length) {
                if (this.mRecurrenceProperties.daysInYear[i2] <= (short) 365 && this.mRecurrenceProperties.daysInYear[i2] > (short) -365) {
                    if (this.mRecurrenceProperties.daysInYear[i2] < (short) 0) {
                        this.mRecurrenceProperties.daysInYear[i2] = (short) (this.mRecurrenceProperties.daysInYear[i2] + DAYS_IN_YEAR);
                    }
                    str2 = new StringBuilder(String.valueOf(str2)).append(this.mRecurrenceProperties.daysInYear[i2]).toString();
                    if (i2 != this.mRecurrenceProperties.daysInYear.length - 1) {
                        str2 = new StringBuilder(String.valueOf(str2)).append(",").toString();
                    }
                }
                i2++;
            }
            if (!str2.equals("")) {
                str = new StringBuilder(String.valueOf(str)).append("BYYEARDAY=").append(str2).append(";").toString();
            }
        }
        if (this.mRecurrenceProperties.monthsInYear != null && str.contains("YEARLY")) {
            str2 = "";
            i2 = 0;
            while (i2 < this.mRecurrenceProperties.monthsInYear.length) {
                if (this.mRecurrenceProperties.monthsInYear[i2] <= (short) 12 && (short) 1 <= this.mRecurrenceProperties.monthsInYear[i2]) {
                    str2 = new StringBuilder(String.valueOf(str2)).append(this.mRecurrenceProperties.monthsInYear[i2]).toString();
                    if (i2 != this.mRecurrenceProperties.monthsInYear.length - 1) {
                        str2 = new StringBuilder(String.valueOf(str2)).append(",").toString();
                    }
                }
                i2++;
            }
            if (!str2.equals("")) {
                str = new StringBuilder(String.valueOf(str)).append("BYMONTH=").append(str2).append(";").toString();
            }
        }
        str2 = "";
        if (this.mRecurrenceProperties.weeksInMonth != null && str.contains("MONTHLY")) {
            i2 = 0;
            while (i2 < this.mRecurrenceProperties.weeksInMonth.length) {
                if (this.mRecurrenceProperties.weeksInMonth[i2] >= (short) -3 && this.mRecurrenceProperties.weeksInMonth[i2] <= (short) 4 && this.mRecurrenceProperties.weeksInMonth[i2] <= (short) 0) {
                    this.mRecurrenceProperties.weeksInMonth[i2] = (short) (this.mRecurrenceProperties.weeksInMonth[i2] + 4);
                }
                switch (this.mRecurrenceProperties.weeksInMonth[i2]) {
                    case (short) 1:
                        str2 = new StringBuilder(String.valueOf(str2)).append(FIRST_WEEK_DAYS).toString();
                        break;
                    case (short) 2:
                        str2 = new StringBuilder(String.valueOf(str2)).append(SECOND_WEEK_DAYS).toString();
                        break;
                    case (short) 3:
                        str2 = new StringBuilder(String.valueOf(str2)).append(THIRD_WEEK_DAYS).toString();
                        break;
                    case (short) 4:
                        str2 = new StringBuilder(String.valueOf(str2)).append(FOURTH_WEEK_DAYS).toString();
                        break;
                }
                if (!(i2 == this.mRecurrenceProperties.weeksInMonth.length - 1 || str2.endsWith(","))) {
                    str2 = new StringBuilder(String.valueOf(str2)).append(",").toString();
                }
                i2++;
            }
            if ((this.mRecurrenceProperties.daysInMonth == null || this.mRecurrenceProperties.daysInMonth.length == 0) && !str2.equals("")) {
                str = new StringBuilder(String.valueOf(str)).append("BYMONTHDAY=").append(str2).append(";").toString();
            } else {
                str2 = "," + str2;
            }
        }
        if (this.mRecurrenceProperties.daysInMonth != null && str.contains("MONTHLY")) {
            String str3 = "";
            while (i < this.mRecurrenceProperties.daysInMonth.length) {
                if (this.mRecurrenceProperties.daysInMonth[i] > (short) -31 && this.mRecurrenceProperties.daysInMonth[i] <= (short) 31) {
                    if (this.mRecurrenceProperties.daysInMonth[i] <= (short) 0) {
                        this.mRecurrenceProperties.daysInMonth[i] = (short) (this.mRecurrenceProperties.daysInMonth[i] + 31);
                    }
                    str3 = new StringBuilder(String.valueOf(str3)).append(this.mRecurrenceProperties.daysInMonth[i]).toString();
                    if (i != this.mRecurrenceProperties.daysInMonth.length - 1) {
                        str3 = new StringBuilder(String.valueOf(str3)).append(",").toString();
                    }
                }
                i++;
            }
            if (!(str3.equals("") && str2.equals(""))) {
                str = new StringBuilder(String.valueOf(str)).append("BYMONTHDAY=").append(str3).append(str2).append(";").toString();
            }
        }
        if (!(validFrequency(this.mRecurrenceProperties.frequency) || str.equals(""))) {
            str = new StringBuilder(String.valueOf(str)).append("FREQ=DAILY;").toString();
        }
        return !str.equals("") ? this.mRecurrenceProperties.interval > 0 ? new StringBuilder(String.valueOf(str)).append("INTERVAL=").append(this.mRecurrenceProperties.interval).append(";").toString() : new StringBuilder(String.valueOf(str)).append("INTERVAL=1;").toString() : str;
    }

    @SuppressLint({"NewApi"})
    private void showCalendarIntent14() {
        if (-1 == getTimeFromStringDateFormat(this.start)) {
            this.mOrmmaView.raiseError("Valid date required.", "createCalendarEvent");
            return;
        }
        this.eventsCount = this.mContext.getContentResolver().query(Events.CONTENT_URI, new String[]{"_id"}, null, null, null).getCount();
        String recurrencePropertiesString = recurrencePropertiesString();
        Intent putExtra = new Intent("android.intent.action.INSERT").addFlags(268435456).setData(Events.CONTENT_URI).putExtra("beginTime", getTimeFromStringDateFormat(this.start)).putExtra("title", this.description).putExtra("description", this.summary).putExtra("eventLocation", this.location);
        if (-1 != getTimeFromStringDateFormat(this.end)) {
            putExtra.putExtra("endTime", getTimeFromStringDateFormat(this.end));
        }
        String str = "";
        if (!(this.mRecurrenceProperties == null || this.mRecurrenceProperties.exceptionDates == null)) {
            for (int i = 0; i < this.mRecurrenceProperties.exceptionDates.length; i++) {
                Date dateFromStringDateFormat = getDateFromStringDateFormat(this.mRecurrenceProperties.exceptionDates[i]);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd HHmmss");
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                str = new StringBuilder(String.valueOf(str)).append(simpleDateFormat.format(dateFromStringDateFormat).replace(" ", "T")).append("Z").toString();
                if (i < this.mRecurrenceProperties.exceptionDates.length - 1) {
                    str = new StringBuilder(String.valueOf(str)).append(",").toString();
                }
            }
            putExtra.putExtra("exdate", str);
        }
        if (recurrencePropertiesString != null) {
            putExtra.putExtra("rrule", recurrencePropertiesString);
            Log.m811d(this.LOG_TAG, "calander rrule:" + recurrencePropertiesString);
        }
        try {
            this.mContext.startActivity(putExtra);
            if (this.mOrmmaView.mViewState == ViewState.POSTITIAL) {
                this.mOrmmaView.closePostitial();
            }
        } catch (Exception e) {
        }
    }

    private void showCalendarWithCursor() {
        if (this.cursor.getCount() == 1) {
            addCalendarEvent(this.cursor.getInt(0), this.description, this.location, this.summary, this.start, this.end, this.status, this.transparency, this.recurrence, this.reminder);
        } else {
            final List arrayList = new ArrayList();
            for (int i = 0; i < this.cursor.getCount(); i++) {
                Map hashMap = new HashMap();
                hashMap.put("ID", this.cursor.getString(0));
                hashMap.put(Condition.TYPE_NAME, this.cursor.getString(1));
                hashMap.put("EMAILID", this.cursor.getString(2));
                arrayList.add(hashMap);
                this.cursor.moveToNext();
            }
            Builder builder = new Builder(this.mContext);
            builder.setTitle("Choose Calendar to save event to");
            builder.setSingleChoiceItems(new SimpleAdapter(this.mContext, arrayList, 17367053, new String[]{Condition.TYPE_NAME, "EMAILID"}, new int[]{16908308, 16908309}), -1, new OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    OrmmaCalendarController.this.addCalendarEvent(Integer.parseInt((String) ((Map) arrayList.get(i)).get("ID")), OrmmaCalendarController.this.description, OrmmaCalendarController.this.location, OrmmaCalendarController.this.summary, OrmmaCalendarController.this.start, OrmmaCalendarController.this.end, OrmmaCalendarController.this.status, OrmmaCalendarController.this.transparency, OrmmaCalendarController.this.recurrence, OrmmaCalendarController.this.reminder);
                    dialogInterface.cancel();
                }
            });
            builder.create().show();
        }
        this.cursor.close();
    }

    private void showNotification() {
        OnClickListener c03301 = new C03301();
        OnClickListener c03312 = new C03312();
        Builder builder = new Builder(this.mContext);
        builder.setTitle(this.description + " - Calendar Event");
        CharSequence charSequence = "Description: " + this.summary + "\n" + "Start date: " + this.start;
        if (this.end.length() > 0) {
            charSequence = new StringBuilder(String.valueOf(charSequence)).append("\nEnd date: ").append(this.end).toString();
        }
        builder.setMessage(charSequence);
        builder.setPositiveButton("yes", c03301);
        builder.setNegativeButton("no", c03312);
        builder.show();
        if (this.mOrmmaView.mViewState == ViewState.POSTITIAL) {
            this.mOrmmaView.closePostitial();
        }
    }

    private boolean validFrequency(String str) {
        for (String equalsIgnoreCase : this.frequency) {
            if (equalsIgnoreCase.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    @SuppressLint({"NewApi"})
    public void createCalendarEvent(String str, RecurrenceProperties recurrenceProperties) {
        this.mRecurrenceProperties = recurrenceProperties;
        try {
            JSONObject jSONObject = new JSONObject(str);
            try {
                if (jSONObject.isNull("description")) {
                    this.mOrmmaView.raiseError("Valid description required.", "createCalendarEvent");
                    return;
                }
                this.description = jSONObject.getString("description");
                if (!jSONObject.isNull("location")) {
                    this.location = jSONObject.getString("location");
                }
                if (!jSONObject.isNull("summary")) {
                    this.summary = jSONObject.getString("summary");
                }
                if (jSONObject.isNull("start")) {
                    this.mOrmmaView.raiseError("Valid date required.", "createCalendarEvent");
                    return;
                }
                this.start = jSONObject.getString("start");
                if (-1 == getTimeFromStringDateFormat(this.start)) {
                    this.mOrmmaView.raiseError("Valid date required.", "createCalendarEvent");
                    return;
                }
                if (!jSONObject.isNull("end")) {
                    this.end = jSONObject.getString("end");
                }
                if (!jSONObject.isNull("status")) {
                    this.status = jSONObject.getString("status");
                }
                if (!jSONObject.isNull("transparency")) {
                    this.transparency = jSONObject.getString("transparency");
                }
                if (!jSONObject.isNull("reminder")) {
                    this.reminder = jSONObject.getString("reminder");
                }
                try {
                    ContentResolver contentResolver = this.mContext.getContentResolver();
                    String[] strArr = new String[]{"_id", "displayName", "_sync_account"};
                    if (Integer.parseInt(VERSION.SDK) >= 14) {
                        this.cursor = contentResolver.query(Calendars.CONTENT_URI, new String[]{"_id", "calendar_displayName", "account_name"}, null, null, null);
                    } else if (Integer.parseInt(VERSION.SDK) >= 8) {
                        this.cursor = contentResolver.query(Uri.parse("content://com.android.calendar/calendars"), strArr, null, null, null);
                    } else {
                        this.cursor = contentResolver.query(Uri.parse("content://calendar/calendars"), strArr, null, null, null);
                    }
                    if (this.cursor == null || !(this.cursor == null || this.cursor.moveToFirst())) {
                        Log.m811d(this.LOG_TAG, "No calendar account found");
                        this.mOrmmaView.raiseError("Calendar is not supported.", "createCalendarEvent");
                        if (this.cursor != null) {
                            this.cursor.close();
                        }
                    } else if (Integer.parseInt(VERSION.SDK) >= 14) {
                        showCalendarIntent14();
                    } else {
                        showNotification();
                    }
                } catch (Exception e) {
                    this.mOrmmaView.raiseError("Calendar is not supported.", "createCalendarEvent");
                    Log.m811d(this.LOG_TAG, "createEvent exception ");
                }
            } catch (JSONException e2) {
            }
        } catch (JSONException e3) {
        }
    }

    @SuppressLint({"NewApi"})
    public boolean isEventSaved() {
        if (Integer.parseInt(VERSION.SDK) < 14) {
            return false;
        }
        if (this.isCalanderJustArrived) {
            try {
                this.isCalanderJustArrived = false;
                if (this.eventsCount == 0) {
                    return false;
                }
                String[] strArr = new String[]{"_id"};
                ContentResolver contentResolver = this.mContext.getContentResolver();
                Cursor query = contentResolver.query(Events.CONTENT_URI, strArr, null, null, null);
                query.moveToFirst();
                int i = 0;
                for (int i2 = 0; i2 < query.getCount(); i2++) {
                    if (i2 == query.getCount() - 1) {
                        i = Integer.parseInt(query.getString(0));
                        if (!(this.mRecurrenceProperties == null || this.mRecurrenceProperties.exceptionDates == null)) {
                            addExceptioDates(i);
                        }
                    }
                    query.moveToNext();
                }
                if (query.getCount() > this.eventsCount) {
                    long j = (long) i;
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("event_id", Long.valueOf(j));
                    contentValues.put("method", Integer.valueOf(1));
                    j = 15;
                    if (this.reminder.length() > 0) {
                        try {
                            j = ((long) (Integer.parseInt(this.reminder) * -1)) / 60000;
                        } catch (Exception e) {
                            try {
                                j = ((getTimeFromStringDateFormat(this.start) - getTimeFromStringDateFormat(this.reminder)) * -1) / 60000;
                            } catch (Exception e2) {
                            }
                        }
                    }
                    contentValues.put("minutes", Long.valueOf(j));
                    contentResolver.insert(Reminders.CONTENT_URI, contentValues);
                    return true;
                }
                this.mOrmmaView.raiseError("Create calendar event canceled by the user.", "createCalendarEvent");
                return true;
            } catch (Exception e3) {
                e3.getMessage() + " ";
                return false;
            }
        }
        this.isCalanderJustArrived = true;
        return false;
    }
}
