package mod.drf.tileentity;

import mod.drf.core.Mod_DiningFurniture;
import mod.drf.item.ItemCore.EnumWoodType;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.nbt.CompoundNBT;

public class TileEntityWoodTable extends TileEntityTable implements ISidedInventory {
	public static final String REGISTER_NAME = "tileentitywoodtable";
	private EnumWoodType woodType;

	public TileEntityWoodTable(){
		this(EnumWoodType.OAK_WOOD);
	}

	public TileEntityWoodTable(EnumWoodType wood) {
		super(Mod_DiningFurniture.RegistryEvents.WOODTABLE);
		this.clear();
		woodType = wood;
	}

	@Override
	public void read(CompoundNBT compound)
    {
		super.read(compound);
	    ItemStackHelper.loadAllItems(compound, this.inventory);
	    compound.putInt("woodType", woodType.getIndex());
    }

	@Override
    public CompoundNBT write(CompoundNBT compound)
    {
		compound = super.write(compound);
		woodType = EnumWoodType.getType(compound.getInt("woodType"));
		return compound;
    }

	public EnumWoodType getWoodType() {
		return woodType;
	}


}
