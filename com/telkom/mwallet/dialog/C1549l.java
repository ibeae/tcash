package com.telkom.mwallet.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import android.widget.ListView;
import android.widget.TextView;
import com.skcc.wallet.framework.api.http.model.BankCode;
import com.telkom.mwallet.C1359a;
import com.telkom.mwallet.R;
import com.telkom.mwallet.dialog.p063a.C1324e;
import com.telkom.mwallet.p064a.C1348b;
import com.telkom.mwallet.p064a.C1350d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C1549l extends DialogFragment {
    public TextWatcher f3671a = new C15462(this);
    private C1350d f3672b;
    private C1324e f3673c;
    private BankCode[] f3674d = C1348b.f2906a;
    private C1548a f3675e;

    class C15451 implements OnItemClickListener {
        final /* synthetic */ C1549l f3661a;

        C15451(C1549l c1549l) {
            this.f3661a = c1549l;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            BankCode bankCode = (BankCode) this.f3661a.f3675e.m5704a().get(i);
            this.f3661a.f3673c.mo1484a(bankCode.getBankCode() + "(" + bankCode.getBankName() + ")");
        }
    }

    class C15462 implements TextWatcher {
        final /* synthetic */ C1549l f3662a;

        C15462(C1549l c1549l) {
            this.f3662a = c1549l;
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.f3662a.f3675e.getFilter().filter(charSequence.toString());
        }
    }

    private class C1548a extends ArrayAdapter<String> {
        final /* synthetic */ C1549l f3664a;
        private C1350d f3665b = this.f3666c.m4982d();
        private C1359a f3666c;
        private List<BankCode> f3667d;
        private int f3668e;
        private LayoutInflater f3669f;
        private List<BankCode> f3670g;

        class C15471 extends Filter {
            final /* synthetic */ C1548a f3663a;

            C15471(C1548a c1548a) {
                this.f3663a = c1548a;
            }

            protected FilterResults performFiltering(CharSequence charSequence) {
                FilterResults filterResults = new FilterResults();
                List arrayList = new ArrayList();
                if (this.f3663a.f3670g == null) {
                    this.f3663a.f3670g = new ArrayList(this.f3663a.f3667d);
                }
                if (charSequence == null || charSequence.length() == 0) {
                    filterResults.count = this.f3663a.f3670g.size();
                    filterResults.values = this.f3663a.f3670g;
                } else {
                    CharSequence toLowerCase = charSequence.toString().toLowerCase();
                    for (int i = 0; i < this.f3663a.f3670g.size(); i++) {
                        BankCode bankCode = (BankCode) this.f3663a.f3670g.get(i);
                        if (bankCode.getBankName().toLowerCase().startsWith(toLowerCase.toString())) {
                            arrayList.add(bankCode);
                        } else if (bankCode.getBankCode().toLowerCase().startsWith(toLowerCase.toString())) {
                            arrayList.add(bankCode);
                        }
                        filterResults.count = arrayList.size();
                        filterResults.values = arrayList;
                    }
                }
                return filterResults;
            }

            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                this.f3663a.f3667d = (List) filterResults.values;
                this.f3663a.notifyDataSetChanged();
            }
        }

        public C1548a(C1549l c1549l, Context context, int i, List<BankCode> list) {
            this.f3664a = c1549l;
            super(context, i);
            this.f3666c = (C1359a) context;
            this.f3667d = list;
            this.f3668e = i;
            this.f3669f = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        public List<BankCode> m5704a() {
            return this.f3667d;
        }

        public int getCount() {
            return this.f3667d.size();
        }

        public Filter getFilter() {
            return new C15471(this);
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            view = (TextView) view;
            if (view == null) {
                view = (TextView) this.f3669f.inflate(this.f3668e, null);
            }
            String bankCode = ((BankCode) this.f3667d.get(i)).getBankCode();
            String bankName = ((BankCode) this.f3667d.get(i)).getBankName();
            ((BankCode) this.f3667d.get(i)).getDisplayName();
            view.setText(bankCode + "(" + bankName + ")");
            this.f3665b.m4932a(this.f3666c, view, 1);
            return view;
        }
    }

    public static C1549l m5706a(int i) {
        C1549l c1549l = new C1549l();
        Bundle bundle = new Bundle();
        bundle.putInt("title", i);
        c1549l.setArguments(bundle);
        return c1549l;
    }

    public void m5708a(C1324e c1324e) {
        this.f3673c = c1324e;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getDialog().getWindow().requestFeature(1);
        View inflate = layoutInflater.inflate(R.layout.dialog_search_list, viewGroup, false);
        this.f3672b = ((C1359a) getActivity()).m4982d();
        View view = (TextView) inflate.findViewById(R.id.dialog_title);
        view.setText(getString(getArguments().getInt("title")));
        this.f3672b.m4932a(getActivity(), view, 3);
        view = (EditText) inflate.findViewById(R.id.search_list_dialog_edittext);
        view.addTextChangedListener(this.f3671a);
        this.f3672b.m4932a(getActivity(), view, 2);
        ListView listView = (ListView) inflate.findViewById(R.id.search_list_dialog_listview);
        List asList = Arrays.asList(this.f3674d);
        if (asList != null && asList.size() > 0) {
            this.f3675e = new C1548a(this, getActivity(), R.layout.view_dialog_list_item, asList);
            listView.setAdapter(this.f3675e);
            listView.setScrollbarFadingEnabled(false);
            listView.setOnItemClickListener(new C15451(this));
        }
        return inflate;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
    }
}
