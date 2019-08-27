package mod.drf.foods.model;

import net.minecraft.client.renderer.entity.model.ModelBase;
import net.minecraft.client.renderer.entity.model.ModelRenderer;

//Date: 2016/10/18 23:33:34
//Template version 1.1
//Java generated by Techne
//Keep in mind that you still need to fill in some blanks
//- ZeuX


public class ModelMillStone extends ModelBase
{
//fields
 private ModelRenderer block_topstone;
 private ModelRenderer block_understone;
 private ModelRenderer block_bar;

 public ModelMillStone()
 {
  textureWidth = 96;
  textureHeight = 64;

    block_topstone = new ModelRenderer(this, 0, 0);
    block_topstone.addBox(-6F, -6F, -6F, 12, 6, 12);
    block_topstone.setRotationPoint(0F, 18F, 0F);
    block_topstone.setTextureSize(96, 64);
    block_topstone.mirror = true;
    setRotation(block_topstone, 0F, 0F, 0F);
    block_understone = new ModelRenderer(this, 0, 18);
    block_understone.addBox(-6F, -6F, -6F, 12, 6, 12);
    block_understone.setRotationPoint(0F, 18F, 0F);
    block_understone.setTextureSize(96, 64);
    block_understone.mirror = true;
    setRotation(block_understone, 0F, 0F, 3.141593F);
    block_bar = new ModelRenderer(this, 49, 0);
    block_bar.addBox(-5F, -9F, -1F, 2, 3, 2);
    block_bar.setRotationPoint(0F, 18F, 0F);
    block_bar.setTextureSize(96, 64);
    block_bar.mirror = true;
    setRotation(block_bar, 0F, 0F, 0F);
 }


 private void setRotation(ModelRenderer model, float x, float y, float z)
 {
   model.rotateAngleX = x;
   model.rotateAngleY = y;
   model.rotateAngleZ = z;
 }

 public void render(float scale, float rotation){
	 block_topstone.rotateAngleY = block_bar.rotateAngleY = rotation;
	 block_topstone.render(scale);
	 block_understone.render(scale);
	 block_bar.render(scale);
 }
}
