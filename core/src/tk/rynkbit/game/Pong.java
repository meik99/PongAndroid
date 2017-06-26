package tk.rynkbit.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;

/**
 * Created by michael on 21.06.17.
 */

public class Pong extends Actor{
    public static final int WIDTH = 100;
    public static final int BORDER_SPACE = 100;
    public static final int HEIGHT = 500;

    ShapeRenderer shapeRenderer;

    public Pong(){
        super();

        shapeRenderer = new ShapeRenderer();
        this.setX(BORDER_SPACE);
        this.setY(Gdx.graphics.getHeight() / 2 - HEIGHT / 2);
    }

    public Pong(int x){
        this();

        setX(x);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.WHITE);
        shapeRenderer.rect(getX(), getY(), WIDTH, HEIGHT);
        shapeRenderer.end();
    }
}
