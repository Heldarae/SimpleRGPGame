public abstract class PlayableCharacter extends Character implements Damageable {
    private Party party;

    public PlayableCharacter(String name, Attributes attributes) {
        super(name, attributes);
    }

    public boolean isInParty(Party party) {
        this.party = party;
        if (this.party == null) {
            return false;
        } else {
            return party.isCharacterInParty(this);
        }
    }

    public void joinParty(Party party) throws PartyLimitReachedException, AlreadyInPartyException {
        this.party = party;
        if (party.isPartySizeLimitReached()) {
            throw new PartyLimitReachedException("Party limit reached!");
        }
        if (!isInParty(party)) {
            party.addCharacter(this);
        } else {
            throw new AlreadyInPartyException("This character is already in the party!");
        }
    }

    public void quitParty() throws CharacterIsNotInPartyException {
        if (isInParty(this.party)) {
            this.party.removeCharacter(this);
            this.party = null;
        }
    }

}