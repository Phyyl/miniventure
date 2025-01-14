package com.mojang.ld22.item;

import com.mojang.ld22.entity.Entity;
import com.mojang.ld22.entity.Furniture;
import com.mojang.ld22.entity.Player;
import com.mojang.ld22.gfx.Color;
import com.mojang.ld22.gfx.Font;
import com.mojang.ld22.gfx.Screen;

public class PowerGloveItem extends Item {
	
	@Override
	public int getColor() {
		return Color.get(-1, 100, 320, 430); //sets the color of the powerglove
	}

	@Override
	public int getSprite() {
		return 7 + 4 * 32; //returns the location of the sprite(image of the glove)
	}

	@Override
	public void renderIcon(Screen screen, int x, int y) {
		screen.render(x, y, getSprite(), getColor(), 0); // Renders the icon of the power glove to the screen
	}

	@Override
	public void renderInventory(Screen screen, int x, int y) {
		screen.render(x, y, getSprite(), getColor(), 0); // renders the icon of the power glove to the screen
		Font.draw(getName(), screen, x + 8, y, Color.get(-1, 555, 555, 555)); // renders the name of the powerglove to the screen
	}

	@Override
	public String getName() {
		return "Pow glove"; //returns the name of the glove
	}

	@Override
	public boolean interact(Player player, Entity entity, int attackDir) {
		if (entity instanceof Furniture) { // If the power glove hits a furnace
			Furniture f = (Furniture) entity; // Assigns the furniture
			f.take(player); // Takes (picks up) the furniture
			return true; // Method returns true
		}
		return false; // method returns false if it did not hit a furniture entity.
	}
}
