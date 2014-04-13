package populo.mod.tungsten;

import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.IFuelHandler;

public class TFuel implements IFuelHandler {

	@Override
	public int getBurnTime(ItemStack fuel) {
		if(fuel.itemID == Tungsten.moltenBlock.blockID)
			return 100000;
		else if (fuel.itemID == Tungsten.molten.itemID)
			return 75000;
		else
			return 0;
	}

}
