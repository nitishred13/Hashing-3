class Solution {
    //We create a sub string of size 10 and add it to the hash set to track repeated sequences
    //Time Complexity:O(10*n)
    //Space Complexity: O(n)
    public List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();
        HashSet<String> allSeq = new HashSet<>();
        HashSet<String> result = new HashSet<>();

        for(int i=0;i<n-9;i++)
        {
            String substr = s.substring(i,i+10);
            if(allSeq.contains(substr))
            {
                result.add(substr);
            }
            else
            {
                allSeq.add(substr);
            }
        }
        return new ArrayList<>(result);
    }
}