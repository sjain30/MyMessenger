package com.example.mymessenger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ReceiveMessageActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "message";
    private static String text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_message);
        Intent intent = getIntent();
        String receivedMessage = intent.getStringExtra(EXTRA_MESSAGE);
        text=receivedMessage;
        TextView textView = findViewById(R.id.message);
        textView.setText(receivedMessage);
    }

    public void sendMessage(View view)
    {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT,text);
        Intent chooseact = Intent.createChooser(intent,"Send via...");
        startActivity(chooseact);
    }
}
