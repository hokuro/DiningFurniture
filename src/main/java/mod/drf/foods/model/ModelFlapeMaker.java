// Date: 2016/10/04 21:48:14
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX

package mod.drf.foods.model;

import mod.drf.foods.tileentity.TileEntityFlapeMaker;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelFlapeMaker extends ModelBase
{
  //fields
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Shape5;
    ModelRenderer Shape6;

    ModelRenderer flapeMaker;
  public ModelFlapeMaker()
  {
    textureWidth = 92;
    textureHeight = 64;

      Shape1 = new ModelRenderer(this, 0, 0);
      Shape1.addBox(-6F, 0F, -5F, 12, 6, 13);
      Shape1.setRotationPoint(0F, 0F, 0F);
      Shape1.setTextureSize(92, 64);
      //Shape1.mirror = true;
      setRotation(Shape1, 0F, 0F, 0F);
      Shape2 = new ModelRenderer(this, 0, 19);
      Shape2.addBox(5F, 6F, 0F, 1, 9, 8);
      Shape2.setRotationPoint(0F, 0F, 0F);
      Shape2.setTextureSize(92, 64);
      //Shape2.mirror = true;
      setRotation(Shape2, 0F, 0F, 0F);
      Shape3 = new ModelRenderer(this, 0, 19);
      Shape3.addBox(-6F, 6F, 0F, 1, 9, 8);
      Shape3.setRotationPoint(0F, 0F, 0F);
      Shape3.setTextureSize(92, 64);
      //Shape3.mirror = true;
      setRotation(Shape3, 0F, 0F, 0F);
      Shape4 = new ModelRenderer(this, 0, 36);
      Shape4.addBox(5F, 15F, -7F, 1, 1, 15);
      Shape4.setRotationPoint(0F, 0F, 0F);
      Shape4.setTextureSize(92, 64);
      //Shape4.mirror = true;
      setRotation(Shape4, 0F, 0F, 0F);
      Shape5 = new ModelRenderer(this, 0, 36);
      Shape5.addBox(-6F, 15F, -7F, 1, 1, 15);
      Shape5.setRotationPoint(0F, 0F, 0F);
      Shape5.setTextureSize(92, 64);
      //Shape5.mirror = true;
      setRotation(Shape5, 0F, 0F, 0F);
      Shape6 = new ModelRenderer(this, 18, 19);
      Shape6.addBox(-5F, 6F, 7F, 10, 10, 1);
      Shape6.setRotationPoint(0F, 0F, 0F);
      Shape6.setTextureSize(92, 64);
      //Shape6.mirror = true;
      setRotation(Shape6, 0F, 0F, 0F);
  }

  public void render(TileEntityFlapeMaker te, float f, float limbSwing, float ageInTicks, float netHeadYaw, float headPitch, float scale){
//	    super.render(null, f, limbSwing, ageInTicks, netHeadYaw, headPitch, scale);
//	    setRotationAngles(f, limbSwing, ageInTicks, netHeadYaw, headPitch, scale);

	    Shape1.render(scale);
	    Shape2.render(scale);
	    Shape3.render(scale);
	    Shape4.render(scale);
	    Shape5.render(scale);
	    Shape6.render(scale);
  }

  public void render(Entity entity, float f, float limbSwing, float ageInTicks, float netHeadYaw, float headPitch, float scale)
  {
    super.render(entity, f, limbSwing, ageInTicks, netHeadYaw, headPitch, scale);
    setRotationAngles(f, limbSwing, ageInTicks, netHeadYaw, headPitch, scale);
    Shape1.render(scale);
    Shape2.render(scale);
    Shape3.render(scale);
    Shape4.render(scale);
    Shape5.render(scale);
    Shape6.render(scale);
  }

  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }

  public void setRotationAngles(float f, float limbSwing, float ageInTicks, float netHeadYaw, float headPitch, float scale)
  {
    super.setRotationAngles(f, limbSwing, ageInTicks, netHeadYaw, headPitch, scale, null);
  }

}