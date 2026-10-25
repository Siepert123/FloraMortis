package trifectumsoftware.floramortis.init;

import net.minecraft.potion.Potion;
import trifectumsoftware.floramortis.world.effect.PotionPollinated;

public class PotionInit {
	public static Potion pollinated;

	public static void register() {
		for (int i = 1; i < Potion.potionTypes.length; i++) {
			if (Potion.potionTypes[i] == null) {
				Potion.potionTypes[i] = pollinated = new PotionPollinated(i, 0xFFFF00).setPotionName("potion.flora_mortis.pollinated");
			}
		}
	}
}
