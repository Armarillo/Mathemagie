package de.co.armadillo;

import com.badlogic.gdx.Files.FileType;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.addIcon("data/favicon.png", FileType.Internal);
		cfg.title = "Mathemagie - developed by Julien";
		cfg.resizable = false;
		cfg.useGL20 = false;
		cfg.width = 720;
		cfg.height = 840;
		
		new LwjglApplication(new GameWindow(), cfg);
	}
}
