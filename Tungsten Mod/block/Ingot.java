package populo.mod.tungsten.block;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import populo.mod.tungsten.Tungsten;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Ingot extends Item {
	public Ingot(int ID, int maxStackSize, CreativeTabs tab) {
		super(ID);
        setMaxStackSize(maxStackSize);
        setCreativeTab(tab);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister reg) {
		if (itemID == Tungsten.ingot.itemID){
			this.itemIcon = reg.registerIcon("tungsten:ingot");
		} else if (itemID == Tungsten.molten.itemID) {
			this.itemIcon = reg.registerIcon("tungsten:molten");
		} else if (itemID == Tungsten.nugget.itemID) {
			this.itemIcon = reg.registerIcon("tungsten:nugget");
		}
	}

	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack item) {
			return EnumRarity.epic;
	}
}
