
// Time Complexity : O(n*l)
// Space Complexity : O(n*l)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
Trie
 */


class Solution {
    class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        TrieNode() {
            children = new TrieNode[26];
        }
    }

    private void insert(TrieNode root, String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isEnd = true;
    }

    public String longestWord(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            insert(root, word);
        }
        Queue<TrieNode> q = new LinkedList<>();
        Queue<String> str = new LinkedList<>();

        q.add(root);
        str.add("");
        String currStr="";
        while (!q.isEmpty()) {
            TrieNode curr = q.poll();
            currStr = str.poll();
            for (int i = 25; i >= 0; i--) {
                if (curr.children[i] != null && curr.children[i].isEnd) {
                    q.offer(curr.children[i]);
                    String newStr = currStr + (char) (i + 'a');
                    str.offer(newStr);
                }
            }
        }
        return currStr;
    }
}







