package mod.drf.furniture.container;

import basashi.trunk.core.ModCommon;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import net.minecraft.world.WorldSavedData;

public class TrunkData extends WorldSavedData {
	// トランク内のアイテムサイズ
	public ItemStack[] items =  new ItemStack[ModCommon.TRUNK_MAX_PAGE*(ModCommon.TrunkCsize*ModCommon.TrunkRsize)];
	private boolean init = false;
	public boolean upDate;
	private static final int UPDATETIME = 1000;

	// コンストラクタ
	public TrunkData(String name)
	{
		super(name);

	}

	public void onUpdate(World world, EntityPlayer player)
	{
		if(!this.init)
		{
			this.init = true;
		}
		if(world.getWorldTime() % UPDATETIME == 0l)
			this.upDate = true;
		if(this.upDate)
		{
			this.markDirty();
			this.upDate = false;
		}
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		// TODO 自動生成されたメソッド・スタブ
        NBTTagList nbtlst = nbt.getTagList("Items", 10);
        this.items =  new ItemStack[ModCommon.TRUNK_MAX_PAGE*(ModCommon.TrunkCsize*ModCommon.TrunkRsize)];

        for (int i = 0; i < nbtlst.tagCount(); ++i)
        {
            NBTTagCompound tag = (NBTTagCompound)nbtlst.getCompoundTagAt(i);
            int slt = tag.getInteger("Slot");

            if (slt >= 0 && slt < this.items.length)
            {
                this.items[slt] = ItemStack.loadItemStackFromNBT(tag);
            }
        }
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		// TODO 自動生成されたメソッド・スタブ
		NBTTagList ntblst = new NBTTagList();

		for (int i = 0; i < this.items.length; ++i)
		{
			if (this.items[i] != null)
			{
				NBTTagCompound tag = new NBTTagCompound();
				tag.setInteger("Slot", i);
				this.items[i].writeToNBT(tag);
				ntblst.appendTag(tag);
			}
		}
		nbt.setTag("Items", ntblst);
	}

}
