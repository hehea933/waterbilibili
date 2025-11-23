# 📺 WaterBilibili (WaterFrames Addon)

**WaterBilibili** 是一个为 [WaterFrames](https://www.curseforge.com/minecraft/mc-mods/waterframes) 设计的拓展模组（Addon）。
它允许玩家在 Minecraft (NeoForge 1.21.1) 的电视、投影仪等屏幕上，直接通过 B 站的 **BV 号** 或 **视频链接** 播放视频。

![Logo](https://via.placeholder.com/150x150?text=WaterBilibili) <!-- 如果你有图标可以替换这里 -->

## ✨ 功能特性 (Features)

*   🔗 **智能解析**：支持输入 `BVxxxxxx` 格式的视频号，自动转换为播放链接。
*   📺 **完美兼容**：直接利用 WaterFrames 的屏幕进行渲染，支持调整大小、音量和距离。
*   🛠️ **简单易用**：只需要一个“B站遥控器” (Bili Remote) 和一个铁砧即可操作。

---

## ⚙️ 前置需求 (Requirements)

在安装本模组前，请确保你已经安装了以下内容：

1.  **Minecraft 1.21.1** (NeoForge)
2.  [WaterFrames](https://www.curseforge.com/minecraft/mc-mods/waterframes) (显示模组)
3.  [WaterMedia](https://www.curseforge.com/minecraft/mc-mods/watermedia-multimedia-api) (底层多媒体引擎)
4.  **[yt-dlp](https://github.com/yt-dlp/yt-dlp/releases) (核心组件，必装！)**

---

## 📥 安装指南 (Installation)

### 1. 放入 Mod 文件
将 `waterbilibili-1.0.0.jar` 以及 WaterFrames 和 WaterMedia 放入你的 `.minecraft/mods` 文件夹。

### 2. 部署 yt-dlp (至关重要！)
由于 WaterMedia 无法原生解析 B 站加密流，**必须** 依赖外部工具 `yt-dlp`。

*   **下载**：前往 [GitHub Releases](https://github.com/yt-dlp/yt-dlp/releases) 下载最新版。
    *   Windows 下载 `yt-dlp.exe`
    *   Linux 下载 `yt-dlp` (并赋予 `chmod +x` 权限)
*   **放置位置**（任选其一，推荐方案 A）：
    *   **方案 A (推荐)**：直接放入系统 `C:\Windows\System32` 目录下（Windows）或 `/usr/local/bin` (Linux)。
    *   **方案 B**：放入 Minecraft 游戏的 **核心运行目录** 下（与 `mods`, `config` 文件夹同级）。

> ⚠️ **注意**：如果你在游戏中遇到 `NoImageException` 或无限转圈，99% 是因为 `yt-dlp` 没有放对位置，或者版本太旧。

### 3. 配置白名单 (Config)
为了允许播放 B 站视频流（非白名单域名），你需要修改服务端配置。

1.  启动一次游戏进入存档/服务器。
2.  找到文件：`saves/你的世界名/serverconfig/waterframes-server.toml` (服务器则在 `world/serverconfig/`)。
3.  修改以下设置：
    ```toml
    [whitelist]
        # 将此项改为 false 以允许 B 站视频
        enable = false
    ```
4.  重启游戏或服务器。

---

## 🎮 使用方法 (Usage)

1.  **准备工具**：从创造模式物品栏拿出 **Bili Remote (B站遥控器)**。
2.  **输入链接**：
    *   将遥控器放入 **铁砧 (Anvil)**。
    *   将名字修改为 B 站视频的 **BV 号** (例如 `BV1f4411M7TC`)。
    *   也可以直接输入完整的 `https://www.bilibili.com/video/...` 链接。
3.  **播放**：
    *   拿着改好名的遥控器，对着 WaterFrames 的屏幕（电视/投影）**右键点击**。
    *   聊天栏提示“已设置”后，等待几秒缓冲即可播放。

---

## ❓ 常见问题 (FAQ)

**Q: 屏幕显示 "NoImageException" 或一直黑屏？**
A: 这意味着 `yt-dlp` 没有被正确调用。
1. 确保你下载了 `yt-dlp`。
2. 确保它放在了正确的位置（推荐 System32）。
3. 确保你的网络能正常访问 B 站。

**Q: 屏幕显示 "URL not allowed in whitelist"？**
A: 你没有关闭 WaterFrames 的白名单。请参考安装指南第 3 步修改 `serverconfig`。

**Q: 只有画面没有声音？**
A: 使用 WaterFrames 自带的遥控器右键屏幕，检查音量设置 (Volume) 和最大声音距离 (Max Distance)。

---

## ⚖️ 免责声明 (Disclaimer)

本模组仅为 Minecraft 提供 Bilibili 视频播放的接口支持，不包含任何视频内容。视频内容的版权归 Bilibili 及原作者所有。请遵守相关法律法规及 Bilibili 服务条款。