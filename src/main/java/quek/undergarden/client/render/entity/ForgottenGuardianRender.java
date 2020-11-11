package quek.undergarden.client.render.entity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import quek.undergarden.UGMod;
import quek.undergarden.client.model.ForgottenGuardianModel;
import quek.undergarden.client.render.layer.ForgottenGuardianEyesLayer;
import quek.undergarden.entity.boss.ForgottenGuardianEntity;

@OnlyIn(Dist.CLIENT)
public class ForgottenGuardianRender extends MobRenderer<ForgottenGuardianEntity, ForgottenGuardianModel<ForgottenGuardianEntity>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(UGMod.MODID, "textures/entity/forgotten_guardian.png");

    public ForgottenGuardianRender(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ForgottenGuardianModel<>(), 0.6F);
        this.addLayer(new ForgottenGuardianEyesLayer<>(this));
    }

    @Override
    public ResourceLocation getEntityTexture(ForgottenGuardianEntity entity) {
        return TEXTURE;
    }
}
