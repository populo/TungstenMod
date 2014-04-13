package populo.mod.tungsten;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSeedFood;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import populo.mod.tungsten.armor.Armor;
import populo.mod.tungsten.block.Ingot;
import populo.mod.tungsten.block.MBlock;
import populo.mod.tungsten.block.Ore;
import populo.mod.tungsten.block.Plant;
import populo.mod.tungsten.block.TBlock;
import populo.mod.tungsten.tools.Axe;
import populo.mod.tungsten.tools.Hoe;
import populo.mod.tungsten.tools.Pickaxe;
import populo.mod.tungsten.tools.Shovel;
import populo.mod.tungsten.tools.Sword;
import populo.mod.tungsten.world.WorldGeneratorTungsten;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;


@Mod(modid="Tungsten", name="Tungsten Mod", version="1.0.0")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)

public class Tungsten {
	
	@Instance(value = "Tungsten")
	public static Tungsten instance;
	
	@SidedProxy(clientSide="populo.mod.tungsten.client.ClientProxy", serverSide="populo.mod.tungsten.CommonProxy")
	public static CommonProxy proxy;
	
	//enums
	
	public static EnumToolMaterial TungstenTools = EnumHelper.addToolMaterial("Tungsten Tools", 3, 800, 17.0F, 14.0F, 28);
	public static EnumArmorMaterial TungstenArmor = EnumHelper.addArmorMaterial("Tungsten Armor", 30, new int[] {3, 8, 7, 5}, 20);
	
	//tools
	
	public static Item pickaxe;
	public static Item axe;
	public static Item hoe;
	public static Item shovel;
	public static Item sword;
	
	//armor
	
	public static Item helmet;
	public static Item chestplate;
	public static Item leggings;
	public static Item boots;
	
	//items
	
	public static Item ingot;
	public static Item molten;
	public static Item nugget;
	public static Item seed;
	
	//blocks
	
	public static Block ore;
	public static Block block;
	public static Block moltenBlock;
	public static Block plant;
	
	//tab
	
	public static CreativeTabs tungstenTab = new TungstenTabClass(CreativeTabs.getNextID(), "Tungsten Mod Tab");
	
	//seed
	
	
	@EventHandler
	public void preInt(FMLPreInitializationEvent event) {
		
		//tools
		
		pickaxe = (ItemPickaxe) new Pickaxe(8000, TungstenTools).setUnlocalizedName("tungstenPickaxe").setCreativeTab(Tungsten.tungstenTab);
		axe = (ItemAxe) new Axe(8001, TungstenTools).setUnlocalizedName("tungstenAxe").setCreativeTab(Tungsten.tungstenTab);
		hoe = (ItemHoe) new Hoe(8002, TungstenTools).setUnlocalizedName("tungstenHoe").setCreativeTab(Tungsten.tungstenTab);
		shovel = (ItemSpade) new Shovel(8003, TungstenTools).setUnlocalizedName("tungstenShovel").setCreativeTab(Tungsten.tungstenTab);
		sword = (ItemSword) new Sword(8004, TungstenTools).setUnlocalizedName("tungstenSword").setCreativeTab(Tungsten.tungstenTab);
		
		//armor
		
		helmet = (ItemArmor) new Armor(8005, TungstenArmor, 5, 0).setUnlocalizedName("tungstenHelmet").setCreativeTab(Tungsten.tungstenTab);
		chestplate = (ItemArmor) new Armor(8006, TungstenArmor, 5, 1).setUnlocalizedName("tungstenChest").setCreativeTab(Tungsten.tungstenTab);
		leggings = (ItemArmor) new Armor(8007, TungstenArmor, 5, 2).setUnlocalizedName("tungstenLegs").setCreativeTab(Tungsten.tungstenTab);
		boots = (ItemArmor) new Armor(8008, TungstenArmor, 5, 3).setUnlocalizedName("tungstenBoot").setCreativeTab(Tungsten.tungstenTab);
		
		//items
		
		ingot = new Ingot(8009, 64, Tungsten.tungstenTab).setUnlocalizedName("tungstenIngot");
		molten = new Ingot(8010, 64, Tungsten.tungstenTab).setUnlocalizedName("tungstenMolten");
		
		//blocks
		
		ore = new Ore(3000, "tungstenOre").setUnlocalizedName("tungstenOre").setCreativeTab(Tungsten.tungstenTab).setHardness(5.0F).setStepSound(Block.soundGlassFootstep).setResistance(10.0F);
		block = new TBlock(3001, "tungstenBlock").setUnlocalizedName("tungstenBlock").setCreativeTab(Tungsten.tungstenTab).setHardness(8.0F).setStepSound(Block.soundGlassFootstep).setResistance(15.0F);
		moltenBlock = new MBlock(3002, "tungstenMoltenBlock").setUnlocalizedName("tungstenMoltenBlock").setCreativeTab(Tungsten.tungstenTab).setHardness(3.5F).setStepSound(Block.soundSnowFootstep).setResistance(10.0F);
		
		//plant nugget get 2-3 nuggets
		
		plant = new Plant(3003).setUnlocalizedName("tungstenPlant");
		nugget = new ItemSeedFood(8011, 0, 0.5F, plant.blockID, block.tilledField.blockID).setUnlocalizedName("tungstenNugget").setCreativeTab(tungstenTab).setTextureName("tungsten:nugget");
		
		//drop nugget in tall grass
		
		MinecraftForge.addGrassSeed(new ItemStack(Tungsten.nugget), 2);
				
	}
	
	@EventHandler
	public void load(FMLInitializationEvent event) {
		proxy.registerRenderers();
		proxy.registerBlocks();
		
		
		//crafting
		
		//tools
		
		GameRegistry.addRecipe(new ItemStack(Tungsten.pickaxe, 1), new Object[] {
			"mmm", " s ", " s ", 'm', Tungsten.molten, 's', Item.stick
		});
		GameRegistry.addRecipe(new ItemStack(Tungsten.axe, 1), new Object[] {
			"mm ", "ms ", " s ", 'm', Tungsten.molten, 's', Item.stick
		});
		GameRegistry.addRecipe(new ItemStack(Tungsten.axe, 1), new Object[] {
			" mm", " sm", " s ", 'm', Tungsten.molten, 's', Item.stick
		});
		GameRegistry.addRecipe(new ItemStack(Tungsten.sword, 1), new Object[] {
			"m", "m", "s", 'm', Tungsten.molten, 's', Item.stick
		});
		GameRegistry.addRecipe(new ItemStack(Tungsten.hoe, 1), new Object[] {
			"jj ", " s ", " s ", 'j', Tungsten.molten, 's', Item.stick
		});
		GameRegistry.addRecipe(new ItemStack(Tungsten.hoe, 1), new Object[] {
			" jj", " s ", " s ", 'j', Tungsten.molten, 's', Item.stick
		});
		GameRegistry.addRecipe(new ItemStack(Tungsten.shovel, 1), new Object[] {
			"m", "s", "s", 'm', Tungsten.molten, 's', Item.stick
		});
		

		/*
		GameRegistry.addRecipe(new ItemStack(LapisMod.lapisPickStrong, 1), new Object[] {
        	"lll", " s ", " s ", 'l', new ItemStack(Block.blockLapis, 1), 's', Item.stick
        });
        GameRegistry.addRecipe(new ItemStack(LapisMod.lapisAxeStrong, 1), new Object[] {
        	"ll ", "ls ", " s ", 'l', new ItemStack(Block.blockLapis, 1), 's', Item.stick
        });
        GameRegistry.addRecipe(new ItemStack(LapisMod.lapisAxeStrong, 1), new Object[] {
        	" ll", " sl", " s ", 'l', new ItemStack(Block.blockLapis, 1), 's', Item.stick
        });
        GameRegistry.addShapedRecipe(new ItemStack(LapisMod.lapisHoeStrong, 1), new Object[] {
        	" ll", " s ", " s ", 'l', new ItemStack(Block.blockLapis, 1), 's', Item.stick
        });
        GameRegistry.addShapedRecipe(new ItemStack(LapisMod.lapisHoeStrong, 1), new Object[] {
        	"ll ", " s ", " s ", 'l', new ItemStack(Block.blockLapis, 1), 's', Item.stick
        });
        GameRegistry.addRecipe(new ItemStack(LapisMod.lapisSwordStrong, 1), new Object[] {
        	"l", "l", "s", 'l', new ItemStack(Block.blockLapis, 1), 's', Item.stick
        });
        GameRegistry.addRecipe(new ItemStack(LapisMod.lapisShovelStrong, 1), new Object[] {
        	"l", "s", "s", 'l', new ItemStack(Block.blockLapis, 1), 's', Item.stick
        });
		*/

		


		//armor
		
		GameRegistry.addRecipe(new ItemStack(Tungsten.helmet, 1), new Object[] {
			"mmm", "m m", 'm', Tungsten.molten
		});
		GameRegistry.addRecipe(new ItemStack(Tungsten.chestplate, 1), new Object[] {
			"m m", "mmm", "mmm", 'm', Tungsten.molten
		});
		GameRegistry.addRecipe(new ItemStack(Tungsten.leggings, 1), new Object[] {
			"mmm", "m m", "m m", 'm', Tungsten.molten
		});
		GameRegistry.addRecipe(new ItemStack(Tungsten.boots, 1), new Object[] {
			"m m", "m m", 'm', Tungsten.molten
		});
		
		//block
		
		GameRegistry.addRecipe(new ItemStack(Tungsten.block, 1), new Object[] {
			"mmm", "mmm", "mmm", 'm', Tungsten.ingot
		});
		GameRegistry.addRecipe(new ItemStack(Tungsten.moltenBlock, 1), new Object[] {
			"mmm", "mmm", "mmm", 'm', Tungsten.molten
		});
		GameRegistry.addRecipe(new ItemStack(Tungsten.ingot, 9), new Object[] {
			"b", 'b', Tungsten.block
		});
		GameRegistry.addRecipe(new ItemStack(Tungsten.ingot, 9), new Object[] {
			"m", 'm', Tungsten.moltenBlock
		});
		GameRegistry.addRecipe(new ItemStack(Tungsten.nugget, 9), new Object[] {
			"i", 'i', Tungsten.ingot
		});
		GameRegistry.addRecipe(new ItemStack(Tungsten.ingot, 1), new Object[] {
			"nnn", "nnn", "nnn", 'n', Tungsten.nugget
		});
		GameRegistry.addRecipe(new ItemStack(Tungsten.ingot, 1), new Object[] {
			"m", 'm', Tungsten.molten
		});
		
		//smelting
		
		GameRegistry.addSmelting(ingot.itemID, new ItemStack(Tungsten.molten, 1), 7.0F);
		GameRegistry.addSmelting(ore.blockID, new ItemStack(Tungsten.ingot, 1), 7.0F);
		
		//world gen
		
		GameRegistry.registerWorldGenerator(new WorldGeneratorTungsten());
		
		//fuel
		
		GameRegistry.registerFuelHandler(new MoltenBlock());
		
		//names(items)
		
		LanguageRegistry.addName(ingot, "Tungsten Ingot");
		LanguageRegistry.addName(molten, "Molten Tungsten Ingot");
		LanguageRegistry.addName(nugget, "Tungsten Nugget");
		
		//names(tools)
		
		LanguageRegistry.addName(axe, "Tungsten Axe");
		LanguageRegistry.addName(sword, "Tungsten Sword");
		LanguageRegistry.addName(hoe, "Tungsten Hoe");
		LanguageRegistry.addName(shovel, "Tungsten Shovel");
		LanguageRegistry.addName(pickaxe, "Tungsten Pickaxe");
		
		//names(armor)
		
		LanguageRegistry.addName(helmet, "Tungsten Helmet");
		LanguageRegistry.addName(chestplate, "Tungsten Chestplate");
		LanguageRegistry.addName(leggings, "Tungsten Leggings");
		LanguageRegistry.addName(boots, "Tungsten Boots");
		
	}
}
