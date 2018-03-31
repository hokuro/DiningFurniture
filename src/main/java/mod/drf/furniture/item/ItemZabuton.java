package mod.drf.furniture.item;

import mod.drf.core.Mod_DiningFurniture;
import mod.drf.furniture.entity.EntityChair;
import mod.drf.furniture.entity.EntityZabuton;
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

public class ItemZabuton extends ItemChair {
	public static String NAME = ItemFurniture.NAME_ZABUTON;
	public static final PropertyInteger METADATA = PropertyInteger.create("meta", 0, 15);
	public static final int colorValues[] = {
			0x1e1b1b, 0xb3312c, 0x3b511a, 0x51301a,
			0x253192, 0x7b2fbe, 0x287697, 0xa0a0af,
			0x434343, 0xd88198, 0x41cd34, 0xdecf2a,
			0x6689d3, 0xc354cd, 0xeb8844, 0xf0f0f0 };

	public ItemZabuton(){
		super();
		maxStackSize = 16;
		setCreativeTab(Mod_DiningFurniture.tabFurniture);
		this.setHasSubtypes(true);
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
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> subItems){
		if (tab != this.getCreativeTab()){return;}
		for (int li = 0; li < 16; li++) {
			subItems.add(new ItemStack(this, 1, li));
		}
	}

	@Override
	public EntityChair getEntityChair(World world, EntityPlayer player, BlockPos blockpos, ItemStack itemstack) {
		EntityChair zabuton = new EntityZabuton(
				world, blockpos.getX()+0.5F, blockpos.getY()+1.0F,blockpos.getZ()+0.5F,
				itemstack,
				(byte)(itemstack.getItemDamage() & 0x0f));

		if (player != null){
			// 方向ぎめはここに入れる
			zabuton.rotationYaw = (MathHelper
					.floor((double) ((player.rotationYaw * 4F) / 360F) + 2.50D) & 3) * 90;
		}
		return zabuton;
	}

	@Override
	public String getName() {
		return NAME;
	}
}
