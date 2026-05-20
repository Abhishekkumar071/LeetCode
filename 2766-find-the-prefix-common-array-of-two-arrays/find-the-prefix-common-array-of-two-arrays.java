class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
       int n = A.length;
       int[] ans = new int[n];
       int count=0;
       Set<Integer> set1 = new HashSet<>();
       Set<Integer> set2 = new HashSet<>();
       for(int i=0; i<n; i++){
           
           set1.add(A[i]);
           if(set2.contains(A[i])) count++;
           set2.add(B[i]);
           if(set1.contains(B[i])) count++; 
           ans[i]=count;         
       }
       return ans;
    }
}