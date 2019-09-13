package mod.drf.model;

import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.Model;

public class ModeWoodlTable extends Model {
	RendererModel Shape1;
	RendererModel Shape2;
	RendererModel Shape3;
	RendererModel Shape4;
	RendererModel Shape5;

	public ModeWoodlTable() {
	    textureWidth = 128;
	    textureHeight = 32;

	      Shape1 = new RendererModel(this, 0, 0);
	      Shape1.addBox(-8F, 0F, -8F, 16, 2, 16);
	      Shape1.setRotationPoint(0F, 0F, 0F);
	      Shape1.setTextureSize(128, 32);
	      Shape1.mirror = true;
	      setRotation(Shape1, 0F, 0F, 0F);
	      Shape2 = new RendererModel(this, 80, 0);
	      Shape2.addBox(-7F, 2F, -7F, 2, 14, 2);
	      Shape2.setRotationPoint(0F, 0F, 0F);
	      Shape2.setTextureSize(128, 32);
	      Shape2.mirror = true;
	      setRotation(Shape2, 0F, 0F, 0F);
	      Shape3 = new RendererModel(this, 88, 0);
	      Shape3.addBox(5F, 2F, -7F, 2, 14, 2);
	      Shape3.setRotationPoint(0F, 0F, 0F);
	      Shape3.setTextureSize(128, 32);
	      Shape3.mirror = true;
	      setRotation(Shape3, 0F, 0F, 0F);
	      Shape4 = new RendererModel(this, 72, 0);
	      Shape4.addBox(-7F, 2F, 5F, 2, 14, 2);
	      Shape4.setRotationPoint(0F, 0F, 0F);
	      Shape4.setTextureSize(128, 32);
	      Shape4.mirror = true;
	      setRotation(Shape4, 0F, 0F, 0F);
	      Shape5 = new RendererModel(this, 64, 0);
	      Shape5.addBox(5F, 2F, 5F, 2, 14, 2);
	      Shape5.setRotationPoint(0F, 0F, 0F);
	      Shape5.setTextureSize(128, 32);
	      Shape5.mirror = true;
	      setRotation(Shape5, 0F, 0F, 0F);
	}

	public void render(float f) {
	    Shape1.render(f);
	    Shape2.render(f);
	    Shape3.render(f);
	    Shape4.render(f);
	    Shape5.render(f);
	}

	  private void setRotation(RendererModel model, float x, float y, float z)
	  {
	    model.rotateAngleX = x;
	    model.rotateAngleY = y;
	    model.rotateAngleZ = z;
	  }
}
