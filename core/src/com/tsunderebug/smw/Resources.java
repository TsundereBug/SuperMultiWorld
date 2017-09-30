package com.tsunderebug.smw;

import com.badlogic.gdx.graphics.Texture;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class Resources {

    private static Map<String, Texture> resources = new HashMap<>();

    public static Texture getResource(String s) {
        if(resources.containsKey(s)) {
            return resources.get(s);
        } else {
            Texture t = new Texture(s + ".png");
            resources.put(s, t);
            return t;
        }
    }

    public static void dispose() {
        resources.forEach((k, v) -> v.dispose());
        resources.clear();
    }

}
