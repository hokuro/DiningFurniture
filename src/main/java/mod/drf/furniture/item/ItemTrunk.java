package mod.drf.furniture.item;

import mod.drf.core.ModCommon;
import mod.drf.core.Mod_DiningFurniture;
import mod.drf.furniture.inventory.SavedDataTrunk;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class ItemTrunk extends Item {
	// トランク情報
	public SavedDataTrunk data;

	public ItemTrunk(){
		super();
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World world, EntityPlayer player, EnumHand hand)
	{
		player.openGui(Mod_DiningFurniture.instance, ModCommon.MOD_GUI_ID_TRUNK, world, player.chunkCoordX, player.chunkCoordY, player.chunkCoordZ);
    	return ActionResult.newResult(EnumActionResult.SUCCESS, itemStackIn);
    }

	// アイテムアップデート
	public void onUpdate(ItemStack item, World world, Entity entity, int itemSlot, boolean isSelected) {
		if(entity instanceof EntityPlayer && isSelected){
			EntityPlayer player = (EntityPlayer) entity;
			if(!world.isRemote)
			{
				this.data = getData(item,world);
				this.data.onUpdate(world, player);
				this.data.markDirty();
			}
		}
	}

	// トランクデータ取得
	public static SavedDataTrunk getTrunkData(ItemStack item, World world)
	{
		SavedDataTrunk data = null;
		if(item != null && item.getItem() instanceof ItemTrunk)
		{
			data = ((ItemTrunk)item.getItem()).getData(item, world);
		}
		return data;
	}


	// トランクデータ取得
	public SavedDataTrunk getData(ItemStack item, World world)
	{
		String itemName = "Trunk";
		int itemDamage = MathHelper.clamp_int(item.getItemDamage(),0,15);
		String name = String.format("%s_%s", itemName, itemDamage);
		SavedDataTrunk data = (SavedDataTrunk)world.loadItemData(SavedDataTrunk.class, name);

		if (data == null)
		{
			data = new SavedDataTrunk(name);
			data.markDirty();
			world.setItemData(name, data);
		}

		return data;
	}
}
