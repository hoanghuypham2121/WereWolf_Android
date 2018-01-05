package werewolf.random_characters;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class Result extends AppCompatActivity {

    int pos;
    Button btnGet;
    TextView txtRes, txtvNV;

    String[] characters, names = new String[100];
    int numbers, p_numbers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        Intent intent = getIntent();
        characters = intent.getStringArrayExtra("characters");
        names = intent.getStringArrayExtra("names");
        numbers = intent.getIntExtra("numbers", 0);
        p_numbers = intent.getIntExtra("p_numbers", 0);

        btnGet = (Button) findViewById(R.id.btnGet);
        txtRes = (TextView) findViewById(R.id.txtv);
        txtvNV = (TextView) findViewById(R.id.txtv1);
        Random rand = new Random();
        int times = rand.nextInt(99999) % 100 + 1;
        while (times != 0)
        {
            for (int i = numbers - 1; i >= 0; i--)
            {
                int id = rand.nextInt(i + 1);
                String a = characters[id];
                characters[id] = characters[i];
                characters[i] = a;
            }
            for (int i = p_numbers - 1; i >= 0; i--)
            {
                int id = rand.nextInt(i + 1);
                String a = names[id];
                names[id] = names[i];
                names[i] = a;
            }
            times--;
        }
        pos = 0;
        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pos == p_numbers)
                {
                    Intent showres = new Intent(Result.this, show.class);
                    showres.putExtra("names", names);
                    showres.putExtra("characters", characters);
                    showres.putExtra("n", p_numbers);
                    startActivity(showres);
                }
                else
                if (txtRes.getText().toString().equals(""))
                {
                    txtRes.setText(names[pos]);
                    txtvNV.setText(characters[pos]);
                    pos++;
                }
                else
                {
                    txtRes.setText("");
                    txtvNV.setText("");
                }
            }
        });
    }

}
