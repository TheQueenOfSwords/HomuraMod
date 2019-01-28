package homura.relics;

import com.badlogic.gdx.graphics.Texture;

import com.megacrit.cardcrawl.relics.AbstractRelic;

import basemod.abstracts.CustomRelic;

public class SpiderLily extends CustomRelic
{
	public SpiderLily()
	{
		super("HomuraMod:SpiderLily", new Texture("HomuraMod/images/relics/bloom.png"), RelicTier.STARTER, LandingSound.MAGICAL);
	}

	@Override
	public String getUpdatedDescription()
	{
		return this.DESCRIPTIONS[0];
	}

	@Override
	public AbstractRelic makeCopy()
	{
		return new SpiderLily();
	}
}