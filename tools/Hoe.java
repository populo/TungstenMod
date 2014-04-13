package populo.mod.tungsten.tools;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemHoe;
import populo.mod.tungsten.Tungsten;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Hoe extends ItemHoe {
	public Hoe(int ID, EnumToolMaterial material) {
		super(ID, material);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister reg) {
		if (itemID == Tungsten.hoe.itemID) {
			this.itemIcon = reg.registerIcon("tungsten:hoe");
		}
	}
}