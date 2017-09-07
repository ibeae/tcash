package com.telkom.mwallet;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import com.telkom.mwallet.view.Random2of6PinEditView;

public class TestActivity extends Activity {
    Random2of6PinEditView f2893a;

    class C13361 implements OnClickListener {
        final /* synthetic */ TestActivity f2892a;

        C13361(TestActivity testActivity) {
            this.f2892a = testActivity;
        }

        public void onClick(View view) {
            if (this.f2892a.f2893a.m8024c()) {
                Toast.makeText(this.f2892a, this.f2892a.f2893a.getPin(), 1).show();
            }
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_test);
        this.f2893a = (Random2of6PinEditView) findViewById(R.id.pin_edit_view);
        ((Button) findViewById(R.id.button1)).setOnClickListener(new C13361(this));
    }
}
