package homura.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import basemod.abstracts.CustomCard;
import basemod.helpers.BaseModCardTags;
import homura.patches.AbstractCardEnum;

public class Strike extends CustomCard
{
    public static final String ID = "HomuraMod:Strike";
    private static CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;
    public static final String IMG_PATH = "HomuraMod/images/cards/Attacks/Parrot.png";
    private static final int COST = 1;
    private static final int ATTACK_DMG = 6;
    private static final int UPGRADE_PLUS_DMG = 3;
    
    public Strike()
    {
        super(ID, NAME, IMG_PATH, COST, DESCRIPTION,
        		CardType.ATTACK, AbstractCardEnum.PURPLE_SOUL_GEM_CHARACTER,
        		CardRarity.BASIC, CardTarget.ENEMY);
        this.baseDamage = ATTACK_DMG;
        this.tags.add(BaseModCardTags.BASIC_STRIKE);
        this.tags.add(AbstractCard.CardTags.STRIKE);
    }

    public AbstractCard makeCopy()
    {
        return new Strike();
    }
    
	@Override
	public void upgrade()
	{
		if (!this.upgraded)
		{
            this.upgradeName();
            this.upgradeDamage(UPGRADE_PLUS_DMG);
        }
	}

	@Override
	public void use(AbstractPlayer p, AbstractMonster m)
	{
		com.megacrit.cardcrawl.dungeons.AbstractDungeon.actionManager.addToBottom(new com.megacrit.cardcrawl.actions.common.DamageAction(m, new com.megacrit.cardcrawl.cards.DamageInfo(p, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.BLUNT_LIGHT));	
	}
}