class Solution {
    public char repeatedCharacter(String s) {

        Set<Character> characters = new HashSet<>();

        for (char ch: s.toCharArray()) {

            if (characters.contains(ch)) {
                return ch;
            }

            characters.add(ch);

        }

        return 'a';
        
    }
}
