package mod.drf.gui;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import com.mojang.blaze3d.platform.GlStateManager;

import mod.drf.inventory.ContainerFurnitureWorkBench;
import mod.drf.inventory.InventoryOriginalMenu;
import mod.drf.network.MessageHandler;
import mod.drf.recipie.FurnitureMenu;
import mod.drf.recipie.OriginalMenu;
import mod.drf.recipie.OriginalMenu.OriginalMenuKind;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.ClickType;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;


@OnlyIn(Dist.CLIENT)
public class GuiFurnitureWorkBench extends ContainerScreen<ContainerFurnitureWorkBench> {
	private static final int TOPPINGCHANGE_TIMER = 20 * 3;
	private static final int TOPPING_ONESET = 6;
    private static final ResourceLocation tex = new ResourceLocation("drf:textures/gui/container/dworkbench.png");

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

	public GuiFurnitureWorkBench(ContainerFurnitureWorkBench container, PlayerInventory playerInv, ITextComponent title) {
		super(container,playerInv,title);
		menu = FurnitureMenu.getInstance();
		this.xSize = 257;
		this.ySize = 189;

		selectMenu = -1;

	    currentScroll = 0.0F;
	    ingIcon = new ArrayList<ItemStack[]>();
	    topIcon = new ArrayList<ItemStack[]>();
	}

	@Override
	public void init(){
		super.init();
		this.buttons.clear();
		String s = I18n.format("button.originalworkbench.create");
		this.addButton(new Button(200, 105, 55, 20, s, (bt)-> {MessageHandler.Send_MessageToServer();}));
	}

	@Override
	protected void handleMouseClick(@Nullable Slot slotIn, int slotId, int mouseButton, ClickType type)
    {
        if (slotIn != null){
        	// メニュースロットがクリックされたか?
        	if (slotIn.inventory == container.getMenu()){
        		if(!slotIn.getStack().isEmpty()){
        			// 選択されたメニューの番号を計算
        			int selectSlot = slotId - container.getMenuStart();

        			selectMenu = selectSlot + ((InventoryOriginalMenu)container.getMenu()).getField(InventoryOriginalMenu.FIELD_SCROLL) * InventoryOriginalMenu.COL;

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
        			}

        			container.setArrowIngredients(arrow);
        			dispRecipie = 0;
        			dispTopping = 0;
        			timerRecipie = 0;
        			timerTopping = 0;

        			// サーバーに送信
        			MessageHandler.Send_MessageSelectMenu(this.currentScroll,selectSlot);
        		}
        		return;
        	}else if (slotIn.inventory == container.getResult()){
        		// 結果
        		return;
        	}else{
        		 slotId = slotIn.slotNumber;
        	}
        }
        super.handleMouseClick(slotIn, slotId, mouseButton, type);
    }

	@Override
	public boolean mouseClicked(double mouseX, double mouseY, int mouseButton) {
		if(mouseButton == 0) {
			double d0 = mouseX - (double)this.guiLeft;
			double d1 = mouseY - (double)this.guiTop;
			if (mouseX >= 320 && mouseX <= 335 && mouseY >= 40 && mouseY <= 200 ) {
				this.isScrolling = ((InventoryOriginalMenu)(container.getMenu())).needScroll();
				return this.isScrolling;
			}
		}
		return super.mouseClicked(mouseX, mouseY, mouseButton);
	}

	@Override
	public boolean mouseReleased(double p_mouseReleased_1_, double p_mouseReleased_3_, int p_mouseReleased_5_) {
		if (p_mouseReleased_5_ == 0) {
			double d0 = p_mouseReleased_1_ - (double)this.guiLeft;
			double d1 = p_mouseReleased_3_ - (double)this.guiTop;
			this.isScrolling = false;
			return  super.mouseReleased(p_mouseReleased_1_, p_mouseReleased_3_, p_mouseReleased_5_);//((InventoryOriginalMenu)((ContainerOriginalWorkBench)this.inventorySlots).getMenu()).needScroll();
		}
		return super.mouseReleased(p_mouseReleased_1_, p_mouseReleased_3_, p_mouseReleased_5_);
	}

	@Override
	public boolean mouseDragged(double p_mouseDragged_1_, double p_mouseDragged_3_, int p_mouseDragged_5_, double p_mouseDragged_6_, double p_mouseDragged_8_) {
		if (this.isScrolling) {
			int i = this.guiTop + 18;
			int j = i + 112;
            this.currentScroll = ((float)(p_mouseDragged_3_ - i) - 7.5F) / ((float)(j - i) - 15.0F);
            this.currentScroll = MathHelper.clamp(this.currentScroll, 0.0F, 1.0F);
            ((InventoryOriginalMenu)(container.getMenu())).scrollTo(this.currentScroll);
			return true;
		} else {
			return super.mouseDragged(p_mouseDragged_1_, p_mouseDragged_3_, p_mouseDragged_5_, p_mouseDragged_6_, p_mouseDragged_8_);
		}
	}

	@Override
	public boolean mouseScrolled(double scrolle, double p_mouseScrolled_3_, double p_mouseScrolled_5_) {
        InventoryOriginalMenu inv = ((InventoryOriginalMenu)container.getMenu());
        if (scrolle != 0 && inv.needScroll())
        {
        	int j = (inv.menuCount() + 3- 1) / 3 - 8;

        	if (p_mouseScrolled_5_ > 1.0D) {
        		p_mouseScrolled_5_ = 1.0D;
        	}
        	if (p_mouseScrolled_5_ < -1.0D) {
        		p_mouseScrolled_5_ = -1.0D;
        	}
            this.currentScroll = (float)((double)this.currentScroll - (double)p_mouseScrolled_5_ / (double)j);
            this.currentScroll = MathHelper.clamp(this.currentScroll, 0.0F, 1.0F);
            inv.scrollTo(this.currentScroll);
        }
        return true;
	}

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        String s;
        if (menu.getKind() == OriginalMenuKind.COOKING){
        	s = I18n.format("cooking workbench");
        }else{
        	s = I18n.format("furniture workbench");
        }
        String s2 = I18n.format("menu");
        this.font.drawString(s, this.xSize / 4 - this.font.getStringWidth(s) / 2, 6, 4210752);
        this.font.drawString(s2, this.xSize * 3 / 4 - this.font.getStringWidth(s2) / 2, 6, 4210752);
        this.font.drawString(I18n.format("container.inventory"), 8, this.ySize - 96 + 2, 4210752);

        if (ingIcon.size() != 0){
        	int cnting = 0;
        	for (ItemStack ing : ingIcon.get(dispRecipie)){
        		if (!ing.isEmpty()){
        			this.drawItemStack2(ing, 8 + cnting*18, 16, "");
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
        	if (topIcon.size() > 0 && topIcon.get(dispRecipie).length > 0 && !topIcon.get(dispRecipie)[0].isEmpty()){
        		changeRecipie = false;
        		int cntTop = topIcon.get(dispRecipie).length;
        		int drawLeft = 8 + 18 * (6 - ((cntTop-TOPPING_ONESET*dispTopping)>6?6:cntTop));

        		int lpstart = TOPPING_ONESET*dispTopping;
        		int lpmax =  (cntTop<TOPPING_ONESET+TOPPING_ONESET*dispTopping?cntTop:TOPPING_ONESET+TOPPING_ONESET*dispTopping);
        		for (int i = lpstart; i < lpmax; i++){
        			this.drawItemStack2(topIcon.get(dispRecipie)[i], drawLeft + ((i-TOPPING_ONESET*dispTopping)*18), 59, null);
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
        GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        Minecraft.getInstance().getTextureManager().bindTexture(tex);
        int i = (this.width - this.xSize) / 2;
        int j = (this.height - this.ySize) / 2;
        this.blit(i, j, 0, 0, this.xSize, this.ySize);

        Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("textures/gui/container/creative_inventory/tabs.png"));
        int scl = this.guiLeft + 236;
        int scu = this.guiTop + 16;
        int sch = scu + 162;
        this.blit(scl,
        		scu + (int)((float)(sch - scu - 17) * this.currentScroll),
        		232 + (((InventoryOriginalMenu)(container.getMenu())).needScroll() ? 0 : 12),
        		0,
        		12,
        		15);
	}


	@Override
    public void render(int mouseX, int mouseY, float partialTicks)
    {
        this.renderBackground();
        super.render(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }

    @Override
    protected void renderHoveredToolTip(int p_191948_1_, int p_191948_2_)
    {
        if (Minecraft.getInstance().player.inventory.getItemStack().isEmpty() && this.getSlotUnderMouse() != null && this.getSlotUnderMouse().getHasStack())
        {
        	if (this.getSlotUnderMouse().inventory == container.getMenu() ||
        			this.getSlotUnderMouse().inventory == container.getResult()){
        		List<String> tooltip = getTooltipFromItem(this.getSlotUnderMouse().getStack());
        		this.renderTooltip(tooltip,p_191948_1_, p_191948_2_);
        	}
        }
    }

    private void drawItemStack2(ItemStack stack, int x, int y, String altText)
    {
        GlStateManager.translatef(0.0F, 0.0F, 32.0F);
        this.itemRenderer.zLevel = 200.0F;
        net.minecraft.client.gui.FontRenderer font = stack.getItem().getFontRenderer(stack);
        if (font == null) font = this.font;
        this.itemRenderer.renderItemAndEffectIntoGUI(stack, x, y);
        this.itemRenderer.renderItemOverlayIntoGUI(font, stack, x, y, altText);
        this.itemRenderer.zLevel = 0.0F;
    }



    private boolean needsScrollBars() {
        return  true;
     }

    protected boolean func_195376_a(double p_195376_1_, double p_195376_3_) {
        int i = this.guiLeft;
        int j = this.guiTop;
        int k = i + 175;
        int l = j + 18;
        int i1 = k + 14;
        int j1 = l + 112;
        return p_195376_1_ >= (double)k && p_195376_3_ >= (double)l && p_195376_1_ < (double)i1 && p_195376_3_ < (double)j1;
     }
}
