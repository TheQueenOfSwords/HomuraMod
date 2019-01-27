<<<<<<< HEAD
package homura.relics;

import com.badlogic.gdx.graphics.Texture;

import com.megacrit.cardcrawl.relics.AbstractRelic;

import basemod.abstracts.CustomRelic;

public class SpiderLily extends CustomRelic
{
	public SpiderLily()
	{
		super("HomuraMod:SpiderLily", new Texture("images/relics/bloom.png"), RelicTier.STARTER, LandingSound.MAGICAL);
	}

	@Override
	public AbstractRelic makeCopy()
	{
		return new SpiderLily();
	}
=======
package homura.relics;

import com.badlogic.gdx.graphics.Texture;

import com.megacrit.cardcrawl.relics.AbstractRelic;

import basemod.abstracts.CustomRelic;

public class SpiderLily extends CustomRelic
{
	public SpiderLily()
	{
		super("HomuraMod:SpiderLily", new Texture("images/relics/bloom.png"), RelicTier.STARTER, LandingSound.MAGICAL);
	}

	@Override
	public AbstractRelic makeCopy()
	{
		return new SpiderLily();
	}
>>>>>>> b2e8d5023d222c9d3b1836f1ee14605c6d816dab
}