package com.puzhenweilibrary.utilsone;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;


import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 照片压缩帮助类
 * Created by XiaoWei on 2015/8/17.
 */
public class PhotoCompressUtil {

    private static final String TAG = "PhotoCompressUtil";

    public List<String> compressedPaths = new ArrayList<String>();

    public PhotoCompressUtil() {

    }

    public PhotoCompressUtil(List<String> paths) {
        for (String path : paths) {
            revisionImageSize(path, path);
        }
    }

    public synchronized String revisionImageSize(String path, String cache_photo_path) {
        try {
            BufferedInputStream in = new BufferedInputStream(new FileInputStream(new File(path)));
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(in, null, options);
            in.close();
            int i = 0;
            Bitmap bitmap;
            while (true) {
                if ((options.outWidth >> i <= 1000) && (options.outHeight >> i <= 1000)) {
                    in = new BufferedInputStream(new FileInputStream(new File(path)));
                    options.inSampleSize = (int) Math.pow(2.0D, i);// 2.0D的i次方
                    options.inJustDecodeBounds = false;
                    bitmap = BitmapFactory.decodeStream(in, null, options);
                    break;
                }
                i += 1;
            }

            File file = new File(cache_photo_path);
            if (!file.exists())
                file.mkdirs();
            OutputStream stream = null;
            try {
                // 压缩完毕后的图片保存路径
                String name = path.substring(path.lastIndexOf("/") + 1);
                StringBuilder builder = new StringBuilder();
                String compressedPhotoPath = builder.append(cache_photo_path)
                        .append("/").append(name).toString();
                stream = new FileOutputStream(compressedPhotoPath);

                int angle = readPictureDegree(path);// 获取图片旋转角度
                Matrix matrix = new Matrix();
                matrix.postRotate(angle);
                bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);

                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);

                compressedPaths.add(compressedPhotoPath);

                return compressedPhotoPath;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (stream != null)
                        stream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 读取图片属性：旋转的角度
     */
    private int readPictureDegree(String path) {
        int degree = 0;
        try {
            ExifInterface exifInterface = new ExifInterface(path);
            int orientation = exifInterface.getAttributeInt(ExifInterface.TAG_ORIENTATION,
                    ExifInterface.ORIENTATION_NORMAL);
            switch (orientation) {
                case ExifInterface.ORIENTATION_ROTATE_90:
                    degree = 90;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_180:
                    degree = 180;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_270:
                    degree = 270;
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return degree;
    }

}
