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
import com.telkom.mwallet.C1359a;
import com.telkom.mwallet.R;
import com.telkom.mwallet.dialog.p063a.C1324e;
import com.telkom.mwallet.p064a.C1350d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C1544k extends DialogFragment {
    public TextWatcher f3656a = new C15412(this);
    private C1350d f3657b;
    private C1324e f3658c;
    private String[] f3659d;
    private C1543a f3660e;

    class C15401 implements OnItemClickListener {
        final /* synthetic */ C1544k f3646a;

        C15401(C1544k c1544k) {
            this.f3646a = c1544k;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            this.f3646a.f3658c.mo1484a((String) this.f3646a.f3660e.m5695a().get(i));
            this.f3646a.dismiss();
        }
    }

    class C15412 implements TextWatcher {
        final /* synthetic */ C1544k f3647a;

        C15412(C1544k c1544k) {
            this.f3647a = c1544k;
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.f3647a.f3660e.getFilter().filter(charSequence.toString());
        }
    }

    private class C1543a extends ArrayAdapter<String> {
        final /* synthetic */ C1544k f3649a;
        private C1350d f3650b = this.f3651c.m4982d();
        private C1359a f3651c;
        private List<String> f3652d;
        private int f3653e;
        private LayoutInflater f3654f;
        private List<String> f3655g;

        class C15421 extends Filter {
            final /* synthetic */ C1543a f3648a;

            C15421(C1543a c1543a) {
                this.f3648a = c1543a;
            }

            protected FilterResults performFiltering(CharSequence charSequence) {
                FilterResults filterResults = new FilterResults();
                List arrayList = new ArrayList();
                if (this.f3648a.f3655g == null) {
                    this.f3648a.f3655g = new ArrayList(this.f3648a.f3652d);
                }
                if (charSequence == null || charSequence.length() == 0) {
                    filterResults.count = this.f3648a.f3655g.size();
                    filterResults.values = this.f3648a.f3655g;
                } else {
                    CharSequence toLowerCase = charSequence.toString().toLowerCase();
                    for (int i = 0; i < this.f3648a.f3655g.size(); i++) {
                        String str = (String) this.f3648a.f3655g.get(i);
                        if (str.toLowerCase().startsWith(toLowerCase.toString())) {
                            arrayList.add(str);
                        }
                        filterResults.count = arrayList.size();
                        filterResults.values = arrayList;
                    }
                }
                return filterResults;
            }

            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                this.f3648a.f3652d = (List) filterResults.values;
                this.f3648a.notifyDataSetChanged();
            }
        }

        public C1543a(C1544k c1544k, Context context, int i, List<String> list) {
            this.f3649a = c1544k;
            super(context, i);
            this.f3651c = (C1359a) context;
            this.f3652d = list;
            this.f3653e = i;
            this.f3654f = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        public List<String> m5695a() {
            return this.f3652d;
        }

        public int getCount() {
            return this.f3652d.size();
        }

        public Filter getFilter() {
            return new C15421(this);
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            view = (TextView) view;
            if (view == null) {
                view = (TextView) this.f3654f.inflate(this.f3653e, null);
            }
            String str = (String) this.f3652d.get(i);
            view.setText(str.substring(0, str.indexOf(44)));
            this.f3650b.m4932a(this.f3651c, view, 1);
            return view;
        }
    }

    public static C1544k m5697a(int i) {
        C1544k c1544k = new C1544k();
        Bundle bundle = new Bundle();
        bundle.putInt("title", i);
        c1544k.setArguments(bundle);
        return c1544k;
    }

    public void m5699a(C1324e c1324e) {
        this.f3658c = c1324e;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getDialog().getWindow().requestFeature(1);
        this.f3659d = getResources().getStringArray(R.array.select_city);
        View inflate = layoutInflater.inflate(R.layout.dialog_search_list, viewGroup, false);
        this.f3657b = ((C1359a) getActivity()).m4982d();
        View view = (TextView) inflate.findViewById(R.id.dialog_title);
        view.setText(getString(getArguments().getInt("title")));
        this.f3657b.m4932a(getActivity(), view, 3);
        view = (EditText) inflate.findViewById(R.id.search_list_dialog_edittext);
        view.addTextChangedListener(this.f3656a);
        this.f3657b.m4932a(getActivity(), view, 2);
        ListView listView = (ListView) inflate.findViewById(R.id.search_list_dialog_listview);
        List asList = Arrays.asList(this.f3659d);
        if (asList != null && asList.size() > 0) {
            this.f3660e = new C1543a(this, getActivity(), R.layout.view_dialog_list_item, asList);
            listView.setAdapter(this.f3660e);
            listView.setScrollbarFadingEnabled(false);
            listView.setOnItemClickListener(new C15401(this));
        }
        return inflate;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
    }
}
