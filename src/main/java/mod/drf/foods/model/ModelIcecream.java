// Date: 2016/10/05 23:41:16
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX






package mod.drf.foods.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public class ModelIcecream extends ModelBase
{
  //fields
  private ModelRenderer casebase;
  private ModelRenderer casecupsid4;
  private ModelRenderer casecupsid3;
  private ModelRenderer caseporl;
  private ModelRenderer casecupbase;
  private ModelRenderer casecupsid2;
  private ModelRenderer casecupsid1;
  private ModelRenderer Ice1;
  private ModelRenderer Ice2;
  private ModelRenderer Ice3;
  private ModelRenderer Ice4;

  public ModelIcecream()
  {
	    textureWidth = 64;
	    textureHeight = 32;

	      casebase = new ModelRenderer(this, 0, 0);
	      casebase.addBox(-3F, 0F, -3F, 6, 1, 6);
	      casebase.setRotationPoint(0F, 23F, 0F);
	      casebase.setTextureSize(64, 32);
	      casebase.mirror = true;
	      setRotation(casebase, (float)Math.PI, 0F, 0F);
	      casecupsid4 = new ModelRenderer(this, 33, 5);
	      casecupsid4.addBox(-4F, -9F, -5F, 8, 3, 1);
	      casecupsid4.setRotationPoint(0F, 23F, 0F);
	      casecupsid4.setTextureSize(64, 32);
	      casecupsid4.mirror = true;
	      setRotation(casecupsid4, (float)Math.PI, -1.570796F, 0F);
	      casecupsid3 = new ModelRenderer(this, 33, 15);
	      casecupsid3.addBox(-4F, -9F, -5F, 8, 3, 1);
	      casecupsid3.setRotationPoint(0F, 23F, 0F);
	      casecupsid3.setTextureSize(64, 32);
	      casecupsid3.mirror = true;
	      setRotation(casecupsid3, (float)Math.PI, 1.570796F, 0F);
	      caseporl = new ModelRenderer(this, 24, 0);
	      caseporl.addBox(-1F, -6F, -1F, 2, 6, 2);
	      caseporl.setRotationPoint(0F, 23F, 0F);
	      caseporl.setTextureSize(64, 32);
	      caseporl.mirror = true;
	      setRotation(caseporl, (float)Math.PI, 0F, 0F);
	      casecupbase = new ModelRenderer(this, 0, 8);
	      casecupbase.addBox(-4F, -7F, -4F, 8, 1, 8);
	      casecupbase.setRotationPoint(0F, 23F, 0F);
	      casecupbase.setTextureSize(64, 32);
	      casecupbase.mirror = true;
	      setRotation(casecupbase, (float)Math.PI, 0F, 0F);
	      casecupsid2 = new ModelRenderer(this, 33, 0);
	      casecupsid2.addBox(-4F, -9F, -5F, 8, 3, 1);
	      casecupsid2.setRotationPoint(0F, 23F, 0F);
	      casecupsid2.setTextureSize(64, 32);
	      casecupsid2.mirror = true;
	      setRotation(casecupsid2, (float)Math.PI, 0F, 0F);
	      casecupsid1 = new ModelRenderer(this, 33, 10);
	      casecupsid1.addBox(-4F, -9F, 4F, 8, 3, 1);
	      casecupsid1.setRotationPoint(0F, 23F, 0F);
	      casecupsid1.setTextureSize(64, 32);
	      casecupsid1.mirror = true;
	      setRotation(casecupsid1, (float)Math.PI, 0F, 0F);
	      Ice1 = new ModelRenderer(this, 0, 18);
	      Ice1.addBox(-3F, -11F, -3F, 6, 4, 6);
	      Ice1.setRotationPoint(0F, 23F, 0F);
	      Ice1.setTextureSize(64, 32);
	      Ice1.mirror = true;
	      setRotation(Ice1, (float)Math.PI, 0F, 0F);


	      Ice2 = new ModelRenderer(this, 3, 20);
	      Ice2.addBox(-2F, -10F, -2F, 4, 3, 4);
	      Ice2.setRotationPoint(0F, 23F, 0F);
	      Ice2.setTextureSize(64, 32);
	      Ice2.mirror = true;
	      setRotation(Ice2, (float)Math.PI, 0F, 0F);
	      Ice3 = new ModelRenderer(this, 0, 24);
	      Ice3.addBox(-1F, -9F, -1F, 2, 2, 2);
	      Ice3.setRotationPoint(0F, 23F, 0F);
	      Ice3.setTextureSize(64, 32);
	      Ice3.mirror = true;
	      setRotation(Ice3, (float)Math.PI, 0F, 0F);
	      Ice4 = new ModelRenderer(this, 0, 24);
	      Ice4.addBox(0F, -8F, 0F, 1, 1, 1);
	      Ice4.setRotationPoint(0F, 23F, 0F);
	      Ice4.setTextureSize(64, 32);
	      Ice4.mirror = true;
	      setRotation(Ice4, (float)Math.PI, 0F, 0F);
	}

  public void render(EnumIcecreamLevel level, float scale){
	    casebase.render(scale);
	    casecupsid4.render(scale);
	    casecupsid3.render(scale);
	    caseporl.render(scale);
	    casecupbase.render(scale);
	    casecupsid2.render(scale);
	    casecupsid1.render(scale);
	    switch(level){
		case LEVEL0:
			break;
		case LEVEL1:
			Ice4.render(scale);
			break;
		case LEVEL2:
			Ice3.render(scale);
			break;
		case LEVEL3:
			Ice2.render(scale);
			break;
		case LEVEL4:
			Ice1.render(scale);
			break;
		default:
			Ice1.render(scale);
			break;

	    }
  }

  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }

  public static enum EnumIcecreamLevel{
	  LEVEL0,
	  LEVEL1,
	  LEVEL2,
	  LEVEL3,
	  LEVEL4;

	  private static final EnumIcecreamLevel[] values = {LEVEL0,LEVEL1,LEVEL2,LEVEL3,LEVEL4};

	  public static int getLevelCnt(){return values.length;}

	  public static EnumIcecreamLevel getValue(int max, int cnt){
		  int level = 0;
		  if (cnt <= 0){level=0;}
		  else{
			  int limit = (int)Math.ceil(max / (values.length-1));
			  level = (int)Math.ceil(cnt/limit)+1;
			  if (level < 0){level = 0;}
			  if (level >= values.length){level = values.length-1;}
		  }
		  return values[level];
	  }

	  public static EnumIcecreamLevel getLevel(int level){
		  if (level < 0){return values[0];}
		  if (level >= values.length){return values[values.length-1];}
		  return values[level];
	  }

  }

}
