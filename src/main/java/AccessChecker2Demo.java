class AccessChecker2 {

    static String classifyAccess(String fieldModifier, String accessorContext) {
        switch (fieldModifier) {
            case "private":
            case "default":
                return "DENIED";   // always denied for the new subclass contexts too

            case "protected":
                if (accessorContext.equals("SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE")) {
                    return "ALLOWED";
                }
                if (accessorContext.equals("SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE")) {
                    return "DENIED";
                }
                // fall-through for older contexts
                if (accessorContext.equals("DIFFERENT_PACKAGE")) return "DENIED";
                return "ALLOWED";

            case "public":
                return "ALLOWED";

            default:
                return "DENIED";
        }
    }

    static String firstDeniedAttempt(String[][] attempts) {
        for (int i = 0; i < attempts.length; i++) {
            String mod = attempts[i][0];
            String ctx = attempts[i][1];
            if (classifyAccess(mod, ctx).equals("DENIED")) {
                return mod + " via " + ctx + " (attempt #" + (i + 1) + ")";
            }
        }
        return "None Denied";
    }
}

public class AccessChecker2Demo {
    public static void main(String[] args) {
        String[][] a1 = {
            {"public", "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"},
            {"protected", "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"},
            {"protected", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"}
        };
        System.out.println(AccessChecker2.firstDeniedAttempt(a1));

        String[][] a2 = {
            {"public", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"},
            {"protected", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"}
        };
        System.out.println(AccessChecker2.firstDeniedAttempt(a2));
    }
}