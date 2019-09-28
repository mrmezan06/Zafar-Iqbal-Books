package com.mezan.zafariqbalbooks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnDrawListener;
import com.github.barteksc.pdfviewer.listener.OnErrorListener;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.listener.OnPageErrorListener;
import com.github.barteksc.pdfviewer.listener.OnRenderListener;
import com.github.barteksc.pdfviewer.util.FitPolicy;
import com.github.barteksc.pdfviewer.util.PageSizeCalculator;
import com.google.android.material.snackbar.Snackbar;

public class Reader extends AppCompatActivity {

    LinearLayout root;
    PDFView pdfView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_reader);

        root = findViewById(R.id.root);
        pdfView = findViewById(R.id.pdfView);


        Intent it= getIntent();
        Bundle bundle = it.getExtras();
        if(bundle != null){
            String activity = bundle.getString("Activity");
            int index = bundle.getInt("index");
            if(activity.equals("ABV")){
                //Auto Biography file should be loaded
                PDFViewer("AB_Rongin.pdf");
            }else if (activity.equals("MSV")){
                // Math Science file shoul be loaded
                PDFViewer(MSV_File_name(index));


            }else if (activity.equals("OV")){
                // Others file should be loaded
                PDFViewer(OV_File_name(index));
            }else if (activity.equals("SFV")){
                //Science Fiction file should be loaded
                PDFViewer(SFV_File_name(index));
            }else if (activity.equals("SV")){
                // Stories file should be loaded
                PDFViewer(SV_File_name(index));
            }else {
                Snackbar.make(root, "Something Went Wrong!!!", Snackbar.LENGTH_LONG).show();
            }
        }
    }
    private void PDFViewer(String asset){

        if(asset.equals("Not Available")){
            Snackbar.make(root, "File not found!!!", Snackbar.LENGTH_LONG).show();
        }else {
            pdfView.fromAsset(asset)
                    .enableSwipe(true) // allows to block changing pages using swipe
                    .swipeHorizontal(true)
                    .enableDoubletap(true)
                    .defaultPage(0)
                    .enableAnnotationRendering(false) // render annotations (such as comments, colors or forms)
                    .password(null)
                    .scrollHandle(null)
                    .enableAntialiasing(true) // improve rendering a little bit on low-res screens
                    // spacing between pages in dp. To define spacing color, set view background
                    .spacing(0)
                    .pageFitPolicy(FitPolicy.WIDTH)
                    .onLoad(new OnLoadCompleteListener() {
                        @Override
                        public void loadComplete(int nbPages) {
                            Snackbar.make(root,"Pdf Load Completed",Snackbar.LENGTH_LONG).show();
                        }
                    })
                    .onError(new OnErrorListener() {
                        @Override
                        public void onError(Throwable t) {
                            Snackbar.make(root,"File can not open.Exception:"+t.getMessage(),Snackbar.LENGTH_LONG).show();
                        }
                    })
                    .onPageError(new OnPageErrorListener() {
                        @Override
                        public void onPageError(int page, Throwable t) {
                            Snackbar.make(root,"Page:"+page+" Exception:"+t.getMessage(),Snackbar.LENGTH_LONG).show();
                        }
                    })
                    .onPageChange(new OnPageChangeListener() {
                        @Override
                        public void onPageChanged(int page, int pageCount) {
                            Snackbar.make(root,"Page:"+(page+1)+"/"+pageCount,Snackbar.LENGTH_LONG).show();
                        }
                    })
                    .load();
        }

    }
    private String MSV_File_name(int index){
        String asset="";
        if(index == 0){
            asset = "MSV_Ektukhani.pdf";
        }else if (index == 1){
            asset = "MSV_AroEktukhani.pdf";
        }else if (index == 2){
            asset = "MSV_Neurone.pdf";
        }else if (index == 3){
            asset = "MSV_NeuroneAbaro.pdf";
        }else if (index == 4){
            asset = "MSV_Bigyaner.pdf";
        }else if (index == 5){
            asset = "MSV_Dekha.pdf";
        }else if (index == 6){
            asset = "MSV_Goniter.pdf";
        }else if (index == 7){
            asset = "MSV_Quantum.pdf";
        }else if (index == 8){
            asset = "MSV_Relativity.pdf";
        }else {
            asset = "Not Available";
        }

        return asset;
    }
    private String OV_File_name(int index){
        String asset="";
        if(index == 0){
            asset = "OV_A.pdf";
        }else if (index == 1){
            asset = "OV_B.pdf";
        }else if (index == 2){
            asset = "OV_C.pdf";
        }else if (index == 3){
            asset = "OV_D.pdf";
        }else if (index == 4){
            asset = "OV_E.pdf";
        }else if (index == 5){
            asset = "OV_F.pdf";
        }else if (index == 6){
            asset = "OV_G.pdf";
        }else if (index == 7){
            asset = "OV_H.pdf";
        }else if (index == 8){
            asset = "OV_I.pdf";
        }else {
            asset = "Not Available";
        }
        return asset;
    }
    private String SFV_File_name(int index){
        String asset="";
        if(index == 0){
            asset = "SF_A.pdf";
        }else if (index == 1){
            asset = "SF_B.pdf";
        }else if (index == 2){
            asset = "SF_C.pdf";
        }else if (index == 3){
            asset = "SF_D.pdf";
        }else if (index == 4){
            asset = "SF_E.pdf";
        }else if (index == 5){
            asset = "SF_F.pdf";
        }else if (index == 6){
            asset = "SF_G.pdf";
        }else if (index == 7){
            asset = "SF_H.pdf";
        }else if (index == 8){
            asset = "SF_I.pdf";
        }else if (index == 9){
            asset = "SF_J.pdf";
        }
        else {
            asset = "Not Available";
        }
        return asset;
    }
    private String SV_File_name(int index){
        String asset="";

        if(index == 0){
            asset = "SV_AA.pdf";
        }else if (index == 1){
            asset = "SV_AB.pdf";
        }else if (index == 2){
            asset = "SV_AC.pdf";
        }else if (index == 3){
            asset = "SV_AD.pdf";
        }else if (index == 4){
            asset = "SV_AE.pdf";
        }else if (index == 5){
            asset = "SV_AF.pdf";
        }else if (index == 6){
            asset = "SV_AG.pdf";
        }else if (index == 7){
            asset = "SV_AH.pdf";
        }else if (index == 8){
            asset = "SV_AI.pdf";
        }else if (index == 9){
            asset = "SV_AJ.pdf";
        }else if (index == 10){
            asset = "SV_AK.pdf";
        }else if (index == 11){
            asset = "SV_AL.pdf";
        }else if (index == 12){
            asset = "SV_AM.pdf";
        }else if (index == 13){
            asset = "SV_AN.pdf";
        }else if (index == 14){
            asset = "SV_AO.pdf";
        }else if (index == 15){
            asset = "SV_AP.pdf";
        }else if (index == 16){
            asset = "SV_AQ.pdf";
        }else if (index == 17){
            asset = "SV_AR.pdf";
        }else if (index == 18){
            asset = "SV_AS.pdf";
        }else if (index == 19){
            asset = "SV_AT.pdf";
        }else if (index == 20){
            asset = "SV_AU.pdf";
        }else if (index == 21){
            asset = "SV_AV.pdf";
        }else if (index == 22){
            asset = "SV_AW.pdf";
        }else if (index == 23){
            asset = "SV_AX.pdf";
        }else if (index == 24){
            asset = "SV_AY.pdf";
        }else if (index == 25){
            asset = "SV_AZ.pdf";
        }else if (index == 26){
            asset = "SV_BA.pdf";
        }else if (index == 27){
            asset = "SV_BB.pdf";
        }else if (index == 28){
            asset = "SV_BC.pdf";
        }else if (index == 29){
            asset = "SV_BD.pdf";
        }else if (index == 30){
            asset = "SV_BE.pdf";
        }else if (index == 31){
            asset = "SV_BF.pdf";
        }else if (index == 32){
            asset = "SV_BG.pdf";
        }else if (index == 33){
            asset = "SV_BH.pdf";
        }else {
                asset = "Not Available";
            }

        return asset;
    }

}
