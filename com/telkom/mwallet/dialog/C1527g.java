package com.telkom.mwallet.dialog;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.telkom.mwallet.R;
import com.telkom.mwallet.TelkomApplication;
import com.telkom.mwallet.dialog.p063a.C1324e;
import com.telkom.mwallet.p064a.C1350d;
import java.util.List;

public class C1527g extends DialogFragment {
    private C1350d f3610a;
    private C1324e f3611b;
    private List<String> f3612c;
    private DisplayMetrics f3613d;

    class C15251 implements OnItemClickListener {
        final /* synthetic */ C1527g f3603a;

        C15251(C1527g c1527g) {
            this.f3603a = c1527g;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            this.f3603a.dismiss();
            this.f3603a.f3611b.mo1484a(((String) this.f3603a.f3612c.get(i)).toString());
            this.f3603a.f3611b.mo1483a(i);
        }
    }

    private class C1526a extends ArrayAdapter<String> {
        final /* synthetic */ C1527g f3604a;
        private C1350d f3605b;
        private Activity f3606c;
        private List<String> f3607d;
        private int f3608e;
        private LayoutInflater f3609f;

        public C1526a(C1527g c1527g, Context context, int i, List<String> list) {
            this.f3604a = c1527g;
            super(context, i, list);
            this.f3606c = (Activity) context;
            this.f3607d = list;
            this.f3608e = i;
            this.f3609f = (LayoutInflater) context.getSystemService("layout_inflater");
            this.f3605b = ((TelkomApplication) c1527g.getActivity().getApplication()).m4899j();
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            view = (TextView) view;
            if (view == null) {
                view = (TextView) this.f3609f.inflate(this.f3608e, null);
            }
            view.setText((CharSequence) this.f3607d.get(i));
            this.f3605b.m4932a(this.f3606c, view, 2);
            return view;
        }
    }

    public static C1527g m5667a(int i) {
        C1527g c1527g = new C1527g();
        Bundle bundle = new Bundle();
        bundle.putInt("title", i);
        c1527g.setArguments(bundle);
        return c1527g;
    }

    public void m5670a(C1324e c1324e) {
        this.f3611b = c1324e;
    }

    public void m5671a(List<String> list) {
        this.f3612c = list;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f3613d = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(this.f3613d);
        getDialog().getWindow().requestFeature(1);
        View inflate = layoutInflater.inflate(R.layout.dialog_list, viewGroup, false);
        this.f3610a = ((TelkomApplication) getActivity().getApplication()).m4899j();
        View view = (TextView) inflate.findViewById(R.id.dialog_title);
        view.setText(getString(getArguments().getInt("title")));
        this.f3610a.m4932a(getActivity(), view, 3);
        ListView listView = (ListView) inflate.findViewById(R.id.list_dialog_listview);
        if (this.f3612c != null && this.f3612c.size() > 0) {
            listView.setAdapter(new C1526a(this, getActivity(), R.layout.view_dialog_list_item, this.f3612c));
            listView.setScrollbarFadingEnabled(false);
            listView.setOnItemClickListener(new C15251(this));
        }
        return inflate;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
    }

    public void onResume() {
        super.onResume();
        Window window = getDialog().getWindow();
        window.setLayout(this.f3613d.widthPixels, this.f3613d.heightPixels / 2);
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setGravity(17);
    }
}
