package mod.drf.furniture.entity;

import mod.drf.core.Mod_DiningFurniture;
import mod.drf.furniture.model.ModelZabuton;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntityZabuton extends EntityChair {
	private static final ModelZabuton mainmodel = new ModelZabuton();
	public static final String NAME="zabuton";
	protected ResourceLocation[] textures = new ResourceLocation[] {
			new ResourceLocation("drf:textures/entity/zabuton_0.png"),
			new ResourceLocation("drf:textures/entity/zabuton_1.png"),
			new ResourceLocation("drf:textures/entity/zabuton_2.png"),
			new ResourceLocation("drf:textures/entity/zabuton_3.png"),
			new ResourceLocation("drf:textures/entity/zabuton_4.png"),
			new ResourceLocation("drf:textures/entity/zabuton_5.png"),
			new ResourceLocation("drf:textures/entity/zabuton_6.png"),
			new ResourceLocation("drf:textures/entity/zabuton_7.png"),
			new ResourceLocation("drf:textures/entity/zabuton_8.png"),
			new ResourceLocation("drf:textures/entity/zabuton_9.png"),
			new ResourceLocation("drf:textures/entity/zabuton_a.png"),
			new ResourceLocation("drf:textures/entity/zabuton_b.png"),
			new ResourceLocation("drf:textures/entity/zabuton_c.png"),
			new ResourceLocation("drf:textures/entity/zabuton_d.png"),
			new ResourceLocation("drf:textures/entity/zabuton_e.png"),
			new ResourceLocation("drf:textures/entity/zabuton_f.png")
	};

	public EnumDyeColor color;

	public EntityZabuton(World worldIn){
		this(worldIn, ItemStack.EMPTY);
	}

	public EntityZabuton(World worldIn, ItemStack item) {
		this(worldIn, item, EnumDyeColor.WHITE);
	}

	public EntityZabuton(World worldIn, ItemStack item, EnumDyeColor c){
		this(worldIn, 0, 0, 0, item,c);
	}

	public EntityZabuton(World worldIn, double x, double y, double z, ItemStack item, EnumDyeColor c){
		super(Mod_DiningFurniture.RegistryEvents.ZABUTON, worldIn,  x, y, z, item);
		setSize(0.81F,0.2F);
		this.color = c;
	}

	@Override
	protected void readAdditional(NBTTagCompound tagCompund) {
		super.readAdditional(tagCompund);
		color = EnumDyeColor.byId(tagCompund.getInt("Color"));
	}


	@Override
	protected void writeAdditional(NBTTagCompound tagCompund) {
		super.writeAdditional(tagCompund);
		tagCompund.setInt("Color", color.getId());
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
	public void writeSpawnData(PacketBuffer data) {
		super.writeSpawnData(data);
		data.writeInt(color.getId());
	}
	@Override
	public void readSpawnData(PacketBuffer data) {
		super.readSpawnData(data);
		color = EnumDyeColor.byId(data.readInt());
	}

	@Override
	public ResourceLocation getEntityTexture(EntityChair chair){
		if(color.getId() >= 0 && color.getId() < 16){
			return textures[color.getId()];
		}else{
			return textures[0];
		}
	}

	@Override
	public void renderChairModel(){
		 mainmodel.render(0.0625F);
	}
}
