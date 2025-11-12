package me.algorithm.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of strings words and a width maxWidth, format the text such that each line has
 * exactly maxWidth characters and is fully (left and right) justified.
 * <p>
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each
 * line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
 * <p>
 * Extra spaces between words should be distributed as evenly as possible. If the number of spaces
 * on a line does not divide evenly between words, the empty slots on the left will be assigned more
 * spaces than the slots on the right.
 * <p>
 * For the last line of text, it should be left-justified, and no extra space is inserted between
 * words.
 * <p>
 * Note:
 * <p>
 * A word is defined as a character sequence consisting of non-space characters only. Each word's
 * length is guaranteed to be greater than 0 and not exceed maxWidth. The input array words contains
 * at least one word.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
 * Output: [ "This    is    an", "example  of text", "justification.  " ] Example 2:
 * <p>
 * Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16 Output: [ "What
 * must   be", "acknowledgment  ", "shall be        " ] Explanation: Note that the last line is
 * "shall be    " instead of "shall     be", because the last line must be left-justified instead of
 * fully-justified. Note that the second line is also left-justified because it contains only one
 * word. Example 3:
 * <p>
 * Input: words =
 * ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"],
 * maxWidth = 20 Output: [ "Science  is  what we", "understand      well", "enough to explain to",
 * "a  computer.  Art is", "everything  else  we", "do                  " ]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= words.length <= 300 1 <= words[i].length <= 20 words[i] consists of only English letters and
 * symbols. 1 <= maxWidth <= 100 words[i].length <= maxWidth
 */
public class TextJustification {

  public List<String> fullJustify(String[] words, int maxWidth) {
    List<String> result = new ArrayList<>();

    int l = words.length;
    int i = 0;
    while (i < l) {
      int width = 0;

      int j = i;
      while (j < l && width + words[j].length() <= maxWidth) {
        width += words[j].length() + 1;
        j++;
      } // now the element at j cannot be added to the same line, j==l is to check if this is the last row

      // justify [i,j-1] on the same line
      result.add(justifyLine(words, maxWidth, i, j));

      i = j;
    }

    return result;
  }

  // e is exclusive
  private String justifyLine(String[] words, int maxWidth, int s, int e) {
    StringBuilder sb = new StringBuilder();
    int l = words.length;

    int sumLength = 0;
    for (int i = s; i < e; i++) {
      sumLength += words[i].length();
    }
    int spaceNeeded = maxWidth - sumLength;

    // if there is only 1 word
    if (e - s == 1) {
      sb.append(words[s]);
      sb.append(" ".repeat(spaceNeeded));
      return sb.toString();
    }

    if (e == l) {
      for (int i = s; i < e; i++) {
        sb.append(words[i]);
        if (i != e - 1) {
          sb.append(" ");
        }
      }

      // all the right padding
      sb.append(" ".repeat(Math.max(0, maxWidth - sb.length())));
      return sb.toString();
    }

    int wordSpace = spaceNeeded / (e - s - 1);
    int extraSpace = spaceNeeded % (e - s - 1);

    for (int i = s; i < e; i++) {
      sb.append(words[i]);
      if (i != e - 1) {
        sb.append(" ".repeat(Math.max(0, wordSpace)));
        if (extraSpace > 0) {
          sb.append(" ");
          extraSpace--;
        }
      }
    }

    return sb.toString();
  }
}
