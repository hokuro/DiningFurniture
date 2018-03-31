package mod.drf.furniture.entity;

import io.netty.buffer.ByteBuf;
import mod.drf.furniture.model.ModelZabuton;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntityZabuton extends EntityChair {
	private static final ModelZabuton mainmodel = new ModelZabuton();
	public static final String NAME="zabuton";
	protected ResourceLocation[] textures = new ResourceLocation[] {
			new ResourceLocation("drf:textures/entity/zabuton_f.png"),
			new ResourceLocation("drf:textures/entity/zabuton_e.png"),
			new ResourceLocation("drf:textures/entity/zabuton_d.png"),
			new ResourceLocation("drf:textures/entity/zabuton_c.png"),
			new ResourceLocation("drf:textures/entity/zabuton_b.png"),
			new ResourceLocation("drf:textures/entity/zabuton_a.png"),
			new ResourceLocation("drf:textures/entity/zabuton_9.png"),
			new ResourceLocation("drf:textures/entity/zabuton_8.png"),
			new ResourceLocation("drf:textures/entity/zabuton_7.png"),
			new ResourceLocation("drf:textures/entity/zabuton_6.png"),
			new ResourceLocation("drf:textures/entity/zabuton_5.png"),
			new ResourceLocation("drf:textures/entity/zabuton_4.png"),
			new ResourceLocation("drf:textures/entity/zabuton_3.png"),
			new ResourceLocation("drf:textures/entity/zabuton_2.png"),
			new ResourceLocation("drf:textures/entity/zabuton_1.png"),
			new ResourceLocation("drf:textures/entity/zabuton_0.png")
	};
	public byte color;

	public EntityZabuton(World worldIn){
		super(worldIn);
		setSize(0.81F,0.2F);
		color = 0;
	}

	public EntityZabuton(World worldIn, ItemStack item) {
		super(worldIn, item);
		setSize(0.81F,0.2F);
		color = 0;
	}

	public EntityZabuton(World worldIn, ItemStack item, byte c){
		this(worldIn, item);
		this.color = c;
	}

	public EntityZabuton(World worldIn, double x, double y, double z, ItemStack item, byte c){
		super(worldIn,  x, y, z, item);
		setSize(0.81F,0.2F);
		this.color = c;
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound tagCompund) {
		super.readEntityFromNBT(tagCompund);
		color = tagCompund.getByte("Color");
	}


	@Override
	protected void writeEntityToNBT(NBTTagCompound tagCompund) {
		super.writeEntityToNBT(tagCompund);
		tagCompund.setByte("Color", (byte)(color & 0x0f));
	}

	@Override
	public double getMountedYOffset() {
		for (Entity et : this.getPassengers()){
			if (et instanceof EntitySpider) {
				return (double)height * 0.0D - 0.1D;
			}
			if (	et instanceof EntityZombie ||
					et instanceof EntityEnderman) {
				return (double)height * 0.0D - 0.4D;
			}
		}

		return (double)height * 0.0D + 0.1D;
	}

	@Override
	public void writeSpawnData(ByteBuf data) {
		super.writeSpawnData(data);
		data.writeByte(color);
	}
	@Override
	public void readSpawnData(ByteBuf data) {
		super.readSpawnData(data);
		color = data.readByte();
	}

	@Override
	public ResourceLocation getEntityTexture(EntityChair chair){
		if(color >= 0 && color < 16){
			return textures[color];
		}else{
			return textures[0];
		}
	}

	@Override
	public void renderChairModel(){
		 mainmodel.render(0.0625F);
	}
}
