package com.example.mynews.activities;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.View;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mynews.databinding.LayoutProgressDialogBinding;
import com.example.mynews.listener.OkListener;

public class BaseActivity extends AppCompatActivity {

    private Dialog mDialog;
    private LayoutProgressDialogBinding binding;

    public void messageDialog(String message, OkListener listener){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setMessage(message);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dismiss(builder);
                if (listener!=null){
                    listener.onClickOk(message);
                }
            }
        });
        builder.show();
    }
    private void dismiss(AlertDialog.Builder builder) {
        builder.create().dismiss();
    }

    public void showProgress(){
        if (mDialog==null){
            mDialog=new Dialog(this);
            binding= LayoutProgressDialogBinding.inflate(getLayoutInflater());
            View view=binding.getRoot();
            mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            mDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
            mDialog.setContentView(view);
            mDialog.setCancelable(false);
        }
        mDialog.show();
    }
    public void hideProgress(){
        if (mDialog.isShowing()){
            mDialog.dismiss();
        }
    }
}
