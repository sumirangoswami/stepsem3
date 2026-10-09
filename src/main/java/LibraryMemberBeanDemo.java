class LibraryMember {
    private String membershipId;
    private String name;
    private boolean premiumMember;
    private String securityAnswerHash;   // one-way transformed, no getter

    private boolean membershipIdSet = false;

    // required public no-arg constructor
    public LibraryMember() {}

    public String getMembershipId() {
        return membershipId;
    }

    // write-once
    public void setMembershipId(String id) {
        if (!membershipIdSet) {
            this.membershipId = id;
            membershipIdSet = true;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPremiumMember() {
        return premiumMember;
    }

    public void setPremiumMember(boolean premium) {
        this.premiumMember = premium;
    }

    // write-only — no getter exists
    public void setSecurityAnswer(String answer) {
        // simple deterministic one-way transform (not real crypto)
        this.securityAnswerHash = Integer.toHexString(answer.hashCode());
    }
}

public class LibraryMemberBeanDemo {
    public static void main(String[] args) {
        LibraryMember m = new LibraryMember();
        m.setMembershipId("LIB-8841");
        m.setName("Priya Nair");
        m.setPremiumMember(true);

        System.out.println(m.getMembershipId());      // LIB-8841

        m.setMembershipId("FAKE-0000");               // ignored
        System.out.println(m.getMembershipId());      // still LIB-8841

        System.out.println(m.isPremiumMember());      // true

        m.setSecurityAnswer("BlueMountain");
        // no way to retrieve the answer
    }
}