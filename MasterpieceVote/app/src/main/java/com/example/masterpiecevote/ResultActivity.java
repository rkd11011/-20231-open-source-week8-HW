package com.example.masterpiecevote;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

//결과화면 액티비티 클래스
public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);//레이아웃 지정

        //액션바
        getSupportActionBar().setDisplayShowHomeEnabled(true);//홈 버튼 표사
        getSupportActionBar().setIcon(R.drawable.image10);// 액션바 아이콘
        setTitle("투표 결과");//액션바 제목

        // 전 화면에서 보낸 투표 결과 값
        Intent intent = getIntent();

        //정수형으로 전달된 객체
        int[] voteResult = intent.getIntArrayExtra("VoteCount");
        //문자열로 전달된 객체
        String[] imageName = intent.getStringArrayExtra("ImageName");

        // TextView, RatingBar 객체배열
        TextView tv[] = new TextView[imageName.length];
        RatingBar rbar[] = new RatingBar[imageName.length];

        // TextView ID, RatingBar ID 배열
        Integer tvID[] = { R.id.tv1, R.id.tv2, R.id.tv3, R.id.tv4, R.id.tv5,
                R.id.tv6, R.id.tv7, R.id.tv8, R.id.tv9 };
        Integer rbarID[] = { R.id.rbar1, R.id.rbar2, R.id.rbar3, R.id.rbar4,
                R.id.rbar5, R.id.rbar6, R.id.rbar7, R.id.rbar8, R.id.rbar9 };

        // TextView, RatingBar 개체 찾기
        for (int i = 0; i < voteResult.length; i++) {
            tv[i] = (TextView) findViewById(tvID[i]);
            rbar[i] = (RatingBar) findViewById(rbarID[i]);
        }

        // TextVeiw, RatingBar에 전달 된 값 적용
        for (int i = 0; i < voteResult.length; i++) {
            tv[i].setText(imageName[i]);
            rbar[i].setRating((float) voteResult[i]);
        }
        //버튼생성
        Button btnReturn = (Button) findViewById(R.id.btnReturn);
        
        //클릭이 벤트 리스너로 등록
        btnReturn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();

            }
        });

    }
}
