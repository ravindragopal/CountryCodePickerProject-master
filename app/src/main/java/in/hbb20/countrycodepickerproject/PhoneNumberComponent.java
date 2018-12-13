package in.hbb20.countrycodepickerproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.hbb20.CountryCodePicker;

public class PhoneNumberComponent extends AppCompatActivity {

    EditText editTextLoadFullNumber, editTextLoadCarrierNumber;

    CountryCodePicker ccpLoadNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_number_component);

        //load number
        editTextLoadCarrierNumber = (EditText) findViewById(R.id.editText_loadCarrierNumber);
        ccpLoadNumber = (CountryCodePicker) findViewById(R.id.ccp_loadFullNumber);

//        ccpLoadNumber.registerCarrierNumberEditText(editTextLoadCarrierNumber);

        editTextLoadCarrierNumber.addTextChangedListener(mTextEditorWatcher);

    }

    private final TextWatcher mTextEditorWatcher = new TextWatcher() {
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String code = editTextLoadCarrierNumber.getText().toString();
            if (code.length() == 3 && code.substring(0,1).contains("+")) {
                ccpLoadNumber.setFullNumber(editTextLoadCarrierNumber.getText().toString());
            }
        }

        public void afterTextChanged(Editable s) {
        }
    };

}
