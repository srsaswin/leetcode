class Solution:
    def compressedString(self, word: str) -> str: 
        ans = ''
        count = 1
        pre = word[0]
        for i in word[1:]:
            if i == pre:
                count+=1
                if count > 9:
                    ans+='9'+i
                    count-=9
            else:
                ans+=str(count)+pre
                pre = i
                count = 1
        ans+=str(count)+pre 
        return ans