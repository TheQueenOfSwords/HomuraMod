package homura;

import com.megacrit.cardcrawl.core.CardCrawlGame;

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
public class HomuraMod implements EditCardsSubscriber, EditCharactersSubscriber
{
	public static final String MODNAME = "Homura"; /*mod name*/
	public static final String AUTHOR = "Meowdoleon"; /*your name*/
	public static final String DESCRIPTION = "v0.0.1 - Homura (dev testing)"; /*description*/
	
    private static final String attackCard = "images/cardui/512/bg_attack_purple.png"; /*Attack card bg*/
    private static final String skillCard = "images/cardui/512/bg_skill_purple.png"; /*Skill card bg*/
    private static final String powerCard = "images/cardui/512/bg_power_purple.png"; /*Power card bg*/
    private static final String energyOrb = "images/cardui/512/card_purple_orb.png"; /*Card energy orb*/
    private static final String attackCardPortrait = "images/cardui/1024/bg_attack_purple.png"; /*Attack card bg big*/
    private static final String skillCardPortrait = "images/cardui/1024/bg_skill_purple.png"; /*Skill card bg big*/
    private static final String powerCardPortrait = "images/cardui/1024/bg_power_purple.png"; /*Power card bg big*/
    private static final String energyOrbPortrait = "images/cardui/1024/card_purple_orb.png"; /*Card energy orb big*/
    private static final String charButton = "images/ui/charselect/homuraButton.png"; /*Character button*/
    private static final String charPortrait = "images/ui/charSelect/homuraPortrait.png"; /*Character portrait*/
    private static final String miniPurpleOrb = "images/cardui/512/mini_purple_orb.png"; /*Small energy orb for the cards in hand*/
    
    public HomuraMod()
    {
    	BaseMod.subscribe(this);
    	
    	BaseMod.addColor(PURPLE_SOUL_GEM_CHARACTER, HomuraCharacter.PURPLE_SOUL_GEM /*bg color*/, HomuraCharacter.PURPLE_SOUL_GEM /*back color*/, 
    			HomuraCharacter.PURPLE_SOUL_GEM /*frame color*/, HomuraCharacter.PURPLE_SOUL_GEM /*frame outline color*/,
    			HomuraCharacter.PURPLE_SOUL_GEM /*description box color*/, HomuraCharacter.GOLD /*VFX trail color*/,
    			HomuraCharacter.GOLD /*glow color*/, attackCard /*attack card bg*/, skillCard /*skill card bg*/, powerCard /*power card bg*/,
				energyOrb /*energy orb*/, attackCardPortrait /*attack card 1024*/,
				skillCardPortrait /*skill card 1024*/, powerCardPortrait /*power card 1024*/,
				energyOrbPortrait /*energy orb 1024*/, miniPurpleOrb /*energy orb 164*/);
    }
    
    public static void initialize()
    {
    	new HomuraMod();
    }

	public void receiveEditCharacters()
	{
		BaseMod.addCharacter(new HomuraCharacter(CardCrawlGame.playerName, MyPlayerClassEnum.HOMURA_CLASS),
				charButton,
				charPortrait,
				MyPlayerClassEnum.HOMURA_CLASS);
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