package mod.drf.furniture.item;

import mod.drf.core.Mod_DiningFurniture;
import mod.drf.furniture.entity.EntityChair;
import mod.drf.furniture.entity.EntityWoodChair;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemWoodChair extends ItemChair {
	public static String NAME = "wood_chair";
	public static final PropertyInteger METADATA = PropertyInteger.create("meta", 0, 6);

	public ItemWoodChair(){
		super();
		maxStackSize = 16;
		setCreativeTab(Mod_DiningFurniture.tabFurniture);
		this.setHasSubtypes(true);
	}

	@Override
	public String getUnlocalizedName(ItemStack par1ItemStack) {
		return this.getUnlocalizedName() + "." + par1ItemStack.getItemDamage();
	}

	@Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> subItems){
		if (tab != this.getCreativeTab()){return;}
		for (int li = 0; li < 6; li++) {
			subItems.add(new ItemStack(this, 1, li));
		}
	}

	@Override
	public EntityChair getEntityChair(World world, EntityPlayer player, BlockPos blockpos, ItemStack itemstack) {
		EntityChair chiar = new EntityWoodChair(
				world, blockpos.getX()+0.5F, blockpos.getY()+1.0F,blockpos.getZ()+0.5F,
				itemstack,
				(itemstack.getItemDamage()));

		if (player != null){
			// 方向ぎめはここに入れる
			chiar.rotationYaw = (MathHelper
					.floor((double) ((player.rotationYaw * 4F) / 360F) + 2.50D) & 3) * 90;
		}
		return chiar;
	}

	@Override
	public String getName() {
		return NAME;
	}

}
