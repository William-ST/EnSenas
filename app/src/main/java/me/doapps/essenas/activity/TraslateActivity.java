package me.doapps.essenas.activity;

import android.content.Intent;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import me.doapps.essenas.R;


public class TraslateActivity extends AppCompatActivity implements RecognitionListener, View.OnClickListener {

    private String TAG = TraslateActivity.class.getSimpleName();
    public static SpeechRecognizer speech = null;
    public static Intent recognizerIntent;

    private List<String> phrase;
    private TextView textPhrase;
    private LinearLayout linearImages, linearText;
    private ImageView imgBack;
    private boolean isConnected = false;
    private int count = 0;
    private HashMap<String, Integer> mapAlphabet;

    private int type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traslate);

        linearImages = (LinearLayout) findViewById(R.id.linearImages);
        linearText = (LinearLayout) findViewById(R.id.linearText);

        type = getIntent().getExtras().getInt(MenuActivity.TYPE);
        if (type == 1)
            linearText.setVisibility(View.VISIBLE);
        else
            linearImages.setVisibility(View.VISIBLE);

        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );

        textPhrase = (TextView) findViewById(R.id.textPhrase);
        imgBack = (ImageView) findViewById(R.id.imgBack);


        imgBack.setOnClickListener(this);

        phrase = new ArrayList<>();
        mapAlphabet = new HashMap<>();

        mapAlphabet.put("a", R.mipmap.a);
        mapAlphabet.put("b", R.mipmap.b);
        mapAlphabet.put("c", R.mipmap.c);
        mapAlphabet.put("d", R.mipmap.d);
        mapAlphabet.put("e", R.mipmap.e);
        mapAlphabet.put("f", R.mipmap.f);
        mapAlphabet.put("g", R.mipmap.g);
        mapAlphabet.put("h", R.mipmap.h);
        mapAlphabet.put("i", R.mipmap.i);
        mapAlphabet.put("j", R.mipmap.j);
        mapAlphabet.put("k", R.mipmap.k);
        mapAlphabet.put("l", R.mipmap.l);
        mapAlphabet.put("m", R.mipmap.m);
        mapAlphabet.put("n", R.mipmap.n);
        mapAlphabet.put("ñ", R.mipmap.enie);
        mapAlphabet.put("o", R.mipmap.o);
        mapAlphabet.put("p", R.mipmap.p);
        mapAlphabet.put("q", R.mipmap.q);
        mapAlphabet.put("r", R.mipmap.r);
        mapAlphabet.put("s", R.mipmap.s);
        mapAlphabet.put("t", R.mipmap.t);
        mapAlphabet.put("u", R.mipmap.u);
        mapAlphabet.put("v", R.mipmap.v);
        mapAlphabet.put("w", R.mipmap.w);
        mapAlphabet.put("x", R.mipmap.x);
        mapAlphabet.put("y", R.mipmap.y);
        mapAlphabet.put("z", R.mipmap.z);


        /*for (int i = 0; i < 20; i++) {
            phrase.add("Este es un ejemplo #" + i);
        }*/

        speech = SpeechRecognizer.createSpeechRecognizer(this);
        speech.setRecognitionListener(this);
        recognizerIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);

        recognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_PREFERENCE, "es");
        recognizerIntent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, this.getPackageName());
        recognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_WEB_SEARCH);
        recognizerIntent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 1);

        speech.startListening(recognizerIntent);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        try {
            speech.cancel();
            speech.destroy();
        } catch (Exception e) {
            Log.e(TAG, "onDestroy() " + e.toString());
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (speech != null) {
            speech.destroy();
            Log.e(TAG, "destroy");
        }

    }

    @Override
    public void onBeginningOfSpeech() {
        Log.e(TAG, "onBeginningOfSpeech");
    }

    @Override
    public void onBufferReceived(byte[] buffer) {
        Log.e(TAG, "onBufferReceived: " + buffer);
    }

    @Override
    public void onEndOfSpeech() {
        Log.e(TAG, "onEndOfSpeech");
//        toggleButton.setChecked(false);
    }

    @Override
    public void onError(int errorCode) {
        String errorMessage = getErrorText(errorCode);
        Log.e(TAG, "FAILED " + errorMessage);
//        returnedText.setText(errorMessage);
//        toggleButton.setChecked(false);
    }

    @Override
    public void onEvent(int arg0, Bundle arg1) {
        Log.e(TAG, "onEvent");
    }

    @Override
    public void onPartialResults(Bundle arg0) {
        Log.e(TAG, "onPartialResults");
    }

    @Override
    public void onReadyForSpeech(Bundle arg0) {
        Log.e(TAG, "onReadyForSpeech");
    }

    @Override
    public void onResults(Bundle results) {
        Log.e(TAG, "onResults");
        ArrayList<String> matches = results
                .getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
        String text = matches.get(0).toString();

        phrase.add(text);
        showingText();

//        returnedText.setText(matches.get(0).toString());
//        toggleButton.performClick();
    }

    @Override
    public void onRmsChanged(float rmsdB) {
    }

    public static String getErrorText(int errorCode) {
        String message;
        switch (errorCode) {
            case SpeechRecognizer.ERROR_AUDIO:
                message = "Audio recording error";
                break;
            case SpeechRecognizer.ERROR_CLIENT:
                message = "Client side error";
                break;
            case SpeechRecognizer.ERROR_INSUFFICIENT_PERMISSIONS:
                message = "Insufficient permissions";
                break;
            case SpeechRecognizer.ERROR_NETWORK:
                message = "Network error";
                break;
            case SpeechRecognizer.ERROR_NETWORK_TIMEOUT:
                message = "Network timeout";
                break;
            case SpeechRecognizer.ERROR_NO_MATCH:
                message = "No match";
                break;
            case SpeechRecognizer.ERROR_RECOGNIZER_BUSY:
                message = "RecognitionService busy";
                speech.cancel();
                speech.startListening(recognizerIntent);
                break;
            case SpeechRecognizer.ERROR_SERVER:
                message = "error from server";
                break;
            case SpeechRecognizer.ERROR_SPEECH_TIMEOUT:
                message = "No speech input";
                break;
            default:
                message = "Didn't understand, please try again.";
                break;
        }
        return message;
    }

    /**
     * Thread
     **/
    private void showingText() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (!isConnected) {
                    Log.e("count", count + "");
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            updateLayout(phrase.get(0));
                        }
                    });
                    count++;
                    if (count == phrase.size() - 1) {
                        Log.e("end", count + "");
                        phrase.clear();
                        isConnected = true;
                    }
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    /**
     * Methods
     **/
    private void updateLayout(String content) {
        textPhrase.setText(content);
        for (int i = 0; i < content.length(); i++) {
            ImageView tempImage = new ImageView(TraslateActivity.this);
            Log.e("charrr", String.valueOf(content.charAt(i)));
            try {
                tempImage.setImageResource(mapAlphabet.get(String.valueOf(content.charAt(i))));
            } catch (Exception e) {
                e.printStackTrace();
            }
            tempImage.setLayoutParams(new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
            ));
            linearImages.addView(tempImage);
        }

        YoYo.with(Techniques.SlideOutLeft)
                .duration(2500)
                .playOn(linearImages);

        YoYo.with(Techniques.SlideOutLeft)
                .duration(2500)
                .playOn(textPhrase);
    }

    @Override
    public void onClick(View view) {
        finish();
    }
}
