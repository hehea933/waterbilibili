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

@Mod("waterbilibili")
public class WaterBilibiliMod {
    public static final String MODID = "waterbilibili";

    // 注册器
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, MODID);
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    // 注册物品：ID 为 "bili_remote"
    // 这意味着你的模型文件必须叫 bili_remote.json，贴图叫 bili_remote.png
    public static final DeferredHolder<Item, BiliRemoteItem> BILI_REMOTE = ITEMS.register("bili_remote", BiliRemoteItem::new);

    // 注册创造模式标签页
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MOD_TAB = TABS.register("waterbilibili_tab", () -> CreativeModeTab.builder()
            // [修改点] 这里改成 translatable，以便在 zh_cn.json 里汉化它
            // 对应的 key 是 "itemGroup.waterbilibili"
            .title(Component.translatable("itemGroup.waterbilibili"))
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