package homura;

import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.helpers.CardHelper;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.localization.CharacterStrings;
import com.megacrit.cardcrawl.localization.RelicStrings;

import com.badlogic.gdx.graphics.Color;

import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;

import basemod.BaseMod;
import basemod.interfaces.*;

import static homura.patches.AbstractCardEnum.PURPLE_SOUL_GEM_CHARACTER;

import homura.cards.Strike;
import homura.character.HomuraCharacter;
import homura.patches.AbstractCardEnum;
import homura.patches.MyPlayerClassEnum;
import homura.relics.SpiderLily;

@SpireInitializer
public class HomuraMod implements EditCardsSubscriber, EditCharactersSubscriber, EditRelicsSubscriber, EditStringsSubscriber
{
	public static final Color PURPLE_SOUL_GEM = CardHelper.getColor(179.0f, 119.0f, 171.0f);
	public static final Color GOLD = CardHelper.getColor(255.0f, 215.0f, 0.0f);
	
	public static final String MODNAME = "Homura"; /*mod name*/
	public static final String AUTHOR = "Meowdoleon"; /*your name*/
	public static final String DESCRIPTION = "v0.0.1 - Homura (dev testing)"; /*description*/
	
	private static final String attackCard = "HomuraMod/images/cardui/512/bg_attack_purple.png"; /*Attack card bg*/
	private static final String skillCard = "HomuraMod/images/cardui/512/bg_skill_purple.png"; /*Skill card bg*/
	private static final String powerCard = "HomuraMod/images/cardui/512/bg_power_purple.png"; /*Power card bg*/
	private static final String energyOrb = "HomuraMod/images/cardui/512/card_purple_orb.png"; /*Card energy orb*/
	private static final String attackCardPortrait = "HomuraMod/images/cardui/1024/bg_attack_purple.png"; /*Attack card bg big*/
	private static final String skillCardPortrait = "HomuraMod/images/cardui/1024/bg_skill_purple.png"; /*Skill card bg big*/
	private static final String powerCardPortrait = "HomuraMod/images/cardui/1024/bg_power_purple.png"; /*Power card bg big*/
	private static final String energyOrbPortrait = "HomuraMod/images/cardui/1024/card_purple_orb.png"; /*Card energy orb big*/
	private static final String charButton = "HomuraMod/images/ui/charselect/homuraButton.png"; /*Character button*/
	private static final String charPortrait = "HomuraMod/images/ui/charselect/homuraPortrait.png"; /*Character portrait*/
	private static final String miniPurpleOrb = "HomuraMod/images/cardui/512/mini_purple_orb.png"; /*Small energy orb for the cards in hand*/
    
    public HomuraMod()
    {
    	BaseMod.subscribe(this);
    	
    	BaseMod.addColor(PURPLE_SOUL_GEM_CHARACTER, PURPLE_SOUL_GEM /*bg color*/, PURPLE_SOUL_GEM /*back color*/,
                PURPLE_SOUL_GEM /*frame color*/, PURPLE_SOUL_GEM /*frame outline color*/,
                PURPLE_SOUL_GEM /*description box color*/, GOLD /*VFX trail color*/,
                GOLD /*glow color*/, attackCard /*attack card bg*/, skillCard /*skill card bg*/, powerCard /*power card bg*/,
                energyOrb /*energy orb*/, attackCardPortrait /*attack card 1024*/,
                skillCardPortrait /*skill card 1024*/, powerCardPortrait /*power card 1024*/,
                energyOrbPortrait /*energy orb 164*/, miniPurpleOrb /*energy orb 24*/);
    }
    
    public static void initialize()
    {
    	new HomuraMod();
    }

	public void receiveEditStrings()
	{
		String language = "eng";

		if (Settings.language == Settings.GameLanguage.ZHS) language = "zhs";
		if (Settings.language == Settings.GameLanguage.ZHT) language = "zht";
		if (Settings.language == Settings.GameLanguage.FRA) language = "fra";
		if (Settings.language == Settings.GameLanguage.KOR) language = "kor";
		if (Settings.language == Settings.GameLanguage.JPN) language = "jpn";

		BaseMod.loadCustomStringsFile(CardStrings.class, "HomuraMod/localization/"+ language + "/cards.json");
		BaseMod.loadCustomStringsFile(RelicStrings.class, "HomuraMod/localization/"+ language + "/relics.json");
		BaseMod.loadCustomStringsFile(CharacterStrings.class, "HomuraMod/localization/" + language + "/character.json");
	}

	public void receiveEditCharacters()
	{
		BaseMod.addCharacter(new HomuraCharacter(CardCrawlGame.playerName, MyPlayerClassEnum.HOMURA_CLASS),
				charButton, charPortrait, MyPlayerClassEnum.HOMURA_CLASS);
	}

	public void receiveEditRelics()
	{
		BaseMod.addRelicToCustomPool(new SpiderLily(), AbstractCardEnum.PURPLE_SOUL_GEM_CHARACTER);
	}
	
	public void receiveEditCards()
	{
		BaseMod.addCard(new Strike());
	}
}