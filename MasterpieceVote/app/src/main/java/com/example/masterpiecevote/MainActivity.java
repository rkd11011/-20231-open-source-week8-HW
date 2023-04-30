package com.example.masterpiecevote;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//레이아웃 지정

        //액션바
        getSupportActionBar().setDisplayShowHomeEnabled(true);//홈버튼 표시
        getSupportActionBar().setIcon(R.drawable.image10);// 액션바 아이콘 지정
        setTitle("명화 선호도 투표");//액션바 제목

        final int voteCount[] = new int[9];//이미지 버튼을 저장할 배열
        for (int i = 0; i < 9; i++)//배열 초기화
            voteCount[i] = 0;

        // 이미지 버튼 객체 배열
        ImageView image[] = new ImageView[9];
        //이미지 버튼 객체 ID 저장
        Integer imageId[] = { R.id.iv1, R.id.iv2, R.id.iv3, R.id.iv4, R.id.iv5,
                R.id.iv6, R.id.iv7, R.id.iv8, R.id.iv9 };

        //이미지 버튼 이름 배열
        final String imgName[] = { "그림1", "그림2", "그림3", "그림4", "그림5", "그림6", "그림7", "그림8", "그림9" };

        for (int i = 0; i < imageId.length; i++) {
            final int index; // 인텍스 값 저장
            index = i;

            //이미지 버튼 객체 생성후 배열에 저장
            image[index] = (ImageView) findViewById(imageId[index]);

            //클릭 이벤트 리스너 등록
            image[index].setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                    //해당 이미지 투표수 증가.
                    voteCount[index]++;
                    //토스트 메시지 출력
                    Toast.makeText(getApplicationContext(),
                            imgName[index] + ": 총 " + voteCount[index] + " 표",
                            Toast.LENGTH_SHORT).show();
                }
            });
        }
        // 걀과 보기 버튼 생성
        Button btnFinish = (Button) findViewById(R.id.btnResult);
        //결과 보기 버튼에 클릭 이벤트 리스너 등록
        btnFinish.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                intent.putExtra("VoteCount", voteCount);
                intent.putExtra("ImageName", imgName);
                startActivity(intent);
            }
        });

    }
}
