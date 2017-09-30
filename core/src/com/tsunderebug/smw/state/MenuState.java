package com.tsunderebug.smw.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.tsunderebug.smw.Resources;
import com.tsunderebug.smw.Text;

public class MenuState implements GameState {

    private SpriteBatch batch;
    private SpriteBatch rainbowBatch;

    public static final String RAINBOW_VERTEX_SHADER =
                    "attribute vec4 a_position;\n" +
                    "attribute vec4 a_color;\n" +
                    "attribute vec2 a_texCoord0;\n" +
                    "uniform mat4 u_projTrans;\n" +
                    "varying vec4 v_color;\n" +
                    "varying vec2 v_texCoords;\n" +
                    "uniform float u_time;\n" +
                    "void main()\n{\n" +
                    "   v_color = vec4(1, 1, 1, 1); \n" +
                    "   v_texCoords = a_texCoord0; \n" +
                    "   gl_Position = u_projTrans * (vec4(0.0, 12.0 * sin(u_time * 8.0 + a_position.x / 8.0), 0.0, 0.0) + a_position);\n" +
                    "}";
    public static final String RAINBOW_FRAGMENT_SHADER =
                    "varying vec4 v_color;\n" +
                    "varying vec2 v_texCoords;\n" +
                    "uniform sampler2D u_texture;\n" +
                    "uniform float u_time;\n" +
                    "float x, y, r, g, b;\n" +
                    "void main()\n{\n" +
                    "  x = v_texCoords.x;\n" +
                    "  y = v_texCoords.y;\n" +
                    "  r = abs(sin((x + y + abs(u_time))));\n" +
                    "  g = abs(sin(120.0 + u_time + (x + y + abs(u_time))));\n" +
                    "  b = abs(sin(240.0 + (x + y + abs(u_time))));\n" +
                    "  gl_FragColor = v_color * vec4(r, g, b, 1.0) * texture2D(u_texture, v_texCoords);\n" +
                    "}";

    @Override
    public void onChange() {
        batch = new SpriteBatch();
        ShaderProgram.pedantic = false;
        ShaderProgram rainbowShader = new ShaderProgram(RAINBOW_VERTEX_SHADER, RAINBOW_FRAGMENT_SHADER);
        rainbowBatch = new SpriteBatch(1000, rainbowShader);
    }

    @Override
    public GameState nextState() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(Resources.getResource("super"), 500.0f, 900.0f);
        batch.draw(Resources.getResource("world"), 800.0f, 600.0f);
        Text.draw(batch, "[ff0000ff]UN[00ff00ff]SE[ffffffff]LEC[ffff00ff]TED TEXT", 500, 400);
        batch.end();
        rainbowBatch.begin();
        rainbowBatch.getShader().setUniformf("u_time", (System.currentTimeMillis() % 18849) / 3000.0f);
        rainbowBatch.draw(Resources.getResource("multi"), 650.0f, 750.0f);
        Text.draw(rainbowBatch, "SELECTED TEXT", 500, 200);
        rainbowBatch.end();
        return this;
    }

}
