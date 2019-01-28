package homura.character;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.MathUtils;

import com.esotericsoftware.spine.AnimationState;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.AbstractGameAction.AttackEffect;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.AbstractCard.CardColor;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.EnergyManager;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.helpers.FontHelper;
import com.megacrit.cardcrawl.helpers.ScreenShake;
import com.megacrit.cardcrawl.localization.CharacterStrings;
import com.megacrit.cardcrawl.screens.CharSelectInfo;
import com.megacrit.cardcrawl.unlock.UnlockTracker;

import basemod.abstracts.CustomPlayer;
import homura.HomuraMod;
import homura.patches.AbstractCardEnum;
import homura.patches.MyPlayerClassEnum;

public class HomuraCharacter extends CustomPlayer
{
	private static CharacterStrings charStrings = CardCrawlGame.languagePack.getCharacterString("Homura");

	private static final int ENERGY_PER_TURN = 4; /*how much energy you get every turn*/

	private static final String MY_CHARACTER_SHOULDER_2 = "HomuraMod/images/characters/homura/idle/shoulder2.png"; /*campfire pose*/
	private static final String MY_CHARACTER_SHOULDER_1 = "HomuraMod/images/characters/homura/idle/shoulder1.png"; /*another campfire pose*/
	private static final String MY_CHARACTER_CORPSE = "HomuraMod/images/characters/homura/idle/corpse.png"; /*dead corpse*/
	private static final String MY_CHARACTER_SKELETON_ATLAS = "HomuraMod/images/characters/homura/idle/skeleton.atlas"; /*spine animation atlas*/
	private static final String MY_CHARACTER_SKELETON_JSON = "HomuraMod/images/characters/homura/idle/skeleton.json"; /*spine animation json*/

    private static final String[] orbTextures =
    	{	"HomuraMod/images/ui/topPanel/homura/1.png",
    		"HomuraMod/images/ui/topPanel/homura/2.png",
    		"HomuraMod/images/ui/topPanel/homura/3.png",
    		"HomuraMod/images/ui/topPanel/homura/4.png",
    		"HomuraMod/images/ui/topPanel/homura/5.png",
    		"HomuraMod/images/ui/topPanel/homura/border.png",
    		"HomuraMod/images/ui/topPanel/homura/1d.png",
    		"HomuraMod/images/ui/topPanel/homura/2d.png",
    		"HomuraMod/images/ui/topPanel/homura/3d.png",
    		"HomuraMod/images/ui/topPanel/homura/4d.png",
    		"HomuraMod/images/ui/topPanel/homura/5d.png"
    	};
    
	public HomuraCharacter (String name, AbstractPlayer.PlayerClass setClass)
	{
		super(name, setClass, orbTextures, "images/vfx/orb.png", null, (String)null);
		
		this.dialogX = (this.drawX + 0.0F * Settings.scale); /*set location for text bubbles*/
		this.dialogY = (this.drawY + 220.0F * Settings.scale); /*you can just copy these values*/
		
		initializeClass(null, MY_CHARACTER_SHOULDER_2, /*required call to load textures and setup energy/loadout*/
				MY_CHARACTER_SHOULDER_1,
				MY_CHARACTER_CORPSE, 
				getLoadout(), 20.0F, -10.0F, 220.0F, 290.0F, new EnergyManager(ENERGY_PER_TURN));

		float renderscale = 1.2F;
		loadAnimation(MY_CHARACTER_SKELETON_ATLAS, MY_CHARACTER_SKELETON_JSON, renderscale); // if you're using modified versions of base game animations or made animations in spine make sure to include this bit and the following lines
		
		AnimationState.TrackEntry e = this.state.setAnimation(0, "Idle", true);
		e.setTime(e.getEndTime() * MathUtils.random());
	}

	public ArrayList<String> getStartingDeck() /*starting deck 'nuff said*/
	{
		ArrayList<String> retVal = new ArrayList<>();
		retVal.add("HomuraMod:Strike");
		return retVal;
	}
	
	public ArrayList<String> getStartingRelics() /*starting relics - also simple*/
	{
		ArrayList<String> retVal = new ArrayList<>();
		retVal.add("HomuraMod:SpiderLily");
		UnlockTracker.markRelicAsSeen("HomuraMod:SpiderLily");
		return retVal;
	}
	
        private static final int STARTING_HP = 50;
        private static final int MAX_HP = 50;
        private static final int STARTING_GOLD = 99;
        private static final int HAND_SIZE = 6;
        private static final int ORB_SLOTS = 0;

	public CharSelectInfo getLoadout()  /*the rest of the character loadout so includes your character select screen info plus hp and starting gold*/
	{
		return new CharSelectInfo(getLocalizedCharacterName(), charStrings.TEXT[0],
				STARTING_HP, MAX_HP, ORB_SLOTS, STARTING_GOLD, HAND_SIZE,
				this, getStartingRelics(), getStartingDeck(), false);
	}

	@Override
	public void doCharSelectScreenSelectEffect()
	{
		CardCrawlGame.sound.playA("MONSTER_SNECKO_GLARE", MathUtils.random(-0.1F, 0.1F));
		CardCrawlGame.screenShake.shake(ScreenShake.ShakeIntensity.MED, ScreenShake.ShakeDur.SHORT, true);
	}

	@Override
	public int getAscensionMaxHPLoss() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public CardColor getCardColor()
	{
		return AbstractCardEnum.PURPLE_SOUL_GEM_CHARACTER;
	}

	@Override
	public Color getCardRenderColor()
	{
		return HomuraMod.PURPLE_SOUL_GEM;
	}

	@Override
	public Color getCardTrailColor()
	{
		return HomuraMod.PURPLE_SOUL_GEM.cpy();
	}

	@Override
	public String getCustomModeCharacterButtonSoundKey() {
		// TODO Auto-generated method stub
		return "MONSTER_SNECKO_GLARE";
	}

	@Override
	public BitmapFont getEnergyNumFont() {
		// TODO Auto-generated method stub
		return FontHelper.energyNumFontBlue;
	}

	@Override
	public String getLocalizedCharacterName()
	{
		return charStrings.NAMES[1];
	}

	@Override
	public Color getSlashAttackColor() {
		// TODO Auto-generated method stub
		return HomuraMod.GOLD;
	}

	@Override
	public AttackEffect[] getSpireHeartSlashEffect() {
		// TODO Auto-generated method stub
		return new AbstractGameAction.AttackEffect[] { AbstractGameAction.AttackEffect.BLUNT_HEAVY};
	}

	@Override
	public String getSpireHeartText() {
		// TODO Auto-generated method stub
		return "??????";
	}

	@Override
	public AbstractCard getStartCardForEvent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTitle(PlayerClass arg0)
	{
		return charStrings.NAMES[0];
	}

	@Override
	public String getVampireText() {
		// TODO Auto-generated method stub
		return "Ah.";
	}

	@Override
	public AbstractPlayer newInstance() {
		// TODO Auto-generated method stub
		return new HomuraCharacter(CardCrawlGame.playerName, MyPlayerClassEnum.HOMURA_CLASS);
	}
}
