package vn.iotstar.baitap01;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.*;
import java.util.*;

public class MainActivity extends AppCompatActivity {

    EditText edtArray, edtString;
    Button btnArray, btnReverse;
    TextView tvArrayResult, tvStringResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtArray = findViewById(R.id.edtArray);
        edtString = findViewById(R.id.edtString);
        btnArray = findViewById(R.id.btnArray);
        btnReverse = findViewById(R.id.btnReverse);
        tvArrayResult = findViewById(R.id.tvArrayResult);
        tvStringResult = findViewById(R.id.tvStringResult);

        // XỬ LÝ MẢNG
        btnArray.setOnClickListener(v -> {
            String input = edtArray.getText().toString();
            String[] parts = input.split(",");

            ArrayList<Integer> numbers = new ArrayList<>();
            for (String p : parts) {
                numbers.add(Integer.parseInt(p.trim()));
            }

            ArrayList<Integer> chan = new ArrayList<>();
            ArrayList<Integer> le = new ArrayList<>();

            for (int n : numbers) {
                if (n % 2 == 0) chan.add(n);
                else le.add(n);
            }

            Log.d("CHAN", chan.toString());
            Log.d("LE", le.toString());

            tvArrayResult.setText("Số chẵn: " + chan + "\nSố lẻ: " + le);
        });

        // XỬ LÝ CHUỖI
        btnReverse.setOnClickListener(v -> {
            String s = edtString.getText().toString().trim();
            String[] words = s.split(" ");
            Collections.reverse(Arrays.asList(words));
            String reversed = String.join(" ", words);

            tvStringResult.setText(reversed);
            Toast.makeText(this, reversed, Toast.LENGTH_SHORT).show();
        });
    }
}