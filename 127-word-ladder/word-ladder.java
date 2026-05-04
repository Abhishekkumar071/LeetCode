class Solution {
    public class Pair {
        String s;
        int l;
        Pair(String s, int l) {
            this.s = s;
            this.l = l;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList); // 1. Direct constructor use karlo
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(beginWord, 1)); // 2. Spelling: beingWord -> beginWord

        if (set.contains(beginWord)) set.remove(beginWord); // Extra safety

        while (!q.isEmpty()) {
            Pair p = q.poll(); // 3. Pehle poll karo phir use karo
            String w = p.s;
            int l = p.l;

            if (w.equals(endWord)) return l;

            // 4. Java mein String mutable nahi hai, isliye char array use karo
            char[] wordChars = w.toCharArray();
            for (int i = 0; i < wordChars.length; i++) {
                char originalChar = wordChars[i]; // Purana char save karo

                for (char ch = 'a'; ch <= 'z'; ch++) {
                    wordChars[i] = ch;
                    String newWord = new String(wordChars);

                    if (set.contains(newWord)) {
                        set.remove(newWord);
                        q.offer(new Pair(newWord, l + 1));
                    }
                }
                wordChars[i] = originalChar; // Reset karo next position ke liye
            }
        }
        return 0;
    }
}
