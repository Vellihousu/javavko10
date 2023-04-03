package veikko.vanninen.userprogram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class AddUserActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private EditText ptFirstName;
    private EditText ptLastName;
    private EditText ptEmail;
    private RadioGroup radioGroup;
    private Button addUser;
    private Context context;
    UserStorage us = UserStorage.getInstance();
    private CheckBox cbBScEngineer;
    private CheckBox cbMScEngineer;
    private CheckBox cbDScEngineer;
    private CheckBox cbSwimMaster;
    private String userDegrees;
    private ArrayList<String> degrees = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        ptFirstName = findViewById(R.id.ptFirstName);
        ptLastName = findViewById(R.id.ptLastName);
        ptEmail = findViewById(R.id.ptEmail);
        radioGroup = findViewById(R.id.rgDegreeProgram);
        addUser = findViewById(R.id.btnAddNewUser);
        cbBScEngineer = findViewById(R.id.cbBEngineer);
        cbMScEngineer = findViewById(R.id.cbMScEngineer);
        cbDScEngineer = findViewById(R.id.cbDScEngineer);
        cbSwimMaster = findViewById(R.id.cbSwimMaster);


        context = this;
    }

    public void addUser(View view) {

        String firstName = ptFirstName.getText().toString();
        String lastName = ptLastName.getText().toString();
        String email = ptEmail.getText().toString();

        int radioButtonId = radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(radioButtonId);
        String degreeProgram = radioButton.getText().toString();

        if (cbBScEngineer.isChecked()) {
            userDegrees = cbBScEngineer.getText().toString();
            degrees.add(userDegrees);
        }
        if (cbMScEngineer.isChecked()) {
            userDegrees = cbMScEngineer.getText().toString();
            degrees.add(userDegrees);
        }
        if (cbDScEngineer.isChecked()) {
            userDegrees = cbDScEngineer.getText().toString();
            degrees.add(userDegrees);
        }
        if (cbSwimMaster.isChecked()) {
            userDegrees = cbSwimMaster.getText().toString();
            degrees.add(userDegrees);
        }

        User user = new User(firstName, lastName, email, degreeProgram, degrees);

        us.addUser(user);
        us.saveUsers(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}