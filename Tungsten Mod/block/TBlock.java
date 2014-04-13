package populo.mod.tungsten.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import populo.mod.tungsten.Tungsten;

public class TBlock extends Block{
	public TBlock(int ID, String texture) {
		super(ID, Material.rock);
	}
	
	public int idDropped(int par1, Random par2Random, int par3) {
		return Tungsten.block.blockID;
	}
	public int quantityDropped(Random random) {
		int y;
		double x = Math.random();
		if (x <= 0.33) {
			y = 1;
		} else if (x <= 0.66 && x > 0.33) {
			y = 2;
		} else if (x < 0.66) {
			y = 3;
		} else {
			y = 4;
		}
		return y;
	}
	
	public void registerIcons(IconRegister reg) {
		this.blockIcon = reg.registerIcon("tungsten:tungsten_block");
	}
	
}

