import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public int numUniqueEmails(String[] emails) {
        return Arrays.stream(emails).map(email -> processEmail(email)).collect(Collectors.toSet())
                .size();
    }

    public String processEmail(String email) {
        String[] splitted = email.split("@");
        String localName = splitted[0];
        String domain = splitted[1];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < localName.length(); i++) {
            char c = localName.charAt(i);
            if (c == '.')
                continue;
            if (c == '+') {
                break;
            }
            sb.append(c);
        }

        sb.append("@");
        sb.append(domain);
        return sb.toString();
    }
}
