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
import com.skcc.wallet.framework.api.http.model.DataPackage;
import com.telkom.mwallet.C1359a;
import com.telkom.mwallet.R;
import com.telkom.mwallet.dialog.p063a.C1494a;
import com.telkom.mwallet.p064a.C1350d;
import java.util.List;

public class C1506b extends DialogFragment {
    private C1350d f3546a;
    private C1494a f3547b;
    private List<DataPackage> f3548c;
    private DisplayMetrics f3549d;

    class C15041 implements OnItemClickListener {
        final /* synthetic */ C1506b f3540a;

        C15041(C1506b c1506b) {
            this.f3540a = c1506b;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            this.f3540a.f3547b.mo1549a((DataPackage) this.f3540a.f3548c.get(i));
        }
    }

    private static class C1505a extends ArrayAdapter<DataPackage> {
        private C1350d f3541a = this.f3542b.m4982d();
        private C1359a f3542b;
        private List<DataPackage> f3543c;
        private int f3544d;
        private LayoutInflater f3545e;

        public C1505a(Context context, int i, List<DataPackage> list) {
            super(context, i, list);
            this.f3542b = (C1359a) context;
            this.f3543c = list;
            this.f3544d = i;
            this.f3545e = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            view = (TextView) view;
            if (view == null) {
                view = (TextView) this.f3545e.inflate(this.f3544d, viewGroup, false);
            }
            view.setText(((DataPackage) this.f3543c.get(i)).getPackageName());
            this.f3541a.m4932a(this.f3542b, view, 2);
            return view;
        }
    }

    public static C1506b m5631a(int i) {
        C1506b c1506b = new C1506b();
        Bundle bundle = new Bundle();
        bundle.putInt("title", i);
        c1506b.setArguments(bundle);
        return c1506b;
    }

    public void m5634a(C1494a c1494a) {
        this.f3547b = c1494a;
    }

    public void m5635a(List<DataPackage> list) {
        this.f3548c = list;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f3549d = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(this.f3549d);
        setStyle(1, 16974126);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.dialog_list, viewGroup, false);
        this.f3546a = ((C1359a) getActivity()).m4982d();
        View view = (TextView) inflate.findViewById(R.id.dialog_title);
        view.setText(getString(getArguments().getInt("title")));
        this.f3546a.m4932a(getActivity(), view, 3);
        ListView listView = (ListView) inflate.findViewById(R.id.list_dialog_listview);
        if (this.f3548c != null && this.f3548c.size() > 0) {
            listView.setAdapter(new C1505a(getActivity(), R.layout.view_dialog_list_item, this.f3548c));
            listView.setScrollbarFadingEnabled(false);
            listView.setOnItemClickListener(new C15041(this));
        }
        return inflate;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
    }

    public void onResume() {
        super.onResume();
        Window window = getDialog().getWindow();
        window.setLayout(this.f3549d.widthPixels, this.f3549d.heightPixels / 2);
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setGravity(17);
    }
}
