package populo.mod.tungsten;

import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public final class TungstenTabClass extends CreativeTabs {
	
	public TungstenTabClass(int par1, String par2Str) {
		super(par1, par2Str);
	}
//sets the image for the creative tab
	@SideOnly(Side.CLIENT)
	public int getTabIconItemIndex() {
		//there is a difference between items and blocks. will give an example of both
		return Tungsten.ingot.itemID;
	}
		//sets the title/name for the creative tab
	public String getTranslatedTabLabel() {
		return "Tungsten Mod Tab";
	}
}
