package xyz.saboteur.pokemongo;

import POGOProtos.Data.PokemonDataOuterClass.PokemonData;
import POGOProtos.Enums.PokemonIdOuterClass.PokemonId;

public class StatsUtil {	
	public static double calculateCpMultiplier(PokemonData poke)
    {
        BaseStats baseStats = getBaseStats(poke.getPokemonId());
        return (baseStats.getBaseAttack() + poke.getIndividualAttack()) * Math.sqrt(baseStats.getBaseDefense() + poke.getIndividualDefense()) * Math.sqrt(baseStats.getBaseStamina() + poke.getIndividualStamina());
    }
	
	public static int calculateMaxCp(PokemonData data) {
        return Math.max((int) Math.floor(0.1 * calculateMaxCpMultiplier(data) * Math.pow(data.getCpMultiplier() + data.getAdditionalCpMultiplier(), 2)), 10);
    }

    public static double calculateMaxCpMultiplier(PokemonData data) {
        BaseStats baseStats = getBaseStats(data.getPokemonId());
        return (baseStats.getBaseAttack() + 15) * Math.sqrt(baseStats.getBaseDefense() + 15) * Math.sqrt(baseStats.getBaseStamina() + 15);
    }

    public static int calculateMinCp(PokemonData data) {
        return Math.max((int) Math.floor(0.1 * calculateMinCpMultiplier(data) * Math.pow(data.getCpMultiplier() + data.getAdditionalCpMultiplier(), 2)), 10);
    }

    public static double calculateMinCpMultiplier(PokemonData poke) {
    	BaseStats baseStats = getBaseStats(poke.getPokemonId());
        return baseStats.getBaseAttack() * Math.sqrt(baseStats.getBaseDefense()) * Math.sqrt(baseStats.getBaseStamina());
    }
	
    public static double calculatePokemonPerfection(PokemonData poke) {
        if (Math.abs(poke.getCpMultiplier() + poke.getAdditionalCpMultiplier()) <= 0)
            return (poke.getIndividualAttack() * 2 + poke.getIndividualDefense() + poke.getIndividualStamina()) / (4.0 * 15.0) * 100.0;

        double maxCp = calculateMaxCpMultiplier(poke);
        double minCp = calculateMinCpMultiplier(poke);
        double curCp = calculateCpMultiplier(poke);

        return (curCp - minCp) / (maxCp - minCp) * 100.0;
    }

	public static BaseStats getBaseStats(PokemonId id) {
		switch (id.getNumber()) {
		case 1:
			return new BaseStats(90, 126, 126);
		case 2:
			return new BaseStats(120, 156, 158);

		case 3:
			return new BaseStats(160, 198, 200);

		case 4:
			return new BaseStats(78, 128, 108);

		case 5:
			return new BaseStats(116, 160, 140);

		case 6:
			return new BaseStats(156, 212, 182);

		case 7:
			return new BaseStats(88, 112, 142);

		case 8:
			return new BaseStats(118, 144, 176);

		case 9:
			return new BaseStats(158, 186, 222);

		case 10:
			return new BaseStats(90, 62, 66);

		case 11:
			return new BaseStats(100, 56, 86);

		case 12:
			return new BaseStats(120, 144, 144);

		case 13:
			return new BaseStats(80, 68, 64);

		case 14:
			return new BaseStats(90, 62, 82);

		case 15:
			return new BaseStats(130, 144, 130);

		case 16:
			return new BaseStats(80, 94, 90);

		case 17:
			return new BaseStats(126, 126, 122);

		case 18:
			return new BaseStats(166, 170, 166);

		case 19:
			return new BaseStats(60, 92, 86);

		case 20:
			return new BaseStats(110, 146, 150);

		case 21:
			return new BaseStats(80, 102, 78);

		case 22:
			return new BaseStats(130, 168, 146);

		case 23:
			return new BaseStats(70, 112, 112);

		case 24:
			return new BaseStats(120, 166, 166);

		case 25:
			return new BaseStats(70, 124, 108);

		case 26:
			return new BaseStats(120, 200, 154);

		case 27:
			return new BaseStats(100, 90, 114);

		case 28:
			return new BaseStats(150, 150, 172);

		case 29:
			return new BaseStats(110, 100, 104);

		case 30:
			return new BaseStats(140, 132, 136);

		case 31:
			return new BaseStats(180, 184, 190);

		case 32:
			return new BaseStats(92, 110, 94);

		case 33:
			return new BaseStats(122, 142, 128);

		case 34:
			return new BaseStats(162, 204, 170);

		case 35:
			return new BaseStats(140, 116, 124);

		case 36:
			return new BaseStats(190, 178, 178);

		case 37:
			return new BaseStats(76, 106, 118);

		case 38:
			return new BaseStats(146, 176, 194);

		case 39:
			return new BaseStats(230, 98, 54);

		case 40:
			return new BaseStats(280, 168, 108);

		case 41:
			return new BaseStats(80, 88, 90);

		case 42:
			return new BaseStats(150, 164, 164);

		case 43:
			return new BaseStats(90, 134, 130);

		case 44:
			return new BaseStats(120, 162, 158);

		case 45:
			return new BaseStats(150, 202, 190);

		case 46:
			return new BaseStats(70, 122, 120);

		case 47:
			return new BaseStats(120, 162, 170);

		case 48:
			return new BaseStats(120, 108, 118);

		case 49:
			return new BaseStats(140, 172, 154);

		case 50:
			return new BaseStats(20, 108, 86);

		case 51:
			return new BaseStats(70, 148, 140);

		case 52:
			return new BaseStats(80, 104, 94);

		case 53:
			return new BaseStats(130, 156, 146);

		case 54:
			return new BaseStats(100, 132, 112);

		case 55:
			return new BaseStats(160, 194, 176);

		case 56:
			return new BaseStats(80, 122, 96);

		case 57:
			return new BaseStats(130, 178, 150);

		case 58:
			return new BaseStats(110, 156, 110);

		case 59:
			return new BaseStats(180, 230, 180);

		case 60:
			return new BaseStats(80, 108, 98);

		case 61:
			return new BaseStats(130, 132, 132);

		case 62:
			return new BaseStats(180, 180, 202);

		case 63:
			return new BaseStats(50, 110, 76);

		case 64:
			return new BaseStats(80, 150, 112);

		case 65:
			return new BaseStats(110, 186, 152);

		case 66:
			return new BaseStats(140, 118, 96);

		case 67:
			return new BaseStats(160, 154, 144);

		case 68:
			return new BaseStats(180, 198, 180);

		case 69:
			return new BaseStats(100, 158, 78);

		case 70:
			return new BaseStats(130, 190, 110);

		case 71:
			return new BaseStats(160, 222, 152);

		case 72:
			return new BaseStats(80, 106, 136);

		case 73:
			return new BaseStats(160, 170, 196);

		case 74:
			return new BaseStats(80, 106, 118);

		case 75:
			return new BaseStats(110, 142, 156);

		case 76:
			return new BaseStats(160, 176, 198);

		case 77:
			return new BaseStats(100, 168, 138);

		case 78:
			return new BaseStats(130, 200, 170);

		case 79:
			return new BaseStats(180, 110, 110);

		case 80:
			return new BaseStats(190, 184, 198);

		case 81:
			return new BaseStats(50, 128, 138);

		case 82:
			return new BaseStats(100, 186, 180);

		case 83:
			return new BaseStats(104, 138, 132);

		case 84:
			return new BaseStats(70, 126, 96);

		case 85:
			return new BaseStats(120, 182, 150);

		case 86:
			return new BaseStats(130, 104, 138);

		case 87:
			return new BaseStats(180, 156, 192);

		case 88:
			return new BaseStats(160, 124, 110);

		case 89:
			return new BaseStats(210, 180, 188);

		case 90:
			return new BaseStats(60, 120, 112);

		case 91:
			return new BaseStats(100, 196, 196);

		case 92:
			return new BaseStats(60, 136, 82);

		case 93:
			return new BaseStats(90, 172, 118);

		case 94:
			return new BaseStats(120, 204, 156);

		case 95:
			return new BaseStats(70, 90, 186);

		case 96:
			return new BaseStats(120, 104, 140);

		case 97:
			return new BaseStats(170, 162, 196);

		case 98:
			return new BaseStats(60, 116, 110);

		case 99:
			return new BaseStats(110, 178, 168);

		case 100:
			return new BaseStats(80, 102, 124);

		case 101:
			return new BaseStats(120, 150, 174);

		case 102:
			return new BaseStats(120, 110, 132);

		case 103:
			return new BaseStats(190, 232, 164);

		case 104:
			return new BaseStats(100, 102, 150);

		case 105:
			return new BaseStats(120, 140, 202);

		case 106:
			return new BaseStats(100, 148, 172);

		case 107:
			return new BaseStats(100, 138, 204);

		case 108:
			return new BaseStats(180, 126, 160);

		case 109:
			return new BaseStats(80, 136, 142);

		case 110:
			return new BaseStats(130, 190, 198);

		case 111:
			return new BaseStats(160, 110, 116);

		case 112:
			return new BaseStats(210, 166, 160);

		case 113:
			return new BaseStats(500, 40, 60);

		case 114:
			return new BaseStats(130, 164, 152);

		case 115:
			return new BaseStats(210, 142, 178);

		case 116:
			return new BaseStats(60, 122, 100);

		case 117:
			return new BaseStats(110, 176, 150);

		case 118:
			return new BaseStats(90, 112, 126);

		case 119:
			return new BaseStats(160, 172, 160);

		case 120:
			return new BaseStats(60, 130, 128);

		case 121:
			return new BaseStats(120, 194, 192);

		case 122:
			return new BaseStats(80, 154, 196);

		case 123:
			return new BaseStats(140, 176, 180);

		case 124:
			return new BaseStats(130, 172, 134);

		case 125:
			return new BaseStats(130, 198, 160);

		case 126:
			return new BaseStats(130, 214, 158);

		case 127:
			return new BaseStats(130, 184, 186);

		case 128:
			return new BaseStats(150, 148, 184);

		case 129:
			return new BaseStats(40, 42, 84);

		case 130:
			return new BaseStats(190, 192, 196);

		case 131:
			return new BaseStats(260, 186, 190);

		case 132:
			return new BaseStats(96, 110, 110);

		case 133:
			return new BaseStats(110, 114, 128);

		case 134:
			return new BaseStats(260, 186, 168);

		case 135:
			return new BaseStats(130, 192, 174);

		case 136:
			return new BaseStats(130, 238, 178);

		case 137:
			return new BaseStats(130, 156, 158);

		case 138:
			return new BaseStats(70, 132, 160);

		case 139:
			return new BaseStats(140, 180, 202);

		case 140:
			return new BaseStats(60, 148, 142);

		case 141:
			return new BaseStats(120, 190, 190);

		case 142:
			return new BaseStats(160, 182, 162);

		case 143:
			return new BaseStats(320, 180, 180);

		case 144:
			return new BaseStats(180, 198, 242);

		case 145:
			return new BaseStats(180, 232, 194);

		case 146:
			return new BaseStats(180, 242, 194);

		case 147:
			return new BaseStats(82, 128, 110);

		case 148:
			return new BaseStats(122, 170, 152);

		case 149:
			return new BaseStats(182, 250, 212);

		case 150:
			return new BaseStats(212, 284, 202);

		case 151:
			return new BaseStats(200, 220, 220);
		default:
			return new BaseStats(0, 0, 0);
		}
	}
}
