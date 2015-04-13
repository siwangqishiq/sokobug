package sokobug;

import sokobug.screens.ChooseLevelScreen;
import sokobug.screens.CreditsScreen;
import sokobug.screens.IngameScreen;
import sokobug.screens.TitleScreen;
import sokobug.screens.MainMenuScreen;
import sokobug.screens.OptionsScreen;
import sokobug.screens.VictoryScreen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class Sokobug extends Game {
	public TitleScreen logoScreen;
	public MainMenuScreen mainMenuScreen;
	public CreditsScreen creditsScreen;
	public OptionsScreen optionsScreen;
	public ChooseLevelScreen chooseLevelScreen;
	public IngameScreen ingameScreen;
	public VictoryScreen victoryScreen;
	
	public AssetManager assetManager;
	public SpriteBatch batch;
	
	public final float VIRTUAL_WIDTH = 1280;
	public final float VIRTUAL_HEIGHT = 800;
	public OrthographicCamera camera;
	public FitViewport viewport;
	
	@Override
	public void create() {
		//float ratio = (float)Gdx.graphics.getHeight() / (float)Gdx.graphics.getWidth();
		camera = new OrthographicCamera();
		viewport = new FitViewport(VIRTUAL_WIDTH, VIRTUAL_HEIGHT, camera);
		viewport.apply();
		
		assetManager = new AssetManager();
		batch = new SpriteBatch();
		
		logoScreen = new TitleScreen(this);
		this.setScreen(logoScreen);
	}
	
	@Override
	public void dispose() {
		super.dispose();
		batch.dispose();
		assetManager.dispose();
	}
	
}
