package mod.drf.model;

import mod.drf.entity.EntityZabuton;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;

public class ModelZabuton extends EntityModel<EntityZabuton> {
	RendererModel box;

	public ModelZabuton() {
		this.textureWidth = 64;
		this.textureHeight = 32;

		this.box = new RendererModel(this, 0, 0);
		this.box.addBox(-6F, -3F, -6F, 12, 3, 12);
		this.box.setTextureSize(64, 32);
		this.box.mirror = true;
	}

	public void render(float f) {
		this.box.render(f);
	}
}
