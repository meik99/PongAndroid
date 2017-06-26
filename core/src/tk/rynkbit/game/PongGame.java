package tk.rynkbit.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;

public class PongGame extends ApplicationAdapter {
	SpriteBatch batch;

	Pong pongPlayer;
	Pong pongEnemy;
	Stage stage;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		pongPlayer = new Pong();
		pongEnemy = new Pong(
		        Gdx.graphics.getWidth() -
                        Pong.WIDTH -
                        Pong.BORDER_SPACE);
		stage = new Stage();

		stage.addActor(pongPlayer);
		stage.addActor(pongEnemy);

		Gdx.input.setInputProcessor(new InputAdapter(){
			@Override
			public boolean touchDragged(int screenX, int screenY, int pointer) {
				pongPlayer.setY(Gdx.graphics.getHeight() - screenY - Pong.HEIGHT / 2);
				return super.touchDragged(screenX, screenY, pointer);
			}
		});
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act();
		stage.draw();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		stage.dispose();
		pongPlayer = null;
		pongEnemy = null;
	}
}
