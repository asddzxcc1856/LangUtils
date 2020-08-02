package com.meowj.langutils.lang;

import com.meowj.langutils.LangUtils;
import com.meowj.langutils.lang.convert.*;
import com.meowj.langutils.locale.LocaleHelper;
import org.bukkit.Material;
import org.bukkit.block.Biome;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import java.util.Map;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.inventory.meta.SkullMeta;


public class LanguageHelper {

    /**
     * Return the display name of the item.
     *
     * @param item   The item
     * @param locale The language of the item(if the item doesn't have a customized name, the method will return the name of the item in this language)
     * @return The name of the item
     */
    public static String getItemDisplayName(final ItemStack item, final String locale) {
        if (item.hasItemMeta() && item.getItemMeta().hasDisplayName())
            return item.getItemMeta().getDisplayName();
        else
            return getItemName(item, locale);
    }

    /**
     * Return the display name of the item.
     *
     * @param item   The item
     * @param player The receiver of the name
     * @return The name of the item
     */
    public static String getItemDisplayName(final ItemStack item, final Player player) {
        return getItemDisplayName(item, LocaleHelper.getPlayerLanguage(player));
    }

    /**
     * Return the localized name of the item.
     *
     * @param item   The item
     * @param locale The language of the item
     * @return The localized name. if the item doesn't have a localized name, this method will return the unlocalized name of it.
     */
    public static String getItemName(final ItemStack item, final String locale) {
        // Potion & SpawnEgg & Player Skull
        if (item.getType() == Material.POTION || item.getType() == Material.SPLASH_POTION || item.getType() == Material.LINGERING_POTION || item.getType() == Material.TIPPED_ARROW) {
            //final PotionMeta potionMeta = (PotionMeta) item.getItemMeta();
            //final PotionType type = potionMeta.getBasePotionData().getType();
//System.out.println("getItemName()="+getItemUnlocalizedName(item.getType())+".effect."+((PotionMeta) item.getItemMeta()).getBasePotionData().getType().toString().toLowerCase());
            return translateToLocal( getItemUnlocalizedName(item.getType())+".effect."+((PotionMeta) item.getItemMeta()).getBasePotionData().getType().toString().toLowerCase(), locale);
            
        /*switch (item.getType()) {
            case SPLASH_POTION:
                return getItemUnlocalizedName(item.getType());
                return LanguageHelper.translateToLocal(getUnlocalizedSplashName(itemStack), locale);
            case LINGERING_POTION:
                return LanguageHelper.translateToLocal(getUnlocalizedLingeringName(itemStack), locale);
            case TIPPED_ARROW:
                return LanguageHelper.translateToLocal(getUnlocalizedArrowName(itemStack), locale);
            default:
                break;
        }*/


            //return EnumPotionEffect.getLocalizedName(item, locale);
        } else if (item.getType() == Material.PLAYER_HEAD || item.getType() == Material.PLAYER_WALL_HEAD) { // is player's skull
            return getPlayerSkullName(item, locale);
        }

        return translateToLocal(getItemUnlocalizedName(item.getType()), locale);
    }
    
    
    /**
     * Return the localized name of the item.
     *
     * @param mat   The Material
     * @param locale The language of the item
     * @return The localized name. if the item doesn't have a localized name, this method will return the unlocalized name of it. Except Potion! For Potions use getItemName!
     */
    public static String getMaterialName(final Material mat, final String locale) {
        return translateToLocal(getItemUnlocalizedName(mat), locale);
    }

    
    
    private static String getPlayerSkullName(final ItemStack skull, final String locale) {
        SkullMeta meta = (SkullMeta) skull.getItemMeta();
        if (meta!=null && meta.hasOwner()) {
            return String.format(LanguageHelper.translateToLocal("block.minecraft.player_head.named", locale),
                    meta.getOwningPlayer().getName());
        } else return LanguageHelper.translateToLocal("block.minecraft.player_head", locale);
    }    /**
     * Return the localized name of the item.
     *
     * @param item   The item
     * @param player The receiver of the name
     * @return The localized name. if the item doesn't have a localized name, this method will return the unlocalized name of it.
     */
    
    public static String getItemName(final ItemStack item, final Player player) {
        return getItemName(item, LocaleHelper.getPlayerLanguage(player));
    }

    
    














    
    
    

    /**
     * Return the localized name of the biome.
     *
     * @param biome The biome
     * @param locale The language of the biome
     * @return The localized name. if the biome doesn't have a localized name, this method will return the unlocalized name of it.
     */
    public static String getBiomeName(final Biome biome, final String locale) {
        return translateToLocal(getBiomeUnlocalizedName(biome), locale);
    }

    /**
     * Return the localized name of the biome.
     *
     * @param biome The biome
     * @param player The receiver of the biome
     * @return The localized name. if the biome doesn't have a localized name, this method will return the unlocalized name of it.
     */
    public static String getBiomeName(final Biome biome, final Player player) {
        return getBiomeName(biome, LocaleHelper.getPlayerLanguage(player));
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /**
     * Return the display name of the entity.
     *
     * @param entity The entity
     * @param locale The language of the entity(if the entity doesn't have a customized name, the method will return the name of the entity in this language)
     * @return The name of the entity
     */
    public static String getEntityDisplayName(final Entity entity, final String locale) {
        return entity.getCustomName() != null ? entity.getCustomName() :
                getEntityName(entity, locale);
    }

    /**
     * Return the display name of the entity.
     *
     * @param entity The entity
     * @param player The receiver of the name
     * @return The name of the entity
     */
    public static String getEntityDisplayName(final Entity entity, final Player player) {
        return getEntityDisplayName(entity, LocaleHelper.getPlayerLanguage(player));
    }

    /**
     * Return the localized name of the entity.
     *
     * @param entity The entity
     * @param locale The language of the item
     * @return The localized name. if the entity doesn't have a localized name, this method will return the unlocalized name of it.
     */
    public static String getEntityName(final Entity entity, final String locale) {
        return translateToLocal(getEntityUnlocalizedName(entity), locale);
    }

    /**
     * Return the localized name of the entity.
     *
     * @param entity The entity
     * @param player The receiver of the entity
     * @return The localized name. if the entity doesn't have a localized name, this method will return the unlocalized name of it.
     */
    public static String getEntityName(final Entity entity, final Player player) {
        return getEntityName(entity, LocaleHelper.getPlayerLanguage(player));
    }

    /**
     * Return the localized name of the entity.
     *
     * @param entityType The EntityType of the entity
     * @param locale     The language of the item
     * @return The localized name. if the entity doesn't have a localized name, this method will return the unlocalized name of it.
     */
    public static String getEntityName(final EntityType entityType, final String locale) {
        return translateToLocal(getEntityUnlocalizedName(entityType), locale);
    }

    /**
     * Return the localized name of the entity.
     *
     * @param entityType The EntityType of the entity
     * @param player     The receiver of the entity
     * @return The localized name. if the entity doesn't have a localized name, this method will return the unlocalized name of it.
     */
    public static String getEntityName(final EntityType entityType, final Player player) {
        return getEntityName(entityType, LocaleHelper.getPlayerLanguage(player));
    }




















    


















    /**
     * Return the name of the enchantment level
     *
     * @param level  The enchantment level
     * @param player The language of the level
     * @return The name of the level.(if level is greater than 10, it will only return the number of the level)
     */
    public static String getEnchantmentLevelName(final int level, final Player player) {
        return translateToLocal(getEnchantmentLevelUnlocalizedName(level), LocaleHelper.getPlayerLanguage(player));
    }

    /**
     * Return the name of the enchantment level
     *
     * @param level  The enchantment level
     * @param locale The language of the level
     * @return The name of the level.(if level is greater than 10, it will only return the number of the level)
     */
    public static String getEnchantmentLevelName(final int level, final String locale) {
        return translateToLocal(getEnchantmentLevelUnlocalizedName(level), locale);
    }

    /**
     * Return the name of the enchantment.
     *
     * @param enchantment The enchantment
     * @param player      The receiver of the name
     * @return The name of the enchantment
     */
    public static String getEnchantmentName(final Enchantment enchantment, final Player player) {
        return getEnchantmentName(enchantment, LocaleHelper.getPlayerLanguage(player));
    }

    /**
     * Return the name of the enchantment.
     *
     * @param enchantment The enchantment
     * @param locale      The language of the name
     * @return The name of the enchantment
     */
    public static String getEnchantmentName(final Enchantment enchantment, final String locale) {
        return translateToLocal(getEnchantmentUnlocalizedName(enchantment), locale);
    }

    /**
     * Return the display name of the enchantment(with level).
     *
     * @param enchantment The enchantment
     * @param level       The enchantment level
     * @param player      The receiver of the name
     * @return The name of the item
     */
    public static String getEnchantmentDisplayName(final Enchantment enchantment, final int level, final Player player) {
        return getEnchantmentDisplayName(enchantment, level, LocaleHelper.getPlayerLanguage(player));
    }

    /**
     * Return the display name of the enchantment(with level).
     *
     * @param enchantment The enchantment
     * @param level       The enchantment level
     * @param locale      The language of the name
     * @return The name of the item
     */
    public static String getEnchantmentDisplayName(final Enchantment enchantment, final int level, final String locale) {
        String name = getEnchantmentName(enchantment, locale);
        String enchLevel = getEnchantmentLevelName(level, locale);
        return name + (enchLevel.length() > 0 ? " " + enchLevel : "");
    }

    /**
     * Return the display name of the enchantment(with level).
     *
     * @param entry  The Entry of an enchantment with level The type is {@code Map.Entry<Enchantment, Integer>}
     * @param locale The language of the name
     * @return The name of the item
     */
    public static String getEnchantmentDisplayName(final Map.Entry<Enchantment, Integer> entry, final String locale) {
        return getEnchantmentDisplayName(entry.getKey(), entry.getValue(), locale);
    }

    /**
     * Return the display name of the enchantment(with level).
     *
     * @param entry  The Entry of an enchantment with level The type is {@code Map.Entry<Enchantment, Integer>}
     * @param player The receiver of the name
     * @return The name of the item
     */
    public static String getEnchantmentDisplayName(final Map.Entry<Enchantment, Integer> entry, final Player player) {
        return getEnchantmentDisplayName(entry.getKey(), entry.getValue(), player);
    }






















    
    
    
    
    
    
    
    
    
    /**
     * Return the unlocalized name of the item(Minecraft convention)
     *
     * @param mat is Material
     * @return The unlocalized name. If the item doesn't have a unlocalized name, this method will return the Material of it.
     */
    public static String getItemUnlocalizedName(final Material mat) {
        //EnumItem enumItem = EnumItem.get(item.getType());
        //return enumItem != null ? enumItem.getUnlocalizedName() : item.getType().toString();
        return (mat.isBlock()?"block":"item") + "."
                + mat.getKey().getNamespace() + "." 
                + mat.getKey().getKey();
    }

    /**
     * Return the unlocalized name of the biome(Minecraft convention)
     *
     * @param biome The biome
     * @return The unlocalized name. If the biome doesn't have a unlocalized name, this method will return the Biome of it.
     */
    public static String getBiomeUnlocalizedName(final Biome biome) {
        //EnumBiome enumBiome = EnumBiome.get(biome);
        //return enumBiome != null ? enumBiome.getUnlocalizedName() : biome.toString();
        return "biome.minecraft."+biome.toString().toLowerCase();
    }
    
    /**
     * Return the unlocalized name of the entity(Minecraft convention)
     *
     * @param entity The entity
     * @return The unlocalized name. If the entity doesn't have a unlocalized name, this method will return the EntityType of it.
     */
    public static String getEntityUnlocalizedName(final Entity entity) {
        //EnumEntity enumEntity = EnumEntity.get(entity.getType());
        //return enumEntity != null ? enumEntity.getUnlocalizedName() : entity.getType().toString();
        return getEntityUnlocalizedName(entity.getType());
    }

    /**
     * Return the unlocalized name of the entity(Minecraft convention)
     *
     * @param entityType The EntityType of the entity
     * @return The unlocalized name. If the entity doesn't have a unlocalized name, this method will return the name of the EntityType.
     */
    public static String getEntityUnlocalizedName(final EntityType entityType) {
        //EnumEntity enumEntity = EnumEntity.get(entityType);
        //return enumEntity != null ? enumEntity.getUnlocalizedName() : entityType.toString();
        if (entityType==EntityType.SNOWMAN) {
            return "entity.minecraft.snow_golem";
        }
        return "entity.minecraft."+entityType.toString().toLowerCase();
    }



    /**
     * Return the unlocalized name of the enchantment level(Minecraft convention)
     *
     * @param level The enchantment level
     * @return The unlocalized name.(if level is greater than 10, it will only return the number of the level)
     */
    public static String getEnchantmentLevelUnlocalizedName(final int level) {
        //EnumEnchantmentLevel enumEnchLevel = EnumEnchantmentLevel.get(level);
        //return enumEnchLevel != null ? enumEnchLevel.getUnlocalizedName() : Integer.toString(level);
        return "enchantment.level."+level;
    }


    /**
     * Return the unlocalized name of the enchantment(Minecraft convention)
     *
     * @param enchantment The enchantment
     * @return The unlocalized name.
     */
    public static String getEnchantmentUnlocalizedName(final Enchantment enchantment) {
        //EnumEnchantment enumEnch = EnumEnchantment.get(enchantment);
        //return (enumEnch != null ? enumEnch.getUnlocalizedName() : enchantment.getKey().getKey());
        return "enchantment.minecraft."+enchantment.getKey().getKey();
    }


    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /**
     * Translate unlocalized entry to localized entry.
     *
     * @param unlocalizedName The unlocalized entry.
     * @param locale          The language to be translated to.
     * @return The localized entry. If the localized entry doesn't exist, it will first look up the fallback language map. If the entry still doesn't exist, then return the unlocalized name.
     */
    public static String translateToLocal(final String unlocalizedName, final String locale) {
//System.out.println("translateToLocal() unlocalizedName="+unlocalizedName);
//final Map<String, String> langMap = EnumLang.get(locale.toLowerCase()).getMap();

        String result = EnumLang.get(locale.toLowerCase()).getMap().get(unlocalizedName);
//System.out.println("translateToLocal() 1 result="+result+"    contains?"+langMap.containsKey(unlocalizedName));
        if (result != null && !result.isEmpty())
            return result;
        else {
            result = EnumLang.get(LangUtils.plugin.config.getString("FallbackLanguage")).getMap().get(unlocalizedName);
            if (result == null || result.isEmpty())// when fallback language doesn't exist
                result = EnumLang.EN_US.getMap().get(unlocalizedName);
        }
        return result == null ? unlocalizedName : result;
    }
}
