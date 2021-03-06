package quek.undergarden.client.model;
// Made with Blockbench 3.6.3
// Exported for Minecraft version 1.15

import com.google.common.collect.ImmutableSet;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import quek.undergarden.entity.boss.MasticatorEntity;

@OnlyIn(Dist.CLIENT)
public class MasticatorModel<T extends MasticatorEntity> extends SegmentedModel<T> {
	private final ModelRenderer masticator;
	private final ModelRenderer head;
	private final ModelRenderer upperjaw;
	private final ModelRenderer lowerjaw;
	private final ModelRenderer innerupperjaw;
	private final ModelRenderer innerlowerjaw;
	private final ModelRenderer leftarm;
	private final ModelRenderer lowerarm2;
	private final ModelRenderer frontfingers2;
	private final ModelRenderer backfinger2;
	private final ModelRenderer rightarm;
	private final ModelRenderer lowerarm;
	private final ModelRenderer frontfingers;
	private final ModelRenderer backfinger;
	private final ModelRenderer body;
	private final ModelRenderer torso;
	private final ModelRenderer waist2;
	private final ModelRenderer rightleg;
	private final ModelRenderer bone2;
	private final ModelRenderer leftleg;
	private final ModelRenderer bone;

	public MasticatorModel() {
		textureWidth = 256;
		textureHeight = 256;

		masticator = new ModelRenderer(this);
		masticator.setRotationPoint(0.0F, -21.0F, -10.0F);
		

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, -3.0F, 1.0F);
		masticator.addChild(head);
		head.setTextureOffset(70, 46).addBox(7.0F, -6.0F, -4.0F, 0.0F, 10.0F, 5.0F, 0.0F, false);
		head.setTextureOffset(51, 83).addBox(-7.0F, -6.0F, -4.0F, 0.0F, 10.0F, 5.0F, 0.0F, false);

		upperjaw = new ModelRenderer(this);
		upperjaw.setRotationPoint(0.0F, -2.0F, 1.0F);
		head.addChild(upperjaw);
		upperjaw.setTextureOffset(0, 20).addBox(-6.0F, 0.0F, -17.0F, 12.0F, 3.0F, 0.0F, 0.0F, false);
		upperjaw.setTextureOffset(51, 62).addBox(6.0F, 0.0F, -17.0F, 0.0F, 3.0F, 17.0F, 0.0F, false);
		upperjaw.setTextureOffset(51, 65).addBox(-6.0F, 0.0F, -17.0F, 0.0F, 3.0F, 17.0F, 0.0F, false);
		upperjaw.setTextureOffset(86, 0).addBox(-9.0F, -6.0F, -18.0F, 18.0F, 6.0F, 18.0F, 0.0F, false);
		upperjaw.setTextureOffset(70, 51).addBox(-18.0F, -5.0F, -17.0F, 36.0F, 4.0F, 12.0F, 0.0F, false);

		lowerjaw = new ModelRenderer(this);
		lowerjaw.setRotationPoint(0.0F, 2.0F, 1.0F);
		head.addChild(lowerjaw);
		lowerjaw.setTextureOffset(112, 46).addBox(-5.0F, -3.0F, -16.0F, 10.0F, 3.0F, 0.0F, 0.0F, false);
		lowerjaw.setTextureOffset(88, 56).addBox(5.0F, -3.0F, -16.0F, 0.0F, 3.0F, 16.0F, 0.0F, false);
		lowerjaw.setTextureOffset(51, 69).addBox(-5.0F, -3.0F, -16.0F, 0.0F, 3.0F, 16.0F, 0.0F, false);
		lowerjaw.setTextureOffset(112, 24).addBox(-8.0F, 0.0F, -18.0F, 16.0F, 4.0F, 18.0F, 0.0F, false);

		innerupperjaw = new ModelRenderer(this);
		innerupperjaw.setRotationPoint(0.0F, -1.0F, 0.0F);
		head.addChild(innerupperjaw);
		innerupperjaw.setTextureOffset(86, 0).addBox(-4.0F, -1.0F, -7.0F, 8.0F, 2.0F, 0.0F, 0.0F, false);
		innerupperjaw.setTextureOffset(0, 57).addBox(4.0F, -1.0F, -7.0F, 0.0F, 2.0F, 8.0F, 0.0F, false);
		innerupperjaw.setTextureOffset(0, 15).addBox(-4.0F, -1.0F, -7.0F, 0.0F, 2.0F, 8.0F, 0.0F, false);

		innerlowerjaw = new ModelRenderer(this);
		innerlowerjaw.setRotationPoint(0.0F, 1.0F, 1.0F);
		head.addChild(innerlowerjaw);
		innerlowerjaw.setTextureOffset(86, 2).addBox(-4.0F, -1.0F, -8.0F, 8.0F, 2.0F, 0.0F, 0.0F, false);
		innerlowerjaw.setTextureOffset(0, 59).addBox(4.0F, -1.0F, -8.0F, 0.0F, 2.0F, 8.0F, 0.0F, false);
		innerlowerjaw.setTextureOffset(70, 59).addBox(-4.0F, -1.0F, -8.0F, 0.0F, 2.0F, 8.0F, 0.0F, false);

		leftarm = new ModelRenderer(this);
		leftarm.setRotationPoint(16.0F, -8.0F, 17.0F);
		masticator.addChild(leftarm);
		setRotationAngle(leftarm, 0.1745F, 0.0F, 0.0F);
		leftarm.setTextureOffset(0, 79).addBox(-1.0F, -9.0F, -10.0F, 16.0F, 19.0F, 19.0F, 0.0F, false);
		leftarm.setTextureOffset(37, 141).addBox(0.0F, 9.8177F, -2.0838F, 14.0F, 17.0F, 7.0F, 0.0F, false);

		lowerarm2 = new ModelRenderer(this);
		lowerarm2.setRotationPoint(7.5F, 26.8053F, 2.7052F);
		leftarm.addChild(lowerarm2);
		setRotationAngle(lowerarm2, -0.6981F, 0.0F, 0.0F);
		lowerarm2.setTextureOffset(0, 117).addBox(-8.0F, -1.0F, -5.5F, 15.0F, 21.0F, 7.0F, 0.0F, false);

		frontfingers2 = new ModelRenderer(this);
		frontfingers2.setRotationPoint(-1.0F, 20.0F, -4.0F);
		lowerarm2.addChild(frontfingers2);
		setRotationAngle(frontfingers2, 0.3491F, 0.0F, 0.0F);
		frontfingers2.setTextureOffset(140, 0).addBox(-6.5F, -1.0718F, -1.2052F, 14.0F, 13.0F, 4.0F, 0.0F, false);

		backfinger2 = new ModelRenderer(this);
		backfinger2.setRotationPoint(-1.0F, 9.1736F, 9.0152F);
		frontfingers2.addChild(backfinger2);
		setRotationAngle(backfinger2, 0.3491F, 0.0F, 0.0F);
		backfinger2.setTextureOffset(10, 145).addBox(-5.5F, -13.1232F, -1.1605F, 6.0F, 14.0F, 4.0F, 0.0F, false);

		rightarm = new ModelRenderer(this);
		rightarm.setRotationPoint(-16.0F, -8.0F, 17.0F);
		masticator.addChild(rightarm);
		setRotationAngle(rightarm, 0.1745F, 0.0F, 0.0F);
		rightarm.setTextureOffset(51, 103).addBox(-15.0F, -9.0F, -10.0F, 16.0F, 19.0F, 19.0F, 0.0F, false);
		rightarm.setTextureOffset(79, 141).addBox(-14.0F, 9.8177F, -2.0838F, 14.0F, 17.0F, 7.0F, 0.0F, false);

		lowerarm = new ModelRenderer(this);
		lowerarm.setRotationPoint(-7.5F, 26.8053F, 2.7052F);
		rightarm.addChild(lowerarm);
		setRotationAngle(lowerarm, -0.6981F, 0.0F, 0.0F);
		lowerarm.setTextureOffset(121, 121).addBox(-7.0F, -1.0F, -5.5F, 15.0F, 21.0F, 7.0F, 0.0F, false);

		frontfingers = new ModelRenderer(this);
		frontfingers.setRotationPoint(1.0F, 20.0F, -4.0F);
		lowerarm.addChild(frontfingers);
		setRotationAngle(frontfingers, 0.3491F, 0.0F, 0.0F);
		frontfingers.setTextureOffset(144, 67).addBox(-7.5F, -1.0718F, -1.2052F, 14.0F, 13.0F, 4.0F, 0.0F, false);

		backfinger = new ModelRenderer(this);
		backfinger.setRotationPoint(1.0F, 9.1736F, 9.0152F);
		frontfingers.addChild(backfinger);
		setRotationAngle(backfinger, 0.3491F, 0.0F, 0.0F);
		backfinger.setTextureOffset(121, 149).addBox(-0.5F, -13.1232F, -1.1605F, 6.0F, 14.0F, 4.0F, 0.0F, false);

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, -6.0F, 20.0F);
		masticator.addChild(body);
		body.setTextureOffset(75, 75).addBox(-14.0F, -6.0F, -18.0F, 28.0F, 15.0F, 13.0F, 0.0F, false);
		body.setTextureOffset(0, 51).addBox(-13.0F, 7.0F, -7.0F, 26.0F, 10.0F, 18.0F, 0.0F, false);

		torso = new ModelRenderer(this);
		torso.setRotationPoint(0.0F, 4.0F, -13.0F);
		body.addChild(torso);
		setRotationAngle(torso, 0.4363F, 0.0F, 0.0F);
		torso.setTextureOffset(0, 0).addBox(-15.0F, -11.0F, 0.0F, 30.0F, 25.0F, 26.0F, 0.0F, false);
		torso.setTextureOffset(88, 43).addBox(0.0F, -16.0F, 2.0F, 0.0F, 5.0F, 24.0F, 0.0F, false);
		torso.setTextureOffset(0, 140).addBox(0.0F, -16.0F, 26.0F, 0.0F, 25.0F, 5.0F, 0.0F, false);

		waist2 = new ModelRenderer(this);
		waist2.setRotationPoint(0.0F, 17.0F, -5.0F);
		body.addChild(waist2);
		setRotationAngle(waist2, -0.3491F, 0.0F, 0.0F);
		waist2.setTextureOffset(102, 103).addBox(-10.0F, -4.2F, -1.5F, 20.0F, 5.0F, 12.0F, 0.0F, false);

		rightleg = new ModelRenderer(this);
		rightleg.setRotationPoint(-6.0F, 17.0F, -4.0F);
		body.addChild(rightleg);
		setRotationAngle(rightleg, -0.2618F, 0.0F, 0.0F);
		rightleg.setTextureOffset(0, 0).addBox(-2.0F, -3.0F, 0.0F, 4.0F, 15.0F, 5.0F, 0.0F, false);

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(0.0F, 13.0F, 2.0F);
		rightleg.addChild(bone2);
		setRotationAngle(bone2, 0.3491F, 0.0F, 0.0F);
		bone2.setTextureOffset(0, 51).addBox(-1.5F, -1.5111F, -1.1177F, 3.0F, 10.0F, 4.0F, 0.0F, false);

		leftleg = new ModelRenderer(this);
		leftleg.setRotationPoint(6.0F, 17.0F, -4.0F);
		body.addChild(leftleg);
		setRotationAngle(leftleg, -0.2618F, 0.0F, 0.0F);
		leftleg.setTextureOffset(141, 149).addBox(-2.0F, -3.0F, 0.0F, 4.0F, 15.0F, 5.0F, 0.0F, false);

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 13.0F, 2.0F);
		leftleg.addChild(bone);
		setRotationAngle(bone, 0.3491F, 0.0F, 0.0F);
		bone.setTextureOffset(0, 79).addBox(-1.5F, -1.5111F, -1.1177F, 3.0F, 10.0F, 4.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		this.head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
		this.head.rotateAngleX = headPitch * ((float)Math.PI / 180F);

		float flap = MathHelper.sin((entity.ticksExisted) * 0.3F) * 0.3F;
		this.lowerjaw.rotateAngleX = flap * 0.70F;

		this.leftarm.rotateAngleX = MathHelper.cos(limbSwing * 0.5F) * 1.4F * limbSwingAmount;

		this.rightarm.rotateAngleX = MathHelper.cos(limbSwing * 0.5F + (float)Math.PI) * 1.4F * limbSwingAmount;
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		masticator.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	@Override
	public Iterable<ModelRenderer> getParts() {
		return ImmutableSet.of(masticator);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}