package werewolf.random_characters;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class characters_Choices extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    int []a = new int[20];
    String []characters = new String[1000];
    String []names = new String[1000];
    EditText edtSL;
    Spinner choice;
    Button Reset , Go;
    TextView txtvRes;
    int selectedPos, d;
    boolean check = true;
    int p_numbers;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.characterschoices);

        Intent intent = getIntent();
        p_numbers = intent.getIntExtra("p_numbers", 0);
        names = intent.getStringArrayExtra("names");

        edtSL = (EditText) findViewById(R.id.txtSL);
        choice = (Spinner) findViewById(R.id.spChoices);
        Reset = (Button)findViewById(R.id.btnReset);
        Go = (Button)findViewById(R.id.btnGo);
        txtvRes = (TextView) findViewById(R.id.txtRes);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.characters, android.R.layout.simple_spinner_item);
        choice.setAdapter(adapter);
        choice.setOnItemSelectedListener(this);

        choice.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (!edtSL.getText().toString().equals(""))
                    a[selectedPos] = Integer.parseInt(edtSL.getText().toString());
                else a[selectedPos] = 0;
                check = true;
                return false;
            }
        });

        Reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < 20; i++)
                    a[i] = 0;
                edtSL.setText("0");
                choice.setSelection(0);
                check = false;
            }
        });

        Go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!edtSL.getText().toString().equals(""))
                    a[selectedPos] = Integer.parseInt(edtSL.getText().toString());
                else a[selectedPos] = 0;
                //initialize numbers of elements in characters array
                d = 0;
                //proceed
                for (int i = 0; i < 16; i++)
                for (int j = 1; j <= a[i]; j++) {
                    switch (i) {
                        case 0:
                            push("Sói");
                            break;
                        case 1:
                            push("Thợ săn");
                            break;
                        case 2:
                            push("Dân");
                            break;
                        case 3:
                            push("Pháp sư câm");
                            break;
                        case 4:
                            push("Bảo vệ");
                            break;
                        case 5:
                            push("Nguyền rủa");
                            break;
                        case 6:
                            push("Tiên tri");
                            break;
                        case 7:
                            push("Phù thủy");
                            break;
                        case 8:
                            push("Cupid");
                            break;
                        case 9:
                            push("Yêu tinh");
                            break;
                        case 10:
                            push("Chán đời");
                            break;
                        case 11:
                            push("Sói con");
                            break;
                        case 12:
                            push("Già làng");
                            break;
                        case 13:
                            push("Con bệnh");
                            break;
                        case 14:
                            push("Nhân bản");
                            break;
                        case 15:
                            push("Phản bội");
                            break;
                    }
                }
                    //push data to result activity
                //check if numbers of players equals with numbers of characters
                if (p_numbers != d)
                    Toast.makeText(characters_Choices.this, "Số người chơi và nhân vật phải bằng nhau", Toast.LENGTH_SHORT).show();
                else
                {
                    Intent res = new Intent(characters_Choices.this, Result.class);
                    res.putExtra("characters", characters);
                    res.putExtra("names", names);
                    res.putExtra("p_numbers", p_numbers);
                    res.putExtra("numbers", d);
                    startActivity(res);
                }
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (edtSL.getText().toString() != "")
            edtSL.setText(Integer.toString(a[position]));
        else edtSL.setText("0");
        selectedPos = position;
        edtSL.selectAll();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void push(String name)
    {
        characters[d++] = name;
    }
}
