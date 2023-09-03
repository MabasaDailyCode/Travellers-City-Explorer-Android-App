package com.example.mabasafinalapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class CameraFragment extends Fragment {
    private ImageView img_display;
    private ImageButton photo_cap;
    private static final int pic_result = 7;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.camera_fragment, container, false);
        img_display = v.findViewById(R.id.imageView);
        photo_cap = v.findViewById(R.id.imageButton);

        photo_cap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent take_pic = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(take_pic, pic_result);

            }
        });

        return v;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        {
            if (requestCode == pic_result) {
                Bitmap photo = (Bitmap) data.getExtras().get("data");
                img_display.setImageBitmap(photo);
            }

        }
    }

}
