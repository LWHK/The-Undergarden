package quek.undergarden.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.Vector3f;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import quek.undergarden.UndergardenMod;
import quek.undergarden.client.render.layer.RotwalkerEyesLayer;
import quek.undergarden.entity.RotwalkerEntity;
import quek.undergarden.client.model.RotwalkerModel;

public class RotwalkerRender extends MobRenderer<RotwalkerEntity, RotwalkerModel<RotwalkerEntity>> {

    private static final ResourceLocation texture = new ResourceLocation(UndergardenMod.MODID, "textures/entities/rotwalker.png");

    public RotwalkerRender(EntityRendererManager manager) {
        super(manager, new RotwalkerModel(), 0.6f);
        this.addLayer(new RotwalkerEyesLayer<>(this));
    }

    @Override
    public ResourceLocation getEntityTexture(RotwalkerEntity entity) {
        return texture;
    }

    @Override
    public void applyRotations(RotwalkerEntity entityLiving, MatrixStack matrixStackIn, float ageInTicks, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, matrixStackIn, ageInTicks, rotationYaw, partialTicks);
        if (!((double)entityLiving.limbSwingAmount < 0.01D)) {
            float f = 13.0F;
            float f1 = entityLiving.limbSwing - entityLiving.limbSwingAmount * (1.0F - partialTicks) + 6.0F;
            float f2 = (Math.abs(f1 % 13.0F - 6.5F) - 3.25F) / 3.25F;
            matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(6.5F * f2));
        }
    }
}
