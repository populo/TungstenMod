package populo.mod.tungsten.world;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import populo.mod.tungsten.Tungsten;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGeneratorTungsten implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		
		switch(world.provider.dimensionId){
		case -1:
			generateNether(world, random, chunkX*16,chunkZ*16);
		case 0 :
			generateSurface(world, random, chunkX*16,chunkZ*16);
		case 1:
			generateEnd(world, random, chunkX*16,chunkZ*16);
		}
	}
	
	private void generateNether(World world, Random random, int x, int y) {
		
	}
	
	private void generateSurface(World world, Random random, int x, int y) {
		this.addOreSpawn(Tungsten.ore, world, random, x, y, 16, 16, 3+random.nextInt(5), 14, 0, 100);
		this.addOreSpawn(Tungsten.block, world, random, x, y, 16, 16, 1+random.nextInt(2), 5, 0, 30);
	}
	
	private void generateEnd(World world, Random random, int x, int y) {
		
	}

	public void addOreSpawn(Block block, World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize, int chancesToSpawn, int minY, int maxY){
		for(int i = 0; i < chancesToSpawn; i++) {
			int posX = blockXPos + random.nextInt(maxX);
			int posY = minY + random.nextInt(maxY - minY);
			int posZ = blockZPos + random.nextInt(maxZ);
			(new WorldGenMinable(block.blockID, maxVeinSize)).generate(world, random, posX, posY, posZ);
		}
	}
	
}
