package quek.undergarden.block;

import net.minecraft.block.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import quek.undergarden.registry.UGBlocks;
import quek.undergarden.registry.UGItems;

import javax.annotation.Nullable;
import java.util.Random;

public class UGStemBlock extends StemBlock {

    public static final IntegerProperty AGE = BlockStateProperties.AGE_0_7;
    private final StemGrownBlock crop;

    public UGStemBlock(StemGrownBlock crop, AbstractBlock.Properties properties) {
        super(crop, properties);
        this.crop = crop;
    }


    @Override
    public boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return state.getBlock() == UGBlocks.DEEPSOIL_FARMLAND.get();
    }

    @Override
    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
        BlockPos blockpos = pos.down();
        return isValidGround(worldIn.getBlockState(blockpos), worldIn, blockpos);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        if (!worldIn.isAreaLoaded(pos, 1))
            return; // Forge: prevent loading unloaded chunks when checking neighbor's light
        float f = CropsBlock.getGrowthChance(this, worldIn, pos);
        if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, random.nextInt((int) (25.0F / f) + 1) == 0)) {
            int i = state.get(AGE);
            if (i < 7) {
                worldIn.setBlockState(pos, state.with(AGE, i + 1), 2);
            } else {
                Direction direction = Direction.Plane.HORIZONTAL.random(random);
                BlockPos blockpos = pos.offset(direction);
                BlockState blockstate = worldIn.getBlockState(blockpos.down());
                Block block = blockstate.getBlock();
                if (worldIn.isAirBlock(blockpos) && (blockstate.canSustainPlant(worldIn, blockpos.down(), Direction.UP, this) || block == UGBlocks.DEEPSOIL_FARMLAND.get() || block == UGBlocks.DEEPSOIL.get() || block == UGBlocks.COARSE_DEEPSOIL.get() || block == UGBlocks.DEEPTURF_BLOCK.get())) {
                    worldIn.setBlockState(blockpos, this.crop.getDefaultState());
                    worldIn.setBlockState(pos, this.crop.getAttachedStem().getDefaultState().with(HorizontalBlock.HORIZONTAL_FACING, direction));
                }
            }
            net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos, state);
        }
    }

    @Nullable
    @OnlyIn(Dist.CLIENT)
    protected Item getSeedItem() {
        return UGItems.GLOOMGOURD_SEEDS.get();
    }

    @Override
    public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
        Item item = this.getSeedItem();
        return item == null ? ItemStack.EMPTY : new ItemStack(item);
    }
}
