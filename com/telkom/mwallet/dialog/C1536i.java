package com.telkom.mwallet.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import android.widget.ListView;
import android.widget.TextView;
import com.skcc.wallet.framework.api.http.model.Region;
import com.telkom.mwallet.C1359a;
import com.telkom.mwallet.R;
import com.telkom.mwallet.dialog.p063a.C1499h;
import com.telkom.mwallet.p064a.C1350d;
import java.util.ArrayList;
import java.util.List;

public class C1536i extends DialogFragment {
    public TextWatcher f3634a = new C15332(this);
    private C1350d f3635b;
    private C1499h f3636c;
    private List<Region> f3637d;
    private DisplayMetrics f3638e;
    private C1535a f3639f;

    class C15321 implements OnItemClickListener {
        final /* synthetic */ C1536i f3625a;

        C15321(C1536i c1536i) {
            this.f3625a = c1536i;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            this.f3625a.f3636c.mo1552a((Region) this.f3625a.f3637d.get(i));
        }
    }

    class C15332 implements TextWatcher {
        final /* synthetic */ C1536i f3626a;

        C15332(C1536i c1536i) {
            this.f3626a = c1536i;
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.f3626a.f3639f.getFilter().filter(charSequence.toString());
        }
    }

    private static class C1535a extends ArrayAdapter<Region> {
        private C1350d f3628a = this.f3629b.m4982d();
        private C1359a f3629b;
        private List<Region> f3630c;
        private int f3631d;
        private LayoutInflater f3632e;
        private List<Region> f3633f;

        class C15341 extends Filter {
            final /* synthetic */ C1535a f3627a;

            C15341(C1535a c1535a) {
                this.f3627a = c1535a;
            }

            protected FilterResults performFiltering(CharSequence charSequence) {
                FilterResults filterResults = new FilterResults();
                List arrayList = new ArrayList();
                if (this.f3627a.f3633f == null) {
                    this.f3627a.f3633f = new ArrayList(this.f3627a.f3630c);
                }
                if (charSequence == null || charSequence.length() == 0) {
                    filterResults.count = this.f3627a.f3633f.size();
                    filterResults.values = this.f3627a.f3633f;
                } else {
                    CharSequence toLowerCase = charSequence.toString().toLowerCase();
                    for (int i = 0; i < this.f3627a.f3633f.size(); i++) {
                        Region region = (Region) this.f3627a.f3633f.get(i);
                        if (region.getRegionName().toLowerCase().contains(toLowerCase.toString())) {
                            arrayList.add(region);
                        }
                        filterResults.count = arrayList.size();
                        filterResults.values = arrayList;
                    }
                }
                return filterResults;
            }

            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                this.f3627a.f3630c = (List) filterResults.values;
                this.f3627a.notifyDataSetChanged();
            }
        }

        public C1535a(Context context, int i, List<Region> list) {
            super(context, i);
            this.f3629b = (C1359a) context;
            this.f3630c = list;
            this.f3631d = i;
            this.f3632e = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        public int getCount() {
            return this.f3630c.size();
        }

        public Filter getFilter() {
            return new C15341(this);
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            view = (TextView) view;
            if (view == null) {
                view = (TextView) this.f3632e.inflate(this.f3631d, viewGroup, false);
            }
            view.setText(((Region) this.f3630c.get(i)).getRegionName());
            this.f3628a.m4932a(this.f3629b, view, 1);
            return view;
        }
    }

    public static C1536i m5680a(int i) {
        C1536i c1536i = new C1536i();
        Bundle bundle = new Bundle();
        bundle.putInt("title", i);
        c1536i.setArguments(bundle);
        return c1536i;
    }

    public void m5684a(C1499h c1499h) {
        this.f3636c = c1499h;
    }

    public void m5685a(List<Region> list) {
        this.f3637d = list;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f3638e = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(this.f3638e);
        setStyle(1, 16974126);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.dialog_search_region_list, viewGroup, false);
        this.f3635b = ((C1359a) getActivity()).m4982d();
        View view = (TextView) inflate.findViewById(R.id.dialog_title);
        view.setText(getString(getArguments().getInt("title")));
        this.f3635b.m4932a(getActivity(), view, 3);
        view = (EditText) inflate.findViewById(R.id.search_list_dialog_edittext);
        view.addTextChangedListener(this.f3634a);
        this.f3635b.m4932a(getActivity(), view, 2);
        ListView listView = (ListView) inflate.findViewById(R.id.search_list_dialog_listview);
        if (this.f3637d != null && this.f3637d.size() > 0) {
            this.f3639f = new C1535a(getActivity(), R.layout.view_dialog_list_item, this.f3637d);
            listView.setAdapter(this.f3639f);
            listView.setScrollbarFadingEnabled(false);
            listView.setOnItemClickListener(new C15321(this));
        }
        return inflate;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
    }

    public void onResume() {
        super.onResume();
        Window window = getDialog().getWindow();
        window.setLayout(this.f3638e.widthPixels, (this.f3638e.heightPixels * 2) / 3);
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setGravity(17);
    }
}
