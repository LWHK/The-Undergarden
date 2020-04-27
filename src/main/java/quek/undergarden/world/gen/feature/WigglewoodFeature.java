package quek.undergarden.world.gen.feature;

import com.mojang.datafixers.Dynamic;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.AbstractSmallTreeFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import quek.undergarden.registry.UndergardenBlocks;

import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.function.Function;

public class WigglewoodFeature extends AbstractSmallTreeFeature<TreeFeatureConfig> {

    public WigglewoodFeature(Function<Dynamic<?>, ? extends TreeFeatureConfig> p_i225798_1_) {
        super(p_i225798_1_);
    }

    @Override
    public boolean func_225557_a_(IWorldGenerationReader p_225557_1_, Random p_225557_2_, BlockPos p_225557_3_, Set<BlockPos> p_225557_4_, Set<BlockPos> p_225557_5_, MutableBoundingBox p_225557_6_, TreeFeatureConfig p_225557_7_) {
        int i = p_225557_7_.baseHeight + p_225557_2_.nextInt(p_225557_7_.heightRandA + 1) + p_225557_2_.nextInt(p_225557_7_.heightRandB + 1);
        int j = p_225557_7_.trunkHeight >= 0 ? p_225557_7_.trunkHeight + p_225557_2_.nextInt(p_225557_7_.trunkHeightRandom + 1) : i - (p_225557_7_.foliageHeight + p_225557_2_.nextInt(p_225557_7_.foliageHeightRandom + 1));
        int k = p_225557_7_.foliagePlacer.func_225573_a_(p_225557_2_, j, i, p_225557_7_);
        Optional<BlockPos> optional = this.func_227212_a_(p_225557_1_, i, j, k, p_225557_3_, p_225557_7_);
        if (!optional.isPresent()) {
            return false;
        } else {
            BlockPos blockpos = optional.get();
            //this.setDirtAt(p_225557_1_, blockpos.down(), blockpos);
            Direction direction = Direction.Plane.HORIZONTAL.random(p_225557_2_);
            int l = i - p_225557_2_.nextInt(4) - 1;
            int i1 = 3 - p_225557_2_.nextInt(3);
            BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();
            int j1 = blockpos.getX();
            int k1 = blockpos.getZ();
            int l1 = 0;

            for(int i2 = 0; i2 < i; ++i2) {
                int j2 = blockpos.getY() + i2;
                if (i2 >= l && i1 > 0) {
                    j1 += direction.getXOffset();
                    k1 += direction.getZOffset();
                    --i1;
                }

                if (this.func_227216_a_(p_225557_1_, p_225557_2_, blockpos$mutable.setPos(j1, j2, k1), p_225557_4_, p_225557_6_, p_225557_7_)) {
                    l1 = j2;
                }
            }

            BlockPos blockpos1 = new BlockPos(j1, l1, k1);
            p_225557_7_.foliagePlacer.func_225571_a_(p_225557_1_, p_225557_2_, p_225557_7_, i, j, k + 1, blockpos1, p_225557_5_);
            j1 = blockpos.getX();
            k1 = blockpos.getZ();
            Direction direction1 = Direction.Plane.HORIZONTAL.random(p_225557_2_);
            if (direction1 != direction) {
                int j3 = l - p_225557_2_.nextInt(2) - 1;
                int k2 = 1 + p_225557_2_.nextInt(3);
                l1 = 0;

                for(int l2 = j3; l2 < i && k2 > 0; --k2) {
                    if (l2 >= 1) {
                        int i3 = blockpos.getY() + l2;
                        j1 += direction1.getXOffset();
                        k1 += direction1.getZOffset();
                        if (this.func_227216_a_(p_225557_1_, p_225557_2_, blockpos$mutable.setPos(j1, i3, k1), p_225557_4_, p_225557_6_, p_225557_7_)) {
                            l1 = i3;
                        }
                    }

                    ++l2;
                }

                if (l1 > 0) {
                    BlockPos blockpos2 = new BlockPos(j1, l1, k1);
                    p_225557_7_.foliagePlacer.func_225571_a_(p_225557_1_, p_225557_2_, p_225557_7_, i, j, k, blockpos2, p_225557_5_);
                }
            }

            return true;
        }
    }

    protected void setDirt(IWorldGenerationReader generationReader, BlockPos pos) {
        if (!isDirt(generationReader, pos)) {
            this.setBlockState(generationReader, pos, UndergardenBlocks.deepsoil.get().getDefaultState());
        }
    }

    protected void setDirtAt(IWorldGenerationReader reader, BlockPos pos, BlockPos origin) {
        if (!(reader instanceof IWorld)) {
            setDirt(reader, pos);
            return;
        }
        ((IWorld)reader).getBlockState(pos).onPlantGrow((IWorld)reader, pos, origin);
    }

    @Override
    public Optional<BlockPos> func_227212_a_(IWorldGenerationReader generationReader, int baseHeight, int trunkHeight, int foliagePlacer, BlockPos pos, TreeFeatureConfig treeFeatureConfigIn) {
        BlockPos blockpos = pos;

        return isSoilOrFarm(generationReader, blockpos.down(), treeFeatureConfigIn.getSapling()) && blockpos.getY() < generationReader.getMaxHeight() - baseHeight - 1 ? Optional.of(blockpos) : Optional.empty();

        /*
        if (blockpos.getY() >= 1 && blockpos.getY() + baseHeight + 1 <= generationReader.getMaxHeight()) {
            for(int i1 = 0; i1 <= baseHeight + 1; ++i1) {
                int j1 = treeFeatureConfigIn.foliagePlacer.func_225570_a_(trunkHeight, baseHeight, foliagePlacer, i1);
                BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();

                for(int k = -j1; k <= j1; ++k) {
                    int l = -j1;

                    while(l <= j1) {
                        if (i1 + blockpos.getY() >= 0 && i1 + blockpos.getY() < generationReader.getMaxHeight()) {
                            blockpos$mutable.setPos(k + blockpos.getX(), i1 + blockpos.getY(), l + blockpos.getZ());
                            if (func_214587_a(generationReader, blockpos$mutable) && (treeFeatureConfigIn.ignoreVines || !func_227222_d_(generationReader, blockpos$mutable))) {
                                ++l;
                                continue;
                            }

                            return Optional.empty();
                        }

                        return Optional.empty();
                    }
                }
            }

            return isSoilOrFarm(generationReader, blockpos.down(), treeFeatureConfigIn.getSapling()) && blockpos.getY() < generationReader.getMaxHeight() - baseHeight - 1 ? Optional.of(blockpos) : Optional.empty();
        } else {
            return Optional.empty();
        }

         */
    }
}