package populo.mod.tungsten.tools;

import populo.mod.tungsten.Tungsten;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemPickaxe;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Pickaxe extends ItemPickaxe {
	
	public Pickaxe(int ID, EnumToolMaterial material) {
		super(ID, material);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister reg) {
		if (itemID == Tungsten.pickaxe.itemID) {
			this.itemIcon = reg.registerIcon("tungsten:pickaxe");
		}
	}
	
}
