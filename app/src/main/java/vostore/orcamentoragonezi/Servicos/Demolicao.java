package vostore.orcamentoragonezi.Servicos;

import android.content.Context;
import android.content.Intent;
import android.Manifest;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.StrictMode;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

import vostore.orcamentoragonezi.Main2Activity;

import vostore.orcamentoragonezi.Permissoes.PermissionsChecker;
import vostore.orcamentoragonezi.R;

import static vostore.orcamentoragonezi.pdf.LogUtils.LOGE;

public class Demolicao extends AppCompatActivity {

    final private int REQUEST_CODE_ASK_PERMISSIONS = 111;
    private LinearLayout relativeLayout;
    private Document document;
    private CheckBox checkBoxCozinha;
    private CheckBox checkBoxBanheiroSocial,checkBoxAreaServico,checkBoxBanheiroSuite,checkBoxLavabo,checkBoxSacadaVaranda,checkBoxSalaJantar,checkBoxSalaEstar,checkBoxQuartoSuite,checkBoxQuarto1,checkBoxQuarto2;
    private LinearLayout linearLayout1,linearLayout2,linearLayout3,linearLayout4,linearLayout5,linearLayout6,linearLayout7,linearLayout8,linearLayout9,linearLayout10,linearLayout11;
    private EditText valorRevestimentoParede1,valorRevestimentoParede1_1,valorRemocaoPiso1,valorRemocaoPiso1_1,valorRemocaoPia1,valorRemocaoPia1_1,valorRemocacAlvenaria1,valorRemocacAlvenaria1_1,valorRemocaoTanque1,valorRemocaoTanque1_1,valorRasgarCaixinha4x2_1,valorRasgarCaixinha4x2_1_1,valorRasgarCaixinha4x4_1,valorRasgarCaixinha4x4_1_1,valorRasgarHidraulica1,valorRasgarHidraulica1_1,valorRemoverGesso1,valorRemoverGesso1_1,valorRemoverVaso1,valorRemoverVaso1_1,valorRemoverVao1,valorRemoverVao1_1,
            valorRevestimentoParede2,valorRevestimentoParede2_1,valorRemocaoPiso2,valorRemocaoPiso2_1,valorRemocaoPia2,valorRemocaoPia2_1,valorRemocacAlvenaria2,valorRemocacAlvenaria2_1,valorRemocaoTanque2,valorRemocaoTanque2_1,valorRasgarCaixinha4x2_2,valorRasgarCaixinha4x2_2_1,valorRasgarCaixinha4x4_2,valorRasgarCaixinha4x4_2_1,valorRasgarHidraulica2,valorRasgarHidraulica2_1,valorRemoverGesso2,valorRemoverGesso2_1,valorRemoverVaso2,valorRemoverVaso2_1,valorRemoverVao2,valorRemoverVao2_1,
            valorRevestimentoParede3,valorRevestimentoParede3_1,valorRemocaoPiso3,valorRemocaoPiso3_1,valorRemocaoPia3,valorRemocaoPia3_1,valorRemocacAlvenaria3,valorRemocacAlvenaria3_1,valorRemocaoTanque3,valorRemocaoTanque3_1,valorRasgarCaixinha4x2_3,valorRasgarCaixinha4x2_3_1,valorRasgarCaixinha4x4_3,valorRasgarCaixinha4x4_3_1,valorRasgarHidraulica3,valorRasgarHidraulica3_1,valorRemoverGesso3,valorRemoverGesso3_1,valorRemoverVaso3,valorRemoverVaso3_1,valorRemoverVao3,valorRemoverVao3_1,
            valorRevestimentoParede4,valorRevestimentoParede4_1,valorRemocaoPiso4,valorRemocaoPiso4_1,valorRemocaoPia4,valorRemocaoPia4_1,valorRemocacAlvenaria4,valorRemocacAlvenaria4_1,valorRemocaoTanque4,valorRemocaoTanque4_1,valorRasgarCaixinha4x2_4,valorRasgarCaixinha4x2_4_1,valorRasgarCaixinha4x4_4,valorRasgarCaixinha4x4_4_1,valorRasgarHidraulica4,valorRasgarHidraulica4_1,valorRemoverGesso4,valorRemoverGesso4_1,valorRemoverVaso4,valorRemoverVaso4_1,valorRemoverVao4,valorRemoverVao4_1,
            valorRevestimentoParede5,valorRevestimentoParede5_1,valorRemocaoPiso5,valorRemocaoPiso5_1,valorRemocaoPia5,valorRemocaoPia5_1,valorRemocacAlvenaria5,valorRemocacAlvenaria5_1,valorRemocaoTanque5,valorRemocaoTanque5_1,valorRasgarCaixinha4x2_5,valorRasgarCaixinha4x2_5_1,valorRasgarCaixinha4x4_5,valorRasgarCaixinha4x4_5_1,valorRasgarHidraulica5,valorRasgarHidraulica5_1,valorRemoverGesso5,valorRemoverGesso5_1,valorRemoverVaso5,valorRemoverVaso5_1,valorRemoverVao5,valorRemoverVao5_1,
            valorRevestimentoParede6,valorRevestimentoParede6_1,valorRemocaoPiso6,valorRemocaoPiso6_1,valorRemocaoPia6,valorRemocaoPia6_1,valorRemocacAlvenaria6,valorRemocacAlvenaria6_1,valorRemocaoTanque6,valorRemocaoTanque6_1,valorRasgarCaixinha4x2_6,valorRasgarCaixinha4x2_6_1,valorRasgarCaixinha4x4_6,valorRasgarCaixinha4x4_6_1,valorRasgarHidraulica6,valorRasgarHidraulica6_1,valorRemoverGesso6,valorRemoverGesso6_1,valorRemoverVaso6,valorRemoverVaso6_1,valorRemoverVao6,valorRemoverVao6_1,
            valorRevestimentoParede7,valorRevestimentoParede7_1,valorRemocaoPiso7,valorRemocaoPiso7_1,valorRemocaoPia7,valorRemocaoPia7_1,valorRemocacAlvenaria7,valorRemocacAlvenaria7_1,valorRemocaoTanque7,valorRemocaoTanque7_1,valorRasgarCaixinha4x2_7,valorRasgarCaixinha4x2_7_1,valorRasgarCaixinha4x4_7,valorRasgarCaixinha4x4_7_1,valorRasgarHidraulica7,valorRasgarHidraulica7_1,valorRemoverGesso7,valorRemoverGesso7_1,valorRemoverVaso7,valorRemoverVaso7_1,valorRemoverVao7,valorRemoverVao7_1,
            valorRevestimentoParede8,valorRevestimentoParede8_1,valorRemocaoPiso8,valorRemocaoPiso8_1,valorRemocaoPia8,valorRemocaoPia8_1,valorRemocacAlvenaria8,valorRemocacAlvenaria8_1,valorRemocaoTanque8,valorRemocaoTanque8_1,valorRasgarCaixinha4x2_8,valorRasgarCaixinha4x2_8_1,valorRasgarCaixinha4x4_8,valorRasgarCaixinha4x4_8_1,valorRasgarHidraulica8,valorRasgarHidraulica8_1,valorRemoverGesso8,valorRemoverGesso8_1,valorRemoverVaso8,valorRemoverVaso8_1,valorRemoverVao8,valorRemoverVao8_1,
            valorRevestimentoParede9,valorRevestimentoParede9_1,valorRemocaoPiso9,valorRemocaoPiso9_1,valorRemocaoPia9,valorRemocaoPia9_1,valorRemocacAlvenaria9,valorRemocacAlvenaria9_1,valorRemocaoTanque9,valorRemocaoTanque9_1,valorRasgarCaixinha4x2_9,valorRasgarCaixinha4x2_9_1,valorRasgarCaixinha4x4_9,valorRasgarCaixinha4x4_9_1,valorRasgarHidraulica9,valorRasgarHidraulica9_1,valorRemoverGesso9,valorRemoverGesso9_1,valorRemoverVaso9,valorRemoverVaso9_1,valorRemoverVao9,valorRemoverVao9_1,
            valorRevestimentoParede10,valorRevestimentoParede10_1,valorRemocaoPiso10,valorRemocaoPiso10_1,valorRemocaoPia10,valorRemocaoPia10_1,valorRemocacAlvenaria10,valorRemocacAlvenaria10_1,valorRemocaoTanque10,valorRemocaoTanque10_1,valorRasgarCaixinha4x2_10,valorRasgarCaixinha4x2_10_1,valorRasgarCaixinha4x4_10,valorRasgarCaixinha4x4_10_1,valorRasgarHidraulica10,valorRasgarHidraulica10_1,valorRemoverGesso10,valorRemoverGesso10_1,valorRemoverVaso10,valorRemoverVaso10_1,valorRemoverVao10,valorRemoverVao10_1,
            valorRevestimentoParede11,valorRevestimentoParede11_1,valorRemocaoPiso11,valorRemocaoPiso11_1,valorRemocaoPia11,valorRemocaoPia11_1,valorRemocacAlvenaria11,valorRemocacAlvenaria11_1,valorRemocaoTanque11,valorRemocaoTanque11_1,valorRasgarCaixinha4x2_11,valorRasgarCaixinha4x2_11_1,valorRasgarCaixinha4x4_11,valorRasgarCaixinha4x4_11_1,valorRasgarHidraulica11,valorRasgarHidraulica11_1,valorRemoverGesso11,valorRemoverGesso11_1,valorRemoverVaso11,valorRemoverVaso11_1,valorRemoverVao11,valorRemoverVao11_1;




    private Button btn_finish;
    PermissionsChecker checker;
    Context mContext;
   // double varRemoverRevestimentoParede2,varRemoverRevestimentoParede3,varRemoverRevestimentoParede4,varRemoverRevestimentoParede5,varRemoverRevestimentoParede6,varRemoverRevestimentoParede7,varRemoverRevestimentoParede8,varRemoverRevestimentoParede9,varRemoverRevestimentoParede10,varRemoverRevestimentoParede11;
    double precoRemoverRevestimentoParede = 30.00;
    double precoRemoverPiso = 30.00;
    double precoRemoverAlvenaria = 60.00;
    double   precoRemoverPia = 72.00;
    double   precoRemoverTanque = 52.00 ;
    double   precoRasgarCaixinha4x2 = 50.40;
    double   precoRasgarCaixinha4x4 = 54.40;
    double   precoRemoverVasoSanitario = 68.00;
    double   precoRemoverVao = 120.00;
    double   precoRemoverHidraulica = 54.40;
    double   precoRemoverGesso = 30.00;
    public int numeroNotaAtual;
    int numNota;

    private TextView exibirNota;

    //Variaveis Cozinha
    private   double varRemoverRevestimentoParede = 0;
    private   double varRemoverRevestimentoParede1 = 0;
    private   double varRemoverRevestimentoParede2 = 0;
    private   double varRemoverRevestimentoParede2_1 = 0;
    private   double varRemoverRevestimentoParede3 = 0;
    private   double varRemoverRevestimentoParede3_1 = 0;
    private   double varRemoverRevestimentoParede4 = 0;
    private   double varRemoverRevestimentoParede4_1 = 0;
    private   double varRemoverRevestimentoParede5 = 0;
    private   double varRemoverRevestimentoParede5_1 = 0;
    private   double varRemoverRevestimentoParede6 = 0;
    private   double varRemoverRevestimentoParede6_1 = 0;
    private  double varRemoverPiso = 0;
    private  double varRemoverPiso1 = 0;
    private  double varRemoverPiso2 = 0;
    private  double varRemoverPiso2_1 = 0;
    private  double varRemoverPiso3 = 0;
    private  double varRemoverPiso3_1 = 0;
    private  double varRemoverPiso4 = 0;
    private  double varRemoverPiso4_1 = 0;
    private  double varRemoverPiso5 = 0;
    private  double varRemoverPiso5_1 = 0;
    private  double varRemoverPiso6 = 0;
    private  double varRemoverPiso6_1 = 0;
    private  double varRemoverPia = 0;
    private  double varRemoverPia1 = 0;
    private  double varRemoverPia2 = 0;
    private  double varRemoverPia2_1 = 0;
    private  double varRemoverPia3 = 0;
    private  double varRemoverPia3_1 = 0;
    private  double varRemoverPia4 = 0;
    private  double varRemoverPia4_1 = 0;
    private  double varRemoverPia5 = 0;
    private  double varRemoverPia5_1 = 0;
    private  double varRemoverPia6 = 0;
    private  double varRemoverPia6_1 = 0;
    private  double varRemoverAlvenaria =0;
    private   double varRemoverAlvenaria1 = 0;
    private   double varRemoverAlvenaria2 = 0;
    private   double varRemoverAlvenaria2_1 = 0;
    private   double varRemoverAlvenaria3 = 0;
    private   double varRemoverAlvenaria3_1 = 0;
    private   double varRemoverAlvenaria4 = 0;
    private   double varRemoverAlvenaria4_1 = 0;
    private   double varRemoverAlvenaria5 = 0;
    private   double varRemoverAlvenaria5_1 = 0;
    private   double varRemoverAlvenaria6 = 0;
    private   double varRemoverAlvenaria6_1 = 0;
    private   double varRemoverTanque = 0;
    private   double varRemoverTanque1 = 0;
    private   double varRemoverTanque2 = 0;
    private   double varRemoverTanque2_1 = 0;
    private   double varRemoverTanque3 = 0;
    private   double varRemoverTanque3_1 = 0;
    private   double varRemoverTanque4 = 0;
    private   double varRemoverTanque4_1 = 0;
    private   double varRemoverTanque5 = 0;
    private   double varRemoverTanque5_1 = 0;
    private   double varRemoverTanque6 = 0;
    private   double varRemoverTanque6_1 = 0;
    private   double  varRemoverCaixinha4x2 = 0;
    private   double  varRemoverCaixinha4x2_1 = 0;
    private   double  varRemoverCaixinha4x2_2 = 0;
    private   double  varRemoverCaixinha4x2_2_1 = 0;
    private   double  varRemoverCaixinha4x2_3 = 0;
    private   double  varRemoverCaixinha4x2_3_1 = 0;
    private   double  varRemoverCaixinha4x2_4 = 0;
    private   double  varRemoverCaixinha4x2_4_1 = 0;
    private   double  varRemoverCaixinha4x2_5 = 0;
    private   double  varRemoverCaixinha4x2_5_1 = 0;
    private   double  varRemoverCaixinha4x2_6 = 0;
    private   double  varRemoverCaixinha4x2_6_1 = 0;
    private   double  varRemoverCaixinha4x4 = 0;
    private   double  varRemoverCaixinha4x4_1 = 0;
    private   double  varRemoverCaixinha4x4_2 = 0;
    private   double  varRemoverCaixinha4x4_2_1 = 0;
    private   double  varRemoverCaixinha4x4_3 = 0;
    private   double  varRemoverCaixinha4x4_3_1 = 0;
    private   double  varRemoverCaixinha4x4_4 = 0;
    private   double  varRemoverCaixinha4x4_4_1 = 0;
    private   double  varRemoverCaixinha4x4_5 = 0;
    private   double  varRemoverCaixinha4x4_5_1 = 0;
    private   double  varRemoverCaixinha4x4_6 = 0;
    private   double  varRemoverCaixinha4x4_6_1 = 0;
    private   double  varRemoverHidraulica = 0;
    private   double  varRemoverHidraulica1 = 0;
    private   double  varRemoverHidraulica2 = 0;
    private   double  varRemoverHidraulica2_1 = 0;
    private   double  varRemoverHidraulica3 = 0;
    private   double  varRemoverHidraulica3_1 = 0;
    private   double  varRemoverHidraulica4 = 0;
    private   double  varRemoverHidraulica4_1 = 0;
    private   double  varRemoverHidraulica5 = 0;
    private   double  varRemoverHidraulica5_1 = 0;
    private   double  varRemoverHidraulica6 = 0;
    private   double  varRemoverHidraulica6_1 = 0;
    private   double  varRemoverGesso = 0;
    private   double  varRemoverGesso1 = 0;
    private   double  varRemoverGesso2 = 0;
    private   double  varRemoverGesso2_1 = 0;
    private   double  varRemoverGesso3 = 0;
    private   double  varRemoverGesso3_1 = 0;
    private   double  varRemoverGesso4 = 0;
    private   double  varRemoverGesso4_1 = 0;
    private   double  varRemoverGesso5 = 0;
    private   double  varRemoverGesso5_1 = 0;
    private   double  varRemoverGesso6 = 0;
    private   double  varRemoverGesso6_1 = 0;
    private   double varRemoverVasoSanitario = 0;
    private   double varRemoverVasoSanitario1 = 0;
    private   double varRemoverVasoSanitario2 = 0;
    private   double varRemoverVasoSanitario2_1 = 0;
    private   double varRemoverVasoSanitario3 = 0;
    private   double varRemoverVasoSanitario3_1 = 0;
    private   double varRemoverVasoSanitario4 = 0;
    private   double varRemoverVasoSanitario4_1 = 0;
    private   double varRemoverVasoSanitario5 = 0;
    private   double varRemoverVasoSanitario5_1 = 0;
    private   double varRemoverVasoSanitario6 = 0;
    private   double varRemoverVasoSanitario6_1 = 0;
    private   double  varRemoverVao = 0;
    private   double  varRemoverVao1 = 0;
    private   double  varRemoverVao2 = 0;
    private   double  varRemoverVao2_1 = 0;
    private   double  varRemoverVao3 = 0;
    private   double  varRemoverVao3_1 = 0;
    private   double  varRemoverVao4 = 0;
    private   double  varRemoverVao4_1 = 0;
    private   double  varRemoverVao5 = 0;
    private   double  varRemoverVao5_1 = 0;
    private   double  varRemoverVao6 = 0;
    private   double  varRemoverVao6_1 = 0;



    //Criacao do PDF
    private static final String TAG = "PdfCreatorActivity";
    final DecimalFormat decimalFormat = new DecimalFormat("0000");

    private File pdfFile;
    private String alterarNumeroNota;


    //
    private double valorTotalCozinha;
    private double valorTotalBanheiro1;
    private double valorTotalBanheiro2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demolicao);

        //Configurar Shared Preferences

        // use Shared preferences to save the best score
        SharedPreferences mypref = getPreferences(MODE_PRIVATE);
         numNota = mypref.getInt("numeroNota", 0001);
        exibirNota = findViewById(R.id.exibirNota);
        exibirNota.setText("000"+Integer.toString(numNota));



        mContext = getApplicationContext();


        checker = new PermissionsChecker(this);

        //Botao Gerar Relatorio
        btn_finish = findViewById(R.id.btnFinishDemolicao);
        relativeLayout = findViewById(R.id.layout_demolicao);

        //Fazendo cast/ instanciando os checklists aos seus respectivos views
        checkBoxCozinha = findViewById(R.id.checkbox_cozinha);
        checkBoxBanheiroSocial = findViewById(R.id.checkbox_banheiro_social);
        checkBoxBanheiroSuite = findViewById(R.id.checkbox_banheiro_suite);
        checkBoxAreaServico = findViewById(R.id.checkbox_areaservico);
        checkBoxLavabo = findViewById(R.id.checkbox_banheiro_lavabo);
        checkBoxSacadaVaranda = findViewById(R.id.checkbox_sacada);
        checkBoxSalaEstar = findViewById(R.id.checkbox_salaEstar);
        checkBoxSalaJantar = findViewById(R.id.checkbox_salaJantar);
        checkBoxQuarto1 = findViewById(R.id.checkbox_quarto1);
        checkBoxQuarto2 = findViewById(R.id.checkbox_quarto2);
        checkBoxQuartoSuite = findViewById(R.id.checkbox_quartoSuite);


        //Cast dos LinearLayouts
        linearLayout1 = findViewById(R.id.linearCozinha);
        linearLayout2 = findViewById(R.id.linearBanheiroSocial);
        linearLayout3 = findViewById(R.id.linearAreaServico);
        linearLayout4 = findViewById(R.id.linearBanheiroSuite);
        linearLayout5 = findViewById(R.id.linearLavabo);
        linearLayout6 = findViewById(R.id.linearSacada);
        linearLayout7 = findViewById(R.id.linearSalaJantar);
        linearLayout8 = findViewById(R.id.linearSalaEstar);
        linearLayout9 = findViewById(R.id.linearQuarto1);
        linearLayout10 = findViewById(R.id.linearQuarto2);
        linearLayout11 = findViewById(R.id.linearQuartoSuite);


        //Cast dos campos de valores


        //Revestimento Parede
        valorRevestimentoParede1 = findViewById(R.id.removerRevestimentoParede);
        valorRevestimentoParede1_1 = findViewById(R.id.removerRevestimentoParede1);
        valorRevestimentoParede2 = findViewById(R.id.removerRevestimentoParede2);
        valorRevestimentoParede2_1 = findViewById(R.id.removerRevestimentoParede2_1);
        valorRevestimentoParede3 = findViewById(R.id.removerRevestimentoParede3);
        valorRevestimentoParede3_1 = findViewById(R.id.removerRevestimentoParede3);
        valorRevestimentoParede4 = findViewById(R.id.removerRevestimentoParede4);
        valorRevestimentoParede4_1 = findViewById(R.id.removerRevestimentoParede4_1);
        valorRevestimentoParede5 = findViewById(R.id.removerRevestimentoParede5);
        valorRevestimentoParede5_1 = findViewById(R.id.removerRevestimentoParede5_1);
        valorRevestimentoParede6 = findViewById(R.id.removerRevestimentoParede6);
        valorRevestimentoParede6_1 = findViewById(R.id.removerRevestimentoParede6_1);
        valorRevestimentoParede7 = findViewById(R.id.removerRevestimentoParede7);
        valorRevestimentoParede7_1 = findViewById(R.id.removerRevestimentoParede7_1);
        valorRevestimentoParede8 = findViewById(R.id.removerRevestimentoParede8);
        valorRevestimentoParede8_1 = findViewById(R.id.removerRevestimentoParede8_1);
        valorRevestimentoParede9 = findViewById(R.id.removerRevestimentoParede9);
        valorRevestimentoParede9_1 = findViewById(R.id.removerRevestimentoParede9_1);
        valorRevestimentoParede10 = findViewById(R.id.removerRevestimentoParede10);
        valorRevestimentoParede10_1 = findViewById(R.id.removerRevestimentoParede10_1);
        valorRevestimentoParede11 = findViewById(R.id.removerRevestimentoParede11);
        valorRevestimentoParede11_1 = findViewById(R.id.removerRevestimentoParede11_1);

        //Remocao de Piso
        valorRemocaoPiso1 = findViewById(R.id.removerPiso);
        valorRemocaoPiso1_1 = findViewById(R.id.removerPiso1);
        valorRemocaoPiso2= findViewById(R.id.removerPiso2);
        valorRemocaoPiso2_1= findViewById(R.id.removerPiso2_1);
        valorRemocaoPiso3= findViewById(R.id.removerPiso3);
        valorRemocaoPiso3_1= findViewById(R.id.removerPiso3_2);
        valorRemocaoPiso4= findViewById(R.id.removerPiso4);
        valorRemocaoPiso4_1= findViewById(R.id.removerPiso4_1);
        valorRemocaoPiso5 = findViewById(R.id.removerPiso5);
        valorRemocaoPiso5_1 = findViewById(R.id.removerPiso5_1);
        valorRemocaoPiso6 = findViewById(R.id.removerPiso6);
        valorRemocaoPiso6_1 = findViewById(R.id.removerPiso6_1);
        valorRemocaoPiso7 = findViewById(R.id.removerPiso7);
        valorRemocaoPiso7_1 = findViewById(R.id.removerPiso7_1);
        valorRemocaoPiso8 = findViewById(R.id.removerPiso8);
        valorRemocaoPiso8_1 = findViewById(R.id.removerPiso8_1);
        valorRemocaoPiso9 = findViewById(R.id.removerPiso9);
        valorRemocaoPiso9_1 = findViewById(R.id.removerPiso9_1);
        valorRemocaoPiso10 = findViewById(R.id.removerPiso10);
        valorRemocaoPiso10_1 = findViewById(R.id.removerPiso10_1);
        valorRemocaoPiso11 = findViewById(R.id.removerPiso11);
        valorRemocaoPiso11_1 = findViewById(R.id.removerPiso11_1);

        //Remocao de Pia
        valorRemocaoPia1 = findViewById(R.id.removerPia);
        valorRemocaoPia1_1 = findViewById(R.id.removerPia1);
        valorRemocaoPia2 = findViewById(R.id.removerPia2);
        valorRemocaoPia2_1 = findViewById(R.id.removerPia2_1);
        valorRemocaoPia3 = findViewById(R.id.removerPia3);
        valorRemocaoPia3_1 = findViewById(R.id.removerPia3_1);
        valorRemocaoPia4 = findViewById(R.id.removerPia4);
        valorRemocaoPia4_1 = findViewById(R.id.removerPia4_1);
        valorRemocaoPia5 = findViewById(R.id.removerPia5);
        valorRemocaoPia5_1 = findViewById(R.id.removerPia5_1);
        valorRemocaoPia6 = findViewById(R.id.removerPia6);
        valorRemocaoPia6_1 = findViewById(R.id.removerPia6_1);
        valorRemocaoPia7 = findViewById(R.id.removerPia7);
        valorRemocaoPia7_1 = findViewById(R.id.removerPia7_1);
        valorRemocaoPia8 = findViewById(R.id.removerPia8);
        valorRemocaoPia8_1 = findViewById(R.id.removerPia8_1);
        valorRemocaoPia9 = findViewById(R.id.removerPia9);
        valorRemocaoPia9_1 = findViewById(R.id.removerPia9_1);
        valorRemocaoPia10 = findViewById(R.id.removerPia10);
        valorRemocaoPia10_1 = findViewById(R.id.removerPia10_1);
        valorRemocaoPia11 = findViewById(R.id.removerPia11);
        valorRemocaoPia11_1 = findViewById(R.id.removerPia11_1);

        //Remocao de Alvenaria
        valorRemocacAlvenaria1 = findViewById(R.id.removerAlvenaria);
        valorRemocacAlvenaria1_1 = findViewById(R.id.removerAlvenaria1);
        valorRemocacAlvenaria2 = findViewById(R.id.removerAlvenaria2);
        valorRemocacAlvenaria2_1 = findViewById(R.id.removerAlvenaria2_1);
        valorRemocacAlvenaria3 = findViewById(R.id.removerAlvenaria3);
        valorRemocacAlvenaria3_1 = findViewById(R.id.removerAlvenaria2_3);
        valorRemocacAlvenaria4 = findViewById(R.id.removerAlvenaria4);
        valorRemocacAlvenaria4_1 = findViewById(R.id.removerAlvenaria4_1);
        valorRemocacAlvenaria5 = findViewById(R.id.removerAlvenaria5);
        valorRemocacAlvenaria5_1 = findViewById(R.id.removerAlvenaria5_1);
        valorRemocacAlvenaria6 = findViewById(R.id.removerAlvenaria6);
        valorRemocacAlvenaria6_1 = findViewById(R.id.removerAlvenaria6_1);
        valorRemocacAlvenaria7 = findViewById(R.id.removerAlvenaria7);
        valorRemocacAlvenaria7_1 = findViewById(R.id.removerAlvenaria7_1);
        valorRemocacAlvenaria8 = findViewById(R.id.removerAlvenaria8);
        valorRemocacAlvenaria8_1 = findViewById(R.id.removerAlvenaria8_1);
        valorRemocacAlvenaria9 = findViewById(R.id.removerAlvenaria9);
        valorRemocacAlvenaria9_1 = findViewById(R.id.removerAlvenaria9_1);
        valorRemocacAlvenaria10 = findViewById(R.id.removerAlvenaria10);
        valorRemocacAlvenaria10_1 = findViewById(R.id.removerAlvenaria10_1);
        valorRemocacAlvenaria11 = findViewById(R.id.removerAlvenaria11);
        valorRemocacAlvenaria11_1 = findViewById(R.id.removerAlvenaria11_1);

        //Remover Tanque
        valorRemocaoTanque1 = findViewById(R.id.removerTanque);
        valorRemocaoTanque1_1 = findViewById(R.id.removerTanque1);
        valorRemocaoTanque2 = findViewById(R.id.removerTanque2);
        valorRemocaoTanque2_1 = findViewById(R.id.removerTanque2_1);
        valorRemocaoTanque3 = findViewById(R.id.removerTanque3);
        valorRemocaoTanque3_1 = findViewById(R.id.removerTanque2_3);
        valorRemocaoTanque4 = findViewById(R.id.removerTanque4);
        valorRemocaoTanque4_1 = findViewById(R.id.removerTanque4_1);
        valorRemocaoTanque5 = findViewById(R.id.removerTanque5);
        valorRemocaoTanque5_1 = findViewById(R.id.removerTanque5_1);
        valorRemocaoTanque6 = findViewById(R.id.removerTanque6);
        valorRemocaoTanque6_1 = findViewById(R.id.removerTanque6_1);
        valorRemocaoTanque7 = findViewById(R.id.removerTanque7);
        valorRemocaoTanque7_1 = findViewById(R.id.removerTanque7_1);
        valorRemocaoTanque8 = findViewById(R.id.removerTanque8);
        valorRemocaoTanque8_1 = findViewById(R.id.removerTanque8_1);
        valorRemocaoTanque9 = findViewById(R.id.removerTanque9);
        valorRemocaoTanque9_1 = findViewById(R.id.removerTanque9_1);
        valorRemocaoTanque10 = findViewById(R.id.removerTanque10);
        valorRemocaoTanque10_1 = findViewById(R.id.removerTanque10_1);
        valorRemocaoTanque11 = findViewById(R.id.removerTanque11);
        valorRemocaoTanque11_1 = findViewById(R.id.removerTanque11_1);

        //Rasgar Caixnha
        valorRasgarCaixinha4x2_1 = findViewById(R.id.rasgarCaixinha4x2);
        valorRasgarCaixinha4x2_1_1 = findViewById(R.id.rasgarCaixinha4x2_1);
        valorRasgarCaixinha4x2_2 = findViewById(R.id.rasgarCaixinha4x2_2);
        valorRasgarCaixinha4x2_2_1 = findViewById(R.id.rasgarCaixinha4x2_2_1);
        valorRasgarCaixinha4x2_3 = findViewById(R.id.rasgarCaixinha4x2_3);
        valorRasgarCaixinha4x2_3_1 = findViewById(R.id.rasgarCaixinha4x2_1);
        valorRasgarCaixinha4x2_4 = findViewById(R.id.rasgarCaixinha4x2_4);
        valorRasgarCaixinha4x2_4_1 = findViewById(R.id.rasgarCaixinha4x2_4_1);
        valorRasgarCaixinha4x2_5 = findViewById(R.id.rasgarCaixinha4x2_5);
        valorRasgarCaixinha4x2_5_1 = findViewById(R.id.rasgarCaixinha4x2_5_1);
        valorRasgarCaixinha4x2_6 = findViewById(R.id.rasgarCaixinha4x2_6);
        valorRasgarCaixinha4x2_6_1 = findViewById(R.id.rasgarCaixinha4x2_6_1);
        valorRasgarCaixinha4x2_7 = findViewById(R.id.rasgarCaixinha4x2_7);
        valorRasgarCaixinha4x2_7_1 = findViewById(R.id.rasgarCaixinha4x2_7_1);
        valorRasgarCaixinha4x2_8 = findViewById(R.id.rasgarCaixinha4x2_8);
        valorRasgarCaixinha4x2_8_1 = findViewById(R.id.rasgarCaixinha4x2_8_1);
        valorRasgarCaixinha4x2_9 = findViewById(R.id.rasgarCaixinha4x2_9);
        valorRasgarCaixinha4x2_9_1 = findViewById(R.id.rasgarCaixinha4x2_9_1);
        valorRasgarCaixinha4x2_10 = findViewById(R.id.rasgarCaixinha4x2_10);
        valorRasgarCaixinha4x2_10_1 = findViewById(R.id.rasgarCaixinha4x2_10_1);
        valorRasgarCaixinha4x2_11 = findViewById(R.id.rasgarCaixinha4x2_11);
        valorRasgarCaixinha4x2_11_1 = findViewById(R.id.rasgarCaixinha4x2_11_1);

        //Rasgar Caixinha 4x4

        valorRasgarCaixinha4x4_1 = findViewById(R.id.rasgarCaixinha4x4);
        valorRasgarCaixinha4x4_1_1 = findViewById(R.id.rasgarCaixinha4x4_1);
        valorRasgarCaixinha4x4_2 = findViewById(R.id.rasgarCaixinha4x4_2);
        valorRasgarCaixinha4x4_2_1 = findViewById(R.id.rasgarCaixinha4x4_2_1);
        valorRasgarCaixinha4x4_3 = findViewById(R.id.rasgarCaixinha4x4_3);
        valorRasgarCaixinha4x4_3_1 = findViewById(R.id.rasgarCaixinha4x4_3_1);
        valorRasgarCaixinha4x4_4 = findViewById(R.id.rasgarCaixinha4x4_4);
        valorRasgarCaixinha4x4_4_1 = findViewById(R.id.rasgarCaixinha4x4_4_1);
        valorRasgarCaixinha4x4_5 = findViewById(R.id.rasgarCaixinha4x4_5);
        valorRasgarCaixinha4x4_5_1 = findViewById(R.id.rasgarCaixinha4x4_5_1);
        valorRasgarCaixinha4x4_6 = findViewById(R.id.rasgarCaixinha4x4_6);
        valorRasgarCaixinha4x4_6_1 = findViewById(R.id.rasgarCaixinha4x4_6_1);
        valorRasgarCaixinha4x4_7 = findViewById(R.id.rasgarCaixinha4x4_7);
        valorRasgarCaixinha4x4_7_1 = findViewById(R.id.rasgarCaixinha4x4_7_1);
        valorRasgarCaixinha4x4_8 = findViewById(R.id.rasgarCaixinha4x4_8);
        valorRasgarCaixinha4x4_8_1 = findViewById(R.id.rasgarCaixinha4x4_8_1);
        valorRasgarCaixinha4x4_9 = findViewById(R.id.rasgarCaixinha4x4_9);
        valorRasgarCaixinha4x4_9_1 = findViewById(R.id.rasgarCaixinha4x4_9_1);
        valorRasgarCaixinha4x4_10 = findViewById(R.id.rasgarCaixinha4x4_10);
        valorRasgarCaixinha4x4_10_1 = findViewById(R.id.rasgarCaixinha4x4_10_1);
        valorRasgarCaixinha4x4_11 = findViewById(R.id.rasgarCaixinha4x4_11);
        valorRasgarCaixinha4x4_11_1 = findViewById(R.id.rasgarCaixinha4x4_11_1);

        //Rasgar Hidraulica
        valorRasgarHidraulica1 = findViewById(R.id.rasgarHidraulica);
        valorRasgarHidraulica1_1 = findViewById(R.id.rasgarHidraulica1);
        valorRasgarHidraulica2 = findViewById(R.id.rasgarHidraulica2);
        valorRasgarHidraulica2_1 = findViewById(R.id.rasgarHidraulica2_1);
        valorRasgarHidraulica3 = findViewById(R.id.rasgarHidraulica3);
        valorRasgarHidraulica3_1 = findViewById(R.id.rasgarHidraulica3_1);
        valorRasgarHidraulica4 = findViewById(R.id.rasgarHidraulica4);
        valorRasgarHidraulica4_1 = findViewById(R.id.rasgarHidraulica4_1);
        valorRasgarHidraulica5 = findViewById(R.id.rasgarHidraulica5);
        valorRasgarHidraulica5_1 = findViewById(R.id.rasgarHidraulica5_1);
        valorRasgarHidraulica6 = findViewById(R.id.rasgarHidraulica6);
        valorRasgarHidraulica6_1 = findViewById(R.id.rasgarHidraulica6_1);
        valorRasgarHidraulica7 = findViewById(R.id.rasgarHidraulica7);
        valorRasgarHidraulica7_1 = findViewById(R.id.rasgarHidraulica7_1);
        valorRasgarHidraulica8 = findViewById(R.id.rasgarHidraulica8);
        valorRasgarHidraulica8_1 = findViewById(R.id.rasgarHidraulica8_1);
        valorRasgarHidraulica9 = findViewById(R.id.rasgarHidraulica9);
        valorRasgarHidraulica9_1 = findViewById(R.id.rasgarHidraulica9_1);
        valorRasgarHidraulica10 = findViewById(R.id.rasgarHidraulica10);
        valorRasgarHidraulica10_1 = findViewById(R.id.rasgarHidraulica10_1);
        valorRasgarHidraulica11 = findViewById(R.id.rasgarHidraulica11);
        valorRasgarHidraulica11_1 = findViewById(R.id.rasgarHidraulica11_1);

        //Remocao Gesso

        valorRemoverGesso1 = findViewById(R.id.removerGesso);
        valorRemoverGesso1_1 = findViewById(R.id.removerGesso1);
        valorRemoverGesso2 = findViewById(R.id.removerGesso2);
        valorRemoverGesso2_1 = findViewById(R.id.removerGesso2_1);
        valorRemoverGesso3 = findViewById(R.id.removerGesso3);
        valorRemoverGesso3_1 = findViewById(R.id.removerGesso3_1);
        valorRemoverGesso4 = findViewById(R.id.removerGesso4);
        valorRemoverGesso4_1 = findViewById(R.id.removerGesso4_1);
        valorRemoverGesso5 = findViewById(R.id.removerGesso5);
        valorRemoverGesso5_1 = findViewById(R.id.removerGesso5_1);
        valorRemoverGesso6 = findViewById(R.id.removerGesso6);
        valorRemoverGesso6_1 = findViewById(R.id.removerGesso6_1);
        valorRemoverGesso7 = findViewById(R.id.removerGesso7);
        valorRemoverGesso7_1 = findViewById(R.id.removerGesso7_1);
        valorRemoverGesso8 = findViewById(R.id.removerGesso8);
        valorRemoverGesso8_1 = findViewById(R.id.removerGesso8_1);
        valorRemoverGesso9 = findViewById(R.id.removerGesso9);
        valorRemoverGesso9_1 = findViewById(R.id.removerGesso9_1);
        valorRemoverGesso10 = findViewById(R.id.removerGesso10);
        valorRemoverGesso10_1 = findViewById(R.id.removerGesso10_1);
        valorRemoverGesso11 = findViewById(R.id.removerGesso11);
        valorRemoverGesso11_1 = findViewById(R.id.removerGesso11_1);

        //Remocao Vaso Sanitario

        valorRemoverVaso1 = findViewById(R.id.removerVaso);
        valorRemoverVaso1_1 = findViewById(R.id.removerVaso1);
        valorRemoverVaso2 = findViewById(R.id.removerVaso2);
        valorRemoverVaso2_1 = findViewById(R.id.removerVaso2_1);
        valorRemoverVaso3 = findViewById(R.id.removerVaso3);
        valorRemoverVaso3_1 = findViewById(R.id.removerVaso3_1);
        valorRemoverVaso4 = findViewById(R.id.removerVaso4);
        valorRemoverVaso4_1 = findViewById(R.id.removerVaso4_1);
        valorRemoverVaso5 = findViewById(R.id.removerVaso5);
        valorRemoverVaso5_1 = findViewById(R.id.removerVaso5_1);
        valorRemoverVaso6 = findViewById(R.id.removerVaso6);
        valorRemoverVaso6_1 = findViewById(R.id.removerVaso6_1);
        valorRemoverVaso7 = findViewById(R.id.removerVaso7);
        valorRemoverVaso7_1 = findViewById(R.id.removerVaso7_1);
        valorRemoverVaso8 = findViewById(R.id.removerVaso8);
        valorRemoverVaso8_1 = findViewById(R.id.removerVaso8_1);
        valorRemoverVaso9 = findViewById(R.id.removerVaso9);
        valorRemoverVaso9_1 = findViewById(R.id.removerVaso9_1);
        valorRemoverVaso10 = findViewById(R.id.removerVaso10);
        valorRemoverVaso10_1 = findViewById(R.id.removerVaso10_1);
        valorRemoverVaso11 = findViewById(R.id.removerVaso11);
        valorRemoverVaso11_1 = findViewById(R.id.removerVaso11_1);

        //vao

        valorRemoverVao1 = findViewById(R.id.removerVao);
        valorRemoverVao1_1 = findViewById(R.id.removerVao1);
        valorRemoverVao2 = findViewById(R.id.removerVao2);
        valorRemoverVao2_1 = findViewById(R.id.removerVao2_1);
        valorRemoverVao3 = findViewById(R.id.removerVao3);
        valorRemoverVao3_1 = findViewById(R.id.removerVao3_1);
        valorRemoverVao4 = findViewById(R.id.removerVao4);
        valorRemoverVao4_1 = findViewById(R.id.removerVao4_1);
        valorRemoverVao5 = findViewById(R.id.removerVao5);
        valorRemoverVao5_1 = findViewById(R.id.removerVao5_1);
        valorRemoverVao6 = findViewById(R.id.removerVao6);
        valorRemoverVao6_1 = findViewById(R.id.removerVao6_1);
        valorRemoverVao7 = findViewById(R.id.removerVao7);
        valorRemoverVao7_1 = findViewById(R.id.removerVao7_1);
        valorRemoverVao8 = findViewById(R.id.removerVao8);
        valorRemoverVao8_1 = findViewById(R.id.removerVao8_1);
        valorRemoverVao9 = findViewById(R.id.removerVao9);
        valorRemoverVao9_1 = findViewById(R.id.removerVao9_1);
        valorRemoverVao10 = findViewById(R.id.removerVao10);
        valorRemoverVao10_1 = findViewById(R.id.removerVao10_1);
        valorRemoverVao11 = findViewById(R.id.removerVao11);
        valorRemoverVao11_1 = findViewById(R.id.removerVao11_1);







        //Exibir linear de acordo com a seleção do checkbox


        checkBoxCozinha.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    linearLayout1.setVisibility(View.VISIBLE);
                    checkBoxCozinha.setBackgroundColor(Color.parseColor("#1d1d1d"));

                    checkBoxCozinha.setTextColor(Color.parseColor("#ffffff"));

                    //Desativando os outros checkBox
                    checkBoxBanheiroSocial.setChecked(false);
                    checkBoxAreaServico.setChecked(false);
                    checkBoxBanheiroSuite.setChecked(false);
                    checkBoxLavabo.setChecked(false);
                    checkBoxQuarto1.setChecked(false);
                    checkBoxQuarto2.setChecked(false);
                    checkBoxQuartoSuite.setChecked(false);
                    checkBoxSacadaVaranda.setChecked(false);
                    checkBoxSalaEstar.setChecked(false);
                    checkBoxSalaJantar.setChecked(false);
                }else if (isChecked == false) {
                    linearLayout1.setVisibility(View.GONE);
                    checkBoxCozinha.setBackgroundResource(R.drawable.btn_servico1);

                }
            }});
        checkBoxBanheiroSocial.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    linearLayout2.setVisibility(View.VISIBLE);
                    checkBoxBanheiroSocial.setBackgroundColor(Color.parseColor("#1d1d1d"));

                    checkBoxBanheiroSocial.setTextColor(Color.parseColor("#ffffff"));



                    //Desativando os outros checkBox
                    checkBoxAreaServico.setChecked(false);
                    checkBoxBanheiroSuite.setChecked(false);
                    checkBoxLavabo.setChecked(false);
                    checkBoxQuarto1.setChecked(false);
                    checkBoxQuarto2.setChecked(false);
                    checkBoxQuartoSuite.setChecked(false);
                    checkBoxSacadaVaranda.setChecked(false);
                    checkBoxSalaEstar.setChecked(false);
                    checkBoxSalaJantar.setChecked(false);
                    checkBoxCozinha.setChecked(false);
                }else if (isChecked == false) {
                    linearLayout2.setVisibility(View.GONE);
                    checkBoxBanheiroSocial.setBackgroundResource(R.drawable.btn_servico1);

                }
            }});
        checkBoxAreaServico.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    linearLayout3.setVisibility(View.VISIBLE);
                    checkBoxAreaServico.setBackgroundColor(Color.parseColor("#1d1d1d"));

                    checkBoxAreaServico.setTextColor(Color.parseColor("#ffffff"));



                    //Desativando os outros checkBox
                    checkBoxBanheiroSocial.setChecked(false);
                    checkBoxBanheiroSuite.setChecked(false);
                    checkBoxLavabo.setChecked(false);
                    checkBoxQuarto1.setChecked(false);
                    checkBoxQuarto2.setChecked(false);
                    checkBoxQuartoSuite.setChecked(false);
                    checkBoxSacadaVaranda.setChecked(false);
                    checkBoxSalaEstar.setChecked(false);
                    checkBoxSalaJantar.setChecked(false);
                    checkBoxCozinha.setChecked(false);
                }else if (isChecked == false) {
                    linearLayout3.setVisibility(View.GONE);
                    checkBoxAreaServico.setBackgroundResource(R.drawable.btn_servico1);

                }
            }});
        checkBoxBanheiroSuite.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    linearLayout4.setVisibility(View.VISIBLE);
                    checkBoxBanheiroSuite.setBackgroundColor(Color.parseColor("#1d1d1d"));

                    checkBoxBanheiroSuite.setTextColor(Color.parseColor("#ffffff"));



                    //Desativando os outros checkBox
                    checkBoxBanheiroSocial.setChecked(false);
                    checkBoxAreaServico.setChecked(false);
                    checkBoxLavabo.setChecked(false);
                    checkBoxQuarto1.setChecked(false);
                    checkBoxQuarto2.setChecked(false);
                    checkBoxQuartoSuite.setChecked(false);
                    checkBoxSacadaVaranda.setChecked(false);
                    checkBoxSalaEstar.setChecked(false);
                    checkBoxSalaJantar.setChecked(false);
                    checkBoxCozinha.setChecked(false);
                }else if (isChecked == false) {
                    linearLayout4.setVisibility(View.GONE);
                    checkBoxBanheiroSuite.setBackgroundResource(R.drawable.btn_servico1);

                }
            }});

        checkBoxLavabo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    linearLayout5.setVisibility(View.VISIBLE);
                    checkBoxLavabo.setBackgroundColor(Color.parseColor("#1d1d1d"));

                    checkBoxLavabo.setTextColor(Color.parseColor("#ffffff"));



                    //Desativando os outros checkBox
                    checkBoxBanheiroSocial.setChecked(false);
                    checkBoxBanheiroSuite.setChecked(false);
                    checkBoxAreaServico.setChecked(false);
                    checkBoxQuarto1.setChecked(false);
                    checkBoxQuarto2.setChecked(false);
                    checkBoxQuartoSuite.setChecked(false);
                    checkBoxSacadaVaranda.setChecked(false);
                    checkBoxSalaEstar.setChecked(false);
                    checkBoxSalaJantar.setChecked(false);
                    checkBoxCozinha.setChecked(false);
                }else if (isChecked == false) {
                    linearLayout5.setVisibility(View.GONE);
                    checkBoxLavabo.setBackgroundResource(R.drawable.btn_servico1);

                }
            }});
        checkBoxSacadaVaranda.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    linearLayout6.setVisibility(View.VISIBLE);
                    checkBoxSacadaVaranda.setBackgroundColor(Color.parseColor("#1d1d1d"));

                    checkBoxSacadaVaranda.setTextColor(Color.parseColor("#ffffff"));



                    //Desativando os outros checkBox
                    checkBoxBanheiroSocial.setChecked(false);
                    checkBoxBanheiroSuite.setChecked(false);
                    checkBoxAreaServico.setChecked(false);
                    checkBoxQuarto1.setChecked(false);
                    checkBoxQuarto2.setChecked(false);
                    checkBoxQuartoSuite.setChecked(false);
                    checkBoxLavabo.setChecked(false);
                    checkBoxSalaEstar.setChecked(false);
                    checkBoxSalaJantar.setChecked(false);
                    checkBoxCozinha.setChecked(false);
                }else if (isChecked == false) {
                    linearLayout6.setVisibility(View.GONE);
                    checkBoxSacadaVaranda.setBackgroundResource(R.drawable.btn_servico1);

                }
            }});

        checkBoxSalaJantar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    linearLayout7.setVisibility(View.VISIBLE);
                    checkBoxSalaJantar.setBackgroundColor(Color.parseColor("#1d1d1d"));

                    checkBoxSalaJantar.setTextColor(Color.parseColor("#ffffff"));



                    //Desativando os outros checkBox
                    checkBoxBanheiroSocial.setChecked(false);
                    checkBoxBanheiroSuite.setChecked(false);
                    checkBoxAreaServico.setChecked(false);
                    checkBoxQuarto1.setChecked(false);
                    checkBoxQuarto2.setChecked(false);
                    checkBoxQuartoSuite.setChecked(false);
                    checkBoxLavabo.setChecked(false);
                    checkBoxSalaEstar.setChecked(false);
                    checkBoxSacadaVaranda.setChecked(false);
                    checkBoxCozinha.setChecked(false);
                }else if (isChecked == false) {
                    linearLayout7.setVisibility(View.GONE);
                    checkBoxSalaJantar.setBackgroundResource(R.drawable.btn_servico1);

                }
            }});

        checkBoxSalaEstar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    linearLayout8.setVisibility(View.VISIBLE);
                    checkBoxSalaEstar.setBackgroundColor(Color.parseColor("#1d1d1d"));

                    checkBoxSalaEstar.setTextColor(Color.parseColor("#ffffff"));



                    //Desativando os outros checkBox
                    checkBoxBanheiroSocial.setChecked(false);
                    checkBoxBanheiroSuite.setChecked(false);
                    checkBoxAreaServico.setChecked(false);
                    checkBoxQuarto1.setChecked(false);
                    checkBoxQuarto2.setChecked(false);
                    checkBoxQuartoSuite.setChecked(false);
                    checkBoxLavabo.setChecked(false);
                    checkBoxSalaJantar.setChecked(false);
                    checkBoxSacadaVaranda.setChecked(false);
                    checkBoxCozinha.setChecked(false);
                }else if (isChecked == false) {
                    linearLayout8.setVisibility(View.GONE);
                    checkBoxSalaEstar.setBackgroundResource(R.drawable.btn_servico1);

                }
            }});

        checkBoxQuartoSuite.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    linearLayout9.setVisibility(View.VISIBLE);
                    checkBoxQuartoSuite.setBackgroundColor(Color.parseColor("#1d1d1d"));

                    checkBoxQuartoSuite.setTextColor(Color.parseColor("#ffffff"));



                    //Desativando os outros checkBox
                    checkBoxBanheiroSocial.setChecked(false);
                    checkBoxBanheiroSuite.setChecked(false);
                    checkBoxAreaServico.setChecked(false);
                    checkBoxQuarto1.setChecked(false);
                    checkBoxQuarto2.setChecked(false);
                    checkBoxSalaEstar.setChecked(false);
                    checkBoxLavabo.setChecked(false);
                    checkBoxSalaJantar.setChecked(false);
                    checkBoxSacadaVaranda.setChecked(false);
                    checkBoxCozinha.setChecked(false);
                }else if (isChecked == false) {
                    linearLayout9.setVisibility(View.GONE);
                    checkBoxQuartoSuite.setBackgroundResource(R.drawable.btn_servico1);

                }
            }});

     checkBoxQuarto1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    linearLayout10.setVisibility(View.VISIBLE);
                    checkBoxQuarto1.setBackgroundColor(Color.parseColor("#1d1d1d"));

                    checkBoxQuarto1.setTextColor(Color.parseColor("#ffffff"));



                    //Desativando os outros checkBox
                    checkBoxBanheiroSocial.setChecked(false);
                    checkBoxBanheiroSuite.setChecked(false);
                    checkBoxAreaServico.setChecked(false);
                    checkBoxQuartoSuite.setChecked(false);
                    checkBoxQuarto2.setChecked(false);
                    checkBoxSalaEstar.setChecked(false);
                    checkBoxLavabo.setChecked(false);
                    checkBoxSalaJantar.setChecked(false);
                    checkBoxSacadaVaranda.setChecked(false);
                    checkBoxCozinha.setChecked(false);
                }else if (isChecked == false) {
                    linearLayout10.setVisibility(View.GONE);
                    checkBoxQuarto1.setBackgroundResource(R.drawable.btn_servico1);

                }
            }});

     checkBoxQuarto2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    linearLayout11.setVisibility(View.VISIBLE);
                    checkBoxQuarto2.setBackgroundColor(Color.parseColor("#1d1d1d"));

                    checkBoxQuarto2.setTextColor(Color.parseColor("#ffffff"));



                    //Desativando os outros checkBox
                    checkBoxBanheiroSocial.setChecked(false);
                    checkBoxBanheiroSuite.setChecked(false);
                    checkBoxAreaServico.setChecked(false);
                    checkBoxQuartoSuite.setChecked(false);
                    checkBoxQuarto1.setChecked(false);
                    checkBoxSalaEstar.setChecked(false);
                    checkBoxLavabo.setChecked(false);
                    checkBoxSalaJantar.setChecked(false);
                    checkBoxSacadaVaranda.setChecked(false);
                    checkBoxCozinha.setChecked(false);
                }else if (isChecked == false) {
                    linearLayout11.setVisibility(View.GONE);
                    checkBoxQuarto2.setBackgroundResource(R.drawable.btn_servico1);

                }
            }});




        btn_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

// Criando PDF



                //Preparando o local

                //Calculando Valores Cozinha

                 varRemoverRevestimentoParede = Double.parseDouble(valorRevestimentoParede1.getText().toString()) * precoRemoverRevestimentoParede;
                 varRemoverRevestimentoParede1 = Double.parseDouble(valorRevestimentoParede1_1.getText().toString()) * precoRemoverRevestimentoParede;
                 varRemoverPiso = Double.parseDouble(valorRemocaoPiso1.getText().toString()) * precoRemoverPiso;
                 varRemoverPiso1 = Double.parseDouble(valorRemocaoPiso1_1.getText().toString()) * precoRemoverPiso;
                 varRemoverPia = Integer.parseInt(valorRemocaoPia1.getText().toString()) * precoRemoverPia;
                 varRemoverPia1 = Integer.parseInt(valorRemocaoPia1_1.getText().toString()) * precoRemoverPia;
                 varRemoverAlvenaria = Double.parseDouble(valorRemocacAlvenaria1.getText().toString()) * precoRemoverAlvenaria;
                 varRemoverAlvenaria1 = Double.parseDouble(valorRemocacAlvenaria1_1.getText().toString()) * precoRemoverAlvenaria;
                 varRemoverTanque = Integer.parseInt(valorRemocaoTanque1.getText().toString()) * precoRemoverTanque;
                 varRemoverTanque1 = Integer.parseInt(valorRemocaoTanque1_1.getText().toString()) * precoRemoverTanque;
                  varRemoverCaixinha4x2 = Integer.parseInt(valorRasgarCaixinha4x2_1.getText().toString()) * precoRasgarCaixinha4x2;
                  varRemoverCaixinha4x2_1 = Integer.parseInt(valorRasgarCaixinha4x2_1_1.getText().toString()) * precoRasgarCaixinha4x2;
                  varRemoverCaixinha4x4 = Integer.parseInt(valorRasgarCaixinha4x4_1.getText().toString()) * precoRasgarCaixinha4x4;
                  varRemoverCaixinha4x4_1 = Integer.parseInt(valorRasgarCaixinha4x4_1_1.getText().toString()) * precoRasgarCaixinha4x4;
                  varRemoverHidraulica = Integer.parseInt(valorRasgarHidraulica1.getText().toString()) * precoRemoverHidraulica;
                  varRemoverHidraulica1 = Integer.parseInt(valorRasgarHidraulica1_1.getText().toString()) * precoRemoverHidraulica;
                  varRemoverGesso = Integer.parseInt(valorRemoverGesso1.getText().toString()) * precoRemoverGesso;
                  varRemoverGesso1 = Integer.parseInt(valorRemoverGesso1_1.getText().toString()) * precoRemoverGesso;
                 varRemoverVasoSanitario = Integer.parseInt(valorRemoverVaso1.getText().toString()) * precoRemoverVasoSanitario;
                 varRemoverVasoSanitario1 = Integer.parseInt(valorRemoverVaso1_1.getText().toString()) * precoRemoverVasoSanitario;
                  varRemoverVao = Integer.parseInt(valorRemoverVao1.getText().toString()) * precoRemoverVao;
                  varRemoverVao1 = Integer.parseInt(valorRemoverVao1_1.getText().toString()) * precoRemoverVao;

               valorTotalCozinha = varRemoverRevestimentoParede + varRemoverRevestimentoParede1 +  varRemoverPiso + varRemoverPiso1 + varRemoverPia + varRemoverPia1 + varRemoverAlvenaria + varRemoverAlvenaria1 + varRemoverTanque + varRemoverTanque1 + varRemoverCaixinha4x2 + varRemoverCaixinha4x2_1 + varRemoverCaixinha4x4 + varRemoverCaixinha4x4_1 + varRemoverHidraulica + varRemoverHidraulica1 + varRemoverGesso + varRemoverGesso1 + varRemoverVasoSanitario + varRemoverVasoSanitario1 + varRemoverVao + varRemoverVao1;

                //Calculando Valores Banheiro 1

                 varRemoverRevestimentoParede2 = Double.parseDouble(valorRevestimentoParede2.getText().toString()) * precoRemoverRevestimentoParede;
                 varRemoverRevestimentoParede2_1 = Double.parseDouble(valorRevestimentoParede2_1.getText().toString()) * precoRemoverRevestimentoParede;
                 varRemoverPiso2 = Double.parseDouble(valorRemocaoPiso2.getText().toString()) * precoRemoverPiso;
                 varRemoverPiso2_1 = Double.parseDouble(valorRemocaoPiso2_1.getText().toString()) * precoRemoverPiso;
                 varRemoverPia2 = Integer.parseInt(valorRemocaoPia2.getText().toString()) * precoRemoverPia;
                 varRemoverPia2_1 = Integer.parseInt(valorRemocaoPia2_1.getText().toString()) * precoRemoverPia;
                 varRemoverAlvenaria2 = Double.parseDouble(valorRemocacAlvenaria2.getText().toString()) * precoRemoverAlvenaria;
                 varRemoverAlvenaria2_1 = Double.parseDouble(valorRemocacAlvenaria2_1.getText().toString()) * precoRemoverAlvenaria;
                 varRemoverTanque2 = Integer.parseInt(valorRemocaoTanque2.getText().toString()) * precoRemoverTanque;
                 varRemoverTanque2_1 = Integer.parseInt(valorRemocaoTanque2_1.getText().toString()) * precoRemoverTanque;
                  varRemoverCaixinha4x2_2 = Integer.parseInt(valorRasgarCaixinha4x2_2.getText().toString()) * precoRasgarCaixinha4x2;
                  varRemoverCaixinha4x2_2_1 = Integer.parseInt(valorRasgarCaixinha4x2_2_1.getText().toString()) * precoRasgarCaixinha4x2;
                  varRemoverCaixinha4x4_2 = Integer.parseInt(valorRasgarCaixinha4x4_2.getText().toString()) * precoRasgarCaixinha4x4;
                  varRemoverCaixinha4x4_2_1 = Integer.parseInt(valorRasgarCaixinha4x4_2_1.getText().toString()) * precoRasgarCaixinha4x4;
                  varRemoverHidraulica2 = Integer.parseInt(valorRasgarHidraulica2.getText().toString()) * precoRemoverHidraulica;
                  varRemoverHidraulica2_1 = Integer.parseInt(valorRasgarHidraulica2_1.getText().toString()) * precoRemoverHidraulica;
                  varRemoverGesso2 = Integer.parseInt(valorRemoverGesso2.getText().toString()) * precoRemoverGesso;
                  varRemoverGesso2_1 = Integer.parseInt(valorRemoverGesso2_1.getText().toString()) * precoRemoverGesso;
                 varRemoverVasoSanitario2 = Integer.parseInt(valorRemoverVaso2.getText().toString()) * precoRemoverVasoSanitario;
                 varRemoverVasoSanitario2_1 = Integer.parseInt(valorRemoverVaso2_1.getText().toString()) * precoRemoverVasoSanitario;
                  varRemoverVao2 = Integer.parseInt(valorRemoverVao2.getText().toString()) * precoRemoverVao;
                  varRemoverVao2_1 = Integer.parseInt(valorRemoverVao2_1.getText().toString()) * precoRemoverVao;

                 valorTotalBanheiro1 = varRemoverRevestimentoParede2 + varRemoverRevestimentoParede2_1 +  varRemoverPiso2 + varRemoverPiso2_1 + varRemoverPia2 + varRemoverPia2_1 + varRemoverAlvenaria2 + varRemoverAlvenaria2_1 + varRemoverTanque2 + varRemoverTanque2 + varRemoverCaixinha4x2_2 + varRemoverCaixinha4x2_2_1 + varRemoverCaixinha4x2_2 + varRemoverCaixinha4x4_2_1 + varRemoverHidraulica2 + varRemoverHidraulica2_1 + varRemoverGesso2 + varRemoverGesso2_1 + varRemoverVasoSanitario2 + varRemoverVasoSanitario2_1 + varRemoverVao2 + varRemoverVao2_1;



                //Calculando Valores Aréa de Serviço

                double varRemoverRevestimentoParede3 = Double.parseDouble(valorRevestimentoParede3.getText().toString()) * precoRemoverRevestimentoParede;
                double varRemoverRevestimentoParede3_1 = Double.parseDouble(valorRevestimentoParede3_1.getText().toString()) * precoRemoverRevestimentoParede;
                double varRemoverPiso3 = Double.parseDouble(valorRemocaoPiso3.getText().toString()) * precoRemoverPiso;
                double varRemoverPiso3_1 = Double.parseDouble(valorRemocaoPiso3_1.getText().toString()) * precoRemoverPiso;
                double varRemoverPia3 = Integer.parseInt(valorRemocaoPia3.getText().toString()) * precoRemoverPia;
                double varRemoverPia3_1 = Integer.parseInt(valorRemocaoPia3_1.getText().toString()) * precoRemoverPia;
                double varRemoverAlvenaria3 = Double.parseDouble(valorRemocacAlvenaria3.getText().toString()) * precoRemoverAlvenaria;
                double varRemoverAlvenaria3_1 = Double.parseDouble(valorRemocacAlvenaria3_1.getText().toString()) * precoRemoverAlvenaria;
                double varRemoverTanque3 = Integer.parseInt(valorRemocaoTanque3.getText().toString()) * precoRemoverTanque;
                double varRemoverTanque3_1 = Integer.parseInt(valorRemocaoTanque3_1.getText().toString()) * precoRemoverTanque;
                double  varRemoverCaixinha4x2_3 = Integer.parseInt(valorRasgarCaixinha4x2_3.getText().toString()) * precoRasgarCaixinha4x2;
                double  varRemoverCaixinha4x2_3_1 = Integer.parseInt(valorRasgarCaixinha4x2_3_1.getText().toString()) * precoRasgarCaixinha4x2;
                double  varRemoverCaixinha4x4_3 = Integer.parseInt(valorRasgarCaixinha4x4_3.getText().toString()) * precoRasgarCaixinha4x4;
                double  varRemoverCaixinha4x4_3_1 = Integer.parseInt(valorRasgarCaixinha4x4_3_1.getText().toString()) * precoRasgarCaixinha4x4;
                double  varRemoverHidraulica3 = Integer.parseInt(valorRasgarHidraulica3.getText().toString()) * precoRemoverHidraulica;
                double  varRemoverHidraulica3_1 = Integer.parseInt(valorRasgarHidraulica3_1.getText().toString()) * precoRemoverHidraulica;
                double  varRemoverGesso3 = Integer.parseInt(valorRemoverGesso3.getText().toString()) * precoRemoverGesso;
                double  varRemoverGesso3_1 = Integer.parseInt(valorRemoverGesso3_1.getText().toString()) * precoRemoverGesso;
                double varRemoverVasoSanitario3 = Integer.parseInt(valorRemoverVaso3.getText().toString()) * precoRemoverVasoSanitario;
                double varRemoverVasoSanitario3_1 = Integer.parseInt(valorRemoverVaso3_1.getText().toString()) * precoRemoverVasoSanitario;
                double  varRemoverVao3 = Integer.parseInt(valorRemoverVao3.getText().toString()) * precoRemoverVao;
                double  varRemoverVao3_1 = Integer.parseInt(valorRemoverVao3_1.getText().toString()) * precoRemoverVao;


                double valorTotalAreaServico = varRemoverRevestimentoParede3 + varRemoverRevestimentoParede3_1 +  varRemoverPiso3 + varRemoverPiso3_1 + varRemoverPia3 + varRemoverPia3_1 + varRemoverAlvenaria3 + varRemoverAlvenaria3_1 + varRemoverTanque3 + varRemoverTanque3_1 + varRemoverCaixinha4x2_3 + varRemoverCaixinha4x2_3_1 + varRemoverCaixinha4x4_3 + varRemoverCaixinha4x4_3_1 + varRemoverHidraulica3 + varRemoverHidraulica3_1 + varRemoverGesso3 + varRemoverGesso3_1 + varRemoverVasoSanitario3 + varRemoverVasoSanitario3_1 + varRemoverVao3 + varRemoverVao3_1;


                //Calculando Valores Banheiro 2

                double varRemoverRevestimentoParede4 = Double.parseDouble(valorRevestimentoParede4.getText().toString()) * precoRemoverRevestimentoParede;
                double varRemoverRevestimentoParede4_1 = Double.parseDouble(valorRevestimentoParede4_1.getText().toString()) * precoRemoverRevestimentoParede;
                double varRemoverPiso4 = Double.parseDouble(valorRemocaoPiso4.getText().toString()) * precoRemoverPiso;
                double varRemoverPiso4_1 = Double.parseDouble(valorRemocaoPiso4_1.getText().toString()) * precoRemoverPiso;
                double varRemoverPia4 = Integer.parseInt(valorRemocaoPia4.getText().toString()) * precoRemoverPia;
                double varRemoverPia4_1 = Integer.parseInt(valorRemocaoPia4_1.getText().toString()) * precoRemoverPia;
                double varRemoverAlvenaria4 = Double.parseDouble(valorRemocacAlvenaria4.getText().toString()) * precoRemoverAlvenaria;
                double varRemoverAlvenaria4_1 = Double.parseDouble(valorRemocacAlvenaria4_1.getText().toString()) * precoRemoverAlvenaria;
                double varRemoverTanque4 = Integer.parseInt(valorRemocaoTanque4.getText().toString()) * precoRemoverTanque;
                double varRemoverTanque4_1 = Integer.parseInt(valorRemocaoTanque4_1.getText().toString()) * precoRemoverTanque;
                double  varRemoverCaixinha4x2_4 = Integer.parseInt(valorRasgarCaixinha4x2_4.getText().toString()) * precoRasgarCaixinha4x2;
                double  varRemoverCaixinha4x2_4_1 = Integer.parseInt(valorRasgarCaixinha4x2_4_1.getText().toString()) * precoRasgarCaixinha4x2;
                double  varRemoverCaixinha4x4_4 = Integer.parseInt(valorRasgarCaixinha4x4_4.getText().toString()) * precoRasgarCaixinha4x4;
                double  varRemoverCaixinha4x4_4_1 = Integer.parseInt(valorRasgarCaixinha4x4_4_1.getText().toString()) * precoRasgarCaixinha4x4;
                double  varRemoverHidraulica4 = Integer.parseInt(valorRasgarHidraulica4.getText().toString()) * precoRemoverHidraulica;
                double  varRemoverHidraulica4_1 = Integer.parseInt(valorRasgarHidraulica4_1.getText().toString()) * precoRemoverHidraulica;
                double  varRemoverGesso4 = Integer.parseInt(valorRemoverGesso4.getText().toString()) * precoRemoverGesso;
                double  varRemoverGesso4_1 = Integer.parseInt(valorRemoverGesso4_1.getText().toString()) * precoRemoverGesso;
                double varRemoverVasoSanitario4 = Integer.parseInt(valorRemoverVaso4.getText().toString()) * precoRemoverVasoSanitario;
                double varRemoverVasoSanitario4_1 = Integer.parseInt(valorRemoverVaso4_1.getText().toString()) * precoRemoverVasoSanitario;
                double  varRemoverVao4 = Integer.parseInt(valorRemoverVao4.getText().toString()) * precoRemoverVao;
                double  varRemoverVao4_1 = Integer.parseInt(valorRemoverVao4_1.getText().toString()) * precoRemoverVao;


               valorTotalBanheiro2 = varRemoverRevestimentoParede4 + varRemoverRevestimentoParede4_1 +  varRemoverPiso4 + varRemoverPiso4_1 + varRemoverPia4 + varRemoverPia4_1 + varRemoverAlvenaria4 + varRemoverAlvenaria4_1 + varRemoverTanque4 + varRemoverTanque4_1 + varRemoverCaixinha4x2_4 + varRemoverCaixinha4x2_4_1 + varRemoverCaixinha4x4_4 + varRemoverCaixinha4x4_4_1 + varRemoverHidraulica4 + varRemoverHidraulica4_1 + varRemoverGesso4 + varRemoverGesso4_1 + varRemoverVasoSanitario4 + varRemoverVasoSanitario4_1 + varRemoverVao4 + varRemoverVao4_1;


                //Calculando Valores Lavabo

                double varRemoverRevestimentoParede5 = Double.parseDouble(valorRevestimentoParede5.getText().toString()) * precoRemoverRevestimentoParede;
                double varRemoverRevestimentoParede5_1 = Double.parseDouble(valorRevestimentoParede5_1.getText().toString()) * precoRemoverRevestimentoParede;
                double varRemoverPiso5 = Double.parseDouble(valorRemocaoPiso5.getText().toString()) * precoRemoverPiso;
                double varRemoverPiso5_1 = Double.parseDouble(valorRemocaoPiso5_1.getText().toString()) * precoRemoverPiso;
                double varRemoverPia5 = Integer.parseInt(valorRemocaoPia5.getText().toString()) * precoRemoverPia;
                double varRemoverPia5_1 = Integer.parseInt(valorRemocaoPia5_1.getText().toString()) * precoRemoverPia;
                double varRemoverAlvenaria5 = Double.parseDouble(valorRemocacAlvenaria5.getText().toString()) * precoRemoverAlvenaria;
                double varRemoverAlvenaria5_1 = Double.parseDouble(valorRemocacAlvenaria5_1.getText().toString()) * precoRemoverAlvenaria;
                double varRemoverTanque5 = Integer.parseInt(valorRemocaoTanque5.getText().toString()) * precoRemoverTanque;
                double varRemoverTanque5_1 = Integer.parseInt(valorRemocaoTanque5_1.getText().toString()) * precoRemoverTanque;
                double  varRemoverCaixinha4x2_5 = Integer.parseInt(valorRasgarCaixinha4x2_5.getText().toString()) * precoRasgarCaixinha4x2;
                double  varRemoverCaixinha4x2_5_1 = Integer.parseInt(valorRasgarCaixinha4x2_5_1.getText().toString()) * precoRasgarCaixinha4x2;
                double  varRemoverCaixinha4x4_5 = Integer.parseInt(valorRasgarCaixinha4x4_5.getText().toString()) * precoRasgarCaixinha4x4;
                double  varRemoverCaixinha4x4_5_1 = Integer.parseInt(valorRasgarCaixinha4x4_5_1.getText().toString()) * precoRasgarCaixinha4x4;
                double  varRemoverHidraulica5 = Integer.parseInt(valorRasgarHidraulica5.getText().toString()) * precoRemoverHidraulica;
                double  varRemoverHidraulica5_1 = Integer.parseInt(valorRasgarHidraulica5_1.getText().toString()) * precoRemoverHidraulica;
                double  varRemoverGesso5 = Integer.parseInt(valorRemoverGesso5.getText().toString()) * precoRemoverGesso;
                double  varRemoverGesso5_1 = Integer.parseInt(valorRemoverGesso5_1.getText().toString()) * precoRemoverGesso;
                double varRemoverVasoSanitario5 = Integer.parseInt(valorRemoverVaso5.getText().toString()) * precoRemoverVasoSanitario;
                double varRemoverVasoSanitario5_1 = Integer.parseInt(valorRemoverVaso5_1.getText().toString()) * precoRemoverVasoSanitario;
                double  varRemoverVao5 = Integer.parseInt(valorRemoverVao5.getText().toString()) * precoRemoverVao;
                double  varRemoverVao5_1 = Integer.parseInt(valorRemoverVao5_1.getText().toString()) * precoRemoverVao;


                double valorTotalLavabo = varRemoverRevestimentoParede5 + varRemoverRevestimentoParede5_1 +  varRemoverPiso5 + varRemoverPiso5_1 + varRemoverPia5 + varRemoverPia5_1 + varRemoverAlvenaria5 + varRemoverAlvenaria5_1 + varRemoverTanque5 + varRemoverTanque5_1 + varRemoverCaixinha4x2_5 + varRemoverCaixinha4x2_5_1 + varRemoverCaixinha4x4_5 + varRemoverCaixinha4x4_5_1 + varRemoverHidraulica5 + varRemoverHidraulica5_1 + varRemoverGesso5 + varRemoverGesso5_1 + varRemoverVasoSanitario5 + varRemoverVasoSanitario5_1 + varRemoverVao5 + varRemoverVao5_1;

                //Calculando Valores Sacada Varanda

                double varRemoverRevestimentoParede6 = Double.parseDouble(valorRevestimentoParede6.getText().toString()) * precoRemoverRevestimentoParede;
                double varRemoverRevestimentoParede6_1 = Double.parseDouble(valorRevestimentoParede6_1.getText().toString()) * precoRemoverRevestimentoParede;
                double varRemoverPiso6 = Double.parseDouble(valorRemocaoPiso6.getText().toString()) * precoRemoverPiso;
                double varRemoverPiso6_1 = Double.parseDouble(valorRemocaoPiso6_1.getText().toString()) * precoRemoverPiso;
                double varRemoverPia6 = Integer.parseInt(valorRemocaoPia6.getText().toString()) * precoRemoverPia;
                double varRemoverPia6_1 = Integer.parseInt(valorRemocaoPia6_1.getText().toString()) * precoRemoverPia;
                double varRemoverAlvenaria6 = Double.parseDouble(valorRemocacAlvenaria6.getText().toString()) * precoRemoverAlvenaria;
                double varRemoverAlvenaria6_1 = Double.parseDouble(valorRemocacAlvenaria6_1.getText().toString()) * precoRemoverAlvenaria;
                double varRemoverTanque6 = Integer.parseInt(valorRemocaoTanque6.getText().toString()) * precoRemoverTanque;
                double varRemoverTanque6_1 = Integer.parseInt(valorRemocaoTanque6_1.getText().toString()) * precoRemoverTanque;
                double  varRemoverCaixinha4x2_6 = Integer.parseInt(valorRasgarCaixinha4x2_6.getText().toString()) * precoRasgarCaixinha4x2;
                double  varRemoverCaixinha4x2_6_1 = Integer.parseInt(valorRasgarCaixinha4x2_6_1.getText().toString()) * precoRasgarCaixinha4x2;
                double  varRemoverCaixinha4x4_6 = Integer.parseInt(valorRasgarCaixinha4x4_6.getText().toString()) * precoRasgarCaixinha4x4;
                double  varRemoverCaixinha4x4_6_1 = Integer.parseInt(valorRasgarCaixinha4x4_6_1.getText().toString()) * precoRasgarCaixinha4x4;
                double  varRemoverHidraulica6 = Integer.parseInt(valorRasgarHidraulica6.getText().toString()) * precoRemoverHidraulica;
                double  varRemoverHidraulica6_1 = Integer.parseInt(valorRasgarHidraulica6_1.getText().toString()) * precoRemoverHidraulica;
                double  varRemoverGesso6 = Integer.parseInt(valorRemoverGesso6.getText().toString()) * precoRemoverGesso;
                double  varRemoverGesso6_1 = Integer.parseInt(valorRemoverGesso6_1.getText().toString()) * precoRemoverGesso;
                double varRemoverVasoSanitario6 = Integer.parseInt(valorRemoverVaso6.getText().toString()) * precoRemoverVasoSanitario;
                double varRemoverVasoSanitario6_1 = Integer.parseInt(valorRemoverVaso6_1.getText().toString()) * precoRemoverVasoSanitario;
                double  varRemoverVao6 = Integer.parseInt(valorRemoverVao6.getText().toString()) * precoRemoverVao;
                double  varRemoverVao6_1 = Integer.parseInt(valorRemoverVao6_1.getText().toString()) * precoRemoverVao;


                double valorTotalSacadaVaranda= varRemoverRevestimentoParede6 + varRemoverRevestimentoParede6_1 +  varRemoverPiso6 + varRemoverPiso6_1 + varRemoverPia6 + varRemoverPia6_1 + varRemoverAlvenaria6 + varRemoverAlvenaria6_1 + varRemoverTanque6 + varRemoverTanque6_1 + varRemoverCaixinha4x2_6 + varRemoverCaixinha4x2_6_1 + varRemoverCaixinha4x4_6 + varRemoverCaixinha4x4_6_1 + varRemoverHidraulica6 + varRemoverHidraulica6_1 + varRemoverGesso6 + varRemoverGesso6_1 + varRemoverVasoSanitario6 + varRemoverVasoSanitario6_1 + varRemoverVao6 + varRemoverVao6_1;

                //Calculando Valores Sala de Jantar

                double varRemoverRevestimentoParede7 = Double.parseDouble(valorRevestimentoParede7.getText().toString()) * precoRemoverRevestimentoParede;
                double varRemoverRevestimentoParede7_1 = Double.parseDouble(valorRevestimentoParede7_1.getText().toString()) * precoRemoverRevestimentoParede;
                double varRemoverPiso7 = Double.parseDouble(valorRemocaoPiso7.getText().toString()) * precoRemoverPiso;
                double varRemoverPiso7_1 = Double.parseDouble(valorRemocaoPiso7_1.getText().toString()) * precoRemoverPiso;
                double varRemoverPia7 = Integer.parseInt(valorRemocaoPia7.getText().toString()) * precoRemoverPia;
                double varRemoverPia7_1 = Integer.parseInt(valorRemocaoPia7_1.getText().toString()) * precoRemoverPia;
                double varRemoverAlvenaria7 = Double.parseDouble(valorRemocacAlvenaria7.getText().toString()) * precoRemoverAlvenaria;
                double varRemoverAlvenaria7_1 = Double.parseDouble(valorRemocacAlvenaria7_1.getText().toString()) * precoRemoverAlvenaria;
                double varRemoverTanque7 = Integer.parseInt(valorRemocaoTanque7.getText().toString()) * precoRemoverTanque;
                double varRemoverTanque7_1 = Integer.parseInt(valorRemocaoTanque7_1.getText().toString()) * precoRemoverTanque;
                double  varRemoverCaixinha4x2_7 = Integer.parseInt(valorRasgarCaixinha4x2_7.getText().toString()) * precoRasgarCaixinha4x2;
                double  varRemoverCaixinha4x2_7_1 = Integer.parseInt(valorRasgarCaixinha4x2_7_1.getText().toString()) * precoRasgarCaixinha4x2;
                double  varRemoverCaixinha4x4_7 = Integer.parseInt(valorRasgarCaixinha4x4_7.getText().toString()) * precoRasgarCaixinha4x4;
                double  varRemoverCaixinha4x4_7_1 = Integer.parseInt(valorRasgarCaixinha4x4_7_1.getText().toString()) * precoRasgarCaixinha4x4;
                double  varRemoverHidraulica7 = Integer.parseInt(valorRasgarHidraulica7.getText().toString()) * precoRemoverHidraulica;
                double  varRemoverHidraulica7_1 = Integer.parseInt(valorRasgarHidraulica7_1.getText().toString()) * precoRemoverHidraulica;
                double  varRemoverGesso7 = Integer.parseInt(valorRemoverGesso7.getText().toString()) * precoRemoverGesso;
                double  varRemoverGesso7_1 = Integer.parseInt(valorRemoverGesso7_1.getText().toString()) * precoRemoverGesso;
                double varRemoverVasoSanitario7 = Integer.parseInt(valorRemoverVaso7.getText().toString()) * precoRemoverVasoSanitario;
                double varRemoverVasoSanitario7_1 = Integer.parseInt(valorRemoverVaso7_1.getText().toString()) * precoRemoverVasoSanitario;
                double  varRemoverVao7 = Integer.parseInt(valorRemoverVao7.getText().toString()) * precoRemoverVao;
                double  varRemoverVao7_1 = Integer.parseInt(valorRemoverVao7_1.getText().toString()) * precoRemoverVao;


                double valorTotalSalaJantar= varRemoverRevestimentoParede7 + varRemoverRevestimentoParede7_1 +  varRemoverPiso7 + varRemoverPiso7_1 + varRemoverPia7 + varRemoverPia7_1 + varRemoverAlvenaria7 + varRemoverAlvenaria7_1 + varRemoverTanque7 + varRemoverTanque7_1 + varRemoverCaixinha4x2_7 + varRemoverCaixinha4x2_7_1 + varRemoverCaixinha4x4_7 + varRemoverCaixinha4x4_7_1 + varRemoverHidraulica7 + varRemoverHidraulica7_1 + varRemoverGesso7 + varRemoverGesso7_1 + varRemoverVasoSanitario7 + varRemoverVasoSanitario7_1 + varRemoverVao7 + varRemoverVao7_1;

                //Calculando Valores Sala de Estar

                double varRemoverRevestimentoParede8 = Double.parseDouble(valorRevestimentoParede8.getText().toString()) * precoRemoverRevestimentoParede;
                double varRemoverRevestimentoParede8_1 = Double.parseDouble(valorRevestimentoParede8_1.getText().toString()) * precoRemoverRevestimentoParede;
                double varRemoverPiso8 = Double.parseDouble(valorRemocaoPiso8.getText().toString()) * precoRemoverPiso;
                double varRemoverPiso8_1 = Double.parseDouble(valorRemocaoPiso8_1.getText().toString()) * precoRemoverPiso;
                double varRemoverPia8 = Integer.parseInt(valorRemocaoPia8.getText().toString()) * precoRemoverPia;
                double varRemoverPia8_1 = Integer.parseInt(valorRemocaoPia8_1.getText().toString()) * precoRemoverPia;
                double varRemoverAlvenaria8= Double.parseDouble(valorRemocacAlvenaria8.getText().toString()) * precoRemoverAlvenaria;
                double varRemoverAlvenaria8_1 = Double.parseDouble(valorRemocacAlvenaria8_1.getText().toString()) * precoRemoverAlvenaria;
                double varRemoverTanque8 = Integer.parseInt(valorRemocaoTanque8.getText().toString()) * precoRemoverTanque;
                double varRemoverTanque8_1 = Integer.parseInt(valorRemocaoTanque8_1.getText().toString()) * precoRemoverTanque;
                double  varRemoverCaixinha4x2_8 = Integer.parseInt(valorRasgarCaixinha4x2_8.getText().toString()) * precoRasgarCaixinha4x2;
                double  varRemoverCaixinha4x2_8_1 = Integer.parseInt(valorRasgarCaixinha4x2_8_1.getText().toString()) * precoRasgarCaixinha4x2;
                double  varRemoverCaixinha4x4_8 = Integer.parseInt(valorRasgarCaixinha4x4_8.getText().toString()) * precoRasgarCaixinha4x4;
                double  varRemoverCaixinha4x4_8_1 = Integer.parseInt(valorRasgarCaixinha4x4_8_1.getText().toString()) * precoRasgarCaixinha4x4;
                double  varRemoverHidraulica8 = Integer.parseInt(valorRasgarHidraulica8.getText().toString()) * precoRemoverHidraulica;
                double  varRemoverHidraulica8_1 = Integer.parseInt(valorRasgarHidraulica8_1.getText().toString()) * precoRemoverHidraulica;
                double  varRemoverGesso8 = Integer.parseInt(valorRemoverGesso8.getText().toString()) * precoRemoverGesso;
                double  varRemoverGesso8_1 = Integer.parseInt(valorRemoverGesso8_1.getText().toString()) * precoRemoverGesso;
                double varRemoverVasoSanitario8 = Integer.parseInt(valorRemoverVaso8.getText().toString()) * precoRemoverVasoSanitario;
                double varRemoverVasoSanitario8_1 = Integer.parseInt(valorRemoverVaso8_1.getText().toString()) * precoRemoverVasoSanitario;
                double  varRemoverVao8 = Integer.parseInt(valorRemoverVao8.getText().toString()) * precoRemoverVao;
                double  varRemoverVao8_1 = Integer.parseInt(valorRemoverVao8_1.getText().toString()) * precoRemoverVao;


                double valorTotalSalaEstar= varRemoverRevestimentoParede8 + varRemoverRevestimentoParede8_1 +  varRemoverPiso8 + varRemoverPiso8_1 + varRemoverPia8 + varRemoverPia8_1 + varRemoverAlvenaria8 + varRemoverAlvenaria8_1 + varRemoverTanque8 + varRemoverTanque8_1 + varRemoverCaixinha4x2_8 + varRemoverCaixinha4x2_8_1 + varRemoverCaixinha4x4_8 + varRemoverCaixinha4x4_8_1 + varRemoverHidraulica8 + varRemoverHidraulica8_1 + varRemoverGesso8 + varRemoverGesso8_1 + varRemoverVasoSanitario8 + varRemoverVasoSanitario8_1 + varRemoverVao8 + varRemoverVao8_1;

                //Calculando Valores Quarto1

                double varRemoverRevestimentoParede9 = Double.parseDouble(valorRevestimentoParede9.getText().toString()) * precoRemoverRevestimentoParede;
                double varRemoverRevestimentoParede9_1 = Double.parseDouble(valorRevestimentoParede9_1.getText().toString()) * precoRemoverRevestimentoParede;
                double varRemoverPiso9 = Double.parseDouble(valorRemocaoPiso9.getText().toString()) * precoRemoverPiso;
                double varRemoverPiso9_1 = Double.parseDouble(valorRemocaoPiso9_1.getText().toString()) * precoRemoverPiso;
                double varRemoverPia9 = Integer.parseInt(valorRemocaoPia9.getText().toString()) * precoRemoverPia;
                double varRemoverPia9_1 = Integer.parseInt(valorRemocaoPia9_1.getText().toString()) * precoRemoverPia;
                double varRemoverAlvenaria9= Double.parseDouble(valorRemocacAlvenaria9.getText().toString()) * precoRemoverAlvenaria;
                double varRemoverAlvenaria9_1 = Double.parseDouble(valorRemocacAlvenaria9_1.getText().toString()) * precoRemoverAlvenaria;
                double varRemoverTanque9 = Integer.parseInt(valorRemocaoTanque9.getText().toString()) * precoRemoverTanque;
                double varRemoverTanque9_1 = Integer.parseInt(valorRemocaoTanque9_1.getText().toString()) * precoRemoverTanque;
                double  varRemoverCaixinha4x2_9 = Integer.parseInt(valorRasgarCaixinha4x2_9.getText().toString()) * precoRasgarCaixinha4x2;
                double  varRemoverCaixinha4x2_9_1 = Integer.parseInt(valorRasgarCaixinha4x2_9_1.getText().toString()) * precoRasgarCaixinha4x2;
                double  varRemoverCaixinha4x4_9 = Integer.parseInt(valorRasgarCaixinha4x4_9.getText().toString()) * precoRasgarCaixinha4x4;
                double  varRemoverCaixinha4x4_9_1 = Integer.parseInt(valorRasgarCaixinha4x4_9_1.getText().toString()) * precoRasgarCaixinha4x4;
                double  varRemoverHidraulica9 = Integer.parseInt(valorRasgarHidraulica9.getText().toString()) * precoRemoverHidraulica;
                double  varRemoverHidraulica9_1 = Integer.parseInt(valorRasgarHidraulica9_1.getText().toString()) * precoRemoverHidraulica;
                double  varRemoverGesso9 = Integer.parseInt(valorRemoverGesso9.getText().toString()) * precoRemoverGesso;
                double  varRemoverGesso9_1 = Integer.parseInt(valorRemoverGesso9_1.getText().toString()) * precoRemoverGesso;
                double varRemoverVasoSanitario9 = Integer.parseInt(valorRemoverVaso9.getText().toString()) * precoRemoverVasoSanitario;
                double varRemoverVasoSanitario9_1 = Integer.parseInt(valorRemoverVaso9_1.getText().toString()) * precoRemoverVasoSanitario;
                double  varRemoverVao9 = Integer.parseInt(valorRemoverVao9.getText().toString()) * precoRemoverVao;
                double  varRemoverVao9_1 = Integer.parseInt(valorRemoverVao9_1.getText().toString()) * precoRemoverVao;


                double valorTotalQuarto1= varRemoverRevestimentoParede9 + varRemoverRevestimentoParede9_1 +  varRemoverPiso9 + varRemoverPiso9_1 + varRemoverPia9 + varRemoverPia9_1 + varRemoverAlvenaria9 + varRemoverAlvenaria9_1 + varRemoverTanque9 + varRemoverTanque9_1 + varRemoverCaixinha4x2_9 + varRemoverCaixinha4x2_9_1 + varRemoverCaixinha4x4_9 + varRemoverCaixinha4x4_9_1 + varRemoverHidraulica9 + varRemoverHidraulica9_1 + varRemoverGesso9 + varRemoverGesso9_1 + varRemoverVasoSanitario9 + varRemoverVasoSanitario9_1 + varRemoverVao9 + varRemoverVao9_1;

                //Calculando Valores Quarto2

                double varRemoverRevestimentoParede10 = Double.parseDouble(valorRevestimentoParede10.getText().toString()) * precoRemoverRevestimentoParede;
                double varRemoverRevestimentoParede10_1 = Double.parseDouble(valorRevestimentoParede10_1.getText().toString()) * precoRemoverRevestimentoParede;
                double varRemoverPiso10 = Double.parseDouble(valorRemocaoPiso10.getText().toString()) * precoRemoverPiso;
                double varRemoverPiso10_1 = Double.parseDouble(valorRemocaoPiso10_1.getText().toString()) * precoRemoverPiso;
                double varRemoverPia10 = Integer.parseInt(valorRemocaoPia10.getText().toString()) * precoRemoverPia;
                double varRemoverPia10_1 = Integer.parseInt(valorRemocaoPia10_1.getText().toString()) * precoRemoverPia;
                double varRemoverAlvenaria10= Double.parseDouble(valorRemocacAlvenaria10.getText().toString()) * precoRemoverAlvenaria;
                double varRemoverAlvenaria10_1 = Double.parseDouble(valorRemocacAlvenaria10_1.getText().toString()) * precoRemoverAlvenaria;
                double varRemoverTanque10 = Integer.parseInt(valorRemocaoTanque10.getText().toString()) * precoRemoverTanque;
                double varRemoverTanque10_1 = Integer.parseInt(valorRemocaoTanque10_1.getText().toString()) * precoRemoverTanque;
                double  varRemoverCaixinha4x2_10 = Integer.parseInt(valorRasgarCaixinha4x2_10.getText().toString()) * precoRasgarCaixinha4x2;
                double  varRemoverCaixinha4x2_10_1 = Integer.parseInt(valorRasgarCaixinha4x2_10_1.getText().toString()) * precoRasgarCaixinha4x2;
                double  varRemoverCaixinha4x4_10 = Integer.parseInt(valorRasgarCaixinha4x4_10.getText().toString()) * precoRasgarCaixinha4x4;
                double  varRemoverCaixinha4x4_10_1 = Integer.parseInt(valorRasgarCaixinha4x4_10_1.getText().toString()) * precoRasgarCaixinha4x4;
                double  varRemoverHidraulica10 = Integer.parseInt(valorRasgarHidraulica10.getText().toString()) * precoRemoverHidraulica;
                double  varRemoverHidraulica10_1 = Integer.parseInt(valorRasgarHidraulica10_1.getText().toString()) * precoRemoverHidraulica;
                double  varRemoverGesso10 = Integer.parseInt(valorRemoverGesso10.getText().toString()) * precoRemoverGesso;
                double  varRemoverGesso10_1 = Integer.parseInt(valorRemoverGesso10_1.getText().toString()) * precoRemoverGesso;
                double varRemoverVasoSanitario10 = Integer.parseInt(valorRemoverVaso10.getText().toString()) * precoRemoverVasoSanitario;
                double varRemoverVasoSanitario10_1 = Integer.parseInt(valorRemoverVaso10_1.getText().toString()) * precoRemoverVasoSanitario;
                double  varRemoverVao10 = Integer.parseInt(valorRemoverVao10.getText().toString()) * precoRemoverVao;
                double  varRemoverVao10_1 = Integer.parseInt(valorRemoverVao10_1.getText().toString()) * precoRemoverVao;


                double valorTotalQuarto2= varRemoverRevestimentoParede10 + varRemoverRevestimentoParede10_1 +  varRemoverPiso10 + varRemoverPiso10_1 + varRemoverPia10 + varRemoverPia10_1 + varRemoverAlvenaria10 + varRemoverAlvenaria10_1 + varRemoverTanque10 + varRemoverTanque10_1 + varRemoverCaixinha4x2_10 + varRemoverCaixinha4x2_10_1 + varRemoverCaixinha4x4_10 + varRemoverCaixinha4x4_10_1 + varRemoverHidraulica10 + varRemoverHidraulica10_1 + varRemoverGesso10 + varRemoverGesso10_1 + varRemoverVasoSanitario10 + varRemoverVasoSanitario10_1 + varRemoverVao10 + varRemoverVao10_1;

                //Calculando Valores Quarto3

                double varRemoverRevestimentoParede11 = Double.parseDouble(valorRevestimentoParede11.getText().toString()) * precoRemoverRevestimentoParede;
                double varRemoverRevestimentoParede11_1 = Double.parseDouble(valorRevestimentoParede11_1.getText().toString()) * precoRemoverRevestimentoParede;
                double varRemoverPiso11 = Double.parseDouble(valorRemocaoPiso11.getText().toString()) * precoRemoverPiso;
                double varRemoverPiso11_1 = Double.parseDouble(valorRemocaoPiso11_1.getText().toString()) * precoRemoverPiso;
                double varRemoverPia11 = Integer.parseInt(valorRemocaoPia11.getText().toString()) * precoRemoverPia;
                double varRemoverPia11_1 = Integer.parseInt(valorRemocaoPia11_1.getText().toString()) * precoRemoverPia;
                double varRemoverAlvenaria11= Double.parseDouble(valorRemocacAlvenaria11.getText().toString()) * precoRemoverAlvenaria;
                double varRemoverAlvenaria11_1 = Double.parseDouble(valorRemocacAlvenaria11_1.getText().toString()) * precoRemoverAlvenaria;
                double varRemoverTanque11 = Integer.parseInt(valorRemocaoTanque11.getText().toString()) * precoRemoverTanque;
                double varRemoverTanque11_1 = Integer.parseInt(valorRemocaoTanque11_1.getText().toString()) * precoRemoverTanque;
                double  varRemoverCaixinha4x2_11 = Integer.parseInt(valorRasgarCaixinha4x2_11.getText().toString()) * precoRasgarCaixinha4x2;
                double  varRemoverCaixinha4x2_11_1 = Integer.parseInt(valorRasgarCaixinha4x2_11_1.getText().toString()) * precoRasgarCaixinha4x2;
                double  varRemoverCaixinha4x4_11 = Integer.parseInt(valorRasgarCaixinha4x4_11.getText().toString()) * precoRasgarCaixinha4x4;
                double  varRemoverCaixinha4x4_11_1 = Integer.parseInt(valorRasgarCaixinha4x4_11_1.getText().toString()) * precoRasgarCaixinha4x4;
                double  varRemoverHidraulica11 = Integer.parseInt(valorRasgarHidraulica11.getText().toString()) * precoRemoverHidraulica;
                double  varRemoverHidraulica11_1 = Integer.parseInt(valorRasgarHidraulica11_1.getText().toString()) * precoRemoverHidraulica;
                double  varRemoverGesso11 = Integer.parseInt(valorRemoverGesso11.getText().toString()) * precoRemoverGesso;
                double  varRemoverGesso11_1 = Integer.parseInt(valorRemoverGesso11_1.getText().toString()) * precoRemoverGesso;
                double varRemoverVasoSanitario11 = Integer.parseInt(valorRemoverVaso11.getText().toString()) * precoRemoverVasoSanitario;
                double varRemoverVasoSanitario11_1 = Integer.parseInt(valorRemoverVaso11_1.getText().toString()) * precoRemoverVasoSanitario;
                double  varRemoverVao11 = Integer.parseInt(valorRemoverVao11.getText().toString()) * precoRemoverVao;
                double  varRemoverVao11_1 = Integer.parseInt(valorRemoverVao11_1.getText().toString()) * precoRemoverVao;

                double valorTotalQuarto3= varRemoverRevestimentoParede11 + varRemoverRevestimentoParede11_1 +  varRemoverPiso11 + varRemoverPiso11_1 + varRemoverPia11 + varRemoverPia11_1 + varRemoverAlvenaria11 + varRemoverAlvenaria11_1 + varRemoverTanque11 + varRemoverTanque11_1 + varRemoverCaixinha4x2_11 + varRemoverCaixinha4x2_11_1 + varRemoverCaixinha4x4_11 + varRemoverCaixinha4x4_11_1 + varRemoverHidraulica11 + varRemoverHidraulica11_1 + varRemoverGesso11 + varRemoverGesso11_1 + varRemoverVasoSanitario11 + varRemoverVasoSanitario11_1 + varRemoverVao11 + varRemoverVao11_1;




                double total = valorTotalCozinha + valorTotalBanheiro1 + valorTotalBanheiro2 + valorTotalBanheiro2 + valorTotalLavabo + valorTotalSacadaVaranda + valorTotalSalaEstar + valorTotalSalaJantar + valorTotalQuarto1 + valorTotalQuarto2 + valorTotalQuarto3;
                Toast.makeText(mContext, "R$"+ total, Toast.LENGTH_SHORT).show();


                try {
                    createPdfWrapper();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (DocumentException e) {
                    e.printStackTrace();
                }
            }
        });

    }
    private void createPdf() throws FileNotFoundException, DocumentException {



        numeroNotaAtual = numNota + 1;
        SharedPreferences mypref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = mypref.edit();
        editor.putInt("numeroNota", numeroNotaAtual);
        editor.commit();
        alterarNumeroNota = Integer.toString(numeroNotaAtual);
        exibirNota.setText("000"+ alterarNumeroNota);

        Date now = new Date();
        android.text.format.DateFormat.format("dd-MM-yyyy_hh:mm:ss", now);

        File docsFolder = new File(Environment.getExternalStorageDirectory() + "/RelatóriosRagonezi/Relatórios de Demolição");
        if (!docsFolder.exists()) {
            docsFolder.mkdir();
           // Log.i(TAG, "Created a new directory for PDF");
        }

        Font bold = FontFactory.getFont("Times-Roman, Bold", 14, Font.BOLD);
        Font boldTitulo = FontFactory.getFont("Times-Roman, Bold", 22, Font.BOLD);
        Font boldServicos = FontFactory.getFont("Times-Roman, Bold", 14, Font.BOLD);
        Font boldServicosPrestados = FontFactory.getFont("Times-Roman, Bold", 12, Font.NORMAL);
        Font fontData = FontFactory.getFont("Times-Roman, Bold", 10, Font.BOLD);
        pdfFile = new File(docsFolder.getAbsolutePath(),"RelatórioDemolicao"+"000"+alterarNumeroNota+".pdf");
        OutputStream output = new FileOutputStream(pdfFile);
        Document document = new Document();
        PdfWriter.getInstance(document, output);
        document.open();


        //Adicionando Logo
        Drawable d = getResources ().getDrawable (R.drawable.logodoc);
        Bitmap bitmap = ((BitmapDrawable)d).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] bitmapData = stream.toByteArray();
        Image image = null;
        try {
            image = Image.getInstance(bitmapData);
            image.setAlignment(Element.ALIGN_CENTER);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Data
        Paragraph dataParagrafo = new Paragraph(String.valueOf(now), fontData);
        dataParagrafo.setAlignment(Element.ALIGN_LEFT);
        Paragraph espacoBranco = new Paragraph("", boldTitulo);
        Paragraph paragrafoCozinha = new Paragraph("Cozinha", boldServicos);
        Paragraph paragrafoBanheiro = new Paragraph("Banheiro", boldServicos);
        Paragraph paragrafoAreaServico = new Paragraph("Área de Serviço", boldServicos);
        Paragraph paragrafoBanheiro2 = new Paragraph("Banheiro Suíte", boldServicos);
        Paragraph paragrafoLavabo = new Paragraph("Lavabo", boldServicos);
        Paragraph paragrafoSacadaVaranda = new Paragraph("Sacada Varanda", boldServicos);
        Paragraph paragrafoSalaJantar = new Paragraph("Sala Jantar", boldServicos);
        Paragraph paragrafoSalaEstar = new Paragraph("Sala Estar", boldServicos);
        Paragraph paragrafoQuarto1 = new Paragraph("Quarto 1", boldServicos);
        Paragraph paragrafoQuarto2 = new Paragraph("Quarto 2", boldServicos);
        Paragraph paragrafoQuarto3 = new Paragraph("Quarto Suíte", boldServicos);



        Paragraph paragrafoServicos = new Paragraph("Quarto Suíte", boldServicosPrestados);

        espacoBranco.add(new Paragraph("", boldTitulo));
        espacoBranco.add(new Paragraph("", boldTitulo));
        //Paragrafos
        Paragraph titulo = new Paragraph("Orçamento de Demolição", boldTitulo);
        //Paragraph banheiro = new Paragraph("Remover revestimento 1", bold);
        //Paragraph cozinha = new Paragraph("Teste Bold", bold);




        //Alinhar paragrafos
        titulo.setAlignment(Element.ALIGN_CENTER);
        //Valores de Banheiro
       // banheiro.add(new Paragraph ("Remover revestimento 1"));
        //Valores de Cozinha
        //cozinha.add(new Paragraph("Revestimento 2"));


        String numeroNotaExibir = Integer.toString(numeroNotaAtual);

         document.add(dataParagrafo);
         document.addTitle("Orçamento de Demolição");
         document.add(new Paragraph("Número da nota:000"+numeroNotaExibir));
         document.add(Chunk.NEWLINE);
         document.add(Chunk.NEWLINE);
         document.add(Chunk.NEWLINE);
         document.add(image);
         document.add(Chunk.NEWLINE);
         document.add(titulo);
         document.add(Chunk.NEWLINE);
         document.add(Chunk.NEWLINE);
         document.add(Chunk.NEWLINE);

         if (valorTotalCozinha > 0){
             document.add(paragrafoCozinha);
             if (varRemoverRevestimentoParede > 0 || varRemoverRevestimentoParede1 > 0)
                 document.add(new Paragraph("Remover Revestimento de Parede: "+ valorRevestimentoParede1.getText().toString() +" - "+ valorRevestimentoParede1_1.getText().toString() + "    R$"+ (varRemoverRevestimentoParede1 + varRemoverRevestimentoParede)+"0",boldServicosPrestados));
             if (varRemoverPiso > 0 || varRemoverPiso1 > 0)
                document.add(new Paragraph("Remover Piso: "+ valorRemocaoPiso1.getText().toString() +" - "+ valorRemocaoPiso1_1.getText().toString() + "    R$"+ (varRemoverPiso + varRemoverPiso1)+"0",boldServicosPrestados));
             if (varRemoverPia > 0 || varRemoverPia1 > 0)
                document.add(new Paragraph("Remover Pia: "+ valorRemocaoPia1.getText().toString() +" - "+ valorRemocaoPia1_1.getText().toString() + "    R$"+ (varRemoverPia + varRemoverPia1)+"0",boldServicosPrestados));
             if (varRemoverAlvenaria > 0 || varRemoverAlvenaria1 > 0)
                document.add(new Paragraph("Remover Alvenaria: "+ valorRemocacAlvenaria1.getText().toString() +" - "+ valorRemocacAlvenaria1_1.getText().toString() + "    R$"+ (varRemoverAlvenaria + varRemoverAlvenaria1)+"0",boldServicosPrestados));
             if (varRemoverTanque > 0 || varRemoverTanque1 > 0)
                document.add(new Paragraph("Remover Tanque: "+ valorRemocaoTanque1.getText().toString() +" - "+ valorRemocaoTanque1_1.getText().toString() + "    R$"+ (varRemoverTanque + varRemoverTanque1)+"0",boldServicosPrestados));
             if (varRemoverCaixinha4x2 > 0 || varRemoverCaixinha4x2_1 > 0)
                document.add(new Paragraph("Rasgar Caixinha 4x2 : "+ valorRasgarCaixinha4x2_1.getText().toString() +" - "+ valorRasgarCaixinha4x2_1_1.getText().toString() + "    R$"+ (varRemoverCaixinha4x2 + varRemoverCaixinha4x2_1)+"0",boldServicosPrestados));
             if (varRemoverCaixinha4x4 > 0 || varRemoverCaixinha4x4_1 > 0)
                document.add(new Paragraph("Rasgar Caixinha 4x4 : "+ valorRasgarCaixinha4x4_1.getText().toString() +" - "+ valorRasgarCaixinha4x4_1_1.getText().toString() + "    R$"+ (varRemoverCaixinha4x4 + varRemoverCaixinha4x4_1)+"0",boldServicosPrestados));
             if (varRemoverHidraulica > 0 || varRemoverHidraulica1 > 0)
                document.add(new Paragraph("Rasgar  Hidráulica : "+ valorRasgarHidraulica1.getText().toString() +" - "+ valorRasgarHidraulica1_1.getText().toString() + "    R$"+ (varRemoverHidraulica + varRemoverHidraulica1)+"0",boldServicosPrestados));
             if (varRemoverGesso > 0 || varRemoverGesso1 > 0)
                document.add(new Paragraph("Remover Gesso : "+ valorRemoverGesso1.getText().toString() +" - "+ valorRemoverGesso1_1.getText().toString() + "    R$"+ (varRemoverGesso + varRemoverGesso1)+"0",boldServicosPrestados));
             if (varRemoverVasoSanitario > 0 || varRemoverVasoSanitario1 > 0)
                document.add(new Paragraph("Remover Vaso Sanitário : "+ valorRemoverVaso1.getText().toString() +" - "+ valorRemoverVaso1_1.getText().toString() + "    R$"+ (varRemoverVasoSanitario1 + varRemoverVasoSanitario)+"0",boldServicosPrestados));
             if (varRemoverVao > 0 || varRemoverVao1 > 0)
                document.add(new Paragraph("Remover Vão para Nicho : "+ valorRemoverVao1.getText().toString() +" - "+ valorRemoverVao1_1.getText().toString() + "    R$"+ (varRemoverVao1 + varRemoverVao)+"0",boldServicosPrestados));

         }
        if (valorTotalBanheiro1 > 0){
            document.add(paragrafoBanheiro);
            if (varRemoverRevestimentoParede2 > 0 || varRemoverRevestimentoParede2_1 > 0)
                document.add(new Paragraph("Remover Revestimento de Parede: "+ valorRevestimentoParede2.getText().toString() +" - "+ valorRevestimentoParede2_1.getText().toString() + "    R$"+ (varRemoverRevestimentoParede2 + varRemoverRevestimentoParede2_1)+"0",boldServicosPrestados));
            if (varRemoverPiso2 > 0 || varRemoverPiso2_1 > 0)
                document.add(new Paragraph("Remover Piso: "+ valorRemocaoPiso2.getText().toString() +" - "+ valorRemocaoPiso2_1.getText().toString() + "    R$"+ (varRemoverPiso2 + varRemoverPiso2_1)+"0",boldServicosPrestados));
            if (varRemoverPia2 > 0 || varRemoverPia2_1 > 0)
                document.add(new Paragraph("Remover Pia: "+ valorRemocaoPia2.getText().toString() +" - "+ valorRemocaoPia2_1.getText().toString() + "    R$"+ (varRemoverPia2 + varRemoverPia2_1)+"0",boldServicosPrestados));
            if (varRemoverAlvenaria2 > 0 || varRemoverAlvenaria2_1 > 0)
                document.add(new Paragraph("Remover Alvenaria: "+ valorRemocacAlvenaria2.getText().toString() +" - "+ valorRemocacAlvenaria2_1.getText().toString() + "    R$"+ (varRemoverAlvenaria2 + varRemoverAlvenaria2_1)+"0",boldServicosPrestados));
            if (varRemoverTanque2 > 0 || varRemoverTanque2_1 > 0)
                document.add(new Paragraph("Remover Tanque: "+ valorRemocaoTanque2.getText().toString() +" - "+ valorRemocaoTanque2_1.getText().toString() + "    R$"+ (varRemoverTanque2 + varRemoverTanque2_1)+"0",boldServicosPrestados));
            if (varRemoverCaixinha4x2_2 > 0 || varRemoverCaixinha4x2_2 > 0)
                document.add(new Paragraph("Rasgar Caixinha 4x2 : "+ valorRasgarCaixinha4x2_2.getText().toString() +" - "+ valorRasgarCaixinha4x2_2_1.getText().toString() + "    R$"+ (varRemoverCaixinha4x2_2 + varRemoverCaixinha4x2_2_1)+"0",boldServicosPrestados));
            if (varRemoverCaixinha4x4_2 > 0 || varRemoverCaixinha4x4_2 > 0)
                document.add(new Paragraph("Rasgar Caixinha 4x4 : "+ valorRasgarCaixinha4x4_2.getText().toString() +" - "+ valorRasgarCaixinha4x2_2_1.getText().toString() + "    R$"+ (varRemoverCaixinha4x4_2 + varRemoverCaixinha4x4_2_1)+"0",boldServicosPrestados));
            if (varRemoverHidraulica2 > 0 || varRemoverHidraulica2_1 > 0)
                document.add(new Paragraph("Rasgar  Hidráulica : "+ valorRasgarHidraulica2.getText().toString() +" - "+ valorRasgarHidraulica2_1.getText().toString() + "    R$"+ (varRemoverHidraulica2 + varRemoverHidraulica2_1)+"0",boldServicosPrestados));
            if (varRemoverGesso2 > 0 || varRemoverGesso2_1 > 0)
                document.add(new Paragraph("Remover Gesso : "+ valorRemoverGesso2.getText().toString() +" - "+ valorRemoverGesso2_1.getText().toString() + "    R$"+ (varRemoverGesso2 + varRemoverGesso2_1)+"0",boldServicosPrestados));
            if (varRemoverVasoSanitario2 > 0 || varRemoverVasoSanitario2_1 > 0)
                document.add(new Paragraph("Remover Vaso Sanitário : "+ valorRemoverVaso2.getText().toString() +" - "+ valorRemoverVaso2_1.getText().toString() + "    R$"+ (varRemoverVasoSanitario2 + varRemoverVasoSanitario2_1)+"0",boldServicosPrestados));
            if (varRemoverVao2 > 0 || varRemoverVao2_1 > 0)
                document.add(new Paragraph("Remover Vão para Nicho : "+ valorRemoverVao2.getText().toString() +" - "+ valorRemoverVao2_1.getText().toString() + "    R$"+ (varRemoverVao2 + varRemoverVao2_1)+"0",boldServicosPrestados));

        }
         else{

         }



       // document.add(new LineSeparator());
        document.close();
        previewPdf();

    }
    private void previewPdf() {

        PackageManager packageManager = getPackageManager();
        Intent testIntent = new Intent(Intent.ACTION_VIEW);
        testIntent.setType("application/pdf");
        List list = packageManager.queryIntentActivities(testIntent, PackageManager.MATCH_DEFAULT_ONLY);
        if (list.size() > 0) {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            Uri uri = FileProvider.getUriForFile(this, "com.pratikbutani.pdf.fileprovider", pdfFile);
            //FileProvider.getUriForFile(this,"your_package.fileprovider",pdfFile);
            intent.setDataAndType(uri, "application/pdf");

            startActivity(intent);
        }else{
            Toast.makeText(this,"Download a PDF Viewer to see the generated PDF",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, Main2Activity.class);
        intent.putExtra("numeroNotta", alterarNumeroNota);
        startActivity(intent);
        finish();
    }
    public void gerar() {




        Date now = new Date();
        android.text.format.DateFormat.format("yyyy-MM-dd_hh:mm:ss", now);

        String pathPdf = Environment.getExternalStorageDirectory()
                + "/Teste PDF/Notificações Teste/";

        Document document = new Document(PageSize.A4, 50, 50, 50, 50);
        try{
            StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
            StrictMode.setVmPolicy(builder.build());

            File dir = new File(pathPdf);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            //File file = new File(dir, "Teste.pdf");

            String file = "arquivo";
            String mPath = Environment.getExternalStorageDirectory().toString() + "/" + now;
            FileOutputStream fOut = new FileOutputStream(mPath);
            PdfWriter.getInstance(document, fOut);
            document.open();
            Font bold = FontFactory.getFont("Times-Roman, Bold", 12, Font.BOLD);
            Paragraph p00 = new Paragraph("Teste Bold", bold);
            Paragraph p01 = new Paragraph("Teste sem bold");
            p00.setAlignment(Paragraph.ALIGN_LEFT);
            p01.setAlignment(Paragraph.ALIGN_LEFT);

            document.add(p00);
            document.add(Chunk.NEWLINE);
            document.add(p01);
            document.add(Chunk.NEWLINE);
            document.close();
            Log.i("PDF", pathPdf);
        }catch (Exception e){
            Log.e("Erro PDF", e.toString());
        }
    }
    private void createPdfWrapper() throws FileNotFoundException,DocumentException{

        int hasWriteStoragePermission = ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (hasWriteStoragePermission != PackageManager.PERMISSION_GRANTED) {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (!shouldShowRequestPermissionRationale(Manifest.permission.WRITE_CONTACTS)) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                                REQUEST_CODE_ASK_PERMISSIONS);

                }

                    return;
                }

                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        REQUEST_CODE_ASK_PERMISSIONS);
            }
            return;
        }else {
            createPdf();
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_ASK_PERMISSIONS:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission Granted
                    try {
                        createPdfWrapper();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (DocumentException e) {
                        e.printStackTrace();
                    }
                } else {
                    // Permission Denied
                    Toast.makeText(this, "WRITE_EXTERNAL Permission Denied", Toast.LENGTH_SHORT)
                            .show();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }
    private static void PularLinha(Paragraph paragraph, int number) {
        for(int i=0; i<number; i++){
            paragraph.add(new Paragraph(""));
        }
    }
}
