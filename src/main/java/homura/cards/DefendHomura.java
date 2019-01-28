package homura.cards;

import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import basemod.abstracts.CustomCard;
import basemod.helpers.BaseModCardTags;

import homura.patches.AbstractCardEnum;

public class DefendHomura extends CustomCard
{
	private static final String ID = "HomuraMod:Defend";
	private static CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
	private static final String NAME = cardStrings.NAME;
	private static final String DESCRIPTION = cardStrings.DESCRIPTION;
	private static final String IMG_PATH = "HomuraMod/images/cards/Skills/Parrot.png";
	private static final int COST = 1;
	private static final int BLOCK = 5;
	private static final int UPGRADE_PLUS_BLK = 3;

	public DefendHomura()
	{
		super(ID, NAME, IMG_PATH, COST, DESCRIPTION,
				CardType.SKILL, AbstractCardEnum.PURPLE_SOUL_GEM_CHARACTER,
				CardRarity.BASIC, CardTarget.SELF);
		this.baseBlock = BLOCK;
		this.tags.add(BaseModCardTags.BASIC_DEFEND);
	}

	public AbstractCard makeCopy()
	{
		return new DefendHomura();
	}

	@Override
	public void upgrade()
	{
		if (!this.upgraded)
		{
			this.upgradeName();
			this.upgradeDamage(UPGRADE_PLUS_BLK);
		}
	}

	@Override
	public void use(AbstractPlayer p, AbstractMonster m)
	{
		AbstractDungeon.actionManager.addToBottom(new GainBlockAction(p, p, block));
	}
}
