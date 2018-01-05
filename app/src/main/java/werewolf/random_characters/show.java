package werewolf.random_characters;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class show extends AppCompatActivity {

    ListView lstvdetails;
    Button btnPlay;
    String[] names, characters;
    boolean checkPlaying = false;
    MediaPlayer mediaPlayer;
    TextView txtvplaying;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show);
        lstvdetails = findViewById(R.id.lstvkq);
        btnPlay = findViewById(R.id.play);
        txtvplaying = findViewById(R.id.playing);
        Intent intent = getIntent();
        names = intent.getStringArrayExtra("names");
        characters = intent.getStringArrayExtra("characters");
        int n = intent.getIntExtra("n",0);
        String[] combination = new String[n];
        for (int i = 0; i < n; i++)
            combination[i] = names[i] + repeat(" ", 30 - names[i].length()) + characters[i];
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_activated_1, combination);
        lstvdetails.setAdapter(arrayAdapter);


        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!checkPlaying)
                {
                    checkPlaying = true;
                    mediaPlayer = MediaPlayer.create(show.this, R.raw.xoso);
                    txtvplaying.setText("Đang chạy nhạc xổ số :))");
                    mediaPlayer.start();

                }
                else
                {
                    checkPlaying = false;
                    txtvplaying.setText("");
                    mediaPlayer.release();
                }
            }
        });
    }



    public String repeat(String st, int times)
    {
        return new String(new char[times]).replace("\0", st);
    }

}
