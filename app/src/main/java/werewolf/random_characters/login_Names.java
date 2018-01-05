package werewolf.random_characters;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.HashSet;
import java.util.Set;

public class login_Names extends AppCompatActivity {

    Set<String> names = new HashSet<String>();
    String[] Names = new String[22];
    int numbers;
    Button btnSub;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginnames);
        btnSub = (Button)findViewById(R.id.btnSubmit);

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (names.size() == 0)
                    Toast.makeText(login_Names.this, "Phải có ít nhất 1 người chơi", Toast.LENGTH_SHORT).show();
                else
                {
                    Intent choose = new Intent(login_Names.this, characters_Choices.class);
                    numbers = 0;
                    for (String s : names)
                        Names[numbers++] = s;
                    choose.putExtra("names", Names);
                    choose.putExtra("p_numbers", numbers);
                    startActivity(choose);
                }
            }
        });
    }

    public void push(String name)
    {
        names.add(name);
    }

    public void pop(String name)
    {
        names.remove(name);
    }

    public void addElement(View view)
    {
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId())
        {
            case R.id.bachlq:
                if (checked)
                    push("Bách");
                else  pop("Bách");
                break;
            case R.id.baottd:
                if (checked)
                    push("Bảo");
                else  pop("Bảo");
                break;
            case R.id.cuonglv:
                if (checked)
                    push("Cường");
                else  pop("Cường");
                break;
            case R.id.danhtc:
                if (checked)
                    push("Danh");
                else  pop("Danh");
                break;
            case R.id.duyvk:
                if (checked)
                    push("Duy");
                else  pop("Duy");
                break;
            case R.id.ducnvv:
                if (checked)
                    push("Đức");
                else  pop("Đức");
                break;
            case R.id.huunv:
                if (checked)
                    push("Hữu");
                else  pop("Hữu");
                break;
            case R.id.hanlts:
                if (checked)
                    push("Hân");
                else  pop("Hân");
                break;
            case R.id.hienlm:
                if (checked)
                    push("Hiền");
                else  pop("Hiền");
                break;
            case R.id.hieuhd:
                if (checked)
                    push("Hiếu");
                else  pop("Hiếu");
                break;
            case R.id.hoaittt:
                if (checked)
                    push("Hoài");
                else  pop("Hoài");
                break;
            case R.id.hoangph:
                if (checked)
                    push("Hoàng");
                else  pop("Hoàng");
                break;
            case R.id.huytl:
                if (checked)
                    push("Huy");
                else  pop("Huy");
                break;
            case R.id.khanhtq:
                if (checked)
                    push("Khánh");
                else  pop("Khánh");
                break;
            case R.id.khoipd:
                if (checked)
                    push("Khôi");
                else  pop("Khôi");
                break;
            case R.id.luantt:
                if (checked)
                    push("Luận");
                else  pop("Luận");
                break;
            case R.id.ngocndt:
                if (checked)
                    push("Ngọc");
                else  pop("Ngọc");
                break;
            case R.id.nhantt:
                if (checked)
                    push("Trần Nhàn");
                else  pop("Trần Nhàn");
                break;
            case R.id.nhanhltt:
                if (checked)
                    push("Lê Nhàn");
                else  pop("Lê Nhàn");
                break;
            case R.id.thinhnh:
                if (checked)
                    push("Thịnh");
                else  pop("Thịnh");
                break;
            case R.id.tuannq:
                if (checked)
                    push("Tuấn");
                else  pop("Tuấn");
                break;
        }
    }
}
