package populo.mod.tungsten.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import populo.mod.tungsten.Tungsten;

public class MBlock extends Block{
	public MBlock(int ID, String texture) {
		super(ID, Material.rock);
	}
	
	public int idDropped(int par1, Random par2Random, int par3) {
		return Tungsten.moltenBlock.blockID;
	}
	public int quantityDropped(Random random) {
		return 1;
	}
	
	public void registerIcons(IconRegister reg) {
		this.blockIcon = reg.registerIcon("tungsten:tungsten_moltenblock");
	}
}