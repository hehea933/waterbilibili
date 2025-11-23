package net.addon.waterbilibili;

// 引入正确的 DisplayTile
import me.srrapero720.waterframes.common.block.entity.DisplayTile;
// 引入 URI 处理工具
import java.net.URI;

import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.entity.BlockEntity;

public class BiliRemoteItem extends Item {

    public BiliRemoteItem() {
        super(new Properties().stacksTo(1));
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        if (context.getLevel().isClientSide) {
            return InteractionResult.SUCCESS;
        }

        BlockEntity be = context.getLevel().getBlockEntity(context.getClickedPos());

        // 检查是否为屏幕实体
        if (be instanceof DisplayTile displayTile) {
            ItemStack stack = context.getItemInHand();

            // 检查是否有命名
            if (stack.has(DataComponents.CUSTOM_NAME)) {

                String input = stack.getHoverName().getString().trim();
                String finalUrl = input;

                // 处理 B 站链接
                if (input.startsWith("BV") || input.startsWith("bv")) {
                    finalUrl = "https://www.bilibili.com/video/" + input;
                } else if (!input.startsWith("http")) {
                    context.getPlayer().sendSystemMessage(Component.literal("§c格式错误，请输入 BV号 或 HTTP链接"));
                    return InteractionResult.FAIL;
                }

                try {
                    // 核心修正：将 String 转换为 URI 并赋值给 data.uri
                    displayTile.data.uri = URI.create(finalUrl);

                    // 保存并同步
                    displayTile.setChanged();

                    context.getPlayer().sendSystemMessage(Component.literal("§a[WaterBilibili] 已设置: " + finalUrl));
                } catch (Exception e) {
                    context.getPlayer().sendSystemMessage(Component.literal("§cURI 格式错误: " + e.getMessage()));
                    e.printStackTrace();
                }

                return InteractionResult.CONSUME;
            } else {
                context.getPlayer().sendSystemMessage(Component.literal("§e请先在铁砧中将此物品重命名为 BV号"));
                return InteractionResult.FAIL;
            }
        }

        return InteractionResult.PASS;
    }
}