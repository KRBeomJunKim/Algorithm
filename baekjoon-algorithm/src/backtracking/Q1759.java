package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1759 {
	
	static String[] alphabetMap;
	static int L;
	static int C;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		alphabetMap = new String[C];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<C;i++) {
			alphabetMap[i] = st.nextToken();
		}
		
		Arrays.sort(alphabetMap);
		
		dfs(0, 0, 0, "");
	}

	private static void dfs(int depth, int consonant, int vowel, String currentString) {
		if((consonant+vowel) == L) {
			if(consonant >= 2 && vowel>=1) {
				System.out.println(currentString);
			}
			return;
		}
		
		if(depth == C)
			return;
		
		String currentAlphabet = alphabetMap[depth];
		String nextString = currentString + currentAlphabet;
		if(currentAlphabet.equals("a") || currentAlphabet.equals("e") ||
				currentAlphabet.equals("i") || currentAlphabet.equals("o") ||
				currentAlphabet.equals("u")) {
			dfs(depth+1, consonant, vowel+1, nextString);
			dfs(depth+1, consonant, vowel, currentString);
		} else {
			dfs(depth+1, consonant+1, vowel, nextString);
			dfs(depth+1, consonant, vowel, currentString);
		}
	}

}
