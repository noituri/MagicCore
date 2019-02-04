package dreavedir.magiccore.common.events;

import dreavedir.magiccore.common.gui.overlay.TitleMessages;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class OverlayRenderHandler {

    public static OverlayRenderHandler instance = new OverlayRenderHandler();

    private String message = "";
    private String submessage = "";
    private int time = 1;
    private int scaleX = 1;
    private int scaleY = 1;
    private int scaleZ = 1;

    private Boolean showMessage = false;

    public void showMessage(String message, String submessage, int time, int scaleX, int scaleY, int scaleZ) {
        this.message = message;
        this.time = time;
        this.scaleX = scaleX;
        this.scaleY = scaleY;
        this.scaleZ = scaleZ;
        this.submessage = submessage;

        showMessage = true;
    }

    @SubscribeEvent
    public void onRenderGui(RenderGameOverlayEvent.Text event) {
        if (event.getType() == RenderGameOverlayEvent.ElementType.EXPERIENCE || !showMessage)
            return;

        new TitleMessages(Minecraft.getMinecraft(), message, submessage, time, scaleX, scaleY, scaleZ);

//        showMessage = false;
    }
}