package quek.undergarden.world.gen.feature;

import com.mojang.serialization.Codec;
import net.minecraft.block.AbstractTopPlantBlock;
import net.minecraft.block.BlockState;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.StructureManager;
import quek.undergarden.block.world.DroopvineBlock;
import quek.undergarden.registry.UndergardenBlocks;

import java.util.Random;

public class DroopvineFeature extends Feature<NoFeatureConfig> {

    private static final Direction[] directionArray = Direction.values();

    public DroopvineFeature(Codec<NoFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public boolean func_230362_a_(ISeedReader seedReader, StructureManager structureManager, ChunkGenerator chunkGenerator, Random rand, BlockPos pos, NoFeatureConfig config) {
        if (!seedReader.isAirBlock(pos)) {
            return false;
        } else {
            BlockState blockstate = seedReader.getBlockState(pos.up());
            if (!blockstate.isIn(UndergardenBlocks.depthrock.get()) && !blockstate.isIn(UndergardenBlocks.shiverstone.get())) {
                return false;
            } else {
                this.func_236428_a_(seedReader, rand, pos);
                this.func_236429_b_(seedReader, rand, pos);
                return true;
            }
        }
    }

    private void func_236428_a_(IWorld world, Random rand, BlockPos pos) {
        //world.setBlockState(pos, UndergardenBlocks.depthrock.get().getDefaultState(), 2);
        BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();
        BlockPos.Mutable blockpos$mutable1 = new BlockPos.Mutable();

        for(int i = 0; i < 200; ++i) {
            blockpos$mutable.func_239621_a_(pos, rand.nextInt(6) - rand.nextInt(6), rand.nextInt(2) - rand.nextInt(5), rand.nextInt(6) - rand.nextInt(6));
            if (world.isAirBlock(blockpos$mutable)) {
                int j = 0;

                for(Direction direction : directionArray) {
                    BlockState blockstate = world.getBlockState(blockpos$mutable1.func_239622_a_(blockpos$mutable, direction));
                    if (blockstate.isIn(UndergardenBlocks.depthrock.get()) || blockstate.isIn(UndergardenBlocks.shiverstone.get())) {
                        ++j;
                    }

                    if (j > 1) {
                        break;
                    }
                }

                //if (j == 1) {
                //    world.setBlockState(blockpos$mutable, UndergardenBlocks.depthrock.get().getDefaultState(), 2);
                //}
            }
        }

    }

    private void func_236429_b_(IWorld world, Random rand, BlockPos pos) {
        BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();

        for(int i = 0; i < 100; ++i) {
            blockpos$mutable.func_239621_a_(pos, rand.nextInt(8) - rand.nextInt(8), rand.nextInt(2) - rand.nextInt(7), rand.nextInt(8) - rand.nextInt(8));
            if (world.isAirBlock(blockpos$mutable)) {
                BlockState blockstate = world.getBlockState(blockpos$mutable.up());
                if (blockstate.isIn(UndergardenBlocks.depthrock.get()) || blockstate.isIn(UndergardenBlocks.shiverstone.get())) {
                    int j = MathHelper.nextInt(rand, 1, 8);
                    if (rand.nextInt(6) == 0) {
                        j *= 2;
                    }

                    if (rand.nextInt(5) == 0) {
                        j = 1;
                    }

                    placeDroopvine(world, rand, blockpos$mutable, j * 4, 17, 25);
                }
            }
        }

    }

    public static void placeDroopvine(IWorld world, Random rand, BlockPos.Mutable posMutable, int x, int y, int z) {
        for(int i = 0; i <= x; ++i) {
            if (world.isAirBlock(posMutable)) {
                if (i == x || !world.isAirBlock(posMutable.down())) {
                    world.setBlockState(posMutable, UndergardenBlocks.droopvine_top.get().getDefaultState().with(AbstractTopPlantBlock.field_235502_d_, MathHelper.nextInt(rand, y, z)), 2);
                    break;
                }

                world.setBlockState(posMutable, UndergardenBlocks.droopvine.get().getDefaultState().with(DroopvineBlock.GLOWY, DroopvineBlock.randomTorF()), 2);
            }

            posMutable.move(Direction.DOWN);
        }

    }
}