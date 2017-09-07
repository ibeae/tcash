package com.telkom.mwallet.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.skcc.wallet.framework.api.http.model.TransferType;
import com.telkom.mwallet.C1359a;
import com.telkom.mwallet.R;
import com.telkom.mwallet.dialog.p063a.C1501j;
import com.telkom.mwallet.p064a.C1350d;
import java.util.Arrays;
import java.util.List;

public class C1552m extends DialogFragment {
    private C1350d f3683a;
    private C1501j f3684b;
    private int f3685c;

    private static class C1551a extends ArrayAdapter<TransferType> {
        private C1350d f3678a = this.f3679b.m4982d();
        private C1359a f3679b;
        private List<TransferType> f3680c;
        private int f3681d;
        private LayoutInflater f3682e;

        public C1551a(Context context, int i, List<TransferType> list) {
            super(context, i, list);
            this.f3679b = (C1359a) context;
            this.f3680c = list;
            this.f3681d = i;
            this.f3682e = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            view = (TextView) view;
            if (view == null) {
                view = (TextView) this.f3682e.inflate(this.f3681d, viewGroup, false);
            }
            view.setText(((TransferType) this.f3680c.get(i)).getName());
            this.f3678a.m4932a(this.f3679b, view, 1);
            return view;
        }
    }

    public static C1552m m5710a(int i) {
        C1552m c1552m = new C1552m();
        Bundle bundle = new Bundle();
        bundle.putInt("title", i);
        c1552m.setArguments(bundle);
        return c1552m;
    }

    public void m5711a(C1501j c1501j) {
        this.f3684b = c1501j;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.f3685c = getArguments().getInt("title");
        }
        setStyle(1, 16974126);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.dialog_list, viewGroup, false);
        this.f3683a = ((C1359a) getActivity()).m4982d();
        View view = (TextView) inflate.findViewById(R.id.dialog_title);
        view.setText(getString(getArguments().getInt("title")));
        this.f3683a.m4932a(getActivity(), view, 3);
        final TransferType[] transferTypeArr = new TransferType[]{new TransferType(getString(R.string.select_transfer_mobile), "4100000"), new TransferType(getString(R.string.select_transfer_bank), "4200000")};
        ListView listView = (ListView) inflate.findViewById(R.id.list_dialog_listview);
        listView.setAdapter(new C1551a(getActivity(), R.layout.view_dialog_list_item, Arrays.asList(transferTypeArr)));
        listView.setScrollbarFadingEnabled(false);
        listView.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ C1552m f3677b;

            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                this.f3677b.f3684b.mo1551a(transferTypeArr[i]);
            }
        });
        return inflate;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
    }
}
