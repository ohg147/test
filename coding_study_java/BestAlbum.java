package practice;

import java.util.HashMap;

public class BestAlbum {
	public int[] solution(String[] genres, int[] plays) {
		int[] answer = {};

		HashMap<Integer, String> gmap = new HashMap<>();
		HashMap<Integer, Integer> pmap = new HashMap<>();
		HashMap<String, Integer> gpmap = new HashMap<>();
		
		for(int i=0;i<genres.length;i++) {
			gmap.put(i, genres[i]);
			pmap.put(i, plays[i]);
			//������ȣ=key �� �帣.Ƚ�� �Է�
		}
		for(int i=0;i<genres.length;i++) {
			if(gmap.get(i).equals(genres[i])) {//������ȣvalues=�帣[i]
				gpmap.put(gmap.get(i), pmap.getOrDefault(i, plays[i])+plays[i]);			
			}else {
				
			}
		}
		for (String genre : genres) {
			if ("classic".equals(genre)) {
				for (int i = 0; i < plays.length; i++) {
					gmap.put(genre, gmap.get(genre) + plays[i]);
				}
			} else {
				for (int i = 0; i < plays.length; i++) {
					pmap.put(genre, pmap.get(genre) + plays[i]);
				}
			}
		}
		if(gmap.get("classic")>pmap.get("pop")) {
			for (int i = 0; i < genres.length; i++) {
				gmap.put(i,gma);
			}
		}
			
			
			
			
			if (map.get)
				for (Integer playNB : plays) {
					map.put(genre, map.get(genre) + playNB);
				}
		}

		return answer;
	}
}
