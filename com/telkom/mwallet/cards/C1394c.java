package com.telkom.mwallet.cards;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.telkom.mwallet.R;
import com.telkom.mwallet.tcash.fragment.C1386e;

public class C1394c extends C1386e {

    class C13931 implements OnClickListener {
        final /* synthetic */ C1394c f3094a;

        C13931(C1394c c1394c) {
            this.f3094a = c1394c;
        }

        public void onClick(View view) {
            this.f3094a.startActivity(new Intent(this.f3094a.getActivity().getApplicationContext(), CardAddListActivity.class));
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_card_empty, null);
        ((ImageView) inflate.findViewById(R.id.card_add_img)).setOnClickListener(new C13931(this));
        return inflate;
    }
}
