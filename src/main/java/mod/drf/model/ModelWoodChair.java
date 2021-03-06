// Date: 2018/03/30 22:13:00
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX






package mod.drf.model;

import mod.drf.entity.EntityWoodChair;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;

public class ModelWoodChair extends EntityModel<EntityWoodChair>
{
  //fields
    RendererModel Leg1;
    RendererModel Leg2;
    RendererModel Leg3;
    RendererModel Leg4;
    RendererModel Base;
    RendererModel BackPoll1;
    RendererModel BackPoll2;
    RendererModel Back;
    RendererModel BackPollInner1;
    RendererModel BackPollInner2;
    RendererModel BackPollInner3;

  public ModelWoodChair()
  {
    textureWidth = 64;
    textureHeight = 64;

    Leg1 = new RendererModel(this, 0, 35);
    Leg1.addBox(0F, 0F, 0F, 2, 12, 2);
    Leg1.setRotationPoint(5F, -12F, 5F);
    Leg1.setTextureSize(64, 64);
    Leg1.mirror = true;
    setRotation(Leg1, 0F, 0F, 0F);
    Leg2 = new RendererModel(this, 8, 35);
    Leg2.addBox(0F, 0F, 0F, 2, 12, 2);
    Leg2.setRotationPoint(5F, -12F, -6F);
    Leg2.setTextureSize(64, 64);
    Leg2.mirror = true;
    setRotation(Leg2, 0F, 0F, 0F);
    Leg3 = new RendererModel(this, 16, 35);
    Leg3.addBox(0F, 0F, 0F, 2, 12, 2);
    Leg3.setRotationPoint(-7F, -12F, -6F);
    Leg3.setTextureSize(64, 64);
    Leg3.mirror = true;
    setRotation(Leg3, 0F, 0F, 0F);
    Leg4 = new RendererModel(this, 24, 35);
    Leg4.addBox(0F, 0F, 0F, 2, 12, 2);
    Leg4.setRotationPoint(-7F, -12F, 5F);
    Leg4.setTextureSize(64, 64);
    Leg4.mirror = true;
    setRotation(Leg4, 0F, 0F, 0F);
    Base = new RendererModel(this, 0, 0);
    Base.addBox(-8F, -2F, -8F, 16, 2, 16);
    Base.setRotationPoint(0F, -12F, 0F);
    Base.setTextureSize(64, 64);
    Base.mirror = true;
    setRotation(Base, 0F, 0F, 0F);
    BackPoll1 = new RendererModel(this, 40, 35);
    BackPoll1.addBox(5F, -20F, 6F, 2, 18, 1);
    BackPoll1.setRotationPoint(0F, -12F, 0F);
    BackPoll1.setTextureSize(64, 64);
    BackPoll1.mirror = true;
    setRotation(BackPoll1, -0.1134464F, 0F, 0F);
    BackPoll2 = new RendererModel(this, 34, 35);
    BackPoll2.addBox(-7F, -20F, 6F, 2, 18, 1);
    BackPoll2.setRotationPoint(0F, -12F, 0F);
    BackPoll2.setTextureSize(64, 64);
    BackPoll2.mirror = true;
    setRotation(BackPoll2, -0.1134464F, 0F, 0F);
    Back = new RendererModel(this, 0, 20);
    Back.addBox(-5F, -21F, 6F, 10, 9, 1);
    Back.setRotationPoint(0F, -12F, 0F);
    Back.setTextureSize(64, 64);
    Back.mirror = true;
    setRotation(Back, -0.1134464F, 0F, 0F);
    BackPollInner1 = new RendererModel(this, 27, 20);
    BackPollInner1.addBox(2.733333F, -12F, 6F, 1, 10, 1);
    BackPollInner1.setRotationPoint(0F, -12F, 0F);
    BackPollInner1.setTextureSize(64, 64);
    BackPollInner1.mirror = true;
    setRotation(BackPollInner1, -0.1134464F, 0F, 0F);
    BackPollInner2 = new RendererModel(this, 23, 20);
    BackPollInner2.addBox(-4F, -12F, 6F, 1, 10, 1);
    BackPollInner2.setRotationPoint(0F, -12F, 0F);
    BackPollInner2.setTextureSize(64, 64);
    BackPollInner2.mirror = true;
    setRotation(BackPollInner2, -0.1134464F, 0F, 0F);
    BackPollInner3 = new RendererModel(this, 31, 20);
    BackPollInner3.addBox(-1F, -12F, 6F, 2, 10, 1);
    BackPollInner3.setRotationPoint(0F, -12F, 0F);
    BackPollInner3.setTextureSize(64, 64);
    BackPollInner3.mirror = true;
    setRotation(BackPollInner3, -0.1134464F, 0F, 0F);
  }

  @Override
  public void render(EntityWoodChair entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    Leg1.render(f5);
    Leg2.render(f5);
    Leg3.render(f5);
    Leg4.render(f5);
    Base.render(f5);
    BackPoll1.render(f5);
    BackPoll2.render(f5);
    Back.render(f5);
    BackPollInner1.render(f5);
    BackPollInner2.render(f5);
    BackPollInner3.render(f5);
  }

  private void setRotation(RendererModel model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
}
