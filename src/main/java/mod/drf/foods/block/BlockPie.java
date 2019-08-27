package mod.drf.foods.block;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;

import mod.drf.config.ConfigValue;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCake;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

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
		super(Block.Properties.create(Material.CAKE).
				hardnessAndResistance(0.5F)
				.sound(SoundType.CLOTH));
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
	public boolean onBlockActivated(IBlockState state, World worldIn, BlockPos pos, EntityPlayer playerIn, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
        this.eatPie(worldIn, pos, state, playerIn);
        return true;
    }

	@Override
	public void onBlockClicked(IBlockState state, World worldIn, BlockPos pos, EntityPlayer playerIn) {
        this.eatPie(worldIn, pos, worldIn.getBlockState(pos), playerIn);
    }

    private void eatPie(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player)
    {
    	// 回復
        if (player.canEat(ConfigValue.piecake.CanEatAllways()) || player.isCreative())
        {
            player.getFoodStats().addStats(_heall, _saturationLevel);
            int i = ((Integer)state.getValues().get(BITES)).intValue();

            if (i < 6)
            {
                worldIn.setBlockState(pos, state.with(BITES, Integer.valueOf(i + 1)), 3);
            }
            else
            {
                worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
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
                }
            }
        }
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



    @Override
    @OnlyIn(Dist.CLIENT)
    public void addInformation(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        PotionUtils.addPotionTooltip(stack, tooltip, 1.0F);
    }


    public boolean hasEffect(ItemStack stack)
    {
        return !PotionUtils.getEffectsFromStack(stack).isEmpty();
    }
}
