package sokobug.domain;

import sokobug.Sokobug;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class MenuButton extends TextButton {
	private String buttonType;
	private Sokobug game;

	public MenuButton(Sokobug game, String buttonType, Skin skin) {
		super(buttonType, skin);
		this.buttonType = buttonType;
		this.game = game;

		try {
			manageEvents();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
	}

	private void manageEvents() throws Exception {
		if (buttonType.compareTo("Play") == 0)
			this.addListener(new ClickListener() {
				@Override
				public void clicked(InputEvent event, float x, float y) {
					game.setScreen(game.chooseLevelScreen);
				}
			});
		else if (buttonType.compareTo("Options") == 0)
			this.addListener(new ClickListener() {
				@Override
				public void clicked(InputEvent event, float x, float y) {
					game.setScreen(game.optionsScreen);
				}
			});
		else if (buttonType.compareTo("Credits") == 0)
			this.addListener(new ClickListener() {
				@Override
				public void clicked(InputEvent event, float x, float y) {
					game.setScreen(game.creditsScreen);
				}
			});
		else if (buttonType.compareTo("Exit") == 0)
			this.addListener(new ClickListener() {
				@Override
				public void clicked(InputEvent event, float x, float y) {
					Gdx.app.exit();
				}
			});
		else if (buttonType.compareTo("BackToMenu") == 0)
			this.addListener(new ClickListener() {
				@Override
				public void clicked(InputEvent event, float x, float y) {
					game.setScreen(game.mainMenuScreen);
				}
			});
		else
			throw new Exception("Error: Wrong button type...");
	}
}