package homura.patches;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.rooms.MonsterRoomBoss;

import static homura.patches.AbstractCardEnum.HOMURAMOD_UNIQUE;

public class MonsterRoomBossUniqueRarityPatch extends MonsterRoomBoss
{
	@Override
	public AbstractCard.CardRarity getCardRarity(int roll)
	{
		if(roll < 10)
		{
			return HOMURAMOD_UNIQUE;
		}

		return AbstractCard.CardRarity.RARE;
	}
}
