package quek.undergarden.registry;

import net.minecraft.item.Food;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class UGFoods {

    public static final Food UNDERBEANS = (new Food.Builder().hunger(3).saturation(0.2F).fastToEat().build());
    public static final Food BLISTERBERRY = (new Food.Builder().hunger(1).saturation(3).fastToEat().build());
    public static final Food GLOOMGOURD_PIE = (new Food.Builder()).hunger(8).saturation(0.3F).effect(() -> new EffectInstance(UGEffects.VIRULENT_RESISTANCE.get(), 600, 0, false, true), 1.0F).build();
    public static final Food RAW_DWELLER = (new Food.Builder().hunger(3).saturation(0.3F).meat().build());
    public static final Food COOKED_DWELLER = (new Food.Builder().hunger(8).saturation(0.8F).meat().build());
    public static final Food RAW_GLOOMPER_LEG = (new Food.Builder().hunger(2).saturation(0.5F).meat().build());
    public static final Food GLOOMPER_LEG = (new Food.Builder().hunger(6).saturation(1.0F).meat().effect(() -> new EffectInstance(Effects.JUMP_BOOST, 600, 0, false, true), 1.0F).build());
    public static final Food GOO_BALL = (new Food.Builder().hunger(0).saturation(0).setAlwaysEdible().effect(() -> new EffectInstance(UGEffects.GOOEY.get(), 600, 0, false, true), 1.0F).build());
    public static final Food RAW_GWIBLING = (new Food.Builder()).hunger(2).saturation(0.1F).build();
    public static final Food COOKED_GWIBLING = (new Food.Builder()).hunger(5).saturation(0.6F).build();
    public static final Food DROOPVINE = (new Food.Builder()).hunger(1).saturation(1).effect(() -> new EffectInstance(Effects.GLOWING, 600, 0, false, true), 1.0F).build();
    public static final Food BLOODY = (new Food.Builder())
            .hunger(4)
            .saturation(0.4F)
            .effect(() -> new EffectInstance(Effects.STRENGTH, 300, 0, false, true), 1.0F)
            .effect(() -> new EffectInstance(UGEffects.BRITTLENESS.get(), 300, 0, false, true), 1.0F)
            .setAlwaysEdible()
            .build();
    public static final Food INKY = (new Food.Builder())
            .hunger(4)
            .saturation(0.4F)
            .effect(() -> new EffectInstance(Effects.BLINDNESS, 300, 0, false, true), 1.0F)
            .effect(() -> new EffectInstance(Effects.RESISTANCE, 300, 0, false, true), 1.0F)
            .setAlwaysEdible()
            .build();
    public static final Food INDIGO = (new Food.Builder())
            .hunger(4)
            .saturation(0.4F)
            .effect(() -> new EffectInstance(Effects.NIGHT_VISION, 300, 0, false, true), 1.0F)
            .effect(() -> new EffectInstance(Effects.SLOWNESS, 300, 0, false, true), 1.0F)
            .setAlwaysEdible()
            .build();
    public static final Food VEILED = (new Food.Builder())
            .hunger(4)
            .saturation(0.4F)
            .effect(() -> new EffectInstance(Effects.SLOW_FALLING, 300, 0, false, true), 1.0F)
            .effect(() -> new EffectInstance(UGEffects.FEATHERWEIGHT.get(), 300, 0, false, true), 1.0F)
            .setAlwaysEdible()
            .build();
}