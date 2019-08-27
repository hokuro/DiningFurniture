package mod.drf.furniture.entity;

import mod.drf.core.Mod_DiningFurniture;
import mod.drf.furniture.item.ItemFurniture.EnumWoodType;
import mod.drf.furniture.model.ModelWoodChair;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntityWoodChair extends EntityChair {
	public static final String NAME= "woodchair";
	private static final ModelWoodChair model = new ModelWoodChair();
	protected static final ResourceLocation[] textures = new ResourceLocation[] {
			new ResourceLocation("drf:textures/entity/woodchair_ork.png"),
			new ResourceLocation("drf:textures/entity/woodchair_birch.png"),
			new ResourceLocation("drf:textures/entity/woodchair_spruce.png"),
			new ResourceLocation("drf:textures/entity/woodchair_jungl.png"),
			new ResourceLocation("drf:textures/entity/woodchair_acacia.png"),
			new ResourceLocation("drf:textures/entity/woodchair_ork2.png")
	};
	private EnumWoodType woodType;


	public EntityWoodChair(World worldIn){
		this(worldIn, ItemStack.EMPTY);
	}

	public EntityWoodChair(World worldIn, ItemStack item) {
		this(worldIn, item, EnumWoodType.OAK_WOOD);
	}

	public EntityWoodChair(World worldIn, ItemStack item, EnumWoodType typ){
		this(worldIn, 0F, 0F, 0F, item, typ);
	}

	public EntityWoodChair(World worldIn, double x, double y, double z, ItemStack item, EnumWoodType typ){
		super(Mod_DiningFurniture.RegistryEvents.WOODCHAIR, worldIn,  x, y, z, item);
		setSize(1.0F,1.8F);
		this.woodType = typ;
	}

	@Override
	protected void readAdditional(NBTTagCompound tagCompund) {
		super.readAdditional(tagCompund);
		woodType = EnumWoodType.getType(tagCompund.getInt("Type"));
	}


	@Override
	protected void writeAdditional(NBTTagCompound tagCompund) {
		super.writeAdditional(tagCompund);
		tagCompund.setInt("Type", woodType.getIndex());
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
	public void writeSpawnData(PacketBuffer data) {
		super.writeSpawnData(data);
		data.writeInt(woodType.getIndex());
	}
	@Override
	public void readSpawnData(PacketBuffer data) {
		super.readSpawnData(data);
		woodType = EnumWoodType.getType(data.readInt());
	}


	@Override
	public ResourceLocation getEntityTexture(EntityChair chair) {
		if (woodType.getIndex() >= 0 && woodType.getIndex() <textures.length){
			return textures[woodType.getIndex()];
		}
		return textures[0];
	}

	@Override
	public void renderChairModel() {
		model.render(this, 0, 0, 0, 0, 0, 0.0625F);
	}

}
