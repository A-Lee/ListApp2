package com.example.ali.listapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.widget.ImageView;

public class detailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent in = getIntent();
        int index = in.getIntExtra("com.example.ali.listapp.itemIndex", -1);

        if(index > -1)
        {
            int pic = getImage(index);
            ImageView imageView = (ImageView) findViewById(R.id.imageView);
            scaleIMG(imageView,pic);
        }
    }

    private int getImage(int index)
    {
        switch(index)
        {
            case 0:
                return R.drawable.ps2;
            case 1:
                return R.drawable.ps3;
            case 2:
                return R.drawable.ps4;
            default:
                return  -1;
        }
    }
    private void scaleIMG(ImageView img, int pic)
    {
        Display screen = getWindowManager().getDefaultDisplay();
        BitmapFactory.Options bfo = new BitmapFactory.Options();
        bfo.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), pic, bfo);

        int imgWidth = bfo.outWidth;
        int screenWidth = screen.getWidth();
        if(imgWidth>screenWidth)
        {
            int ratio = Math.round((float)imgWidth / (float)screenWidth);
            bfo.inSampleSize = ratio;
        }
        bfo.inJustDecodeBounds = false;

        Bitmap scaledImg = BitmapFactory.decodeResource(getResources(),pic,bfo);
        img.setImageBitmap(scaledImg);
    }
}
