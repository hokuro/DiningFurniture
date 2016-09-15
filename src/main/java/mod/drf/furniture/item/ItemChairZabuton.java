package mod.drf.furniture.item;

import java.util.List;

import mod.drf.core.Mod_DiningFurniture;
import mod.drf.furniture.entity.EntityChairZabuton;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemChairZabuton extends Item{
	public static String NAME = "zabuton";
	public static final PropertyInteger METADATA = PropertyInteger.create("meta", 0, 15);
	public static final int colorValues[] = {
			0x1e1b1b, 0xb3312c, 0x3b511a, 0x51301a,
			0x253192, 0x7b2fbe, 0x287697, 0xa0a0af,
			0x434343, 0xd88198, 0x41cd34, 0xdecf2a,
			0x6689d3, 0xc354cd, 0xeb8844, 0xf0f0f0 };

	public ItemChairZabuton(){
		super();
		maxStackSize = 16;
		setCreativeTab(Mod_DiningFurniture.tabsChairs);
		this.setUnlocalizedName(NAME);
		this.setRegistryName(NAME);
		this.setHasSubtypes(true);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemstack, World world, EntityPlayer player, EnumHand hand){
	//public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player){
		float f = 1.0F;
		float f1 = player.prevRotationPitch + (player.rotationPitch - player.prevRotationPitch) * f;
		float f2 = player.prevRotationYaw + (player.rotationYaw - player.prevRotationYaw) * f;
		double d0 = player.prevPosX + (player.posX - player.prevPosX) * (double) f;
		double d1 = (player.prevPosY + (player.posY - player.prevPosY) * (double) f + 1.6200000000000001D) - (double) player.getYOffset();
		double d2 = player.prevPosZ + (player.posZ - player.prevPosZ) * (double) f;
		Vec3d vec3 = new Vec3d(d0, d1, d2);
		float f3 = MathHelper.cos(-f2 * 0.01745329F - 3.141593F);
		float f4 = MathHelper.sin(-f2 * 0.01745329F - 3.141593F);
		float f5 = -MathHelper.cos(-f1 * 0.01745329F);
		float f6 = MathHelper.sin(-f1 * 0.01745329F);
		float f7 = f4 * f5;
		float f8 = f6;
		float f9 = f3 * f5;
		double d3 = 5D;
		Vec3d vec3d1 = vec3.addVector((double) f7 * d3, (double) f8 * d3, (double) f9 * d3);
		//MovingObjectPosition movingobjectposition = world.rayTraceBlocks(vec3, vec3d1, true);
		RayTraceResult movingobjectposition = world.rayTraceBlocks(vec3, vec3d1, true);

		if (movingobjectposition == null) {
			return new ActionResult(EnumActionResult.SUCCESS, itemstack);
		}

		if (movingobjectposition.typeOfHit == RayTraceResult.Type.BLOCK) {
			BlockPos blockpos = movingobjectposition.getBlockPos();
			if (world.isAirBlock(blockpos.add(0, 1, 0))) {
				if (!world.isRemote) {
					try {
						EntityChairZabuton zabuton = new EntityChairZabuton(
								world, blockpos.getX()+0.5F, blockpos.getY()+1.0F,blockpos.getZ()+0.5F,
								(byte)(itemstack.getItemDamage() & 0x0f));
						// 方向ぎめはここに入れる
						zabuton.rotationYaw = (MathHelper
								.floor_double((double) ((player.rotationYaw * 4F) / 360F) + 2.50D) & 3) * 90;
						world.spawnEntityInWorld(zabuton);
					} catch (Exception e) {
					}

				}
				if (!player.capabilities.isCreativeMode) {
					itemstack.stackSize--;
				}
			}
		}
		return new ActionResult(EnumActionResult.SUCCESS, itemstack);
	}

	public int getColorFromItemStack(ItemStack item, int p){
		if ( item != null && item.getItemDamage() >= 0 && item.getItemDamage() < colorValues.length){
			return colorValues[item.getItemDamage()];
		}
		return colorValues[0];
	}

	@Override
	public String getUnlocalizedName(ItemStack par1ItemStack) {
		return this.getUnlocalizedName() + "." + par1ItemStack.getItemDamage();
	}

	@Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item itemIn, CreativeTabs tab, List<ItemStack> subItems){
		for (int li = 0; li < 16; li++) {
			subItems.add(new ItemStack(itemIn, 1, li));
		}
	}
}
