package ws.bilka.learnenglish;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


    public class GameStatsActivity extends AppCompatActivity {

        private static final String TAG = GameStatsActivity.class.getName();

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_game_stats);
            Intent intent = getIntent();

            int numOfRightAnswers = intent.getIntExtra("right", 0);
            int numOfWrongAnswers = intent.getIntExtra("wrong", 0);

            TextView rightTextView = (TextView) findViewById(R.id.numberOfRightAnswer);
            TextView wrongTextView = (TextView) findViewById(R.id.numberOfWrongAnswer);

            rightTextView.setText(Integer.toString(numOfRightAnswers));
            wrongTextView.setText(Integer.toString(numOfWrongAnswers));

            final Button tryButton = (Button) findViewById(R.id.tryAgainBtn);
            tryButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(GameStatsActivity.this, ChooseFragment.class);
                    startActivity(intent);
                }
            });

            final Button goodButton = (Button) findViewById(R.id.goodBtn);
            goodButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(GameStatsActivity.this, CardActivity.class));
                }
            });
        }

        @Override
        public void onBackPressed() {
            startActivity(new Intent(GameStatsActivity.this,CardActivity.class));
        }

    }

