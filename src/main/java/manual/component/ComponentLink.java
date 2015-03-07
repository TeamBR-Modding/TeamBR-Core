package manual.component;

import com.dyonovan.modernalchemy.ModernAlchemy;
import com.dyonovan.modernalchemy.helpers.GuiHelper;
import com.dyonovan.modernalchemy.manual.ManualDirector;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;

public class ComponentLink extends ComponentBase {
    protected String title;
    protected String destination;

    public ComponentLink(String label, String dest) {
        setAlignment(ALIGNMENT.LEFT);
        title = label;
        destination = dest;
    }

    @Override
    public void onMouseLeftClick() {
        if(ManualDirector.getManualRegistry(ModernAlchemy.class).getPage(destination) != null) {
            ManualDirector.getManualRegistry(ModernAlchemy.class).visitNewPage(ManualDirector.getManualRegistry(ModernAlchemy.class).getPage(destination));
        }
        super.onMouseLeftClick();
    }

    @Override
    public void drawComponent(int x, int y, int mouseX, int mouseY) {
        FontRenderer fontRenderer = Minecraft.getMinecraft().fontRenderer;
        int drawX = x + xPos;
        switch(alignment) {
            case RIGHT :
                drawX += 85 - fontRenderer.getStringWidth(title);
                break;
            case CENTER :
                drawX += 53 - (fontRenderer.getStringWidth(title) / 2);
                break;
            case LEFT :
            default :
                drawX += 0;
                break;
        }
        int drawY = y + yPos;
        fontRenderer.drawSplitString(GuiHelper.GuiColor.BLUE + title, drawX, drawY, 110, 4210752);
        super.drawComponent(x, y, mouseX, mouseY);
    }
}
