 class Solution {

    public String encode(List<String> strs) {

        StringBuilder result = new StringBuilder();

        for (String str : strs) {
            result.append(str.length());
            result.append("#");
            result.append(str);
        }

        return result.toString();
    }

    public List<String> decode(String s) {

        List<String> result = new ArrayList<>();

        int i = 0;

        while (i < s.length()) {

            int j = i;

            // Find the '#'
            while (s.charAt(j) != '#') {
                j++;
            }

            // Get the length
            int length = Integer.parseInt(s.substring(i, j));

            // Move after '#'
            j++;

            // Get the actual string
            String str = s.substring(j, j + length);

            result.add(str);

            // Move to the next encoded string
            i = j + length;
        }

        return result;
    }
}
