package sokobug.screens;

import sokobug.Sokobug;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.loaders.TextureLoader.TextureParameter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class LogoScreen implements Screen, InputProcessor {

	private Sokobug game;
	
	private Sprite titleImage;
	private float titleImageDuration;
	
	private Sprite logo1;
	private float logo1Duration;

	private Sprite logo2;
	private float logo2Duration;
	
	private boolean displayTitle, displayLogo1, displayLogo2;
	private float pasedTimeCounter;
	
	
	public LogoScreen(Sokobug myGame) {
		game = myGame;
		
		TextureParameter param = new TextureParameter();
		param.minFilter = TextureFilter.Linear;
		game.assetManager.load("backgrounds/title.png", Texture.class, param);
		game.assetManager.load("logos/aart.png", Texture.class, param);
		game.assetManager.load("logos/potatoes.png", Texture.class, param);
		
		game.assetManager.finishLoading();
		
		titleImage = new Sprite(game.assetManager.get("backgrounds/title.png", Texture.class));
		titleImage.setPosition(0.f, 0.f);
		titleImageDuration = 5.0f;
		
		logo1 = new Sprite(game.assetManager.get("logos/aart.png", Texture.class));
		logo1Duration = 4.f;
		logo2 = new Sprite(game.assetManager.get("logos/potatoes.png", Texture.class));
		logo2Duration = 4.f;
		
		displayTitle = true;
		displayLogo1 = false;
		displayLogo2 = false;
		pasedTimeCounter = 0.0f;
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(Color.BLACK.r, Color.BLACK.g, Color.BLACK.b, Color.BLACK.a);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		game.camera.update();
		game.batch.setProjectionMatrix(game.camera.combined);
		
		pasedTimeCounter += delta;
		if (displayTitle) {
	        if(pasedTimeCounter > titleImageDuration) {
	        	displayTitle = false;
	        	displayLogo1 = true;
	        	pasedTimeCounter = 0.0f;
	        	return;
	        }   
	        
			game.batch.begin();
			titleImage.draw(game.batch);
			game.batch.end();
		}
		else if (displayLogo1) {
	        if(pasedTimeCounter > logo1Duration) {
	        	displayLogo1 = false;
	        	displayLogo2 = true;
	        	pasedTimeCounter = 0.0f;
	        	return;
	        }  
			
			game.batch.begin();
			logo1.draw(game.batch);
			game.batch.end();
		}
		else if (displayLogo2) {
	        if(pasedTimeCounter > logo2Duration) {
	        	game.setScreen(game.mainMenuScreen);
	        	return;
	        }  
			
			game.batch.begin();
			logo2.draw(game.batch);
			game.batch.end();
		}
	}

	@Override
	public void show() {
		Gdx.input.setInputProcessor(this);
	}

	@Override
	public void hide() {
		dispose();
	}
	
	@Override
	public void dispose() {
		game.assetManager.unload("backgrounds/title.png");
		game.assetManager.unload("logos/aart.png");
		game.assetManager.unload("logos/potatoes.png");
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

	@Override
	public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.ESCAPE) {
        	if (displayTitle) {
	        	displayTitle = false;
		    	displayLogo1 = true;
		    	pasedTimeCounter = 0.0f;
        	}
        	else if (displayLogo1) {
	        	displayLogo1 = false;
	        	displayLogo2 = true;
	        	pasedTimeCounter = 0.0f;
        	}
        	else if (displayLogo2) {
	        	game.setScreen(game.mainMenuScreen);
        	}
        	return true; // ca sa arat ca am rezolvat evenimentul
        } 
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
    	if (displayTitle) {
        	displayTitle = false;
	    	displayLogo1 = true;
	    	pasedTimeCounter = 0.0f;
    	}
    	else if (displayLogo1) {
        	displayLogo1 = false;
        	displayLogo2 = true;
        	pasedTimeCounter = 0.0f;
    	}
    	else if (displayLogo2) {
        	game.setScreen(game.mainMenuScreen);
    	}
    	return true; // ca sa arat ca am rezolvat evenimentul
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}



}
