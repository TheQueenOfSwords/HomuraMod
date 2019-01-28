package homura.patches;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.ModHelper;
import com.megacrit.cardcrawl.rooms.MonsterRoomElite;

import static homura.patches.AbstractCardEnum.HOMURAMOD_UNIQUE;

public class MonsterRoomEliteUniqueRarityPatch extends MonsterRoomElite
{
	@Override
	public AbstractCard.CardRarity getCardRarity(int roll)
	{
		if (ModHelper.isModEnabled("Elite Swarm"))
		{
			if(roll < 10)
			{
				return HOMURAMOD_UNIQUE;
			}

			return AbstractCard.CardRarity.RARE;
		}
		int rareRate;

		if (AbstractDungeon.player.hasRelic("Nloth's Gift"))
		{
			rareRate = 30;
		}
		else
		{
			rareRate = 10;
		}

		if (roll < rareRate)
		{
			if ((AbstractDungeon.player.hasRelic("Nloth's Gift")) && (roll > 10)) {
				AbstractDungeon.player.getRelic("Nloth's Gift").flash();
			}
			return AbstractCard.CardRarity.RARE;
		}

		if (roll < 50) {
			return AbstractCard.CardRarity.UNCOMMON;
		}

		return AbstractCard.CardRarity.COMMON;
	}
}
