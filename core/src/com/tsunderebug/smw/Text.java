package com.tsunderebug.smw;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Arrays;

public class Text {

    public static void draw(SpriteBatch batch, String t, float x, float y) {
        Color originalColor = batch.getColor();
        batch.setColor(Color.WHITE);
        Texture a = Resources.getResource("ascii");
        byte[] bytes = t.getBytes();
        int escapes = 0;
        for (int i = 0; i < bytes.length; i++) {
            if (bytes[i] != '[') {
                int high = (bytes[i] & 0xF0) >> 4;
                int low = bytes[i] & 0x0F;
                int posx = low * 8;
                int posy = high * 8;
                batch.draw(a, x + ((i - escapes) * 64), y, 64, 64, posx, posy, 8, 8, false, false);
            } else {
                escapes++;
                StringBuilder hex = new StringBuilder();
                for(int j = 0; j < 8; j++) {
                    i++;
                    escapes++;
                    hex.append((char) bytes[i]);
                }
                Color c = new Color(Integer.parseUnsignedInt(hex.toString(), 16));
                batch.setColor(c);
                if(bytes[i + 1] == ']') {
                    escapes++;
                    i++;
                }
            }
        }
        batch.setColor(originalColor);
    }

}
