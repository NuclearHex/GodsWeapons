package com.hexagon.world;

import java.util.Random;

import com.hexagon.block.ModBlocks;

import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class ModWorldGenerator implements IWorldGenerator{

	private WorldGenerator dark_steel_ore; 

	public ModWorldGenerator() {
	    this.dark_steel_ore = new WorldGenMinable(ModBlocks.dark_steel_ore.getDefaultState(), 4);
	}
	 
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator arg4, IChunkProvider arg5) {
		switch (world.provider.getDimension()) {
	    case 0: 
	    	this.runGenerator(this.dark_steel_ore, world, random, chunkX, chunkZ, 15, 10, 25);
	        break;
	    case -1: 

	        break;
	    case 1: 

	        break;
	    }
	}
	
	private void runGenerator(WorldGenerator generator, World world, Random rand, int chunk_X, int chunk_Z, int chancesToSpawn, int minHeight, int maxHeight) {
	    if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight)
	        throw new IllegalArgumentException("Illegal Height Arguments for WorldGenerator");

	    int heightDiff = maxHeight - minHeight + 1;
	    for (int i = 0; i < chancesToSpawn; i ++) {
	        int x = chunk_X * 16 + rand.nextInt(16);
	        int y = minHeight + rand.nextInt(heightDiff);
	        int z = chunk_Z * 16 + rand.nextInt(16);
	        generator.generate(world, rand, new BlockPos(x, y, z));
	    }
	}
}
