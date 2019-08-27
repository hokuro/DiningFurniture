package mod.drf.event;

import com.google.common.eventbus.Subscribe;

import mod.drf.foods.Item.ItemFoods;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDeathEvent;


public class LivingDeathEventHandler {
	@Subscribe
	public void onLivingDeathEvent(LivingDeathEvent event) {
		if(event.getEntityLiving().world.isRemote) {
			return;
		}
		if(event.getEntityLiving() instanceof EntityCow) {
			EntityCow cow = (EntityCow)event.getEntityLiving();
			if(cow.isChild() && (cow.world.rand.nextInt(10) < 5)) {
				cow.entityDropItem(new ItemStack(ItemFoods.item_rennet,1));
			}
		}
	}
}
