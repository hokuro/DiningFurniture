package mod.drf.furniture.model;

import net.minecraft.client.renderer.entity.model.ModelBase;
import net.minecraft.client.renderer.entity.model.ModelRenderer;

public class ModelZabuton extends ModelBase {
	ModelRenderer box;

	public ModelZabuton() {
		this.textureWidth = 64;
		this.textureHeight = 32;

		this.box = new ModelRenderer(this, 0, 0);
		this.box.addBox(-6F, -3F, -6F, 12, 3, 12);
		this.box.setTextureSize(64, 32);
		this.box.mirror = true;
	}

	public void render(float f) {
		this.box.render(f);
	}
}
