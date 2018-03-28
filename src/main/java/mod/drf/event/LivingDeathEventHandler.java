package mod.drf.event;

import mod.drf.foods.Item.ItemFoods;
import net.minecraft.entity.passive.EntityCow;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


public class LivingDeathEventHandler {
	@SubscribeEvent
	public void onLivingDeathEvent(LivingDeathEvent event) {
		if(event.getEntityLiving().world.isRemote) {
			return;
		}
		if(event.getEntityLiving() instanceof EntityCow) {
			EntityCow cow = (EntityCow)event.getEntityLiving();
			if(cow.isChild() && (cow.world.rand.nextInt(10) < 5)) {
				cow.dropItem(ItemFoods.item_rennet, 1);
			}
		}
	}
}
