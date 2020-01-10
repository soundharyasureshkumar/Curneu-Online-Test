package com.example.chatboxapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    RoomListener {

        private String channelID = "n19iPjGKuTbhcDN7";
        private String roomName = "observable-room";
        private EditText editText;
        private Scaledrone scaledrone;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            // This is where we write the mesage
            editText = (EditText) findViewById(R.id.editText);
        }

        // Successfully connected to Scaledrone room
        @Override
        public void onOpen(Room room) {
            System.out.println("Conneted to room");
        }

        // Connecting to Scaledrone room failed
        @Override
        public void onOpenFailure(Room room, Exception ex) {
            System.err.println(ex);
        }

        // Received a message from Scaledrone room
        @Override
        public void onMessage(Room room, com.scaledrone.lib.Message receivedMessage) {
            // TODO
        }
}
