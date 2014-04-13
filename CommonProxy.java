package populo.mod.tungsten;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class CommonProxy {

	public void registerRenderers() {
		
	}
	
	public void registerBlocks() {
		
		//ore
		
		GameRegistry.registerBlock(Tungsten.ore, "tungstenOre");
		LanguageRegistry.addName(Tungsten.ore, "Tungsten Ore");
		
		//block
		
		GameRegistry.registerBlock(Tungsten.block, "tungstenBlock");
		LanguageRegistry.addName(Tungsten.block, "Tungsten Block");
		
		//molten block
		
		GameRegistry.registerBlock(Tungsten.moltenBlock, "tungstenMoltenBlock");
		LanguageRegistry.addName(Tungsten.moltenBlock, "Molten Tungsten Block");
		
		//plant
		
		GameRegistry.registerBlock(Tungsten.plant, "tungstenPlant");
		LanguageRegistry.addName(Tungsten.plant, "Tungsten Plant");
	}
	
}
