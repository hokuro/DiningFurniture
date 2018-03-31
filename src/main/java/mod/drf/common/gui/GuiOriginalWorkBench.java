package mod.drf.common.gui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import org.lwjgl.input.Mouse;

import mod.drf.common.inventory.ContainerOriginalWorkBench;
import mod.drf.common.inventory.InventoryOriginalMenu;
import mod.drf.core.Mod_DiningFurniture;
import mod.drf.foods.network.MessageSelectMenu;
import mod.drf.foods.network.MessageToServe;
import mod.drf.recipie.CookingMenu;
import mod.drf.recipie.OriginalMenu;
import mod.drf.recipie.OriginalMenu.OriginalMenuKind;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.achievement.GuiStats;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ClickType;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import scala.actors.threadpool.Arrays;

@SideOnly(Side.CLIENT)
public class GuiOriginalWorkBench extends GuiContainer {
	private static final int TOPPINGCHANGE_TIMER = 20 * 3;
	private static final int TOPPING_ONESET = 6;
    private final EntityPlayer player;
    private final World world;
    private final BlockPos pos;

    private ResourceLocation tex;

    private final OriginalMenu menu;

    private float currentScroll;
    private int selectMenu;
    private List<ItemStack[]> ingIcon;
    private List<ItemStack[]> topIcon;

    private boolean wasClicking;
    private boolean isScrolling;

	private int dispRecipie = 0;
	private int dispTopping = 0;
	private int timerRecipie = 0;
	private int timerTopping = 0;
	private boolean changeRecipie = true;

	public GuiOriginalWorkBench(EntityPlayer playerIn, World worldIn, BlockPos posIn, OriginalMenu menuIn) {
		super(new ContainerOriginalWorkBench(playerIn.inventory, worldIn, posIn, menuIn));
		player=playerIn;
		world = worldIn;
		pos = posIn;
		menu = menuIn;
		this.xSize = 257;
		this.ySize = 189;

		selectMenu = -1;

	    currentScroll = 0.0F;
	    ingIcon = new ArrayList<ItemStack[]>();
	    topIcon = new ArrayList<ItemStack[]>();
	    if (menu.getKind() == OriginalMenuKind.COOKING){
	    	tex = new ResourceLocation("drf:textures/gui/container/cworkbench.png");
	    }else{
	    	tex = new ResourceLocation("drf:textures/gui/container/dworkbench.png");
	    }

    }

	@Override
	public void initGui(){
		super.initGui();
		this.buttonList.clear();
		String s = net.minecraft.util.text.translation.I18n.translateToLocal("button.originalworkbench.create");
        buttonList.add(new GuiButton(101, 200, 105, 55, 20,  s));
	}

	@Override
	protected void handleMouseClick(@Nullable Slot slotIn, int slotId, int mouseButton, ClickType type)
    {
        ContainerOriginalWorkBench inv = (ContainerOriginalWorkBench)this.inventorySlots;
        if (slotIn != null){
        	// メニュースロットがクリックされたか?
        	if (slotIn.inventory == inv.getMenu()){
        		if(!slotIn.getStack().isEmpty()){
        			// 選択されたメニューの番号を計算
        			int selectSlot = slotId - inv.getMenuStart();

        			selectMenu = selectSlot + inv.getMenu().getField(InventoryOriginalMenu.FIELD_SCROLL) * InventoryOriginalMenu.COL;

        			List<OriginalMenu> m = menu.getMenuInfo(selectMenu);

        			// 許可リスト
        			List<List<ItemStack>> arrow = new ArrayList<List<ItemStack>>();
        			for (int i = 0; i < menu.getKind().getLength(); i++){
        				arrow.add(new ArrayList());
        			}

        			// 材料を取得
        			this.ingIcon.clear();
        			this.topIcon.clear();
        			for (OriginalMenu mitem : m){
        				ingIcon.add(new ItemStack[mitem.getIgetIngreadientCount()]);
        				for (int i = 0; i < mitem.getIgetIngreadientCount(); i++){
        					ingIcon.get(ingIcon.size()-1)[i] = mitem.getIngredient(i);
        					arrow.get(i).add(mitem.getIngredient(i));
        				}

        				if (menu.getKind() == OriginalMenuKind.COOKING){
        					if (((CookingMenu)mitem).isTopping()){
        						CookingMenu cm = ((CookingMenu)mitem);
        						topIcon.add(cm.getToppings());
        						arrow.get(menu.getKind().getLength()-1).addAll(Arrays.asList(cm.getToppings()));
        					}else{
        						topIcon.add(new ItemStack[]{ItemStack.EMPTY});
        					}
        				}

        			}

        			inv.setArrowIngredients(arrow);
        			dispRecipie = 0;
        			dispTopping = 0;
        			timerRecipie = 0;
        			timerTopping = 0;

        			// サーバーに送信
        			Mod_DiningFurniture.Net_Instance.sendToServer(new MessageSelectMenu(this.currentScroll,selectSlot));
        		}
        		return;
        	}else if (slotIn.inventory == inv.getResult()){
        		// 結果
        		return;
        	}else{
        		 slotId = slotIn.slotNumber;
        	}
        }
        this.mc.playerController.windowClick(this.inventorySlots.windowId, slotId, mouseButton, type, this.mc.player);
    }

	@Override
    public void handleMouseInput() throws IOException
    {
        super.handleMouseInput();
        int i = Mouse.getEventDWheel();

        InventoryOriginalMenu inv = ((InventoryOriginalMenu)(((ContainerOriginalWorkBench)this.inventorySlots).getMenu()));
        if (i != 0 && inv.needScroll())
        {
            int j = (inv.menuCount() + 3- 1) / 3 - 8;

            if (i > 0)
            {
                i = 1;
            }

            if (i < 0)
            {
                i = -1;
            }

            this.currentScroll = (float)((double)this.currentScroll - (double)i / (double)j);
            this.currentScroll = MathHelper.clamp(this.currentScroll, 0.0F, 1.0F);
            inv.scrollTo(this.currentScroll);
        }
    }

	@Override
    protected void actionPerformed(GuiButton button) throws IOException
    {
        if (button.id == 1)
        {
            this.mc.displayGuiScreen(new GuiStats(this, this.mc.player.getStatFileWriter()));
        }

        if (button.id == 101)
        {
        	// サーバーに送信
			Mod_DiningFurniture.Net_Instance.sendToServer(new MessageToServe());
        }
    }


    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        String s;
        if (menu.getKind() == OriginalMenuKind.COOKING){
        	s = net.minecraft.util.text.translation.I18n.translateToLocal("cooking workbench");
        }else{
        	s = net.minecraft.util.text.translation.I18n.translateToLocal("furniture workbench");
        }
        String s2 = net.minecraft.util.text.translation.I18n.translateToLocal("menu");
        this.fontRenderer.drawString(s, this.xSize / 4 - this.fontRenderer.getStringWidth(s) / 2, 6, 4210752);
        this.fontRenderer.drawString(s2, this.xSize * 3 / 4 - this.fontRenderer.getStringWidth(s2) / 2, 6, 4210752);
        this.fontRenderer.drawString(I18n.format("container.inventory"), 8, this.ySize - 96 + 2, 4210752);

        if (ingIcon.size() != 0){
        	int cnting = 0;
        	for (ItemStack ing : ingIcon.get(dispRecipie)){
        		if (!ing.isEmpty()){
        			this.drawItemStack2(ing, 8 + cnting*18, 16, null);
        			cnting++;
        		}
        		timerRecipie++;
        		if (timerRecipie > TOPPINGCHANGE_TIMER*2 && changeRecipie){
        			timerRecipie = 0;
        			dispRecipie++;
        			if (dispRecipie >= ingIcon.size()){
        				dispRecipie = 0;
        			}
        		}
        	}
        	if (!topIcon.get(dispRecipie)[0].isEmpty()){
        		changeRecipie = false;
        		int cntTop = topIcon.get(dispRecipie).length;
        		int drawLeft = 8 + 18 * (6 - ((cntTop-TOPPING_ONESET*dispTopping)>6?6:cntTop));

        		int lpstart = TOPPING_ONESET*dispTopping;
        		int lpmax =  (cntTop<TOPPING_ONESET+TOPPING_ONESET*dispTopping?cntTop:TOPPING_ONESET+TOPPING_ONESET*dispTopping);
        		for (int i = lpstart; i < lpmax; i++){
            		this.drawItemStack2(topIcon.get(dispRecipie)[i+TOPPING_ONESET*dispTopping], drawLeft + (i*18), 59, null);
        		}
        		timerTopping++;
        		if (timerTopping > TOPPINGCHANGE_TIMER){
        			timerTopping = 0;
        			dispTopping++;
        			if ((dispTopping >= MathHelper.ceil(cntTop/TOPPING_ONESET))){;
        				dispTopping = 0;
        				changeRecipie = true;
        			}
        		}
        	}else{
        		changeRecipie = true;
        	}
        }
    }

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(tex);
        int i = (this.width - this.xSize) / 2;
        int j = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize);

        this.mc.getTextureManager().bindTexture(new ResourceLocation("textures/gui/container/creative_inventory/tabs.png"));
        int scl = this.guiLeft + 236;
        int scu = this.guiTop + 16;
        int sch = scu + 162;
        this.drawTexturedModalRect(scl,
        		scu + (int)((float)(sch - scu - 17) * this.currentScroll),
        		232 + (((InventoryOriginalMenu)((ContainerOriginalWorkBench)this.inventorySlots).getMenu()).needScroll() ? 0 : 12),
        		0,
        		12,
        		15);
	}


	@Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        this.drawDefaultBackground();
        boolean flag = Mouse.isButtonDown(0);
        int i = this.guiLeft;
        int j = this.guiTop;
        int k = i + 236;
        int l = j + 16;
        int i1 = k + 13;
        int j1 = l + 158;

        if (!this.wasClicking && flag && mouseX >= k && mouseY >= l && mouseX < i1 && mouseY < j1)
        {
            this.isScrolling = ((InventoryOriginalMenu)((ContainerOriginalWorkBench)this.inventorySlots).getMenu()).needScroll();
        }

        if (!flag)
        {
            this.isScrolling = false;
        }

        this.wasClicking = flag;

        if (this.isScrolling)
        {
            this.currentScroll = ((float)(mouseY - l) - 7.5F) / ((float)(j1 - l) - 15.0F);
            this.currentScroll = MathHelper.clamp(this.currentScroll, 0.0F, 1.0F);
            ((InventoryOriginalMenu)((ContainerOriginalWorkBench)this.inventorySlots).getMenu()).scrollTo(this.currentScroll);
        }

        super.drawScreen(mouseX, mouseY, partialTicks);

        this.renderHoveredToolTip(mouseX, mouseY);
    }

	@Override
    public void onGuiClosed()
    {
        super.onGuiClosed();
    }


    private void drawItemStack2(ItemStack stack, int x, int y, String altText)
    {
        GlStateManager.translate(0.0F, 0.0F, 32.0F);
        float zLevel = 200.0F;
        RenderItem itemRender = Minecraft.getMinecraft().getRenderItem();
        itemRender.zLevel = 200.0F;
        net.minecraft.client.gui.FontRenderer font = stack.getItem().getFontRenderer(stack);
        if (font == null) font = Minecraft.getMinecraft().fontRenderer;
        itemRender.renderItemAndEffectIntoGUI(stack, x, y);
        itemRender.renderItemOverlayIntoGUI(font, stack, x, y , altText);
        zLevel = 0.0F;
        itemRender.zLevel = 0.0F;
    }

    protected void renderHoveredToolTip(int p_191948_1_, int p_191948_2_)
    {
        if (this.mc.player.inventory.getItemStack().isEmpty() && this.getSlotUnderMouse() != null && this.getSlotUnderMouse().getHasStack())
        {
        	if (this.getSlotUnderMouse().inventory == ((ContainerOriginalWorkBench)this.inventorySlots).getMenu() ||
        			this.getSlotUnderMouse().inventory == ((ContainerOriginalWorkBench)this.inventorySlots).getResult()){
        		this.renderToolTip(this.getSlotUnderMouse().getStack(), p_191948_1_, p_191948_2_);
        	}
        }
    }
}
