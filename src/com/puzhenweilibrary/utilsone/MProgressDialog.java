package com.puzhenweilibrary.utilsone;

import com.puzhenweilibrary.R;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.widget.TextView;

/**
 * 自定义进度Dialog
 */
public class MProgressDialog extends Dialog {
    private static MProgressDialog customProgressDialog = null;
    
    public MProgressDialog(Context context) {
        super(context);
    }
    
    public MProgressDialog(Context context, int theme) {
        super(context, theme);
    }
    
    public static MProgressDialog createDialog(Context context, int dialog_style, int dialog_layout) {
        customProgressDialog = new MProgressDialog(context, dialog_style);
        customProgressDialog.setContentView(dialog_layout);
        customProgressDialog.getWindow().getAttributes().gravity = Gravity.CENTER;
        return customProgressDialog;
    }
    
    public void onWindowFocusChanged(boolean hasFocus) {
        
        if (customProgressDialog == null) {
            return;
        }
        // ImageView imageView = (ImageView) customProgressDialog.findViewById(R.id.loadingImageView);
        // AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getBackground();
        // animationDrawable.start();
    }
    
    /**
     * 设置标题
     *
     * @param 标题
     * @return CustomProgressDialog
     */
    public MProgressDialog setTitile(String strTitle) {
        return customProgressDialog;
    }
    
    /**
     * 设置提示内容
     *
     * @param 显示信息
     * @return CustomProgressDialog
     */
    public MProgressDialog setMessage(String strMessage, int dialog_layout_tv) {
        TextView tvMsg = (TextView)customProgressDialog.findViewById(dialog_layout_tv);
        tvMsg.setText(strMessage + "");
        return customProgressDialog;
    }
}
