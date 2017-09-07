package com.telkom.mwallet.dialog;

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
import com.skcc.wallet.framework.api.http.model.Denomination;
import com.telkom.mwallet.C1359a;
import com.telkom.mwallet.R;
import com.telkom.mwallet.dialog.p063a.C1496c;
import com.telkom.mwallet.p064a.C1350d;
import com.telkom.mwallet.p064a.C1354g;
import java.util.List;

public class C1509c extends DialogFragment {
    private C1350d f3556a;
    private C1496c f3557b;
    private List<Denomination> f3558c;
    private int f3559d;
    private DisplayMetrics f3560e;

    class C15071 implements OnItemClickListener {
        final /* synthetic */ C1509c f3550a;

        C15071(C1509c c1509c) {
            this.f3550a = c1509c;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            this.f3550a.f3557b.mo1548a((Denomination) this.f3550a.f3558c.get(i));
        }
    }

    private static class C1508a extends ArrayAdapter<Denomination> {
        private C1350d f3551a = this.f3552b.m4982d();
        private C1359a f3552b;
        private List<Denomination> f3553c;
        private int f3554d;
        private LayoutInflater f3555e;

        public C1508a(Context context, int i, List<Denomination> list) {
            super(context, i, list);
            this.f3552b = (C1359a) context;
            this.f3553c = list;
            this.f3554d = i;
            this.f3555e = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            view = (TextView) view;
            if (view == null) {
                view = (TextView) this.f3555e.inflate(this.f3554d, viewGroup, false);
            }
            Denomination denomination = (Denomination) this.f3553c.get(i);
            view.setText(C1354g.m4957h("" + denomination.getAmount()) + " (" + denomination.getName() + ")");
            this.f3551a.m4932a(this.f3552b, view, 2);
            return view;
        }
    }

    public static C1509c m5636a(int i) {
        C1509c c1509c = new C1509c();
        Bundle bundle = new Bundle();
        bundle.putInt("title", i);
        c1509c.setArguments(bundle);
        return c1509c;
    }

    public void m5639a(C1496c c1496c) {
        this.f3557b = c1496c;
    }

    public void m5640a(List<Denomination> list) {
        this.f3558c = list;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.f3559d = getArguments().getInt("title");
        }
        this.f3560e = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(this.f3560e);
        setStyle(1, 16974126);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.dialog_list, viewGroup, false);
        this.f3556a = ((C1359a) getActivity()).m4982d();
        View view = (TextView) inflate.findViewById(R.id.dialog_title);
        view.setText(getString(getArguments().getInt("title")));
        this.f3556a.m4932a(getActivity(), view, 3);
        ListView listView = (ListView) inflate.findViewById(R.id.list_dialog_listview);
        if (this.f3558c != null && this.f3558c.size() > 0) {
            listView.setAdapter(new C1508a(getActivity(), R.layout.view_dialog_list_item, this.f3558c));
            listView.setScrollbarFadingEnabled(false);
            listView.setOnItemClickListener(new C15071(this));
        }
        return inflate;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
    }

    public void onResume() {
        super.onResume();
        Window window = getDialog().getWindow();
        window.setLayout(this.f3560e.widthPixels, this.f3560e.heightPixels / 2);
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setGravity(17);
    }
}
