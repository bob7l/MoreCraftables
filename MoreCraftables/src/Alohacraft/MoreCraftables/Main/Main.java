package Alohacraft.MoreCraftables.Main;

import java.io.File;
import java.util.HashMap;
import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.EnchantmentWrapper;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
    public final Logger logger = Logger.getLogger("Minecraft");
    public static String PluginName = ChatColor.RED + "[MoreCraftables v1.5]: ";
    private final String Disabled = PluginName + "has been disabled!";
    public HashMap<Recipe, String> is = new HashMap<Recipe, String>();
    public HashMap<Recipe, String> bs = new HashMap<Recipe, String>();
    public HashMap<Recipe, String> ar = new HashMap<Recipe, String>();
    public HashMap<Recipe, String> ts = new HashMap<Recipe, String>();
    public HashMap<Recipe, String> me = new HashMap<Recipe, String>();
    private final String Enabled = PluginName + "has been enabled!";

    @Override
    public void onDisable() {
            logger.info(Disabled);
    }

    @Override
    public void onEnable() {
            //Create Config.yml
            if (!new File(this.getDataFolder(), "config.yml").exists()) {
            	this.saveDefaultConfig();
            }
    
            if (getConfig().getBoolean("Permissions") == true) {
            getServer().getPluginManager().registerEvents((Listener) new PermissionsListener(this), this);
    		}
            
//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX [ addRecipe ] XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
//          || Items ||           
            if(this.getConfig().getBoolean("Flint"))
            addRecipeitem(Material.GRAVEL, Material.FLINT);
            if(this.getConfig().getBoolean("Seeds"))
            addRecipeitem(Material.DIRT, Material.SEEDS);
            if(this.getConfig().getBoolean("Leather"))
            addRecipeitem(Material.ROTTEN_FLESH, Material.LEATHER);          

//          || Blocks ||  
            if(this.getConfig().getBoolean("Flatsnow"))
            addRecipeblock(Material.SNOW_BALL, Material.SNOW);
            
//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX [End of Just Recipe ] XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
            
            
            
//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX [ addShapedRecipe ] XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
            
//                  || Blocks ||        
            if(this.getConfig().getBoolean("Cobwebs"))
            addShapedRecipeblock('X', Material.STRING, new String[] { "X X", " X ", "X X" }, Material.WEB);
            
//                  || Items ||
            if(this.getConfig().getBoolean("Feather"))
            addShapedRecipeitem('X', Material.STRING, new String[] { "   ", " X ", "  X" }, Material.FEATHER);

//                  || Armor ||
            if(this.getConfig().getBoolean("ChainHelmet"))
            addShapedRecipearmor('I', Material.IRON_FENCE, new String[] { "III", "I I", "   " }, Material.CHAINMAIL_HELMET);
            if(this.getConfig().getBoolean("ChainChestplate"))
            addShapedRecipearmor('I', Material.IRON_FENCE, new String[] { "I I", "III", "III" }, Material.CHAINMAIL_CHESTPLATE);
            if(this.getConfig().getBoolean("ChainLeggings"))
            addShapedRecipearmor('I', Material.IRON_FENCE, new String[]  { "III", "I I", "I I" }, Material.CHAINMAIL_LEGGINGS);
            if(this.getConfig().getBoolean("ChainBoots"))
            addShapedRecipearmor('I', Material.IRON_FENCE, new String[]  { "   ", "I I", "I I" }, Material.CHAINMAIL_BOOTS);
            
//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX [ End of 1 Shaped] XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX

//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX [ addDoubleShapedRecipe ] XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX          
//          || Blocks ||        
            if(this.getConfig().getBoolean("Grass"))
            addDoubleShapedRecipeblock('S', Material.SEEDS, 'D', Material.DIRT, new String[] { "   ", " S ", " D " }, Material.GRASS);
            if(this.getConfig().getBoolean("Netherbrick"))
            addDoubleShapedRecipeblock('X', Material.NETHERRACK, 'O', Material.SMOOTH_BRICK, new String[] { "XXX", "OOO", "XXX" }, Material.NETHER_BRICK);
            if(this.getConfig().getBoolean("EnderPortalFrame"))
            addDoubleShapedRecipeblock('X', Material.ENDER_STONE, 'O', Material.OBSIDIAN, new String[] { "O O", "XOX", "XXX" }, Material.ENDER_PORTAL_FRAME);
            if(this.getConfig().getBoolean("MossyCobbleStone"))
            addDoubleShapedRecipeblock('S', Material.SEEDS, 'D', Material.COBBLESTONE, new String[] { "   ", " S ", " D " }, Material.MOSSY_COBBLESTONE);
            if(this.getConfig().getBoolean("Sponge"))
            addDoubleShapedRecipeblock('S', Material.STRING, 'W', Material.WOOL, new String[] { "SSS", "SWS", "SSS" }, Material.SPONGE);

//          || Items ||
            if(this.getConfig().getBoolean("Netherwarts")) {
            addDoubleShapedRecipeitem('M', Material.RED_MUSHROOM, 'N', Material.NETHERRACK, new String[] { " N ", "NMN", " N " }, Material.NETHER_WARTS);
            addDoubleShapedRecipeitem('M', Material.BROWN_MUSHROOM, 'N', Material.NETHERRACK, new String[] { " N ", "NMN", " N " }, Material.NETHER_WARTS); }
            if(this.getConfig().getBoolean("Expbottles"))
            addDoubleShapedRecipeitem('G', Material.GLASS, 'E', Material.EMERALD, new String[] { " G ", "GEG", "GGG" }, Material.EXP_BOTTLE);
            if(this.getConfig().getBoolean("GoldHorseArmor"))
            addDoubleShapedRecipeitem('O', Material.GOLD_INGOT, 'W', Material.WOOL, new String[] { "WWO", "OOO", "O O" }, Material.GOLD_BARDING);
            if(this.getConfig().getBoolean("IronHorseArmor"))
            addDoubleShapedRecipeitem('O', Material.IRON_INGOT, 'W', Material.WOOL, new String[] { "WWO", "OOO", "O O" }, Material.IRON_BARDING);
            if(this.getConfig().getBoolean("DiamondHorseArmor"))
            addDoubleShapedRecipeitem('O', Material.DIAMOND, 'W', Material.WOOL, new String[] { "WWO", "OOO", "O O" }, Material.DIAMOND_BARDING);
            if(this.getConfig().getBoolean("Nametag"))
            addDoubleShapedRecipeitem('S', Material.STRING, 'I', Material.IRON_INGOT, new String[] { "S  ", " I ", "  I" }, Material.NAME_TAG);
            if(this.getConfig().getBoolean("Saddle"))
            addDoubleShapedRecipeitem('S', Material.LEATHER, 'D', Material.STRING, new String[] { "SSS", "D D", "   " }, Material.SADDLE);
            if(this.getConfig().getBoolean("Ice"))
            addDoubleShapedRecipeitem('S', Material.SNOW_BALL, 'D', Material.WATER_BUCKET, new String[] { "   ", " S ", " D " }, Material.ICE);           
//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX [ End of 1 Shaped] XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
           
//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX [ DoubleShapless ] XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
//          || Blocks ||
            if(this.getConfig().getBoolean("Obsidian"))
            addDoubleShapelessRecipeblock(Material.LAVA_BUCKET, Material.WATER_BUCKET, Material.OBSIDIAN);
            if(this.getConfig().getBoolean("Clayblock"))
            addDoubleShapelessRecipeblock(Material.SAND, Material.WATER_BUCKET, Material.CLAY);
//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX [ End of DoubleShapless] XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
            
//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX [ TripleShapless ] XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
//          || Blocks ||
            if(this.getConfig().getBoolean("Soulsand"))
            addTripleShapelessRecipeblock(Material.SAND, Material.NETHERRACK, Material.COCOA, Material.SOUL_SAND);
            if(this.getConfig().getBoolean("Mycelium"))
            addTripleShapelessRecipeblock(Material.BROWN_MUSHROOM, Material.RED_MUSHROOM, Material.DIRT, Material.MYCEL);
//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX [ End of TripleShapless] XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX  

//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX [ Quartz Things ] XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
            if(this.getConfig().getBoolean("QuartzTools")) {
            addQuartzTools(Material.IRON_SPADE, "quartzspade", ChatColor.RED + "Quartz Shovel", 34, 1, new String[] { " Q "," S "," S " });
            addQuartzTools(Material.IRON_PICKAXE, "quartzpickaxe", ChatColor.RED + "Quartz Pickaxe", 34, 1, new String[] { "QQQ"," S "," S " });
            addQuartzTools(Material.IRON_AXE, "quartzaxe", ChatColor.RED + "Quartz Axe", 34, 1, new String[] { "QQ ","QS "," S " });
            addQuartzTools(Material.IRON_SWORD, "quartzsword", ChatColor.RED + "Quartz Sword", 16, 1, new String[] { " Q "," Q "," S " });
            addQuartzTools(Material.IRON_HOE, "quartzhoe", ChatColor.RED + "Quartz Hoe", 34, 1, new String[] { "QQ "," S "," S " });
            }
            if(this.getConfig().getBoolean("QuartzArmor")) {
            addQuartzArmor(Material.IRON_HELMET, "quartzhelmet", ChatColor.RED + "Quartz Helmet", 0, 1, new String[] { "QQQ","Q Q","   " });
            addQuartzArmor(Material.IRON_CHESTPLATE, "quartzchestplate", ChatColor.RED + "Quartz Chestplate", 0, 1, new String[] { "Q Q","QQQ","QQQ" });
            addQuartzArmor(Material.IRON_LEGGINGS, "quartzleggings", ChatColor.RED + "Quartz Leggings", 0, 1, new String[] { "QQQ","Q Q","   " });
            addQuartzArmor(Material.IRON_BOOTS, "quartzboots", ChatColor.RED + "Quartz Boots", 0, 1, new String[] { "   ","Q Q","Q Q" });
            }
//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX [ MobEggs ] XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
            if(this.getConfig().getBoolean("MobEggs")) {
            addMobEgg("creeper", 50, Material.SULPHUR);
            addMobEgg("skeleton", 51, Material.ARROW);
            addMobEgg("spider", 52, Material.SPIDER_EYE);
            addMobEgg("zombie", 54, Material.ROTTEN_FLESH);
            addMobEgg("slime", 55, Material.SLIME_BALL);
            addMobEgg("ghast", 56, Material.GHAST_TEAR);
            addMobEgg("zombiepigmen", 57, Material.GOLD_NUGGET);
            addMobEgg("enderman", 58, Material.ENDER_PEARL);
            addMobEgg("cavespider", 59, Material.WEB);
            addMobEgg("silverfish", 60, Material.COOKED_FISH);
            addMobEgg("blaze", 61, Material.BLAZE_ROD);
            addMobEgg("magmacube", 62, Material.MAGMA_CREAM);
            addMobEgg("bat", 65, Material.COCOA);
            addMobEgg("witch", 66, Material.BREWING_STAND);
            addMobEgg("pig", 90, Material.PORK);
            addMobEgg("sheep", 91, Material.WOOL);
            addMobEgg("cow", 92, Material.LEATHER);
            addMobEgg("chicken", 93, Material.RAW_CHICKEN);
            addMobEgg("squid", 94, Material.INK_SACK);
            addMobEgg("wolf", 95, Material.BONE);
            addMobEgg("mooshroom", 96, Material.RED_MUSHROOM);
            addMobEgg("ocelot", 98, Material.RAW_FISH);
            addMobEgg("horse", 100, Material.SADDLE);
            addMobEgg("villager", 120, Material.EMERALD);
            }
//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX [ ETC. ] XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
            
            //Furnace Bedrock Recipes
            if(this.getConfig().getBoolean("Bedrock"))
            addFurnaceRP(7, Material.OBSIDIAN); 

//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX [ End of ETC.] XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX              
            logger.info(Enabled);
    }
//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX [ addQuartz ] XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
    public void addQuartzTools(Material type, String perm, String n, int f, int l, String[] shape) {
        Server server = getServer();
		ItemStack enc = new ItemStack(type);
        ItemMeta meta = enc.getItemMeta();
        meta.setDisplayName(n);
        enc.setItemMeta(meta);
        int effect1 = f;
        int level1 = l;
		EnchantmentWrapper Enchantment = new EnchantmentWrapper(effect1);
		enc.addUnsafeEnchantment(Enchantment, level1);
        ShapedRecipe rec = new ShapedRecipe(new ItemStack(enc));
        rec.shape(shape);
        rec.setIngredient('Q', Material.QUARTZ);
        rec.setIngredient('S', Material.STICK);
        server.addRecipe(rec);
    	ar.put(rec, perm);
	}	
    public void addQuartzArmor(Material type, String perm, String n, int f, int l, String[] shape) {
        Server server = getServer();
		ItemStack enc = new ItemStack(type);
        ItemMeta meta = enc.getItemMeta();
        meta.setDisplayName(n);
        enc.setItemMeta(meta);
        int effect1 = f;
        int level1 = l;
		EnchantmentWrapper Enchantment = new EnchantmentWrapper(effect1);
		enc.addUnsafeEnchantment(Enchantment, level1);
        ShapedRecipe rec = new ShapedRecipe(new ItemStack(enc));
        rec.shape(shape);
        rec.setIngredient('Q', Material.QUARTZ);
        server.addRecipe(rec);
    	ar.put(rec, perm);
	}
//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX [ addMobEgg ] XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
    public void addMobEgg(String perm, int b, Material i) {
    	Server server = getServer();
		ItemStack mbe = new ItemStack(Material.MONSTER_EGG, Byte.valueOf((byte)b));
    	ShapedRecipe rec = new ShapedRecipe(new ItemStack(mbe));
		rec.shape(new String[] { "CEC", "DMD", "CDC" });
		rec.setIngredient('D', Material.DIAMOND);
		rec.setIngredient('E', Material.EGG);
		rec.setIngredient('C', Material.COAL_BLOCK);
    	rec.setIngredient('M', i);
    	server.addRecipe(rec);
    	me.put(rec, perm);
    }
//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX [ addRecipe ] XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
    public void addRecipeitem(Material i, Material type) {
    	Server server = getServer();
    	ShapelessRecipe rec = new ShapelessRecipe(new ItemStack(type));
    	rec.addIngredient(i);
    	server.addRecipe(rec);
    	is.put(rec, type.name().toLowerCase());
    }
    public void addRecipeblock(Material i, Material type) {
    	Server server = getServer();
    	ShapelessRecipe rec = new ShapelessRecipe(new ItemStack(type));
    	rec.addIngredient(i);
    	server.addRecipe(rec);
    	bs.put(rec, type.name().toLowerCase());
    }
  //XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX [ addShapedRecipe ] XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
    public void addShapedRecipeitem(char in1, Material i, String[] shape, Material type) {
    	Server server = getServer();
    	ShapedRecipe rec = new ShapedRecipe(new ItemStack(type));
    	rec.shape(shape);
    	rec.setIngredient(in1, i);
    	server.addRecipe(rec);
    	is.put(rec, type.name().toLowerCase());
    }
    public void addShapedRecipeblock(char in1, Material i, String[] shape, Material type) {
    	Server server = getServer();
    	ShapedRecipe rec = new ShapedRecipe(new ItemStack(type));
    	rec.shape(shape);
    	rec.setIngredient(in1, i);
    	server.addRecipe(rec);
    	bs.put(rec, type.name().toLowerCase());
    }
    public void addShapedRecipearmor(char in1, Material i, String[] shape, Material type) {
    	Server server = getServer();
    	ShapedRecipe rec = new ShapedRecipe(new ItemStack(type));
    	rec.shape(shape);
    	rec.setIngredient(in1, i);
    	server.addRecipe(rec);
    	ar.put(rec, type.name().toLowerCase());
    }
//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX [ addDoubleShapedRecipe ] XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
    public void addDoubleShapedRecipeitem(char in1, Material i, char in2, Material i2, String[] shape, Material type) {
    	Server server = getServer();
    	ShapedRecipe rec = new ShapedRecipe(new ItemStack(type));
    	rec.shape(shape);
    	rec.setIngredient(in1, i);
    	rec.setIngredient(in2, i2);
    	is.put(rec, type.toString().toLowerCase());
    	server.addRecipe(rec);
    }
    public void addDoubleShapedRecipeblock(char in1, Material i, char in2, Material i2, String[] shape, Material type) {
    	Server server = getServer();
    	ShapedRecipe rec = new ShapedRecipe(new ItemStack(type));
    	rec.shape(shape);
    	rec.setIngredient(in1, i);
    	rec.setIngredient(in2, i2);
    	bs.put(rec, type.toString().toLowerCase());
    	server.addRecipe(rec);
    }
//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX [ ETC. METHODS ] XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX  
    public void addDoubleShapelessRecipeblock(Material i, Material d, Material type) {
    	Server server = getServer();
    	ShapelessRecipe rec = new ShapelessRecipe(new ItemStack(type));
    	rec.addIngredient(i);
    	rec.addIngredient(d);
    	server.addRecipe(rec);
    	bs.put(rec, type.name().toLowerCase());
    }
    public void addTripleShapelessRecipeblock(Material i, Material d, Material c, Material type) {
    	Server server = getServer();
    	ShapelessRecipe rec = new ShapelessRecipe(new ItemStack(type));
    	rec.addIngredient(i);
    	rec.addIngredient(d);
    	rec.addIngredient(c);
    	server.addRecipe(rec);
    	bs.put(rec, type.name().toLowerCase());
    }
    public void addFurnaceRP(int i, Material type) {
    	Server server = getServer();
    	FurnaceRecipe rec = new FurnaceRecipe(new ItemStack(i), type);
        server.addRecipe(rec);
        bs.put(rec, type.name().toLowerCase());
    }
//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX [ Commands ] XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

            Player player = (Player) sender;
            if(commandLabel.equalsIgnoreCase("morecraftables")) {
                player.sendMessage(ChatColor.DARK_RED + "----------------[ " + ChatColor.RED + "MoreCraftables v1.5" + ChatColor.DARK_RED + " ]-----------------");
                player.sendMessage(ChatColor.DARK_RED + "| - " + ChatColor.YELLOW + "Plugin Developed By " + ChatColor.RED + "zRA1Nz" + ChatColor.YELLOW + "!");
                player.sendMessage(ChatColor.DARK_RED + "| - " + ChatColor.YELLOW + getConfig().getString("WebsiteForRecipe"));
                player.sendMessage(ChatColor.DARK_RED + "-----------------------------------------------------");
            }
            return true; 
    }
}
