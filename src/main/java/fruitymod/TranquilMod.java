package fruitymod;

import basemod.BaseMod;
import com.badlogic.gdx.graphics.Color;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.helpers.CardHelper;
import com.megacrit.cardcrawl.rooms.AbstractRoom;
import fruitymod.characters.TheTranquil;
import fruitymod.patches.AbstractCardEnum;
import fruitymod.patches.TheTranquilEnum;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TranquilMod implements CharacterMod {

	public static final Logger logger = LogManager.getLogger(TranquilMod.class.getName());

	private static final Color TAN = CardHelper.getColor(210.0f, 180.0f, 140.0f);

	private static final String ATTACK_TAN = "512/bg_attack_tan.png";
	private static final String SKILL_TAN = "512/bg_skill_tan.png";
	private static final String POWER_TAN = "512/bg_power_tan.png";
	private static final String ENERGY_ORB_TAN = "512/card_tan_orb.png";
	private static final String CARD_ENERGY_ORB_TAN = "512/card_tan_small_orb.png";

	private static final String ATTACK_TAN_PORTRAIT = "1024/bg_attack_tan.png";
	private static final String SKILL_TAN_PORTRAIT = "1024/bg_skill_tan.png";
	private static final String POWER_TAN_PORTRAIT = "1024/bg_power_tan.png";
	private static final String ENERGY_ORB_TAN_PORTRAIT = "1024/card_tan_orb.png";

	private static final String TRANQUIL_BUTTON = "charSelect/tranquilButton.png";
	private static final String TRANQUIL_PORTRAIT = "charSelect/TranquilPortraitBG.jpg";
	public static final String TRANQUIL_SHOULDER_1 = "char/tranquil/shoulder.png";
	public static final String TRANQUIL_SHOULDER_2 = "char/tranquil/shoulder2.png";
	public static final String TRANQUIL_CORPSE = "char/tranquil/corpse.png";


	private static final String FRUITY_MOD_ASSETS_FOLDER = "img";

	public TranquilMod() {
		/*
		 * Note that for now when installing FruityMod, in the `mods/` folder another folder named
		 * the value of FRUITY_MOD_ASSETS_FOLDER must be created into which all the contents of the
		 * `images/` folder must be relocated
		 */
		logger.info("creating the color " + AbstractCardEnum.TRANQUIL_TAN.toString());
		BaseMod.addColor(AbstractCardEnum.TRANQUIL_TAN.toString(),
				TAN, TAN, TAN, TAN, TAN, TAN, TAN,
				makePath(ATTACK_TAN), makePath(SKILL_TAN),
				makePath(POWER_TAN), makePath(ENERGY_ORB_TAN),
				makePath(ATTACK_TAN_PORTRAIT), makePath(SKILL_TAN_PORTRAIT),
				makePath(POWER_TAN_PORTRAIT), makePath(ENERGY_ORB_TAN_PORTRAIT), makePath(CARD_ENERGY_ORB_TAN));
	}

	@Override
	public void receiveEditCards() {

	}

	@Override
	public void receiveEditCharacters() {
		if (isEnabled()) {
			logger.info("add " + TheTranquilEnum.THE_TRANQUIL.toString());
			BaseMod.addCharacter(TheTranquil.class, "The Tranquil", "Tranquil class string",
					AbstractCardEnum.TRANQUIL_TAN.toString(), "The Tranquil",
					makePath(TRANQUIL_BUTTON), makePath(TRANQUIL_PORTRAIT),
					TheTranquilEnum.THE_TRANQUIL.toString());
		}
	}

	@Override
	public void receiveEditKeywords() {

	}

	@Override
	public void receiveEditRelics() {

	}

	@Override
	public void receiveEditStrings() {

	}

	@Override
	public void receiveCardUsed(AbstractCard abstractCard) {

	}

	@Override
	public void receivePowersModified() {

	}

	@Override
	public void receivePostBattle(AbstractRoom abstractRoom) {

	}

	@Override
	public void receivePostDraw(AbstractCard abstractCard) {

	}

	@Override
	public void receivePostDungeonInitialize() {

	}

	@Override
	public void receivePostExhaust(AbstractCard abstractCard) {

	}

	/**
	 * Makes a full path for a resource path
	 * @param resource the resource, must *NOT* have a leading "/"
	 * @return the full path
	 */
	private static final String makePath(String resource) {
		return FRUITY_MOD_ASSETS_FOLDER + "/" + resource;
	}

	public static boolean isEnabled() {
		return Boolean.parseBoolean(System.getProperty("tranquil_enabled","false"));
	}
}
