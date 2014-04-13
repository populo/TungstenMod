package populo.mod.tungsten.armor;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import populo.mod.tungsten.Tungsten;

public class Armor extends ItemArmor {
	
	public Armor(int ID, EnumArmorMaterial material, int par3, int par4) {
		super(ID, material, par4, par4);
	}
	
	public void registerIcons(IconRegister reg) {
		if (itemID == Tungsten.helmet.itemID) {
			this.itemIcon = reg.registerIcon("tungsten:helmet");
		} else if (itemID == Tungsten.chestplate.itemID){
			this.itemIcon = reg.registerIcon("tungsten:chestplate");
		} else if (itemID == Tungsten.leggings.itemID) {
			this.itemIcon = reg.registerIcon("tungsten:leggings");
		} else if (itemID == Tungsten.boots.itemID) {
			this.itemIcon = reg.registerIcon("tungsten:boots");
		}
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer) {
		if (slot == 2) {
			return "tungsten:textures/armor/armor_2.png";
		} else {
			return "tungsten:textures/armor/armor_1.png";
		}
	}

}
