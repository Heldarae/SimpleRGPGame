import java.util.ArrayList;
import java.util.List;

public class Party {
    private final int partyLimit = 8;
    private List<Combat> fighters = new ArrayList<>();
    private List<Caster> healers = new ArrayList<>();
    private List<Character> otherCharacters = new ArrayList<>();
    private List<Character> paladins = new ArrayList<>();
    private int mixedCount;

    public boolean isCharacterInParty(Character character) {
        if (character instanceof Paladin) {
            return paladins.contains(character);
        } else if (character instanceof Caster) {
            return healers.contains((Caster) character);
        } else {
            return fighters.contains((Warrior) character);
        }
    }

    private void turnToCharacter() {
        for (Combat combat : fighters) {
            otherCharacters.add((Character) combat);
        }

        for (Caster caster : healers) {
            otherCharacters.add((Character) caster);
        }
    }

    protected boolean isPartySizeLimitReached() {
        if (healers.size() + fighters.size() + mixedCount >= partyLimit) {
            return true;
        } else {
            return false;
        }
    }

    public void addCharacter(PlayableCharacter character)
            throws PartyLimitReachedException, AlreadyInPartyException {
        if (isPartySizeLimitReached()) {
            throw new PartyLimitReachedException("Party limit reached!");
        }

        if (healers.size() + fighters.size() + mixedCount != 0) {
            if (character.isInParty(this)) {
                throw new AlreadyInPartyException("This character is already in the party!");
            }
        }

        if (character instanceof Caster && character instanceof Combat) {
            paladins.add(character);
        } else if (character instanceof Caster) {
            healers.add((Caster) character);
        } else if (character instanceof Combat) {
            fighters.add((Combat) character);
        }
    }

    public void removeCharacter(PlayableCharacter character) throws CharacterIsNotInPartyException {
        if (character.isInParty(this)) {
            if (character instanceof Caster && character instanceof Combat) {
                paladins.remove(character);
            } else if (character instanceof Caster) {
                healers.remove((Caster) character);
            } else if (character instanceof Combat) {
                fighters.remove((Combat) character);
            }
        } else {
            throw new CharacterIsNotInPartyException("This character is not in the party!");
        }
    }

    public void partyLevelUp() {
        turnToCharacter();
        for (Character character : otherCharacters) {
            character.level++;
        }

        for (Character character : paladins) {
            character.level++;
        }
    }

}
