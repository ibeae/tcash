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
import com.skcc.wallet.framework.api.http.model.TypeInsurance;
import com.telkom.mwallet.C1359a;
import com.telkom.mwallet.R;
import com.telkom.mwallet.dialog.p063a.C1502k;
import com.telkom.mwallet.p064a.C1350d;
import java.util.List;

public class C1555n extends DialogFragment {
    private C1350d f3692a;
    private C1502k f3693b;
    private List<TypeInsurance> f3694c;
    private DisplayMetrics f3695d;

    class C15531 implements OnItemClickListener {
        final /* synthetic */ C1555n f3686a;

        C15531(C1555n c1555n) {
            this.f3686a = c1555n;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            this.f3686a.f3693b.mo1571a((TypeInsurance) this.f3686a.f3694c.get(i));
        }
    }

    private static class C1554a extends ArrayAdapter<TypeInsurance> {
        private C1350d f3687a = this.f3688b.m4982d();
        private C1359a f3688b;
        private List<TypeInsurance> f3689c;
        private int f3690d;
        private LayoutInflater f3691e;

        public C1554a(Context context, int i, List<TypeInsurance> list) {
            super(context, i, list);
            this.f3688b = (C1359a) context;
            this.f3689c = list;
            this.f3690d = i;
            this.f3691e = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            view = (TextView) view;
            if (view == null) {
                view = (TextView) this.f3691e.inflate(this.f3690d, viewGroup, false);
            }
            view.setText(((TypeInsurance) this.f3689c.get(i)).getDataName());
            this.f3687a.m4932a(this.f3688b, view, 2);
            return view;
        }
    }

    public static C1555n m5712a(int i) {
        C1555n c1555n = new C1555n();
        Bundle bundle = new Bundle();
        bundle.putInt("title", i);
        c1555n.setArguments(bundle);
        return c1555n;
    }

    public void m5715a(C1502k c1502k) {
        this.f3693b = c1502k;
    }

    public void m5716a(List<TypeInsurance> list) {
        this.f3694c = list;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f3695d = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(this.f3695d);
        setStyle(1, 16974126);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.dialog_list, viewGroup, false);
        this.f3692a = ((C1359a) getActivity()).m4982d();
        View view = (TextView) inflate.findViewById(R.id.dialog_title);
        view.setText(getString(getArguments().getInt("title")));
        this.f3692a.m4932a(getActivity(), view, 3);
        ListView listView = (ListView) inflate.findViewById(R.id.list_dialog_listview);
        if (this.f3694c != null && this.f3694c.size() > 0) {
            listView.setAdapter(new C1554a(getActivity(), R.layout.view_dialog_list_item, this.f3694c));
            listView.setScrollbarFadingEnabled(false);
            listView.setOnItemClickListener(new C15531(this));
        }
        return inflate;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
    }

    public void onResume() {
        super.onResume();
        Window window = getDialog().getWindow();
        window.setLayout(this.f3695d.widthPixels, this.f3695d.heightPixels / 2);
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setGravity(17);
    }
}
