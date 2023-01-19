package com.dm.earth.cabricality.client.plugin.rei;

import static com.dm.earth.cabricality.ModEntry.CABF;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.dm.earth.cabricality.Cabricality;
import com.dm.earth.cabricality.content.entries.CabfItemTags;
import com.dm.earth.cabricality.content.entries.CabfItems;
import com.dm.earth.cabricality.util.debug.CabfDebugger;

import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.entry.CollapsibleEntryRegistry;
import me.shedaniel.rei.api.common.util.EntryIngredients;

@SuppressWarnings("UnstableApiUsage")
public class CabricalityREIClientPlugin implements REIClientPlugin {
	@Override
	public void registerCollapsibleEntries(CollapsibleEntryRegistry registry) {
		CabfDebugger.debug("Registering Collapsible Entries");

		// Trading
		registry.group(Cabricality.id("trade_cards"),
				Cabricality.genTranslatableText("tag",
						CabfItemTags.TRADE_CARDS.id().getPath()),
				EntryIngredients.ofItemTag(CabfItemTags.TRADE_CARDS));
		registry.group(Cabricality.id("profession_cards"),
				Cabricality.genTranslatableText("tag",
						CabfItemTags.PROFESSION_CARDS.id().getPath()),
				EntryIngredients.ofItemTag(CabfItemTags.PROFESSION_CARDS));

		// Alchemist Jars
		registry.group(Cabricality.id("catalyst_jars"),
				Cabricality.genTranslatableText("tag",
						CabfItemTags.CATALYST_JARS.id().getPath()),
				EntryIngredients.ofItemTag(CabfItemTags.CATALYST_JARS));
		registry.group(Cabricality.id("reagent_jars"),
				Cabricality.genTranslatableText("tag",
						CabfItemTags.REAGENT_JARS.id().getPath()),
				EntryIngredients.ofItemTag(CabfItemTags.REAGENT_JARS));

		// Numbers
		registry.group(Cabricality.id("numbers"),
				Cabricality.genTranslatableText("col", "numbers"),
				EntryIngredients.ofItems(Stream.concat(CabfItems.NUMBERS.stream().map(n -> CABF.asItem("number_" + n)),
						CabfItems.OPERATORS.keySet().stream().map(CABF::asItem)).collect(Collectors.toList())));

		// Math casts
		registry.group(Cabricality.id("math_casts"),
				Cabricality.genTranslatableText("col", "math_casts"),
				EntryIngredients.ofItems(
						CabfItems.MATH_CASTS.stream().map(c -> CABF.asItem(c + "_cast")).collect(Collectors.toList())));
	}
}