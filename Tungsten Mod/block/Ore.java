package populo.mod.tungsten.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import populo.mod.tungsten.Tungsten;

public class Ore extends Block {
	public Ore(int ID, String texture) {
		super(ID, Material.rock);
	}
	
	public int idDropped(int par1, Random par2Random, int par3) {
		return Tungsten.ore.blockID;
	}
	public int quantityDropped(Random random) {
		return 1+random.nextInt(1);
	}
	
	public void registerIcons(IconRegister reg) {
		this.blockIcon = reg.registerIcon("tungsten:ore");
	}
}
