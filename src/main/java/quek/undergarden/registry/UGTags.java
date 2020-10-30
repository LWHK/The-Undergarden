package quek.undergarden.registry;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.*;
import net.minecraft.util.ResourceLocation;
import quek.undergarden.UGMod;

public class UGTags {

    public static class Items {

        public static final ITag.INamedTag<Item> MUSHROOMS = tag("mushrooms");

        public static final ITag.INamedTag<Item> CLOGGRUM_ITEMS = tag("cloggrum_items");
        public static final ITag.INamedTag<Item> FROSTSTEEL_ITEMS = tag("froststeel_items");
        public static final ITag.INamedTag<Item> UTHERIUM_ITEMS = tag("utherium_items");

        private static ITag.INamedTag<Item> tag(String name) {
            return ItemTags.makeWrapperTag(new ResourceLocation(UGMod.MODID, name).toString());
        }

    }

    public static class Blocks {

        public static final ITag.INamedTag<Block> PORTAL_FRAME_BLOCKS = tag("portal_frame_blocks");

        private static ITag.INamedTag<Block> tag(String name) {
            return BlockTags.makeWrapperTag(new ResourceLocation(UGMod.MODID, name).toString());
        }

    }

}
