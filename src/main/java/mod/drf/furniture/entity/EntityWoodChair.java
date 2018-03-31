package mod.drf.furniture.entity;

import io.netty.buffer.ByteBuf;
import mod.drf.furniture.item.ItemFurniture;
import mod.drf.furniture.model.ModelWoodChair;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntityWoodChair extends EntityChair {
	public static final String NAME= ItemFurniture.NAME_WOODCHAIR;
	private static final ModelWoodChair model = new ModelWoodChair();
	protected static final ResourceLocation[] textures = new ResourceLocation[] {
			new ResourceLocation("drf:textures/entity/woodchair_ork.png"),
			new ResourceLocation("drf:textures/entity/woodchair_birch.png"),
			new ResourceLocation("drf:textures/entity/woodchair_spruce.png"),
			new ResourceLocation("drf:textures/entity/woodchair_jungl.png"),
			new ResourceLocation("drf:textures/entity/woodchair_acacia.png"),
			new ResourceLocation("drf:textures/entity/woodchair_ork2.png")
	};
	private int woodType;


	public EntityWoodChair(World worldIn){
		super(worldIn);
		setSize(1F,1.8F);
		woodType = 0;
	}

	public EntityWoodChair(World worldIn, ItemStack item) {
		super(worldIn, item);
		setSize(1.0F,1.8F);
		if (item.getItem() == Item.getItemFromBlock(Blocks.PLANKS)){
			woodType = item.getMetadata();
		}
	}

	public EntityWoodChair(World worldIn, ItemStack item, int typ){
		this(worldIn, item);
		this.woodType = typ;
	}

	public EntityWoodChair(World worldIn, double x, double y, double z, ItemStack item, int typ){
		super(worldIn,  x, y, z, item);
		setSize(1.0F,1.8F);
		this.woodType = typ;
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound tagCompund) {
		super.readEntityFromNBT(tagCompund);
		woodType = tagCompund.getInteger("Type");
	}


	@Override
	protected void writeEntityToNBT(NBTTagCompound tagCompund) {
		super.writeEntityToNBT(tagCompund);
		tagCompund.setInteger("Type", woodType);
	}


	@Override
	public double getMountedYOffset() {
		for (Entity et : this.getPassengers()){
			if (et instanceof EntitySpider) {
				return (double)height * 0.0D +0.66D;
			}
			if (	et instanceof EntityZombie ||
					et instanceof EntityEnderman) {
				return (double)height * 0.0D +0.66D;
			}
		}

		return (double)height * 0.0D +0.66D;
	}

	@Override
	public void writeSpawnData(ByteBuf data) {
		super.writeSpawnData(data);
		data.writeInt(woodType);
	}
	@Override
	public void readSpawnData(ByteBuf data) {
		super.readSpawnData(data);
		woodType = data.readInt();
	}


	@Override
	public ResourceLocation getEntityTexture(EntityChair chair) {
		if (woodType >= 0 && woodType <textures.length){
			return textures[woodType];
		}
		return textures[0];
	}

	@Override
	public void renderChairModel() {
		model.render(this, 0, 0, 0, 0, 0, 0.0625F);
	}

}
