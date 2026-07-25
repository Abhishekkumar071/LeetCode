class Solution {
public:
    int minSteps(int n) {
        int ans=0;
        for(int d=2; d*d<=n; d++){
            while(n%d==0){
                ans+=d;
                n/=d;
            }
        }
        if(n>1) ans+=n;
        return ans;
    }
};

// #include <bits/stdc++.h>
// using namespace std;

// int main(){
//     int n;
//     cin>>n;
    
//     cout<<ans<<endl;
// }