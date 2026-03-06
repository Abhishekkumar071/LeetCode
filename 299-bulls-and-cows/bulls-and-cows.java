class Solution {
    public String getHint(String secret, String guess) {
        
        int n = secret.length();
        int bulls = 0;
        int cows = 0;

        boolean[] s = new boolean[n];
        boolean[] g = new boolean[n];

        for(int i = 0; i < n; i++){
            if(secret.charAt(i) == guess.charAt(i)){
                bulls++;
                s[i] = true;
                g[i] = true;
            }
        }

        for(int i = 0; i < n; i++){
            if(g[i]) continue;

            for(int j = 0; j < n; j++){
                if(!s[j] && guess.charAt(i) == secret.charAt(j)){
                    cows++;
                    s[j] = true;
                    break;
                }
            }
        }

        return bulls + "A" + cows + "B";
    }
}