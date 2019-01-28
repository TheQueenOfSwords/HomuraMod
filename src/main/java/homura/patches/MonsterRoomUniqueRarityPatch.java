package homura.patches;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.rooms.MonsterRoom;

import static com.megacrit.cardcrawl.dungeons.AbstractDungeon.cardBlizzRandomizer;
import static com.megacrit.cardcrawl.dungeons.AbstractDungeon.cardRng;
import static homura.patches.AbstractCardEnum.HOMURAMOD_UNIQUE;

public class MonsterRoomUniqueRarityPatch extends MonsterRoom
{
	@Override
	public AbstractCard.CardRarity getCardRarity(int roll)
	{
		int uniqueRate = 1;
		int uniqueRoll;
		int rareRate;

		if(roll < uniqueRate)
		{
			uniqueRoll = cardRng.random(99);
			roll += cardBlizzRandomizer;

			if(uniqueRoll < uniqueRate)
			{
				return HOMURAMOD_UNIQUE;
			}
		}

		if (AbstractDungeon.player.hasRelic("Nloth's Gift"))
		{
			rareRate = 9;
		}
		else
		{
			rareRate = 3;
		}

		if (roll < rareRate)
		{
			if ((AbstractDungeon.player.hasRelic("Nloth's Gift")) && (roll > 3))
			{
				AbstractDungeon.player.getRelic("Nloth's Gift").flash();
			}
			return AbstractCard.CardRarity.RARE;
		}

		if (roll < 40)
		{
			return AbstractCard.CardRarity.UNCOMMON;
		}

		return AbstractCard.CardRarity.COMMON;
	}
}
