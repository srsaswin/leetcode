class Solution {
    public static int fun(int n,int inx,int previous){
        if(n-1 == 0){
            return previous;
        }
        int countNode = ((int)Math.pow(2,n-1))/2;
        if(countNode >= inx) return fun(n-1,inx,previous);
        return fun(n-1,inx - countNode,previous == 0?1:0);
    }
    public int kthGrammar(int n, int k) {
        return fun(n,k,0);
    }
}