package mod.drf.foods.block;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mod.drf.core.ModCommon;
import mod.drf.core.log.ModLog;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCake;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockPie extends BlockCake {

	private PotionEffect[] _effect;
	private int _heall;
	private float _saturationLevel;

	public static final Map<Integer,String> META_NAME = new HashMap<Integer,String>(){
		{put(0,"uneaten");}
		{put(1,"slice1");}
		{put(2,"slice2");}
		{put(3,"slice3");}
		{put(4,"slice4");}
		{put(5,"slice5");}
		{put(6,"slice6");}
	};

	private BlockPie(){
		super();
		this.setStepSound(SoundType.CLOTH);
		this.setHardness(0.5F);
	}

	public BlockPie(int heall, float saturation){
		this();

		this.setHeal(heall, saturation);
		this.setPotionEffect(null);
	}

	public BlockPie(int heall, float saturation, PotionEffect[] effect)
    {
		this();

		this.setHeal(heall, saturation);
		this.setPotionEffect(effect);
    }

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        this.eatPie(worldIn, pos, state, playerIn);
        return true;
    }

	@Override
    public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn)
    {
        this.eatPie(worldIn, pos, worldIn.getBlockState(pos), playerIn);
    }

    private void eatPie(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player)
    {
		if (ModCommon.isDebug){ModLog.log().debug("start eat " + this.getRegistryName());}
    	// 回復
        if (player.canEat(false) || player.capabilities.isCreativeMode)
        {
            player.getFoodStats().addStats(_heall, _saturationLevel);
    		if (ModCommon.isDebug){ ModLog.log().debug("(" + _heall + ", " + (_saturationLevel*2.0*_heall) + ")" );}
            int i = ((Integer)state.getValue(BITES)).intValue();

            if (i < 6)
            {
                worldIn.setBlockState(pos, state.withProperty(BITES, Integer.valueOf(i + 1)), 3);
            }
            else
            {
                worldIn.setBlockToAir(pos);
            }
        }

        // ポーション効果
        if (!worldIn.isRemote)
        {
            if (_effect != null)
            {
                for (PotionEffect potioneffect : _effect)
                {
                	player.addPotionEffect(new PotionEffect(potioneffect));
            		ModLog.log().debug("potion:"+potioneffect.getEffectName());
                }
            }
        }
		if (ModCommon.isDebug){ ModLog.log().debug("end" + this.getRegistryName());}
    }


    public Block setHeal(int heal, float saturation){
    	this._heall = heal;
    	this._saturationLevel = saturation;
    	return this;
    }

    public Block setPotionEffect(PotionEffect[] effect){
		_effect = effect;
		return this;
    }


    /**
     * allows items to add custom lines of information to the mouseover description
     */
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced)
    {
        PotionUtils.addPotionTooltip(stack, tooltip, 1.0F);
    }

    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack)
    {
        return !PotionUtils.getEffectsFromStack(stack).isEmpty();
    }
}
