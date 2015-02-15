package sokobug.screens;

import sokobug.Sokobug;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class LogoScreen implements Screen {

	private Sokobug game;
	private Sprite background;
	float pasedTimeCounter;
	
	public LogoScreen(Sokobug myGame) {
		game = myGame;
		
		background = new Sprite(new Texture(Gdx.files.internal("Logo1.png")));
		background.setPosition(0.f, 0.f);
		pasedTimeCounter = 0.0f;
	}

	@Override
	public void render(float delta) {
		pasedTimeCounter += delta;
		if (pasedTimeCounter >= 4.0f) { // dupa ce au trecut 2 sec trece la Main Menu
			game.setScreen(game.mainMenuScreen);
			return;
		}		
		Gdx.gl.glClearColor(Color.DARK_GRAY.r, Color.DARK_GRAY.g, Color.DARK_GRAY.b, Color.DARK_GRAY.a);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		game.camera.update();
		game.batch.setProjectionMatrix(game.camera.combined);
		
		game.batch.begin();
		background.draw(game.batch);
		game.batch.end();
	}

	@Override
	public void show() {
		pasedTimeCounter = 0.0f;

	}

	@Override
	public void hide() {
		
	}
	
	@Override
	public void dispose() {
		background.getTexture().dispose();
	}
	
	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		game.viewport.update(width, height);
		game.camera.position.set(game.VIRTUAL_WIDTH / 2.f, game.VIRTUAL_HEIGHT / 2.f, 0.f);
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}



}
