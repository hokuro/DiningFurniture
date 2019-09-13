package mod.drf.entity;

import mod.drf.core.Mod_DiningFurniture;
import mod.drf.model.ModelZabuton;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.EndermanEntity;
import net.minecraft.entity.monster.SpiderEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.item.DyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.FMLPlayMessages;

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

	public DyeColor color;

	public EntityZabuton(EntityType<?> etype, World worldIn) {
		super(etype, worldIn);
	}

	public EntityZabuton(FMLPlayMessages.SpawnEntity packet, World world) {
		this(world);
	}

	public EntityZabuton(World worldIn){
		this(worldIn, ItemStack.EMPTY);
	}

	public EntityZabuton(World worldIn, ItemStack item) {
		this(worldIn, item, DyeColor.WHITE);
	}

	public EntityZabuton(World worldIn, ItemStack item, DyeColor c){
		this(worldIn, 0, 0, 0, item,c);
	}

	public EntityZabuton(World worldIn, double x, double y, double z, ItemStack item, DyeColor c){
		super(Mod_DiningFurniture.RegistryEvents.ZABUTON, worldIn,  x, y, z, item);
		this.color = c;
	}

	@Override
	protected void readAdditional(CompoundNBT tagCompund) {
		super.readAdditional(tagCompund);
		color = DyeColor.byId(tagCompund.getInt("Color"));
	}


	@Override
	protected void writeAdditional(CompoundNBT tagCompund) {
		super.writeAdditional(tagCompund);
		tagCompund.putInt("Color", color.getId());
	}

	@Override
	public double getMountedYOffset() {
		for (Entity et : this.getPassengers()){
			if (et instanceof SpiderEntity) {
				return (double) - 0.1D;
			}
			if (	et instanceof ZombieEntity ||
					et instanceof EndermanEntity) {
				return (double) - 0.1D;
			}
		}

		return (double) 0.1D;
	}

	@Override
	public void writeSpawnData(PacketBuffer data) {
		super.writeSpawnData(data);
		data.writeInt(color.getId());
	}
	@Override
	public void readSpawnData(PacketBuffer data) {
		super.readSpawnData(data);
		color = DyeColor.byId(data.readInt());
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
