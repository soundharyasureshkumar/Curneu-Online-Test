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
        private String getRandomName() {
            String[] adjs = {"autumn", "hidden", "bitter", "misty", "silent", "empty", "dry", "dark", "summer", "icy", "delicate", "quiet", "white", "cool", "spring", "winter", "patient", "twilight", "dawn", "crimson", "wispy", "weathered", "blue", "billowing", "broken", "cold", "damp", "falling",  "green", "long", "late", "lingering", "bold", "little", "morning", "muddy", "old", "red", "rough", "still", "small", "sparkling", "throbbing", "shy", "wandering", "withered", "wild", "black", "young", "holy", "solitary", "fragrant", "aged", "snowy", "proud", "floral", "restless", "divine", "polished", "ancient", "purple", "lively", "nameless"};
            String[] nouns = {"waterfall", "river", "breeze", "moon", "rain", "wind", "sea", "morning", "snow", "lake", "sunset", "pine", "shadow", "leaf", "dawn", "glitter", "forest", "hill", "cloud", "meadow", "sun", "glade", "bird", "brook", "butterfly", "bush", "dew", "dust", "field", "fire", "flower", "feather", "grass", "haze", "mountain", "night", "pond", "darkness", "snowflake", "silence", "sound", "sky", "shape", "surf", "thunder", "violet", "water", "wildflower", "wave", "water", "resonance", "sun", "wood", "dream", "cherry", "tree", "fog", "frost", "voice", "paper", "frog", "smoke", "star"};
            return (
                    adjs[(int) Math.floor(Math.random() * adjs.length)] +
                            "_" +
                            nouns[(int) Math.floor(Math.random() * nouns.length)]
            );
        }

        private String getRandomColor() {
            Random r = new Random();
            StringBuffer sb = new StringBuffer("#");
            while(sb.length() < 7){
                sb.append(Integer.toHexString(r.nextInt()));
            }
            return sb.toString().substring(0, 7);
        }
    }
    public void sendMessage(View view) {
        String message = editText.getText().toString();
        if (message.length() > 0) {
            scaledrone.publish("observable-room", message);
            editText.getText().clear();
        }
    }
    class MemberData {
        private String name;
        private String color;

        public MemberData(String name, String color) {
            this.name = name;
            this.color = color;
        }

        // Add an empty constructor so we can later parse JSON into MemberData using Jackson
        public MemberData() {
        }

        public String getName() {
            return name;
        }

        public String getColor() {
            return color;
        }
    }
}
