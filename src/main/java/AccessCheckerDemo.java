class LibraryMember {
    private String membershipPin;       // only same class
    String branchCode;                  // default (same package only)
    protected double finesOwed;         // same package + subclasses
    public String displayName;          // anywhere
}

class AccessChecker {

    static String classifyAccess(String fieldModifier, String accessorContext) {
        switch (fieldModifier) {
            case "private":
                return accessorContext.equals("SAME_CLASS") ? "ALLOWED" : "DENIED";
            case "default":
                return (accessorContext.equals("SAME_CLASS") || accessorContext.equals("SAME_PACKAGE"))
                        ? "ALLOWED" : "DENIED";
            case "protected":
                // same class, same package, or subclass → allowed
                // different package (non-subclass) → denied
                if (accessorContext.equals("DIFFERENT_PACKAGE")) return "DENIED";
                return "ALLOWED";
            case "public":
                return "ALLOWED";
            default:
                return "DENIED";
        }
    }

    static String summarizeByModifier(String[][] attempts) {
        int[] allowed = new int[4]; // private, default, protected, public
        int[] denied  = new int[4];
        String[] mods = {"private", "default", "protected", "public"};

        for (String[] attempt : attempts) {
            String mod = attempt[0];
            String ctx = attempt[1];
            String result = classifyAccess(mod, ctx);

            int idx = -1;
            for (int i = 0; i < 4; i++) {
                if (mods[i].equals(mod)) {
                    idx = i;
                    break;
                }
            }
            if (idx == -1) continue;

            if (result.equals("ALLOWED")) allowed[idx]++;
            else denied[idx]++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            if (i > 0) sb.append(" | ");
            sb.append(mods[i]).append(": ")
              .append(allowed[i]).append(" allowed / ")
              .append(denied[i]).append(" denied");
        }
        return sb.toString();
    }
}

public class AccessCheckerDemo {
    public static void main(String[] args) {
        System.out.println(AccessChecker.classifyAccess("private", "SAME_CLASS"));
        System.out.println(AccessChecker.classifyAccess("protected", "DIFFERENT_PACKAGE"));

        String[][] attempts = {
            {"private", "SAME_CLASS"},
            {"private", "SAME_PACKAGE"},
            {"default", "SAME_PACKAGE"},
            {"default", "DIFFERENT_PACKAGE"},
            {"protected", "SAME_PACKAGE"},
            {"protected", "SAME_CLASS"},
            {"public", "DIFFERENT_PACKAGE"}
        };
        System.out.println(AccessChecker.summarizeByModifier(attempts));
    }
}