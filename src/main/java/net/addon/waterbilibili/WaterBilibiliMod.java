package net.addon.waterbilibili;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

@Mod("waterbilibili") // 必须与 neoforge.mods.toml 一致
public class WaterBilibiliMod {
    public static final String MODID = "waterbilibili";

    // 注册器
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, MODID);
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    // 注册物品：B站遥控器
    public static final DeferredHolder<Item, BiliRemoteItem> BILI_REMOTE = ITEMS.register("bili_remote", BiliRemoteItem::new);

    // 注册创造模式标签页 (可选，为了方便拿取)
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MOD_TAB = TABS.register("waterbilibili_tab", () -> CreativeModeTab.builder()
            .title(Component.literal("WaterBilibili"))
            .icon(() -> BILI_REMOTE.get().getDefaultInstance())
            .displayItems((params, output) -> {
                output.accept(BILI_REMOTE.get());
            })
            .build());

    public WaterBilibiliMod(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
        TABS.register(modEventBus);
    }
}